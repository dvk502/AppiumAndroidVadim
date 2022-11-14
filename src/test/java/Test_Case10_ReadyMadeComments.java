import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import logic.hos.header.Header;
import logic.hos.logsPage.CreateEvents;
import logic.hos.statusPage.StatusPage;
import logic.init.*;
import logic.loginPage.LoginPage;
import logic.web.Customers;
import logic.web.LoginPageWeb;
import logic.web.MainPageOrganization;
import logic.web.MainScreen;
import logic.web.companyProfile.Drivers;
import logic.web.companyProfile.HosPage;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.sql.SQLException;

@Listeners(UniversalVideoListener.class)
public class Test_Case10_ReadyMadeComments extends BasePage {

    @BeforeClass
    public void beforeClass(ITestContext context) {
        /*log.info("Get android driver.");
        context.setAttribute("driver", AndroidMobileDrivers.getDriver());*/

    }

//    @AfterMethod
//    public void logoutWeb() {
//        LoginPageWeb loginPageWeb = new LoginPageWeb();
//        loginPageWeb.logoutFromWeb();
//    }

    DateUtil date = new DateUtil();

    @Test(description = "Test")
    //@Video(name = "LogsPage_1")
    public void test_LogsPage() throws InterruptedException {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        CreateEvents events = new CreateEvents();
        Drivers webDrivers = new Drivers();
        Customers webCustomers = new Customers();
        MainScreen webMainScreen = new MainScreen();
        LoginPageWeb webLogin = new LoginPageWeb();
        HosPage hosPage = new HosPage();
        MainPageOrganization webMainPageOrg = new MainPageOrganization();
        //--------------------------------------
        webLogin
                .loginOnWeb(cred.webAdmin().WEBLOGIN, cred.webAdmin().WEBPASS);
        webMainScreen
                .openCustomers();
        webCustomers
                .findOrganization(cred.webAdmin().WEBORG)
                .openTestCompany();
        webMainPageOrg
                .goToDriversPage();
        webDrivers
                .foundDriver(cred.myDriverName().MYDRIVERNAME, cred.myDriverName().MYDRIVERLASTNAME)
                .openHosPage();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        statusPage
                .createWheelEvent(true, "sleep", "TestCity", "Trailer1", "License1", "Shipping1", false, false, false);
        header
                .logsOpen();
        Thread.sleep(58000);
        events
//                //------------------------------------- Create On Duty
                .openEventCreatePage()
                .chooseEventOnDuty()
                /*.inputHourEvent(date.getDeltaEventHours2(null, -1))*/
                .inputMinuteEvent(date.getDeltaEventMinute3(null, -3))
                .nextPageEventCreate()
                .trailerHook()
                .inputTrailerData(cred.onDutyEventData().EVENTTRAILER, cred.onDutyEventData().EVENTLICENSE)
                .closeWindow()
                .shippingAdd()
                .inputShippingData(cred.onDutyEventData().EVENTSHIPPING)
                .closeWindow()
                .nextPageEventCreate()
                .inputDataEvent(true, cred.onDutyEventData().EVENTCITY, "")
                .openReadyMadeComments()
                .checkDisplayedAllComments()
                .chooseReadyMadeComment(1)
                .nextPageEventCreate()
                .comparingComments();
        hosPage
                .compareCommentEvent(true);
        events
                .openEditEventPage()
                .nextPageEventCreate()
                .nextPageEventCreate()
                .nextPageEventCreate()
                .inputDataEvent(true, cred.onDutyEventData().EVENTCITY, "")
                .openReadyMadeComments()
                .chooseReadyMadeComment(2)
                .nextPageEventCreate()
                .comparingComments();
        hosPage
                .compareCommentEvent(true);
        events
                .openEditEventPage()
                .nextPageEventCreate()
                .nextPageEventCreate()
                .nextPageEventCreate()
                .inputDataEvent(true, cred.onDutyEventData().EVENTCITY, "")
                .openReadyMadeComments()
                .chooseReadyMadeComment(3)
                .nextPageEventCreate()
                .comparingComments();
        hosPage
                .compareCommentEvent(true);
        events
                .openEditEventPage()
                .nextPageEventCreate()
                .nextPageEventCreate()
                .nextPageEventCreate()
                .inputDataEvent(true, cred.onDutyEventData().EVENTCITY, "")
                .openReadyMadeComments()
                .chooseReadyMadeComment(4)
                .nextPageEventCreate()
                .comparingComments();
        hosPage
                .compareCommentEvent(true);
        events
                .openEditEventPage()
                .nextPageEventCreate()
                .nextPageEventCreate()
                .nextPageEventCreate()
                .inputDataEvent(true, cred.onDutyEventData().EVENTCITY, "")
                .openReadyMadeComments()
                .chooseReadyMadeComment(5)
                .nextPageEventCreate()
                .comparingComments();
        hosPage
                .compareCommentEvent(true);
        events
                .openEditEventPage()
                .nextPageEventCreate()
                .nextPageEventCreate()
                .nextPageEventCreate()
                .inputDataEvent(true, cred.onDutyEventData().EVENTCITY, "")
                .openReadyMadeComments()
                .chooseReadyMadeComment(6)
                .nextPageEventCreate()
                .comparingComments();
        hosPage
                .compareCommentEvent(true);
        events
                .openEditEventPage()
                .nextPageEventCreate()
                .nextPageEventCreate()
                .nextPageEventCreate()
                .inputDataEvent(true, cred.onDutyEventData().EVENTCITY, "")
                .openReadyMadeComments()
                .chooseReadyMadeComment(7)
                .nextPageEventCreate()
                .comparingComments();
        hosPage
                .compareCommentEvent(true);
        events
                .openEditEventPage()
                .nextPageEventCreate()
                .nextPageEventCreate()
                .nextPageEventCreate()
                .inputDataEvent(true, cred.onDutyEventData().EVENTCITY, "")
                .openReadyMadeComments()
                .chooseReadyMadeComment(8)
                .nextPageEventCreate()
                .comparingComments();
        hosPage
                .compareCommentEvent(true);
        events
                .openEditEventPage()
                .nextPageEventCreate()
                .nextPageEventCreate()
                .nextPageEventCreate()
                .inputDataEvent(true, cred.onDutyEventData().EVENTCITY, "")
                .openReadyMadeComments()
                .chooseReadyMadeComment(9)
                .nextPageEventCreate();
        statusPage
                .attachLater();
        events
                .comparingComments();
        hosPage
                .compareCommentEvent(true);
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }

