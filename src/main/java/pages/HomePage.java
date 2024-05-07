package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@href ='/javascript_alerts']")
    WebElement linkJSAlertPage;

    @FindBy(xpath = "//a[@href ='/windows']")
    WebElement linkOpenNewWindowPage;

    @FindBy(xpath = "//a[@href ='/checkboxes']")
    WebElement linkCheckboxesPage;

    @FindBy(xpath = "//a[@href ='/dropdown']")
    WebElement linkDropdownPage;

    @FindBy(xpath = "//a[@href ='/broken_images']")
    WebElement linkBrokenImagesPage;

    @FindBy(xpath = "//a[@href ='/drag_and_drop']")
    WebElement linkDragAndDropPage;

    @FindBy(xpath = "//a[@href ='/upload']")
    WebElement linkFileUploadPage;
    public HomePage navigateToHomePage() {
        driver.navigate().to("https://demoqa.com/");
        return this;
    }

    public JSAlertsPage clickOnLinkJSAlertsPage() {
        clickWithJSScroll(linkJSAlertPage, 0, 500);
        return new JSAlertsPage(driver);
    }

    public MultipleWindowsPage clickOnMultipleWindowsPage() {
        clickWithJSScroll(linkOpenNewWindowPage, 0, 500);
        return new MultipleWindowsPage(driver);
    }

    public CheckboxesPage clickOnCheckboxesPage() {
        clickWithJSScroll(linkCheckboxesPage, 0, 500);
        return new CheckboxesPage(driver);
    }

    public DropdownPage clickOnDropdownPage() {
        click(linkDropdownPage);
        return new DropdownPage(driver);
    }

    public BrokenImagesPage clickOnBrokenImagesPage() {
        click(linkBrokenImagesPage);
        return new BrokenImagesPage(driver);
    }

    public DragAndDropPage clickOnDragAndDropPage() {
        click(linkDragAndDropPage);
        return new DragAndDropPage(driver);
    }

    public FileUploadPage clickOnFileUploadPage() {
        clickWithJSScroll(linkFileUploadPage, 0, 200);
        return new FileUploadPage(driver);
    }
}
