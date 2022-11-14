import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import logic.fleet.CreateTruck;
import logic.hos.header.Header;
import logic.hos.statusPage.StatusPage;
import logic.init.*;
import logic.loginPage.CheckRegFields;
import logic.loginPage.LoginPage;
import logic.loginPage.RegistrationPage;
import logic.web.Customers;
import logic.web.LoginPageWeb;
import logic.web.MainPageOrganization;
import logic.web.MainScreen;
import logic.web.companyProfile.Drivers;
import logic.web.companyProfile.Trucks;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

@Listeners(UniversalVideoListener.class)
public class Test_Case1_Registration extends BasePage {


    //--------------------------------------*
    /**
     * Создаем поля для проверки отображения данных на вебе.
     * В полях ниже хранится информация о траке, названии компании, имени водителя, которые создаются в процессе тестов.
     */
    public String truckName;
    public String nameOfCompany;
    public String webFirstName;
    public String webLastName;

    private void checkFieldsOwnerAndFleetDriver() throws InterruptedException {
        RegistrationPage regPage = new RegistrationPage();
        CheckRegFields check = new CheckRegFields();
        Credentials cred = new Credentials();
        regPage
                .checkSnackBar("companyName");
        check
                .checkUsdot(cred.fleetDataND().COMPANYNAME)
                .nextPageButton();
        regPage
                .checkSnackBar("usdot");
        check
                .checkMcNumber(cred.fleetDataND().USDOT)
                .nextPageButton();
        regPage
                .checkSnackBar("mcnumber");
        check
                .checkFirstName(cred.fleetDataND().MCNUMBER)
                .nextPageButton();
        regPage
                .checkSnackBar("firstname");
        check
                .checkLastName(cred.fleetDataND().FLEETNAME)
                .nextPageButton();
        regPage
                .checkSnackBar("lastname");
        check
                .checkEmail(cred.fleetDataND().FLEETLASTNAME)
                .nextPageButton();
        regPage
                .checkSnackBar("email");
        check
                .checkPass(cred.fleetDataND().EMAILFLEET)
                .nextPageButton();
        regPage
                .checkSnackBar("enterPassword");

        check
                .checkConfPass(cred.fleetDataND().REGPASSWORD)
                .nextPageButton();
        regPage
                .checkSnackBar("confirmPassword");
        check
                .checkLicense(cred.fleetDataND().CONFPASSWORD)
                .nextPageButton();
        regPage
                .checkSnackBar("driverLicense");
        check
                .licenseInput("awdawdawda21321123adwadawdaw")
                .nextPageButton();
        regPage
                .checkSnackBar("longDriverLicense");
        check
                .licenseInput("TestLicense222333")
                .smallpass(cred.fleetDataND().SMALPASS, cred.fleetDataND().CONFSMALLPASS)
                .nextPageButton();
        regPage
                .checkSnackBar("smallPass");
        check
                .usdotSymbols("WADKOW", "Test12345", "Test12345")
                .nextPageButton();
        regPage
                .checkSnackBar("usdot");
        check
                .usdotSymbols("231423322231", "Test12345", "Test12345")
                .nextPageButton();
        regPage
                .checkSnackBar("usdot>9");
        check
                .checkShortFirstName("T")
                .nextPageButton();
        regPage
                .checkSnackBar("firstname");
        check
                .checkLongFirstName("Faithbia-n.")
                .checkShortLastName("L")
                .nextPageButton();
        regPage
                .checkSnackBar("lastname");
        check
                .checkLongFirstName("AWDAWDAWDAWDAWDAWDaWDAWDAWDAWDAWDAWDAWDAWDAWDAWDAWEDAWDAWD")
                .checkShortLastName("Faithbia-n.")
                .nextPageButton();
        regPage
                .checkSnackBar("firstname");
        check
                .checkShortFirstName("Faithbia-n.")
                .checkLongLastName("WLOAWMKDOAWDJAWOPDJKWAPODJKWAPDKWAPDKOPAKDPOAWKPAWKDPOAWKD")
                .nextPageButton();
        regPage
                .checkSnackBar("lastname");
        check
                .checkLongLastName("Faith'bia-n.")
                .usdotInput(cred.fleetDataND().USDOT)
                .nextPageButton();
        regPage
                .inputZip("11111")
                .inputCity("City")
                .inputPhone("1111111111")
                .saveBtn2()
                .checkSnackBar("Address")
                .inputAddress("Adress")
                .inputCity("")
                .saveBtn2()
                .checkSnackBar("City")
                .inputCity("City")
                .inputPhone("")
                .saveBtn2()
                .checkSnackBar("Phone")
                .inputPhone("4545454454");
        check
                .checkSetZipCodesUsa()
                .checkSetFailCodesUsa();
        regPage
                .chooseCountryFromList("canada");
        check
                .checkSetZipCodesCanada()
                .checkSetFailCodesCanada()
                .backToRegMenu()
                .backToRegMenu()
                .backToRegMenu();
    }

