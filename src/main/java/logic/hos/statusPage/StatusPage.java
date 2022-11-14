package logic.hos.statusPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import logic.hos.coDriverPage.CoDriverPage;
import logic.hos.header.Header;
import logic.hos.iftaPage.AddFuelPurchase;
import logic.hos.logsPage.CreateEvents;

import logic.init.BasePage;
import logic.init.ImageSelector;
import logic.init.LocatorName;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;

public class StatusPage extends BasePage {

    Header header = new Header();
    CoDriverPage codriver = new CoDriverPage();

    protected static final Logger log = Logger.getLogger(StatusPage.class);


    @AndroidFindBy(id = "android:id/button2")
    public MobileElement androidBtn;
    @AndroidFindBy(id = projectLocator + ":id/autoTextView_ie_logs_edit_location_state")
    public MobileElement stateEvent;
    @AndroidFindBy(id = projectLocator + ":id/editText_ie_logs_edit_location")
    public MobileElement cityEvent;
    @AndroidFindBy(id = projectLocator + ":id/relativeLayout_trailer_shipping_editor_trailer_add")
    public MobileElement hookTrailer;
    @AndroidFindBy(id = projectLocator + ":id/editText_alert_dialog_edit_truck_field_2")
    public MobileElement trailerLicenseNumber;
    @AndroidFindBy(id = projectLocator + ":id/relativeLayout_trailer_shipping_editor_shipping_add")
    public MobileElement hookShipping;
    @AndroidFindBy(id = projectLocator + ":id/editText_alert_dialog_edit_truck_field_1")
    public MobileElement trailerNumberField;
    @AndroidFindBy(id = projectLocator + ":id/editText_alert_dialog_edit_truck_field_1")
    public MobileElement shippingNumberField;
    @AndroidFindBy(id = projectLocator + ":id/button_alert_dialog_edit_truck_close")
    public MobileElement closeButton;
    @AndroidFindBy(id = projectLocator + ":id/save_button")
    public MobileElement saveEventButton;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_right_button")
    public MobileElement skipTrailerShipping;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_left_button")
    public MobileElement leftDialogButton;
    @AndroidFindBy (xpath = "//*[@text='ON DUTY']")
    public static MobileElement createOnDutyOnWheel;
    @AndroidFindBy (id = projectLocator + ":id/editText_ie_logs_edit_location_comment")
    public static MobileElement eventCommentField;
    @AndroidFindBy (id = projectLocator + ":id/dialog_alert_msg_message")
    public static MobileElement windowAlertIfta;
    @AndroidFindBy (id = projectLocator + ":id/dialog_image_picker_gallery")
    public static MobileElement galleryButtonIfta;
    @AndroidFindBy (id = projectLocator + ":id/dialog_image_picker_camera")
    public static MobileElement cameraButtonIfta;
    @AndroidFindBy (id = projectLocator + ":id/dialog_image_picker_scan")
    public static MobileElement scanButtonIfta;
    @AndroidFindBy (id = projectLocator + ":id/dialog_image_picker_attach_latter")
    public static MobileElement attachLaterButtonIfta;
    @AndroidFindBy (id = projectLocator + ":id/dialog_alert_msg_ok")
    public static MobileElement reminderOk;
    @AndroidFindBy (id = projectLocator + ":id/dialog_alert_left_button")
    public static MobileElement dialogLeft;
    @AndroidFindBy (id = projectLocator + ":id/title")
    public static MobileElement newReminderTitle;
    @AndroidFindBy (id = projectLocator + ":id/ok_remind_later")
    public static MobileElement newReminderLaterButton;
    @AndroidFindBy (id = projectLocator + ":id/spinner_ie_logs_edit_truck")
    public static MobileElement truckNumber;
    @AndroidFindBy (id = projectLocator + ":id/relativeLayout_trailer_shipping_editor_trailer_add")
    public static MobileElement editTrailerNumber;
    @AndroidFindBy (id = projectLocator + ":id/relativeLayout_trailer_shipping_editor_shipping_add")
    public static MobileElement editShippingNumber;
    @AndroidFindBy (id = projectLocator + ":id/button_item_row_alert_dialog_truck_drop")
    public static MobileElement dropTrailer;
    @AndroidFindBy (id = projectLocator + ":id/motley_button_cycle_current")
    public static MobileElement offDutyButtonWheelSwift;
    @AndroidFindBy (id = projectLocator + ":id/motley_button_cycle_left")
    public static MobileElement onDutyButtonWheelSwift;
    @AndroidFindBy (id = projectLocator + ":id/motley_button_cycle_center")
    public static MobileElement sbButtonWheelSwift;
    @AndroidFindBy (id = projectLocator + ":id/motley_button_cycle_right")
    public static MobileElement drivingButtonWheelSwift;
    @AndroidFindBy (id = projectLocator + ":id/btn_d")
    public static MobileElement drivingButtonWheelTrendy;
    @AndroidFindBy (id = projectLocator + ":id/btn_on")
    public static MobileElement onDutyButtonWheelTrendy;
    @AndroidFindBy (id = projectLocator + ":id/btn_sb")
    public static MobileElement sbButtonWheelTrendy;
    @AndroidFindBy (id = projectLocator + ":id/btn_off")
    public static MobileElement offDutyButtonWheelTrendy;
    @AndroidFindBy (id = projectLocator + ":id/btn_ym")
    public static MobileElement ymButtonWheelTrendy;
    @AndroidFindBy (id = projectLocator + ":id/btn_pc")
    public static MobileElement pcButtonWheelTrendy;
    @AndroidFindBy (id = "com.sec.android.app.camera:id/shutter_button")
    public static MobileElement cameraButton;
    @AndroidFindBy (id = "org.sharp.eld:id/short_d")
    public static MobileElement sharpDriving;
    @AndroidFindBy (id = "org.sharp.eld:id/short_sb")
    public static MobileElement sharpSleep;
    @AndroidFindBy (id = "org.sharp.eld:id/short_on")
    public static MobileElement sharpOn;
    @AndroidFindBy (id = "org.sharp.eld:id/short_off")
    public static MobileElement sharpOff;
    @AndroidFindBy (id = "org.vista.eld:id/status_button_driving")
    public static MobileElement vistaDriving;
    @AndroidFindBy (id = "org.vista.eld:id/status_button_sleeper")
    public static MobileElement vistaSleep;
    @AndroidFindBy (id = "org.vista.eld:id/status_button_on_duty")
    public static MobileElement vistaOn;
    @AndroidFindBy (id = "org.vista.eld:id/status_button_off_duty")
    public static MobileElement vistaOff;
    @AndroidFindBy (id = projectLocator + ":id/loader")
    public static MobileElement loaderElement;

