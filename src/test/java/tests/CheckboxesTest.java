package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BrokenImagesPage;
import pages.HomePage;

public class CheckboxesTest extends BaseTest{
    @BeforeClass
    public void classPreconditions() {
        new HomePage(driver).clickOnBrokenImagesPage();
    }

    @AfterClass
    public void classPostConditions() {
        new HomePage(driver).navigateToHomePage();
    }

    @Test
    public void brokenImagesTest() {
        //this is wrong
        driver.navigate().to("https://the-internet.herokuapp.com/broken_images");
        new BrokenImagesPage(driver).checkBrokenImages();
    }
}
