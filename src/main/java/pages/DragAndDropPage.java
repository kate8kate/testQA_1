package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage{
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "column-b")
    WebElement elementDrop;

    @FindBy(id = "column-a")
    WebElement elementToDrag;

    @FindBy(xpath = "//header[text()='B']")
    WebElement checkElement;


    public DragAndDropPage actionsDragIt() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(elementDrop, elementToDrag).perform();
        pause(10000);
        return this;
    }

    public boolean verifyDragAndDropAction() {
        return elementToDrag.getText()
                .equals(checkElement);
    }
}
