import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import logic.fleet.CreateDriver;
import logic.fleet.CreateTruck;
import logic.fleet.SideMenu;
import logic.hos.dvirPage.AddInspectionReport;
import logic.hos.dvirPage.DvirPage;
import logic.hos.header.Header;
import logic.hos.logsPage.LogsPage;
import logic.hos.statusPage.StatusPage;

import logic.init.BasePage;
import logic.init.Credentials;
import logic.init.ImageSelector;
import logic.loginPage.CheckRegFields;
import logic.loginPage.LoginPage;
import logic.mainMenu.MainMenuDriver;
import logic.web.Customers;
import logic.web.LoginPageWeb;
import logic.web.MainPageOrganization;
import logic.web.MainScreen;
import logic.web.companyProfile.Options;
import logic.web.companyProfile.Trucks;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(UniversalVideoListener.class)
public class Test_Case9_TruckManagement extends BasePage {

    @BeforeClass
    public void beforeClass(ITestContext context) {
        /*log.info("Get android driver.");
        context.setAttribute("driver", AndroidMobileDrivers.getDriver());*/
    }

    public String truckName;
    public String truckName2;

//    String truckNumberCreated;
    String eldDeviceCreated;
    String vinNumberCreated;
    String licensePlateCreated;
    String makeTruckCreated;
    String modelTruckCreated;
    String modelYearTruckCreated;
    String truckNumberNew;
    String eldDeviceNew;
    String vinNumberNew;
    String licensePlateNew;
    String makeTruckNew;
    String modelTruckNew;
    String modelYearTruckNew;

