package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JSAlertsPage extends BasePage{
    public JSAlertsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@onclick = 'jsAlert()']")
    WebElement btnOpenAlert;

    @FindBy(xpath = "//button[@onclick = 'jsConfirm()']")
    WebElement btnOpenConfirmAlert;

    @FindBy(xpath = "//button[@onclick = 'jsPrompt()']")
    WebElement btnOpenPromptAlert;

    @FindBy(xpath = "//p[@id = 'result']")
    WebElement textFromPrompt;

    private Alert getAlert() {
        return driver.switchTo().alert();
    }

    public JSAlertsPage clickAccept(Alert alert) {
        alert.accept();
        return this;
    }

    private void typeInAlertPrompt(String text, Alert alert) {
        alert.sendKeys(text);
    }

    private String getMessageAlert(Alert alert) {
        return alert.getText().trim();
    }

    public JSAlertsPage closeAlertIfPresent() {
        try {
            clickAccept(getAlert());
        } catch (Exception e) {
            logger.info("alert not displays");
        }
        return this;
    }

    public boolean verifyAlertOpen() {
        click(btnOpenAlert);
        Alert alert = getAlert();
        if (alert.equals(ExpectedConditions.alertIsPresent())) {
            clickAccept(alert);
            return true;
        } else {
            clickAccept(alert);
            return false;
        }
    }

    public boolean verifyConfirmAlertText() {
        click(btnOpenConfirmAlert);
        Alert alert = getAlert();
        String expectedRes = "I am a JS Confirm";
        String actualRes = getMessageAlert(alert);
        clickAccept(alert);
        return expectedRes.equals(actualRes);
    }

    public boolean verifyTextFromPromptDisplaysCorrect(String text) {
        click(btnOpenPromptAlert);
        Alert alert = getAlert();
        typeInAlertPrompt(text, alert);
        clickAccept(alert);
        String actualRes = "You entered: " + textFromPrompt;
        return actualRes.contains(text);
    }
}
