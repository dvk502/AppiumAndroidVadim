package logic.hos.logsPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import logic.hos.header.Header;

import logic.init.BasePage;
import logic.init.Credentials;
import logic.init.DateUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.List;

public class CreateEvents extends BasePage {

    protected static final Logger log = Logger.getLogger(CreateEvents.class);

    Credentials cred = new Credentials();

    @AndroidFindBy(id = projectLocator + ":id/menu_item_editor_next_step")
    public MobileElement nextPageButton;
    @AndroidFindBy(id = projectLocator + ":id/insert_event")
    public MobileElement createEventButton;
    @AndroidFindBy(id = projectLocator + ":id/relativeLayout_ie_logs_choice_event_off")
    public MobileElement createOffDutyButton;
    @AndroidFindBy(id = projectLocator + ":id/relativeLayout_ie_logs_choice_event_sb")
    public MobileElement createSleeperButton;
    @AndroidFindBy(id = projectLocator + ":id/relativeLayout_ie_logs_choice_event_d")
    public MobileElement createDrivingButton;
    @AndroidFindBy(id = projectLocator + ":id/relativeLayout_ie_logs_choice_event_on")
    public MobileElement createOnDutyButton;
    @AndroidFindBy(xpath = "//*[@text='BC']")
    public MobileElement createBorderCrossButton;
    @AndroidFindBy(id = projectLocator + ":id/editText_date")
    public MobileElement dateField;
    @AndroidFindBy(id = projectLocator + ":id/editText_hour")
    public MobileElement hourField;
    @AndroidFindBy(id = projectLocator + ":id/editText_minute")
    public MobileElement minuteField;
    @AndroidFindBy(id = projectLocator + ":id/imageView_date_back")
    public MobileElement dateBackButton;
    @AndroidFindBy(id = projectLocator + ":id/imageView_hour_back")
    public MobileElement hoursBackButton;
    @AndroidFindBy(id = projectLocator + ":id/imageView_minute_back")
    public MobileElement minuteBackButton;
    @AndroidFindBy(id = projectLocator + ":id/imageView_date_next")
    public MobileElement dateNextButton;
    @AndroidFindBy(id = projectLocator + ":id/imageView_hour_next")
    public MobileElement hoursNextButton;
    @AndroidFindBy(id = projectLocator + ":id/imageView_minute_next")
    public MobileElement minuteNextButton;
    @AndroidFindBy(id = projectLocator + ":id/relativeLayout_trailer_shipping_editor_trailer_add")
    public MobileElement hookTrailerButton;
    @AndroidFindBy(id = projectLocator + ":id/relativeLayout_trailer_shipping_editor_shipping_add")
    public MobileElement addShippingButton;
    @AndroidFindBy(id = projectLocator + ":id/autoTextView_ie_logs_edit_location_state")
    public MobileElement stateEventField;
    @AndroidFindBy(id = projectLocator + ":id/editText_ie_logs_edit_location")
    public MobileElement cityEventField;
    @AndroidFindBy(id = projectLocator + ":id/editText_ie_logs_edit_location_comment")
    public MobileElement commentEventField;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_right_button")
    public MobileElement confirmAlertSkip;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_left_button")
    public MobileElement cancelAlert;
    @AndroidFindBy(id = projectLocator + ":id/editText_alert_dialog_edit_truck_field_1")
    public MobileElement trailerNumberField;
    @AndroidFindBy(id = projectLocator + ":id/editText_alert_dialog_edit_truck_field_2")
    public MobileElement trailerLicenseField;
    @AndroidFindBy(id = projectLocator + ":id/editText_alert_dialog_edit_truck_field_1")
    public MobileElement shippingField;
    @AndroidFindBy(id = projectLocator + ":id/button_alert_dialog_edit_truck_close")
    public MobileElement closeWindow;
    @AndroidFindBy(id = projectLocator + ":id/button_item_row_alert_dialog_truck_drop")
    public MobileElement deleteShippingTrailer;
    @AndroidFindBy(id = projectLocator + ":id/imageView_screen_logs_back_chart")
    public MobileElement choosePreviousDay;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_msg_ok")
    public MobileElement closeAlertCertification;
    @AndroidFindBy(id = projectLocator + ":id/textView_ie_logs_item_trailers")
    List<MobileElement> trailerIdList;
    @AndroidFindBy(id = projectLocator + ":id/textView_ie_logs_item_shipping")
    List<MobileElement> shippingIdList;
    @AndroidFindBy(id = projectLocator + ":id/button_ie_logs_item_edit_event")
    public MobileElement eventEditButton;
    @AndroidFindBy(id = projectLocator + ":id/textView_ie_logs_item_comment")
    public MobileElement eventCommentDisplayed;

