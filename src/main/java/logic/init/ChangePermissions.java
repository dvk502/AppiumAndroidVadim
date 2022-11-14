package logic.init;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import logic.hos.header.Header;
import logic.hos.statusPage.StatusPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class ChangePermissions extends BasePage {
    protected static final Logger log = Logger.getLogger(ChangePermissions.class);

    //--------------------------------------*
    StatusPage status = new StatusPage();
    Header header = new Header();
    //--------------------------------------*

    /**
     * Метод отключает права на использование Камеры на устройстве для тестируемого приложения.
     */
    public ChangePermissions disableCamera() {
        Map<String, Object> removePicsCmd = ImmutableMap.of(
                "action", "revoke",
                "appPackage", projectLocator,
                "permissions", "android.permission.CAMERA"
        );
        driver.executeScript("mobile: changePermissions", removePicsCmd);
        log.info("Turn off Camera permission in app " + projectLocator);
        while (!isElementPresent(2, header.mainMenuBtn) && (!isElementPresent(2, StatusPage.windowAlertIfta))) {
            driver.activateApp(projectLocator);
            log.info("Re-open app " + projectLocator);
        }
        status.clickAndroidBtn();
        return this;
    }

    public ChangePermissions disableGpsPermission1() {
        Map<String, Object> removePicsCmd = ImmutableMap.of(
                "action", "revoke",
                "appPackage", projectLocator,
                "permissions", "android.permission.ACCESS_COARSE_LOCATION"
        );
        driver.executeScript("mobile: changePermissions", removePicsCmd);
        log.info("Turn off GPS permission in app " + projectLocator);
        while (!isElementPresent(2, header.mainMenuBtn)) {
            driver.activateApp(projectLocator);
            log.info("Re-open app " + projectLocator);
        }
        status.clickAndroidBtn();
        return this;
    }

    public ChangePermissions disableGpsPermission2() {
        Map<String, Object> removePicsCmd = ImmutableMap.of(
                "action", "revoke",
                "appPackage", projectLocator,
                "permissions", "android.permission.ACCESS_FINE_LOCATION"
        );
        driver.executeScript("mobile: changePermissions", removePicsCmd);
        log.info("Turn off GPS permission in app " + projectLocator);
        while (!isElementPresent(2, header.mainMenuBtn)) {
            driver.activateApp(projectLocator);
            log.info("Re-open app " + projectLocator);
        }
        status.clickAndroidBtn();
        return this;
    }

    /**
     * Метод запрещает запись и чтение из памяти устройства для тестируемого приложения.
     */
    public ChangePermissions disableWriteAndReadMemory() {
        Map<String, Object> writeMemoryCmd = ImmutableMap.of(
                "action", "revoke",
                "appPackage", projectLocator + "",
                "permissions", "android.permission.WRITE_EXTERNAL_STORAGE"
        );
        driver.executeScript("mobile: changePermissions", writeMemoryCmd);
        Map<String, Object> readMemoryCmd = ImmutableMap.of(
                "action", "revoke",
                "appPackage", projectLocator + "",
                "permissions", "android.permission.READ_EXTERNAL_STORAGE"
        );
        driver.executeScript("mobile: changePermissions", readMemoryCmd);
        log.info("Turn off Memory Write and Read permission in app com.trackensure.eld.debug");
        while (!isElementPresent(2, status.androidBtn)) {
            driver.activateApp(projectLocator + "");
            log.info("Re-open app com.trackensure.eld.debug");
        }
        status.clickAndroidBtn();
        return this;
    }

    /**
     * Метод разрешает чтение и запись в памяти устройства для тестируемого приложения.
     *
     */
    public void enableWriteAndReadMemory() throws Exception {
        Map<String, Object> writeMemoryCmd = ImmutableMap.of(
                "action", "grant",
                "appPackage", projectLocator + "",
                "permissions", "android.permission.WRITE_EXTERNAL_STORAGE"
        );
        driver.executeScript("mobile: changePermissions", writeMemoryCmd);
        Map<String, Object> readMemoryCmd = ImmutableMap.of(
                "action", "grant",
                "appPackage", projectLocator + "",
                "permissions", "android.permission.READ_EXTERNAL_STORAGE"
        );
        driver.executeScript("mobile: changePermissions", readMemoryCmd);
        log.info("Turn off Memory Write and Read permission in app com.trackensure.eld.debug");
        while (!isElementPresent(2, status.androidBtn)) {
            driver.activateApp(projectLocator + "");
            log.info("Re-open app com.trackensure.eld.debug");
        }
        status.clickAndroidBtn();

    }

    /**
     * Метод разрешает использование камеры на устройстве для тестируемого приложения.
     */
    public void enableCamera() {
        Map<String, Object> removePicsCmd = ImmutableMap.of(
                "action", "grant",
                "appPackage", projectLocator + "",
                "permissions", "android.permission.CAMERA"
        );
        driver.executeScript("mobile: changePermissions", removePicsCmd);
        log.info("Turn on Camera permission in app com.trackensure.eld.debug");
    }

}
