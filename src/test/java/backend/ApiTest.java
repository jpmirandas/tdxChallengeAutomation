package backend;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import util.PropertyOptions;
import util.PropertyReader;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApiTest {

    protected RequestSpecification httpRequest;
    protected JsonPath jsonPathEvaluator;
    protected Response response;

    @Before
    public void setup(){
        RestAssured.baseURI = PropertyReader.getProperty(PropertyOptions.SERVER_URL);
        this.httpRequest = RestAssured.given().contentType(ContentType.JSON);
    }

    @Test
    public void verifyStatusCodeAllowedAccess(){
        this.response = this.httpRequest.get("/messages/?under18=false&acceptRules=true");
        assertEquals("Wrong status code", HttpStatus.SC_OK, response.getStatusCode());
    }

    @Test
    public void verifyMessageAllowedAccess(){
        this.response = this.httpRequest.get("/messages/?under18=false&acceptRules=true");
        this.jsonPathEvaluator = this.response.jsonPath();
        ArrayList messages = this.jsonPathEvaluator.get("message");

        assertTrue("Wrong message", messages.contains("Enjoy the site!"));
    }

    @Test
    public void verifyStatusCodeDeniedAccess(){
        this.response = this.httpRequest.get("/messages/?under18=true");
        assertEquals("Wrong status code", HttpStatus.SC_OK, response.getStatusCode());
    }

    @Test
    public void verifyMessageDeniedAccess(){
        this.response = this.httpRequest.get("/messages/?under18=true");
        jsonPathEvaluator = this.response.jsonPath();
        ArrayList messages = this.jsonPathEvaluator.get("message");

        assertTrue("Wrong message", messages.contains("Sorry, too young!"));
    }


}
