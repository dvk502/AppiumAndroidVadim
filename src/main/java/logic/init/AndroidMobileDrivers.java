package logic.init;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidMobileDrivers{

    /**
     * Инициализация параметра driver, который будет заполнен данными тестируемого устройства в начале теста.
     */
    public static AndroidDriver<MobileElement> driver = null;

    /**
     * Получение драйвера тестируемого устройства
     * Если драйвер пустой, выполняем метод заполнения драйвера
     * Если драйвер заполнен, возвращаем текущее значение драйвера.
     */
    public static AndroidDriver<MobileElement> getDriver() {
        if(driver!=null) return driver;
        return getMobileDriver();
    }

    /**
     * Метод заполнения драйвера тестируемого устройства.
     * Параметры caps - Device Capability, данные об устройстве, на котором будет проведены тесты.
     * switch (projectName) - параметр который принимает значение из класса BasePage, для установки локатора выбранного проекта.
     */
    private static AndroidDriver<MobileElement> getMobileDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "Samsung Tab");
        caps.setCapability("appium:platformName", "Android");
        caps.setCapability("appium:automationName", "uiautomator2");
        caps.setCapability("appium:platformVersion", "11");
        caps.setCapability("appium:noReset", "false");
//        caps.setCapability("app", "/home/hazexp/IdeaProjects/Appium/TrackEnsure.apk"); - если хотим устанавливать перед прогоном тестов...
        switch (BasePage.projectName) {
            case "TE":
                caps.setCapability("appium:appPackage", "com.trackensure.eld.debug");
                break;
            case "Alfa":
                caps.setCapability("appium:appPackage", "org.alfa.eld");
                break;
            case "Vista":
                caps.setCapability("appium:appPackage", "org.vista.eld");
                break;
            case "Swift":
                caps.setCapability("appium:appPackage", "org.swift.eld");
                break;
            case "Smart":
                caps.setCapability("appium:appPackage", "org.smart.eld");
                break;
            case "Trendy":
                caps.setCapability("appium:appPackage", "org.trendy.eld");
                break;
            case "Sharp":
                caps.setCapability("appium:appPackage", "org.sharp.eld");
                break;
        }
        caps.setCapability("appium:appActivity", "eld.trackensure.SplashScreenActivity");
        caps.setCapability("appium:appWaitActivity", "eld.trackensure.activityforms.authorization.LoginActivity");
        caps.setCapability("appium:autoGrantPermissions", "true");//Автоматическое предоставление прав приложению
        caps.setCapability("autoAcceptAlerts", "true");
        caps.setCapability("appium:udid", "R9WN51C01AJ");//Подключение к устройству
        caps.setCapability("appium:newCommandTimeout", "0");
        caps.setCapability("appium:skipDeviceInitialization", "true"/*"true"*/);
        caps.setCapability("appium:skipServerInstallation", "true"/*"true"*/);
        caps.setCapability("appium:disableWindowAnimation", "true");
        caps.setCapability("appium:skipUnlock", true);
        caps.setCapability("appium:enableMultiWindows", false);
        //caps.setCapability("remoteAppsCacheLimit", "10");
        //caps.setCapability("systemPort", "8210");
        //caps.setCapability("systemPort", PORT_);
        //Instantiate Appium Driver
        /**
         * Инициализация драйвера, подключение к узлу Appium Driver.
         */
        try {
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);//Создание подключения к серверу аппиума.
            //driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.8);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
