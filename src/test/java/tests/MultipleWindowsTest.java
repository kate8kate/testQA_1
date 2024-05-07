package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MultipleWindowsPage;
import pages.SamplePage;

public class MultipleWindowsTest extends BaseTest{
    @BeforeClass
    public void classPreconditions() {
        new HomePage(driver).clickOnMultipleWindowsPage();
    }

    @AfterMethod
    public void afterMethodPostConditions() {
        new SamplePage(driver).closeCurrentTab()
                .switchToMultipleWindowsPage(0);
    }

    @AfterClass
    public void classPostConditions() {
        new HomePage(driver).navigateToHomePage();
    }

    @Test
    public void multipleWindowsOpenTest() {
        Assert.assertTrue(new MultipleWindowsPage(driver)
                .openSamplePage()
                .switchToSamplePage(1)
                .verifySamplePageOpen());
    }
}
