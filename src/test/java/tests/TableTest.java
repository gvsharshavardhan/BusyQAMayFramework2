package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TablePage;

import java.util.ArrayList;
import java.util.List;

public class TableTest extends BaseTest {

    TablePage tablePage;

    @BeforeMethod
    public void goToTargetPage() {
        setUp();
        tablePage = new TablePage(driver);
        tablePage.goToTablePage();
    }

//    @AfterMethod
    public void closingActivity() {
        tearDown();
    }

    @Test(priority = 20)
    public void columnCountTest() {
        //AAA
        //Arrange
        int expectedColumnCount = 3;

        //Act
        int actualColumnCount = tablePage.getTotalColumnCount();


        //Assert
        Assert.assertEquals(actualColumnCount, expectedColumnCount, "Column count is not as expected!!");


    }

    @Test(priority = 1)
    public void rowCountTest() {

        //Arrange
        int expectRowCount = 6;

        //Act
        int actualRowCount = tablePage.getRowCount();

        //Assert
        Assert.assertEquals(actualRowCount, expectRowCount, "Row count is not as expected!!");

    }

    @Test(priority = 40)
    public void progressValueTest() {
        //Arrange
        String learningDetail = "Learn to interact with Elements";
        List<String> expectedProgressValues = new ArrayList<>();
        expectedProgressValues.add("80%");
        expectedProgressValues.add("30%");
        expectedProgressValues.add("80%");

        //Act
        List<String> actualProgressValues = tablePage.getProgressValues(learningDetail);

        //Assert
        Assert.assertTrue(actualProgressValues.equals(expectedProgressValues));
    }

    @Test
    public void vitalTaskTest() {
        //Arrange
        int leastProgressValueIndex = tablePage.getLeastProgressValueIndex();
        System.out.println(leastProgressValueIndex);

        //Act
        tablePage.selectTheVitalTask(leastProgressValueIndex);

        //Assert
        Assert.assertEquals(tablePage.getIndexOfCheckedVitalTask(), leastProgressValueIndex, "Wrong checkbox got selected!!");
    }
}