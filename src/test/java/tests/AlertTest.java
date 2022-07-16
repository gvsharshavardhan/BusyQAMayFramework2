package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertPage;

public class AlertTest extends BaseTest {

    AlertPage alertPage;

    @BeforeMethod
    public void goToTargetPage() {
        setUp();
        alertPage = new AlertPage(driver);
        alertPage.goToAlertPage();
    }

    //    @AfterMethod
    public void closingActivity() {
        tearDown();
    }


    @Test
    public void getTextFromAlertBox() {
        alertPage.clickOnAlertBoxButton();
        System.out.println(alertPage.getTextFromAlert());
    }

    @Test
    public void confirmBoxTest(){
        alertPage.clickOnConfirmBoxButton();
        alertPage.dismissAlert();

        //Assert
        String expectedResult = "You pressed Cancel!";
        String actualResult = alertPage.getTextFromConfirmBoxResult();

        Assert.assertEquals(actualResult,expectedResult,"Result of confirm box is not as expected!!");
    }
}
