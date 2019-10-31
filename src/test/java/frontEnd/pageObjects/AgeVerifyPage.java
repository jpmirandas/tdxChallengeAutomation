package frontEnd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.PropertyOptions;
import util.PropertyReader;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class AgeVerifyPage extends BasePage {

    /**
     * Class constructor.
     * @param webDriver An stance of WebDriver.
     */
    public AgeVerifyPage(WebDriver webDriver) {
        super(webDriver);
    }

    // LOCATORS

    // fields
    private By ageField = By.id("ageVerification");

    // buttons
    private By submitButton = By.id("submitFormButton");

    // checkboxes
    private By agreeCheckbox = By.id("agreeCheckbox");


    // notifications
    private By notification = By.cssSelector(".alert");

    // expected messages
    static final String EXPECTED_RULES_ERROR_MESSAGE = "To access the page, you should accept the rules!";
    static final String EXPECTED_UNDER_18_ERROR_MESSAGE = "Sorry, too young!";
    static final String EXPECTED_SUCCESSFUL_MESSAGE = "Enjoy the site!";


    // ACTIONS
    /**
     * Access the main page.
     */
    public void accessPage() {
        String url = "";

        try {
            url = "file:///" + new File(PropertyReader.getProperty(PropertyOptions.BASE_URL)).getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.getWebDriver().get(url);
        this.waitForPageLoad();
    }

    /**
     * Fill the age field.
     * @param age The age to be typed on the age field.
     */
    public void fillAgeField(String age) {
        this.type(ageField, age);
    }

    /**
     * Click on the submit button.
     */
    public void submitForm(){
        this.click(submitButton);
    }


    /**
     * Click on the checkbox to accept the page rules.
     */
    public void acceptRules(){
        this.click(agreeCheckbox);
    }

    // ASSERTIONS

    /**
     * Verify if the notification is displayed due to don't accept the page rules.
     */
    public void isMissingAcceptedRulesErrorDisplayed(){
        this.waitForElementToBeDisplayed(notification);
        assertEquals("The missing accepted rules notification is not displayed!", EXPECTED_RULES_ERROR_MESSAGE, this.getText(notification));
    }

    /**
     * Verify if the notification is displayed due to be under 18.
     */
    public void isUnder18ErrorDisplayed(){
        this.waitForElementToBeDisplayed(notification);
        assertEquals("The under 18 notification is not displayed!", EXPECTED_UNDER_18_ERROR_MESSAGE, this.getText(notification));
    }

    /**
     * Verify if the notification is displayed after submitting the form correcty.
     */
    public void isSuccessfulNotificationDisplayed(){
        this.waitForElementToBeDisplayed(notification);
        assertEquals("The successful notification is not displayed!", EXPECTED_SUCCESSFUL_MESSAGE, this.getText(notification));
    }
}
