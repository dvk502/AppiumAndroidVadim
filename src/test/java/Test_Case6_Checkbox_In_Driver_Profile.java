import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import logic.hos.logsPage.CreateEvents;
import logic.hos.logsPage.LogsPage;
import logic.hos.statusPage.StatusPage;
import logic.hos.header.Header;
import logic.init.*;
import logic.loginPage.LoginPage;
import logic.web.Customers;
import logic.web.LoginPageWeb;
import logic.web.MainPageOrganization;
import logic.web.MainScreen;
import logic.web.companyProfile.Drivers;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Collection;

@Listeners(UniversalVideoListener.class)
public class Test_Case6_Checkbox_In_Driver_Profile extends BasePage {


    @BeforeClass
    public void beforeClass (ITestContext context) {
        /*log.info("Get android driver.");
        context.setAttribute("driver", AndroidMobileDrivers.getDriver());*/
    }

    @AfterClass
    public void checkIfAllCheckboxTurnedOn() {
        Drivers webDrivers = new Drivers();
        webDrivers
                .openDriverSettings()
                .turnOnAllowEditEvents()
                .turnOnAllowInsertEvents()
                .turnOnAllowDeleteEvents()
                .turnOnAllowDrivingEvents()
                .saveChangesProfile();
    }

    @Test(description = "Checking the work of checkboxes on the web")
    //@Video(name = "Checkbox in Driver profile")
    public void test_Checkbox_on_web() throws InterruptedException, SQLException {
        //--------------------------------------
        Credentials cred = new Credentials();
        LoginPageWeb webLogin = new LoginPageWeb();
        MainPageOrganization webMainPageOrg = new MainPageOrganization();
        Drivers webDrivers = new Drivers();
        Customers webCustomers = new Customers();
        MainScreen webMainScreen = new MainScreen();
        StatusPage statusPage = new StatusPage();
        LogsPage logsPage = new LogsPage();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        CreateEvents createEvents = new CreateEvents();
        //--------------------------------------

        webLogin
                .loginOnWeb(cred.webAdmin().WEBLOGIN, cred.webAdmin().WEBPASS);
        webMainScreen
                .openCustomers();
        webCustomers
                .findOrganization(cred.myDriverName().DRIVERORG)
                .openTestCompany();
        webMainPageOrg
                .goToDriversPage();
        webDrivers
                .foundDriverForLoginName(cred.driverCredentials().DRIVER_LOGIN)
                .openDriverSettings()
                .turnOffAllowDeleteEvents()
                .saveChangesProfile();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        statusPage
                .createWheelEventOnDutyWithoutShip("Test", "test");
        header
                .logsOpen();
        logsPage
                .deleteEventDisableAllow();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
        webDrivers
                .openDriverSettings()
                .turnOnAllowDeleteEvents()
                .turnOffAllowInsertEvents()
                .saveChangesProfile();
        clearEventsDrivers();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        createEvents
                .checkPossibleEventCreate();
        header
                .logoutCurrentDriver(true);
        loginPage
                .logoutWait();
        webDrivers
                .openDriverSettings()
                .turnOnAllowInsertEvents()
                .turnOffAllowEditEvents()
                .saveChangesProfile();
        clearEventsDrivers();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        statusPage
                .createWheelEventOnDutyWithoutShip("Test", "test");
        header
                .logsOpen();
        createEvents
                .checkPossibleEventEdit();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
        webDrivers
                .openDriverSettings()
                .turnOnAllowEditEvents()
                .turnOffAllowDrivingEvents()
                .saveChangesProfile();
        clearEventsDrivers();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        createEvents
                .openEventCreatePage()
                .checkPossibleEventDriving()
                .returnToLogsPage();
        header
                .logoutCurrentDriver(true);
        loginPage
                .logoutWait();
    }
}
