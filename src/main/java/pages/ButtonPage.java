package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class ButtonPage extends BasePage {

    //locators
    By homeButtonLocator = By.id("home");
    By locationButtonLocator = By.cssSelector("#position");
    By colorButtonLocator = By.cssSelector("#color");
    By dimensionsButtonLocator = By.cssSelector("#size");

    public ButtonPage(WebDriver driver) {
        super(driver);
    }

    public void goToButtonPage() {
        driver.get("http://leafground.com/pages/Button.html");
    }

    //methods on these locators
    public void clickHomeButton() {
        driver.findElement(homeButtonLocator).click();
    }

    public String getLocationOfLocationButton() {
        Point location = driver.findElement(locationButtonLocator).getLocation();
        return "X: " + location.getX() + "\tY: " + location.getY();
    }

    public String getColorOfColorButton() {
        return driver.findElement(colorButtonLocator).getCssValue("background-color");
    }

    public String getDimensionsOfDimensionButton() {
        Dimension dimension = driver.findElement(dimensionsButtonLocator).getSize();
        return "Height : " + dimension.getHeight() + "\tWidth : " + dimension.getWidth();
    }

}