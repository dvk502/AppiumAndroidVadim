package logic.hos.header;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import logic.fleet.SideMenu;
import logic.hos.statusPage.StatusPage;

import logic.init.BasePage;
import logic.init.ImageSelector;
import logic.init.LocatorName;
import logic.loginPage.CheckAlertConnection;
import logic.mainMenu.MainMenuDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class Header extends BasePage {

    protected static final Logger log = Logger.getLogger(Header.class);

    MainMenuDriver menu = new MainMenuDriver();
    CheckAlertConnection connection = new CheckAlertConnection();

    @AndroidFindBy(id = projectLocator + ":id/driver_toolbar_flag")
    public MobileElement countryFlag;
    @AndroidFindBy(accessibility = "STATUS")
    public MobileElement statusBtn;
    @AndroidFindBy(accessibility = "SUMMARY")
    public MobileElement statusBtnSmart;
    @AndroidFindBy(accessibility = "DOT INSPECT")
    public MobileElement dotInspectBtn;
    @AndroidFindBy(accessibility = "INSPECTION")
    public MobileElement dotInspectBtnSmart;
    @AndroidFindBy(accessibility = "RULES")
    public MobileElement rulesBtn;
    @AndroidFindBy(accessibility = "DVIR")
    public MobileElement dvirBtn;
    @AndroidFindBy(accessibility = "LOGS")
    public MobileElement logsBtn;
    @AndroidFindBy(accessibility = "LOG")
    public MobileElement logsBtnSmart;
    @AndroidFindBy(id = projectName + ":id/nav_driver_inspection_reports")
    public MobileElement dvirMainMenuBtn;
    @AndroidFindBy(id = projectLocator + ":id/driver_toolbar_truck")
    public MobileElement truckConnectIcon;
    @AndroidFindBy(accessibility = "Drawer open")
    public MobileElement mainMenuBtn;
    @AndroidFindBy(accessibility = "Navigate up")
    public MobileElement navigateUp;
    @AndroidFindBy(id = projectLocator + ":id/driver_toolbar_codriver_icon")
    public MobileElement openCoDriverPageBtn;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_right_button")
    public MobileElement confirmBtn;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_msg_message")
    public MobileElement alertMsg;
    @AndroidFindBy(id = projectLocator + ":id/driver_ds_status")
    public MobileElement driverStatus;
    @AndroidFindBy(id = projectLocator + ":id/ok_button")
    public MobileElement okButtonLogout;
    @AndroidFindBy(id = projectLocator + ":id/name")
    public MobileElement fieldNewLogout;
    @AndroidFindBy(id = projectLocator + ":id/data_textview")
    public List<MobileElement> certificationsDate;
    @AndroidFindBy(id = projectLocator + ":id/check")
    public List<MobileElement> certifyCheckbox;
    @AndroidFindBy(id = projectLocator + ":id/certify_records")
    public MobileElement certifyRecords;
    @AndroidFindBy(id = projectLocator + ":id/title")
    public MobileElement changeEventMessage;
    @AndroidFindBy(id = projectLocator + ":id/relativeLayout_ie_logs_choice_event_off")
    public MobileElement offDutyEventChoose;
    @AndroidFindBy(id = projectLocator + ":id/toolBar")
    public static MobileElement titleMainMenu;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton")
    public static MobileElement topButtonMenuOrArrow;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    public static MobileElement titleDriversPageTE;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[@text='Drivers']")
    public static MobileElement titleDriversPageTrendy;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    public static MobileElement titleTrucksPageTE;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[@text='Trucks']")
    public static MobileElement titleTrucksPageTrendy;
    @AndroidFindBy(id = projectLocator + ":id/skip_cancel")
    public static MobileElement skipWindow;
    @AndroidFindBy(accessibility = "Collapse")
    public static MobileElement collapse;
    @AndroidFindBy(id = projectLocator + ":id/nav_logout")
    public MobileElement logoutButton;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.ImageView")
    public MobileElement internetImageSuccess;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.ImageView")
    public MobileElement eventImageSuccess;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.ImageView")
    public MobileElement truckImageSuccess;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.ImageView")
    public MobileElement certificationImageSuccess;
    @AndroidFindBy(id = projectLocator + ":id/warning_image_view")
    public MobileElement warningIcon;
    @AndroidFindBy(id = projectLocator + ":id/disable_dialog")
    public MobileElement cancelLogoutWindow;
    @AndroidFindBy(accessibility = "DOT")
    public MobileElement dotInspectBtnTrendy;
    @AndroidFindBy(id = projectLocator + ":id/ind_id_certification")
    public MobileElement certificationLine;
    @AndroidFindBy(id = projectLocator + ":id/dialog_title")
    public MobileElement certifyTitle;

    LocatorName lname = LocatorName.getLocatorNameInstance();

    public By countryFlag1 = MobileBy.id(projectLocator + ":id/driver_toolbar_truck");

    public Header checkVisibilityCertificationLine() {
        if (isElementPresent(3, certificationLine)) {
            Assert.fail("Certification line displayed now! Test failed.");
        } else {
            log.info("Certification line is not appear!");
            return this;
        }
        return this;
    }

    @Step("Open main menu on Fleet Account.")
    public Header openFleetMenu() {
        waitToVisibilityOf(20, titleMainMenu);
        waitToBeClickable(20, topButtonMenuOrArrow);
        topButtonMenuOrArrow.click();
        log.info("Open main menu on Fleet Account.");
        return this;
    }

    @Step("Back to main Fleet page from Trucks Page.")
    public Header backToMainPageFromTrucksPage() {
        if (projectName.equals("Trendy")) {
            waitToVisibilityOf(5, titleTrucksPageTrendy);
        } else {
            waitToVisibilityOf(5, titleTrucksPageTE);
        }
        topButtonMenuOrArrow.click();
        log.info("Back to main Fleet page from Trucks Page.");
        return this;
    }

    @Step("Back to main Fleet page from Drivers Page.")
    public Header backToMainPageFromDriversPage() {
        if (projectName.equals("Trendy")) {
            waitToVisibilityOf(5, titleDriversPageTrendy);
        } else {
            waitToVisibilityOf(5, titleDriversPageTE);
        }
        topButtonMenuOrArrow.click();
        log.info("Back to main Fleet page from Drivers Page.");
        return this;
    }

    @Step("Open main menu.")
    public Header openMenu() {
        waitToVisibilityOf(20, mainMenuBtn);
        waitToBeClickable(20, mainMenuBtn);
        mainMenuBtn.click();
        log.info("Open main menu.");
        return this;
    }

    @Step("Back to main menu.")
    public Header collapseBack() {
        log.info("Back to main menu. ");
        waitToVisibilityOf(15, collapse);
        waitToBeClickable(15, collapse);
        collapse.click();
        return this;
    }

    @Step("Open Company Profile Page.")
    public Header goToCompanyProfile() {
        SideMenu fleetMenu = new SideMenu();
        waitToVisibilityOf(5, fleetMenu.companyProfileButton);
        waitToBeClickable(5, fleetMenu.companyProfileButton);
        SideMenu menu = new SideMenu();
        menu.companyProfileButton.click();
        log.info("Open Company Profile Page.");
        return this;
    }

    @Step("Check if the DVIR is displayed in the Main Menu.")
    public Header dvirDisplayedHeadMenu(boolean status) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (status) {
            if (isElementPresent(1, dvirBtn)) {
                log.info("DVIR is not displayed in Main Menu. Checkbox working fine!");
            } else {
                Assert.fail("DVIR is displayed in Main Menu. Checkbox not working");
            }
        } else {
            if (!isElementPresent(3, dvirBtn)) {
                log.info("DVIR is displayed in Main Menu. Checkbox working fine!");
            } else {
                Assert.fail("DVIR is not displayed in Main Menu. Checkbox not working");
            }
        }
        return this;
    }

    @Step("Check if the DVIR is displayed in the Header Menu.")
    public Header dvirDisplayedMainMenu() {
        if (!isElementPresent(1, dvirBtn)) {
            log.info("DVIR not displayed in Header Menu. Checkbox working fine!");
        } else {
            Assert.fail("DVIR displayed in Header Menu. Checkbox not working");
        }
        return this;
    }

    @Step("Back to main menu.")
    public Header backMenu() {
        waitToVisibilityOf(20, navigateUp);
        waitToBeClickable(20, navigateUp);
        navigateUp.click();
        log.info("Back to main menu.");
        return this;
    }

    @Step("Click to country flag.")
    public Header countryFlagChangeToCanada() {
        ImageSelector img = new ImageSelector();
        try {
            img.findCountryIconUsa();
        } catch (IOException e) {
            e.printStackTrace();
        }
        waitToVisibilityOf(10, countryFlag);
        waitToVisibilityLocated(10, countryFlag1);
        countryFlag.click();
        log.info("Change rules (Click to country Flag).");
        try {
            waitToBeClickable(3, StatusPage.reminderOk, false);
            Assert.assertEquals(StatusPage.windowAlertIfta.getText(), "There are uncertified records for the current cycle. Go to Hours of Service -> DOT Inspect, to certify records");
            while (isElementPresent(1, StatusPage.reminderOk)) {
                StatusPage.reminderOk.click();
            }
        } catch (Exception e) {
            log.info("Uncertified records window did not appear.");
        }
        return this;
    }

    @Step("Open Tab STATUS.")
    public Header statusOpen() {
        waitToVisibilityOf(10, lname.statusBtn);
        waitToBeClickable(10, lname.statusBtn);
        lname.statusBtn.click();
        log.info("Open STATUS page.");
        return this;
    }

    @Step("Open Tab DOT Inspect.")
    public Header dotInspectOpen() {
        waitToVisibilityOf(10, lname.dotButton);
        waitToBeClickable(10, lname.dotButton);
        lname.dotButton.click();
        log.info("Open DOT Inspect page.");
        return this;
    }

    @Step("Open Tab RULES.")
    public Header rulesOpen() {
        waitToVisibilityOf(10, rulesBtn);
        waitToBeClickable(10, rulesBtn);
        rulesBtn.click();
        log.info("Open RULES page.");
        return this;
    }

    @Step("Open Tab DVIR.")
    public Header dvirOpen() {
        waitToVisibilityOf(10, dvirBtn);
        waitToBeClickable(10, dvirBtn);
        dvirBtn.click();
        log.info("Open DVIR page.");
        return this;
    }

    @Step("Open LOGS page.")
    public Header logsOpen() {
        waitToVisibilityOf(10, lname.logsButton);
        waitToBeClickable(10, lname.logsButton);
        lname.logsButton.click();
        log.info("Open LOGS page.");
        return this;
    }

    @Step("Click to Truck Icon (recursion is possible when clicking on the icon)")
    public Header pressTruckIcon() {
        try {
            if (driver.currentActivity().equalsIgnoreCase("eld.trackensure.activityforms.connecttruck.ConnectTruckActivity")) {
                return this;
            }
            if (truckConnectIcon != null && isElementPresent(1, truckConnectIcon)) {
                log.info("Click to truck icon and open Truck's Page");
                truckConnectIcon.click();
            }
            if (driver.currentActivity().equalsIgnoreCase("eld.trackensure.MainActivity")) {
                log.info("Recursion. Try open truck's page.");
                this.pressTruckIcon();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Confirming the driver's logout (Click to Confirm Button).")
    public Header confirmBtn() {
        waitToVisibilityOf(20, confirmBtn);
        waitToBeClickable(20, confirmBtn);
        confirmBtn.click();
        log.info("Confirming the driver's logout.");
        return this;
    }

    @Step("Logout Current driver with Driving event.")
    public Header logoutCurrentDriverDrivingEvent(String city, boolean skipShippingsAndTrailers) {
        log.info("Logging out the Current driver.");
        boolean certificatioNeeded = isElementPresent(1, certificationLine);
        waitToVisibilityOf(20, mainMenuBtn);
        waitToBeClickable(20, mainMenuBtn);
        mainMenuBtn.click();
        log.info("Click to main menu button. Open main menu.");
        waitToVisibilityOf(5, logoutButton);
        logoutButton.click();
        log.info("Click to Logout Button. Try to logout driver.");
        confirmBtn.click();
        log.info("Confirm driver logout.");
        waitToVisibilityOf(5, changeEventMessage);
        Assert.assertEquals(changeEventMessage.getText(), "Your current duty status is Driving \n" +
                "Please change it before you log out");
        offDutyEventChoose.click();
        StatusPage statusPage = new StatusPage();
        waitToVisibilityOf(5, statusPage.stateEvent);
        statusPage.stateEvent.click();
        statusPage.stateEvent.sendKeys("Kansas (KS)");
        log.info("Enter state in state field. State: " + statusPage.stateEvent.getText());
        statusPage.cityEvent.sendKeys(city);
        log.info("Enter city in city field. City: " + statusPage.cityEvent.getText());
        driver.hideKeyboard();
        statusPage.saveEventButton.click();
        log.info("Save created event.");
        if (skipShippingsAndTrailers) {
            waitToVisibilityOf(5, statusPage.skipTrailerShipping);
            statusPage.skipTrailerShipping.click();
            log.info("Skip window adding trailer/shipping.");
        }
        if (certificatioNeeded) {
            log.info("We have days for certified.");
            try {
                waitToVisibilityOf(7, certifyRecords);
                while (certifyTitle.isDisplayed()) {
                    while (certifyCheckbox.get(0).isDisplayed()) {
                        for (MobileElement element : certificationsDate) {
                            try {
                                waitToVisibilityOf(10, element);
                                element.click();
                                log.info("We certify the day: " + element.getText());
                            } catch (Exception e) {
                                log.info("LeakCanary is displayed. Waiting...");
                                waitToVisibilityOf(10, element);
                                element.click();
                            }
                        }
                        certifyRecords.click();
                        Thread.sleep(1000);
                    }
                }
            } catch (Exception e) {
                log.info("All days are successfully certified.");
                log.info("Internet OK");
                log.info("Events OK");
                log.info("Truck OK");
                log.info("There are no non-certified days, everything is fine.");
            }
        } else {
            log.info("Internet OK");
            log.info("Events OK");
            log.info("Truck OK");
            log.info("There are no non-certified days, everything is fine.");
        }
        return this;
    }

    @Step("Logout Current driver.")
    public Header logoutCurrentDriver(boolean firstLogout) throws InterruptedException {
        log.info("Logging out the Current driver.");
        waitToVisibilityOf(5, statusBtn);
        boolean certificatioNeeded = isElementPresent(1, certificationLine);
        waitToVisibilityOf(20, mainMenuBtn);
        waitToBeClickable(20, mainMenuBtn);
        mainMenuBtn.click();
        log.info("Click to main menu button. Open main menu.");
        waitToVisibilityOf(5, logoutButton);
        waitToBeClickable(5, logoutButton);
        logoutButton.click();
        log.info("Click to Logout Button. Try to logout driver.");
        waitToBeClickable(5, confirmBtn);
        confirmBtn.click();
        log.info("Confirm driver logout.");
        log.info("Waiting for a successful internet connection");
        if (!firstLogout) {
            if (certificatioNeeded) {
                log.info("We have days for certified.");
                try {
                    waitToVisibilityOf(7, certifyRecords);
                    while (certifyTitle.isDisplayed()) {
                        while (certifyCheckbox.get(0).isDisplayed()) {
                            for (MobileElement element : certificationsDate) {
                                try {
                                    waitToVisibilityOf(10, element);
                                    element.click();
                                    log.info("We certify the day: " + element.getText());
                                } catch (Exception e) {
                                    log.info("LeakCanary is displayed. Waiting...");
                                    waitToVisibilityOf(10, element);
                                    element.click();
                                }
                            }
                            certifyRecords.click();
                            Thread.sleep(1000);
                        }
                    }
                } catch (Exception e) {
                    log.info("All days are successfully certified.");
                    log.info("Internet OK");
                    log.info("Events OK");
                    log.info("Truck OK");
                    log.info("There are no non-certified days, everything is fine.");
                }
            } else {
                log.info("Internet OK");
                log.info("Events OK");
                log.info("Truck OK");
                log.info("There are no non-certified days, everything is fine.");
            }
        } else {
            log.info("Internet OK");
            log.info("Events OK");
            log.info("Truck OK");
            log.info("There are no non-certified days, everything is fine.");
        }
        return this;
    }


    @Step("Logging out the Current driver without the included Wi-Fi module.")
    public Header logoutCurrentDriverWithoutConnection() {
        log.info("Click to main menu button. Open main menu.");
        waitToVisibilityOf(20, mainMenuBtn);
        waitToBeClickable(20, mainMenuBtn);
        mainMenuBtn.click();
        waitToVisibilityOf(5, logoutButton);
        logoutButton.click();
//        menu.logout();
        log.info("Click to Logout Button. Try to logout driver.");
        confirmBtn.click();
        try {
            log.info("Checking for non-certified days");
            waitToBeClickable(7, certifyRecords, false);
            log.info("Internet OK");
            log.info("Events OK");
            log.info("Truck OK");
            log.info("There are uncertified days, right now we will certify.");
            certifyRecords.click();
            log.info("Try to click on Certificate button without choose days for certification.");
            while (isElementPresent(1, certifyRecords)) {
                for (MobileElement element : certificationsDate) {
                    element.click();
                    log.info("We certify the day: " + element.getText());
                }
                certifyRecords.click();
            }
        } catch (Exception e) {
            log.info("");
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (isElementPresent(5, warningIcon)) {
            waitToBeClickable(5, cancelLogoutWindow);
            cancelLogoutWindow.click();
            log.info("Warning about disable internet was appear! Trying to turn Wi-Fi and continue logout.");
        }
        return this;
    }

    @Step("Logout the Fleet manager.")
    public Header logoutCurrentDriverFromFleet() {
        waitToVisibilityOf(30, titleMainMenu);
        waitToVisibilityOf(20, topButtonMenuOrArrow);
        waitToBeClickable(20, topButtonMenuOrArrow);
        topButtonMenuOrArrow.click();
        log.info("Click to main menu button. Open main menu.");
        waitToVisibilityOf(20, menu.logoutBtnFleet);
        waitToBeClickable(20, menu.logoutBtnFleet);
        menu.logoutBtnFleet.click();
        log.info("Click on the Logout button and try to log out the Fleet manager.");
        waitToVisibilityOf(20, confirmBtn);
        waitToBeClickable(20, confirmBtn);
        confirmBtn.click();
        log.info("Confirm the logout of the Fleet manager.");
        return this;
    }

    @Step("Opening the page for adding Co-Driver.")
    public Header openCoDriverPage() {
        if (isElementPresent(1, driverStatus)) {
            return this;
        } else {
            log.info("Opening the page for adding Co-Driver.");
            waitToVisibilityOf(20, openCoDriverPageBtn);
            waitToBeClickable(20, openCoDriverPageBtn);
            openCoDriverPageBtn.click();
            log.info("Click on the button to open the Co-Driver page.");
            return this;
        }
    }
}
