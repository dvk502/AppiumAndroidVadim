import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logic.fleet.CreateDriver;
import logic.fleet.CreateTruck;
import logic.fleet.SideMenu;
import logic.hos.header.Header;
import logic.hos.statusPage.StatusPage;

import logic.init.BasePage;
import logic.init.Credentials;
import logic.loginPage.CheckAlertConnection;
import logic.loginPage.CheckRegFields;
import logic.loginPage.LoginPage;
import logic.loginPage.RegistrationPage;
import logic.web.Customers;
import logic.web.LoginPageWeb;
import logic.web.MainPageOrganization;
import logic.web.MainScreen;
import logic.web.companyProfile.Drivers;
import logic.web.companyProfile.Trucks;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

@Listeners(UniversalVideoListener.class)
public class Test_Case2_Account_Fleet_Manager extends BasePage {

    //CheckAlertConnection connection = new CheckAlertConnection();

    /*@BeforeClass
    public void beforeClass (ITestContext context) {
        *//*log.info("Get android driver.");
        context.setAttribute("driver", AndroidMobileDrivers.getDriver());*//*
    }*/

    /**
     * Проверка состояния WiFi. После тестов, wifi соединение должно быть включено.
     * @throws InterruptedException
     */
    /*@AfterClass
    public void checkIfWifiTurned() throws InterruptedException {
        connection.checkWiFiTurned();
    }*/
    /**
     * Создаем поля для проверки отображения данных на вебе.
     * В полях ниже хранится информация о траке, имени водителя, которые создаются в процессе тестов.
     */
    //--------------------------------------
    public String webFirstName;
    public String webLastName;
    public String truckName;
    public String loginDriver;
    public String passDriver;
    //--------------------------------------

