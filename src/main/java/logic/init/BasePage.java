package logic.init;

import com.automation.remarks.video.recorder.ffmpeg.FFmpegWrapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import logic.dbConnection.SqlRequests;
import logic.loginPage.LoginPage;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;


@org.testng.annotations.Listeners(Listeners.class)
public class BasePage {
    protected static final Logger log = Logger.getLogger(BasePage.class);

    /**
     * Выбор проекта для тестирования.
     * В переменную projectName можно установить одно из нескольких значений - названий существующих проектов.
     * Список проектов:
     * TE - TrackEnsure
     * Alfa
     * Vista
     * Smart
     * Swift
     * В переменную eldName устанавливается официальное название проекта, отображаемое в Privacy Policy. при создании IFTA и т.д.
     * В переменную projectLocator устанавливается дефолтный локатор приложения. Каждый проект имеет разный локатор.
     * Список локаторов существующих проектов:
     * TE - com.trackensure.eld.debug
     * Alfa - org.alfa.eld
     * Swift - org.swift.eld
     * Smart - org.smart.eld
     * Vista - org.vista.eld
     * Trendy - org.trendy.eld
     * Sharp - org.sharp.eld
     */

    public static final String projectName = "TE";
    public static final String eldName = "TrackEnsure ELD";
    public static final String projectLocator = "com.trackensure.eld.debug";
    public static final String serverIp = "http://10.10.1.95:8080/TrackEnsure";
    public static final String webAddress = "http://10.10.1.95:8080/TrackEnsure";
    //public static final String serverIp = "https://trackensure.com";
   // public static final String webAddress = "https://trackensure.com";
   // public static final String webAddressLogin = "https://trackensure.com/login.do";
    public static final String webAddressLogin = "http://10.10.1.95:8080/TrackEnsure/login.do";
    public static String textMatch = ConsoleColors.GREEN_BOLD + " Text Matches!" + ConsoleColors.RESET;
    public static String textIsDifferent = ConsoleColors.RED_BOLD + " Text is Different!" + ConsoleColors.RESET;

