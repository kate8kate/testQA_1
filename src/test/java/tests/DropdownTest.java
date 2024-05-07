package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DropdownPage;
import pages.HomePage;

public class DropdownTest extends BaseTest{
    @BeforeClass
    public void classPreconditions() {
        new HomePage(driver).clickOnDropdownPage();
    }

    @AfterClass
    public void classPostConditions() {
        new HomePage(driver).navigateToHomePage();
    }

    @Test
    public void dropdownListTest() {
        new DropdownPage(driver)
                .selectFromTheList("Option 1")
                .verifyOptionRes("Option 1");
    }
}
