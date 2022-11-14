package logic.hos.dotInspectPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import logic.hos.header.Header;
import logic.hos.logsPage.LogsPage;

import logic.init.BasePage;
import logic.init.DateUtil;
import logic.web.Customers;
import logic.web.companyProfile.Drivers;
import logic.web.companyProfile.General;
import org.apache.log4j.Logger;
import org.testng.Assert;


public class DotPage extends BasePage {
    protected static final Logger log = Logger.getLogger(DotPage.class);

    @AndroidFindBy(id = projectLocator + ":id/button_certify_records")
    public MobileElement certifyRecords;
    @AndroidFindBy(id = projectLocator + ":id/button_fragment_screen_dot_view_unidentified")
    public MobileElement unidentifiedRecords;
    @AndroidFindBy(id = projectLocator + ":id/button_start_inspection")
    public MobileElement startInspectionButton;
    @AndroidFindBy(id = projectLocator + ":id/editText_date")
    public MobileElement currentDate;
    @AndroidFindBy(id = projectLocator + ":id/imageView_date_back")
    public MobileElement dateBackButton;
    @AndroidFindBy(id = projectLocator + ":id/imageView_date_next")
    public MobileElement dateNextButton;
    @AndroidFindBy(id = projectLocator + ":id/textView_fragment_screen_dot_inspect_table_field_time_zone")
    public MobileElement currentHomeZone;
    @AndroidFindBy(id = projectLocator + ":id/textView_fragment_screen_dot_inspect_table_field_carrier")
    public MobileElement carrier;
    @AndroidFindBy(id = projectLocator + ":id/textView_fragment_screen_dot_inspect_table_field_current_location")
    public MobileElement currentLocation;
    @AndroidFindBy(id = projectLocator + ":id/textView_fragment_screen_dot_inspect_table_field_usdot")
    public MobileElement usDot;
    @AndroidFindBy(id = projectLocator + ":id/textView_fragment_screen_dot_inspect_table_field_driver")
    public MobileElement driverName;
    @AndroidFindBy(id = projectLocator + ":id/textView_fragment_screen_dot_inspect_table_field_eld_provider")
    public MobileElement currentEldProvider;
    @AndroidFindBy(id = projectLocator + ":id/textView_fragment_screen_dot_inspect_table_field_shipping_id")
    public MobileElement shippingNumbers;
    @AndroidFindBy(id = projectLocator + ":id/textView_fragment_screen_dot_inspect_table_field_trailers")
    public MobileElement trailerNumbers;

    @Step("Check all displayed attributes.")
    public DotPage checkAllDisplayedElements() {
        log.info("Try to Search buttons Certify Records, Unidentified Records, Start Inspection.");
        waitToVisibilityOf(5, certifyRecords);
        waitToVisibilityOf(5, unidentifiedRecords);
        waitToVisibilityOf(5, startInspectionButton);
        log.info("All buttons successfully found. Try to Search date buttons.");
        waitToVisibilityOf(5, dateBackButton);
        waitToVisibilityOf(5, dateNextButton);
        waitToVisibilityOf(5, currentDate);
        log.info("All date buttons successfully found!");
        checkCurrentDay();
        return this;
    }

    @Step("Compare the displayed day in the logbook with the current one")
    public DotPage checkCurrentDay() {
        DateUtil date = new DateUtil();
        if (currentDate.getText().equals(date.getLogDate(null))) {
            log.info("The current day is the same as the displayed!");
            return new DotPage();
        } else {
            log.info("We leaf through until today! Displayed day: " + currentDate.getText() + " Current day: " + date.getLogDate(null));
            dateNextButton.click();
            this.checkCurrentDay();
        }
        return new DotPage();
    }

    @Step("Check table with information.")
    public DotPage checkTable() {
        Header header = new Header();
        searchElementByText("Time Zone");
        Assert.assertEquals(Drivers.homeZone, currentHomeZone.getText());
        log.info("Compare displayed Home Zone on Web and in App.");
        searchElementByText("24 Per. Start Time");
        searchElementByText("Carrier");
        Assert.assertEquals(Customers.carrier, carrier.getText());
        log.info("Compare displayed Carrier on Web and in App");
        searchElementByText("Current Location");
        certifyRecords.click();
        waitToBeClickable(5, header.confirmBtn);
        header.confirmBtn.click();
        waitToBeClickable(5, currentLocation);
        Assert.assertEquals(LogsPage.currentLocation, currentLocation.getText());
        log.info("Compare displayed Current Location in Logs and on DOT Page");
        searchElementByText("USDOT #");
        Assert.assertEquals(General.usDot, usDot.getText());
        log.info("Compare displayed USDOT# on Web and in App");
        searchElementByText("Driver Name");
        Assert.assertEquals(Drivers.nameDriverValue + " " + Drivers.lastNameDriverValue, driverName.getText());
        log.info("Compare displayed Driver Name on Web and in App");
        searchElementByText("ELD Provider");
        Assert.assertEquals(currentEldProvider.getText(), eldName);
        log.info("Compare displayed ELD Provider.");
        searchElementByText("Shipping ID");
        Assert.assertEquals(shippingNumbers.getText(), LogsPage.shippingsString);
        log.info("Compare displayed in LOGS and DOT Inspect Shipping numbers.");
        searchElementByText("Trailer Number");
        Assert.assertEquals(trailerNumbers.getText(), LogsPage.trailersString);
        log.info("Compare displayed in LOGS and DOT Inspect Trailer numbers.");
        return this;
    }
}