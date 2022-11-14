package logic.init;

import io.qameta.allure.Attachment;
import logic.loginPage.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


import static logic.init.BasePage.driver;
import static logic.init.BasePage.projectName;


public class Listeners extends TestListenerAdapter {

    protected static final Logger log = Logger.getLogger(Listeners.class);

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }



    /**
     * Listener onTestFailure
     * Выполнение тела происходит в случае падения теста.
     *
     */
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info(BasePage.ConsoleColors.RED_BOLD_BRIGHT + BasePage.ConsoleColors.BLACK_BACKGROUND + "---------------------------- PROJECT: " + projectName + " | TEST FAILED: " + iTestResult.getMethod().getMethodName() + " ----------------------------" + BasePage.ConsoleColors.RESET);
        BasePage basePage = new BasePage();
        try {
            basePage.stopRecordFalse(iTestResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
            /*ITestContext context = iTestResult.getTestContext();
            driver = ((AndroidDriver) context.getAttribute("driver"));*/
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        saveTextLog(getTestMethodName(iTestResult) + " failed!");
        driver.resetApp();
        }

    /**
     * Listener onTestSuccess
     * Выполнение тела происходит в случае успешного окончания теста.
     *
     */
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        BasePage basePage = new BasePage();
        try {
            basePage.stopRecordSuccess(iTestResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info(BasePage.ConsoleColors.GREEN_BOLD_BRIGHT + BasePage.ConsoleColors.BLACK_BACKGROUND + "++++++++++++++++++++++++++++ PROJECT: " + projectName + " | TEST PASSED: " + iTestResult.getMethod().getMethodName() + " ++++++++++++++++++++++++++++" + BasePage.ConsoleColors.RESET);
    }

    /**
     * Listener onTestStart
     * Выполнение тела происходит в начале каждого тест-метода.
     *
     */
    @Override
    public void onTestStart(ITestResult iTestResult) {
        LoginPage loginPage = new LoginPage();
        log.info(BasePage.ConsoleColors.BLUE_BOLD_BRIGHT + BasePage.ConsoleColors.BLACK_BACKGROUND + "---------------------------- PROJECT: " + projectName + " | TEST START: " + iTestResult.getMethod().getMethodName() + " ----------------------------" + BasePage.ConsoleColors.RESET);
        loginPage.setServerIp();
    }

    /**
     * Listener onStart
     * Выполнение тела происходит в начале любого тест-метода.
     *
     */
    @Override
    public void onStart(ITestContext iTestContext) {
    }

    /**
     * Listener onFinish.
     * Выполнение тела происходит после выполнения всех тестов.
     *
     */
    @Override
    public void onFinish(ITestContext iTestContext) {
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Attachment(value = "Open to watch method name.", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

}