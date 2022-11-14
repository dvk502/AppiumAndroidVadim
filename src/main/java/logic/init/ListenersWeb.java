package logic.init;

import io.qameta.allure.Attachment;
import logic.web.companyProfile.Trucks;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public abstract class ListenersWeb implements ITestListener {

    Trucks webTruck = new Trucks();

    protected static final Logger log = Logger.getLogger(ListenersWeb.class );

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("------ WEB TEST FAILED: " + iTestResult.getMethod().getMethodName() + " -------");
        ChromeWebDriver.driver.quit();
        ITestContext context = iTestResult.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("++++++++++++++++++++++++++++ TEST PASSED: " + iTestResult.getMethod().getMethodName() + " ++++++++++++++++++++++++++++");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("---------------------------- TEST START: " + iTestResult.getMethod().getMethodName() + " ----------------------------");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Attachment(value="Open to watch method name.", type = "text/plain")
    public static String saveTextLog (String message) {

        return message;
    }

}