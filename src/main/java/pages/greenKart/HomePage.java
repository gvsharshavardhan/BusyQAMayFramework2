package pages.greenKart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //locators
    public String addToKartXpath = "//h4[contains(text(),'$$')]/following-sibling::div[@class='product-action']//button";
    public By KartIconXpath = By.xpath("//a[@class='cart-icon']");
    public By proceedToCheckoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");

    //methods
    public void goToGreenKartPage(){
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    public void addVegetableToKart(String veg) {
        driver.findElement(By.xpath(addToKartXpath.replace("$$", veg))).click();
    }

    public void clickOnKartIcon(){
        driver.findElement(KartIconXpath).click();
    }

    public CheckoutPage clickOnProceedToCheckout(){
        driver.findElement(proceedToCheckoutButton).click();
        return new CheckoutPage(driver);
    }
}
