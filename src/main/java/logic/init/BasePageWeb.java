package logic.init;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.qameta.allure.Attachment;
import logic.dbConnection.SqlRequests;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

//@org.testng.annotations.Listeners(Listeners.class)
public abstract class BasePageWeb {

    protected static final Logger log = Logger.getLogger(BasePageWeb.class);
    protected AndroidDriver<MobileElement> AndroidDriver;

    protected WebDriver driver;
    public Boolean recorderLogger = false;

    public BasePageWeb() {
        this.driver = ChromeWebDriver.getWebDriver();
        PageFactory.initElements(driver, this);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    SqlRequests sql = new SqlRequests();
    Credentials cred = new Credentials();

    public void clearEventsDrivers() throws SQLException {
        sql.deleteEvents(cred.sqlDriver1());
        sql.deleteEvents(cred.sqlDriver2());
    }

    /*@BeforeClass
    public void clearDB() throws SQLException {
        sql.deleteEvents(cred.sqlDriver1());
        sql.deleteEvents(cred.sqlDriver2());
        sql.deleteIR(cred.sqlDriver1());
        sql.deleteIR(cred.sqlDriver2());
    }*/

    @BeforeMethod
    public void startRecord() {
        //this.AndroidDriver = AndroidMobileDrivers.getDriver();
        AndroidDriver.startRecordingScreen(new AndroidStartScreenRecordingOptions().withTimeLimit(Duration.ofSeconds(1800)));
        log.info("Start recording tests.");
    }

    @AfterMethod
    public void stopRecord() throws Exception {
        //this.AndroidDriver = AndroidMobileDrivers.getDriver();
        String base64String = AndroidDriver.stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);
        String destinationPath = "allure-results/video/test-Date-" + DateUtil.currentDateVideo(null) + "-Time-" + DateUtil.currentTimeVideo(null) + ".mp4";
        Path path = Paths.get(destinationPath);
        Files.write(path, data);
        log.info("Stop recording tests.");
        attachVideo(destinationPath);
    }

//    @FindBy(xpath = "/html/body/div[3]/div[2]/nav/div/div[2]/a")
//    public WebElement logoutButtonInCompany;
//    @FindBy(xpath = "/html/body/admin-view/div/div/admin-desktop-menu/div[1]/div/div/div[3]/div/button")
//    public WebElement logoutButtonOutOfCompany;
//    @FindBy(xpath = "/html/body/nav/div/div[2]/ul/li[4]")
//    public WebElement clickLogin;
//
//    public BasePageWeb logoutFromWeb() {
//        if (isElementPresent(3, logoutButtonInCompany)) {
//            log.info("Logout from web.");
//            waitToVisibilityOfClick(5, logoutButtonInCompany);
//            logoutButtonInCompany.click();
//            waitToVisibilityOfClick(5, clickLogin);
//            clickLogin.click();
//            return this;
//        }
//        if (isElementPresent(3, logoutButtonOutOfCompany)){
//            log.info("Logout from web.");
//            waitToVisibilityOfClick(5, logoutButtonOutOfCompany);
//            logoutButtonOutOfCompany.click();
//            waitToVisibilityOfClick(5, clickLogin);
//            clickLogin.click();
//            return this;
//        }
//        return this;
//    }

    protected void implicityWait(int timeOut) {
        try {
            driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            log.info("Test failed. Time to wait is end " + e);
            saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            fail(e.toString());
        }
    }

    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    protected boolean isElementDisplayedOnPage(WebElement element, String elementName) throws NoSuchElementException {
        if (element.isDisplayed()) {
            log.info(elementName + " is displayed");
            //LogToAllure.logToAllure(elementName + " is displayed");
            return true;
        } else {
            log.error(elementName + " is NOT displayed");
            //LogToAllure.logToAllure(elementName + " is NOT displayed");
            return false;
        }
    }

    public boolean isElementPresent(int timeOut, WebElement element) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        try {
            element.isDisplayed();
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            return true;
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            return false;
        }
    }

    protected void waitToVisibilityOfClick(int timeOut, WebElement element) {
        new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
        try {
            new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions
                            .elementToBeClickable(element));
        } catch (TimeoutException e) {
            log.error("Test failed. Time to wait is end " + e);
        }
    }

    protected WebElement waitToVisibilityOf(int timeOut, WebElement element) throws TimeoutException {
        try {
            new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            fail(e.toString());
        }
        return element;
    }

//    protected boolean waitToVisibilityMenu(int timeout) {
//        try {
//            js.executeScript(String.valueOf("return document.readyState".equals("complete")));
//            return true;
//        } catch (Exception e) {
//            log.info("Menu not found!");
//            return false;
//        }
//    }

    protected void clickCheckbox(WebElement checkbox, boolean flag, String checkboxName) {
        waitToVisibilityOf(10, checkbox);
        if (checkbox.isSelected() != flag) {
            checkbox.click();
            log.info("Set " + checkboxName + " checkbox - " + flag);
            LogToAllure.logToAllure("Set " + checkboxName + " checkbox", String.valueOf(flag));
        } else {
            log.info("CheckBox " + checkboxName + " already " + flag);
        }
    }

    protected void waitPageToLoad(int pageLoadTimeout) {
        new WebDriverWait(driver, pageLoadTimeout).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    protected void waitToBeClickable(int timeOut, WebElement element) {
        try {
            new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions
                            .elementToBeClickable(element));
        } catch (TimeoutException e) {
            log.error("Test failed. Time to wait is end " + e);
        }
    }

    protected boolean checkTextOnElement(WebElement element, String text) {
        return element.getText().contains(text);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    public void screenshot() {
        log.info("Taking a screenshot of the page.");
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
    }


    @Attachment(value = "video", type = "video/mp4")
    public byte[] attachVideo(String path) throws Exception {
        return getFileResult(path);
    }

    public byte[] getFileResult(String fileName) throws Exception {
        File file = new File(fileName);
        return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
    }
}