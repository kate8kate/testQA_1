package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MultipleWindowsPage extends BasePage{
    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@href='/windows/new']")
    WebElement linkClickHere;

    public MultipleWindowsPage openSamplePage() {
        click(linkClickHere);
        return this;
    }

    public SamplePage switchToSamplePage(int index) {
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
        return new SamplePage(driver);
    }
}
