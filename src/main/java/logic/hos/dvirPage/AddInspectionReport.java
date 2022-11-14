package logic.hos.dvirPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import logic.hos.logsPage.CreateEvents;
import logic.hos.statusPage.StatusPage;
import logic.init.*;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.fail;

public class AddInspectionReport extends BasePage {
    protected static final Logger log = Logger.getLogger(AddInspectionReport.class);


    @AndroidFindBy(id = projectLocator + ":id/editText_date")
    public MobileElement dateField;
    @AndroidFindBy(id = projectLocator + ":id/editText_hour")
    public MobileElement hourField;
    @AndroidFindBy(id = projectLocator + ":id/editText_minute")
    public MobileElement minuteField;
    @AndroidFindBy(id = projectLocator + ":id/single_location")
    public MobileElement locationField;
    @AndroidFindBy(id = projectLocator + ":id/truck_btn")
    public MobileElement truckButton;
    @AndroidFindBy(id = projectLocator + ":id/trailer_btn")
    public MobileElement trailerButton;
    @AndroidFindBy(id = projectLocator + ":id/truck_number_spinner")
    public MobileElement truckNumberSpinner;
    @AndroidFindBy(id = projectLocator + ":id/truck_odometer")
    public MobileElement odometerField;
    @AndroidFindBy(id = projectLocator + ":id/img_view_ir_edit_trailers")
    public MobileElement trailerNumberChangeButton;
    @AndroidFindBy(id = projectLocator + ":id/trailer_license")
    public MobileElement trailerLicenseField;
    @AndroidFindBy(id = projectLocator + ":id/editText_alert_dialog_edit_truck_field_2")
    public MobileElement newTrailerLicenseField;
    @AndroidFindBy(id = projectLocator + ":id/vehicle_defects_btn")
    public MobileElement vehicleDefectsButton;
    @AndroidFindBy(id = projectLocator + ":id/remarks")
    public MobileElement remarksField;
    @AndroidFindBy(id = projectLocator + ":id/confirm_safe_btn")
    public MobileElement confirmSafeButton;
    @AndroidFindBy(id = projectLocator + ":id/confirm_unsafe_btn")
    public MobileElement confirmUnsafeButton;
    @AndroidFindBy(id = projectLocator + ":id/certify_check")
    public MobileElement certifyCheckButton;
    @AndroidFindBy(id = projectLocator + ":id/ir_save_button")
    public MobileElement saveButton;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Spinner/android.widget.TextView")
    public MobileElement truckNumberField;
    @AndroidFindBy(id = projectLocator + ":id/imageView_date_next")
    public MobileElement nextDateButton;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_msg_message")
    public MobileElement fieldAlert;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_msg_warning")
    public MobileElement trailerAlert;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_left_button")
    public MobileElement skipOnDuty;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_right_button")
    public MobileElement createIrWithOnDuty;
    @AndroidFindBy(xpath = "//*[@text='INSPECTION REPORT']")
    public MobileElement addInspectionReportToolbar;
    @AndroidFindBy(id = projectLocator + ":id/imageView_date_back")
    public MobileElement dateBackButton;
    @AndroidFindBy(id = projectLocator + ":id/imageView_hour_back")
    public MobileElement hoursBackButton;
    @AndroidFindBy(id = projectLocator + ":id/imageView_minute_back")
    public MobileElement minutesBackButton;
    @AndroidFindBy(id = projectLocator + ":id/vehicle_defects_btn")
    public MobileElement addDefectsButton;
    @AndroidFindBy(id = projectLocator + ":id/item_done")
    public MobileElement doneButton;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_msg_ok")
    public MobileElement alertOkButton;
    @AndroidFindBy(id = projectLocator + ":id/checkbox_defect_item")
    public List<MobileElement> defectCheckbox;
    @AndroidFindBy(id = projectLocator + ":id/editText_alert_dialog_edit_truck_field_1")
    public MobileElement trailerNumberFieldNew;
    @AndroidFindBy(id = projectLocator + ":id/button_alert_dialog_edit_truck_close")
    public MobileElement trailerWindowClose;
    @AndroidFindBy(id = projectLocator + ":id/textview_trailers_list")
    public MobileElement trailerNumberCheck;
    @AndroidFindBy(id = projectLocator + ":id/button_alert_dialog_edit_truck_hook")
    public MobileElement trailerHook;
    @AndroidFindBy(id = projectLocator + ":id/button_item_row_alert_dialog_truck_drop")
    public MobileElement dropTrailer;
    @AndroidFindBy(id = projectLocator + ":id/textView_item_row_alert_dialog_truck_number")
    public MobileElement trailerName;
    @AndroidFindBy(xpath = "//*[@text='Create Inspection Report']")
    public MobileElement iRToolbarTrendy;

