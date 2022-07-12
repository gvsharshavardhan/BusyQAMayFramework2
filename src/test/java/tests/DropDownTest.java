package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropDownPage;

import java.util.ArrayList;
import java.util.List;

public class DropDownTest extends BaseTest {

    DropDownPage dropDownPage;

    @BeforeMethod
    public void goToTargetPage() {
        setUp();
        dropDownPage = new DropDownPage(driver);
        dropDownPage.goToDropDownPage();
    }

    @AfterMethod
    public void closingActivity() {
        tearDown();
    }

    @Test
    public void indexDropDownTest() {
        dropDownPage.selectAnOptionUsingIndex(2);
        Assert.assertEquals(dropDownPage.getSelectedOptionFromIndexDropDown(), "Appium");
    }

    @Test
    public void noOfOptionsTest() {
        Assert.assertEquals(dropDownPage.getTotalNoOfOptionsForNoOfOptionsDropDown(), 5);
    }

    @Test
    public void multiDropDownTest() {
        List<String> values = new ArrayList<>();
        values.add("Selenium");
        values.add("Loadrunner");
        dropDownPage.selectOptionsFromMultiSelectDropDown(values);
        List<String> actualList = dropDownPage.getSelectedValuesFromMultiSelectDropDown();
        actualList.remove(0);
        Assert.assertTrue(actualList.equals(values), "Actual list is not as expected!!");
    }

}