package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtil {

    public static void takeScreenShot(WebDriver driver, String screenShotName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\Harsha\\myOwnWorkSpace\\BusyQAMayFramework2\\screenshots\\" + screenShotName + ".png"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}