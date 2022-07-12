package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LinksPage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class LinksTest extends BaseTest {
    LinksPage linksPage;

    @BeforeMethod
    public void goToTargetPage() {
        setUp();
        linksPage = new LinksPage(driver);
        linksPage.goToLinksPage();
    }

    @AfterMethod
    public void closingActivity() {
        tearDown();
    }

    @Test
    public void homePageLink1Test() {
        linksPage.goToHomePageLink();
        Assert.assertEquals(linksPage.getPageTitle(), "TestLeaf - Selenium Playground");
    }

    @Test
    public void destinationTest() {
        String dest = linksPage.getDestinationOfWithoutClickingMeLink();
        Assert.assertTrue(dest.contains("Button.html"));
    }

    @Test
    public void homePageLink2Test() {
        linksPage.goToHomePageLink2();
        Assert.assertEquals(linksPage.getPageTitle(), "TestLeaf - Selenium Playground");
    }

    @Test
    public void linksCountTest() {
        int actualLinksCount = linksPage.getTotalLinksCount();
        Assert.assertEquals(actualLinksCount, 6);
    }


    @Test
    public void brokenLinkTest() {
        String urlInStringFormat = linksPage.getHrefValueOfBrokenLink();
        URL urlInURLFormat = null;
        try {
            urlInURLFormat = new URL(urlInStringFormat);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection) (urlInURLFormat.openConnection());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            httpURLConnection.setRequestMethod("HEAD");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        try {
            httpURLConnection.connect();
            Assert.assertTrue(httpURLConnection.getResponseCode() >= 400);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}