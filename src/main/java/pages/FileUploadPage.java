package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage{
    public FileUploadPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "file-upload")
    WebElement filePathVerifyBtn;

    @FindBy(xpath = "//input[@class='button']")
    WebElement uploadBtn;

    @FindBy(xpath = "//h3")
    WebElement successfulUpload;


    public FileUploadPage uploadFile(String path) {
        filePathVerifyBtn.sendKeys(path);
        click(uploadBtn);
        return this;
    }

    public boolean verifySuccessfulUpload(String str) {
        String actualRes = getTextBase(successfulUpload);
        return isStringsEqual(actualRes, str);
    }
}