    LocatorName lname = LocatorName.getLocatorNameInstance();

    public String date;
    public static String resultHours;
    public static String minutes;
    public static String location;
    public static String truckNumber;
    public static String odometer;
    public static String hoursInApp;
    public int hours;
    public int differenceTimeZone = 0;


    public AddInspectionReport checkLocation(String location) {
        waitToVisibilityOf(5, locationField);
        locationField.click();
        log.info("Enter location " + location + " in location field.");
        locationField.sendKeys(location);
        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pressPoints(475, 65);
        log.info("Press to first founded city in list.");
        log.info("Compare the city selected from the menu with the one displayed in the location field");
        if (locationField.getText().equals("Kansas, IL, US")) {
            log.info("Location is match! Loc. in field: " + locationField.getText());
        } else if (locationField.getText().equals("Kansas, KS, US")) {
            log.info("Location is match! Loc. in field: " + locationField.getText());
        } else {
            Assert.fail("Location doesn't match! Failed!");
        }
        return this;
    }

    public AddInspectionReport changeDateIr() {
        waitToVisibilityOf(5, dateBackButton);
        DateUtil date = new DateUtil();
        log.info("Creating IR 2 days before current date");
        while (!dateField.getText().equals(date.getDeltaIrDay(null, -2))) {
            dateBackButton.click();
            log.info("Date in app: " + dateField.getText() + " | Current date minus 2 days: " + date.getDeltaIrDay(null, -2));
        }
        return this;
    }

    public AddInspectionReport changeTrailersIr(String trailer) {
        waitToVisibilityOf(5, trailerNumberChangeButton);
        trailerNumberChangeButton.click();
        log.info("Check message about empty trailer number.");
        waitToVisibilityOf(5, trailerHook);
        trailerHook.click();
        waitToVisibilityOf(5, trailerAlert);
        Assert.assertEquals(trailerAlert.getText(), "Trailer # cannot be empty");
        log.info("Alert about empty trailer number appear!");
        log.info("Change trailers in created IR");
        waitToVisibilityOf(5, trailerNumberFieldNew);
        trailerNumberFieldNew.sendKeys(trailer);
        return this;
    }

    public AddInspectionReport checkMessageAboutEmptyTrailer() {
        log.info("Check message about empty trailer number.");
        waitToVisibilityOf(5, trailerHook);
        trailerHook.click();
        waitToVisibilityOf(5, trailerAlert);
        Assert.assertEquals(trailerAlert.getText(), "Trailer # cannot be empty");
        log.info("Alert about empty trailer number appear!");
        return this;
    }

    public AddInspectionReport openTrailerWindow() {
        log.info("Open trailer window.");
        waitToVisibilityOf(5, trailerNumberChangeButton);
        trailerNumberChangeButton.click();
        return this;
    }

    public AddInspectionReport dropTrailer() {
        log.info("Drop trailer " + trailerName.getText());
        waitToVisibilityOf(5, dropTrailer);
        dropTrailer.click();
        return this;
    }

    public AddInspectionReport changeTrailerLicenseIr(String trailer, String license) {
        log.info("Change trailers in created IR");
        waitToVisibilityOf(5, trailerNumberFieldNew);
        trailerNumberFieldNew.sendKeys(trailer);
        log.info("Change trailer License in created IR");
        waitToVisibilityOf(5, newTrailerLicenseField);
        newTrailerLicenseField.sendKeys(license);
        return this;
    }

    public AddInspectionReport closeTrailerChangeWindow() {
        waitToVisibilityOf(5, trailerWindowClose);
        trailerWindowClose.click();
        log.info("Close trailer window.");
        return this;
    }

    public AddInspectionReport changeOdometerIr(String odometer) {
        waitToVisibilityOf(5, odometerField);
        odometerField.clear();
        odometerField.sendKeys(odometer);
        log.info("Change Odometer in created IR");
        return this;
    }

