package logic.hos.logsPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import logic.hos.dvirPage.AddInspectionReport;
import logic.hos.dvirPage.DvirPage;
import logic.hos.rulesPage.RulesPage;
import logic.init.BasePage;
import logic.init.DateUtil;
import logic.init.ImageSelector;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogsPage extends BasePage {

    protected static final Logger log = Logger.getLogger(LogsPage.class);

    DateUtil date = new DateUtil();
    RulesPage country = new RulesPage();
    ImageSelector imageFinder = new ImageSelector();
    DvirPage dvirPage = new DvirPage();
    AddInspectionReport irPage = new AddInspectionReport();
    CreateEvents events = new CreateEvents();


    @AndroidFindBy (id = projectLocator + ":id/editText_date")
    public MobileElement viewLogsDate;
    @AndroidFindBy (id = projectLocator + ":id/imageView_date_next")
    public MobileElement nextDay;
    @AndroidFindBy (id = projectLocator + ":id/imageView_date_back")
    public MobileElement previousDay;
    @AndroidFindBy (id = projectLocator + ":id/textView_ie_logs_item_location")
    public MobileElement eventLocation;
    @AndroidFindBy (id = projectLocator + ":id/insert_event")
    public MobileElement insertEventButton;
    @AndroidFindBy (id = projectLocator + ":id/dialog_alert_msg_message")
    public MobileElement alertDeleteEvent;
    @AndroidFindBy (id = projectLocator + ":id/dialog_alert_right_button")
    public MobileElement confirmDeleteEvent;
    @AndroidFindBy (id = projectLocator + ":id/dialog_alert_left_button")
    public MobileElement cancelDeleteEvent;
    @AndroidFindBy (id = projectLocator + ":id/label_border_crossing")
    public MobileElement eventName;
    @AndroidFindBy (id = projectLocator + ":id/textView_ie_logs_item_location")
    public List<MobileElement> eventLocationList;
    @AndroidFindBy (id = projectLocator + ":id/textView_ie_logs_item_shipping")
    public List<MobileElement> shippingNumbers;
    @AndroidFindBy (id = projectLocator + ":id/textView_ie_logs_item_trailers")
    public List<MobileElement> trailerNumbers;
    @AndroidFindBy (id = projectLocator + ":id/textView_ie_logs_item_image_status")
    public List<MobileElement> eventItemImage;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    public MobileElement firstItem;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]")
    public MobileElement secondItem;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView[3]")
    public MobileElement thirdItem;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView[4]")
    public MobileElement fourthItem;
    @AndroidFindBy (id = projectLocator + ":id/log_off_time")
    public MobileElement firstTimeItem;
    @AndroidFindBy (id = projectLocator + ":id/log_sb_time")
    public MobileElement secondTimeItem;
    @AndroidFindBy (id = projectLocator + ":id/log_d_time")
    public MobileElement thirdTimeItem;
    @AndroidFindBy (id = projectLocator + ":id/log_on_time")
    public MobileElement fourthTimeItem;
    @AndroidFindBy (id = projectLocator + ":id/textView_ie_logs_item_event_time")
    public List<MobileElement> eventTimeList;
    @AndroidFindBy (id = projectLocator + ":id/textView_ie_logs_item_event_time")
    public MobileElement eventTime;
    @AndroidFindBy (id = projectLocator + ":id/textView_ie_logs_item_duration_time")
    public List<MobileElement> durationEvents;
    @AndroidFindBy (id = projectLocator + ":id/button_ie_logs_item_edit_event")
    public MobileElement editEventButton;
    @AndroidFindBy (id = projectLocator + ":id/textView_dialog_trailer_shipping_editor_event_truck")
    public MobileElement displayedTruck;
    @AndroidFindBy (id = projectLocator + ":id/button_dialog_trailer_shipping_editor_cancel")
    public MobileElement buttonDialogTrailerCancel;
    @AndroidFindBy (id = projectLocator + ":id/textView_ie_logs_item_bc_event_time")
    public List<MobileElement> bcTimeList;
    @AndroidFindBy (id = projectLocator + ":id/textView_tree_view")
    public List<MobileElement> eventImage;

    @Step ("Checking changes information about event.")
    public LogsPage checkingChangesEvent(String location, String eventTimeCheck, String displayedOnEventTruck) {
        waitToVisibilityOf(5, eventLocation);
        log.info("We check if the location has changed at the event");
        Assert.assertEquals(eventLocation.getText(), location+", AL, US");
        log.info("Location changed correctly.");
        log.info("We check if the time has changed at the event");
        Assert.assertEquals(eventTime.getText(), eventTimeCheck);
        log.info("Time changed correctly.");
        eventLocation.click();
        waitToVisibilityOf(5, displayedTruck);
        log.info("We check if the truck has changed at the event");
        Assert.assertEquals(displayedTruck.getText(), displayedOnEventTruck);
        log.info("Truck changed correctly.");
        buttonDialogTrailerCancel.click();
        return this;
    }

    @Step ("Check displayed event after creating BC (OffDuty)")
    public LogsPage checkBcAfterOffDuty() {
        log.info("Check all displayed events, try to find OFF, BC, ON.");
        int number = 0;
        int timeNumber = 0;
        int bcTimeNumber = 0;
        for (MobileElement item : eventItemImage) {
            number++;
            log.info("Take " +number + " event.");
            items.add(item.getText());
        }
        /*Assert.assertEquals(items.get(0), "OFF");
        Assert.assertEquals(items.get(1), "BC");
        Assert.assertEquals(items.get(2), "ON");*/
        try {
            imageFinder.checkSetEventsBC("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (MobileElement time : eventTimeList ) {
            timeNumber++;
            times.add(time.getText());
            log.info("Take time "+timeNumber+ " event");
        }
        for (MobileElement bcTime : bcTimeList ) {
            bcTimeNumber++;
            bcTimes.add(bcTime.getText());
            log.info("Take BC time "+bcTimeNumber+" event");
        }
        Assert.assertEquals(times.get(0), "10:00:00");
        Assert.assertEquals(bcTimes.get(0), "10:30:00");
        Assert.assertEquals(times.get(1), "10:30:00");
        log.info("All displayed events compared with expected events.");
        return this;
    }

    @Step ("Check displayed event after creating BC (OnDuty)")
    public LogsPage checkBcAfterOnDuty() {
        log.info("Check all displayed events, try to find ON, BC.");
        int number = 0;
        int timeNumber = 0;
        int bcTimeNumber = 0;
        for (MobileElement item : eventItemImage) {
            number++;
            log.info("Take " +number + " event.");
            items.add(item.getText());
        }
        /*Assert.assertEquals(items.get(0), "ON");
        Assert.assertEquals(items.get(1), "BC");*/
        try {
            imageFinder.checkSetEventsBC("2");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (MobileElement time : eventTimeList ) {
            timeNumber++;
            times.add(time.getText());
            log.info("Take time "+timeNumber+ " event");
        }
        for (MobileElement bcTime : bcTimeList ) {
            bcTimeNumber++;
            bcTimes.add(bcTime.getText());
            log.info("Take BC time "+bcTimeNumber+" event");
        }
        Assert.assertEquals(times.get(0), "10:00:00");
        Assert.assertEquals(bcTimes.get(0), "10:30:00");
        log.info("All displayed events compared with expected events.");
        return this;
    }

    @Step ("Check displayed event after creating BC (Sleep)")
    public LogsPage checkBcAfterSleep() {
        log.info("Check all displayed events, try to find SB, BC, ON.");
        int number = 0;
        int timeNumber = 0;
        int bcTimeNumber = 0;
        for (MobileElement item : eventItemImage) {
            number++;
            log.info("Take " +number + " event.");
            items.add(item.getText());
        }
        /*Assert.assertEquals(items.get(0), "SB");
        Assert.assertEquals(items.get(1), "BC");
        Assert.assertEquals(items.get(2), "ON");*/
        try {
            imageFinder.checkSetEventsBC("3");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (MobileElement time : eventTimeList ) {
            timeNumber++;
            times.add(time.getText());
            log.info("Take time "+timeNumber+ " event");
        }
        for (MobileElement bcTime : bcTimeList ) {
            bcTimeNumber++;
            bcTimes.add(bcTime.getText());
            log.info("Take BC time "+bcTimeNumber+" event");
        }
        Assert.assertEquals(times.get(0), "10:00:00");
        Assert.assertEquals(bcTimes.get(0), "10:30:00");
        Assert.assertEquals(times.get(1), "10:30:00");
        log.info("All displayed events compared with expected events.");
        return this;
    }

    @Step ("Check displayed event after creating BC (Driving)")
    public LogsPage checkBcAfterDriving() {
        log.info("Check all displayed events, try to find D, BC.");
        int number = 0;
        int timeNumber = 0;
        int bcTimeNumber = 0;
        for (MobileElement item : eventItemImage) {
            number++;
            log.info("Take " +number + " event.");
            items.add(item.getText());
        }
        /*Assert.assertEquals(items.get(0), "D");
        Assert.assertEquals(items.get(1), "BC");*/
        try {
            imageFinder.checkSetEventsBC("4");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (MobileElement time : eventTimeList ) {
            timeNumber++;
            times.add(time.getText());
            log.info("Take time "+timeNumber+ " event");
        }
        for (MobileElement bcTime : bcTimeList ) {
            bcTimeNumber++;
            bcTimes.add(bcTime.getText());
            log.info("Take BC time "+bcTimeNumber+" event");
        }
        Assert.assertEquals(times.get(0), "10:00:00");
        Assert.assertEquals(bcTimes.get(0), "10:30:00");
        log.info("All displayed events compared with expected events.");
        return this;
    }

    @Step ("Check displayed event after creating BC without On-Duty")
    public LogsPage checkBcWithOnDuty() {
        log.info("Check all displayed events, try to find BC without On-Duty");
        int number = 0;
        int timeNumber = 0;
        int bcTimeNumber = 0;
        for (MobileElement item : eventItemImage) {
            number++;
            log.info("Take " +number + " event.");
            items.add(item.getText());
        }
        /*Assert.assertEquals(items.get(0), "BC");
        Assert.assertEquals(items.get(1), "ON");*/
        try {
            imageFinder.checkSetEventsBC("6");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (items.size() > 2) {
            Assert.fail("Found more that 2 events (BC and On-Duty).");
        }
        for (MobileElement time : eventTimeList ) {
            timeNumber++;
            times.add(time.getText());
            log.info("Take time "+timeNumber+ " event");
        }
        for (MobileElement bcTime : bcTimeList ) {
            bcTimeNumber++;
            bcTimes.add(bcTime.getText());
            log.info("Take BC time "+bcTimeNumber+" event");
        }
        Assert.assertEquals(bcTimes.get(0), "10:30:00");
        Assert.assertEquals(times.get(0), "10:30:00");
        log.info("All displayed events compared with expected events.");
        return this;
    }

    @Step ("Check displayed event after creating BC with On-Duty")
    public LogsPage checkBcWithoutOnDuty() {
        log.info("Check all displayed events, try to find BC with On-Duty");
        int number = 0;
        int timeNumber = 0;
        int bcTimeNumber = 0;
        for (MobileElement item : eventItemImage) {
            number++;
            log.info("Take " +number + " event.");
            items.add(item.getText());
        }
//        Assert.assertEquals(items.get(0), "BC");
        try {
            imageFinder.checkSetEventsBC("5");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (items.size() > 1) {
            Assert.fail("Found more that 1 event (BC).");
        }
        for (MobileElement bcTime : bcTimeList ) {
            bcTimeNumber++;
            bcTimes.add(bcTime.getText());
            log.info("Take BC time "+bcTimeNumber+" event");
        }
        Assert.assertEquals(bcTimes.get(0), "10:30:00");
        log.info("All displayed events compared with expected events.");
        return this;
    }

    @Step ("Edit first event in list")
    public LogsPage editFirstEvent() {
        waitToVisibilityOf(5, editEventButton);
        editEventButton.click();
        log.info("Click to edit event button.");
        return this;
    }

    @Step ("Compare the displayed day in the logbook with the current one")
    public LogsPage checkCurrentDay() {
        if (viewLogsDate.getText().equals(date.getLogDate(null))) {
            log.info("The current day is the same as the displayed!");
            return new LogsPage();
        } else {
            log.info("We leaf through until today! Displayed day: "+viewLogsDate.getText()+ " Current day: "+date.getLogDate(null));
            nextDay.click();
            this.checkCurrentDay();
        }
        return new LogsPage();
    }

    public ArrayList<String> items = new ArrayList<>();
    public ArrayList<String> times = new ArrayList<>();
    public ArrayList<String> durations = new ArrayList<>();
    public ArrayList<String> bcTimes = new ArrayList<>();

    @Step ("Check all elements on page.")
    public LogsPage checkElements() {
        int number = 0;
        int numberLastElement = 0;
        Assert.assertEquals(firstItem.getText(), "OFF");
        Assert.assertEquals(secondItem.getText(), "SB");
        Assert.assertEquals(thirdItem.getText(), "D");
        Assert.assertEquals(fourthItem.getText(), "ON");
        Assert.assertEquals(firstTimeItem.getText(), "06:00");
        Assert.assertEquals(secondTimeItem.getText(), "04:00");
        Assert.assertEquals(thirdTimeItem.getText(), "12:30");
        Assert.assertEquals(fourthTimeItem.getText(), "01:30");
        waitToVisibilityOf(5, viewLogsDate);
        Assert.assertEquals(viewLogsDate.getText(), date.getDeltaIrDay(null, -1));
        waitToVisibilityOf(5, insertEventButton);
        waitToVisibilityOf(5, nextDay);
        waitToVisibilityOf(5, previousDay);
        //scrollToElementTouchActions(driver.findElementByXPath("//text[@value=\"Tr: lastEvent\"]"));
        //scrollToAnElementByText(driver, "Tr: lastEvent");
        try {
            swipe(250, 517, 250, 270, 100);
            log.info("Scroll to bottom page.");
            Thread.sleep (1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*new TouchAction(driver).press(PointOption.point(40, 517)).moveTo(PointOption.point(40, 270)).release().perform();*/
        for (MobileElement item : eventItemImage) {
            number++;
            log.info("Take " +number + " event.");
            items.add(item.getText());
        }


        /*for (MobileElement item : eventItemImage) {
            if(numberLastElement++ == eventItemImage.size()-1) {
                log.info("Take " +(number+1) + " event.");
                items.add(item.getText());
            }
        }*/
        /*Assert.assertEquals(items.get(0), "ON");
        Assert.assertEquals(items.get(1), "D");
        Assert.assertEquals(items.get(2), "OFF");
        Assert.assertEquals(items.get(3), "ON");
        Assert.assertEquals(items.get(4), "D");
        Assert.assertEquals(items.get(5), "OFF");
        Assert.assertEquals(items.get(6), "SB");*/
        try {
            imageFinder.checkSetEventsLogsPage("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int timeNumber = 0;
        List<MobileElement> timeList = driver.findElementsById(projectLocator + ":id/textView_ie_logs_item_event_time");
        for (int i = 0; i < timeList.size(); i++) {
            waitToVisibilityOf(5, timeList.get(i));
            timeNumber++;
            times.add(timeList.get(i).getText());
            log.info("Take time "+timeNumber+ " event: "+timeList.get(i).getText());
        }
        /*for (MobileElement time : eventTimeList) {
            MobileElement eventTime = time;
            waitToVisibilityOf(5, eventTime);
            timeNumber++;
            times.add(eventTime.getText());
            log.info("Take time "+timeNumber+ " event: "+time.getText());
        }*/
        Assert.assertEquals(times.get(0), "02:00:00");
        Assert.assertEquals(times.get(1), "03:00:00");
        Assert.assertEquals(times.get(2), "09:00:00");
        Assert.assertEquals(times.get(3), "11:00:00");
        Assert.assertEquals(times.get(4), "11:30:00");
        Assert.assertEquals(times.get(5), "18:00:00");
        Assert.assertEquals(times.get(6), "20:00:00");
        int durationNumber = 0;
        for (MobileElement duration : durationEvents) {
            MobileElement eventDuration = duration;
            waitToVisibilityOf(5, eventDuration);
            durationNumber++;
            durations.add(eventDuration.getText());
            log.info("Take duration "+durationNumber+" event: " + duration.getText());
        }
        String lastEventTimeAtMoment1 = date.getDeltaEventMinute2(null);
        String lastEventTimeAtMoment2 = date.getDeltaEventMinute3(null);
        int changedLastEventTimeAtMoment1 = Integer.parseInt(lastEventTimeAtMoment1);
        int changedLastEventTimeAtMoment2 = Integer.parseInt(lastEventTimeAtMoment2);
        Assert.assertEquals(durations.get(0), "1h 0s");
        Assert.assertEquals(durations.get(1), "6h 0s");
        Assert.assertEquals(durations.get(2), "2h 0s");
        Assert.assertEquals(durations.get(3), "30m 0s");
        Assert.assertEquals(durations.get(4), "6h 30m 0s");
        Assert.assertEquals(durations.get(5), "2h 0s");
        int newMinutesCheck = Integer.parseInt(date.getDeltaEventMinute2(null));
        if (newMinutesCheck>9) {
            int hours = Integer.parseInt(date.getDeltaEventHours2(null, 0));
            if (hours>9) {
                int newHours = Integer.parseInt(date.getDeltaEventHours2(null, 0));
                try {
                    Assert.assertEquals(durations.get(6).substring(0, 7), (newHours) + "h " + changedLastEventTimeAtMoment1 + "m" /*+ (newSeconds-different) + "s"*/);
                } catch (AssertionError e) {
                    try {
                        Assert.assertEquals(durations.get(6).substring(0, 7), (newHours) + "h " + ((changedLastEventTimeAtMoment1) + 1) + "m" /*+ (newSeconds-different) + "s"*/);
                    } catch (AssertionError d) {
                        Assert.assertEquals(durations.get(6).substring(0, 7), (newHours) + "h " + ((changedLastEventTimeAtMoment1) + 2) + "m" /*+ (newSeconds-different) + "s"*/);
                    }
                }
            } else {
                int newHours = Integer.parseInt(date.getDeltaEventHours3(null, 0));
                try {
                    Assert.assertEquals(durations.get(6).substring(0, 6), (newHours) + "h " + changedLastEventTimeAtMoment1 + "m" /*+ (newSeconds-different) + "s"*/);
                } catch (AssertionError e) {
                    try {
                        Assert.assertEquals(durations.get(6).substring(0, 6), (newHours) + "h " + ((changedLastEventTimeAtMoment1) + 1) + "m" /*+ (newSeconds-different) + "s"*/);
                    } catch (AssertionError d) {
                        Assert.assertEquals(durations.get(6).substring(0, 6), (newHours) + "h " + ((changedLastEventTimeAtMoment1) + 2) + "m" /*+ (newSeconds-different) + "s"*/);
                    }
                }
            }
        } else {
            if (newMinutesCheck>=1) {
                int hours = Integer.parseInt(date.getDeltaEventHours2(null, 0));
                if (hours > 9) {
                    int newHours = Integer.parseInt(date.getDeltaEventHours2(null, 0));
                    try {
                        Assert.assertEquals(durations.get(6).substring(0, 7), (newHours) + "h " + changedLastEventTimeAtMoment2 + "m " /*+ (newSeconds-different) + "s"*/);
                    } catch (AssertionError e) {
                        try {
                            Assert.assertEquals(durations.get(6).substring(0, 7), (newHours) + "h " + ((changedLastEventTimeAtMoment2) + 1) + "m " /*+ (newSeconds-different) + "s"*/);
                        } catch (AssertionError d) {
                            Assert.assertEquals(durations.get(6).substring(0, 7), (newHours) + "h " + ((changedLastEventTimeAtMoment2) + 2) + "m " /*+ (newSeconds-different) + "s"*/);
                        }
                    }
                } else {
                    int newHours = Integer.parseInt(date.getDeltaEventHours3(null, 0));
                    try {
                        Assert.assertEquals(durations.get(6).substring(0, 6), (newHours) + "h " + changedLastEventTimeAtMoment2 + "m " /*+ (newSeconds-different) + "s"*/);
                    } catch (AssertionError e) {
                        try {
                            Assert.assertEquals(durations.get(6).substring(0, 6), (newHours) + "h " + ((changedLastEventTimeAtMoment2) + 1) + "m " /*+ (newSeconds-different) + "s"*/);
                        } catch (AssertionError d) {
                            Assert.assertEquals(durations.get(6).substring(0, 6), (newHours) + "h " + ((changedLastEventTimeAtMoment2) + 2) + "m " /*+ (newSeconds-different) + "s"*/);
                        }
                    }
                }
            } else {
                int hours = Integer.parseInt(date.getDeltaEventHours2(null, 0));
                if (hours > 9) {
                    int newHours = Integer.parseInt(date.getDeltaEventHours2(null, 0));
                    Assert.assertEquals(durations.get(6).substring(0, 4), (newHours) + "h " /*+ date.getDeltaEventMinute3(null) + "m" + (newSeconds-different) + "s"*/);
                } else {
                    int newHours = Integer.parseInt(date.getDeltaEventHours3(null, 0));
                    Assert.assertEquals(durations.get(6).substring(0, 4), (newHours) + "h " /*+ date.getDeltaEventMinute3(null) + "m " + (newSeconds-different) + "s"*/);
                }
            }
        }
        log.info("All events items compared with expected.");
        return this;
    }

    @Step ("Checking the allowed number of days in the logbook.")
    public LogsPage checkDays() {
        if (RulesPage.countryP.equals("USA")) {
            log.info("Current rules: " + RulesPage.countryP + ". Going back 7 days");
            int i;
            for (i = 0; i < 7; i++) {
                previousDay.click();
                log.info("Current day: "+date.getLogDate(null)+ ". Displayed day :" +viewLogsDate.getText());
            }
            String lastDayUsa = viewLogsDate.getText();
            log.info("Checking whether it is possible to scroll more than 7 days ago.");
            previousDay.click();
            log.info("Going back 1 day");
            Assert.assertEquals(viewLogsDate.getText(), lastDayUsa);
//            viewLogsDate.equals(lastDayUsa);
            log.info("The logbook does not display for more than 7 days, you cannot scroll further. The day before clicking back: " +lastDayUsa + ". Day after clicking back: " +viewLogsDate.getText());

        } else {
            log.info("Current rules: " + RulesPage.countryP + ". . Going back 14 days.");
            int b;
            for (b = 0; b < 14; b++) {
                previousDay.click();
                log.info("Current day: "+date.getLogDate(null)+ ". Listing days CAN :" +viewLogsDate.getText());
            }
            String lastDayCan = viewLogsDate.getText();
            log.info("Checking whether it is possible to scroll more than 7 days ago.");
            previousDay.click();
            log.info("Going back 1 day");
            Assert.assertEquals(viewLogsDate.getText(), lastDayCan);
//            viewLogsDate.equals(lastDayCan);
            log.info("The logbook does not display more than 14 days, you cannot scroll further. The day before clicking back: " +lastDayCan + ". Day after clicking back: " +viewLogsDate.getText());
        }
        return this;
    }


    public LogsPage onDutyShouldBeDisplayedInLogs(boolean result) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        if (result) {
            //wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//*[@text='ON' and @resource-id='"+ projectLocator + ":id/textView_tree_view']")));
            wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//*[@text='PTI On-Duty' and @resource-id='"+ projectLocator + ":id/textView_ie_logs_item_comment']")));
            wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//*[@text='Secondevent, KS, US' and @resource-id='"+ projectLocator + ":id/textView_ie_logs_item_location']")));
            log.info("On-Duty created successfully!");
        } else {
            try {
                wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//*[@text='ON' and @resource-id='"+ projectLocator + ":id/textView_ie_logs_item_image_status']")));
                Assert.fail("On-Duty was found!");
            } catch (Exception e) {
                log.info("On-Duty was not created! Continue the test.");
            }
        }
        return this;
    }

    public LogsPage pressToPreviousDay() {
        waitToVisibilityOf(5, previousDay);
        previousDay.click();
        return this;
    }

    @Step("Try delete event")
    public LogsPage deleteEventDisableAllow() {
        waitToVisibilityOf(5, eventLocation);
        int cordX = eventLocation.getCenter().getX();
        int cordY = eventLocation.getCenter().getY();
        tapPoints(cordX, cordY);
        log.info("Long press to event for delete");
        if (!isElementPresent(2, alertDeleteEvent)) {
            log.info("The event could not be deleted, the checkbox is working");
            return this;
        } else {
            Assert.fail("The event can be deleted, the checkbox does not work!");
        }
        return this;
    }

    @Step("Delete event")
    public LogsPage deleteEvent(boolean status) {
        waitToVisibilityOf(5, eventLocation);
        int cordX = eventTime.getCenter().getX();
        int cordY = eventTime.getCenter().getY();
        tapPoints(cordX, cordY);
        log.info("Long press to event for delete");
        waitToVisibilityOf(5, alertDeleteEvent);
        Assert.assertEquals(alertDeleteEvent.getText(), "Do you want to confirm the deletion of the Duty Status Event?");
        log.info("We check the appearance of the warning about the deletion of the event");
        if (status) {
            confirmDeleteEvent.click();
            log.info("We confirm the deletion of the event");
        } else {
            cancelDeleteEvent.click();
            log.info("We canceled deletion of the event");
            waitToVisibilityOf(5, eventLocation);
        }
        return this;
    }

    @Step("Search created IR on graph and in event list.")
    public LogsPage searchCreatedIR(boolean status) {
        log.info("Search created IR on graph and in event list");
        if (status) {
            try {
                waitToVisibilityOf(5, events.irEventTime);
                imageFinder.InspectionReportOnGraph();
                log.info("Created IR found on graph!");
                String correctTime = events.irEventTime.getText();
                Assert.assertEquals(correctTime.substring(0, 5), DvirPage.checkResultHours + ":" + DvirPage.checkResultMinutes);
                Assert.assertEquals(eventName.getText(), "Inspection Report");
                log.info("Created IR found in event list. IR Event Time: " + correctTime.substring(0, 5));
            } catch (Exception e) {
                Assert.fail("IR Not found on graph");
            }
        } else {
            try {
                waitToBeClickable(5, events.irEventTime, false);
                imageFinder.InspectionReportOnGraph();
                Assert.fail("Created IR found on graph!");
            } catch (Exception e) {
                log.info("IR not found on graph!");
            }
        }
        return this;
    }

    public LogsPage checkDeleteIrOnGraph() {
        log.info("Compare date in DVIR (When we delete IR) and date on graph in LOGS.");
        Assert.assertEquals(viewLogsDate.getText(), DvirPage.saveDate);
        log.info("Date matches!");
        try {
            imageFinder.InspectionReportOnGraph();
            Assert.fail("IR was found on graph! IR was not deleted.");
        } catch (Exception e) {
            log.info("IR successfully deleted and not found on graph.");
        }
        return this;
    }

    public static String currentLocation;

    @Step("Take Current Location on last event.")
    public LogsPage currentLocationTake() {
        int lastId = -1;
        for (MobileElement location : eventLocationList) {
            lastId++;
        }
        currentLocation = eventLocationList.get(lastId).getText();
        return this;
    }

    public ArrayList<String> shippings = new ArrayList<>();
    public ArrayList<String> trailers = new ArrayList<>();
    public static String shippingsString;
    public static String trailersString;

    @Step("Take Shipping on events.")
    public LogsPage shippingTake() {
        
        for (MobileElement shipping : shippingNumbers) {
            shippings.add(shipping.getText().substring(4));
        }
        shippingsString = String.join(", ", shippings);
        Assert.assertEquals(shippingsString, "Ship1, Ship2, Ship3, Ship4");
        return this;
    }

    @Step("Take Trailer on events.")
    public LogsPage trailerTake() {

        for (MobileElement trailer : trailerNumbers) {
            trailers.add(trailer.getText().substring(4));
        }
        trailersString = String.join(", ", trailers);
        Assert.assertEquals(trailersString, "Trailer1, Trailer2, Trailer3, Trailer4");
        return this;
    }
}