    //Alpha
    @AndroidFindBy (xpath = "//*[@text='SLEEPER BERTH' and @resource-id='"+ projectLocator + ":id/textView_fragment_screen_status_event_title']")
    public static MobileElement sbButtonWheelAlpha;
    @AndroidFindBy (xpath = "//*[@text='OFF DUTY' and @resource-id='"+ projectLocator + ":id/textView_fragment_screen_status_event_title']")
    public static MobileElement offButtonWheelAlpha;
    @AndroidFindBy (xpath = "//*[@text='ON DUTY' and @resource-id='"+ projectLocator + ":id/textView_fragment_screen_status_event_title']")
    public static MobileElement onButtonWheelAlpha;
    @AndroidFindBy (xpath = "//*[@text='DRIVING' and @resource-id='"+ projectLocator + ":id/textView_fragment_screen_status_event_title']")
    public static MobileElement drivingButtonWheelAlpha;
    @AndroidFindBy (id = projectLocator + ":id/button_ie_logs_item_edit_fuel")
    public static MobileElement iftaCameraButtonAdd;

    private boolean status = false;

    LocatorName lname = LocatorName.getLocatorNameInstance();

    @Step("Close Message about Uncertified records")
    public StatusPage closeMessageUncertified() {
        if (isElementPresent(3, reminderOk)) {
            waitToVisibilityOf(5, windowAlertIfta);
            try {
                Assert.assertEquals(windowAlertIfta.getText(), "There are uncertified records for the current cycle. Go to Hours of Service -> DOT Inspect, to certify records");
                reminderOk.click();
            } catch (AssertionError e) {
                Assert.assertEquals(windowAlertIfta.getText(), "You need to re-certify your events. Go to Hours of Service > DOT Inspect, to certify records");
                reminderOk.click();
            }
            return this;
        }
        return this;
    }


