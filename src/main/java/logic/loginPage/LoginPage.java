package logic.loginPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

/*import logic.init.AppiumBaseTest;*/
import logic.init.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class LoginPage extends BasePage {
    protected static final Logger log = Logger.getLogger(LoginPage.class);

    CheckAlertConnection connection = new CheckAlertConnection();

    @AndroidFindBy(id = projectLocator + ":id/login_name")
    public MobileElement loginField;
    @AndroidFindBy(id = projectLocator + ":id/login_password")
    public MobileElement passField;
    @AndroidFindBy(id = projectLocator + ":id/login_button")
    public MobileElement loginButton;
    @AndroidFindBy(id = "android:id/button2")
    public MobileElement AndroidBtn;
    @AndroidFindBy(id = projectLocator + ":id/register_button")
    public MobileElement confirmButton;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_msg_message")
    public MobileElement alertMsg;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_left_button")
    public MobileElement chooseDriverFleetType;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_right_button")
    public MobileElement chooseFleetType;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_msg_ok")
    public MobileElement alertOk;
    @AndroidFindBy(id = projectLocator + ":id/server_input")
    public static MobileElement serverIp;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_accept")
    public static MobileElement acceptButton;


    @Step("Invalid Login or Password check after login.")
    public LoginPage invalidLogin() {
        waitToVisibilityOf(10, alertMsg);
        Assert.assertEquals(alertMsg.getText(), "Invalid Login or Password.");
        alertOk.click();
        return this;
    }

    public void setServerIp() {
        if (isElementPresent(5, serverIp)) {
            waitToVisibilityOf(5, serverIp);
            serverIp.sendKeys(BasePage.serverIp);
            acceptButton.click();
            log.info("Alert about Server IP has been displayed! Entering server ip: " + BasePage.serverIp);
        } else {
            log.info("Alert about server ip has not been displayed.");
        }
    }

    @Step("Login Current Driver.")
    public LoginPage loginCurrentDr(String login, String password) {
        //try {
        //waitToVisibilityOf(25, loginField);
        waitToBeClickable(25, loginField);
        implicityWait(25);
        loginField.sendKeys(login);
        implicityWait(0);
        waitToVisibilityOf(15, passField);
        waitToBeClickable(15, passField);
        if (!isElementPresent(2, passField)) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        passField.sendKeys(password);
        waitToVisibilityOf(15, loginButton);
        waitToBeClickable(15, loginButton);
        loginButton.click();
        log.info("Login Current Driver: Login - " + login + ", Pass:" + password + "");
        /*} catch (Exception e) {
            log.info("CanaryLeak is displayed.");
            loginCurrentDr(login, password);
        }*/
        return this;
    }

    @Step("Choose user type Fleet on Login Page.")
    public LoginPage chooseTypeFleet(String driverType) {
        switch (driverType) {
            case ("Driver"):
                waitToBeClickable(5, chooseDriverFleetType);
                chooseDriverFleetType.click();
                log.info("Choosing Driver Type Fleet manager.");
                break;
            case ("Fleet"):
                waitToBeClickable(5, chooseFleetType);
                chooseFleetType.click();
                log.info("Choosing Fleet manager type.");
                break;
        }
        return this;
    }


    @Step("Login Current Driver.")
    public LoginPage loginCurrentDrT() {
        waitToVisibilityOf(10, loginButton);
        waitToBeClickable(10, loginButton);
        loginButton.click();
        log.info("Login Current Driver");
        return this;
    }

    public LoginPage checkWifiConnected() {
        if (isElementPresent(1, alertMsg) && alertMsg.getText().equals("Failed to connect to /10.10.1.93:8080")) {
            waitToVisibilityOf(10, connection.alertOk);
            waitToBeClickable(10, connection.alertOk);
            connection.alertOk.click();
            waitToVisibilityOf(10, loginButton);
            waitToBeClickable(10, loginButton);
            loginButton.click();
            log.info("Waiting Wi-Fi Connecting.");
            return checkWifiConnected();
        } else {
            log.info("Wi-Fi Connected!");
            return this;
        }
    }

    @Step("Wait logout driver after test / The End...")
    public LoginPage logoutWait() {
        log.info("Waiting logout from driver!");
        waitToVisibilityOf(50, loginField);
        loginField.isDisplayed();
        return this;
    }

    public LoginPage resetApp() {
        driver.resetApp();
        return this;
    }
}
