
import logic.dbConnection.SqlRequests;
import logic.hos.header.Header;
import logic.hos.logsPage.CreateEvents;
import logic.hos.statusPage.StatusPage;

import logic.init.BasePage;
import logic.init.Credentials;
import logic.init.DateUtil;
import logic.loginPage.LoginPage;
import logic.mainMenu.MainMenuDriver;
import logic.settingsPage.Settings;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class Test_Case12_LogoutScreen extends BasePage {


    @BeforeClass
    public void beforeClass(ITestContext context) {
        /*log.info("Get android driver.");
        context.setAttribute("driver", AndroidMobileDrivers.getDriver());*/
    }

    @Test (description = "Logout_Screen")
    public void test1() throws InterruptedException, SQLException {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        CreateEvents events = new CreateEvents();
        SqlRequests sql = new SqlRequests();
        DateUtil date = new DateUtil();
        MainMenuDriver menuDriver = new MainMenuDriver();
        Settings settings = new Settings();
        //--------------------------------------
        //First
        /*loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logoutCurrentDriver(true);
        loginPage
                .logoutWait();
        //Second
        sql.takeLastEventSequence(92807);
        sql.addEvent("Driving", 92807, 5891, 1, 2, 1, 3, date.getDeltaEventMinute(null, -10), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", sql.nextSequence+1, 309473, "Nikolaev");
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logoutCurrentDriverDrivingEvent("Paris", false);
        loginPage
                .logoutWait();
        sql
                .deleteEvents(92807);
        //Third
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logoutCurrentDriver(true);
        loginPage
                .logoutWait();
        sql
                .deleteEvents(92807);
        //Fourth
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .openMenu();
        menuDriver
                .openSettings();
        settings
                .openCurrentDriverProfile(false)
                .logoutCurrentDriverInSettings();
        loginPage
                .logoutWait();
        sql
                .deleteEvents(92807);
        //Fifth
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logoutCurrentDriver(true);*/
        loginPage
                .logoutWait();
        sql.takeLastEventSequence(92807);
        sql.addEvent("On-Duty", 92807, 5891, 1, 2, 1, 4, date.getDeltaEventHours(null, -24), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", sql.nextSequence+6, 309473, "Nikolaev");
        sql.addEvent("Driving", 92807, 5891, 1, 2, 1, 3, date.getDeltaEventHours(null, -48), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", sql.nextSequence+5, 309473, "Nikolaev");
        sql.addEvent("Driving", 92807, 5891, 1, 2, 1, 3, date.getDeltaEventHours(null, -72), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", sql.nextSequence+4, 309473, "Nikolaev");
        sql.addEvent("Driving", 92807, 5891, 1, 2, 1, 3, date.getDeltaEventHours(null, -96), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", sql.nextSequence+3, 309473, "Nikolaev");
        sql.addEvent("Driving", 92807, 5891, 1, 2, 1, 3, date.getDeltaEventHours(null, -120), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", sql.nextSequence+2, 309473, "Nikolaev");
        sql.addEvent("Driving", 92807, 5891, 1, 2, 1, 3, date.getDeltaEventHours(null, -144), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", sql.nextSequence+1, 309473, "Nikolaev");
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .checkVisibilityCertificationLine()
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }
}