    @Step("Close Android msg about Battery Settings.")
    public StatusPage clickAndroidBtn() {
        int countTry = 0;
        while (!status && countTry < 5) {
            try {
                while (isElementPresent(1, loaderElement)) {
                    log.info("Waiting to login driver. Loader message is displayed.");
                }
                status = true;
                log.info("Loader is disappeared.");
            } catch (Exception e) {
                log.info("CanaryLeak is displayed. Waiting.");
                clickAndroidBtn();
                countTry++;
            }
        }

        try {
            while (!isElementPresent(1,reminderOk) && (!isElementPresent(1, dialogLeft) && !isElementPresent(1, lname.statusBtn)) && (countTry < 5)) {
                log.info("Waiting to appear uncertified records window or Status page.");
                countTry++;
            }
            if (isElementPresent(1, lname.statusBtn)) {
                log.info("Uncertified window is not appear! Status page is displayed now!");
            } else {
                waitToBeClickable(1, reminderOk, false);
                if (windowAlertIfta.getText().equals("You have no DVIR in the last 24 hours! You can create DVIR now or insert it later")) {
                    dialogLeft.click();
                }
                Assert.assertEquals(windowAlertIfta.getText(), "There are uncertified records for the current cycle. Go to Hours of Service -> DOT Inspect, to certify records");
                while (reminderOk.isDisplayed()) {
                    reminderOk.click();
                    log.info("Trying to close uncertified records window.");
                    log.info("Uncertified window successfully closed.");
                }
            }
        } catch (Exception e) {
            log.info("The window of uncertified records is no longer displayed.");
        }
        try {
            waitToBeClickable(3, windowAlertIfta, false);
            Assert.assertEquals(windowAlertIfta.getText(), "You have no DVIR in the last 24 hours! You can create DVIR now or insert it later");
            leftDialogButton.click();
        } catch (Exception e) {
            log.info("DVIR Window is not appear!");
        }
        //closeNotificationAndroid();
        waitToVisibilityOf(10, lname.statusBtn);
        return this;
    }

    @Step("Close Notification android.")
    public StatusPage closeNotificationAndroid() {
        log.info("Waiting for the closure of the Android notification!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Notification closed.");
        if (isElementPresent(1, header.driverStatus)) {
            codriver.backToMainMenuBtn.click();
        } else {
            return this;
        }
        return this;
    }

