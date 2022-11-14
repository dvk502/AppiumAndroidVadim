package logic.loginPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

import logic.init.BasePage;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class CheckAlertConnection extends BasePage {

    protected static final Logger log = Logger.getLogger(CheckAlertConnection.class);

    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_msg_message")
    public MobileElement alertConnection;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_msg_ok")
    public MobileElement alertOk;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Wi-Fi,Включено,TrackEnsureCAP2G,Кнопка\"]/android.widget.ImageView")
    public MobileElement enabledWifi;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Wi-Fi,Отключено,,Кнопка\"]/android.widget.ImageView")
    public MobileElement disabledWifi;

    /**
     * Проверка отображения алерта при авторизации пользователя с отключенным интернет соединением.
     * После появления алерта, происходит проверка текста внутри алерта.
     */
    public void checkAlertText() {
        waitToVisibilityOf(10, alertConnection);
        waitToBeClickable(10, alertConnection);
        Assert.assertEquals(alertConnection.getText(), "Failed to connect to /10.10.1.93:8080");
        log.info("Alert window about connection is appeared! Text in window: " +alertConnection.getText());
        alertOk.click();
    }

    public CheckAlertConnection checkAlertTextLogout() {
        waitToVisibilityOf(10, alertConnection);
        waitToBeClickable(10, alertConnection);
        Assert.assertEquals(alertConnection.getText(), "Logout is impossible. Please check internet connection");
        log.info("Alert window about connection is appeared! Text in window: " +alertConnection.getText());
        alertOk.click();
        return this;
    }

    public void toggleWifiSwitch() {

        driver.toggleWifi();
    }

    public void openNotification() {

        driver.openNotifications();
    }

    public void closeNotification() {

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public CheckAlertConnection checkStatusWifi() {
        openNotification();
        if (isElementPresent(2, enabledWifi)) {
            driver.toggleWifi();
            log.info("Wi-Fi is enabled at the moment. Disabling Wi-Fi module");
            closeNotification();
            return this;
        } else {
            log.info("Wi-Fi disabled!");
            closeNotification();
            return this;
        }
    }

        public CheckAlertConnection checkWiFiTurned () {
            openNotification();
            if (isElementPresent(1, enabledWifi)) {
                log.info("Wi-Fi is enabled at the moment.");
                closeNotification();
                return this;
            } if (isElementPresent(1, disabledWifi)) {
                driver.toggleWifi();
                log.info("Wi-Fi module is disabled at the moment. Enabling Wi-Fi module.");
                closeNotification();
                return checkWiFiTurned();
            }
            closeNotification();
            return checkWiFiTurned();
        }
    }