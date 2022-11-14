package logic.web.companyProfile;

import io.qameta.allure.Step;
import logic.hos.logsPage.CreateEvents;
import logic.init.BasePageWeb;
import logic.init.Credentials;
import logic.init.DateUtil;
import logic.init.ListenersWeb;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@org.testng.annotations.Listeners(ListenersWeb.class)
public class HosPage extends BasePageWeb {
    protected static final Logger log = Logger.getLogger(HosPage.class);

    @FindBy (css = "span[class='ng-binding text-on']")
    public WebElement eventNameOnDuty;
    @FindBy (css = "span[class='ng-binding text-sleep']")
    public WebElement eventNameSleeper;
    @FindBy (xpath = "/html/body/div[3]/div[3]/div/div[1]/div/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div/span")
    public WebElement eventTime;
    @FindBy (xpath = "/html/body/div[3]/div[3]/div/div[1]/div/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[3]/div")
    public WebElement eventTrailer;
    @FindBy (xpath = "/html/body/div[3]/div[3]/div/div[1]/div/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[4]/div")
    public WebElement eventShipping;
    @FindBy (xpath = "/html/body/div[3]/div[3]/div/div[1]/div/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div[7]/div/span")
    public WebElement eventComment;
    @FindBy (xpath = "/html/body/div[3]/div[3]/div/div[1]/div/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[7]/div/span")
    public WebElement eventCommentWheel;
    @FindBy (css = "a[ng-click=\"vm.changeTab('inspectionReport')\"]")
    public WebElement dvirButton;

    CreateEvents events = new CreateEvents();

    @Step("Compare Event Data Sleeper Berth in App and on WEB")
    public HosPage compareCommentEvent(boolean type) {
        try {
            Thread.sleep(80000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updatePageHos();
        if (type) {
            waitToVisibilityOf(5, eventComment);
            log.info("Comparing comment in App ( " + CreateEvents.elementText + " ) and comment on Web ( " + eventComment.getText() + " ).");
            Assert.assertEquals(eventComment.getText(), CreateEvents.elementText);
            log.info("Comments compare!");
        } else {
            waitToVisibilityOf(5, eventCommentWheel);
            log.info("Comparing comment in App ( " + CreateEvents.elementText + " ) and comment on Web ( " + eventCommentWheel.getText() + " ).");
            Assert.assertEquals(eventCommentWheel.getText(), CreateEvents.elementText);
            log.info("Comments compare!");
        }
        return this;
    }

    @Step("Compare Event Data On-Duty in App and on WEB")
    public HosPage compareEventDataOnDuty(String trailer, String shipping) {
        CreateEvents events = new CreateEvents();
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updatePageHos();
        waitToVisibilityOf(5, eventNameOnDuty);
        log.info("Compare event name in app and on WEB.");
        Assert.assertEquals(eventNameOnDuty.getText(), "On Duty");
        log.info("Event name match! Event name in app: On Duty, event name on WEB: "+eventNameOnDuty.getText());
        log.info("Compare event time start in app and on WEB.");
        Assert.assertEquals(eventTime.getText(),DateUtil.getEventDate(null)+events.eventTimeTake().time);
        log.info("Event time start match! Event time start in app: "+DateUtil.getEventDate(null)+events.eventTimeTake().time+", event time start on WEB: "+eventTime.getText());
        log.info("Compare Event trailer in app and on WEB.");
        Assert.assertEquals(eventTrailer.getText(), trailer);
        log.info("Event trailer match! Event trailer in app: "+trailer+", event trailer on WEB: "+eventTrailer.getText());
        log.info("Compare Event Shipping in app and on WEB.");
        Assert.assertEquals(eventShipping.getText(), shipping);
        log.info("Event Shipping match! Event shipping in app: "+shipping+", event shipping on WEB: "+eventShipping.getText());
        return this;
    }

    @Step("Compare Event Data Sleeper Berth in App and on WEB")
    public HosPage compareEventDataSleep() {
        CreateEvents events = new CreateEvents();
        Credentials cred = new Credentials();
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updatePageHos();
        waitToVisibilityOf(5, eventNameSleeper);
        log.info("Compare event name in app and on WEB.");
        Assert.assertEquals(eventNameSleeper.getText(), "Sleeper Berth");
        log.info("Event name match! Event name in app: Sleeper Berth, event name on WEB: "+eventNameSleeper.getText());
        log.info("Compare event time start in app and on WEB.");
        Assert.assertEquals(eventTime.getText(),DateUtil.getEventDate(null)+events.eventTimeTake().time);
        log.info("Event time start match! Event time start in app: "+DateUtil.getEventDate(null)+events.eventTimeTake().time+", event time start on WEB: "+eventTime.getText());
        log.info("Compare Event trailer in app and on WEB.");
        Assert.assertEquals(eventTrailer.getText(), cred.sleepEventData().EVENTTRAILER);
        log.info("Event trailer match! Event trailer in app: "+cred.sleepEventData().EVENTTRAILER+", event trailer on WEB: "+eventTrailer.getText());
        log.info("Compare Event Shipping in app and on WEB.");
        Assert.assertEquals(eventShipping.getText(), cred.sleepEventData().EVENTSHIPPING);
        log.info("Event Shipping match! Event shipping in app: "+cred.sleepEventData().EVENTSHIPPING+", event shipping on WEB: "+eventShipping.getText());
        return this;
    }

    @Step("Compare Event Data On-Duty (from Wheel) in App and on WEB")
    public HosPage compareEventDataWheelOnDuty() {
        CreateEvents events = new CreateEvents();
        try {
            Thread.sleep(80000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updatePageHos();
        waitToVisibilityOf(5, eventNameOnDuty);
        log.info("Compare event name in app and on WEB.");
        Assert.assertEquals(eventNameOnDuty.getText(), "On Duty");
        log.info("Event name match! Event name in app: On Duty, event name on WEB: "+eventNameOnDuty.getText());
        log.info("Compare event time start in app and on WEB.");
        Assert.assertEquals(eventTime.getText(),DateUtil.getEventDate(null)+events.eventTimeTakeSecond().time);
        log.info("Event time start match! Event time start in app: "+DateUtil.getEventDate(null)+events.eventTimeTakeSecond().time+", event time start on WEB: "+eventTime.getText());


        return this;
    }

    @Step("Update HOS Page")
    public HosPage updatePageHos() {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            log.error(e);
        }
        log.info("Update HOS Page on WEB");
        return this;
    }

    @Step("Open DVIR Page")
    public HosPage openDvirPage() {
        waitToVisibilityOf(5, dvirButton);
        dvirButton.click();
        log.info("Open Inspection report page.");
        return this;
    }
}
