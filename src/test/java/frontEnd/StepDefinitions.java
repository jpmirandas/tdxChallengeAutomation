package frontEnd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import frontEnd.pageObjects.AgeVerifyPage;
import util.FactoryWebDriver;

public class StepDefinitions {

    AgeVerifyPage ageVerifyPage;

    @Given("I access the Polishvodka website")
    public void accessPage() {
        this.ageVerifyPage = new AgeVerifyPage(FactoryWebDriver.getWebDriver());
        this.ageVerifyPage.accessPage();
    }

    @When("I type the age {string}")
    public void fillAgeField(String age) {
        this.ageVerifyPage.fillAgeField(age);
    }

    @When("I don't accept the rules")
    public void doNotAcceptRules() {
        // do nothing
    }

    @When("I accept the rules")
    public void acceptRules(){
        this.ageVerifyPage.acceptRules();
    }

    @When("I submit the form")
    public void submitForm() {
        this.ageVerifyPage.submitForm();
    }

    @Then("I should see an error notification due to don't accept the page rules")
    public void isAccessRulesNotificationDisplayed() {
        this.ageVerifyPage.isMissingAcceptedRulesErrorDisplayed();
    }

    @Then("I should see an error notification due to be under 18")
    public void isUnder18NotificationDisplayed(){
        this.ageVerifyPage.isUnder18ErrorDisplayed();
    }

    @Then("I should see a successful notification")
    public void isSuccessfulNotificationDisplayed(){
        this.ageVerifyPage.isSuccessfulNotificationDisplayed();
    }

    @After()
    public void closeBrowser() {
        this.ageVerifyPage.closeWindow();
    }
}