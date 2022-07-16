package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckboxesPage extends BasePage {

    public CheckboxesPage(WebDriver driver) {

        super(driver);
    }

    //locators
    private By divText = By.xpath("//label[contains(text(),'languages')]/parent::div");
    private By optionsElements = By.xpath("//label[contains(text(),'languages')]/following-sibling::input");
    private Map<String, WebElement> inputMapping = new HashMap<>();

    //actions/methods/behaviours

    public void goToCheckboxPage() {
        driver.get("http://leafground.com/pages/checkbox.html");
    }

    public String getTextFromDivTextElement() {
        return driver.findElement(divText).getText();
    }

    public String[] getOptionsFromDivText() {
        return getTextFromDivTextElement().split("\n")[2].split(" ");
    }

    public List<WebElement> getAllOptionElements() {
        return driver.findElements(optionsElements);
    }

    public void mapOptionsToCorrespondingElements() {
        String[] options = getOptionsFromDivText();
        List<WebElement> inputElements = getAllOptionElements();
        for (int i = 0; i < options.length; i++) {
            inputMapping.put(options[i], inputElements.get(i));
        }
    }

    public WebElement getTheElementOfCorrespondingValue(String language) {
        return inputMapping.get(language);
    }

    public void SelectLanguages(List<String> languages) {
        mapOptionsToCorrespondingElements();
        for (String ip : languages) {
            getTheElementOfCorrespondingValue(ip).click();
        }
    }

    public List<String> getAllCheckedLanguagesOptions() {
        List<WebElement> optionElements = getAllOptionElements();
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < optionElements.size(); i++) {
            if (optionElements.get(i).isSelected()) {
                indexes.add(i);
            }
        }
        List<String> selectedLanguages = new ArrayList<>();
        String[] languages = getOptionsFromDivText();
        for (int index : indexes) {
            selectedLanguages.add(languages[index]);
        }

        return selectedLanguages;
    }

}