    //--------------------------------------*

    @Test(priority = 1, description = "Проверяем регистрацию Флита (водителя).")
    public void test_Fleet_Driver_Registration() throws InterruptedException {
        //--------------------------------------*
        CheckRegFields check = new CheckRegFields();
        Credentials cred = new Credentials();
        RegistrationPage regPage = new RegistrationPage();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        //--------------------------------------*
        /**
         * Открываем страницу регистрации пользователя, выбираем тип Fleet (Driver).
         * Заполняем обязательные поля для регистрации.
         * Пытаемся сохранить пользователя, ожидаем успешное отображение Privacy Policy.
         * Проверяем корректное отображение Privacy Policy, открытие всех кликабельных ссылок.
         * Принимаем условия Privacy Policy, ожидаем авторизацию созданного пользователя.
         * При успешной авторизации после регистрации данного пользователя делаем логаут.
         */
        regPage
                .goToFleetReg();
        check
                .chooseFleetDriver();
        regPage
                .fleetDriverReg(cred.fleetDataND().COMPANYNAME, cred.fleetDataND().USDOT, cred.fleetDataND().MCNUMBER,
                        cred.fleetDataND().FLEETNAME, cred.fleetDataND().FLEETLASTNAME, cred.fleetDataND().EMAILFLEET,
                        cred.fleetDataND().REGPASSWORD, cred.fleetDataND().CONFPASSWORD, cred.driverData().LICENSE);
        regPage
                .nextPageButton();
        regPage
                .fleetNoDriverReg2(cred.fleetDataND().FLEETADRESS, cred.fleetDataND().CITYFIELD,
                        cred.fleetDataND().ZIPCODE, cred.fleetDataND().PHONENUMBER);
        regPage
                .saveBtn2()
                .privacyPolicy();
        header
                .logoutCurrentDriverFromFleet();
        loginPage
                .logoutWait();
    }


    @Test(priority = 2, description = "Проверяем заполнение обязательных полей у Флита (Водителя).")
    public void test_Fleet_Driver_FieldsCheck() throws IOException, InterruptedException {
        //--------------------------------------*
        CheckRegFields check = new CheckRegFields();
        ImageSelector imgFind = new ImageSelector();
        Credentials cred = new Credentials();
        RegistrationPage regPage = new RegistrationPage();
        //--------------------------------------*
        /**
         * Открываем страницу регистрации, выбираем тип Fleet (Driver).
         * Вводим информацию во все поля, оставляя пустым одно из полей, начиная с первого, пытаемся зарегистрировать водителя.
         * Ожидаем отображение Snack Bar окна, с уведомлением о том что одно из полей не заполнено, с указанием названия поля.
         * После отображения Snack Bar окна, заполняем пустое поле, очищаем следующее.
         * Проверив все поля на корректность отображения Snack Bar возвращаемся на страницу авторизации.
         */
        check
                .goToReg()
                .goToFleetReg()
                .chooseFleetDriver()
                .checkFieldsFleetDriver(cred.fleetDataND().USDOT, cred.fleetDataND().MCNUMBER, cred.fleetDataND().FLEETNAME,
                        cred.fleetDataND().FLEETLASTNAME, cred.fleetDataND().EMAILFLEET, cred.fleetDataND().REGPASSWORD,
                        cred.fleetDataND().CONFPASSWORD, cred.driverData().LICENSE)
                .nextPageButton();
        checkFieldsOwnerAndFleetDriver();
    }

