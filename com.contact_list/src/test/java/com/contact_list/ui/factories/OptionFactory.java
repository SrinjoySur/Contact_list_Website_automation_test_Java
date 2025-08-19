package com.contact_list.ui.factories;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public class OptionFactory {

    public static Object getOptions(String browser) {
        switch (browser) {
            case "CHROME":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                chromeOptions.addArguments("--headless");
                return chromeOptions;
            case "FIREFOX":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("dom.webnotifications.enabled", false);
                return firefoxOptions;
            case "EDGE":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                //edgeOptions.addArguments("--disable-notifications");
                edgeOptions.addArguments("--headless");
                return edgeOptions;
            case "SAFARI":
                SafariOptions safariOptions = new SafariOptions();
                return safariOptions;
            default:
                throw new IllegalArgumentException("Invalid browser type: " + browser);
        }
    }
}