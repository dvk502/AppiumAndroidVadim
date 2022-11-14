import logic.dbConnection.SqlRequests;
import logic.hos.header.Header;
import logic.hos.statusPage.StatusPage;
import logic.hos.truckPage.TruckConnect;

import logic.init.BasePage;
import logic.init.Credentials;
import logic.init.ImageSelector;
import logic.loginPage.LoginPage;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class TestTruckConnected extends BasePage {

    @BeforeClass
    public void beforeClass (ITestContext context) {
        /*context.setAttribute("driver", AndroidMobileDrivers.getDriver());*/
    }


    Credentials cred = new Credentials();
    Header header = new Header();
    LoginPage loginPage = new LoginPage();
    StatusPage statusPage = new StatusPage();
    TruckConnect truckConnect = new TruckConnect();
    ImageSelector imgFind = new ImageSelector();
    SqlRequests sql = new SqlRequests();

    @Test(description = "Проверяем подключение к траку.")
    public void test_Truck_Connected() throws IOException, InterruptedException {
        loginPage.loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,cred.driverCredentials().DRIVER_PASSWORD);
        statusPage.clickAndroidBtn();
        header.pressTruckIcon();
        truckConnect
                .chooseTruck()
                .connectTruck();
        imgFind.checkTruckConnected();
        header
                .confirmBtn()
                .logoutCurrentDriver(false);
        loginPage.logoutWait();
    }
}

