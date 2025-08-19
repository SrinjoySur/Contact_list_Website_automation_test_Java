package com.contact_list.utils;

import com.contact_list.constants.ConstantsProvider;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {
    private static volatile TakesScreenshot screenshot;
    private static int count = 0;

    public static void saveScreenshot(WebDriver driver) throws IOException {
        count++;
        screenshot = (TakesScreenshot) driver;
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(ConstantsProvider.screenshotsDirPath + "/failure" + count + "_screenshot.png");
        FileHandler.copy(srcFile, destFile);
    }
}