    @Test(priority = 3, description = "Проверяем регистрацию Флита (не водителя).")
    public void test_Fleet_Not_A_Driver_Registration() throws InterruptedException {
        //--------------------------------------*
        Credentials cred = new Credentials();
        RegistrationPage regPage = new RegistrationPage();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        //--------------------------------------*
        /**
         * Открываем страницу регистрации пользователя, выбираем тип Fleet (Not a Driver).
         * Заполняем обязательные поля для регистрации.
         * Пытаемся сохранить пользователя, ожидаем успешное отображение Privacy Policy.
         * Проверяем корректное отображение Privacy Policy, открытие всех кликабельных ссылок.
         * Принимаем условия Privacy Policy, ожидаем авторизацию созданного пользователя.
         * При успешной авторизации после регистрации данного пользователя делаем логаут.
         */
        regPage
                .goToFleetReg();
        regPage
                .chooseFleetNoDriver();
        regPage
                .fleetNoDriverReg(cred.fleetDataND().COMPANYNAME, cred.fleetDataND().USDOT,
                        cred.fleetDataND().MCNUMBER, cred.fleetDataND().FLEETNAME, cred.fleetDataND().FLEETLASTNAME,
                        cred.fleetDataND().EMAILFLEET, cred.fleetDataND().REGPASSWORD, cred.fleetDataND().CONFPASSWORD);
        regPage
                .nextPageButton();
        regPage
                .fleetNoDriverReg2(cred.fleetDataND().FLEETADRESS, cred.fleetDataND().CITYFIELD,
                        cred.fleetDataND().ZIPCODE, cred.fleetDataND().PHONENUMBER);
        regPage
                .saveBtn2()
                .privacyPolicy();
        header
                .logoutCurrentDriverFromFleet();
        loginPage
                .logoutWait();
    }

