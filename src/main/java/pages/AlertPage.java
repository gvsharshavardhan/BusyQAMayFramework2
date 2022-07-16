package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    //locators
    String alertBoxButtonXpath = "//label[contains(text(),'$$')]/following-sibling::button";
    By confirmBoxResultLocator = By.cssSelector("#result");
    By promptBoxResultLocator = By.cssSelector("#result1");

    //methods
    public void goToAlertPage() {
        driver.get("http://leafground.com/pages/Alert.html");
    }

    public void clickOnAlertBoxButton() {
        driver.findElement(By.xpath(alertBoxButtonXpath.replace("$$", "alert box"))).click();
    }

    public void clickOnConfirmBoxButton() {
        driver.findElement(By.xpath(alertBoxButtonXpath.replace("$$", "confirm box"))).click();
    }

    public void clickOnPromptBoxButton() {
        driver.findElement(By.xpath(alertBoxButtonXpath.replace("$$", "prompt box"))).click();
    }

    public void clickOnLineBreakBoxButton() {
        driver.findElement(By.xpath(alertBoxButtonXpath.replace("$$", "line-breaks"))).click();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    public void sendTextIntoAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public String getTextFromConfirmBoxResult() {
        return driver.findElement(confirmBoxResultLocator).getText();
    }

    public String getTextFromPromptBoxResult() {
        return driver.findElement(promptBoxResultLocator).getText();
    }
}
