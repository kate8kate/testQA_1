package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JSAlertsPage;

public class JSAlertsTest extends BaseTest{
    @BeforeClass
    public void classPreconditions() {
        new HomePage(driver).clickOnLinkJSAlertsPage();
    }

    @AfterMethod
    public void postConditionAfterMethod() {
        new JSAlertsPage(driver).closeAlertIfPresent();
    }

    @AfterClass
    public void classPostConditions() {
        new HomePage(driver).navigateToHomePage();
    }

    @Test
    public void clickForJSAlertBtnTest() {
        Assert.assertFalse(new JSAlertsPage(driver)
                .verifyAlertOpen());
    }

    @Test
    public void clickForJSConfirmBtnTest() {
        Assert.assertTrue(new JSAlertsPage(driver)
                .verifyConfirmAlertText());
    }

    @Test
    public void clickForJSPromptBtnTest() {
        Assert.assertFalse(new JSAlertsPage(driver)
                .verifyTextFromPromptDisplaysCorrect("Yes!"));
    }
}
