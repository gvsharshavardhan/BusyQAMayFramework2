package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DropDownPage extends BasePage {

    //locators
    By indexDropdownLocator = By.cssSelector("#dropdown1");
    By noOfDropDownLocator = By.className("dropdown");
    By multiDropDownLocator = By.xpath("//select[@multiple]");

    //const
    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    //methods
    public void goToDropDownPage() {
        driver.get("http://leafground.com/pages/Dropdown.html");
    }

    public void selectAnOptionUsingIndex(int index) {
        WebElement indexDropDownElement = driver.findElement(indexDropdownLocator);
        Select select = new Select(indexDropDownElement);
        select.selectByIndex(index);
    }

    public String getSelectedOptionFromIndexDropDown() {
        WebElement indexDropDownElement = driver.findElement(indexDropdownLocator);
        Select select = new Select(indexDropDownElement);
        return select.getFirstSelectedOption().getText();
    }

    public int getTotalNoOfOptionsForNoOfOptionsDropDown() {
        WebElement noOfOptionsDropDownElement = driver.findElement(noOfDropDownLocator);
        Select select = new Select(noOfOptionsDropDownElement);
        return select.getOptions().size();
    }

    public void selectOptionsFromMultiSelectDropDown(List<String> values) {
        WebElement multiDropDownElement = driver.findElement(multiDropDownLocator);
        Select select = new Select(multiDropDownElement);
        if (isMyDropDownMultiple(select)) {
            for (String value : values) {
                select.selectByVisibleText(value);
            }
        } else {
            Assert.assertTrue(false, "Drop down is not multiple!!");
        }
    }

    private boolean isMyDropDownMultiple(Select select) {
        return select.isMultiple();
    }

    public List<String> getSelectedValuesFromMultiSelectDropDown() {
        WebElement multiDropDownElement = driver.findElement(multiDropDownLocator);
        Select select = new Select(multiDropDownElement);
        List<WebElement> selectedWebElements = select.getAllSelectedOptions();
        List<String> values = new ArrayList<>();
        for (WebElement element : selectedWebElements) {
            values.add(element.getText().trim());
        }
        return values;
    }

}
