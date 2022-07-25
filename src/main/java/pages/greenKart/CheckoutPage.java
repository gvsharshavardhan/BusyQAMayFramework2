package pages.greenKart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public By promoCodeFieldLocator = By.xpath("//input[@class='promoCode']");
    public By promoCodeApplyButton = By.xpath("//button[@class='promoBtn']");
    public By placeOrderButton = By.xpath("//button[.='Place Order']");
    public By discountPercent = By.xpath("//span[@class='discountPerc']");
    public By promoInfo = By.xpath("//span[@class='promoInfo']");


    public void enterPromoCode(String promoCode) {
        driver.findElement(promoCodeFieldLocator).sendKeys(promoCode);
    }

    public void applyPromoCode() {
        driver.findElement(promoCodeApplyButton).click();

        //explicit wait
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(promoInfo));
    }
    //https://rahulshettyacademy.com/seleniumPractise/#/cart

    public String getPromoCode() {
        return driver.getCurrentUrl().split(".com")[0].split("//")[1].trim();
    }

    public void placeTheOrder() {
        driver.findElement(placeOrderButton).click();
    }

    public String getDiscountPercent() {
        return driver.findElement(discountPercent).getText().trim();
    }
}
