package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DragAndDropPage;
import pages.HomePage;

public class DragAndDropTest extends BaseTest{
    @BeforeClass
    public void classPreconditions() {
        new HomePage(driver).clickOnDragAndDropPage();
    }

    @AfterClass
    public void classPostConditions() {
        new HomePage(driver).navigateToHomePage();
    }

    @Test
    public void dragAndDropActions() {
        new DragAndDropPage(driver)
                .actionsDragIt()
                .verifyDragAndDropAction();
    }
}
