package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TablePage extends BasePage {

    public TablePage(WebDriver driver) {
        super(driver);
    }

    //locators
    private final By headersXpath = By.xpath("//table//th");
    private final By rowsXpath = By.xpath("//table//tr");
    private String progressValueXpath = "//table//td[1]//font[normalize-space(text())='$$']/../following-sibling::td[1]/font";
    private final By allProgressValuesXpath = By.xpath("//table//td[2]/font");
    private String vitalTaskXpath = "(//table//td[3])[$$]/input";
    private By allVitalTasksXpath = By.xpath("(//table//td[3])/input");

    //methods

    public void goToTablePage() {
        driver.get("http://leafground.com/pages/table.html");
    }

    public int getTotalColumnCount() {
        return driver.findElements(headersXpath).size();
    }

    public int getRowCount() {
        return driver.findElements(rowsXpath).size();
    }

    public List<String> getProgressValues(String details) {
        return getTextOfElements(By.xpath(progressValueXpath.replace("$$", details)));
    }

    public List<String> getAllProgressValues() {
        return getTextOfElements(allProgressValuesXpath);
    }

    public List<String> getTextOfElements(By locator) {
        List<String> texts = new ArrayList<>();
        List<WebElement> elements = driver.findElements(locator);
        for (WebElement ele : elements) {
            texts.add(ele.getText().trim());
        }
        return texts;
    }

    public int getLeastProgressValueIndex() {
        List<String> progressValues = getAllProgressValues();
        List<Integer> progressValuesAsIntegers = new ArrayList<>();
        for(String progressValue : progressValues){
            progressValuesAsIntegers.add(Integer.parseInt(progressValue.replace("%","")));
        }
        List<Integer> sortedList = new ArrayList<>(progressValuesAsIntegers);
        Collections.sort(sortedList);//default -> ascending order
        System.out.println(sortedList);
        int minValue = sortedList.get(0);
        return progressValuesAsIntegers.indexOf(minValue) + 1;
    }

    public void selectTheVitalTask(int index) {
        String indexAsString = Integer.toString(index);
        driver.findElement(By.xpath(vitalTaskXpath.replace("$$", indexAsString))).click();
    }

    public int getIndexOfCheckedVitalTask() {
        List<WebElement> allVitalTaskElements = driver.findElements(allVitalTasksXpath);
        int index = 0;
        for (int i = 0; i < allVitalTaskElements.size(); i++) {
            if (allVitalTaskElements.get(i).isSelected()) {
                index = i;
            }
        }
        return index + 1;
    }

}