package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinksPage extends BasePage {

    //locators
    By withoutClickingMeLink = By.partialLinkText("clicking me");
    By homePageLink = By.linkText("Go to Home Page");
    By brokenLink = By.linkText("Verify am I broken?");
    By homePageLink2 = By.xpath("//label/preceding-sibling::a");

    //const -> intialize the driver
    public LinksPage(WebDriver driver) {
        super(driver);
    }
    //methods

    public void goToLinksPage() {
        driver.get("http://leafground.com/pages/Link.html");
    }

    public void goToHomePageLink() {
        driver.findElement(homePageLink).click();
    }

    public String getDestinationOfWithoutClickingMeLink() {
        return driver.findElement(withoutClickingMeLink).getAttribute("href");
    }

    public void goToHomePageLink2() {
        driver.findElement(homePageLink2).click();
    }

    public String getHrefValueOfBrokenLink() {
        return driver.findElement(brokenLink).getAttribute("href");
    }

    public int getTotalLinksCount() {
        return driver.findElements(By.xpath("//a")).size();
    }
}