    @Test(priority = 4, description = "Проверяем заполнение обязательных полей у Флита (не водителя).")
    public void test_Fleet_Not_A_Driver_FieldsCheck() throws IOException, InterruptedException {
        //--------------------------------------*
        CheckRegFields check = new CheckRegFields();
        Credentials cred = new Credentials();
        RegistrationPage regPage = new RegistrationPage();
        //--------------------------------------*
        /**
         * Открываем страницу регистрации, выбираем тип Fleet (Not a Driver).
         * Вводим информацию во все поля, оставляя пустым одно из полей, начиная с первого, пытаемся зарегистрировать водителя.
         * Ожидаем отображение Snack Bar окна, с уведомлением о том что одно из полей не заполнено, с указанием названия поля.
         * После отображения Snack Bar окна, заполняем пустое поле, очищаем следующее.
         * Проверив все поля на корректность отображения Snack Bar возвращаемся на страницу авторизации.
         */
        check
                .goToReg()
                .goToFleetReg()
                .chooseFleetNoDriver()
                .checkFieldsFleetNoDriver(cred.fleetDataND().USDOT, cred.fleetDataND().MCNUMBER, cred.fleetDataND().FLEETNAME,
                        cred.fleetDataND().FLEETLASTNAME, cred.fleetDataND().EMAILFLEET, cred.fleetDataND().REGPASSWORD,
                        cred.fleetDataND().CONFPASSWORD)
                .nextPageButton();
        regPage
                .checkSnackBar("companyName");
        check
                .checkUsdot(cred.fleetDataND().COMPANYNAME)
                .nextPageButton();
        regPage
                .checkSnackBar("usdot");
        check
                .checkMcNumber(cred.fleetDataND().USDOT)
                .nextPageButton();
        regPage
                .checkSnackBar("mcnumber");
        check
                .checkFirstName(cred.fleetDataND().MCNUMBER)
                .nextPageButton();
        regPage
                .checkSnackBar("firstname");
        check
                .checkLastName(cred.fleetDataND().FLEETNAME)
                .nextPageButton();
        regPage
                .checkSnackBar("lastname");
        check
                .checkEmail(cred.fleetDataND().FLEETLASTNAME)
                .nextPageButton();
        regPage
                .checkSnackBar("email");
        check
                .checkPass(cred.fleetDataND().EMAILFLEET)
                .nextPageButton();
        regPage
                .checkSnackBar("enterPassword");
        check
                .checkConfPass(cred.fleetDataND().REGPASSWORD)
                .nextPageButton();
        regPage
                .checkSnackBar("confirmPassword");
        check
                .smallpass(cred.fleetDataND().SMALPASS, cred.fleetDataND().CONFSMALLPASS)
                .nextPageButton();
        regPage
                .checkSnackBar("smallPass");
        check
                .usdotSymbols("WADKOW", "Test12345", "Test12345")
                .nextPageButton();
        regPage
                .checkSnackBar("usdot");
        check
                .usdotSymbols("231423322231", "Test12345", "Test12345")
                .nextPageButton();
        regPage
                .checkSnackBar("usdot>9");
        check
                .checkShortFirstName("T")
                .nextPageButton();
        regPage
                .checkSnackBar("firstname");
        check
                .checkLongFirstName("Faithbia-n.")
                .checkShortLastName("L")
                .nextPageButton();
        regPage
                .checkSnackBar("lastname");
        check
                .checkLongFirstName("AWDAWDAWDAWDAWDAWDaWDAWDAWDAWDAWDAWDAWDAWDAWDAWDAWEDAWDAWD")
                .checkShortLastName("Faithbia-n.")
                .nextPageButton();
        regPage
                .checkSnackBar("firstname");
        check
                .checkShortFirstName("Faithbia-n.")
                .checkLongLastName("WLOAWMKDOAWDJAWOPDJKWAPODJKWAPDKWAPDKOPAKDPOAWKPAWKDPOAWKD")
                .nextPageButton();
        regPage
                .checkSnackBar("lastname");
        check
                .checkLongLastName("Faith'bia-n.")
                .usdotInput(cred.fleetDataND().USDOT)
                .nextPageButton();
/*        regPage
                .checkSnackBar("lastname");
        check
                .checkLongLastName("LastName")
                .usdotInput("123123123")
                .nextPageButton();*/
        regPage
                .inputZip("11111")
                .inputCity("City")
                .inputPhone("1111111111")
                .saveBtn2()
                .checkSnackBar("Address")
                .inputAddress("Adress")
                .inputCity("")
                .saveBtn2()
                .checkSnackBar("City")
                .inputCity("City")
                .inputPhone("")
                .saveBtn2()
                .checkSnackBar("Phone")
                .inputPhone("4545454454");
        check
                .checkSetZipCodesUsa()
                .checkSetFailCodesUsa();
        regPage
                .chooseCountryFromList("canada");
        check
                .checkSetZipCodesCanada()
                .checkSetFailCodesCanada()
                .backToRegMenu()
                .backToRegMenu()
                .backToRegMenu();
    }

