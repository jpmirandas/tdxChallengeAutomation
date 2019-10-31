package frontEnd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PropertyOptions;
import util.PropertyReader;

public class BasePage {

    private WebDriver webdriver;
    protected static int TIMEOUT_IN_SECONDS = Integer.parseInt(PropertyReader.getProperty(PropertyOptions.TIMEOUT_IN_SECONDS));

    /**
     * Class constructor.
     * @param webDriver An stance of WebDriver.
     */
    public BasePage(WebDriver webDriver) {
        this.webdriver = webDriver;
    }

    /**
     * Wait for page all page be loaded completely.
     */
    public void waitForPageLoad() {
        getWebDriverWait().until((ExpectedCondition<Boolean>) webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    /**
     * Return an instance of WebDriver.
     * @return WebDriver instance.
     */
    protected WebDriver getWebDriver() {
        return this.webdriver;
    }

    /**
     * Wait for element be displayed on webpage.
     * @param locator The locator of desired element.
     */
    protected void waitForElementToBeDisplayed(By locator) {
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Return a WebDriverWait instance.
     * @return WebDriverWait instance.
     */
    protected WebDriverWait getWebDriverWait() {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), TIMEOUT_IN_SECONDS);
        return wait;
    }

    /**
     * Perform a click on element
     * @param locator The locator of desired element.
     */
    protected void click(By locator) {
        getWebDriver().findElement(locator).click();
    }

    /**
     * Typed a text into field.
     * @param locator The locator of desired element.
     * @param text The text to be written on field.
     */
    protected void type(By locator, String text) {
        WebElement field = getWebDriver().findElement(locator);
        field.clear();
        field.sendKeys(text);
    }

    /**
     * Return the text placed into element.
     * @param locator The locator of desired element.
     * @return Return the string contained into element.
     */
    protected String getText(By locator) {
        return getWebDriver().findElement(locator).getText();
    }

    /**
     * Close the browser windows, if it exists.
     */
    public void closeWindow() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }
}
