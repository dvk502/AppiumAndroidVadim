package logic.settingsPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import logic.hos.header.Header;

import logic.init.BasePage;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class Settings extends BasePage {

    protected static final Logger log = Logger.getLogger(Settings.class);
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]")
    public static MobileElement currentDriverProfile;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]")
    public static MobileElement logoutCurrentDriverButton;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]")
    public static MobileElement currentDriverName;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.TextView[2]")
    public static MobileElement coDriverName;
    @AndroidFindBy (xpath = "//*[@text='Permissions']")
    public static MobileElement permissionsButton;

    String nameCoDriver;

    @Step("Open permissions page")
    public Settings openPermPage() {
        waitToVisibilityOf(10, permissionsButton);
        permissionsButton.click();
        log.info("Open Permissions page.");
        return this;
    }


    @Step("Open Current driver profile in settings")
    public Settings openCurrentDriverProfile(boolean coDriverUse) {
        if (coDriverUse==true) {
            waitToVisibilityOf(5, coDriverName);
            nameCoDriver = coDriverName.getText();
        }
        waitToVisibilityOf(5, currentDriverProfile);
        currentDriverProfile.click();
        log.info("Open Current driver profile in settings.");
        return this;
    }

    @Step("Logout Current Driver in settings")
    public Settings logoutCurrentDriverInSettings() throws InterruptedException {
        Header header = new Header();
        waitToVisibilityOf(5, logoutCurrentDriverButton);
        waitToBeClickable(5, logoutCurrentDriverButton);
        logoutCurrentDriverButton.click();
        log.info("Logout Current Driver in settings.");
        waitToVisibilityOf(5, header.confirmBtn);
        header.confirmBtn.click();
        /*waitToVisibilityOf(5, header.fieldNewLogout);
        log.info("We check the notification about the presence of problems with the Internet");
        header.fieldNewLogout.getText().equals("Internet");
        log.info("There are no problems with the Internet");
        header.okButtonLogout.click();
        log.info("Press the OK button to go to the next check");
        waitToVisibilityOf(2, header.fieldNewLogout);
        log.info("We check the notification about the presence of problems with the Events");
        header.fieldNewLogout.getText().equals("Current event valid");
        log.info("There are no problems with the Events");
        header.okButtonLogout.click();
        log.info("Press the OK button to go to the next check");
        waitToVisibilityOf(2, header.fieldNewLogout);
        log.info("We check the notification about the presence of a connection to the track");
        header.fieldNewLogout.getText().equals("Disconnect from Truck");
        log.info("No connection to the track");
        header.okButtonLogout.click();
        log.info("Press the OK button to go to the next check");
        log.info("Checking for non-certified days");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (isElementPresent(2, header.fieldNewLogout)) {
            if (header.fieldNewLogout.getText().equals("You don`t need to do certification")) {
                log.info("There are no non-certified days, no certification is required, everything is fine.");
                header.okButtonLogout.click();
            }
        } else {
            log.info("There are uncertified days, right now we will certify.");
            header.certifyRecords.click();
            log.info("Try to click on Certificate button without choose days for certification.");
            Thread.sleep(1000);
            for (MobileElement element : header.certifications) {
                element.click();
                log.info("We certify the day: " + element.getText());
            }
            waitToVisibilityOf(8, header.certifyRecords);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            header.certifyRecords.click();
            if (isElementPresent(1, header.certifyRecords)) {
                for (MobileElement element : header.certifications) {
                    element.click();
                    log.info("We certify the day: " + element.getText());
                }
                header.certifyRecords.click();
                waitToVisibilityOf(5, header.okButtonLogout);
            }
//            waitToVisibilityOf(8, confirmBtn);
//            waitToBeClickable(8, confirmBtn);
//            while (isElementPresent(1, confirmBtn)) {
//                confirmBtn.click();
//            }
            while (isElementPresent(1, header.okButtonLogout)) {
                log.info("All days are certified, we log out.");
                waitToVisibilityOf(8, header.okButtonLogout);
                waitToBeClickable(8, header.okButtonLogout);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                header.okButtonLogout.click();
            }*/
        try {
            log.info("Checking for non-certified days");
            waitToBeClickable(7, header.certifyRecords, false);
            log.info("Internet OK");
            log.info("Events OK");
            log.info("Truck OK");
            log.info("There are uncertified days, right now we will certify.");
            header.certifyRecords.click();
            log.info("Try to click on Certificate button without choose days for certification.");
            while (isElementPresent(1, header.certifyRecords)) {
                for (MobileElement element : header.certificationsDate) {
                    element.click();
                    log.info("We certify the day: " + element.getText());
                }
                header.certifyRecords.click();
            }
        } catch (Exception e) {
            log.info("Internet OK");
            log.info("Events OK");
            log.info("Truck OK");
            log.info("There are no non-certified days, everything is fine.");
        }
        return this;
    }

    @Step("Checking that the co-driver has become the current driver")
    public Settings checkCurrentDriver() {
        log.info("Checking that the co-driver has become the current driver.");
        Assert.assertEquals(currentDriverName.getText(), nameCoDriver);
        log.info("After logout Current Driver, Co-Driver became Current driver.");
        Header header = new Header();
        log.info("Return to the main menu.");
        header.navigateUp.click();
        return this;
    }
}
