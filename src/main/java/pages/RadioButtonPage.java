package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtonPage extends BasePage {

    //locators
    String ageRadioButtonXpath = "//input[@name='age' and @value='$$']";
    By ageRadioButtonsLocator = By.xpath("//input[@name='age']");

    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    //methods
    public void selectYourAgeGroup(int age) {
        if (age >= 1 && age <= 20) {
            WebElement radio0 = driver.findElement(By.xpath(ageRadioButtonXpath.replace("$$", "0")));
            if (!radio0.isSelected()) {
                radio0.click();
            }
        } else if (age >= 21 && age <= 40) {
            WebElement radio1 = driver.findElement(By.xpath(ageRadioButtonXpath.replace("$$", "1")));
            if (!radio1.isSelected()) {
                radio1.click();
            }
        } else {
            WebElement radio2 = driver.findElement(By.xpath(ageRadioButtonXpath.replace("$$", "2")));
            if (!radio2.isSelected()) {
                radio2.click();
            }
        }
    }

    public int getTheSelectedAgeValue() {
        List<WebElement> ageRadioButtonElements = driver.findElements(ageRadioButtonsLocator);
        String ageValue = "";
        for (WebElement element : ageRadioButtonElements) {
            if (element.isSelected()) {
                ageValue = element.getAttribute("value");
            }
        }
        return Integer.parseInt(ageValue);
    }

    public void goToRadioButtonPage() {
        driver.get("http://leafground.com/pages/radio.html");
    }
}
