package logic.init;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDriver {

    private static ThreadLocal<AndroidDriver> tlDriver = new ThreadLocal<AndroidDriver>();

    public synchronized void setTlDriver(AndroidDriver driver) {
        tlDriver.set(driver);
    }

    public static synchronized AndroidDriver getTlDriver() {
        return tlDriver.get();
    }
}
