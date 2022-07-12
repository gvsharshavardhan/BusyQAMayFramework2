package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RadioButtonPage;

public class RadioButtonTest extends BaseTest {

    RadioButtonPage radioButtonPage;

    @BeforeMethod
    public void goToTargetPage() {
        setUp();
        radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.goToRadioButtonPage();
    }

    @AfterMethod
    public void closingActivity() {
        tearDown();
    }

    @Test
    public void ageTest() {
        radioButtonPage.selectYourAgeGroup(75);
        int actualAgeValue = radioButtonPage.getTheSelectedAgeValue();
        Assert.assertEquals(actualAgeValue, 2);
    }
}