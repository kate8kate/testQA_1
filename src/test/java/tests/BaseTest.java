package tests;

import config.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTests {
    static WebDriver driver;

    static ApplicationManager app =
            new ApplicationManager(System
                    .getProperty("browser", Browser.CHROME.browserName()));
    static Logger logger = LoggerFactory.getLogger(BaseTests.class);
    @BeforeSuite
    public static void startBrowser() {
        logger.info("run browser settings ");
        app.init();
    }
    @AfterSuite
    public static void tearDown() {
        logger.info("quit browser");
        app.quit();
    }
}
