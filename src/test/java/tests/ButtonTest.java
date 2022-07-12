package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ButtonPage;

public class ButtonTest extends BaseTest {

    ButtonPage buttonPage;

    @BeforeMethod
    public void goToTargetPage() {
        setUp();
        buttonPage = new ButtonPage(driver);
        buttonPage.goToButtonPage();
    }

    @AfterMethod
    public void closingActivity() {
        tearDown();
    }

    @Test
    public void homeButtonTest() {

        String buttonPageTitleFirst = buttonPage.getPageTitle();
        System.out.println(buttonPageTitleFirst);
        buttonPage.clickHomeButton();
        System.out.println(buttonPage.getPageTitle());
        buttonPage.navigateBack();
        String buttonPageTitleSecond = buttonPage.getPageTitle();
        System.out.println(buttonPageTitleSecond);

        //validation
        if (buttonPageTitleFirst.equals(buttonPageTitleSecond)) {
            System.out.println("testcase passed!!");
        } else {
            System.out.println("failed!!");
        }

    }

    @Test
    public void positionOfTheButtonTest() {

        System.out.println(buttonPage.getLocationOfLocationButton());

    }

    @Test
    public void buttonColorTest() {

        System.out.println(buttonPage.getColorOfColorButton());

    }

    @Test
    public void dimensionsTest() {

        System.out.println(buttonPage.getDimensionsOfDimensionButton());

    }
}