    public AddInspectionReport changeLocationIr(String location) {
        waitToVisibilityOf(5, locationField);
        locationField.clear();
        locationField.sendKeys(location);
        log.info("Change location in created IR");
        return this;
    }

    public AddInspectionReport trailerLicenseAdd(String license) {
        waitToVisibilityOf(5, trailerLicenseField);
        trailerLicenseField.sendKeys(license);
        return this;
    }

    public AddInspectionReport openDefectsWindow() {
        waitToVisibilityOf(5, addDefectsButton);
        addDefectsButton.click();
        log.info("Open defects window.");
        return this;
    }

    public AddInspectionReport addAllDefects() {
        waitToVisibilityOf(5, doneButton);
        int i = 0;
        while (i != 53) {
            for (MobileElement checkbox : defectCheckbox) {
                if (checkbox.getAttribute("checked").equals("false")) {
                    checkbox.click();
                    log.info("Turn On checkbox - " + checkbox.getText());
                    i++;
                }
            }
            scrollToAnElementByText(driver, "Tarpaulin");
        }
        return this;
    }

    public AddInspectionReport delAllDefects() {
        waitToVisibilityOf(5, doneButton);
        int i = 53;
        while (i != 0) {
            for (MobileElement checkbox : defectCheckbox) {
                if (checkbox.getAttribute("checked").equals("true")) {
                    checkbox.click();
                    log.info("Turn Off checkbox - " + checkbox.getText());
                    i--;
                }
            }
            scrollToAnElementByText(driver, "Tarpaulin");
        }
        return this;
    }

    public AddInspectionReport checkAllDefectsTurnedOff() {
        waitToVisibilityOf(5, doneButton);
        List<String> defectsOff = new ArrayList<>();
        MobileElement lastCheckbox = defectCheckbox.get(defectCheckbox.size() - 1);
        defectCheckbox.forEach(checkbox -> isNotChecked(defectsOff, checkbox, "true"));

        scrollToAnElementByText(driver, "Tarpaulin");
        searchElementByText(3,"Wheels and Rims");

        int index = defectCheckbox.indexOf(lastCheckbox);
        for (int i = index + 1; i < defectCheckbox.size(); i++) {
            MobileElement checkbox = defectCheckbox.get(i);
            isNotChecked(defectsOff, checkbox, "true");
        }

        if (defectsOff.size() != 0) {
            fail("Some defects is selected. Defects " + defectsOff + " is selected.");
        }
        return this;
    }

    private void isNotChecked(List<String> defectsOff, MobileElement checkbox, String flag) {
        boolean status = checkbox.getAttribute("checked").equals(flag);
        if (status) {
            log.info("Checkbox - " + checkbox.getText() + " - selected!");
            defectsOff.add(checkbox.getText());
        } else {
            log.info("Checkbox - " + checkbox.getText() + " - is not selected.");
        }
    }

    public AddInspectionReport checkAllDefectsTurnedOn() {
        waitToVisibilityOf(5, doneButton);
        List<String> defects = new ArrayList<>();
        MobileElement lastCheckbox = defectCheckbox.get(defectCheckbox.size() - 1);
        defectCheckbox.forEach(checkbox -> isChecked(defects, checkbox, "true"));

        scrollToAnElementByText(driver, "Tarpaulin");
        searchElementByText(3,"Wheels and Rims");

        int index = defectCheckbox.indexOf(lastCheckbox);
        for (int i = index + 1; i < defectCheckbox.size(); i++) {
            MobileElement checkbox = defectCheckbox.get(i);
            isChecked(defects, checkbox, "true");
        }

        if (defects.size() != 0) {
            fail("Not all defects selected. Defects " + defects + " is not selected.");
        }
        return this;
    }

    private void isChecked(List<String> defects, MobileElement checkbox, String flag) {
        boolean status = checkbox.getAttribute("checked").equals(flag);
        if (status) {
            log.info("Checkbox - " + checkbox.getText() + " - selected!");
        } else {
            log.info("Checkbox - " + checkbox.getText() + " - is not selected.");
            defects.add(checkbox.getText());
        }
    }

    public AddInspectionReport addDefects(String defect, Integer countDefect) {
        waitToVisibilityOf(5, doneButton);
        MobileElement element = waitToVisibilityOf(10, driver.findElementsByXPath("//*[@text='" + defect + "']").get(countDefect));
        element.click();
        log.info("Select defect - " + defect);
        return this;
    }