    /**
     * Авторизуем флит-менеджера, открываем страницу создания трака нажатием на кнопку Create at least one truck.
     * Создаем трак, проверяем его отображение в приложении, а после на вебе.
     * Таким же образом создаем водителя, проверяем в приложении и на вебе.
     * При создании трака присутствует проверка на VIN номер.
     * После создания трака делаем логаут из профиля флита, логинимся на созданного водителя, проверяем отображение Privacy Policy, принимаем, делаем логаут.
     * @throws InterruptedException
     * @throws IOException
     */
    @Test(priority = 1, description = "Создаем водителя/трак из под флита с помощью кнопки Create at least one driver/truck account, проверка на отображение в приложении и на вебе.")
    //@Video(name = "Check Driver creating on Web (1)")
    public void test_Create_Driver_Truck_From_Fleet_At_Least_One_Driver_Truck_Record() throws InterruptedException, IOException {
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
        RegistrationPage regPage = new RegistrationPage();
        StatusPage statusPage = new StatusPage();
        //--------------------------------------

        truckCreate
                .loginFleet(cred.driverCredentials().FLEETLOGIN)
                .passFleet(cred.driverCredentials().FLEETPASS)
                .loginBtnPress();
        loginPage
                .chooseTypeFleet("Fleet");
        create
                .clicktoAtLeastOneDriverButton();
        truckCreate
                .addButton();
        this.webFirstName = create.firstNameField(cred.driverData().FIRSTNAME);
        this.webLastName = create.lastNameField(cred.driverData().LASTNAME);
        create
                .driverLicenseField(cred.driverData().LICENSE)
                .homeTimeZoneChoose()
                .usaDutyCycleChoose()
                .canDutyCycleChoose()
                .yardMoveChoose()
                .pcChoose()
                .loginNameInput(cred.driverData().LOGINNAME)
                .passFieldInput(cred.driverData().REGPASSWORD)
                .confPassInput(cred.driverData().CONFPASSWORD)
        //create.moveToSaveButton();
                .addDriverButtonClick()
                .confirmDriverAdd();
        loginDriver = cred.driverData().LOGINNAME;
        passDriver = cred.driverData().REGPASSWORD;
        header
                .backToMainPageFromDriversPage()
                .openFleetMenu();
        create
                .openDriversPage();
        header
                .backToMainPageFromDriversPage()
                .openFleetMenu();
        create
                .openDriversPage()
                .driverFoundButton()
                .driverFoundField(webFirstName);
                //.driverNameFoundList(webFirstName);

        header
                .collapseBack()
                .backToMainPageFromDriversPage();
        webLogin
                .loginOnWeb(cred.webAdmin().WEBLOGIN, cred.webAdmin().WEBPASS);
        webMainScreen
                .openCustomers();
        webCustomers
                .findOrganization(cred.webAdmin().WEBORG)
                .openTestCompany();
        webMainPageOrg
                .goToDriversPage();
        webDrivers
                .foundDriver(webFirstName, webLastName)
                .compareDriver(webFirstName);
        truckCreate
                .clicktoAtLeastOneTruckButton()
                .emptyTruckList()
                .addButton();
        this.truckName = truckCreate.truckNumberFld(cred.truckCreate().TRUCKNUMBER);
        truckCreate
                .eldDeviceNumber(cred.truckCreate().ELDDEVICENUMBER)
                .vinNumberCheck15Symbols("AKDLWKDGSGMGEGOEGJKAWDA")
                .licensePlate(cred.truckCreate().LICENSEPLATE)
                .makeTruck(cred.truckCreate().MAKE)
                .modelTruck(cred.truckCreate().MODEL)
                .modelYearTruck(cred.truckCreate().MODELYEAR)
                .fuelType()
                .fuelTypeChoose()
                .truckSave()
                .checkVinNumberAlert();
        truckCreate
                .vinNumber(cred.truckCreate().VINNUMBER)
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
                .backMenu();
        header
                .collapseBack()
                .backToMainPageFromTrucksPage()
                .logoutCurrentDriverFromFleet();
        loginPage
                .logoutWait();
        webLogin
                .loginOnWeb(cred.webAdmin().WEBLOGIN, cred.webAdmin().WEBPASS);
        webMainScreen
                .openCustomers();
        webCustomers
                .findOrganization(cred.webAdmin().WEBORG)
                .openTestCompany();
        webMainPageOrg
                .goToAssetsPage();
        webTruck
                .inputTruckNumber(truckName)
                .findTruck(truckName);
        loginPage
                .loginCurrentDr(loginDriver, passDriver);
        regPage
                .privacyPolicy();
        statusPage
                .clickAndroidBtn();
        header
                .logoutCurrentDriver(true);
        loginPage
                .logoutWait();
    }

    /**
     * Авторизуем флит-менеджера, открываем боковое меню.
     * В боковом меню проверяем наличие кнопок.
     * При успешном нахождении всех кнопок, делаем логаут.
     */
    @Test(priority = 4, description = "Поиск кнопок Company profile, drivers, trucks, etc.")
    public void test_Find_Buttons_in_Side_Menu() {
        //--------------------------------------
        SideMenu sideMenu = new SideMenu();
        CreateTruck truckCreate = new CreateTruck();
        Header header = new Header( );
        Credentials cred = new Credentials();
        LoginPage loginPage = new LoginPage();
        //--------------------------------------

        truckCreate
                .loginFleet(cred.driverCredentials().FLEETLOGIN)
                .passFleet(cred.driverCredentials().FLEETPASS)
                .loginBtnPress();
        loginPage
                .chooseTypeFleet("Fleet");
        header
                .openFleetMenu();
        sideMenu
                .findCompanyProfile()
                .findDrivers()
                .findTrucks()
                .findContactSupport()
                .findLogoutButton();
        header.logoutCurrentDriverFromFleet();
        loginPage.logoutWait();
    }

