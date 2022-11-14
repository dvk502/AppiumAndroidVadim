import logic.hos.statusPage.StatusPage;

import logic.init.BasePage;
import logic.init.Credentials;
import logic.loginPage.LoginPage;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
public class TestShowPassword extends BasePage {

    protected static final Logger log = Logger.getLogger(TestShowPassword.class);

    @Test
    public void preference() throws Exception {
        LoginPage loginPage = new LoginPage();
        StatusPage statusPage = new StatusPage();
        Credentials cred = new Credentials();
        loginPage
                .loginCurrentDr(cred.driverCredentials().DRIVER_LOGIN,
                        cred.driverCredentials().DRIVER_PASSWORD);
        statusPage
                .clickAndroidBtn();
    }
}