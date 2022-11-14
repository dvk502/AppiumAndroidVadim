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
public class Test_Case15_BorderCrossing extends BasePage {

    @BeforeClass
    public void beforeClass (ITestContext context) {
        /*log.info("Get android driver.");
        context.setAttribute("driver", AndroidMobileDrivers.getDriver());*/
    }

    @Test(priority = 1, description = "Create Border Cross with Auto Driving.")
    public void test_BorderCrossing_AutoDriving() throws InterruptedException, SQLException {
        //--------------------------------------
        Credentials cred = new Credentials();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        StatusPage statusPage = new StatusPage();
        CreateEvents eventCreate = new CreateEvents();
        DateUtil date = new DateUtil();
        //--------------------------------------
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
        SqlRequests.takeLastEventSequence(92807);
        SqlRequests.addEvent("Driving", 92807, 5891, 1, 1, 1, 3, date.getDeltaEventMinute(null, -10), "4fe54670b860ae64", "Nikolaev, AL, US", "0", "", "", SqlRequests.nextSequence+1, 309473, "Nikolaev");
        SqlRequests.addEvent("Off-Duty", 92807, 5891, 1, 2, 1, 1, date.getDeltaEventMinute(null, -2), "4fe54670b860ae64", "Nikolaev, AL, US", "0", "", "", SqlRequests.nextSequence+2, 309473, "Nikolaev");
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        eventCreate
                .openEventCreatePage();
        searchAndClickElementByText("BC");
        eventCreate
                .timeForBc()
                //.addOnDutyWithBc(false)
                .nextPageEventCreate()
                .BcAlertMustBeDisplayed(false);
        header
                .backMenu()
                .backMenu()
                .backMenu()
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }

    @Test(priority = 2, description = "Create Border Cross on Off-Duty.")
    public void test_BorderCrossing_OffDuty() throws InterruptedException, SQLException {
        //--------------------------------------
        Credentials cred = new Credentials();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        StatusPage statusPage = new StatusPage();
        LogsPage logs = new LogsPage();
        CreateEvents eventCreate = new CreateEvents();
        DateUtil date = new DateUtil();
        //--------------------------------------
        clearDB();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
        SqlRequests.takeLastEventSequence(92807);
        SqlRequests.addEvent("Off-Duty", 92807, 5891, 1, 2, 1, 1, date.getDeltaEventDays(null, -1)+" 14:00:00", "4fe54670b860ae64", "Nikolaev, AL, US", "0", "", "", SqlRequests.nextSequence+1, 309473, "Nikolaev");
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        logs
                .pressToPreviousDay();
        eventCreate
                .openEventCreatePage();
        searchAndClickElementByText("BC");
        eventCreate
                .setTimeForEvent("10","30")
                .nextPageEventCreate()
                .addOnDutyWithBc(true)
                .checkTruckOnCreatedBc()
                .nextPageEventCreate()
                .skipTrailersAndShipping()
                .selectBcTypeOnLocation();
        searchAndClickElementByText("U.S.A to Canada");
        eventCreate
                .changeLocationEvent("TestCity", true)
                .nextPageEventCreate();
                //.closeCertificationAlert();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait()
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        logs
                .pressToPreviousDay();
        logs
                .checkBcAfterOffDuty();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }

    @Test(priority = 3, description = "Create Border Cross on On-Duty.")
    public void test_BorderCrossing_OnDuty() throws InterruptedException, SQLException {
        //--------------------------------------
        Credentials cred = new Credentials();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        StatusPage statusPage = new StatusPage();
        SqlRequests sql = new SqlRequests();
        ImageSelector image = new ImageSelector();
        LogsPage logs = new LogsPage();
        CreateEvents eventCreate = new CreateEvents();
        DateUtil date = new DateUtil();
        //--------------------------------------
        clearDB();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
        SqlRequests.takeLastEventSequence(92807);
        SqlRequests.addEvent("On-Duty", 92807, 5891, 1, 2, 1, 4, date.getDeltaEventDays(null, -1)+" 14:00:00", "4fe54670b860ae64", "Nikolaev, AL, US", "0", "", "", SqlRequests.nextSequence+1, 309473, "Nikolaev");
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        logs
                .pressToPreviousDay();
        eventCreate
                .openEventCreatePage();
        searchAndClickElementByText("BC");
        eventCreate
                .setTimeForEvent("10", "30");
        eventCreate
                .nextPageEventCreate()
                .checkTruckOnCreatedBc()
                .selectBcType();
        searchAndClickElementByText("U.S.A to Canada");
        eventCreate
                .nextPageEventCreate();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait()
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        statusPage
                .clickAndroidBtn();
        logs
                .pressToPreviousDay();
        logs
                .checkBcAfterOnDuty();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }

