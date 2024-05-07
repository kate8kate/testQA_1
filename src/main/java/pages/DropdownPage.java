package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropdownPage extends BasePage{
    public DropdownPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "dropdown")
    WebElement selectOption;

    @FindBy(xpath = "//option[@value='2']")
    WebElement optionValue;

    public DropdownPage selectFromTheList(String option) {
        click(selectOption);
        selectOption.sendKeys(option);
        selectOption.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean verifyOptionRes(String str) {
        String actualRes = getTextBase(optionValue);
        return isStringsEqual(actualRes, str);
    }
}