    @Test(priority = 2, description = "Создаем водителя из под флита с помощью кнопки Drivers в главном меню, проверяем на отображение в приложении на вебе.")
    //@Video(name = "Check Driver creating on Web (2)")
    public void test_Create_Driver_From_Fleet_Drivers_Button() throws InterruptedException {
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
        StatusPage statusPage = new StatusPage();
        RegistrationPage regPage = new RegistrationPage();
        LoginPageWeb webLogin = new LoginPageWeb();
        MainPageOrganization webMainPageOrg = new MainPageOrganization();
        //--------------------------------------

        String login = cred.driverData().LOGINNAME;
        String pass = cred.driverData().REGPASSWORD;

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
                .openDriversPage();
        truckCreate
                .addButton();
        this.webFirstName = create.firstNameField(cred.driverData().FIRSTNAME);
        this.webLastName = create.lastNameField(cred.driverData().LASTNAME);
        create
                .driverLicenseField(cred.driverData().LICENSE)
                .homeTimeZoneChoose()
                .usaDutyCycleChoose()
                .canDutyCycleChoose()
                .yardMoveChoose()
                .pcChoose()
                .loginNameInput(login)
                .passFieldInput(pass)
                .confPassInput(cred.driverData().CONFPASSWORD)
                .moveToSaveButton()
                .addDriverButtonClick()
                .confirmDriverAdd();
        header
                .backToMainPageFromDriversPage();
        header
                .openFleetMenu();
        create
                .openDriversPage()
                .driverFoundButton()
                .driverFoundField(webFirstName);
                //.driverNameFoundList(webFirstName);
        header
                .collapseBack()
                .backToMainPageFromDriversPage()
                .logoutCurrentDriverFromFleet();
        loginPage
                .logoutWait()
                .loginCurrentDr(login, pass);
        regPage
                .privacyPolicy();
        statusPage
                .clickAndroidBtn();
        header
                .logoutCurrentDriver(true);
        loginPage
                .logoutWait();
        webLogin
                .loginOnWeb(cred.webAdmin().WEBLOGIN, cred.webAdmin().WEBPASS);
        webMainScreen
                .openCustomers();
        webCustomers
                .findOrganization(cred.webAdmin().WEBORG)
                .openTestCompany();
        webMainPageOrg
                .goToDriversPage();
        webDrivers
                .foundDriver(webFirstName, webLastName)
                .compareDriver(webFirstName);
    }

    @Test(priority = 3,description = "Создаем трак из под флита через меню с помощью кнопки Trucks, проверяем на создание и отображение в приложении и на вебе.")
    //@Video(name = "Check Driver creating on Web (3)")
    public void test_Create_Truck_From_Fleet_Drivers_Button() throws InterruptedException {
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
        truckCreate
                .truckPageOpen()
                .emptyTruckList()
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
                .collapseBack();
        header
                .backToMainPageFromTrucksPage()
                .logoutCurrentDriverFromFleet();
        loginPage
                .logoutWait();
        webLogin
                .loginOnWeb(cred.webAdmin().WEBLOGIN, cred.webAdmin().WEBPASS);
        webMainScreen
                .openCustomers();
        webCustomers
                .findOrganization(cred.webAdmin().WEBORG)
                .openTestCompany();
        webMainPageOrg
                .goToAssetsPage();
        webTruck
                .inputTruckNumber(truckName)
                .findTruck(truckName);
    }

    @Test(priority = 5, description = "Проверка авторизации без подключения к интернету")
    public void test_No_Connection_Login() {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        CheckAlertConnection connection = new CheckAlertConnection();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        //--------------------------------------

        connection
                .checkStatusWifi();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                cred.driverCredentials().DRIVER_PASSWORD);
        connection
                .checkAlertText();
        connection
                .toggleWifiSwitch();
    }

    @Test(priority = 6, description = "Проверка логаута без подключения к интернету")
    public void test_No_Connection_Logout() throws InterruptedException {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        CheckAlertConnection connection = new CheckAlertConnection();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        //--------------------------------------

        connection
                .checkWiFiTurned();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                cred.driverCredentials().DRIVER_PASSWORD);
        loginPage
                .checkWifiConnected();
        statusPage
                .clickAndroidBtn();
        connection
                .checkStatusWifi();
        header
                .logoutCurrentDriverWithoutConnection();
        connection
                .toggleWifiSwitch();
        header
                .logoutCurrentDriver(true);
        loginPage
                .logoutWait();
    }
}
