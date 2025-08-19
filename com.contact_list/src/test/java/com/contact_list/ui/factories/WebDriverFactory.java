package com.contact_list.ui.factories;

import com.contact_list.exceptions.DriverNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class WebDriverFactory {
    private static WebDriverFactory instance;
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver getThreadLocalDriver() {
        return threadLocalDriver.get();
    }

    public static void setThreadLocalDriver(String browser) {
        threadLocalDriver.set(getInstance().getDriver(browser));
    }

    public static void quitDriverAndRemove() {
        getThreadLocalDriver().quit();
        threadLocalDriver.remove();
    }

    private WebDriverFactory() {}

    private synchronized static WebDriverFactory getInstance() {
        if (instance == null){
            return instance = new WebDriverFactory();
        }
        return instance;
    }

    private WebDriver getDriver(String browser){
        return switch (browser){
            case "CHROME" -> new ChromeDriver((ChromeOptions) OptionFactory.getOptions(browser));
            case "EDGE" -> new EdgeDriver((EdgeOptions) OptionFactory.getOptions(browser));
            case "FIREFOX" -> new FirefoxDriver((FirefoxOptions) OptionFactory.getOptions(browser));
            case "SAFARI" -> new SafariDriver((SafariOptions) OptionFactory.getOptions(browser));
            default -> throw new DriverNotFoundException("No such Browser is not available");
        };
    }
}
