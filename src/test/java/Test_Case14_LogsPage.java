import com.automation.remarks.testng.UniversalVideoListener;
import logic.dbConnection.SqlRequests;
import logic.hos.header.Header;
import logic.hos.logsPage.CreateEvents;
import logic.hos.logsPage.LogsPage;
import logic.hos.statusPage.StatusPage;
import logic.init.*;
import logic.loginPage.LoginPage;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

@Listeners(UniversalVideoListener.class)
public class Test_Case14_LogsPage extends BasePage {


    @Test(priority = 1, description = "1")
    public void test_1() throws InterruptedException, SQLException, IOException {
        //--------------------------------------
        Credentials cred = new Credentials();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        StatusPage statusPage = new StatusPage();
        ImageSelector image = new ImageSelector();
        LogsPage logs = new LogsPage();
        CreateEvents eventCreate = new CreateEvents();
        DateUtil date = new DateUtil();
        //--------------------------------------
        SqlRequests
                .deleteEvents(88154);
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logoutCurrentDriver(true);
        loginPage
                .logoutWait();
        SqlRequests.takeLastEventSequence(92807);
        SqlRequests.addEvent("On-Duty", 92807, 5891, 1, 2, 1, 4, date.getDeltaEventDays(null, -1)+" 06:00:00", "4fe54670b860ae64", "Nikolaev, AL, US", "0", "", "", SqlRequests.nextSequence+1, 309473, "");
        SqlRequests.addEvent("Driving", 92807, 5891, 1, 2, 1, 3, date.getDeltaEventDays(null, -1)+" 07:00:00", "4fe54670b860ae64", "Nikolaev, AL, US", "0", "", "", SqlRequests.nextSequence+2, 309473, "");
        SqlRequests.addEvent("Off-Duty", 92807, 5891, 1, 2, 1, 1, date.getDeltaEventDays(null, -1)+" 13:00:00", "4fe54670b860ae64", "Nikolaev, AL, US", "0", "", "", SqlRequests.nextSequence+3, 309473, "");
        SqlRequests.addEvent("On-Duty", 92807, 5891, 1, 2, 1, 4, date.getDeltaEventDays(null, -1)+" 15:00:00", "4fe54670b860ae64", "Nikolaev, AL, US", "0", "", "", SqlRequests.nextSequence+4, 309473, "");
        SqlRequests.addEvent("Driving", 92807, 5891, 1, 2, 1, 3, date.getDeltaEventDays(null, -1)+" 15:30:00", "4fe54670b860ae64", "Nikolaev, AL, US", "0", "", "", SqlRequests.nextSequence+5, 309473, "");
        SqlRequests.addEvent("Off-Duty", 92807, 5891, 1, 2, 1, 1, date.getDeltaEventDays(null, -1)+" 22:00:00", "4fe54670b860ae64", "Nikolaev, AL, US", "0", "", "", SqlRequests.nextSequence+6, 309473, "");
        SqlRequests.addEvent("Sleeping Berth", 92807, 5891, 1, 2, 1, 2, date.getDeltaEventDays(null, 0)+" 00:00:00", "4fe54670b860ae64", "Nikolaev, AL, US", "0", "", "lastEvent", SqlRequests.nextSequence+7, 309473, "");
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        logs
                .pressToPreviousDay();
        Thread.sleep(1000);
        image
                .findAllViolations();
        image
                .compareGraphEvents();
        logs
                 .checkElements();
        header
                .logoutCurrentDriver(false);
        SqlRequests
                .deleteEvents(92807);
        SqlRequests
                .addEvent("On-Duty", 92807, 5891, 1, 2, 1, 4, date.getDeltaEventDays(null, -1)+" 13:00:00", "4fe54670b860ae64", "Nikolaev, AL, US", "0", "", "", SqlRequests.nextSequence+1, 309473, "Nikolaev");
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        logs
                .pressToPreviousDay()
                .editFirstEvent();
        eventCreate
                .inputHourEvent("12")
                .nextPageEventCreate()
                .checkDisplayedEvents()
                .chooseEventSleeper()
                .openListTrucks();
        Thread.sleep(3000);
        searchAndClickElementByText("TestTruck1638441050133");
        eventCreate
                .nextPageEventCreate()
                .skipTrailersAndShipping()
                //.checkStateEvent()
                .changeLocationEvent("SweetHome", true)
                .nextPageEventCreate();
        statusPage
                .closeMessageUncertified();
        logs
                .checkingChangesEvent("SweetHome", "12:00:00", "TestTruck1638441050133")
                .deleteEvent(false)
                .deleteEvent(true)
                .checkCurrentDay();
        image
                .findCountryIconUsa();
        eventCreate
                .openEventCreatePage()
                .chooseEventDriving()
                .eventDateMoreThanCurrentDateUsa()
                .eventTimeMoreThanCurrentTime(1)
                .eventMinuteMoreThanCurrentTime(1)
                .eventDateLessThanFirstDateEventUsa()
                .eventHoursLessThanFirstDayTimeEvent();
        header
                .backMenu()
                .backMenu()
                .countryFlagChangeToCanada();
        image
                .findCountryIconCanada();
        logs
                .checkCurrentDay();
        eventCreate
                .openEventCreatePage()
                .chooseEventDriving()
                .eventDateMoreThanCurrentDateCan()
                .eventTimeMoreThanCurrentTime(1)
                .eventMinuteMoreThanCurrentTime(1)
                .eventDateLessThanFirstDateEventCan()
                .eventHoursLessThanFirstDayTimeEvent();
        header
                .backMenu()
                .backMenu();
        header
                .logoutCurrentDriver(true);
        loginPage
                .logoutWait();
        loginPage
                .loginCurrentDr("statustest1", "test");
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        logs
                .checkCurrentDay()
                .pressToPreviousDay();
        eventCreate
                .openEventCreatePage();
        searchAndClickElementByText("BC");
        eventCreate
                .inputHourEvent("8")
                .inputMinuteEvent("0")
                .nextPageEventCreate()
                .addOnDutyWithBc(false)
                .selectBcType();
        searchAndClickElementByText("U.S.A to Canada");
        eventCreate
                .nextPageEventCreate();
        statusPage
                .closeMessageUncertified();
        eventCreate
                .openEventCreatePage();
        searchAndClickElementByText("BC");
        eventCreate
                .inputHourEvent("12")
                .inputMinuteEvent("0")
                .nextPageEventCreate()
                .addOnDutyWithBc(true)
                .nextPageEventCreate()
                .skipTrailersAndShipping()
                .inputDataEvent(true, "Nikolaev", "Ambreu")
                .nextPageEventCreate()
                .closeCertificationAlert();
        image
                .compareGraphBC();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }
}
