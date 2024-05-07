package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxesPage extends BasePage{
    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "checkboxes")
    List<WebElement> allCheckboxes;

    public CheckboxesPage selectCheckboxes(String[] strings) {
        for (String str : strings) {
            for (WebElement element : allCheckboxes) {
                if (getTextBase(element).equals(str)) {
                    click(element);
                    break;
                }
            }
        }
        return this;
    }

    public boolean verifyIfCheckboxesSelected() {
        return allCheckboxes.get(0).isSelected() && allCheckboxes.get(1).isEnabled();
    }
}
