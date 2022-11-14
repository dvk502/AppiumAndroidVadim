package logic.init;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

public class WiFiConnection extends BasePage {
    protected static final Logger log = Logger.getLogger(WiFiConnection.class);

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Wi-Fi,Включено,TrackEnsureCAP2G,Кнопка\"]/android.widget.ImageView")
    public MobileElement enabledWifi;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Wi-Fi,Отключено,,Кнопка\"]/android.widget.ImageView")
    public MobileElement disabledWifi;

    public void closeNotification() {

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    @Step("Disable WiFi to check the creation of events")
    public WiFiConnection wifiDisable() {
        log.info("Opening the quick access curtain");
        driver.openNotifications();
        if (isElementPresent(2, enabledWifi)) {
            log.info("WiFi module is on. Turn off.");
            driver.toggleWifi();
            log.info("WiFi module is off.");
            closeNotification();
        } else {
            log.info("WiFi module disabled.");
            closeNotification();
        }
        return this;
    }

    @Step("Turn on the WiFi module")
    public WiFiConnection wifiEnable() {
        log.info("Opening the quick access curtain");
        driver.openNotifications();
        if (!isElementPresent(2, enabledWifi)) {
            log.info("WiFi module is disabled. Turn on");
            disabledWifi.click();
            log.info("WiFi module enabled.");
            closeNotification();
        } else {
            log.info("WiFi module enabled.");
            closeNotification();
        }
        return this;
    }
}
