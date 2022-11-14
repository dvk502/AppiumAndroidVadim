import logic.hos.header.Header;
import logic.hos.iftaPage.AddFuelPurchase;
import logic.hos.iftaPage.IftaPage;
import logic.hos.statusPage.StatusPage;

import logic.init.BasePage;
import logic.init.ChangePermissions;
import logic.init.Credentials;
import logic.loginPage.LoginPage;
import logic.mainMenu.MainMenuDriver;
import logic.settingsPage.Permissions;
import logic.settingsPage.Settings;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Case16_PermissionsAndRequirements extends BasePage {
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
                .checkCameraPermStatusDisable()
                .clickPermissionThroughSwitch()
                .choosePermissionStatusInDisplayedWindow(false)//true - enable permission in displayed window, false - disable permission in displayed window.
                .checkCameraPermStatusDisable()
                .clickPermissionThroughSwitch()
                .choosePermissionStatusInDisplayedWindow(true);//true - enable permission in displayed window, false - disable permission in displayed window.
    }
}
