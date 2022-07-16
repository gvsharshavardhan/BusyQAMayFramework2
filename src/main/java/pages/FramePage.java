package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }

    //locators
    By frameButton = By.cssSelector("#Click");
    By defaultFrameLocator = By.xpath("//div[@id='wrapframe'][1]/iframe");
    By pageFrameButtonLocator = By.cssSelector("#Click1");
    By pageFrameLocator = By.xpath("//iframe[@src='page.html']");
    By nestFrameLocator = By.xpath("//iframe[@src='nested.html']");

    public void goToFramePage(){
        driver.get("http://leafground.com/pages/frame.html");
    }

    public void clickFrameButton() {
        driver.findElement(frameButton).click();
    }

    public String getTextFromFrameButton() {
        return driver.findElement(frameButton).getText();
    }

    public void switchToAFrame(By frameLocator){
        driver.switchTo().frame(driver.findElement(frameLocator));
    }

    public void switchToDefaultFrame(){
        switchToAFrame(defaultFrameLocator);
    }

    public void clickOnPageFrameButton(){
        driver.findElement(pageFrameButtonLocator).click();
    }

    public String getTextFromPageFrameButton(){
        return driver.findElement(pageFrameButtonLocator).getText();
    }

    public void switchToPageFrame(){
        switchToAFrame(pageFrameLocator);
    }

    public void switchToNestedFrame(){
        switchToAFrame(nestFrameLocator);
    }
}
