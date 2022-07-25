package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTipPage extends BasePage {

    public ToolTipPage(WebDriver driver) {
        super(driver);
    }

    By toolTipLocator = By.cssSelector("[role='tooltip']");
    By ageInputFieldLocator = By.id("age");

    public void goToToolTipPage(){
        driver.get("http://leafground.com/pages/tooltip.html");
    }

    public String getTextFromToolTopLocator() {
        return driver.findElement(toolTipLocator).getText();
    }

    public void hoverOverInputBox() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(ageInputFieldLocator)).perform();
    }
}