    @Step("Check displayed location description in Additional Info")
    public StatusPage openAdditionalInfo(String typeEvent, boolean waitSync) {
        ImageSelector findimg = new ImageSelector();
        if (typeEvent.equals("off")) {
            switch (projectName) {
                case "TE": case "Smart":
                    try {
                        findimg.offDutyEventWheel();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Trendy":
                    waitToVisibilityOf(5, offDutyButtonWheelTrendy);
                    offDutyButtonWheelTrendy.click();
                    break;
                case "Swift":
                    waitToVisibilityOf(5, offDutyButtonWheelSwift);
                    offDutyButtonWheelSwift.click();
                    break;
                case "Alfa":
                    waitToVisibilityOf(5, offButtonWheelAlpha);
                    offButtonWheelAlpha.click();
                    break;
                case "Sharp":
                    waitToVisibilityOf(5, sharpOff);
                    sharpOff.click();
                    break;
                case "Vista":
                    waitToVisibilityOf(5, vistaOff);
                    vistaOff.click();
                    break;
            }
        }
        if (typeEvent.equals("on")) {
            switch (projectName) {
                case "TE": case "Smart":
                    try {
                        findimg.onDutyEventWheel();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Trendy":
                    waitToVisibilityOf(5, onDutyButtonWheelTrendy);
                    onDutyButtonWheelTrendy.click();
                    break;
                case "Swift":
                    waitToVisibilityOf(5, onDutyButtonWheelSwift);
                    onDutyButtonWheelSwift.click();
                    break;
                case "Alfa":
                    waitToVisibilityOf(5, onButtonWheelAlpha);
                    onButtonWheelAlpha.click();
                    break;
                case "Sharp":
                    waitToVisibilityOf(5, sharpOn);
                    sharpOn.click();
                    break;
                case "Vista":
                    waitToVisibilityOf(5, vistaOn);
                    vistaOn.click();
                    break;
            }
        }
        if (typeEvent.equals("sleep")) {
            switch (projectName) {
                case "TE": case "Smart":
                    try {
                        findimg.sleperEventWheel();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Trendy":
                    waitToVisibilityOf(5, sbButtonWheelTrendy);
                    sbButtonWheelTrendy.click();
                    break;
                case "Swift":
                    waitToVisibilityOf(5, sbButtonWheelSwift);
                    sbButtonWheelSwift.click();
                    break;
                case "Alfa":
                    waitToVisibilityOf(5, sbButtonWheelAlpha);
                    sbButtonWheelAlpha.click();
                    break;
                case "Sharp":
                    waitToVisibilityOf(5, sharpSleep);
                    sharpSleep.click();
                    break;
                case "Vista":
                    waitToVisibilityOf(5, vistaSleep);
                    vistaSleep.click();
                    break;
            }
        }
        if (waitSync) {
            if (isElementPresent(1, windowAlertIfta) && (windowAlertIfta.getText().equals("Status cannot be changed without truck synchronization"))) {
                reminderOk.click();
                log.info("Unable to change status. Waiting synchronization.");
                this.openAdditionalInfo(typeEvent, true);
            } else {
                log.info("Wait to opening Additional Info.");
                waitToVisibilityOf(5, stateEvent);
                return this;
            }
        }
        waitToVisibilityOf(5, stateEvent);
        return this;
    }

    @Step("Check Location description")
    public StatusPage checkLocationDescriptionInAdditionalInfo(String state, String city) {
        waitToVisibilityOf(5, stateEvent);
        log.info("Checking displayed State in Additional Info. Expected State: " + state);
        Assert.assertEquals(stateEvent.getText(), state);
        log.info("Actual state: " +stateEvent.getText());
        log.info("Checking displayed City in Additional Info. Expected City: "+city);
        Assert.assertEquals(cityEvent.getText(), city);
        log.info("Actual city: " +cityEvent.getText());
        return this;
    }

    @Step("Creating event from the wheel (Sleeper)")
    public StatusPage createWheelEvent(boolean stateStatus, String typeEvent, String city, String trailer, String license, String shipping, boolean trailerDrop, boolean skipTrailerLicense, boolean skipTandS) {
        ImageSelector findimg = new ImageSelector();
        if (typeEvent=="off") {
            switch (projectName) {
                case "TE": case "Smart":
                    try {
                        findimg.offDutyEventWheel();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Trendy":
                    waitToVisibilityOf(5, offDutyButtonWheelTrendy);
                    offDutyButtonWheelTrendy.click();
                    break;
                case "Swift":
                    waitToVisibilityOf(5, offDutyButtonWheelSwift);
                    offDutyButtonWheelSwift.click();
                    break;
                case "Alfa":
                    waitToVisibilityOf(5, offButtonWheelAlpha);
                    offButtonWheelAlpha.click();
                    break;
                case "Sharp":
                    waitToVisibilityOf(5, sharpOff);
                    sharpOff.click();
                    break;
                case "Vista":
                    waitToVisibilityOf(5, vistaOff);
                    vistaOff.click();
                    break;
            }
        }
        if (typeEvent=="on") {
            switch (projectName) {
                case "TE": case "Smart":
                    try {
                        findimg.onDutyEventWheel();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Trendy":
                    waitToVisibilityOf(5, onDutyButtonWheelTrendy);
                    onDutyButtonWheelTrendy.click();
                    break;
                case "Swift":
                    waitToVisibilityOf(5, onDutyButtonWheelSwift);
                    onDutyButtonWheelSwift.click();
                    break;
                case "Alfa":
                    waitToVisibilityOf(5, onButtonWheelAlpha);
                    onButtonWheelAlpha.click();
                    break;
                case "Sharp":
                    waitToVisibilityOf(5, sharpOn);
                    sharpOn.click();
                    break;
                case "Vista":
                    waitToVisibilityOf(5, vistaOn);
                    vistaOn.click();
                    break;
            }
        }
        if (typeEvent=="sleep") {
            switch (projectName) {
                case "TE": case "Smart":
                    try {
                        findimg.sleperEventWheel();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Trendy":
                    waitToVisibilityOf(5, sbButtonWheelTrendy);
                    sbButtonWheelTrendy.click();
                    break;
                case "Swift":
                    waitToVisibilityOf(5, sbButtonWheelSwift);
                    sbButtonWheelSwift.click();
                    break;
                case "Alfa":
                    waitToVisibilityOf(5, sbButtonWheelAlpha);
                    sbButtonWheelAlpha.click();
                    break;
                case "Sharp":
                    waitToVisibilityOf(5, sharpSleep);
                    sharpSleep.click();
                    break;
                case "Vista":
                    waitToVisibilityOf(5, vistaSleep);
                    vistaSleep.click();
                    break;
            }
        }
        stateEvent.click();
        if (stateStatus) {
            stateEvent.sendKeys("Kansas (KS)");
            /*driver.pressKey(new KeyEvent(AndroidKey.K));
            driver.pressKey(new KeyEvent(AndroidKey.A));
            driver.pressKey(new KeyEvent(AndroidKey.N));*/
        }
        log.info("Enter state in state field. State: "+stateEvent.getText());
        cityEvent.sendKeys(city);
        log.info("Enter city in city field. City: "+cityEvent.getText());
        driver.hideKeyboard();
        log.info("Hide the keyboard");
        try {
            hookTrailer.click();
        } catch (Exception e) {
            editTrailerNumber.click();
        }
        log.info("Open window add trailer");
        if (trailerDrop) {
            dropTrailer.click();
        }
        trailerNumberField.sendKeys(trailer);
        log.info("Enter trailer number. Trailer number: "+trailer);
        if (!skipTrailerLicense) {
            trailerLicenseNumber.sendKeys(license);
            log.info("Enter trailer license number. Trailer license: " + license);
        }
        closeButton.click();
        try {
            waitToBeClickable(5, hookShipping, false);
            hookShipping.click();
        } catch (Exception e) {
            editShippingNumber.click();
        }
        log.info("Open window add shipping");
        shippingNumberField.sendKeys(shipping);
        log.info("Enter shipping number. Shipping number: "+shipping);
        closeButton.click();
        saveEventButton.click();
        log.info("Save created event.");
        if (skipTandS) {
            waitToBeClickable(5, skipTrailerShipping);
            skipTrailerShipping.click();
        }
        return this;
    }

    @Step("Creating event from the wheel (Sleeper)")
    public StatusPage createWheelEventSleeper(String city, String trailer, String shipping) {
        ImageSelector findimg = new ImageSelector();
        log.info("Open page creating event Sleeper from wheel.");
        switch (projectName) {
            case "TE": case "Smart":
                try {
                    findimg.sleperEventWheel();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Trendy":
                waitToVisibilityOf(5, sbButtonWheelTrendy);
                sbButtonWheelTrendy.click();
                break;
            case "Swift":
                waitToVisibilityOf(5, sbButtonWheelSwift);
                sbButtonWheelSwift.click();
                break;
            case "Alfa":
                waitToVisibilityOf(5, sbButtonWheelAlpha);
                sbButtonWheelAlpha.click();
                break;
            case "Sharp":
                waitToVisibilityOf(5, sharpSleep);
                sharpSleep.click();
                break;
            case "Vista":
                waitToVisibilityOf(5, vistaSleep);
                vistaSleep.click();
                break;
        }
        truckNumber.click();
        searchAndClickElementByText("TestTruck1638441050133");
        stateEvent.click();
        stateEvent.sendKeys("Kansas (KS)");
        /*driver.pressKey(new KeyEvent(AndroidKey.K));
        driver.pressKey(new KeyEvent(AndroidKey.A));
        driver.pressKey(new KeyEvent(AndroidKey.N));*/
        log.info("Enter state in state field. State: "+stateEvent.getText());
        cityEvent.sendKeys(city);
        log.info("Enter city in city field. City: "+cityEvent.getText());
        driver.hideKeyboard();
        log.info("Hide the keyboard");
        hookTrailer.click();
        log.info("Open window add trailer");
        trailerNumberField.sendKeys(trailer);
        log.info("Enter trailer number. Trailer number: "+trailer);
        closeButton.click();
        hookShipping.click();
        log.info("Open window add shipping");
        shippingNumberField.sendKeys(shipping);
        log.info("Enter shipping number. Shipping number: "+shipping);
        closeButton.click();
        saveEventButton.click();
        log.info("Save created event.");
        return this;
    }

    @Step("Creating event from the wheel (OnDuty)")
    public StatusPage createWheelEventOnDuty(boolean state, String city, String comment) {
        CreateEvents eventsCreate = new CreateEvents();
        ImageSelector findimg = new ImageSelector();
        log.info("Open page creating event OnDuty from wheel.");
        switch (projectName) {
            case "TE": case "Smart":
                try {
                    findimg.onDutyEventWheel();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Trendy":
                waitToVisibilityOf(5, onDutyButtonWheelTrendy);
                onDutyButtonWheelTrendy.click();
                break;
            case "Swift":
                waitToVisibilityOf(5, onDutyButtonWheelSwift);
                onDutyButtonWheelSwift.click();
                break;
            case "Alfa":
                waitToVisibilityOf(5, onButtonWheelAlpha);
                onButtonWheelAlpha.click();
                break;
            case "Sharp":
                waitToVisibilityOf(5, sharpOn);
                sharpOn.click();
                break;
            case "Vista":
                waitToVisibilityOf(5, vistaOn);
                vistaOn.click();
                break;
        }
        stateEvent.click();
        log.info("Enter state in state field. State: "+stateEvent.getText());
        if (state) {
            stateEvent.sendKeys("Kansas (KS)");
            /*driver.pressKey(new KeyEvent(AndroidKey.K));
            driver.pressKey(new KeyEvent(AndroidKey.A));
            driver.pressKey(new KeyEvent(AndroidKey.N));*/
        }
        cityEvent.sendKeys(city);
        log.info("Enter city in city field. City: "+cityEvent.getText());
        eventCommentField.sendKeys(comment);
        log.info("Enter comment for event in comment field. Commend: "+comment);
        driver.hideKeyboard();
        log.info("Hide the keyboard");
        saveEventButton.click();
        log.info("Save created event.");
        return this;
    }

    @Step("Creating event from the wheel (OnDuty)")
    public StatusPage openAndInputOnDutyWheelWithReadyComment(String city, Integer commentCount) {
        CreateEvents eventsCreate = new CreateEvents();
        ImageSelector findimg = new ImageSelector();
        log.info("Open page creating event OnDuty from wheel.");
        switch (projectName) {
            case "TE": case "Smart":
                try {
                    findimg.onDutyEventWheel();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Trendy":
                waitToVisibilityOf(5, onDutyButtonWheelTrendy);
                onDutyButtonWheelTrendy.click();
                break;
            case "Swift":
                waitToVisibilityOf(5, onDutyButtonWheelSwift);
                onDutyButtonWheelSwift.click();
                break;
            case "Alfa":
                waitToVisibilityOf(5, onButtonWheelAlpha);
                onButtonWheelAlpha.click();
                break;
            case "Sharp":
                waitToVisibilityOf(5, sharpOn);
                sharpOn.click();
                break;
            case "Vista":
                waitToVisibilityOf(5, vistaOn);
                vistaOn.click();
                break;
        }
        waitToVisibilityOf(5, stateEvent);
        stateEvent.click();
        log.info("Enter state in state field. State: "+stateEvent.getText());
        stateEvent.sendKeys("Kansas (KS)");
        /*driver.pressKey(new KeyEvent(AndroidKey.K));
        driver.pressKey(new KeyEvent(AndroidKey.A));
        driver.pressKey(new KeyEvent(AndroidKey.N));*/
        cityEvent.sendKeys(city);
        driver.hideKeyboard();
        log.info("Hide the keyboard");
        eventsCreate.openReadyMadeComments();
        eventsCreate.chooseReadyMadeComment(commentCount);
        saveEventButton.click();
        log.info("Save created event.");
        skipTrailerShipping.click();
        log.info("Skip window adding trailer/shipping.");
        return this;
    }

    @Step("Creating event without trailer/shipping from the wheel (OnDuty)")
    public StatusPage createWheelEventOnDutyWithoutShip(String city, String comment) {
        ImageSelector findimg = new ImageSelector();
        log.info("Open page creating event OnDuty from wheel without shipping.");
        switch (projectName) {
            case "TE": case "Smart":
                try {
                    findimg.onDutyEventWheel();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Trendy":
                waitToVisibilityOf(5, onDutyButtonWheelTrendy);
                onDutyButtonWheelTrendy.click();
                break;
            case "Swift":
                waitToVisibilityOf(5, onDutyButtonWheelSwift);
                onDutyButtonWheelSwift.click();
                break;
            case "Alfa":
                waitToVisibilityOf(5, onButtonWheelAlpha);
                onButtonWheelAlpha.click();
                break;
            case "Sharp":
                waitToVisibilityOf(5, sharpOn);
                sharpOn.click();
                break;
            case "Vista":
                waitToVisibilityOf(5, vistaOn);
                vistaOn.click();
                break;
        }
        waitToVisibilityOf(5, stateEvent);
        stateEvent.click();
        stateEvent.sendKeys("Kansas (KS)");
        /*driver.pressKey(new KeyEvent(AndroidKey.K));
        driver.pressKey(new KeyEvent(AndroidKey.A));
        driver.pressKey(new KeyEvent(AndroidKey.N));*/
        cityEvent.sendKeys(city);
        log.info("Enter state in state field. State: "+stateEvent.getText());
        eventCommentField.sendKeys(comment);
        log.info("Enter comment for event in comment field. Commend: "+comment);
        driver.hideKeyboard();
        log.info("Hide the keyboard");
        saveEventButton.click();
        log.info("Save created event.");
        skipTrailerShipping.click();
        log.info("Skip window adding trailer/shipping.");
        return this;
    }

    @Step("Check displayed ifta window.")
    public StatusPage checkIftaWindow() {
        /*waitToVisibilityOf(5, iftaCameraButtonAdd);
        iftaCameraButtonAdd.click();
        log.info("Opening IFTA Window.");*/
        waitToVisibilityOf(5, windowAlertIfta);
        log.info("Checking the presence of all elements in the window Ifta");
        Assert.assertEquals(windowAlertIfta.getText(), "Select the image of fuel receipt from the camera or gallery");
        isElementPresent(1, galleryButtonIfta);
        isElementPresent(1, cameraButtonIfta);
        isElementPresent(1, scanButtonIfta);
        isElementPresent(1, attachLaterButtonIfta);
        log.info("All elements are present in the window");
        return this;
    }

    @Step("Choosing Gallery Type for load IFTA Image")
    public StatusPage clickToGalleryType() {
        waitToVisibilityOf(5,galleryButtonIfta);
        galleryButtonIfta.click();
        log.info("Choose Gallery for add ifta image.");
        return this;
    }

    @Step("Choosing Camera Type for load IFTA Image")
    public StatusPage clickToCameraType() {
        waitToVisibilityOf(5, cameraButtonIfta);
        cameraButtonIfta.click();
        log.info("Choose Camera for add ifta image.");
        return this;
    }

    @Step("Deny permissions for load image in Fuel Purchase")
    public StatusPage denyPermissions() {
        AddFuelPurchase ifta = new AddFuelPurchase();
        log.info("Check appear permission message.");
        Assert.assertEquals(ifta.permissionMessage.getText(), "Разрешить приложению " + eldName + " снимать фото и видео?");
        log.info("Permission message appear! Deny permission.");
        ifta.denyPermission.click();
        Assert.assertEquals(ifta.androidDenyPermissionMessage.getText(), "Photo Gallery Access Denied");
        log.info("Deny permission message appear! Impossible to load photo from camera");
        ifta.closeAndroidMessage.click();
        return this;
    }
    @Step("Accept permissions for load image in Fuel Purchase")
    public StatusPage acceptPermissions() {
        AddFuelPurchase ifta = new AddFuelPurchase();
        log.info("Check appear permission message.");
        Assert.assertEquals(ifta.permissionMessage.getText(), "Разрешить приложению " + eldName + " снимать фото и видео?");
        log.info("Permission message appear! Accept permission.");
        ifta.acceptPermission.click();
        waitToVisibilityOf(5, lname.galleryWindow);
        //Assert.assertEquals(ifta.galleryCheck.getText(), "Выбор элемента");
        return this;
    }

    @Step("Accept permissions for load image in Fuel Purchase")
    public StatusPage acceptPermissionsOnCamera() {
        AddFuelPurchase ifta = new AddFuelPurchase();
        log.info("Check appear permission message.");
        Assert.assertEquals(ifta.permissionMessage.getText(), "Разрешить приложению " + eldName + " снимать фото и видео?");
        log.info("Permission message appear! Accept permission.");
        ifta.acceptPermission.click();
        waitToVisibilityOf(5, cameraButton);
        return this;
    }

    @Step("Click to attach later.")
    public StatusPage attachLater() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(isElementPresent(5, attachLaterButtonIfta))
        {
            attachLaterButtonIfta.click();
            log.info("Click to Attach later fuel image.");
        }
/*        waitToVisibilityOf(5, attachLaterButtonIfta);
        attachLaterButtonIfta.click();
        log.info("Click to Attach later fuel image.");*/
        return this;
    }

    @Step("Return to the app")
    public StatusPage backToApp() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!isElementPresent(1, cameraButtonIfta)) {
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        }
        log.info("Return to the app");
        return this;
    }

    @Step("Return to the main menu")
    public StatusPage backToMainMenu() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!isElementPresent(1, header.mainMenuBtn)) {
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        }
        log.info("Return to the main menu");
        return this;
    }
}