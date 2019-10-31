package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FactoryWebDriver {

    static WebDriver webdriver;

    public static WebDriver getWebDriver() {

        String chromeDriverPath = PropertyReader.getProperty(PropertyOptions.CHROME_DRIVER_PATCH);
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        Boolean headlessMode = Boolean.valueOf(PropertyReader.getProperty(PropertyOptions.HEADLESS_MODE));

        if (headlessMode) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1200x600");
            webdriver = new ChromeDriver(options);
        } else {
            webdriver = new ChromeDriver();
        }

        return webdriver;
    }
}