package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BrokenImagesPage;
import pages.CheckboxesPage;
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
    public void practiceFormTest() {
        new CheckboxesPage(driver)
                .selectCheckboxes(new String[]{"checkbox 1","checkbox 2"})
                .verifyIfCheckboxesSelected();
    }
}
