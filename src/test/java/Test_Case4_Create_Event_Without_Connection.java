import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import logic.hos.coDriverPage.CoDriverPage;
import logic.hos.dvirPage.AddInspectionReport;
import logic.hos.dvirPage.DvirPage;
import logic.hos.logsPage.CreateEvents;
import logic.hos.statusPage.StatusPage;
import logic.hos.header.Header;
import logic.init.*;
import logic.loginPage.CheckAlertConnection;
import logic.loginPage.LoginPage;
import logic.web.Customers;
import logic.web.LoginPageWeb;
import logic.web.MainPageOrganization;
import logic.web.MainScreen;
import logic.web.companyProfile.Drivers;
import logic.web.companyProfile.HosPage;
import logic.web.companyProfile.IRPage;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(UniversalVideoListener.class)
public class Test_Case4_Create_Event_Without_Connection extends BasePage {

    @BeforeClass
    public void checkNeededWeb() {
        usingWeb = true;
    }

    @BeforeMethod
    public void beforeTest (ITestContext context) {
        /*context.setAttribute("driver", AndroidMobileDrivers.getDriver());*/
    }

    @BeforeClass
    public void checkIfWifiTurnedB() throws InterruptedException {
        CheckAlertConnection connection = new CheckAlertConnection();
        connection.checkWiFiTurned();
    }

    @AfterClass
    public void checkIfWifiTurnedA() throws InterruptedException {
        CheckAlertConnection connection = new CheckAlertConnection();
        connection.checkWiFiTurned();
    }

    @Test(priority = 1, description = "Создание, редактирование ивента без подключенного интернета, проверка его отображения на веб после включения.")
    //@Video(name = "Check Event on Web")
    public void test_Create_Events() throws Exception {
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
        WiFiConnection connection = new WiFiConnection();
        CoDriverPage coDriver = new CoDriverPage();
        DvirPage dvir = new DvirPage();
        AddInspectionReport addIR = new AddInspectionReport();
        IRPage webIRPage = new IRPage();
        //--------------------------------------
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        connection.wifiDisable();
        events
//                //------------------------------------- Create On Duty
                .openEventCreatePage()
                .chooseEventOnDuty()
                .inputHourEvent(cred.onDutyEventData().EVENTHOUR)
                .inputMinuteEvent(cred.onDutyEventData().EVENTMINUTE)
                .nextPageEventCreate()
                .trailerHook()
                .inputTrailerData(cred.onDutyEventData().EVENTTRAILER, cred.onDutyEventData().EVENTLICENSE)
                .closeWindow()
                .shippingAdd()
                .inputShippingData(cred.onDutyEventData().EVENTSHIPPING)
                .closeWindow()
                .nextPageEventCreate()
                .inputDataEvent(true, cred.onDutyEventData().EVENTCITY, cred.onDutyEventData().EVENTCOMMENT)
                .nextPageEventCreate()
//                .closeCertificationAlert()
                .eventTimeTake();
        connection.wifiEnable();
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
        hosPage
                .compareEventDataOnDuty(cred.onDutyEventData().EVENTTRAILER, cred.onDutyEventData().EVENTSHIPPING);
        connection
                .wifiDisable();
        events
                .eventEditToSleeper(cred.sleepEventData().EVENTTRAILER, cred.sleepEventData().EVENTSHIPPING)
                .eventTimeTake();
        connection
                .wifiEnable();
        hosPage
                .compareEventDataSleep();
        connection
                .wifiDisable();
        header
                .statusOpen();
        statusPage
                .createWheelEventOnDuty(false, cred.onDutyEventData().EVENTCITY, "test");
        connection
                .wifiEnable();
        header
                .logsOpen();
        hosPage
                .compareEventDataWheelOnDuty();
        connection
                .wifiDisable();
        header
                .openCoDriverPage();
        coDriver
                .coDriverOpenLoginPage()
                .loginCoDriverFromOG(cred.coDriverCredentials().CODRIVER_LOGIN, cred.coDriverCredentials().CODRIVER_PASSWORD)
                .checkTextFromAlertConnection()
                .goToMainMenu();
        header
                .dvirOpen();
        dvir
                .createIR();
        addIR
                .setCurrentDate()
                .inputDataIR("Kansas", "5000", "Test");
        connection
                .wifiEnable();
        hosPage
                .openDvirPage();
        webIRPage
                .refreshIRPage()
                .compareDataIR();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }
}
