import logic.dbConnection.SqlRequests;
import logic.hos.coDriverPage.CoDriverPage;
import logic.hos.logsPage.CreateEvents;
//import logic.init.AndroidMobileDrivers;

import logic.settingsPage.Settings;
import logic.hos.statusPage.StatusPage;
import logic.init.BasePage;
import logic.init.Credentials;
import logic.loginPage.LoginPage;
import logic.hos.header.Header;
import logic.mainMenu.MainMenuDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_Case3_Co_Driver_Add extends BasePage {
    public Test_Case3_Co_Driver_Add() {
        usingWeb = false;
    }

    @BeforeMethod
    public void beforeTest(ITestContext context) {
        context.setAttribute("driver", driver);
    }


//   @Test(priority = 2, description = "Проверяем авторизацию Co-Driver, подключение его к траку.")
//    public void test_Login_Co_Driver() throws InterruptedException {
//                loginPage.loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
//                        cred.driverCredentials().DRIVER_PASSWORD);
//                statusPage.clickAndroidBtn();
//                header.openCoDriverPage();
//                //coDriverPage.moveToCoDriver();
//                coDriverPage
//                        .coDriverOpenLoginPage()
//                        .coDriverLogin(cred.coDriverCredentials().CODRIVER_LOGIN, cred.coDriverCredentials().CODRIVER_PASSWORD)
//                        .switchDriver()
//                        .confirmSwapDrivers()
//                        .chooseCurrentDriver()
//                        .goToMainMenu();
//                header
//                        .logoutCoDriver()
//                        .logoutCurrentDriver(false);
//                loginPage.logoutWait();
//
//    }

    @Test(priority = 1, description = "Проверяем авторизацию Co-Driver из другой организации.")
    public void test_Login_Co_Driver_From_Other_Organization() throws Exception {
        //--------------------------------------
        CreateEvents createEvents = new CreateEvents();
        MainMenuDriver menuDriver = new MainMenuDriver();
        Settings settings = new Settings();
        Header header = new Header();
        LoginPage loginPage = new LoginPage();
        StatusPage statusPage = new StatusPage();
        CoDriverPage coDriverPage = new CoDriverPage();
        Credentials cred = new Credentials();
        SqlRequests sql = new SqlRequests();
        //--------------------------------------

        String trailer = cred.sleepEventData().EVENTTRAILER;
        String shipping = cred.sleepEventData().EVENTSHIPPING;

        //--------------------------------------allowDeleteEventsCheckbox
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN, cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .openCoDriverPage();
//                coDriverPage.moveToCoDriver();
        coDriverPage
                .coDriverOpenLoginPage()
                .loginCoDriverFromOG(cred.coDriverCredentials().DRIVER_LOGIN_ANOTHER_ORGANIZATION,
                        cred.coDriverCredentials().DRVIER_PASSWORD_ANOTHER_ORGANIZATION)
                .checkTextFromAlert()
                .coDriverLogin(cred.coDriverCredentials().CODRIVER_LOGIN, cred.coDriverCredentials().CODRIVER_PASSWORD)
                .openCoDriversLogBook();
        header
                .backMenu();
        coDriverPage
                .switchDriver()
                .confirmSwapDrivers()
                .chooseCurrentDriver()
                .goToMainMenu();
        statusPage
                .closeMessageUncertified();
        header
                .statusOpen();
        statusPage
                .createWheelEventSleeper(cred.sleepEventData().EVENTCITY, trailer, shipping);
        header
                .openCoDriverPage();
        coDriverPage
                .switchDriver()
                .confirmSwapDrivers()
                .goToMainMenu();
        header
                .statusOpen();
        statusPage
                .createWheelEventOnDuty(false, cred.sleepEventData().EVENTCITY, "test");
        header
                .logsOpen();
        createEvents
                .compareTrailerNumber(trailer)
                .compareShippingNumber(shipping);
        header
                .openMenu();
        menuDriver
                .openSettings();
        settings
                .openCurrentDriverProfile(true)
                .logoutCurrentDriverInSettings();
        header
                .openMenu();
        menuDriver
                .openSettings();
        settings
                .checkCurrentDriver();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }
}