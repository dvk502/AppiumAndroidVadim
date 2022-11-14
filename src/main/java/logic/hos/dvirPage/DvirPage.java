package logic.hos.dvirPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import logic.hos.header.Header;

import logic.init.BasePage;
import logic.init.DateUtil;
import logic.web.companyProfile.IRPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DvirPage extends BasePage {
    protected static final Logger log = Logger.getLogger(DvirPage.class);

    @AndroidFindBy(xpath = "//*[@text='Add Inspection Report']")
    public MobileElement addInspectionReportTE;
    @AndroidFindBy(xpath = "//*[@text='Create Inspection Report']")
    public MobileElement addInspectionReportTrendy;
    @AndroidFindBy(id = projectLocator + ":id/textView_ir_time")
    private MobileElement createdTimeIR;
    @AndroidFindBy(id = projectLocator + ":id/textView_ir_truck_number")
    private MobileElement createdIRTruckNumber;
    @AndroidFindBy(id = projectLocator + ":id/textView_ir_location")
    private MobileElement locationCreatedIR;
    @AndroidFindBy(id = projectLocator + ":id/inspection_report_date_arrow_right")
    private MobileElement nextDateButton;
    @AndroidFindBy(id = projectLocator + ":id/editText_date")
    private MobileElement dateField;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_right_button")
    public MobileElement confirmDelete;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_left_button")
    public MobileElement denyDelete;
    @AndroidFindBy(id = projectLocator + ":id/inspection_report_date_arrow_left")
    public MobileElement backDateButton;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_msg_message")
    public MobileElement autoDrivingAlertIr;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_msg_ok")
    public MobileElement closeAlertIR;



    AddInspectionReport irPage = new AddInspectionReport();

    public String date;
    public static String checkResultHours;
    public static String checkResultMinutes;
    public static String saveDate;

    public DvirPage createIR() {
        if (projectName.equals("Trendy")) {
            waitToBeClickable(5, addInspectionReportTrendy);
            addInspectionReportTrendy.click();
            log.info("Open page creating IR");
        } else {
            waitToBeClickable(5, addInspectionReportTE);
            addInspectionReportTE.click();
            log.info("Open page creating IR");
        }
        return this;
    }

    public DvirPage checkAlertAutoDriving() {
        waitToVisibilityOf(5, autoDrivingAlertIr);
        Assert.assertEquals(autoDrivingAlertIr.getText(), "You can't make any changes while truck is in motion or on Driving status.\n" +
                "Please stop the truck or change current driving event manually and try again");
        log.info("Can't create IR in AutoDriving!");
        closeAlertIR.click();
        return this;
    }

    public DvirPage openCreatedIr(String number) {
        implicityWait(10);
        waitToVisibilityOf(10, driver.findElementByXPath("//*[@text='"+number+"']"));
        MobileElement element =  driver.findElementByXPath("//*[@text='"+number+"']");
        pressPoints(element.getCenter().getX(), element.getCenter().getY());
        log.info("Open created IR with Location - "+number);
        implicityWait(0);
        return this;
    }

    public DvirPage findCreatedIR() {
        log.info("Searching created Inspection report.");
        waitToVisibilityOf(5, createdTimeIR);
        log.info("Created Inspection report found! Comparing data.");
        checkResultHours = irPage.hoursInApp;
        if (Integer.parseInt(irPage.hoursInApp) < 10) {
            checkResultHours = "" + checkResultHours;
        }
        checkResultMinutes = irPage.minutes;
        if (Integer.parseInt(irPage.minutes) < 10) {
            checkResultMinutes = "" + checkResultMinutes;
        }
        if (Integer.parseInt(irPage.minutes) == 0) {
            checkResultMinutes = "0" + checkResultMinutes;
        }
        Assert.assertEquals(createdTimeIR.getText(), checkResultHours+":"+checkResultMinutes+" AKDT");
        log.info("Comparing time created Inspection report.");
        Assert.assertEquals(createdIRTruckNumber.getText(), irPage.truckNumber);
        log.info("Comparing truck number created Inspection report.");
        Assert.assertEquals(locationCreatedIR.getText(), irPage.location);
        log.info("Comparing location created Inspection report.");
        return this;
    }

    public DvirPage deleteIRForText(String number) {
        implicityWait(10);
        waitToVisibilityOf(5, createdIRTruckNumber);
        waitToVisibilityOf(10, driver.findElementByXPath("//*[@text='"+number+"']"));
        MobileElement element =  driver.findElementByXPath("//*[@text='"+number+"']");
        tapPoints(element.getCenter().getX(), element.getCenter().getY());
        log.info("Delete created Inspection Report.");
        waitToVisibilityOf(5, confirmDelete);
        confirmDelete.click();
        implicityWait(0);
        return this;
    }

    public DvirPage changeDateOnDvirPage() {
        waitToVisibilityOf(5, backDateButton);
        DateUtil date = new DateUtil();
        log.info("Back two days.");
        while (!dateField.getText().equals(date.getDeltaIrDay(null, -2))) {
            backDateButton.click();
            log.info("Date in app: "+dateField.getText()+" | Current date minus 2 days: "+date.getDeltaIrDay(null, -2));
        }
        saveDate = dateField.getText();
        return this;
    }

    public DvirPage checkDeleteIr(String number) {
        try {
            implicityWait(2);
            waitToVisibilityOf(10, driver.findElementByXPath("//*[@text='"+number+"']"));
            MobileElement element =  driver.findElementByXPath("//*[@text='"+number+"']");
            isElementPresent(1, element);
            Assert.assertTrue(false, "Inspection report has not been deleted!");
        } catch (Exception e) {
            log.info("Inspection report successfully deleted!");
        }
        implicityWait(0);
        return this;
    }

    public DvirPage setCurrentDate() {
        DateUtil date = new DateUtil();
        waitToVisibilityOf(5, dateField);
        this.date = dateField.getText();
        if(!this.date.equals(date.currentDateIR(null))) {
            nextDateButton.click();
            log.info("Click to next day button.");
            log.info("Displayed date in app: "+dateField.getText());
            log.info("Current date: "+date.currentDateIR(null));
            return setCurrentDate();
        } else {
            log.info("Current date compared with displayed IR date.");
        }
        return this;
    }
}