    public static String elementText;

    @AndroidFindBy(id = "wada")
    List<MobileElement> listTest;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]")
    public MobileElement trailerOffDuty;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")
    public MobileElement shippingOffDuty;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]")
    public MobileElement trailerDriving;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")
    public MobileElement shippingDriving;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]")
    public MobileElement trailerOnDuty;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")
    public MobileElement shippingOnDuty;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]")
    public MobileElement trailerSleep;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")
    public MobileElement shippingSleep;
    @AndroidFindBy(id = projectLocator + ":id/textView_ie_logs_item_event_time")
    public MobileElement eventTime;
    @AndroidFindBy(id = projectLocator + ":id/textView_ie_logs_item_ir_event_time")
    public MobileElement irEventTime;
    @AndroidFindBy(id = projectLocator + ":id/textView_ie_logs_item_location")
    public MobileElement eventLocation;
    @AndroidFindBy(id = projectLocator + ":id/editText_ie_logs_edit_location_common_comments")
    public MobileElement commentButton;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_list_title")
    public MobileElement commentWindowTitle;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_list_cancel")
    public MobileElement commentWindowCancelButton;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
    public MobileElement eventTimeSecond;
    @AndroidFindBy(id = projectLocator + ":id/spinner_ie_logs_edit_truck")
    public MobileElement openSpinnerEditTruck;
    @AndroidFindBy(id = projectLocator + ":id/spinner_ie_logs_edit_truck_bc")
    public MobileElement selectBcTypeOnTruckPage;
    @AndroidFindBy(id = projectLocator + ":id/spinner_ie_logs_edit_location_border")
    public MobileElement selectBcTypeOnLocationPage;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_msg_message")
    public MobileElement alertBc;
    @AndroidFindBy(id = "android:id/text1")
    public MobileElement truckNumberOnBc;

    public String time;

    @Step("We check if it is possible to create an driving event")
    public CreateEvents checkPossibleEventDriving() {
        if (!isElementPresent(1, createDrivingButton)) {
            log.info("It is impossible to add Driving event, the checkbox works");
            return this;
        } else {
            Assert.fail("It 's possible to add Driving event, checkbox doesn't work");
        }
        return this;
    }

    @Step("Open list of trucks")
    public CreateEvents openListTrucks() {
        waitToVisibilityOf(5, openSpinnerEditTruck);
        log.info("Open list of trucks");
        openSpinnerEditTruck.click();
        return this;
    }

    @Step("Open ready-made comments window")
    public CreateEvents openReadyMadeComments() {
        waitToBeClickable(5, commentButton);
        commentButton.click();
        log.info("Open ready-made comments window.");
        return this;
    }

    @Step("Opening the event editing page")
    public CreateEvents openEditEventPage() {
        waitToBeClickable(5, eventEditButton);
        eventEditButton.click();
        log.info("Opening the event editing page.");
        return this;
    }

    @Step("Select BC type on Truck Page")
    public CreateEvents selectBcType() {
        waitToVisibilityOf(5, selectBcTypeOnTruckPage);
        selectBcTypeOnTruckPage.click();
        return this;
    }

    @Step("Select BC type on Location Page")
    public CreateEvents selectBcTypeOnLocation() {
        waitToVisibilityOf(5, selectBcTypeOnLocationPage);
        selectBcTypeOnLocationPage.click();
        return this;
    }

    @Step("Checking the display of all comments")
    public CreateEvents checkDisplayedAllComments() {
        waitToVisibilityOf(5, commentWindowTitle);
        log.info("Waiting for the comment window to open.");
        log.info("Checking the display of all comments.");
        searchElementByText("Pre-trip inspection");
        searchElementByText("Post-trip inspection");
        searchElementByText("Yard move");
        searchElementByText("Cargo loaded");
        searchElementByText("Cargo unloaded");
        searchElementByText("Trailer pickup");
        searchElementByText("Trailer drop-off");
        searchElementByText("Forgot to switch status");
        searchElementByText("Fuel");
        log.info("All comments displayed correct!");
        return this;
    }

    @Step("Checking the display of all comments")
    public CreateEvents chooseReadyMadeComment(int countComment){
        waitToVisibilityOf(5, commentWindowTitle);
        log.info("Waiting for the comment window to open.");
        log.info("Choose " + countComment + " comment");
        switch (countComment) {
            case (1):
                searchAndClickElementByText(elementText = "Pre-trip inspection");
                log.info("Comment with text - Pre-trip inspection - successfully chosen.");
                break;
            case (2):
                searchAndClickElementByText(elementText = "Post-trip inspection");
                log.info("Comment with text - Post-trip inspection - successfully chosen.");
                break;
            case (3):
                searchAndClickElementByText(elementText = "Yard move");
                log.info("Comment with text - Yard move - successfully chosen.");
                break;
            case (4):
                searchAndClickElementByText(elementText = "Cargo loaded");
                log.info("Comment with text - Cargo loaded - successfully chosen.");
                break;
            case (5):
                searchAndClickElementByText(elementText = "Cargo unloaded");
                log.info("Comment with text - Cargo unloaded - successfully chosen.");
                break;
            case (6):
                searchAndClickElementByText(elementText = "Trailer pickup");
                log.info("Comment with text - Trailer pickup - successfully chosen.");
                break;
            case (7):
                searchAndClickElementByText(elementText = "Trailer drop-off");
                log.info("Comment with text - Trailer drop-off - successfully chosen.");
                break;
            case (8):
                searchAndClickElementByText(elementText = "Forgot to switch status");
                log.info("Comment with text - Forgot to switch status - successfully chosen.");
                break;
            case (9):
                searchAndClickElementByText(elementText = "Fuel");
                log.info("Comment with text - Fuel - successfully chosen.");
                break;
        }
        return this;
    }

    @Step("Comparing displayed comment event with chosen.")
    public CreateEvents comparingComments() {
        waitToVisibilityOf(5, eventCommentDisplayed);
        log.info("Comparing displayed comment event with chosen.");
        Assert.assertEquals(eventCommentDisplayed.getText(), elementText);
        log.info("Displayed comment - " + eventCommentDisplayed.getText() + " - and expected comment - " + elementText + " - compare!");
        return this;
    }

    @Step("Return to Logs page")
    public CreateEvents returnToLogsPage() {
        Header header = new Header();
        header.navigateUp.click();
        log.info("Return to logs page");
        return this;
    }

    @Step("We check if it is possible to edit an event")
    public CreateEvents checkPossibleEventEdit() {
        if ((isElementPresent(1, eventTime)) && (!isElementPresent(1, eventEditButton)) && (isElementPresent(1, eventLocation))) {
            log.info("It is impossible to edit an event, the checkbox works");
            return this;
        } else {
            log.info("No one event was found, or it's possible to edit an event, checkbox doesn't work");
            Assert.assertTrue(false);
        }
        return this;
    }

    @Step("We check if it is possible to create an event")
    public CreateEvents checkPossibleEventCreate() {
        if (!isElementPresent(1, createEventButton)) {
            log.info("It is impossible to create an event, the checkbox works");
            return this;
        } else {
            Assert.fail("It 's possible to create an event, checkbox doesn't work");
        }
        return this;
    }

    @Step("Opening the event creation page")
    public CreateEvents openEventCreatePage() {
        waitToVisibilityOf(10, createEventButton);
        waitToBeClickable(10, createEventButton);
        // new TouchAction(driver).press(PointOption.point(649, 496)).release().perform();
        createEventButton.click();
        log.info("Opening the event creation page.");
        return this;
    }

    @Step("Checking the possibility of creating displayed events")
    public CreateEvents checkDisplayedEvents() {
        waitToVisibilityOf(5, createOffDutyButton);
        waitToVisibilityOf(5, createSleeperButton);
        waitToVisibilityOf(5, createDrivingButton);
        waitToVisibilityOf(5, createOnDutyButton);
        return this;
    }

    @Step("Choosing an event Off-Duty")
    public CreateEvents chooseEventOffDuty() {
        waitToVisibilityOf(10, createOffDutyButton);
        waitToBeClickable(10, createOffDutyButton);
        createOffDutyButton.click();
        log.info("Choosing an event Off-Duty.");
        return this;
    }

    @Step("Check date event > current date USA")
    public CreateEvents eventDateMoreThanCurrentDateUsa() {
        waitToVisibilityOf(5, dateField);
        /*if (dateField.isEnabled()) {
            Assert.fail("Date field is enabled. Test stopped.");
        } else {*/
            log.info("Date field is enabled. Try to press DateNext button.");
            if (dateNextButton.isEnabled()) {
                Assert.fail("Date next button is enabled. Test stopped");
            } else {
                log.info("Date next button is not enabled. Try to click on this button and check date changes.");
                dateNextButton.click();
                Assert.assertEquals(dateField.getText(), DateUtil.currentDateIR(null));
                log.info("Date has not changed.");
            }
        return this;
    }

    @Step("Check date event > current date Canada")
    public CreateEvents eventDateMoreThanCurrentDateCan() {
        waitToVisibilityOf(5, dateField);
        /*if (dateField.isEnabled()) {
            Assert.fail("Date field is enabled. Test stopped.");
        } else {*/
            log.info("Date field is not enabled. Try to press DateNext button.");
            if (dateNextButton.isEnabled()) {
                Assert.fail("Date next button is enabled. Test stopped");
            } else {
                log.info("Date next button is not enabled. Try to click on this button and check date changes.");
                dateNextButton.click();
                Assert.assertEquals(dateField.getText(), DateUtil.currentDateIR(null));
                log.info("Date has not changed.");
            }
        return this;
    }

    @Step("Check date event < first date event Usa")
    public CreateEvents eventDateLessThanFirstDateEventUsa() {
        DateUtil date = new DateUtil();
        waitToVisibilityOf(5, dateField);
        while(dateBackButton.isEnabled()) {
            dateBackButton.click();
            log.info("Click to previous date button.");
            log.info("Current displayed date - "+dateField.getText());
        }
        Assert.assertEquals(dateField.getText(), date.getDateByDeltaDayOnEvent(null, -7));
        log.info("First day in date field displayed correctly.");
        /*if (dateField.isEnabled()) {
            Assert.fail("Date Field is enabled. Test failed.");
        } else {
            log.info("Date Field isn't enabled.");
        }*/
        return this;
    }

    @Step("Check date event < first date event Canada")
    public CreateEvents eventDateLessThanFirstDateEventCan() {
        DateUtil date = new DateUtil();
        waitToVisibilityOf(5, dateField);
        while(dateBackButton.isEnabled()) {
            dateBackButton.click();
            log.info("Click to previous date button.");
            log.info("Current displayed date - "+dateField.getText());
        }
        Assert.assertEquals(dateField.getText(), date.getDateByDeltaDayOnEvent(null, -14));
        log.info("First day in date field displayed correctly.");
        /*if (dateField.isEnabled()) {
            Assert.fail("Date Field is enabled. Test failed.");
        } else {
            log.info("Date Field isn't enabled.");
        }*/
        return this;
    }

    @Step("Check hour event < first day time on event.")
    public CreateEvents eventHoursLessThanFirstDayTimeEvent() {
        waitToVisibilityOf(5, hourField);
        hourField.sendKeys("-10");
        minuteField.sendKeys("-10");
        while(hoursBackButton.isEnabled()) {
            hoursBackButton.click();
            log.info("Click to hours back button while is enabled.");
        }
        Assert.assertEquals(hourField.getText(), "0");
        log.info("Hours = 0 ");
        while(minuteBackButton.isEnabled()) {
            minuteBackButton.click();
            log.info("Click to minute back button while is enabled.");
        }
        Assert.assertEquals(minuteField.getText(), "0");
        log.info("Minute = 0");
        return this;
    }

    @Step("Check time event > current time")
    public CreateEvents eventTimeMoreThanCurrentTime(Integer number1) {
        waitToVisibilityOf(5, hourField);
        String eventTimeOld = hourField.getText();
        int eventTimeNow = Integer.parseInt(hourField.getText());
        log.info("Try to set time of event more than current time.");
        eventTimeNow = (eventTimeNow)+number1;
        hourField.sendKeys(Integer.toString(eventTimeNow));
        Assert.assertEquals(hourField.getText(), eventTimeOld);
        log.info("Can't set the time more than current time.");
        return this;
    }

    @Step("Check minute event > current time")
    public CreateEvents eventMinuteMoreThanCurrentTime(Integer number2) {
        Header header = new Header();
        waitToVisibilityOf(5, minuteField);
        String eventMinuteOld = minuteField.getText();
        int eventMinuteNow = Integer.parseInt(minuteField.getText());
        log.info("Try to set minute of event more than current time.");
        if(eventMinuteNow==59) {
            header.backMenu();
            header.backMenu();
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            openEventCreatePage();
            chooseEventDriving();
            return eventMinuteMoreThanCurrentTime(number2);
        }
        eventMinuteNow = (eventMinuteNow)+number2;
        minuteField.sendKeys(Integer.toString(eventMinuteNow));
        Assert.assertEquals(minuteField.getText(), eventMinuteOld);
        log.info("Can't set minute more than current minute.");
        return this;
    }

    @Step("Take event time")
    public CreateEvents eventTimeTake() {
        waitToVisibilityOf(5, eventTime);
        time = eventTime.getText();
        log.info("We read the start time of the event");
        return this;
    }

    @Step("Take event time")
    public CreateEvents eventTimeTakeSecond() {
        waitToVisibilityOf(5, eventTimeSecond);
        time = eventTimeSecond.getText();
        log.info("We read the start time of the event");
        return this;
    }

    @Step("Choosing an event Sleeper berth")
    public CreateEvents chooseEventSleeper() {
        waitToVisibilityOf(10, createSleeperButton);
        waitToBeClickable(10, createSleeperButton);
        createSleeperButton.click();
        log.info("Choosing an event Sleeper Berth.");
        return this;
    }

    @Step("Choosing an event Driving")
    public CreateEvents chooseEventDriving() {
        waitToVisibilityOf(10, createDrivingButton);
        waitToBeClickable(10, createDrivingButton);
        createDrivingButton.click();
        log.info("Choosing an event Driving.");
        return this;
    }

    @Step("Choosing an event On-Duty")
    public CreateEvents chooseEventOnDuty() {
        waitToVisibilityOf(10, createOnDutyButton);
        waitToBeClickable(10, createOnDutyButton);
        createOnDutyButton.click();
        log.info("Choosing an event On-Duty.");
        return this;
    }

    @Step("Removing Shipping / Trailer from the event")
    public CreateEvents deleteShippingTrailer() {
        waitToVisibilityOf(10, deleteShippingTrailer);
        deleteShippingTrailer.click();
        deleteShippingTrailer.click();
        deleteShippingTrailer.click();
        log.info("Removing Shipping / Trailer from the event");
        return this;
    }

    @Step("Enter the beginning of the event (hours).")
    public CreateEvents inputHourEvent(String hours) {
//        waitToVisibilityOf(10, dateField);
//        waitToBeClickable(10, dateField);
        hourField.sendKeys(hours);
        log.info("Enter the beginning of the event (hours). Hours: " + hours);
        return this;
    }

    @Step("Change location (City) for event.")
    public CreateEvents changeLocationEvent(String city, boolean state) {
        waitToVisibilityOf(5, stateEventField);
        stateEventField.click();
        if (state) {
            stateEventField.sendKeys("Alabama (AL)");
            /*driver.pressKey(new KeyEvent(AndroidKey.A));
            driver.pressKey(new KeyEvent(AndroidKey.L));
            driver.pressKey(new KeyEvent(AndroidKey.A));
            driver.pressKey(new KeyEvent(AndroidKey.B));*/
        }
        waitToVisibilityOf(5, cityEventField);
        try {
            cityEventField.sendKeys(city);
        } catch (Exception e) {
            log.warn("Canary Leak is displayed...");
            cityEventField.sendKeys(city);
        }
        log.info("Change city for event (" +city+ ").");
        return this;
    }

    @Step("Enter the beginning of the event (minutes)")
    public CreateEvents inputMinuteEvent(String minute) {
//        waitToVisibilityOf(10, minuteField);
//        waitToBeClickable(10, minuteField);
        minuteField.sendKeys(minute);
        log.info("Enter the beginning of the event (minutes). Minute: " + minute);
        return this;
    }

    @Step("Go to the next page")
    public CreateEvents nextPageEventCreate() {
        waitToVisibilityOf(10, nextPageButton);
        waitToBeClickable(10, nextPageButton);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nextPageButton.click();
        log.info("Go to the next page.");
        return this;
    }

    @Step("Attaching Trailer numbers")
    public CreateEvents trailerHook() {
        waitToVisibilityOf(10, hookTrailerButton);
        waitToBeClickable(10, hookTrailerButton);
        hookTrailerButton.click();
        log.info("Attaching Trailer numbers.");
        return this;
    }

    @Step("Choose time for BC (>Driving and <Off-Duty")
    public CreateEvents timeForBc() {
        DateUtil date = new DateUtil();
        waitToVisibilityOf(10, minuteField);
        waitToBeClickable(10, minuteField);
        if (Integer.parseInt(minuteField.getText())<5) {
            hoursBackButton.click();
        }
        minuteField.sendKeys(date.getDeltaEventMinute3(null,-5));
        log.info("Set time for BC between Driving and Off-Duty.");
        return this;
    }

    @Step("Set time for created event.")
    public CreateEvents setTimeForEvent(String hours, String minutes) {
        waitToVisibilityOf(5, hourField);
        hourField.sendKeys(hours);
        waitToVisibilityOf(10, minuteField);
        minuteField.sendKeys(minutes);;
        log.info("Set time for event.");
        return this;
    }

    @Step("Wait to appear alert about creating BC between AutoDriving and Off-Duty.")
    public CreateEvents BcAlertMustBeDisplayed(boolean status) {
        if (status) {
            try {
                waitToBeClickable(10, alertBc, false);
            } catch (Exception e) {
                log.info("Alert not found!");
            }
            log.info("Wait to appear alert and compare text in alert.");
            Assert.assertEquals(alertBc.getText(), "The previous event cannot be changed as it was added automatically");
            log.info("Text in alert compare on 100%.");
            closeAlertCertification.click();
            log.info("Close BC alert.");
            return this;
        } else {
            if (isElementPresent(3, alertBc)) {
                Assert.fail("BC Alert displayed. Test failed.");
            } else {
                log.info("BC Alert is not displayed. Next step.");
            }
        }
        return this;
    }

    @Step("Add Shipping numbers")
    public CreateEvents shippingAdd() {
        waitToVisibilityOf(10, addShippingButton);
        waitToBeClickable(10, addShippingButton);
        addShippingButton.click();
        log.info("Add Shipping numbers.");
        return this;
    }

    @Step("Confirm skipping adding Shipping / Trailer numbers")
    public CreateEvents skipTrailersAndShipping() {
        waitToVisibilityOf(10, confirmAlertSkip);
        waitToBeClickable(10, confirmAlertSkip);
        confirmAlertSkip.click();
        log.info("Confirm skipping adding Shipping / Trailer numbers.");
        return this;
    }

    @Step("Confirm skipping adding Shipping / Trailer numbers")
    public CreateEvents addOnDutyWithBc(boolean status) {
        if (status) {
            waitToVisibilityOf(10, confirmAlertSkip);
            waitToBeClickable(10, confirmAlertSkip);
            confirmAlertSkip.click();
            log.info("Confirm adding On-Duty with BC.");
        } else {
            waitToVisibilityOf(10, cancelAlert);
            waitToBeClickable(10, cancelAlert);
            cancelAlert.click();
            log.info("Cancel adding On-Duty with BC.");
        }
        return this;
    }

    @Step("Check appear same truck on created BC")
    public CreateEvents checkTruckOnCreatedBc() {
        waitToVisibilityOf(5, truckNumberOnBc);
        log.info("Comparing displayed truck number with previous event.");
        Assert.assertEquals(truckNumberOnBc.getText(), "TestTruck1638441050133");
        log.info("Truck number compare with previous event.");
        return this;
    }

    @Step("Check state event")
    public CreateEvents checkStateEvent() {
        Header header = new Header();
        waitToVisibilityOf(5, stateEventField);
        if (stateEventField.getText().equals("Alabama (AL)")) {
            return this;
        } else {
            header.backMenu();
            waitToVisibilityOf(5, nextPageButton);
            nextPageButton.click();
            return checkStateEvent();
        }
    }

    @Step("Enter the state, city of the event, add a comment")
    public CreateEvents inputDataEvent(boolean state, String city, String comment) throws InterruptedException {
        waitToVisibilityOf(5, stateEventField);
        stateEventField.click();
        if (state) {
            stateEventField.sendKeys("Kansas (KS)");
            /*driver.pressKey(new KeyEvent(AndroidKey.K));
            driver.pressKey(new KeyEvent(AndroidKey.A));
            driver.pressKey(new KeyEvent(AndroidKey.N));*/
        }
        log.info("Entering the state.");
        //waitToVisibilityOf(10, citeEventField);
        cityEventField.sendKeys(city);
        log.info("Entering the city.");
        //waitToVisibilityOf(10, commentEventField);
        commentEventField.sendKeys(comment);
        log.info("Entering a comment.");
        return this;
    }

    @Step("Enter the Trailer number")
    public CreateEvents inputTrailerData(String number, String license) {
        waitToVisibilityOf(10, trailerNumberField);
        trailerNumberField.sendKeys(number);
        log.info("Enter the Trailer number. Trailer number: " + number);
        waitToVisibilityOf(10, trailerLicenseField);
        trailerLicenseField.sendKeys(license);
        log.info("Enter the trailer license number. Trailer license number: " + license);
        return this;
    }

    @Step("Close the Trailer / Shipping numbers window")
    public CreateEvents closeWindow() {
        waitToVisibilityOf(10, closeWindow);
        closeWindow.click();
        log.info("Close the Trailer / Shipping numbers window.");
        return this;
    }

    @Step("Enter the Shipping number")
    public CreateEvents inputShippingData(String shipping) {
        waitToVisibilityOf(10, shippingField);
        shippingField.sendKeys(shipping);
        log.info("Enter the Shipping number. Shipping number: " + shipping);
        return this;
    }

