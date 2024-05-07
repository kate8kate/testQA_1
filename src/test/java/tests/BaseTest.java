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

import java.lang.reflect.Method;
import java.util.Arrays;

public class BaseTest {
    static WebDriver driver;

    static ApplicationManager app =
            new ApplicationManager(System
                    .getProperty("browser", Browser.CHROME.browserName()));

    static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeSuite
    public static void startBrowser() {
        logger.info("run browser settings ");
        driver = app.init();
    }

    @AfterSuite
    public static void tearDown() {
        logger.info("quit browser");
        app.quit();
    }

    @BeforeMethod
    public void startTest(Method method, Object[] o) {
        logger.info("Start test: " + method.getName() +
                " with data " + Arrays.asList(o));
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED " + result.getMethod().getMethodName());
            //     + "Screenshot: " + app.getUserHelper().takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("-------------------------------------------------------");
    }
}
