/*
package logic.init;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBaseTest {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    private final ThreadLocalDriver threadLocalDriver = new ThreadLocalDriver();



    @BeforeMethod
    @Parameters({"deviceName", "platformVersion", "udid"})
    public synchronized AndroidDriver<MobileElement> setup(String deviceName, String platformVersion, String udid) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        */
/*switch (projectName) {
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
        }*//*

        caps.setCapability("appium:appPackage", "com.trackensure.eld.debug");
        caps.setCapability("appium:deviceName", deviceName);
        caps.setCapability("appium:udid", udid);
        caps.setCapability("appium:platformVersion", platformVersion);
        caps.setCapability("appium:platformName", "Android");
        caps.setCapability("appium:automationName", "uiautomator2");
        caps.setCapability("appium:appActivity", "eld.trackensure.SplashScreenActivity");
        caps.setCapability("appium:appWaitActivity", "eld.trackensure.activityforms.authorization.LoginActivity");
        caps.setCapability("appium:skipUnlock", "true");
        caps.setCapability("appium:noReset", "false");
        caps.setCapability("appium:newCommandTimeout", "60");
        caps.setCapability("appium:autoGrantPermissions", "true");//Автоматическое предоставление прав приложению
        caps.setCapability("appium:element-wait", 20);
        //Instantiate Appium Driver
        threadLocalDriver.setTlDriver(new AndroidDriver<MobileElement>(new URL("http://localhost:4445/wd/hub"), caps));
        this.driver = threadLocalDriver.getTlDriver();
        System.out.println("Get threadLocalDriver");
        //wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this.driver);
        return driver;
    }

    @AfterMethod
    public synchronized void teardown() {
        driver.quit();
    }
}
*/
