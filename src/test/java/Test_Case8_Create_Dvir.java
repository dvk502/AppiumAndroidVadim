import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import logic.dbConnection.SqlRequests;
import logic.hos.dvirPage.AddInspectionReport;
import logic.hos.dvirPage.DvirPage;
import logic.hos.header.Header;
import logic.hos.logsPage.LogsPage;
import logic.hos.statusPage.StatusPage;
import logic.init.*;
import logic.loginPage.LoginPage;
import logic.mainMenu.MainMenuDriver;
import logic.web.Customers;
import logic.web.LoginPageWeb;
import logic.web.MainPageOrganization;
import logic.web.MainScreen;
import logic.web.companyProfile.Drivers;
import logic.web.companyProfile.HosPage;
import logic.web.companyProfile.IRPage;
import logic.web.companyProfile.Options;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

@Listeners(UniversalVideoListener.class)
public class Test_Case8_Create_Dvir extends BasePage {
    @BeforeClass
    public void beforeClass(ITestContext context) {
        /*log.info("Get android driver.");
        context.setAttribute("driver", AndroidMobileDrivers.getDriver());*/
    }

    @AfterMethod
    public void checkIfAllCheckboxTurnedOn() {
        if (myWebDriver != null) {
            try {
            Options webOptions = new Options();
            webOptions
                    .checkIfWeInSettings()
                    .turnOnShowDvirInMainMenu()
                    .saveChangesOptions();
            } catch (Exception e) {
                log.info(":C");
            }
        }
    }

    String myWebDriver;

    @Test(description = "Проверка Location Description при создании PTI")
    //@Video(name = "CheckLocationDescription")
    /** Number 1
     * Проверка Location Description при создании PTI:
     *
     * Ввести несколько символов в поле Location Description, выбрать из всплывающего списка-подсказки нужный город.
     */
    public void test_DVIR1() throws Exception {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        DvirPage dvir = new DvirPage();
        AddInspectionReport addIR = new AddInspectionReport();
        MainMenuDriver menu = new MainMenuDriver();
        LogsPage logs = new LogsPage();
        LoginPageWeb webLogin = new LoginPageWeb();
        MainPageOrganization webMainPageOrg = new MainPageOrganization();
        Customers webCustomers = new Customers();
        MainScreen webMainScreen = new MainScreen();
        Options options = new Options();
        //--------------------------------------
        myWebDriver = "1";
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
                .turnOffShowDvirInMainMenu()
                .saveChangesOptions();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .dvirDisplayedHeadMenu(false);
        options
                .turnOnShowDvirInMainMenu()
                .saveChangesOptions();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait()
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .dvirDisplayedHeadMenu(true)
                .dvirOpen();
        dvir
                .createIR();
        addIR
                .checkLocation("kansas");
        header
                .backMenu()
                .openMenu();
        menu
                .openDvir();
        /*dvir
                .createIR();
        addIR
                .setCurrentDate()
                .inputDataIR("Firstevent", "5000", "Test")
                .onDutySkip(false);
        dvir
                .setCurrentDate()
                .findCreatedIR();
        header
                .backMenu()
                .logsOpen();
        logs
                .searchCreatedIR()
                .onDutyShouldBeDisplayedInLogs(true)
                .deleteEvent(true);
        header
                .openMenu();
        menu
                .openDvir();
        dvir
                .deleteIRForText("Firstevent")*/
        dvir
                .createIR();
        addIR
                .setCurrentDate()
                .checkRequiredFields("Kansas", "5000", "Test", "Test", "test");
        header
                .backMenu()
                .backMenu()
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }

