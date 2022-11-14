import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import logic.dbConnection.SqlRequests;
import logic.hos.header.Header;
import logic.hos.logsPage.CreateEvents;
import logic.hos.logsPage.LogsPage;
import logic.hos.statusPage.StatusPage;
import logic.hos.truckPage.TruckConnect;
import logic.init.*;
import logic.loginPage.LoginPage;
import logic.web.Customers;
import logic.web.LoginPageWeb;
import logic.web.MainPageOrganization;
import logic.web.MainScreen;
import logic.web.companyProfile.Drivers;
import logic.web.companyProfile.Options;
import org.openqa.selenium.html5.Location;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(UniversalVideoListener.class)
public class Test_CheckLocation extends BasePage {


    @BeforeClass
    public void beforeClass(ITestContext context) {
        /*log.info("Get android driver.");
        context.setAttribute("driver", AndroidMobileDrivers.getDriver());*/
    }


    @Test(description = "Test")
    //@Video(name = "Check Location Description")
    public void test_CheckLocation() throws InterruptedException, IOException {
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
        TruckConnect truckConnect = new TruckConnect();
        LoginPageWeb webLogin = new LoginPageWeb();
        MainPageOrganization webMainPageOrg = new MainPageOrganization();
        Drivers webDrivers = new Drivers();
        Customers webCustomers = new Customers();
        MainScreen webMainScreen = new MainScreen();
        Options options = new Options();
        //--------------------------------------
        webLogin
                .loginOnWeb(cred.webAdmin().WEBLOGIN, cred.webAdmin().WEBPASS);
        webMainScreen
                .openCustomers();
        webCustomers
                .findOrganization(cred.myDriverName().DRIVERORG)
                .openTestCompany();
        webMainPageOrg
                .goToOptionsPage();
        options
                .openSystemTab()
                .setPopulationValue("100")
                .savePopulationChanges();
        driver.setLocation(new Location(39.259409, -104.888722, 10)); // Must be a driver that implements LocationContext
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .pressTruckIcon();
        truckConnect
                .chooseTruck()
                .connectTruck();
        image
                .checkTruckConnected();
        statusPage
                .openAdditionalInfo("sleep", true)
                .checkLocationDescriptionInAdditionalInfo("Colorado (CO)", "(2mi S) Larkspur");
        header
                .backMenu()
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
        options
                .setPopulationValue("5000")
                .savePopulationChanges();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .pressTruckIcon();
        truckConnect
                .chooseTruck()
                .connectTruck();
        image
                .checkTruckConnected();
        statusPage
                .openAdditionalInfo("sleep", true)
                .checkLocationDescriptionInAdditionalInfo("Colorado (CO)", "(7mi NNE) Castle Rock");
    }
}