    /**
     * getTestMethodName
     * Получение названия метода.
     */

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }

    /**
     * Вызов экземпляра классов, которые используются в BasePage.
     */

    SqlRequests sql = new SqlRequests();
    Credentials cred = new Credentials();
    FFmpegWrapper fFmpegWrapper = new FFmpegWrapper();
    DateUtil myDate = new DateUtil();


    /**
     * Выполнение запроса deleteEvents на удаление ивентов у выбранных водителей.
     * @throws SQLException
     */
    public void clearEventsDrivers() throws SQLException {
        SqlRequests.deleteEvents(cred.sqlDriver1());
        SqlRequests.deleteEvents(cred.sqlDriver2());
    }

    /**
     * Выполнение в начале каждого тест-класса.
     * Очистка водителей от созданных ивентов в предыдущих тестах.
     * Происходит очистка Duty ивентов, inspection reports, border crossing ивентов.
     * @throws SQLException
     */
    @BeforeClass
    public void clearDB() throws SQLException {
        SqlRequests.deleteEvents(cred.sqlDriver1());
        SqlRequests.deleteEvents(cred.sqlDriver2());
        SqlRequests.deleteIR(cred.sqlDriver1());
        SqlRequests.deleteIR(cred.sqlDriver2());
        SqlRequests.deleteBC(cred.sqlDriver1());
    }

    /**
     * Метод автоматического запуска видеозаписи тестирования.
     * Выполнение происходит в начале каждого тест-метода.
     * Длительность записи видео регулируется в функции Duration.ofSeconds.
     * Максимальная длительность записи тестов - 1800 секунд.
     */
    @BeforeMethod
    public void startRecord() {
        driver.startRecordingScreen(new AndroidStartScreenRecordingOptions().withTimeLimit(Duration.ofSeconds(1800)));
        log.info("Start recording tests.");
    }

    /**
     * Метод автоматической остановки видеозаписи тестирования.
     * Выполнение происходит только в случае успешного завершения тест-метода.
     * Поле path содержит название папки, в которой будет сохранено видео.
     *
     */
    public void stopRecordSuccess(ITestResult iTestResult) throws Exception {
        try {
            Path path = Paths.get("videoMobileSuccess");
            Files.createDirectories(path);
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "------------------------------------------------------------------------> MOBILE REC." + ConsoleColors.RESET);
            System.out.println("MobileVideoRecorder | Video from Mobile success created in dir '" + ConsoleColors.GREEN_BOLD_BRIGHT + "videoMobileSuccess" + ConsoleColors.RESET + "'.");
        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());

        }
        String base64String = driver.stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);
        String destinationPath="videoMobileSuccess/" + getTestMethodName(iTestResult) + "-Date-"+DateUtil.currentDateVideo(null)+"-Time-"+DateUtil.currentTimeVideo(null)+".mp4";
        nameToMobile = getTestMethodName(iTestResult) + "-Date-"+DateUtil.currentDateVideo(null)+"-Time-"+DateUtil.currentTimeVideo(null)+".mp4";
        Path path = Paths.get(destinationPath);
        Files.write(path, data);
        log.info("Stop recording tests.");
        attachVideo(destinationPath);
        //getNameVideoWeb();
        getNameVideoMobileSuccess();
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "<------------------------------------------------------------------------ MOBILE REC." + ConsoleColors.RESET);
    }

    /**
     * Метод автоматической остановки видеозаписи тестирования.
     * Выполнение происходит только в случае неуспешного завершения тест-метода.
     * Поле path содержит название папки, в которой будет сохранено видео.
     *
     */
    public void stopRecordFalse(ITestResult iTestResult) throws Exception {
        try {
            Path path = Paths.get("videoMobileFalse");
            Files.createDirectories(path);
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "------------------------------------------------------------------------> MOBILE REC." + ConsoleColors.RESET);
            System.out.println("MobileVideoRecorder | Video from Mobile success created in dir '" + ConsoleColors.RED_BOLD_BRIGHT + "videoMobileFalse"  + ConsoleColors.RESET + "'.");
        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());

        }
        String base64String = driver.stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);
        String destinationPath="videoMobileFalse/" + getTestMethodName(iTestResult) + "-Date-"+DateUtil.currentDateVideo(null)+"-Time-"+DateUtil.currentTimeVideo(null)+".mp4";
        nameToMobile = getTestMethodName(iTestResult) + "-Date-"+DateUtil.currentDateVideo(null)+"-Time-"+DateUtil.currentTimeVideo(null)+".mp4";
        Path path = Paths.get(destinationPath);
        Files.write(path, data);
        log.info("Stop recording tests.");
        attachVideo(destinationPath);
        //getNameVideoWeb();
        getNameVideoMobileFalse();
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "<------------------------------------------------------------------------ MOBILE REC." + ConsoleColors.RESET);
    }

    /**
     * Метод выводит в консоль название и полный путь к сохраненной видеозаписи тестирования ВЕБ части.
     * Параметр ffmpegWrapper.nameToFfmpeg заполняется в случае успешной записи веб части.
     * @throws Exception
     */
    public void getNameVideoWeb() throws Exception {
        if (FFmpegWrapper.nameToFfmpeg != null) {
            log.info("NEW VIDEO RESULT WEB: D:\\AppiumTestThread\\web_video_result\\" + FFmpegWrapper.nameToFfmpeg +".mp4");
            attachVideo("web_video_result/" + FFmpegWrapper.nameToFfmpeg + ".mp4");
        } else {
            log.info("WEB Recorder not used OR test is running on a mobile device only");
        }
    }

    /**
     * Метод выводит в консоль название и полный путь к сохраненной видеозаписи успешного тестирования мобильной части.
     */
    public void getNameVideoMobileSuccess() {
        log.info("NEW VIDEO RESULT MOBILE: /home/yana/IdeaProjects/ActualAndroidAppiumLastVer/videoMobileSuccess" + nameToMobile);
    }

    /**
     *  Метод выводит в консоль название и полный путь к сохраненной видеозаписи провального тестирования мобильной части.
     */
    public void getNameVideoMobileFalse() {
        log.info("NEW VIDEO RESULT MOBILE: /home/yana/IdeaProjects/ActualAndroidAppiumLastVer/videoMobileFalse" + nameToMobile);
    }

    /**
     * Инициализация драйверов
     */

    protected static AndroidDriver<MobileElement> driver;
    protected WebDriver webDriver;
    public String formattedDate;
    public String formattedDate2;
    public boolean usingWeb;
    public static String nameToMobile;

    /**
     * Конструктор BasePage
     */
     public BasePage() {
         if (usingWeb = true) {
             this.webDriver = ChromeWebDriver.getWebDriver();
         }
         driver = AndroidMobileDrivers.getDriver();
         this.formattedDate = DateUtil.getFormattedDate(null);
         this.formattedDate2 = DateUtil.getFormattedDate2(null);
         PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    /**
     * Метод waitToBeClickable - ожидание кликабельности элемента.
     * Входящие данные:
     * @param timeOut - ожидание кликабельности элемента в секундах.
     * @param element - локатор элемента, который ожидаем для проверки.
     * @param isFailTestIfElementNotClickable - флаг, в зависимости от которого тест будет валиться в случае если элемент не кликабелен.
     * @throws Exception
     */
    protected MobileElement waitToBeClickable (int timeOut, MobileElement element, boolean isFailTestIfElementNotClickable) throws Exception {
        try {
            new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e){
            log.error("Expected condition failed. Element not found!");
            //saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            if(isFailTestIfElementNotClickable) {
                fail(e.toString());
            } else {
                log.info("Test not failed cause isFailTestIfElementNotClickable is false.");
            }
        }
        return element;
    }

    /**
     * Метод производит свайп по экрану устройства.
     * @param startX - координата x с которой начинается движение свайпа.
     * @param startY - координата y с которой начинается движение свайпа.
     * @param endX - координата x на которой заканчивается движение свайпа.
     * @param endY - координата y на которой заканчивается движение свайпа.
     * @param msDuration - длительность выполнения свайпа.
     */
    public void swipe(int startX, int startY, int endX, int endY, int msDuration) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(msDuration)))
                .moveTo(PointOption.point(endX, endY))
                .release();

        touchAction.perform();
    }

    /**
     * Метод ожидания кликабельности элемента. Схож с предыдущим waitToBeClickable, но отсутствует параметр падения теста при отсутствии элемента.
     * @param timeOut - время, в течении которого будет выполняться поиск эдемента.
     * @param element - локатор элемента, который ищем для проверки.
     */
    protected MobileElement waitToBeClickable (int timeOut, MobileElement element){
        try {
            waitToBeClickable(timeOut, element, true);
        } catch (Exception ignore) {}
        return element;
    }

    /**
     * Метод ImplicityWait - неявное ожидание неопределенного элемента.
     * @param timeOut - время в течении которого выполняется поиск указанного элемента.
     */
    protected void implicityWait (int timeOut) {
        try {
            driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("Test failed. Time to wait is end " + e);
            //assertTrue (false);
        }
    }

    /**
     * Метод изменения ориентации устройства.
     */
    protected void rotateDevice() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
        log.info("Rotate screen orientation. Waiting 2 seconds");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.rotate(ScreenOrientation.PORTRAIT);
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод поиска элемента по отображаемому тексту в приложении.
     * @param elementText - текст, по которому будет производится поиск элемента.
     */
    protected void searchElementByText(String elementText) {
        waitToVisibilityOf(5, driver.findElementByXPath("//*[@text='"+ elementText +"']"));
        log.info("Searching element by contained text - " + elementText);
    }

    protected void searchElementByText(int timeOut, String elementText) {
        waitToVisibilityOf(timeOut, driver.findElementByXPath("//*[@text='"+ elementText +"']"));
        log.info("Searching element by contained text - " + elementText);
    }

    /**
     * Метод поиска элемента, и дальнейшего клика по нему.
     * Поиск производится по отображаемому тексту в приложении.
     * @param elementText - текст, по которому будет производится поиск элемента.
     */
    protected void searchAndClickElementByText(String elementText) {
        log.info("Searching element by contained text - " + elementText);
        implicityWait(5);
        try {
            MobileElement element = waitToBeClickable(5, driver.findElementByXPath("//*[@text='" + elementText + "']"), false);
            log.info("Element with text - " + elementText +" successfully found!");
            log.info("Click to this element.");
            element.click();
        } catch (Exception e) {
            log.info("Element is not visible now!");
        }
        implicityWait(0);
    }

    /**
     * Метод тапа по элементу.
     * @param element - локатор элемента, по которому мы тапнем.
     * @param duration - длительность тапа по элементу.
     */
    public void tap(MobileElement element, long duration) {
        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(ElementOption.element(element))).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration))).perform();
    }

    /**
     * Метод тапа по указанным координатам X and Y.
     * @param x - cord X for tap.
     * @param y - cord Y for tap
     */
    public void tapPoints(int x, int y) {
        new TouchAction(driver).press(PointOption.point(x, y)).perform();
    }

    public void pressPoints(int x, int y) {
        new TouchAction(driver).tap(PointOption.point(x, y)).perform();
    }

    /**
     * Метод ожидания отображения конкретного элемента на экране
     * @param timeOut - Время, в течении которого будет производится поиск нужного элемента.
     * @param element - локатор элемента, который нужно найти.
     * @return
     * @throws TimeoutException
     */
    protected MobileElement waitToVisibilityOf (int timeOut, MobileElement element) throws TimeoutException{
        try {
            new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            fail(e.toString());
        }
        return element;
    }

    protected void waitToVisibilityOfNoFail (int timeOut, WebElement element){
        new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitToVisibilityLocated (int timeOut, By locator){
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void isElementPresentTrueFalse(MobileElement element) {
        boolean check;
        String msg = "Element not found!";
        try {
            element.isDisplayed();
            check = true;
        } catch (NoSuchElementException e) {
            check = false;
        }
        finally {
           // implicityWait(30);
        }
        assertTrue(check, msg);

    }

    /**
     * Метод isElementPresent - присутствует ли элемент на экране. Возвращаемое значение типа boolean.
     * @param timeOut - Время проверки, отображен ли нужный элемент на экране.
     * @param element - локатор элемента, который мы проверяем.
     * @return
     */
    public boolean isElementPresent(int timeOut, MobileElement element) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        try {
            element.isDisplayed();
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            return true;
        } catch (NoSuchElementException | StaleElementReferenceException  e) {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            return false;
        }
    }


    /**
     * Скролл страницы приложения до конкретного элемента.
     * Поиск элемента выполняется по тексту в контейнере элемента.
     * При нахождении текста на странице, скролл останавливается.
     * @param driver - выбор драйвера для поиска элемента. По дефолту - driver.
     * @param text - текст, по которому будет найден нужный элемент при скролле.
     */
    public WebElement scrollToAnElementByText(AppiumDriver<MobileElement> driver, String text) {
        log.info("Scroll to element with contain text - '"+ text +"'");
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
    }

    public BasePage scrollToElementTouchActions(MobileElement element) {
        TouchActions action = new TouchActions(driver);
        action.scroll(element, 260, 525);
        action.perform();
        return this;
    }

    /**
     * Аттач скриншота приложения при падении теста в систему Allure.
     * @param screenShot
     * @return
     */
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot ( byte[] screenShot){
        return screenShot;
    }
    public void screenshot() {
        log.info("Taking a screenshot of the page.");
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
    }

    /**
     * Аттач видеозаписи тестирования приложения.
     * @param path
     * @return
     * @throws Exception
     */
    @Attachment(value = "video",type="video/mp4")
    public byte[] attachVideo(String path) throws Exception {
        return getFile(path);
    }

    public byte[] getFile(String fileName) throws Exception {
        File file = new File(fileName);
        return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
    }

    /**
     * Набор цветов консоли.
     */
    public static class ConsoleColors {
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        public static final String BLACK = "\033[0;30m";   // BLACK
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN
        public static final String YELLOW = "\033[0;33m";  // YELLOW
        public static final String BLUE = "\033[0;34m";    // BLUE
        public static final String PURPLE = "\033[0;35m";  // PURPLE
        public static final String CYAN = "\033[0;36m";    // CYAN
        public static final String WHITE = "\033[0;37m";   // WHITE

        // Bold
        public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
        public static final String RED_BOLD = "\033[1;31m";    // RED
        public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
        public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
        public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
        public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
        public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
        public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

        // Underline
        public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
        public static final String RED_UNDERLINED = "\033[4;31m";    // RED
        public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
        public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
        public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
        public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
        public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
        public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

        // Background
        public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
        public static final String RED_BACKGROUND = "\033[41m";    // RED
        public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
        public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
        public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
        public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
        public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
        public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

        // High Intensity
        public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
        public static final String RED_BRIGHT = "\033[0;91m";    // RED
        public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
        public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
        public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
        public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
        public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
        public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

        // Bold High Intensity
        public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
        public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
        public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
        public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
        public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
        public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
        public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
        public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

        // High Intensity backgrounds
        public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
        public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
        public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
        public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
        public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
        public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
        public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
        public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
    }
}