    @Test(description = "На текущий момент создать Sleeper Berth Event без Trailer Number.")
    //@Video(name = "IRWithoutTrailerNo&Lic")
    /** Number 2
     * На текущий момент создать Sleeper Berth Event без Trailer Number.
     * - перейти во вкладку DVIR и создать PTI для Truck# и Trailer#.
     * На текущий момент создать Off Duty Event с Trailer Number 001 не заполняя поля Оdometer и License.
     * - перейти во вкладку DVIR и создать PTI для Truck# и Trailer#.
     */
    public void test_DVIR2() throws Exception {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        DvirPage dvir = new DvirPage();
        AddInspectionReport addIR = new AddInspectionReport();
        MainMenuDriver menu = new MainMenuDriver();
        LogsPage logs = new LogsPage();
        SqlRequests sql = new SqlRequests();
        //--------------------------------------
        myWebDriver = null;
        sql.deleteEvents(92807);
        sql.deleteIR(92807);
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn()
                .createWheelEvent(true,"sleep", "TestCity", "", "", "", false, true, true);
        header
                .dvirOpen();
        Thread.sleep(60000);
        dvir
                .createIR();
        addIR
                .setCurrentDate()
                .inputIRwithoutLocation("50")
                .checkAlertIr("trailernumber");
        header
                .backMenu()
                .statusOpen();
        statusPage
                .createWheelEvent(false,"off", "TestCity", "TestTr", "", "TestShipping", false, true, false);
        header
                .dvirOpen();
        log.info("Waiting 1 minute!!!");
        Thread.sleep(60000);
        dvir
                .createIR();
        addIR
                .setCurrentDate()
                .inputIRwithoutLocation("50")
                .onDutySkip(false,true, true);
        header
                .backMenu()
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }

    @Test(description = "Добавление PTI через вкладку DVIR(заполнив все обязательные поля).")
    //@Video(name = "CheckCreatingPTI")
    /** Number 3
     * "Добавление PTI через вкладку DVIR(заполнив все обязательные поля).
     *
     * Ввести информацию во все обязательные к заполнению поля, попытаться сохранить отчет;"
     */
    public void test_DVIR3() throws Exception {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        DvirPage dvir = new DvirPage();
        AddInspectionReport addIR = new AddInspectionReport();
        MainMenuDriver menu = new MainMenuDriver();
        LogsPage logs = new LogsPage();
        SqlRequests sql = new SqlRequests();
        //--------------------------------------
        myWebDriver = null;
        sql.deleteEvents(92807);
        sql.deleteIR(92807);;
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .dvirOpen();
        dvir
                .createIR();
        addIR
                .setCurrentDate()
                .inputDataIR("Firstevent", "5000", "Test")
                .onDutySkip(true,false, true);
        dvir
                .setCurrentDate()
                .findCreatedIR();
        header
                //.backMenu()
                .logsOpen();
        logs
                .searchCreatedIR(true)
                .onDutyShouldBeDisplayedInLogs(true);
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }

    @Test(description = "Creating PTI without OnDuty in first case, and with OnDuty in second case.")
    //@Video(name = "CheckCreatingOnDutyWithPTI")
    /** Number 4
     * "Создать Sleeper Berth Event.
     * Произвести повторное добавление PTI через вкладку DVIR.
     */
    public void test_DVIR4() throws Exception {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        DvirPage dvir = new DvirPage();
        AddInspectionReport addIR = new AddInspectionReport();
        MainMenuDriver menu = new MainMenuDriver();
        LogsPage logs = new LogsPage();
        SqlRequests sql = new SqlRequests();
        //--------------------------------------
        myWebDriver = null;
        sql.deleteEvents(92807);
        sql.deleteIR(92807);
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
//        header
//                .dvirOpen();
//        dvir
//                .deleteIRForText("Firstevent");
//        header
//                .backMenu()
//                .statusOpen();
        statusPage
                .createWheelEvent(true,"sleep", "Monaco", "Toyota", "Crown or", "Mark2", false, false, false);
        header
                .dvirOpen();
        Thread.sleep(60000);
        dvir
                .createIR();
        addIR
                .setCurrentDate()
                .inputIRwithoutLocation("500")
                .onDutySkip(false,true, false);
        header
                .backMenu()
                .logsOpen();
        logs
                .searchCreatedIR(false)
                .onDutyShouldBeDisplayedInLogs(false);
        header
                .dvirOpen();
        Thread.sleep(30000);
        dvir
                .createIR();
        addIR
                .setCurrentDate()
                .inputIRwithoutLocation("500")
                .onDutySkip(false,false, false);
        dvir
                .setCurrentDate()
                .findCreatedIR();
        header
                .logsOpen();
        logs
                .searchCreatedIR(true)
                .onDutyShouldBeDisplayedInLogs(true);
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }

