import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import logic.hos.iftaPage.AddFuelPurchase;
import logic.hos.iftaPage.IftaPage;
import logic.hos.logsPage.CreateEvents;
import logic.settingsPage.Permissions;
import logic.settingsPage.Settings;
import logic.hos.statusPage.StatusPage;
import logic.hos.header.Header;
import logic.init.*;
import logic.loginPage.LoginPage;
import logic.mainMenu.MainMenuDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class Test_Case7_Ifta extends BasePage {
    @BeforeClass
    public void beforeClass(ITestContext context) {
        /*log.info("Get android driver.");
        context.setAttribute("driver", AndroidMobileDrivers.getDriver());*/
    }

    @Test(description = "Test")
    public void test_Add_Photo_From_Camera_In_Ifta() throws InterruptedException {
        //--------------------------------------
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        MainMenuDriver menu = new MainMenuDriver();
        Settings settings = new Settings();
        ChangePermissions changePermissions = new ChangePermissions();
        Permissions permissions = new Permissions();
        IftaPage iftaPage = new IftaPage();
        AddFuelPurchase fuelPurchase = new AddFuelPurchase();
        //--------------------------------------

        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        changePermissions
                .disableCamera();
        header
                .openMenu();
        menu
                .openSettings();
        scrollToAnElementByText(driver, "Permissions");
        settings
                .openPermPage();
        permissions
                .checkCameraPermStatusDisable();
        header
                .backMenu()
                .backMenu()
                .openMenu();
        menu
                .openIfta();
        iftaPage
                .addFuel();
        fuelPurchase
                .inputDataFuel("5", "5", "5")
                .checkAcceptPermission();
        iftaPage
                .addFuel();
        fuelPurchase
                .inputDataFuel("5", "5", "5")
                .checkDenyPermissionCamera();
     /*   iftaPage
                .addFuel();
        fuelPurchase
                .inputDataFuel("5","5","5")
                .checkDenyPermissionGallery();*/
        header
                .backMenu()
                .backMenu()
                .logoutCurrentDriver(true);
        loginPage
                .logoutWait();
    }

    @Test(description = "Test")
    public void test_add_Wheel_onDuty_with_comment_fuel() throws InterruptedException, SQLException {
        //--------------------------------------
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        MainMenuDriver menu = new MainMenuDriver();
        Settings settings = new Settings();
        ChangePermissions changePermissions = new ChangePermissions();
        Permissions permissions = new Permissions();
        //--------------------------------------
        clearDB();
        driver.resetApp();
        loginPage.setServerIp();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        changePermissions
                .disableCamera();
        header
                .openMenu();
        menu
                .openSettings();
        scrollToAnElementByText(driver, "Permissions");
        settings
                .openPermPage();
        permissions
                .checkCameraPermStatusDisable();
        header
                .backMenu()
                .backMenu();
        statusPage
                .createWheelEventOnDutyWithoutShip("Nikolaev", "fuel")
                .checkIftaWindow()
                .clickToGalleryType()
                .denyPermissions()
                .backToApp()
                .clickToCameraType()
                .acceptPermissionsOnCamera()
                .backToApp()
                .attachLater();
        header
                .openMenu()
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }

    @Test(description = "Test")
    public void test_add_InsertEvent_onDuty_with_comment_fuel() throws InterruptedException, SQLException {
        //--------------------------------------
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        MainMenuDriver menu = new MainMenuDriver();
        Settings settings = new Settings();
        ChangePermissions changePermissions = new ChangePermissions();
        Permissions permissions = new Permissions();
        CreateEvents events = new CreateEvents();
        //--------------------------------------
        clearDB();
        driver.resetApp();
        loginPage.setServerIp();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        changePermissions
                .disableCamera();
        header
                .openMenu();
        menu
                .openSettings();
        scrollToAnElementByText(driver, "Permissions");
        settings
                .openPermPage();
        permissions
                .checkCameraPermStatusDisable();
        header
                .backMenu()
                .backMenu();
        header
                .logsOpen();
        events
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
                .inputDataEvent(true, cred.onDutyEventData().EVENTCITY, "fuel")
                .nextPageEventCreate();
        statusPage
                .checkIftaWindow()
                .clickToCameraType()
                .denyPermissions()
                .backToApp()
                .clickToGalleryType()
                .acceptPermissions()
                .backToApp()
                .attachLater();
        //driver.pressKey(new KeyEvent(AndroidKey.BACK));
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }
}