    @Test(description = "Test")
    //@Video(name = "LogsPage_2")
    public void test_LogsPage2() throws InterruptedException, SQLException {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        CreateEvents events = new CreateEvents();
        Drivers webDrivers = new Drivers();
        Customers webCustomers = new Customers();
        MainScreen webMainScreen = new MainScreen();
        LoginPageWeb webLogin = new LoginPageWeb();
        HosPage hosPage = new HosPage();
        MainPageOrganization webMainPageOrg = new MainPageOrganization();
        //--------------------------------------
        clearDB();
        webLogin
                .loginOnWeb(cred.webAdmin().WEBLOGIN, cred.webAdmin().WEBPASS);
        webMainScreen
                .openCustomers();
        webCustomers
                .findOrganization(cred.webAdmin().WEBORG)
                .openTestCompany();
        webMainPageOrg
                .goToDriversPage();
        webDrivers
                .foundDriver(cred.myDriverName().MYDRIVERNAME, cred.myDriverName().MYDRIVERLASTNAME)
                .openHosPage();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn()
                .openAndInputOnDutyWheelWithReadyComment("Nikolaev", 1);
        header
                .logsOpen();
        events
                .comparingComments();
        hosPage
                .compareCommentEvent(false);
        header
                .logoutCurrentDriver(false);
    }
}