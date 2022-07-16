package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FramePage;

public class FrameTest extends BaseTest {

    FramePage framePage;

    @BeforeMethod
    public void goToTargetPage() {
        setUp();
        framePage = new FramePage(driver);
        framePage.goToFramePage();
    }

    @AfterMethod
    public void closingActivity() {
        tearDown();
    }


    @Test
    public void frameButtonTest() {
        framePage.switchToDefaultFrame();
        framePage.clickFrameButton();
        String expectedText = "Hurray! You Clicked Me.";
        String actualText = framePage.getTextFromFrameButton();
        Assert.assertEquals(actualText, expectedText);

    }

    @Test
    public void nestedFrameTest(){
        framePage.switchToPageFrame();
        framePage.switchToNestedFrame();
        framePage.clickOnPageFrameButton();
        String actualText = framePage.getTextFromPageFrameButton();
        String expectedText = "Hurray! You Clicked Me.";
        Assert.assertEquals(actualText, expectedText);
    }

}