//    @Step("Compare Trailer number")
//    public void compareTrailerNumber1(MobileElement element, String trailer) {
//        log.info("Compare Trailer number.");
//        waitToVisibilityOf(10, element);
//        Assert.assertEquals(element.getText(), "Tr: "+trailer);
//        log.info("Trailer number match! Displayed Trailer number: "+element.getText()+" Expected: Tr: "+trailer);
//    }

    @Step("Comparing Displayed Trailer number with expected.")
    public CreateEvents compareTrailerNumber(String trailer) {
        int lastTrailerId = 0;
        log.info("Compare Trailer number.");
        // int i = 0;
        for (int i = 0; i < trailerIdList.size(); i++) {
            int b = i;
            lastTrailerId++;
            b++;
            if (trailerIdList.get(i).getText().equals("Tr: " + trailer)) {
                Assert.assertEquals(trailerIdList.get(i).getText(), "Tr: " + trailer);
                Assert.assertEquals(i + 1, lastTrailerId);
                log.info("Trailer number found! Event number: " + b + ". Trailer number displayed: " + trailerIdList.get(i).getText() + ". Expected Trailer number: Tr: " + trailer + ".");
                return this;
            }
        }
        /*for (MobileElement trailerField : trailerIdList) {
            i++;
             int a = i;`
            if(trailerField.getText().equals(trailer) && a+1 > i){
                Assert.assertEquals(trailerField.getText(), trailer);
                log.info("Trailer number match! Number of field: " + i + ". Displayed Trailer number: " + trailerField.getText() + " Expected: " + trailer);
                return this;
            }
        }*/
        Assert.fail("Trailer not found!");
        return this;
    }

    @Step("Comparing Shipping number displayed with expected.")
    public CreateEvents compareShippingNumber(String shipping) {
        int lastShippingId = 0;
        log.info("Compare Shipping number.");
        for (int i = 0; i < shippingIdList.size(); i++) {
            int b = i;
            b++;
            lastShippingId++;
            if (shippingIdList.get(i).getText().equals("Sh: " + shipping)) {
                Assert.assertEquals(shippingIdList.get(i).getText(), "Sh: " + shipping);
                Assert.assertEquals(i + 1, lastShippingId);
                log.info("Shipping number found! Event number: " + b + ". Displayed Shipping number: " + shippingIdList.get(i).getText() + ". Expected Shipping number: Sh: " + shipping + ".");
                return this;
            }
        }

//        int i = 0;
//        for (MobileElement shippingField : shippingIdList) {
//            i++;
//            if(shippingField.getText().equals(shipping)) {
//                Assert.assertEquals(shippingField.getText(), shipping);
//                log.info("Shipping number match! Number of field: " + i + ". Displayed Shipping number: " + shippingField.getText() + " Expected: " + shipping);
//                return this;
//            }
//        }
        Assert.fail("Shipping number not found!");
        return this;
    }

    @Step("Back to the previous day")
    public CreateEvents backToPreviousDay() {
        waitToVisibilityOf(10, choosePreviousDay);
        choosePreviousDay.click();
        log.info("Back to the previous day.");
        return this;
    }

    @Step("Close the warning about the need for certification")
    public CreateEvents closeCertificationAlert() {
        try {
            waitToBeClickable(10, closeAlertCertification, false);
            closeAlertCertification.click();
            log.info("Close the warning about the need for certification.");
        } catch (Exception e) {
            log.error("Certification window is not displayed!!!");
        }
        return this;
    }

    @Step("Editing the event")
    public CreateEvents eventEditToSleeper(String trailer, String shipping) {
        waitToVisibilityOf(5, eventEditButton);
        eventEditButton.click();
        log.info("Click to event edit button");
        waitToVisibilityOf(5, hoursBackButton);
        /*hoursBackButton.click();
        log.info("Change time event");*/
        nextPageButton.click();
        waitToVisibilityOf(5, createOffDutyButton);
        createSleeperButton.click();
        log.info("Change event type.");
        waitToVisibilityOf(5, hookTrailerButton);
        hookTrailerButton.click();
        log.info("Change trailer event.");
        waitToVisibilityOf(5, deleteShippingTrailer);
        deleteShippingTrailer.click();
        trailerNumberField.sendKeys(trailer);
        closeWindow.click();
        waitToVisibilityOf(5, addShippingButton);
        addShippingButton.click();
        log.info("Change shipping event");
        waitToVisibilityOf(5, deleteShippingTrailer);
        deleteShippingTrailer.click();
        shippingField.sendKeys(shipping);
        closeWindow.click();
        nextPageButton.click();
        try {
            inputDataEvent(true, "Orlando", "TestSave");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitToVisibilityOf(5, nextPageButton);
        while (!isElementPresent(1, eventTime)) {
            nextPageButton.click();
        }
        return this;
    }
}
