package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WndowPage extends BasePage {

    public WndowPage(WebDriver driver) {
        super(driver);
    }

    By homePageButtonLocator = By.cssSelector("#home");
    By homePageHeaderLocator = By.cssSelector("[itemprop='name']");
    By closeMeButtonLocator = By.xpath("//label[contains(.,'except')]/following-sibling::button");


    public void goToWindowPage() {
        driver.get("http://leafground.com/pages/Window.html");
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public void clickOnHomePageButton() {
        driver.findElement(homePageButtonLocator).click();
    }

    public String getHomePageHeader() {
        return driver.findElement(homePageHeaderLocator).getText();
    }

    public void switchToWindow(String windowId){
        driver.switchTo().window(windowId);
    }

    public void clickOnDoNotCloseMeButton(){
        driver.findElement(closeMeButtonLocator).click();
    }

    public void closeTheWindow(){
        driver.close();
    }
}