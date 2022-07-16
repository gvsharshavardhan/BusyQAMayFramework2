package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ToolTipPage;
import pages.WndowPage;

public class ToolTipTest extends BaseTest{

    ToolTipPage toolTipPage;

    @BeforeMethod
    public void goToTargetPage() {
        setUp();
        toolTipPage = new ToolTipPage(driver);
        toolTipPage.goToToolTipPage();
    }

    //    @AfterMethod
    public void closingActivity() {
        tearDown();
    }

    @Test
    public void toolTipTest(){
        toolTipPage.hoverOverInputBox();
        System.out.println(toolTipPage.getTextFromToolTopLocator());
    }
}
