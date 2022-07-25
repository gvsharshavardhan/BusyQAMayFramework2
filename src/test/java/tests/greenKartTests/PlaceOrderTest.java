package tests.greenKartTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.greenKart.CheckoutPage;
import pages.greenKart.HomePage;
import tests.BaseTest;

public class PlaceOrderTest extends BaseTest {

    HomePage homePage;

    @BeforeMethod
    public void goToTargetPage() {
        setUp();
        homePage = new HomePage(driver);
        homePage.goToGreenKartPage();
    }

    //    @AfterMethod
    public void closingActivity() {
        tearDown();
    }


    @Test
    public void placeOrderTest() {
        homePage.addVegetableToKart("Beetroot");
        homePage.clickOnKartIcon();
        CheckoutPage checkoutPage = homePage.clickOnProceedToCheckout();
        String promoCode = checkoutPage.getPromoCode();
        checkoutPage.enterPromoCode(promoCode);
        checkoutPage.applyPromoCode();
        String actualDiscount = checkoutPage.getDiscountPercent();
        String expectedDiscount = "10%";
        Assert.assertEquals(actualDiscount, expectedDiscount, "Error with  promocode!!");
        checkoutPage.placeTheOrder();
    }
}
