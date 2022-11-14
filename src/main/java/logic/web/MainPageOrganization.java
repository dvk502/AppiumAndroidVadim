package logic.web;

import logic.init.BasePage;
import logic.init.BasePageWeb;
import logic.init.ChromeWebDriver;
import logic.init.ListenersWeb;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@org.testng.annotations.Listeners(ListenersWeb.class)
public class MainPageOrganization extends BasePageWeb{
    protected static final Logger log = Logger.getLogger(MainPageOrganization.class);

    @FindBy(css = "i[class = 'fa fa-fw fa-xl fa-cogs'")
    private WebElement companyProfileBar;
    @FindBy(css = "div[id=\"company-profile-dropdown-content\"")
    private WebElement driversButton;

    public MainPageOrganization navigateToCompanyProfile(String goTo) {
        waitToBeClickable(20, companyProfileBar);
         Actions action = new Actions(driver);
        int x = companyProfileBar.getLocation().getX();
        int y = companyProfileBar.getLocation().getY();
        action.moveByOffset(x, y);
        action.perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement cp = driver.findElement(By.xpath("//a[contains(text(),'" + goTo + "')]"));
        cp.click();
        return this;
    }

    public MainPageOrganization goToDriversPage() {
//        navigateToCompanyProfile("Drivers");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get(BasePage.webAddress + "/fleet/manager/cpDrivers/#/");
        return this;
    }

    public MainPageOrganization goToOptionsPage() {
//        navigateToCompanyProfile("Options");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get("http://10.10.1.93:8080/TrackEnsure/fleet/manager/cpOptions/");
        return this;
    }

    public MainPageOrganization goToGeneralPage() {
//        navigateToCompanyProfile("General");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get("http://10.10.1.93:8080/TrackEnsure/fleet/manager/cpGeneral/#/");
        return this;
    }
    public MainPageOrganization goToAssetsPage() {
//        navigateToCompanyProfile("Assets");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get("http://10.10.1.93:8080/TrackEnsure/fleet/manager/cpAssets/#/");
        return this;
    }
}
