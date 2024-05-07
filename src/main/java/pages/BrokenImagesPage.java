package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenImagesPage extends BasePage{
    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//img")
    List<WebElement> allImages;

    public BrokenImagesPage checkBrokenImages() {
        for(WebElement el : allImages) {
            String image = getAttributeBase(el, "src");
            verifyLinks(image);
            try {
                boolean isImageDisplayed =
                        (boolean) ((JavascriptExecutor)driver)
                                .executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth > 0);",
                                        image);
                if(isImageDisplayed) {
                    System.out.println("OK");
                } else {
                    System.out.println("Broke");
                }
            }catch (Exception e){
                System.out.println("ERROR");
            }
        }
        return this;
    }

    private void verifyLinks(String link) {
        try {
            URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() >= 400) {
                System.out.println(link + " " + httpURLConnection.getResponseMessage() + " broken link");
            } else {
                System.out.println(link + " " + httpURLConnection.getResponseMessage() + " correct link");
            }
        }catch (Exception e) {
            System.out.println(link + " " + e.getMessage() + " ERROR");
        }
    }
}