    //--------------------------------------
    LoginPage loginPage = new LoginPage();
    Credentials cred = new Credentials();
    StatusPage statusPage = new StatusPage();
    Header header = new Header();
    CreateTruck truckCreate = new CreateTruck();
    SideMenu sideMenu = new SideMenu();
    MainPageOrganization webMainPageOrg = new MainPageOrganization();
    Trucks webTruck = new Trucks();
    MainScreen webMainScreen = new MainScreen();
    Customers webCustomers = new Customers();
    LoginPageWeb webLogin = new LoginPageWeb();
    //--------------------------------------
    @Test(description = "Test")
    //@Video(name = "TruckManagement")
    public void test_truckManagement() throws IOException, InterruptedException {
        loginPage
                .loginCurrentDr("fleet11638449630318@gmail.com", "test12345");
        header
                .openFleetMenu();
        truckCreate
                .truckPageOpen()
                .emptyTruckList();
        header
                .backToMainPageFromTrucksPage()
                .logoutCurrentDriverFromFleet();
        loginPage
                .logoutWait();
        truckCreate.loginFleet(cred.myOwner().OWNER_LOGIN)
                .passFleet(cred.myOwner().OWNER_PASS)
                .loginBtnPress();
        loginPage
                .chooseTypeFleet("Fleet");
        header
                .openFleetMenu();
        truckCreate
                .truckPageOpen()
                .addButton();
        truckCreate
                .checkRequireFields("2332", cred.truckCreate().TRUCKNUMBER, cred.truckCreate().ELDDEVICENUMBER, cred.truckCreate().VINNUMBER, cred.truckCreate().LICENSEPLATE, cred.truckCreate().MAKE, cred.truckCreate().MODEL, cred.truckCreate().MODELYEAR);
        header
                .backMenu();
        truckCreate
                .addButton();
        this.truckName = truckCreate.truckNumberFld(cred.truckCreate().TRUCKNUMBER);
        truckCreate
                .eldDeviceNumber(cred.truckCreate().ELDDEVICENUMBER)
                .vinNumber(cred.truckCreate().VINNUMBER)
                .licensePlate(cred.truckCreate().LICENSEPLATE)
                .makeTruck(cred.truckCreate().MAKE)
                .modelTruck(cred.truckCreate().MODEL)
                .modelYearTruck(cred.truckCreate().MODELYEAR)
                .fuelType()
                .fuelTypeChoose()
                .truckSave();
        header
                .backToMainPageFromTrucksPage()
                .openFleetMenu();
        truckCreate
                .truckPageOpen()
                .truckFoundButton()
                .truckFoundField()
                .truckFind()
                .vinTruckCompare()
                .licenseTruckCompare()
                .makeCompare()
                .modelFieldCompare()
                .modelYearCompare()
                .fuelTypeCompare();
        header
                .backMenu()
                .collapseBack()
                .backToMainPageFromTrucksPage()
                .logoutCurrentDriverFromFleet();
        truckCreate.loginFleet(cred.myOwner().OWNER_LOGIN)
                .passFleet(cred.myOwner().OWNER_PASS)
                .loginBtnPress();
        loginPage
                .chooseTypeFleet("Driver");
        statusPage
                .clickAndroidBtn();
        header
                .openMenu();
        sideMenu
                .findTrucks();
        truckCreate
                .truckPageOpen()
                .truckFoundButton()
                .truckFoundField()
                .truckFindonDriverFleet()
                .vinTruckCompare()
                .licenseTruckCompare()
                .makeCompare()
                .modelFieldCompare()
                .modelYearCompare()
                .fuelTypeCompare();
        //truckNumberCreated = cred.truckCreate().TRUCKNUMBER;
        eldDeviceCreated = cred.truckCreate().ELDDEVICENUMBER;
        vinNumberCreated = cred.truckCreate().VINNUMBER;
        licensePlateCreated = cred.truckCreate().LICENSEPLATE;
        makeTruckCreated = cred.truckCreate().MAKE;
        modelTruckCreated = cred.truckCreate().MODEL;
        modelYearTruckCreated = cred.truckCreate().MODELYEAR;
        /*truckCreate
                .truckNumberFld(truckNumberCreated);*/
        truckCreate
                .eldDeviceNumber(eldDeviceCreated)
                .vinNumber(vinNumberCreated)
                .licensePlate(licensePlateCreated)
                .makeTruck(makeTruckCreated)
                .modelTruck(modelTruckCreated)
                .modelYearTruck(modelYearTruckCreated)
                .truckSave();
        header
                .collapseBack();
        truckCreate
                .addButton();
        truckNumberNew = cred.truckCreate().TRUCKNUMBER;
        eldDeviceNew = cred.truckCreate().ELDDEVICENUMBER;
        vinNumberNew = cred.truckCreate().VINNUMBER;
        licensePlateNew = cred.truckCreate().LICENSEPLATE;
        makeTruckNew = cred.truckCreate().MAKE;
        modelTruckNew = cred.truckCreate().MODEL;
        modelYearTruckNew = cred.truckCreate().MODELYEAR;
        truckCreate.truckNumberFld(truckNumberNew);
        truckCreate
                .eldDeviceNumber(eldDeviceNew)
                .vinNumber(vinNumberNew)
                .licensePlate(licensePlateNew)
                .makeTruck(makeTruckNew)
                .modelTruck(modelTruckNew)
                .modelYearTruck(modelYearTruckNew)
                .fuelType()
                .fuelTypeChoose()
                .truckSave();
        header
                .backMenu()
                .logoutCurrentDriver(true);
        loginPage
                .logoutWait();
        truckCreate.loginFleet(cred.myOwner().OWNER_LOGIN)
                .passFleet(cred.myOwner().OWNER_PASS)
                .loginBtnPress();
        loginPage
                .chooseTypeFleet("Fleet");
        header
                .openFleetMenu();
        truckCreate
                .truckPageOpen()
                .truckFoundButton()
                .truckFoundFieldName(truckName)
                .truckOpenName(truckName)
                .truckDataCompare(truckName, eldDeviceCreated, vinNumberCreated, licensePlateCreated, makeTruckCreated, modelTruckCreated, modelYearTruckCreated);
        header
                .backMenu();
        truckCreate
                .truckFoundFieldName(truckNumberNew)
                .truckOpenName(truckNumberNew)
                .truckDataCompare(truckNumberNew, eldDeviceNew, vinNumberNew, licensePlateNew, makeTruckNew, modelTruckNew, modelYearTruckNew);
        header
                .backMenu()
                .collapseBack()
                .backToMainPageFromTrucksPage()
                .logoutCurrentDriverFromFleet();
        webLogin
                .loginOnWeb(cred.webAdmin().WEBLOGIN, cred.webAdmin().WEBPASS);
        webMainScreen
                .openCustomers();
        webCustomers
                .findOrganization("MyAppium")
                .openTestCompany();
        webMainPageOrg
                .goToAssetsPage();
        webTruck
                .inputTruckNumber(truckNumberNew)
                .findTruck(truckNumberNew)
                .openTruckPage()
                .changeGpsProvider()
                .changeTruckInformation()
                .saveChangesTruck();
    }

    @Test(description = "Test")
    public void test_truckManagement_2() throws InterruptedException {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        DvirPage dvir = new DvirPage();
        AddInspectionReport addIR = new AddInspectionReport();
        MainMenuDriver menu = new MainMenuDriver();
        LogsPage logs = new LogsPage();
        CreateTruck truckCreate = new CreateTruck();
        CreateDriver driverCreate = new CreateDriver();
        CheckRegFields check = new CheckRegFields();
        ImageSelector imageFinder = new ImageSelector();
        SideMenu sideMenu = new SideMenu();
        //--------------------------------------
        truckCreate.loginFleet(cred.myOwner().OWNER_LOGIN)
                .passFleet(cred.myOwner().OWNER_PASS)
                .loginBtnPress();
        loginPage
                .chooseTypeFleet("Driver");
        statusPage
                .clickAndroidBtn();
        header
                .openMenu();
        sideMenu
                .findTrucks();
        truckCreate
                .truckPageOpen();
        header
                .backMenu();
        header
                .logoutCurrentDriver(true);
    }
}
