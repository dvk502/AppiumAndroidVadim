package logic.init;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ChromeWebDriver {

    /**
     * Инициализация web драйвера.
     */
    public static WebDriver driver = null;

    /**
     * Заполнение драйвера Web.
     * @return
     */
    public static WebDriver getWebDriver() {
        if (driver != null) return driver;
        return getDriver();
    }

    /**
     * Метод вызывается в случае если при вызове веб драйвера, он оказался пустым.
     * Веб драйвер создается с указанными ниже параметрами.
     * @return
     */
    private static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080"); /* open Browser in maximized mode */
        //options.addArguments("--headless"); /* Использовать headless мод для тестирования в Jenkins */
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "normal");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(400, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        driver.manage().window().setPosition(new Point(-8, 0));
//        driver.manage().window().setSize(new Dimension(1936,1088));
        driver.get(BasePage.webAddress);
        return driver;
    }
}