    @Test(description = "Creating PTI between 2 events (OnDuty and Sleep")
    //@Video(name = "CreatePTIBetweenEvents")
    /** Number 5
     * Создать два ручных ивента OFF -> SB продолжительностью пару минут.
     * - Между ивентами OFF - SB создать PTI.
     */
    public void test_DVIR5() throws Exception {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        DvirPage dvir = new DvirPage();
        AddInspectionReport addIR = new AddInspectionReport();
        DateUtil date = new DateUtil();
        //--------------------------------------
        myWebDriver = null;
        usingWeb = false;
        SqlRequests.deleteEvents(92807);
        SqlRequests.deleteIR(92807);
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
        SqlRequests.addEvent("On-Duty", 92807, 5891, 1, 2, 1, 4, date.getDeltaEventMinute(null, -30), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", SqlRequests.nextSequence + 1, 309473, "Nikolaev");
        SqlRequests.addEvent("Off-Duty", 92807, 5891, 1, 2, 1, 1, date.getDeltaEventMinute(null, -15), "4fe54670b860ae64", "Test3", "20000", "", "", SqlRequests.nextSequence+2, 309473, "Nikolaev");
        SqlRequests.addEvent("Sleeping Berth", 92807, 5891, 1, 2, 1, 2, date.getDeltaEventMinute(null, -5)/*+" 21:00:00"*/, "4fe54670b860ae64", "Nikolaev, AL, US", "0", "", "lastEvent", SqlRequests.nextSequence+3, 309473, "Nikolaev");
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .dvirOpen();
        dvir
                .createIR();
        addIR
                .setCurrentTimeWithDeltaMinute(date.getDeltaEventMinuteForIR(null, -8), "5")
                .openTrailerWindow()
                .changeTrailerLicenseIr("Trailer1", "License1")
                .closeTrailerChangeWindow()
                .inputIRwithoutLocation("500")
                .onDutySkip(true,false, false);
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();

    }

    @Test(description = "Creating PTI on Driving.")
    /** Number 6
     * "Для теста необходим водитель с имеющимся AUTO Driving Event продолжительностью 10 минут.
     * Создайте PTI с On Duty Event и установите ему время, которое будет совпадать с временем Автоматического драйвинга (середина драйвинга)."
     */
    public void test_DVIR6() throws Exception {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        DvirPage dvir = new DvirPage();
        MainMenuDriver menu = new MainMenuDriver();
        DateUtil date = new DateUtil();
        //--------------------------------------
        myWebDriver = null;
        SqlRequests.deleteEvents(92807);
        SqlRequests.deleteIR(92807);
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
        SqlRequests.addEvent("Driving", 92807, 5891, 1, 1, 1, 3, date.getDeltaEventMinute(null, -10), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", SqlRequests.nextSequence + 1, 309473, "Nikolaev");
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .openMenu();
        menu
                .openDvir();
        dvir
                .checkAlertAutoDriving();
        header
                .logoutCurrentDriverDrivingEvent("Nikolaev", false);
        loginPage
                .logoutWait();
    }

    @Test(description = "Creating PTI between YM and Clear, and between On-Duty and YM.")
    /** Number 7
     * "Предварительно у водителя должен быть On Duty >> YM >> CLEAR созданный на сегодня (или предыдущие дни):
     * 1. Добавляем PTI через вкладку DVIR на сегодня выбирая промежуток времени  между YM and CLEAR.
     *
     * 2. Добавляем PTI через вкладку DVIR на промежуток времени между On Duty and YM. "
     */
    public void test_DVIR7() throws Exception {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        DvirPage dvir = new DvirPage();
        AddInspectionReport addIR = new AddInspectionReport();
        MainMenuDriver menu = new MainMenuDriver();
        DateUtil date = new DateUtil();
        //--------------------------------------
        myWebDriver = null;
        SqlRequests.deleteEvents(92807);
        SqlRequests.deleteIR(92807);
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
        SqlRequests.addEvent("On-Duty", 92807, 5891, 1, 2, 1, 4, date.getDeltaEventMinute(null, -30), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", SqlRequests.nextSequence + 1, 309473, "Nikolaev");
        SqlRequests.addEvent("Yard Move", 92807, 5891, 1, 2, 3, 2, date.getDeltaEventMinute(null, -15), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", SqlRequests.nextSequence + 2, 309473, "Nikolaev");
        SqlRequests.addEvent("Clear", 92807, 5891, 1, 2, 3, 0, date.getDeltaEventMinute(null, -1), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", SqlRequests.nextSequence + 3, 309473, "Nikolaev");
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen()
                .openMenu();
        menu
                .openDvir();
        dvir
                .createIR();
        addIR
                .setCurrentDate()
                .setCurrentTimeWithDeltaMinute(date.getDeltaEventMinuteForIR(null, -10), "10")
                .inputDataIR("Firstevent", "5000", "Test")
                .checkErrorIR();
        header
                .backMenu();
        dvir
                .createIR();
        addIR
                .setCurrentDate()
                .setCurrentTimeWithDeltaMinute(date.getDeltaEventMinuteForIR(null, -20), "20")
                .inputDataIR("Firstevent", "5000", "Test");
        header
                .backMenu()
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }

    @Test(description = "Creating PTI between PC and Clear, between Off-Duty and PC.")
    /** Number 8
     * "Предварительно у водителя должен быть Off Duty >> PC >> CLEAR созданный на сегодня (или предыдущие дни):
     * 1. Добавляем PTI через вкладку DVIR на сегодня выбирая промежуток времени  между PC and CLEAR.
     *
     * 2. Добавляем PTI через вкладку DVIR на промежуток времени между Off Duty and PC.  "
     */
    public void test_DVIR8() throws Exception {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        DvirPage dvir = new DvirPage();
        AddInspectionReport addIR = new AddInspectionReport();
        MainMenuDriver menu = new MainMenuDriver();
        DateUtil date = new DateUtil();
        //--------------------------------------
        myWebDriver = null;
        SqlRequests.deleteEvents(92807);
        SqlRequests.deleteIR(92807);
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
        SqlRequests.addEvent("Off-Duty", 92807, 5891, 1, 2, 1, 1, date.getDeltaEventMinute(null, -30), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", SqlRequests.nextSequence + 1, 309473, "Nikolaev");
        SqlRequests.addEvent("Personal Use", 92807, 5891, 1, 2, 3, 1, date.getDeltaEventMinute(null, -15), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", SqlRequests.nextSequence + 2, 309473, "Nikolaev");
        SqlRequests.addEvent("Clear", 92807, 5891, 1, 2, 3, 0, date.getDeltaEventMinute(null, -1), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", SqlRequests.nextSequence + 3, 309473, "Nikolaev");
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen()
                .openMenu();
        menu
                .openDvir();
        dvir
                .createIR();
        addIR
                .setCurrentDate()
                .setCurrentTimeWithDeltaMinute(date.getDeltaEventMinuteForIR(null, -10), "10")
                .inputDataIR("Firstevent", "5000", "Test")
                .checkErrorIR();
        header
                .backMenu();
        dvir
                .createIR();
        addIR
                .setCurrentDate()
                .setCurrentTimeWithDeltaMinute(date.getDeltaEventMinuteForIR(null, -20), "20")
                .inputDataIR("Firstevent", "5000", "Test")
                .checkErrorIRBeetwen();
        header
                .backMenu()
                .backMenu()
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }

    @Test(description = "Creating PTI with Vehicle Defects")
    //@Video(name = "Creating_PTI_with_Vehicle_Defects.")
    /** Number 9
     * "Добавление Vehicle Defects при создании PTI:
     * - перейти во вкладку DVIR и создать IR (при создании выбрать Defects для грузовика и трейлера);
     * - на вебе перейти в Customers > Login As Organization > Drivers > View in New Window > Inspection Report и сверить данные."
     */
    public void test_DVIR9() throws Exception {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        DvirPage dvir = new DvirPage();
        AddInspectionReport addIR = new AddInspectionReport();
        MainMenuDriver menu = new MainMenuDriver();
        LoginPageWeb webLogin = new LoginPageWeb();
        MainPageOrganization webMainPageOrg = new MainPageOrganization();
        Customers webCustomers = new Customers();
        MainScreen webMainScreen = new MainScreen();
        Drivers webDrivers = new Drivers();
        HosPage hosPage = new HosPage();
        IRPage irPage = new IRPage();
        //--------------------------------------
        clearDB();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .openMenu();
        menu
                .openDvir();
        dvir
                .createIR();
        addIR
                .setCurrentDate()
                .changeLocationIr("Thirdevent")
                .openTrailerWindow()
                .changeTrailerLicenseIr("Test1", "Test2")
                .closeTrailerChangeWindow()
                //.changeTrailerLicenseIr("LicenseTest")
                .changeOdometerIr("50000")
                .openDefectsWindow() 
                .addAllDefects()
                .saveSelectedDefects()
                .saveChanges()
                .onDutySkip(true,false, true);
        dvir
                .openCreatedIr("Thirdevent");
        addIR
                .openDefectsWindow()
                .checkAllDefectsTurnedOn();
        header
                .backMenu()
                .backMenu();
        webLogin
                .loginOnWeb(cred.webAdmin().WEBLOGIN, cred.webAdmin().WEBPASS);
        webMainScreen
                .openCustomers();
        webCustomers
                .findOrganization(cred.myDriverName().DRIVERORG)
                .openTestCompany();
        webMainPageOrg
                .goToDriversPage();
        webDrivers
                .foundDriver(cred.myDriverName().MYDRIVERNAME, cred.myDriverName().MYDRIVERLASTNAME)
                .openHosPage();
        Thread.sleep(5000);
        hosPage
                .openDvirPage();
        irPage
                .openEditIr()
                .checkIfAllTruckCheckboxesActivated()
                .checkIfAllTrailerCheckboxesActivated()
                .saveIrDefects();
        dvir
                .openCreatedIr("Thirdevent");
        addIR
                .openDefectsWindow()
                .delAllDefects()
                .saveSelectedDefects()
                //.disableTrailer()
                .saveChanges();
        Thread.sleep(20000);
        webDriver.navigate().refresh();
        irPage
                .openEditIr()
                .checkIfAllTruckCheckboxesDeactivated()
                .checkIfAllTrailerCheckboxesDeactivated()
                .saveIrDefects();
        header
                .backMenu()
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
    }

    @Test(description = "Test")
    //@Video(name = "DVIR_3")
    public void test_DVIR10() throws Exception {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        DvirPage dvir = new DvirPage();
        AddInspectionReport addIR = new AddInspectionReport();
        MainMenuDriver menu = new MainMenuDriver();
        LoginPageWeb webLogin = new LoginPageWeb();
        MainPageOrganization webMainPageOrg = new MainPageOrganization();
        Customers webCustomers = new Customers();
        MainScreen webMainScreen = new MainScreen();
        Drivers webDrivers = new Drivers();
        HosPage hosPage = new HosPage();
        IRPage irPage = new IRPage();
        //--------------------------------------
        webLogin
                .loginOnWeb(cred.webAdmin().WEBLOGIN, cred.webAdmin().WEBPASS);
        webMainScreen
                .openCustomers();
        webCustomers
                .findOrganization(cred.myDriverName().DRIVERORG)
                .openTestCompany();
        webMainPageOrg
                .goToDriversPage();
        webDrivers
                .foundDriver(cred.myDriverName().MYDRIVERNAME, cred.myDriverName().MYDRIVERLASTNAME)
                .openHosPage();
        hosPage
                .openDvirPage();
        irPage
                .createNewIR("FourthEvent")
                .turnOnAllTruckCheckboxes()
                .turnOnAllTrailerCheckboxes()
                .saveIrDefects();
        Thread.sleep(5000);
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .openMenu();
        menu
                .openDvir();
        dvir
                .openCreatedIr("FourthEvent");
        addIR
                .openDefectsWindow()
                .checkAllDefectsTurnedOn();
        header
                .backMenu()
                .backMenu()
                .backMenu()
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
        irPage
                .openEditIr()
                .turnOffAllTruckCheckboxes()
                .turnOffAllTrailerCheckboxes()
                .saveIrDefects();
        loginPage
                .loginCurrentDr("statustest1", "test");
        statusPage
                .clickAndroidBtn();
        header
                .openMenu();
        menu
                .openDvir();
        dvir
                .openCreatedIr("FourthEvent");
        addIR
                .openDefectsWindow()
                .checkAllDefectsTurnedOff();
        header
                .backMenu()
                .backMenu()
                .backMenu()
                .logoutCurrentDriver(false);

    }

    @Test(description = "Test")
    //@Video(name = "DVIR_4")
    public void test_dvir7() throws Exception {
        //--------------------------------------
        LoginPage loginPage = new LoginPage();
        Credentials cred = new Credentials();
        StatusPage statusPage = new StatusPage();
        Header header = new Header();
        DvirPage dvir = new DvirPage();
        AddInspectionReport addIR = new AddInspectionReport();
        MainMenuDriver menu = new MainMenuDriver();
        SqlRequests sql = new SqlRequests();
        DateUtil date = new DateUtil();
        //--------------------------------------
        clearDB();
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
        SqlRequests.addEvent("Sleeping Berth", 92807, 5891, 1, 2, 1, 2, date.getDeltaEventMinute(null, -10), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", SqlRequests.nextSequence + 1, 309473, "Nikolaev");
        loginPage
                .loginCurrentDr("statustest1", "test");
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen()
                .openMenu();
        menu
                .openDvir();
        dvir
                .createIR();
        addIR
                .setCurrentDate()
                .inputDataIR("Firstevent", "5000", "Test")
                .onDutySkip(true,false, true);
        header
                .backMenu()
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
        SqlRequests.deleteIR(92807);
        SqlRequests.deleteEvents(92807);
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
        SqlRequests.addEvent("Off-Duty", 92807, 5891, 1, 2, 1, 1, date.getDeltaEventMinute(null, -30), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", SqlRequests.nextSequence + 1, 309473, "Nikolaev");
        loginPage
                .loginCurrentDr("statustest1", "test");
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen()
                .openMenu();
        menu
                .openDvir();
        dvir
                .createIR();
        addIR
                .setCurrentDate()
                .inputDataIR("Firstevent", "5000", "Test")
                .onDutySkip(true,false,  true);
        header
                .backMenu()
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
        SqlRequests.deleteIR(92807);
        SqlRequests.deleteEvents(92807);
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
        SqlRequests.addEvent("Driving", 92807, 5891, 1, 2, 1, 3, date.getDeltaEventMinute(null, -10), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", SqlRequests.nextSequence + 1, 309473, "Nikolaev");
        loginPage
                .loginCurrentDr("statustest1", "test");
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen()
                .openMenu();
        menu
                .openDvir();
        dvir
                .createIR();
        addIR
                .setCurrentDate()
                .inputDataIR("Firstevent", "5000", "Test")
                .onDutySkip(true,false, true);
        header
                .backMenu()
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
        SqlRequests.deleteIR(92807);
        SqlRequests.deleteEvents(92807);
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
        SqlRequests.addEvent("On-Duty", 92807, 5891, 1, 2, 1, 4, date.getDeltaEventMinute(null, -30), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", SqlRequests.nextSequence + 1, 309473, "Nikolaev");
        loginPage
                .loginCurrentDr("statustest1", "test");
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen()
                .openMenu();
        menu
                .openDvir();
        dvir
                .createIR();
        addIR
                .setCurrentDate()
                .inputDataIR("Firstevent", "5000", "Test");
        header
                .backMenu()
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
        SqlRequests.deleteIR(92807);
        SqlRequests.deleteEvents(88154);
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
        header
                .logoutCurrentDriver(false);
        loginPage
                .logoutWait();
        SqlRequests.takeLastEventSequence(88154);
        SqlRequests.addEvent("Driving", 88154, 5891, 1, 1, 1, 3, date.getDeltaEventMinute(null, -10), "4fe54670b860ae64", "Alabama, AL, US", "0", "", "", SqlRequests.nextSequence + 1, 309473, "Nikolaev");
        loginPage
                .loginCurrentDr("statustest1", "test");
        statusPage
                .clickAndroidBtn();
        header
                .logsOpen()
                .openMenu();
        menu
                .openDvir();
        dvir
                .checkAlertAutoDriving();
        header
                .logoutCurrentDriverDrivingEvent("Paris", false);
        loginPage
                .logoutWait();
    }
}
