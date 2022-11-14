package logic.web.companyProfile;

import logic.init.BasePageWeb;
import logic.init.Credentials;
import logic.init.ListenersWeb;
import logic.web.Customers;
import logic.web.LoginPageWeb;
import logic.web.MainPageOrganization;
import logic.web.MainScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

@org.testng.annotations.Listeners(ListenersWeb.class)
public class Options extends BasePageWeb {
    protected static final Logger log = Logger.getLogger(Options.class);

    @FindBy(css = "input[ng-model=\"vm.OTS.options.UiAppShowDVIRInMainMenu.value\"]")
    public WebElement dvirInMainMenuCheckbox;
    @FindBy(css = "input[ng-model=\"vm.OTS.options.SysAllowAutoRecordFuelELDEvent.value\"]")
    public WebElement fuelEvent;
    @FindBy(xpath = "//div[@class='uiEldBlock ng-isolate-scope']/descendant::input[@value='Save']")
    public WebElement saveEldChanges;
    @FindBy(xpath = "//div[@class='sysEldBlock ng-isolate-scope']/descendant::input[@value='Save']")
    public WebElement savePopulationChanges;
    @FindBy(xpath = "//div[@class='sysFuelCardBlock ng-isolate-scope']/descendant::input[@value='Save']")
    public WebElement saveFuelChanges;
    @FindBy(css = "button[ng-click=\"vm.openModalAndLogout()\"]")
    public WebElement notLoginCompany;
    @FindBy(css = "a[ng-click=\"vm.activeTab = 'System Options'\"]")
    public WebElement systemTab;
    @FindBy(css = "input[ng-model=\"vm.OTS.options.SysAutomaticReplaceGpsProviderToTrackEnsureElogGps.value\"]")
    public WebElement test;
    @FindBy(css = "input[ng-model=\"vm.sysIgnoreMinPopulationValue.MINIMUM_POPULATION_SIZE\"]")
    public WebElement populationValue;

    public Options turnOnShowDvirInMainMenu() {
        clickCheckbox(dvirInMainMenuCheckbox, true, "Allow display DVIR Only in Main Menu");
        return this;
    }

    public Options turnOnFuelInMainMenu() {
        clickCheckbox(fuelEvent, true, "Allow display DVIR Only in Main Menu");
        return this;
    }

    public Options openSystemTab() {
        waitToVisibilityOf(5, systemTab);
        systemTab.click();
        return this;
    }

    public Options setPopulationValue(String value) {
        waitToVisibilityOf(5, populationValue);
        populationValue.clear();
        populationValue.sendKeys(value);
        log.info("Input population value: " + value);
        return this;
    }

    public Options savePopulationChanges() {
        waitToVisibilityOf(5, savePopulationChanges);
        savePopulationChanges.click();
        log.info("Save Population Changes.");
        return this;
    }

    public Options saveChangesFuel() {
//        waitToVisibilityOf(5, saveEldChanges);
        Actions actions = new Actions(driver);
        actions.moveToElement(test);
        actions.perform();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", saveFuelChanges);
        return this;
    }

    public Options turnOffShowDvirInMainMenu() {
        clickCheckbox(dvirInMainMenuCheckbox, false, "Allow display DVIR Only in Main Menu");
        return this;
    }

    public Options checkIfWeInSettings() {
        MainScreen webMainScreen = new MainScreen();
        LoginPageWeb webLogin = new LoginPageWeb();
        Customers webCustomers = new Customers();
        MainPageOrganization webMainPageOrg = new MainPageOrganization();
        Credentials cred = new Credentials();
        if(!isElementPresent(1, notLoginCompany)) {

            webLogin
                    .loginOnWeb(cred.webAdmin().WEBLOGIN, cred.webAdmin().WEBPASS);
            webMainScreen
                    .openCustomers();
            webCustomers
                    .findOrganization(cred.myDriverName().DRIVERORG)
                    .openTestCompany();
            webMainPageOrg
                    .goToOptionsPage();
        } else {
            driver.get("http://10.10.1.93:8080/TrackEnsure/fleet/manager/cpOptions/#/");
        }
        return this;
    }

    public Options saveChangesOptions() {
        waitToVisibilityOf(5, saveEldChanges);
        saveEldChanges.click();
        log.info("Save ELD Changes.");
        return this;
    }
}
