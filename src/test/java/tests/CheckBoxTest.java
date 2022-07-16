package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckBoxTest extends BaseTest {

    CheckboxesPage checkboxesPage;

    @BeforeMethod
    public void goToTargetPage() {
        setUp();
        checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.goToCheckboxPage();
    }

    //    @AfterMethod
    public void closingActivity() {
        tearDown();
    }

    @Test
    public void languagesTest() {
        //AAA
        //Arrange: test data
        //Act: logic//methids from page class
        //Assert: to validate the requirent

        //arrange
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("SQL");
        languages.add("VB");
        languages.add("C++");
        Set<String> expectedSetOfLanguages = new HashSet<>(languages);

        //act
        checkboxesPage.SelectLanguages(languages);

        //assert//validation
        List<String> actualLanguagesSelected = checkboxesPage.getAllCheckedLanguagesOptions();
        System.out.println(actualLanguagesSelected);
        Set<String> actualSetOfLanguages = new HashSet<>(actualLanguagesSelected);
        Assert.assertTrue(actualSetOfLanguages.equals(expectedSetOfLanguages), "selected languages are not matching with expected languages!!");
    }
}
