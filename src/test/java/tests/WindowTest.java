package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WndowPage;

import java.util.Set;

public class WindowTest extends BaseTest {

    WndowPage wndowPage;

    @BeforeMethod
    public void goToTargetPage() {
        setUp();
        wndowPage = new WndowPage(driver);
        wndowPage.goToWindowPage();
    }

//    @AfterMethod
    public void closingActivity() {
        tearDown();
    }

    @Test
    public void homePageWindowTest(){
        String parentWindowId = wndowPage.getWindowHandle();
        wndowPage.clickOnHomePageButton();
        Set<String> windowHandles = wndowPage.getWindowHandles();
        for(String handle:windowHandles){
            if(!handle.equals(parentWindowId)){
                wndowPage.switchToWindow(handle);
            }
        }
        System.out.println(wndowPage.getHomePageHeader());
    }


    @Test
    public void doNotCloseParentWindowTest(){
        String parentWindowId = wndowPage.getWindowHandle();
        wndowPage.clickOnDoNotCloseMeButton();
        Set<String> windowHandles = wndowPage.getWindowHandles();
        for(String handle:windowHandles){
            if(!handle.equals(parentWindowId)){
                wndowPage.switchToWindow(handle);
                wndowPage.closeTheWindow();
            }
        }
    }
}
