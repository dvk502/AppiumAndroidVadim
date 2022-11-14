import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import logic.fleet.CreateDriver;
import logic.fleet.CreateTruck;
import logic.hos.header.Header;

import logic.init.BasePage;
import logic.init.Credentials;
import logic.loginPage.CheckRegFields;
import logic.loginPage.LoginPage;
import logic.web.Customers;
import logic.web.LoginPageWeb;
import logic.web.MainPageOrganization;
import logic.web.MainScreen;
import logic.web.companyProfile.Drivers;
import logic.web.companyProfile.Trucks;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(UniversalVideoListener.class)
public class Test_Case13_DriverStatus extends BasePage {

    @BeforeClass
    public void beforeClass (ITestContext context) {
        /*log.info("Get android driver.");
        context.setAttribute("driver", AndroidMobileDrivers.getDriver());*/
    }

    /**
     * В случае падения теста, тестовый водитель может остаться в статусе unavailable or inactive.
     * Метод меняет статус на active для водителя, в случае падения теста или другой непредвиденной ситуации.
     * @throws InterruptedException
     */
    /*@AfterClass
    public void activateDriverAfterTest() throws InterruptedException {
        Drivers webDrivers = new Drivers();
        try {
            webDrivers
                    .openDriverSettings();
            if()
                webDrivers
                    .changeStatusDriverToActiveInSettings()
                    .saveChangesProfile();
        }
    }*/

    @Test(priority = 1, description = "Check Driver Status changes")
    //@Video(name = "Check Driver Status changes")
    public void test_Check_Driver_Status_Change() throws InterruptedException {
        //--------------------------------------
        Credentials cred = new Credentials();
        CreateTruck truckCreate = new CreateTruck();
        CreateDriver create = new CreateDriver();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        CheckRegFields check = new CheckRegFields();
        Drivers webDrivers = new Drivers();
        Customers webCustomers = new Customers();
        MainScreen webMainScreen = new MainScreen();
        Trucks webTruck = new Trucks();
        LoginPageWeb webLogin = new LoginPageWeb();
        MainPageOrganization webMainPageOrg = new MainPageOrganization();
        //--------------------------------------
        truckCreate
                .loginFleet(cred.driverCredentials().FLEETLOGIN)
                .passFleet(cred.driverCredentials().FLEETPASS)
                .loginBtnPress();
        loginPage
                .chooseTypeFleet("Fleet");
        header
                .openFleetMenu();
        create
                .openDriversPage()
                .driverFoundButton()
                .driverFoundField("testplan1")
                .driverLoginFoundList("testplan1")
                .statusDriverCheck("Active");
        header
                .collapseBack()
                .backToMainPageFromDriversPage()
                .logoutCurrentDriverFromFleet();
        webLogin
                .loginOnWeb(cred.webAdmin().WEBLOGIN, cred.webAdmin().WEBPASS);
        webMainScreen
                .openCustomers();
        webCustomers
                .findOrganization("MyAppium")
                .openTestCompany();
        webMainPageOrg
                .goToDriversPage();
        webDrivers
                .foundDriver("test1", "plan1")
                .checkStatusDriver()
                .changeStatusDriverToInactive("test1", "plan1");
        truckCreate
                .loginFleet(cred.driverCredentials().FLEETLOGIN)
                .passFleet(cred.driverCredentials().FLEETPASS)
                .loginBtnPress();
        loginPage
                .chooseTypeFleet("Fleet");
        header
                .openFleetMenu();
        create
                .openDriversPage()
                .driverFoundButton();
        //leaksFinder();
        create
                .driverFoundField("testplan1")
                .driverLoginFoundList("testplan1")
                .statusDriverCheck("Inactive");
        header
                .collapseBack()
                .backToMainPageFromDriversPage()
                .logoutCurrentDriverFromFleet();
        webDrivers
                .changeStatusFilter("Inactive")
                .checkStatusDriver()
                .changeStatusDriverToActive();
        truckCreate
                .loginFleet(cred.driverCredentials().FLEETLOGIN)
                .passFleet(cred.driverCredentials().FLEETPASS)
                .loginBtnPress();
        loginPage
                .chooseTypeFleet("Fleet");
        header
                .openFleetMenu();
        create
                .openDriversPage()
                .driverFoundButton()
                .driverFoundField("testplan1")
                .driverLoginFoundList("testplan1")
                .statusDriverCheck("Active");
        header
                .collapseBack()
                .backToMainPageFromDriversPage()
                .logoutCurrentDriverFromFleet();
        webDrivers
                .changeStatusFilter("Active")
                .checkStatusDriver()
                .openDriverSettings()
                .changeStatusDriverToUnavailableInSettings()
                .saveChangesProfile();
        truckCreate
                .loginFleet(cred.driverCredentials().FLEETLOGIN)
                .passFleet(cred.driverCredentials().FLEETPASS)
                .loginBtnPress();
        loginPage
                .chooseTypeFleet("Fleet");
        header
                .openFleetMenu();
        create
                .openDriversPage()
                .driverFoundButton()
                .driverFoundField("testplan1")
                .driverLoginFoundList("testplan1")
                .statusDriverCheck("Unavailable");
        webDrivers
                .changeStatusFilter("Unavailable")
                .checkStatusDriver()
                .changeStatusDriverToActive();
        header
                .collapseBack()
                .backToMainPageFromDriversPage()
                .logoutCurrentDriverFromFleet();
    }
}
