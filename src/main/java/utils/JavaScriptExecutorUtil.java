package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorUtil {


    public static void addBorderToAnElement(WebDriver driver, WebElement element, String thickness) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='" + thickness + " solid red'", element);
    }
}