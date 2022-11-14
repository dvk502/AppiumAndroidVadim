import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import logic.dbConnection.SqlRequests;
import logic.hos.dotInspectPage.DotPage;
import logic.hos.header.Header;
import logic.hos.logsPage.CreateEvents;
import logic.hos.logsPage.LogsPage;
import logic.hos.statusPage.StatusPage;
import logic.init.*;
import logic.loginPage.LoginPage;
import logic.web.Customers;
import logic.web.LoginPageWeb;
import logic.web.MainPageOrganization;
import logic.web.MainScreen;
import logic.web.companyProfile.Drivers;
import logic.web.companyProfile.General;
import logic.web.companyProfile.HosPage;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

@Listeners(UniversalVideoListener.class)
public class Test_Case11_DotInspect extends BasePage {

    @BeforeClass
    public void beforeClass(ITestContext context) {
        /*log.info("Get android driver.");
        context.setAttribute("driver", AndroidMobileDrivers.getDriver());*/
    }

    @Test(description = "Test")
    //@Video(name = "DotInspect")
    public void test_LogsPage() throws InterruptedException, SQLException {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        Drivers webDrivers = new Drivers();
        Customers webCustomers = new Customers();
        MainScreen webMainScreen = new MainScreen();
        LoginPageWeb webLogin = new LoginPageWeb();
        LogsPage logs = new LogsPage();
        DotPage dotPage = new DotPage();
        DateUtil date = new DateUtil();
        MainPageOrganization webMainPageOrg = new MainPageOrganization();
        General general = new General();
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
        SqlRequests.addEvent("Off-Duty", 92808, 5891, 1, 2, 1, 1, date.getDeltaEventMinute(null, -30), "4fe54670b860ae64", "Test1", "5000", "Ship1", "Trailer1", SqlRequests.nextSequence+1, 309473, "Nikolaev");
        SqlRequests.addEvent("Off-Duty", 92808, 5891, 1, 2, 1, 1, date.getDeltaEventMinute(null, -20), "4fe54670b860ae64", "Test2", "10000", "Ship2", "Trailer2", SqlRequests.nextSequence+2, 309473, "Nikolaev");
        SqlRequests.addEvent("Off-Duty", 92808, 5891, 1, 2, 1, 1, date.getDeltaEventMinute(null, -15), "4fe54670b860ae64", "Test3", "20000", "Ship3", "Trailer3", SqlRequests.nextSequence+3, 309473, "Nikolaev");
        SqlRequests.addEvent("Off-Duty", 92808, 5891, 1, 2, 1, 1, date.getDeltaEventMinute(null, -5), "4fe54670b860ae64", "Alabama, AL, US", "35000", "Ship4", "Trailer4", SqlRequests.nextSequence+4, 309473, "Nikolaev");

        webLogin
                .loginOnWeb(cred.webAdmin().WEBLOGIN, cred.webAdmin().WEBPASS);
        webMainScreen
                .openCustomers();
        webCustomers
                .findOrganization(cred.webAdmin().WEBORG)
                .openTestCompany();
        webMainPageOrg
                .goToGeneralPage();
        general
                .takeUsDotNumber();
        webMainPageOrg
                .goToDriversPage();
        webDrivers
                .foundDriver(cred.myDriverName().MYDRIVERNAME, cred.myDriverName().MYDRIVERLASTNAME)
                .openDriverSettings()
                .saveAllDriverProperties();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen();
        logs
                .currentLocationTake()
                .shippingTake()
                .trailerTake();
        header
                .dotInspectOpen();
        dotPage
                .checkAllDisplayedElements()
                .checkCurrentDay()
                .checkTable();
        header
                .logoutCurrentDriver(false);
    }
}
