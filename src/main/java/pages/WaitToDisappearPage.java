package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.JavaScriptExecutorUtil;

import java.time.Duration;

public class WaitToDisappearPage extends BasePage {

    public WaitToDisappearPage(WebDriver driver) {
        super(driver);
    }

    public void goToPage() {
        driver.get("http://leafground.com/pages/disapper.html");
    }

    public By disappearingButtonLocator = By.cssSelector("#btn");

    public void waitUntilButtonIsDisappeared() {

        JavaScriptExecutorUtil.addBorderToAnElement(driver, driver.findElement(disappearingButtonLocator), "8px");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(disappearingButtonLocator));
    }

    public boolean isElementHidden() {
        String hiddenValue = driver.findElement(disappearingButtonLocator).getAttribute("hidden");
        return Boolean.valueOf(hiddenValue);
    }

}