    @Test(priority = 5, description = "Проверяем регистрацию Овнер-Оператора.")
    //@Video(name = "Registration_1")
    public void test_Owner_Operator_Registration() throws InterruptedException {
        //--------------------------------------*
        CheckRegFields check = new CheckRegFields();
        Credentials cred = new Credentials();
        RegistrationPage regPage = new RegistrationPage();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        Trucks webTruck = new Trucks();
        MainScreen webMainScreen = new MainScreen();
        LoginPageWeb webLogin = new LoginPageWeb();
        Customers webCustomers = new Customers();
        CreateTruck truckCreate = new CreateTruck();
        MainPageOrganization webMainPageOrg = new MainPageOrganization();
        //--------------------------------------*

        this.nameOfCompany = cred.fleetDataND().COMPANYNAME;

        //--------------------------------------*
        /**
         * Открываем страницу регистрации пользователя, выбираем тип Owner Operator.
         * Заполняем обязательные поля для регистрации.
         * Пытаемся сохранить пользователя, ожидаем успешное отображение Privacy Policy.
         * Проверяем корректное отображение Privacy Policy, открытие всех кликабельных ссылок.
         * Принимаем условия Privacy Policy, ожидаем авторизацию созданного пользователя.
         * При успешной авторизации после регистрации данного пользователя делаем логаут.
         */

        check
                .goToReg();
        check
                .chooseOwner();
        regPage
                .fleetDriverReg(cred.fleetDataND().COMPANYNAME, cred.fleetDataND().USDOT, cred.fleetDataND().MCNUMBER,
                        cred.fleetDataND().FLEETNAME, cred.fleetDataND().FLEETLASTNAME, cred.fleetDataND().EMAILFLEET,
                        cred.fleetDataND().REGPASSWORD, cred.fleetDataND().CONFPASSWORD, cred.driverData().LICENSE);
        //regPage.moveToBtn();
        regPage
                .nextPageButton();
        regPage
                .fleetNoDriverReg2(cred.fleetDataND().FLEETADRESS, cred.fleetDataND().CITYFIELD,
                        cred.fleetDataND().ZIPCODE, cred.fleetDataND().PHONENUMBER);
        regPage
                .saveBtn2()
                .privacyPolicy();
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
                .findOrganization(nameOfCompany)
                .openTestCompany();
        webMainPageOrg
                .goToAssetsPage();
        webTruck
                .inputTruckNumber(truckName)
                .findTruck(truckName);
    }

    @Test(priority = 6, description = "Проверяем заполнение обязательных полей у Овнер-Оператора.")
    public void test_Owner_Operator_CheckFields() throws IOException, InterruptedException {
        //--------------------------------------*
        CheckRegFields check = new CheckRegFields();
        Credentials cred = new Credentials();
        RegistrationPage regPage = new RegistrationPage();
        //--------------------------------------*
        /**
         * Открываем страницу регистрации, выбираем тип Owner Operator.
         * Вводим информацию во все поля, оставляя пустым одно из полей, начиная с первого, пытаемся зарегистрировать водителя.
         * Ожидаем отображение Snack Bar окна, с уведомлением о том что одно из полей не заполнено, с указанием названия поля.
         * После отображения Snack Bar окна, заполняем пустое поле, очищаем следующее.
         * Проверив все поля на корректность отображения Snack Bar возвращаемся на страницу авторизации.
         */
        check
                .goToReg()
                .chooseOwner()
                .checkFieldsOwner(cred.fleetDataND().USDOT, cred.fleetDataND().MCNUMBER, cred.fleetDataND().FLEETNAME,
                        cred.fleetDataND().FLEETLASTNAME, cred.fleetDataND().EMAILFLEET, cred.fleetDataND().REGPASSWORD,
                        cred.fleetDataND().CONFPASSWORD, cred.driverData().LICENSE)
                .nextPageButton();
        checkFieldsOwnerAndFleetDriver();
    }