    public AddInspectionReport saveSelectedDefects() {
        waitToVisibilityOf(5, doneButton);
        doneButton.click();
        log.info("Save selected defects.");
        return this;
    }

    public AddInspectionReport setCurrentDate() {
        DateUtil date = new DateUtil();
        waitToVisibilityOf(5, dateField);
        this.date = dateField.getText();
        if (!this.date.equals(date.currentDateIR(null))) {
            nextDateButton.click();
            log.info("Click to next day button.");
            log.info("Displayed date in app: " + dateField.getText());
            log.info("Current date: " + date.currentDateIR(null));
            return setCurrentDate();
        } else {
            log.info("Current date compared with displayed IR date.");
            this.date = date.formattedCurrentDateIRWeb(null);
        }
        return this;
    }

    public AddInspectionReport setCurrentTimeWithDeltaMinute(String time, String delta) {
        DateUtil date = new DateUtil();
        waitToVisibilityOf(5, minuteField);
        String minute = minuteField.getText();
        if (Integer.parseInt(minute) < Integer.parseInt(delta)) {
            hoursBackButton.click();
            minuteField.sendKeys("59");
            return setCurrentTimeWithDeltaMinute(time, delta);
        }
        minuteField.sendKeys(time);
        return this;
    }

    public AddInspectionReport saveChanges() {
        scrollToAnElementByText(driver, "SAVE");
        log.info("Scroll to button Save.");
        confirmSafeButton.click();
        log.info("Click to this vehicle safe to drive.");
        certifyCheckButton.click();
        log.info("Click to certify button.");
        saveButton.click();
        log.info("Click to save button for save report.");
        return this;
    }

    public AddInspectionReport checkTrailerNumberField(String trailerNumber, String trailerLicense) {
        waitToVisibilityOf(5, trailerNumberCheck);
        Assert.assertEquals(trailerNumberCheck.getText(), trailerNumber + " (Lic.:" + trailerLicense + ")");
        return this;
    }

    public AddInspectionReport checkErrorIR() {
        waitToVisibilityOf(5, fieldAlert);
        Assert.assertEquals(fieldAlert.getText(), "You can create Inspection Report only after Duty event");
        alertOkButton.click();
        return this;
    }

    public AddInspectionReport checkErrorIRBeetwen() {
        waitToVisibilityOf(5, fieldAlert);
        Assert.assertEquals(fieldAlert.getText(), "Cannot insert Inspection Report between Off Duty and Personal Use");
        alertOkButton.click();
        return this;
    }

    public AddInspectionReport checkRequiredFields(String loc, String odom, String rem, String trailerNumber, String trailerLicense) throws IOException {
        //-------------------------------------------------
        ImageSelector imgFinder = new ImageSelector();
        //-------------------------------------------------
        waitToVisibilityOf(5, locationField);
        confirmSafeButton.click();
        log.info("Click to this vehicle safe to drive.");
        certifyCheckButton.click();
        log.info("Click to certify button.");
        scrollToAnElementByText(driver, "SAVE");
        log.info("Scroll to button Save.");
        saveButton.click();
        log.info("Click to save button for save report.");
        //imgFinder.locationIR();
        waitToVisibilityOf(5, fieldAlert);
        log.info("Check to appear Location Alert.");
        Assert.assertEquals(fieldAlert.getText(), "Location cannot be empty");
        alertOkButton.click();
        waitToVisibilityOf(5, locationField);
        locationField.sendKeys(loc);
        driver.hideKeyboard();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lname.inspectionReportToolbar.click();
        log.info("Enter Location Report: " + loc);
        saveButton.click();
        log.info("Click to save button for save report.");
        //imgFinder.odometerIR();
        log.info("Check to appear Odometer Value Alert.");
        waitToVisibilityOf(5, fieldAlert);
        Assert.assertEquals(fieldAlert.getText(), "Odometer value cannot be 0 or empty");
        alertOkButton.click();
        waitToVisibilityOf(5, odometerField);
        odometerField.sendKeys(odom);
        log.info("Enter odometer: " + odom);
        saveButton.click();
        log.info("Click to save button for save report.");
//        imgFinder.trailerNumberIR();
        log.info("Check to appear Trailer Number Alert.");
        waitToVisibilityOf(5, fieldAlert);
        Assert.assertEquals(fieldAlert.getText(), "Trailer number cannot be empty");
        alertOkButton.click();
        openTrailerWindow();
        checkMessageAboutEmptyTrailer();
        changeTrailerLicenseIr(trailerNumber, trailerLicense);
        closeTrailerChangeWindow();
        log.info("Enter Trailer Number: " + trailerNumber);
        checkTrailerNumberField(trailerNumber, trailerLicense);
        /*saveButton.click();
        log.info("Click to save button for save report.");
        imgFinder.trailerLicenseIR();*/
        remarksField.sendKeys(rem);
        log.info("Enter remarks: " + rem);
        Assert.assertEquals(remarksField.getText(), rem);
        return this;
    }

