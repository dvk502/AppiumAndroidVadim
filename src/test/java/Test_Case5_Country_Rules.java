import com.automation.remarks.video.annotations.Video;
import logic.hos.header.Header;
import logic.hos.logsPage.LogsPage;
import logic.hos.rulesPage.CycleHours;
import logic.hos.rulesPage.RulesPage;
import logic.hos.statusPage.StatusPage;
import logic.init.*;
import logic.loginPage.LoginPage;
import logic.web.Customers;
import logic.web.LoginPageWeb;
import logic.web.MainPageOrganization;
import logic.web.MainScreen;
import logic.web.companyProfile.Drivers;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;

public class Test_Case5_Country_Rules extends BasePage {

    @BeforeClass
    public void beforeClass(ITestContext context) {
        /*log.info("Get android driver.");
        context.setAttribute("driver", AndroidMobileDrivers.getDriver());*/
    }

    @AfterClass
    public void disableOnlyUSA() {
        Drivers webDrivers = new Drivers();
        webDrivers
                .openDriverSettings();
        if (webDrivers.checkStatusOnlyUSA()) {
            log.info("Disable Only USA function.");
            webDrivers
                    .disableOnlyUsa()
                    .saveChangesProfile();
        } else {
            log.info("Only USA already disabled.");
            webDrivers
                    .saveChangesProfile();
        }
    }

    @Test(priority = 1, description = "Проверяем отображение правил у водителя на USA and CAN. (Смена правил через флаг)")
    public void test_Country_Rules_Change_Flag() throws IOException, InterruptedException {
        //--------------------------------------
        Credentials cred = new Credentials();
        Header header = new Header();
        LoginPage loginPage = new LoginPage();
        StatusPage statusPage = new StatusPage();
        RulesPage rulesPage = new RulesPage();
        LogsPage logsPage = new LogsPage();
        ImageSelector imgFind = new ImageSelector();
        //--------------------------------------

        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        imgFind
                .findCountryIconUsa();
        header
                .rulesOpen();
        rulesPage
                .checkCountry();
        header
                .logsOpen();
        logsPage
                .checkCurrentDay()
                .checkDays();
        header
                .countryFlagChangeToCanada();
        imgFind
                .findCountryIconCanada();
        header
                .rulesOpen();
        rulesPage
                .checkCountry();
        header
                .logsOpen();
        logsPage
                .checkCurrentDay()
                .checkDays();
        header
                .logoutCurrentDriver(true);
        loginPage
                .logoutWait();
        //--------------------------------------
    }

    @Test(priority = 2, description = "Проверка корректного отображения Cycle Hours Page")
    public void test_Hours_Cycle_Page() throws InterruptedException {
        //--------------------------------------
        Credentials cred = new Credentials();
        Header header = new Header();
        LoginPage loginPage = new LoginPage();
        StatusPage statusPage = new StatusPage();
        RulesPage rulesPage = new RulesPage();
        CycleHours cycle = new CycleHours();
        //--------------------------------------

        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .rulesOpen();
        rulesPage
                .openCycleHours();
        cycle
                .dateCycleHours()
                .cycleHoursNote()
                .searchElementsOnPage();
        header
                .backMenu()
                .logoutCurrentDriver(true);
        loginPage
                .logoutWait();
    }

//    @Test (description = "Проверяем отображение правил у водителя на USA and CAN. (Смена правил через Rules)")
//    public void test_Country_Rules_Change_Rules() throws IOException, InterruptedException {
//        loginPage.loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
//                cred.driverCredentials().DRIVER_PASSWORD);
//        statusPage.clickAndroidBtn();
//        imgFind.findCountryIconUsa();
//        header.rulesOpen();
//        rulesPage.checkCountry();
//        header.logsOpen();
//        logsPage
//                .checkCurrentDay()
//                .checkDays();
//        header.rulesOpen();
//        rulesPage
//                .changeRules()
//                .chooseCan()
//                .checkCountry();
//        imgFind.findCountryIconCanada();
//        header.logsOpen();
//        logsPage
//                .checkCurrentDay()
//                .checkDays();
//        header.logoutCurrentDriver(false);
//        loginPage.logoutWait();
//    }

    @Test(priority = 3, description = "Проверяем смену правил при Only Drivers in USA")
    //@Video(name = "Country Rules")
    public void test_Country_Rules_Only_Usa() throws IOException, InterruptedException {
        //--------------------------------------
        Credentials cred = new Credentials();
        Header header = new Header();
        LoginPage loginPage = new LoginPage();
        StatusPage statusPage = new StatusPage();
        ImageSelector imgFind = new ImageSelector();
        LoginPageWeb webLogin = new LoginPageWeb();
        MainPageOrganization webMainPageOrg = new MainPageOrganization();
        Drivers webDrivers = new Drivers();
        Customers webCustomers = new Customers();
        MainScreen webMainScreen = new MainScreen();
        //--------------------------------------

        webLogin.loginOnWeb(cred.webAdmin().WEBLOGIN, cred.webAdmin().WEBPASS);
        webMainScreen.openCustomers();
        webCustomers
                .findOrganization(cred.myDriverName().DRIVERORG)
                .openTestCompany();
        webMainPageOrg.goToDriversPage();
        webDrivers
                .foundDriverForLoginName(cred.driverCredentials().DRIVER_LOGIN)
                .openDriverSettings()
                .turnOnlyUsa()
                .saveChangesProfile();
        loginPage.loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                cred.driverCredentials().DRIVER_PASSWORD);
        statusPage.clickAndroidBtn();
        /*header.countryFlagChangeToCanada();*/
        header
                .countryFlagChangeToCanada();
        imgFind.changeRulesOnlyUsa();//Закрыть пуш или подождать чтобы кликнуть на флаг.
        webDrivers
                .openDriverSettings()
                .disableOnlyUsa()
                .saveChangesProfile();
        header.logoutCurrentDriver(true);
        loginPage.logoutWait();
    }
}

