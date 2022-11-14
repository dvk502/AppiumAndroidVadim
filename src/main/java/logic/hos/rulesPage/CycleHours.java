package logic.hos.rulesPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

import logic.init.BasePage;
import logic.init.DateUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class CycleHours extends BasePage {
    protected static final Logger log = Logger.getLogger(CycleHours.class);

    DateUtil date = new DateUtil();

    @AndroidFindBy(id = projectLocator + ":id/placeholder_1")
    public MobileElement dateCycle;
    @AndroidFindBy(id = projectLocator + ":id/placeholder_2")
    public MobileElement hoursUsed;
    @AndroidFindBy(id = projectLocator + ":id/placeholder_3")
    public MobileElement totalHoursSixDay;
    @AndroidFindBy(id = projectLocator + ":id/placeholder_4")
    public MobileElement totalHours;
    @AndroidFindBy(id = projectLocator + ":id/placeholder_5")
    public MobileElement totalHoursSevenDay;
    @AndroidFindBy(id = projectLocator + ":id/textView_cycle_hours_note")
    public MobileElement cycleHoursNoteElement;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[1]/android.widget.TextView[1]")
    public MobileElement dateCycleHours;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[2]/android.widget.TextView[1]")
    public MobileElement dateFirst;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[3]/android.widget.TextView[1]")
    public MobileElement dateSecond;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[4]/android.widget.TextView[1]")
    public MobileElement dateThird;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[5]/android.widget.TextView[1]")
    public MobileElement dateFourth;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[6]/android.widget.TextView[1]")
    public MobileElement dateFifth;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[7]/android.widget.TextView[1]")
    public MobileElement dateSixth;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[8]/android.widget.TextView[1]")
    public MobileElement dateSeventh;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[9]/android.widget.TextView[1]")
    public MobileElement dateEighth;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[10]/android.widget.TextView[1]")
    public MobileElement dateNinth;


    @Step("Table search Date, comparison of the displayed date with the expected current.")
    public CycleHours dateCycleHours() {
        if (isElementPresent(1, dateCycleHours)) {
            log.info("Compare the displayed date with the expected current.");
            Assert.assertEquals(dateFirst.getText(), date.getDateByDeltaDay(null, -6));
            log.info("The first day is the same as expected. Displayed day: "+dateFirst.getText() +" Expected: "+date.getDateByDeltaDay(null, -6));
            Assert.assertEquals(dateSecond.getText(), date.getDateByDeltaDay(null, -5));
            log.info("The second day is the same as expected. Displayed day: "+dateSecond.getText() +" Expected: "+date.getDateByDeltaDay(null, -5));
            Assert.assertEquals(dateThird.getText(), date.getDateByDeltaDay(null, -4));
            log.info("The third day is the same as expected. Displayed day: "+dateThird.getText() +" Expected: "+date.getDateByDeltaDay(null, -4));
            Assert.assertEquals(dateFourth.getText(), date.getDateByDeltaDay(null, -3));
            log.info("The fourth day is the same as expected. Displayed day: "+dateFourth.getText() +" Expected: "+date.getDateByDeltaDay(null, -3));
            Assert.assertEquals(dateFifth.getText(), date.getDateByDeltaDay(null, -2));
            log.info("The fifth day is the same as expected. Displayed day: "+dateFifth.getText() +" Expected: "+date.getDateByDeltaDay(null, -2));
            Assert.assertEquals(dateSixth.getText(), date.getDateByDeltaDay(null, -1));
            log.info("The sixth day coincides with the expected one. Displayed day: "+dateSixth.getText() +" Expected: "+date.getDateByDeltaDay(null, -1));
            Assert.assertEquals(dateSeventh.getText(), date.getDateByDeltaDay(null, 0));
            log.info("The seventh day is as expected. Displayed day: "+dateSeventh.getText() +" Expected: "+date.getDateByDeltaDay(null, 0));
            Assert.assertEquals(dateEighth.getText(), date.getDateByDeltaDay(null, 1));
            log.info("The eighth day is the same as expected. Displayed day: "+dateEighth.getText() +" Expected: "+date.getDateByDeltaDay(null, 1));
            Assert.assertEquals(dateNinth.getText(), date.getDateByDeltaDay(null, 2));
            log.info("The ninth day coincides with the expected one. Displayed day: "+dateNinth.getText() +" Expected: "+date.getDateByDeltaDay(null, 2));
        }
        return this;
    }

    @Step("We are looking for an notation at the bottom of the page")
    public CycleHours cycleHoursNote() {
        if (isElementPresent(1, cycleHoursNoteElement)) {
            log.info("The notation at the bottom of the page is displayed! Checking the text in the post with the expected one.");
            Assert.assertEquals(cycleHoursNoteElement.getText(), ("* Note that we are showing the driving time available tomorrow and the day after (" +date.getDateByDeltaDay(null, 1) + " and " + date.getDateByDeltaDay(null, 2) + "). Today's total hours assumes we have regained all the hours from " + date.getDateByDeltaDay(null, -7)));
            log.info("The text in the post is as expected. Displayed text: "+cycleHoursNoteElement.getText());
            log.info("Expected text: * Note that we are showing the driving time available tomorrow and the day after (" +date.getDateByDeltaDay(null, 1) + " and " + date.getDateByDeltaDay(null, 2) + "). Today's total hours assumes we have regained all the hours from " + date.getDateByDeltaDay(null, -7));
        }
        return this;
    }

    @Step("Looking for the rest of the elements on the page")
    public void searchElementsOnPage() {
        log.info("Trying to find an element Date");
        isElementPresentTrueFalse(dateCycle);
        Assert.assertEquals(dateCycle.getText(), "Date");
        log.info("Element Date found!");
        log.info("Trying to find an element Hours Used");
        isElementPresentTrueFalse(hoursUsed);
        Assert.assertEquals(hoursUsed.getText(), "Hours Used");
        log.info("Element Hours Used found!");
        log.info("Trying to find an element Total Hours (6 day)");
        isElementPresentTrueFalse(totalHoursSixDay);
        Assert.assertEquals(totalHoursSixDay.getText(), "Total Hrs\n(6-Day)");
        log.info("Element Total Hours (6 day) found!");
        log.info("Trying to find an element Total Hours.");
        isElementPresentTrueFalse(totalHours);
        Assert.assertEquals(totalHours.getText(), "Total Hrs\n(From-60)");
        log.info("Element Total Hours found!");
        log.info("Trying to find an element Total Hours (7 day).");
        isElementPresentTrueFalse(totalHoursSevenDay);
        Assert.assertEquals(totalHoursSevenDay.getText(), "Total Hrs\n(7-Day Max 60)");
        log.info("Element Total Hours (7 day) found!");
        screenshot();
    }
}