    @Test(priority = 7, description = "Проверяем регистрацию Водителя.")
    //@Video(name = "Registration_2")
    public void test_Driver_Registration() throws InterruptedException {
        //--------------------------------------*
        LoginPageWeb webLogin = new LoginPageWeb();
        Customers webCustomers = new Customers();
        Credentials cred = new Credentials();
        RegistrationPage regPage = new RegistrationPage();
        MainPageOrganization webMainPageOrg = new MainPageOrganization();
        StatusPage statusPage = new StatusPage();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        MainScreen webMainScreen = new MainScreen();
        Drivers webDrivers = new Drivers();
        regPage.goToDriverRegistration();
        //--------------------------------------*

        this.webFirstName = cred.driverData().FIRSTNAME;
        this.webLastName = cred.driverData().LASTNAME;

        //--------------------------------------*
        /**
         * Открываем страницу регистрации пользователя, выбираем тип Driver.
         * Заполняем обязательные поля для регистрации.
         * Пытаемся сохранить пользователя, ожидаем успешное отображение Privacy Policy.
         * Проверяем корректное отображение Privacy Policy, открытие всех кликабельных ссылок.
         * Принимаем условия Privacy Policy, ожидаем авторизацию созданного пользователя.
         * При успешной авторизации после регистрации данного пользователя делаем логаут.
         */

        regPage
                .sendTextInRegisterField(cred.driverData().ORGPIN, cred.driverData().FIRSTNAME,
                        cred.driverData().LASTNAME, cred.driverData().EMAIL, cred.driverData().REGPASSWORD,
                        cred.driverData().CONFPASSWORD, cred.driverData().LICENSE);
        regPage
                .saveBtn()
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

    @Test(priority = 8, description = "Проверяем заполнение обязательных полей у Водителя.")
    public void test_Driver_CheckFields() throws IOException {
        //--------------------------------------*
        CheckRegFields check = new CheckRegFields();
        ImageSelector imgFind = new ImageSelector();
        Credentials cred = new Credentials();
        RegistrationPage regPage = new RegistrationPage();
        //--------------------------------------*
        /**
         * Открываем страницу регистрации, выбираем тип Driver.
         * Вводим информацию во все поля, оставляя пустым одно из полей, начиная с первого, пытаемся зарегистрировать водителя.
         * Ожидаем отображение Snack Bar окна, с уведомлением о том что одно из полей не заполнено, с указанием названия поля.
         * После отображения Snack Bar окна, заполняем пустое поле, очищаем следующее.
         * Проверив все поля на корректность отображения Snack Bar возвращаемся на страницу авторизации.
         */

        check
                .goToReg()
                .driverRegPage()
                .checkFieldsDriver(cred.driverData().FIRSTNAME, cred.fleetDataND().LASTNAME, cred.fleetDataND().EMAIL,
                        cred.fleetDataND().REGPASSWORD, cred.fleetDataND().CONFPASSWORD, cred.driverData().LICENSE)
                .nextPageButton();
        regPage
                .checkSnackBar("orgpin");
        check
                .checkFirstNameDriver(cred.fleetDataND().ORGPIN)
                .nextPageButton();
        regPage
                .checkSnackBar("firstname");
        check
                .checkLastName(cred.fleetDataND().FIRSTNAME)
                .nextPageButton();
        regPage
                .checkSnackBar("lastname");
        check
                .checkEmail(cred.fleetDataND().LASTNAME)
                .nextPageButton();
        regPage
                .checkSnackBar("email");
        check
                .checkPass(cred.fleetDataND().EMAIL)
                .nextPageButton();
        regPage
                .checkSnackBar("enterPassword");
        check
                .checkConfPass(cred.fleetDataND().REGPASSWORD)
                .nextPageButton();
        regPage
                .checkSnackBar("confirmPassword");
        check
                .checkLicense(cred.fleetDataND().CONFPASSWORD)
                .nextPageButton();
        regPage
                .checkSnackBar("driverLicense");
        check
                .longLicense("22232039203923029322231312312")
                .nextPageButton();
        regPage
                .checkSnackBar("londDriverLicense");
        check
                .smallpass(cred.fleetDataND().SMALPASS, cred.fleetDataND().CONFSMALLPASS)
                .nextPageButton();
        regPage
                .checkSnackBar("smallPass");
        check
                .checkShortFirstName("T")
                .nextPageButton();
        regPage
                .checkSnackBar("firstname");
        check
                .checkShortFirstName("FirstName")
                .checkShortLastName("L")
                .nextPageButton();
        regPage
                .checkSnackBar("lastname");
        check
                .checkShortLastName("LastName")
                .checkLongFirstName("AWDAWDAWDAWDAWDAWDaWDAWDAWDAWDAWDAWDAWDAWDAWDAWDAWEDAWDAWD")
                .nextPageButton();
        regPage
                .checkSnackBar("firstname");
        check
                .checkLongFirstName("FirstName")
                .checkLongLastName("WLOAWMKDOAWDJAWOPDJKWAPODJKWAPDKWAPDKOPAKDPOAWKPAWKDPOAWKD")
                .nextPageButton();
        regPage
                .checkSnackBar("lastname");
        check
                .longsPass(cred.fleetDataND().REGPASSWORD, cred.fleetDataND().CONFPASSWORD)
                .checkLongLastName("LastName")
                .licenseInput(cred.driverData().SAMELICENSE)
                .nextPageButton();
        regPage
                .checkSnackBar("samelicense");
        check
                .backToRegMenu()
                .backToRegMenu();
    }

    @Test(priority = 9, description = "Проверяем отображение Privacy Policy у Флита (водителя).")
    public void test_Privacy_Policy_new_Fleet_driver() throws InterruptedException {
        //--------------------------------------*
        CheckRegFields check = new CheckRegFields();
        Credentials cred = new Credentials();
        RegistrationPage regPage = new RegistrationPage();
        LoginPage loginPage = new LoginPage();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        regPage.goToFleetReg();
        check.chooseFleetDriver();
        //--------------------------------------*

        String login = cred.fleetDataND().EMAIL;
        String pass = cred.fleetDataND().REGPASSWORD;

        //--------------------------------------*
        /**
         * Открываем страницу регистрации пользователя, выбираем тип Fleet (Driver).
         * Заполняем обязательные поля для регистрации.
         * Пытаемся сохранить пользователя, ожидаем успешное отображение Privacy Policy.
         * Проверяем корректное отображение Privacy Policy, открытие всех кликабельных ссылок.
         * Принимаем условия Privacy Policy, ожидаем авторизацию созданного пользователя.
         * При успешной авторизации после регистрации данного пользователя делаем логаут.
         * Пытаемся авторизоваться на водителя повторно, проверяем что окно Privacy Policy не отобразилось повторно.
         * При успешной авторизации пользователя, делаем логаут.
         */
        regPage
                .fleetDriverReg(cred.fleetDataND().COMPANYNAME, cred.fleetDataND().USDOT, cred.fleetDataND().MCNUMBER,
                        cred.fleetDataND().FLEETNAME, cred.fleetDataND().FLEETLASTNAME, login,
                        pass, cred.fleetDataND().CONFPASSWORD, cred.driverData().LICENSE);
        regPage
                .nextPageButton();
        regPage
                .fleetNoDriverReg2(cred.fleetDataND().FLEETADRESS, cred.fleetDataND().CITYFIELD,
                        cred.fleetDataND().ZIPCODE, cred.fleetDataND().PHONENUMBER);
        regPage
                .saveBtn2()
                .privacyPolicy();
        header
                .logoutCurrentDriverFromFleet();
        loginPage
                .logoutWait();
        loginPage
                .loginCurrentDr(login, pass);
        loginPage
                .chooseTypeFleet("Driver");
        statusPage
                .clickAndroidBtn();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }

    @Test(priority = 10, description = "Проверяем отображение Privacy Policy у Флита (НЕ водителя).")
    public void test_Privacy_Policy_new_Fleet_Not_a_driver() throws InterruptedException {
        //--------------------------------------*
        Credentials cred = new Credentials();
        RegistrationPage regPage = new RegistrationPage();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        //--------------------------------------*

        String login = cred.fleetDataND().EMAIL;
        String pass = cred.fleetDataND().REGPASSWORD;

        //--------------------------------------*
        /**
         * Открываем страницу регистрации пользователя, выбираем тип Fleet (Not a Driver).
         * Заполняем обязательные поля для регистрации.
         * Пытаемся сохранить пользователя, ожидаем успешное отображение Privacy Policy.
         * Проверяем корректное отображение Privacy Policy, открытие всех кликабельных ссылок.
         * Принимаем условия Privacy Policy, ожидаем авторизацию созданного пользователя.
         * При успешной авторизации после регистрации данного пользователя делаем логаут.
         * Пытаемся авторизоваться на водителя повторно, проверяем что окно Privacy Policy не отобразилось повторно.
         * При успешной авторизации пользователя, делаем логаут.
         */

        regPage
                .goToFleetReg();
        regPage
                .chooseFleetNoDriver();
        regPage
                .fleetNoDriverReg(cred.fleetDataND().COMPANYNAME, cred.fleetDataND().USDOT,
                        cred.fleetDataND().MCNUMBER, cred.fleetDataND().FLEETNAME, cred.fleetDataND().FLEETLASTNAME,
                        login, pass, cred.fleetDataND().CONFPASSWORD);
        regPage
                .nextPageButton();
        regPage
                .fleetNoDriverReg2(cred.fleetDataND().FLEETADRESS, cred.fleetDataND().CITYFIELD,
                        cred.fleetDataND().ZIPCODE, cred.fleetDataND().PHONENUMBER);
        regPage
                .saveBtn2()
                .privacyPolicy();
        header
                .logoutCurrentDriverFromFleet();
        loginPage
                .logoutWait();
        loginPage
                .loginCurrentDr(login, pass);
        header
                .logoutCurrentDriverFromFleet();
        loginPage
                .logoutWait();
    }

    @Test(priority = 11, description = "Проверяем создание Овнера при отмене Privacy Policy")
    public void test_Privacy_Policy_new_OwnerOperator() throws InterruptedException {
        //--------------------------------------*
        CheckRegFields check = new CheckRegFields();
        Credentials cred = new Credentials();
        RegistrationPage regPage = new RegistrationPage();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        //--------------------------------------*

        String login = cred.fleetDataND().EMAIL;
        String pass = cred.fleetDataND().REGPASSWORD;

        //--------------------------------------*
        /**
         * Открываем страницу регистрации пользователя, выбираем тип Fleet (Driver).
         * Заполняем обязательные поля для регистрации.
         * Пытаемся сохранить пользователя, ожидаем успешное отображение Privacy Policy.
         * При успешном отображении Privacy Policy отменяем подтверждение PP.
         * Возвращаемся на страницу авторизации, пытаемся авторизовать пользователя которого пытались зарегистрировать.
         * Ожидаем отображение ошибки, говорящей о том что данный пользователь отсутствует в системе (Некорректно введен логин или пароль).
         */
        check
                .goToReg();
        check
                .chooseOwner();
        regPage
                .fleetDriverReg(cred.fleetDataND().COMPANYNAME, cred.fleetDataND().USDOT, cred.fleetDataND().MCNUMBER,
                        cred.fleetDataND().FLEETNAME, cred.fleetDataND().FLEETLASTNAME, login,
                        pass, cred.fleetDataND().CONFPASSWORD, cred.driverData().LICENSE);
        regPage
                .nextPageButton();
        regPage
                .fleetNoDriverReg2(cred.fleetDataND().FLEETADRESS, cred.fleetDataND().CITYFIELD,
                        cred.fleetDataND().ZIPCODE, cred.fleetDataND().PHONENUMBER);
        regPage
                .saveBtn2()
                .cancelPrivacyPolicy();
        header
                .backMenu()
                .backMenu()
                .backMenu();
        loginPage
                .loginCurrentDr(login, pass)
                .invalidLogin();
    }

    @Test(priority = 12, description = "Проверяем отображение Privacy Policy у Водителя.")
    public void test_Privacy_Policy_new_Driver() throws InterruptedException {
        //--------------------------------------*
        Credentials cred = new Credentials();
        RegistrationPage regPage = new RegistrationPage();
        LoginPage loginPage = new LoginPage();
        Header header = new Header();
        //--------------------------------------*

        String login = cred.fleetDataND().EMAIL;
        String pass = cred.fleetDataND().REGPASSWORD;

        //--------------------------------------*
        /**
         * Открываем страницу регистрации пользователя, выбираем тип Driver.
         * Заполняем обязательные поля для регистрации.
         * Пытаемся сохранить пользователя, ожидаем успешное отображение Privacy Policy.
         * При успешном отображении Privacy Policy отменяем подтверждение PP.
         * Возвращаемся на страницу авторизации, пытаемся авторизовать пользователя которого пытались зарегистрировать.
         * Ожидаем отображение ошибки, говорящей о том что данный пользователь отсутствует в системе (Некорректно введен логин или пароль).
         */
        regPage.goToDriverRegistration();
        regPage
                .sendTextInRegisterField(cred.driverData().ORGPIN, cred.driverData().FIRSTNAME,
                        cred.driverData().LASTNAME, login, pass,
                        cred.driverData().CONFPASSWORD, cred.driverData().LICENSE);
        regPage
                .saveBtn()
                .cancelPrivacyPolicy();
        header
                .backMenu()
                .backMenu();
        loginPage
                .loginCurrentDr(login, pass)
                .invalidLogin();
    }
}