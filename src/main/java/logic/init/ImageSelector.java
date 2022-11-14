package logic.init;


import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByImage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.Setting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import logic.hos.header.Header;
import org.apache.log4j.Logger;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ImageSelector extends BasePage {

    protected static final Logger log = Logger.getLogger(ImageSelector.class);

    @AndroidFindBy(id = projectLocator + ":id/driver_toolbar_truck")
    public MobileElement truckIcon;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.Toast")
    public MobileElement toast;
    @AndroidFindBy(xpath = "//*[@resource-id='com.example.informer:id/color_toast_image']")
    public MobileElement newToast;
    @AndroidFindBy(id = projectLocator + ":id/textView_activity_form_violation_item_row_title")
    public MobileElement violationText;


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    Header header = new Header();

    private String ImgTruck64() throws IOException {
        File file = new File("greentruck.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String findViolation() throws IOException {
        File file = new File("violation.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String ImgCountryCanada64() throws IOException {
        File file = new File("can.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String SetOfEventsOffDuty() throws IOException {
        File file = new File("BorderCrossing_OffDuty.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String SetOfEventsOnDuty() throws IOException {
        File file = new File("BorderCrossing_OnDuty.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String SetOfEventsSleep() throws IOException {
        File file = new File("BorderCrossing_Sleeper.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String SetOfEventsDriving() throws IOException {
        File file = new File("BorderCrossing_Driving.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String SetOfEventsBcWithoutOnDuty() throws IOException {
        File file = new File("BorderCrossing_WithoutOnDuty.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String SetOfEventsBcWithOnDuty() throws IOException {
        File file = new File("BorderCrossing_WithOnDuty.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String SetOfEventsLogsPage() throws IOException {
        File file = new File("LogsPage_1.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String ImgCountryUsa64() throws IOException {
        File file = null;
        switch (projectName) {
            case "TE":
                file = new File("usa.png");
                log.info("Flag for TE.");
                break;
            case "Swift":
                log.info("Flag for Swift.");
                file = new File("usa_swift.png");
                break;
            case "Trendy":
                log.info("Flag for Trendy.");
                file = new File("usa_trendy.png");
                break;
            case "Alfa":
                log.info("Flag for Alfa.");
                file = new File("usa_alfa.png");
                break;
            case "Sharp":
                log.info("Flag for Sharp.");
                file = new File("usa_sharp.png");
                break;
            case "Vista":
                log.info("Flag for Vista.");
                file = new File("usa_vista.png");
                break;
            case "Smart":
                log.info("Flag for Smart.");
                file = new File("usa_smart.png");
                break;
        }
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String CloseNotification() throws IOException {
        File file = new File("notif.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String compareGraph() throws IOException {
        File file = new File("graphTE.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String compareGraphSwift() throws IOException {
        File file = new File("graphSwift.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String compareGraphTrendy() throws IOException {
        File file = new File("graphTrendy.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String compareGraphAlfa() throws IOException {
        File file = new File("graphAlfa.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String compareGraphSharp() throws IOException {
        File file = new File("graphSharp.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String compareGraphVista() throws IOException {
        File file = new File("graphVista.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String compareGraphSmart() throws IOException {
        File file = new File("graphSmart.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String compareGraph2() throws IOException {
        File file = null;
        switch (projectName) {
            case "TE":
                file = new File("graph2.png");
                log.info("BC Graph for TE.");
                break;
            case "Swift":
                log.info("BC Graph for Swift.");
                file = new File("graph2Swift.png");
                break;
            case "Trendy":
                log.info("BC Graph for Trendy.");
                file = new File("graph2Trendy.png");
                break;
            case "Alfa":
                log.info("BC Graph for Alfa.");
                file = new File("graph2Alfa.png");
                break;
            case "Sharp":
                log.info("BC Graph for Sharp.");
                file = new File("graph2Sharp.png");
                break;
            case "Vista":
                log.info("BC Graph for Vista.");
                file = new File("graph2Vista.png");
                break;
            case "Smart":
                log.info("BC Graph for Smart.");
                file = new File("graph2Smart.png");
                break;
        }
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String compareBcWithoutOnDuty() throws IOException {
        File file = new File("graph3.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String compareBcWithOnDuty() throws IOException {
        File file = new File("graph4.png");
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String Toast(String toastPath) throws IOException {
        File file = new File(toastPath);
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    private String ImageFinder(String toastPath) throws IOException {
        File file = new File(toastPath);
        File refImgFile = Paths.get(file.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    @Step("Check toast Truck Number empty displayed.")
    public void truckNumber() throws IOException {
        log.info("Try to find toast Truck Number empty.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/trucknumber.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Truck Number empty) found! Position: " + cords);
    }

    @Step("Check toast Truck License Number empty displayed.")
    public void licenseNumberEmpty() throws IOException {
        log.info("Try to find toast Truck License Number empty.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/licenseEmpty.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Truck License Number empty) found! Position: " + cords);
    }

    @Step("Check toast Fuel Type mpty displayed.")
    public void fuelTypeEmpty() throws IOException {
        log.info("Try to find toast Fuel Type empty.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/fueltype.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Fuel Type empty) found! Position: " + cords);
    }

    @Step("Check toast Vin Number empty displayed.")
    public void vinNumber() throws IOException {
        log.info("Try to find toast Vin Number empty.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/vinempty.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Vin Number empty) found! Position: " + cords);
    }

    @Step("Check toast Vin Number Wrong displayed(higher).")
    public void wrongVinNumberHigher() throws IOException {
        log.info("Try to find toast Vin Number Wrong.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/forbiddenvin.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Vin Number Wrong) found! Position: " + cords);
    }

    @Step("Check toast Vin Number Wrong displayed (less).")
    public void wrongVinNumberLess() throws IOException {
        log.info("Try to find toast Vin Number Wrong.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/forbiddenvinless.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Vin Number Wrong) found! Position: " + cords);
    }

    @Step("Check toast Location IR required.")
    public void locationIR() throws IOException {
        log.info("Try to find toast Location IR.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/irlocation.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Inspection Report location) found! Position: " + cords);
    }

    @Step("Check toast Odometer IR required.")
    public void odometerIR() throws IOException {
        log.info("Try to find toast Odometer IR.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/irodometer.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Inspection Report Odometer) found! Position: " + cords);
    }

    @Step("Check toast Trailer Number IR required.")
    public void trailerNumberIR() throws IOException {
        log.info("Try to find toast Trailer Number IR.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/irtrailernumber.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Inspection Report Trailer Number) found! Position: " + cords);
    }

    @Step("Check toast Trailer License IR required.")
    public void trailerLicenseIR() throws IOException {
        log.info("Try to find toast Trailer License IR.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/irtrailerlicense.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Inspection Report Trailer License) found! Position: " + cords);
    }

    @Step("Search inspection report on graph.")
    public ImageSelector InspectionReportOnGraph() throws IOException {
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.7);
        implicityWait(6);
        MobileElement ir = driver.findElementByImage(ImageFinder("IR.png"));
        implicityWait(0);
        ir.click();
        Point cords = ir.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Inspection report on graph found! Position: " + cords);
        return this;
    }

    @Step("Search Sleeper event on Wheel.")
    public ImageSelector sleperEventWheel() throws IOException {
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement sleeper = driver.findElementByImage(ImageFinder("sleeperWheelSams.png"));
        implicityWait(0);
        log.info("Event Sleeper on Wheel found!");
        sleeper.click();
        return this;
    }

    @Step("Search Off-Duty event on Wheel.")
    public ImageSelector offDutyEventWheel() throws IOException {
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement sleeper = driver.findElementByImage(ImageFinder("offdutyWheel.png"));
        implicityWait(0);
        log.info("Event Off-Duty on Wheel found!");
        sleeper.click();
        return this;
    }

    @Step("Search OnDuty event on Wheel.")
    public ImageSelector onDutyEventWheel() throws IOException {
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.6);
        implicityWait(15);
        MobileElement onduty = driver.findElementByImage(ImageFinder("ondutyWheelSams.png"));
        implicityWait(0);
        log.info("Event On-Duty on Wheel found!");
        onduty.click();
        return this;
    }

    @Step("Search Image Truck Icon.")
    public ImageSelector checkTruckConnected() throws IOException {
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        waitToVisibilityOf(60, truckIcon);
        waitToBeClickable(10, truckIcon);
        log.info("Waiting to truck icon!");
        implicityWait(10);
        MobileElement truckIconFind = driver.findElementByImage(ImgTruck64());
        implicityWait(0);
        log.info("Truck connected successfully!");
        //truckIconFind.click();
        return this;
    }

    @Step("Search Image Canada Country Flag.")
    public ImageSelector findCountryIconCanada() throws IOException {
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.7);
        waitToVisibilityOf(5, header.countryFlag);
        waitToBeClickable(5, header.countryFlag);
        log.info("Try to find flag Canada!");
        implicityWait(10);
        MobileElement countryCanIcon = driver.findElementByImage(ImgCountryCanada64());
        implicityWait(0);
        log.info("Flag country (Canada) and rules match!");
        return this;
    }

    @Step("Search Image USA Country Flag.")
    public ImageSelector findCountryIconUsa() throws IOException {
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.7);
        waitToVisibilityOf(5, header.countryFlag);
        waitToBeClickable(5, header.countryFlag);
        log.info("Try to find flag USA!");
        implicityWait(8);
        MobileElement countryUsaIcon = driver.findElementByImage(ImgCountryUsa64());
        implicityWait(0);
        log.info("Flag country (USA) and rules match!");
        return this;
    }

    @Step("Check toast Company Name required.")
    public void companyNameToast() throws IOException {

        log.info("Try to find toast company name.");
//          isElementPresent(300, newToast);
//          String toastText = "Enter your company name!";
//          Assert.assertEquals(newToast.getText(), toastText);
//          String text = newToast.getText();
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8 );
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/company.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Company name) found! Position: " + cords);
    }

    @Step("Check toast USDOT Number required.")
    public void usDotToast() throws IOException {
        log.info("Try to find toast USDOT.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/usdot.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (USDOT) found! Position: " + cords);
    }

    @Step("Check toast Long License.")
    public void longLicenseToast() throws IOException {
        log.info("Try to find toast USDOT.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/longlicense.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Long License) found! Position: " + cords);
    }

    @Step("Check toast MC Number required.")
    public void mcNumberToast() throws IOException {
        log.info("Try to find toast MC Number.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/mcnumber.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (MC Number) found! Position: " + cords);
    }

    @Step("Check toast First Name required.")
    public void firstNameToast() throws IOException {
        log.info("Try to find toast First Name.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/firstname.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (First name) found! Position: " + cords);
    }

    @Step("Check toast Last Name required.")
    public void lastNameToast() throws IOException {
        log.info("Try to find toast Last Name.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/lastname.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Last name) found! Position: " + cords);
    }

    @Step("Check toast Email required.")
    public void emailToast() throws IOException {
        log.info("Try to find toast Email.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/mail.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Email) found! Position: " + cords);
    }

    @Step("Check toast Password required.")
    public void passToast() throws IOException {
        log.info("Try to find toast Password.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/pass.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Password) found! Position: " + cords);
    }

    @Step("Check toast Confirm password required.")
    public void confPassToast() throws IOException {
        log.info("Try to find toast Confirm password.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/confirmpass.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Confrirm password) found! Position: " + cords);
    }

    @Step("Check toast License required.")
    public void licenseToast() throws IOException {
        log.info("Try to find toast License.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/license.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (License) found! Position: " + cords);
    }

    @Step("Check toast Organization pin required.")
    public void orgPinToast() throws IOException {
        log.info("Try to find toast Organization pin.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/pin.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Org. Pin) found! Position: " + cords);
    }

    @Step("Check toast Password < 8 symbols.")
    public void smallPass() throws IOException {
        log.info("Try to find toast Password < 8 symbols.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/smallpass.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Password is too small) found! Position: " + cords);
    }

    @Step("Check toast Same License.")
    public void sameLicense() throws IOException {
        log.info("Try to find toast Same License.");
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        implicityWait(10);
        MobileElement element = driver.findElementByImage(Toast("oldtoasts/samelicense.png"));
        implicityWait(0);
        Point cords = element.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Toast (Same license) found! Position: " + cords);
    }

    @Step("Check if rules changed with function Only USA Drivers.")
    public ImageSelector changeRulesOnlyUsa() throws IOException {
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        waitToVisibilityOf(28, header.countryFlag);
        waitToBeClickable(28, header.countryFlag);
        log.info("Try to find flag USA!");
        MobileElement countryUsaIcon = driver.findElementByImage(ImgCountryUsa64());
        implicityWait(0);
        log.info("Flag country USA found! Rules not changed.");
        return this;
    }

    @Step("Check set of events on logs page")
    public ImageSelector checkSetEventsLogsPage(String set) throws IOException {
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        log.info("Try to find set of events!");
        implicityWait(10);
        switch (set) {
            case "1":
                MobileElement setOfEvents = driver.findElementByImage(SetOfEventsLogsPage());
                break;
        }

        implicityWait(0);
        log.info("Set of Events found!");
        return this;
    }

    @Step("Check set of events on log page.")
    public ImageSelector checkSetEventsBC(String set) throws IOException {
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        log.info("Try to find set of events!");
        switch (set) {
            case "1": MobileElement setOfEventsOff = driver.findElementByImage(SetOfEventsOffDuty());
            break;
            case "2": MobileElement setOfEventsOn = driver.findElementByImage(SetOfEventsOnDuty());
            break;
            case "3": MobileElement setOfEventsSb = driver.findElementByImage(SetOfEventsSleep());
            break;
            case "4": MobileElement setOfEventsDr = driver.findElementByImage(SetOfEventsDriving());
            break;
            case "5": MobileElement setOfEventsBcWithoutOnDuty = driver.findElementByImage(SetOfEventsBcWithoutOnDuty());
            break;
            case "6": MobileElement setOfEventsBcWithOnDuty = driver.findElementByImage(SetOfEventsBcWithOnDuty());
            break;
        }

        implicityWait(0);
        log.info("Set of Events found!");
        return this;
    }

    @Step("Check if rules changed with function Only USA Drivers.")
    public ImageSelector compareGraphEvents() throws IOException {
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.89);
        log.info("Try to find and compare event graph!");
        MobileElement graph = null;
        switch (projectName) {
            case "TE":
                graph = driver.findElementByImage(compareGraph());
                break;
            case "Swift":
                graph = driver.findElementByImage(compareGraphSwift());
                break;
            case "Trendy":
                graph = driver.findElementByImage(compareGraphTrendy());
                break;
            case "Alfa":
                graph = driver.findElementByImage(compareGraphAlfa());
                break;
            case "Sharp":
                graph = driver.findElementByImage(compareGraphSharp());
                break;
            case "Vista":
                graph = driver.findElementByImage(compareGraphVista());
                break;
            case "Smart":
                graph = driver.findElementByImage(compareGraphSmart());
                break;
        }
        Point cords = graph.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Graph found and compare! Cords: " + cords);
        return this;
    }

    @Step("Check displayed BC on Graph.")
    public ImageSelector compareGraphBC() throws IOException {
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.90);
        driver.setSetting(Setting.GET_MATCHED_IMAGE_RESULT, true);
        log.info("Try to find and compare BC graph!");
        MobileElement graph = driver.findElementByImage(compareGraph2());
        log.info("Graph compare on " + graph.getAttribute("score") + " score");
        Point cords = graph.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Graph found and compare! Cords: " + cords);
        return this;
    }

    @Step("Check displayed BC on Graph.")
    public ImageSelector compareGraphBCWithoutOnDuty() throws IOException {
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.90);
        driver.setSetting(Setting.GET_MATCHED_IMAGE_RESULT, true);
        log.info("Try to find and compare BC without On-Duty on graph!");
        MobileElement graph = driver.findElementByImage(compareBcWithoutOnDuty());
        log.info("Graph compare on " + graph.getAttribute("score") + " score");
        Point cords = graph.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Graph found and compare! Cords: " + cords);
        return this;
    }

    @Step("Check displayed BC on Graph.")
    public ImageSelector compareGraphBCWithOnDuty() throws IOException {
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.90);
        driver.setSetting(Setting.GET_MATCHED_IMAGE_RESULT, true);
        log.info("Try to find and compare BC with On-Duty on graph!");
        MobileElement graph = driver.findElementByImage(compareBcWithOnDuty());
        log.info("Graph compare on " + graph.getAttribute("score") + " score");
        Point cords = graph.getCenter();
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Graph found and compare! Cords: " + cords);
        return this;
    }

    @Step("Check displayed BC on Graph.")
    public ImageSelector findAllViolations() throws IOException {
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.78);
        log.info("Try to find all violations!");
        List<MobileElement> elementsOne = driver.findElementsByImage(findViolation());
        for (MobileElement violation : elementsOne) {
            log.info(violation.getAttribute("score"));
            log.info("Number of violation: "+((elementsOne.indexOf(violation))+1));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            violation.click();
            waitToVisibilityOf(5, violationText);
            saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            log.info("Violation found!");
            log.info("Text in violation - " + violationText.getText());
            header.backMenu();
            waitToVisibilityOf(5, header.mainMenuBtn);
        }
        return this;
    }

}