    @Test(priority = 4, description = "Create Border Cross on Sleeper Birth.")
    public void test_BorderCrossing_Sleeper() throws InterruptedException, SQLException {
        //--------------------------------------
        Credentials cred = new Credentials();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        StatusPage statusPage = new StatusPage();
        LogsPage logs = new LogsPage();
        CreateEvents eventCreate = new CreateEvents();
        DateUtil date = new DateUtil();
        //--------------------------------------
        clearDB();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
        SqlRequests.takeLastEventSequence(92807);
        SqlRequests.addEvent("Sleeping Berth", 92807, 5891, 1, 2, 1, 2, date.getDeltaEventDays(null, -1)+" 14:00:00", "4fe54670b860ae64", "Nikolaev, AL, US", "0", "", "lastEvent", SqlRequests.nextSequence+1, 309473, "Nikolaev");
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        logs
                .pressToPreviousDay();
        eventCreate
                .openEventCreatePage();
        searchAndClickElementByText("BC");
        eventCreate
                .setTimeForEvent("10", "30")
                .nextPageEventCreate()
                .addOnDutyWithBc(true)
                .checkTruckOnCreatedBc()
                .nextPageEventCreate()
                .skipTrailersAndShipping()
                .selectBcTypeOnLocation();
        searchAndClickElementByText("U.S.A to Canada");
        eventCreate
                .changeLocationEvent("TestCity", false)
                .nextPageEventCreate();
                //.closeCertificationAlert();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait()
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        logs
                .pressToPreviousDay();
        logs
                .checkBcAfterSleep();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }

    @Test(priority = 5, description = "Create Border Cross on Driving.")
    public void
    test_BorderCrossing_Driving() throws InterruptedException, SQLException {
        //--------------------------------------
        Credentials cred = new Credentials();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        StatusPage statusPage = new StatusPage();
        LogsPage logs = new LogsPage();
        CreateEvents eventCreate = new CreateEvents();
        DateUtil date = new DateUtil();
        //--------------------------------------
        clearDB();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
        SqlRequests.takeLastEventSequence(92807);
        SqlRequests.addEvent("Driving", 92807, 5891, 1, 2, 1, 3, date.getDeltaEventDays(null, -1)+" 14:00:00", "4fe54670b860ae64", "Nikolaev, AL, US", "0", "", "", SqlRequests.nextSequence+1, 309473, "Nikolaev");
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .statusOpen()
                .logoutCurrentDriverDrivingEvent("TEST", false);
        loginPage
                .logoutWait();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        logs
                .pressToPreviousDay();
        eventCreate
                .openEventCreatePage();
        searchAndClickElementByText("BC");
        eventCreate
                .setTimeForEvent("10", "30")
                .nextPageEventCreate()
                .checkTruckOnCreatedBc()
                .selectBcType();
        searchAndClickElementByText("U.S.A to Canada");
        eventCreate
                .nextPageEventCreate();
        header
                .statusOpen()
                .logoutCurrentDriverDrivingEvent("TEST", false);
        loginPage
                .logoutWait()
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        header
                .logsOpen();
        logs
                .pressToPreviousDay();
        logs
                .checkBcAfterDriving();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }

    @Test(priority = 6, description = "Create Border Cross without On-Duty.")
    public void test_BorderCrossing_Without_OnDuty() throws InterruptedException, SQLException, IOException {
        //--------------------------------------
        Credentials cred = new Credentials();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        StatusPage statusPage = new StatusPage();
        SqlRequests sql = new SqlRequests();
        ImageSelector image = new ImageSelector();
        LogsPage logs = new LogsPage();
        CreateEvents eventCreate = new CreateEvents();
        DateUtil date = new DateUtil();
        //--------------------------------------
        clearDB();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        logs
                .pressToPreviousDay();
        eventCreate
                .openEventCreatePage();
        searchAndClickElementByText("BC");
        eventCreate
                .setTimeForEvent("10", "30")
                .nextPageEventCreate()
                .addOnDutyWithBc(false)
                .selectBcType() ;
        searchAndClickElementByText("U.S.A to Canada");
        Thread.sleep(3000);
        eventCreate
                .nextPageEventCreate();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait()
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        logs
                .pressToPreviousDay();
        image.compareGraphBCWithoutOnDuty();
        logs
                .checkBcWithoutOnDuty();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }

    @Test(priority = 7, description = "Create Border Cross with On-Duty.")
    public void test_BorderCrossing_With_OnDuty() throws InterruptedException, SQLException, IOException {
        //--------------------------------------
        Credentials cred = new Credentials();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        StatusPage statusPage = new StatusPage();
        SqlRequests sql = new SqlRequests();
        ImageSelector image = new ImageSelector();
        LogsPage logs = new LogsPage();
        CreateEvents eventCreate = new CreateEvents();
        DateUtil date = new DateUtil();
        //--------------------------------------
        clearDB();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        logs
                .pressToPreviousDay();
        eventCreate
                .openEventCreatePage();
        searchAndClickElementByText("BC");
        eventCreate
                .setTimeForEvent("10", "30")
                .nextPageEventCreate()
                .addOnDutyWithBc(true)
                .nextPageEventCreate()
                .skipTrailersAndShipping();
        eventCreate
                .changeLocationEvent("Nikolaev", true)
                .nextPageEventCreate();
        /*eventCreate
                .closeCertificationAlert();*/
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait()
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        logs
                .pressToPreviousDay();
        image.compareGraphBCWithOnDuty();
        logs
                .checkBcWithOnDuty();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }


}
