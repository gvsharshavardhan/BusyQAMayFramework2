package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WaitToDisappearPage;
import utils.ScreenShotUtil;

public class WaitToDisappearTest extends BaseTest {

    WaitToDisappearPage waitToDisappearPage;

    @BeforeMethod
    public void goToTargetPage() {
        setUp();
        waitToDisappearPage = new WaitToDisappearPage(driver);
        waitToDisappearPage.goToPage();
    }

    //    @AfterMethod
    public void closingActivity() {
        tearDown();
    }

    @Test
    public void disappearTest() {
        ScreenShotUtil.takeScreenShot(driver, "beforeDisappearance");
        waitToDisappearPage.waitUntilButtonIsDisappeared();
        ScreenShotUtil.takeScreenShot(driver, "afterDisappearance");
        Assert.assertTrue(waitToDisappearPage.isElementHidden(), "Element took long time to disappear!!");
    }
}
