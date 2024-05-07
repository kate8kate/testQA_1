package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import pages.HomePage;

public class FileUploadTest extends BaseTest{
    @BeforeClass
    public void classPreconditions() {
        new HomePage(driver).clickOnFileUploadPage();
    }

    @AfterClass
    public void classPostConditions() {
        new HomePage(driver).navigateToHomePage();
    }

    @Test
    public void fileUploadTest() {
        new FileUploadPage(driver)
                .uploadFile("/Users/kategonshteyn/Tools/example.png")
                .verifySuccessfulUpload("File Uploaded!");
    }
}