    public AddInspectionReport checkAlertIr(String alert) {
        switch (alert) {
            case ("trailernumber"): {
                waitToVisibilityOf(5, fieldAlert);
                Assert.assertEquals(fieldAlert.getText(), "Trailer number cannot be empty");
                alertOkButton.click();
                break;
            }
        }
        return this;
    }

    public AddInspectionReport inputIRwithoutLocation(String odom) {
        waitToBeClickable(5, odometerField);
        odometerField.sendKeys(odom);
        log.info("Enter odometer: " + odom);
        confirmSafeButton.click();
        log.info("Click to this vehicle safe to drive.");
        certifyCheckButton.click();
        log.info("Click to certify button.");
        getDataIR();
        log.info("Get info about created IR");
        scrollToAnElementByText(driver, "SAVE");
        saveButton.click();
        log.info("Click to save button for save report.");
        return this;
    }

    public AddInspectionReport inputDataIR(String loc, String odom, String rem) {
        waitToVisibilityOf(5, locationField);
        locationField.sendKeys(loc);
        log.info("Enter Location Report: " + loc);
        odometerField.sendKeys(odom);
        log.info("Enter odometer: " + odom);
        remarksField.sendKeys(rem);
        log.info("Enter remarks: " + rem);
        confirmSafeButton.click();
        log.info("Click to this vehicle safe to drive.");
        certifyCheckButton.click();
        log.info("Click to certify button.");
        getDataIR();
        log.info("Get info about created IR");
        trailerButton.click();
        log.info("Disable trailer add");
        saveButton.click();
        log.info("Click to save button for save report.");
        return this;
    }

    public AddInspectionReport disableTrailer() {
        waitToVisibilityOf(5, trailerButton);
        trailerButton.click();
        log.info("Disable Trailer.");
        return this;
    }

    public AddInspectionReport saveIR() {
        waitToVisibilityOf(5, saveButton);
        saveButton.click();
        log.info("Click to save button for save report.");
        return this;
    }

    public AddInspectionReport enableTrailer() {
        waitToVisibilityOf(5, trailerButton);
        trailerButton.click();
        log.info("Enable trailer in IR");
        return this;
    }

    public AddInspectionReport getDataIR() {
        location = locationField.getText();
        odometer = odometerField.getText();
        truckNumber = truckNumberField.getText();
        hoursInApp = hourField.getText();
        hours = Integer.parseInt(hourField.getText()) + differenceTimeZone;
        resultHours = String.valueOf(hours);
        minutes = minuteField.getText();
        return this;
    }

    public AddInspectionReport onDutySkip(boolean state, boolean statusSkipOnDuty, boolean statusSkipTandS) throws InterruptedException {
        CreateEvents createEvents = new CreateEvents();
        StatusPage statusPage = new StatusPage();
        waitToVisibilityOf(5, fieldAlert);
        Assert.assertEquals(fieldAlert.getText(), "Previous event is not On Duty, so you must add On Duty event after");
        if (statusSkipOnDuty) {
            skipOnDuty.click();
            log.info("Skip creating IR With On-Duty.");
        } else {
            createIrWithOnDuty.click();
            log.info("Create IR With On-Duty");
            createEvents.inputDataEvent(state, "Secondevent", " On-Duty");
            driver.hideKeyboard();
            log.info("Hide the keyboard");
            statusPage.saveEventButton.click();
            log.info("Save created event.");
            if (statusSkipTandS) {
                statusPage.skipTrailerShipping.click();
                log.info("Skip window adding trailer/shipping.");
            }
        }
        return this;
    }
}
