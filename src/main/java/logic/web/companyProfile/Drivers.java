package logic.web.companyProfile;

import logic.init.BasePageWeb;
import logic.init.ListenersWeb;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@org.testng.annotations.Listeners(ListenersWeb.class)
public class Drivers extends BasePageWeb{
    protected static final Logger log = Logger.getLogger(Drivers.class);

    @FindBy(css = "input[ng-model='vm.filter.firstName']")
    private WebElement nameField;
    @FindBy(css = "input[ng-model='vm.filter.lastName']")
    private WebElement lastNameField;
    @FindBy(css = "input[ng-model='vm.filter.loginName']")
    private WebElement loginField;
    @FindBy(css = "a[class ='c-p ng-binding']")
    private WebElement firstNameFieldDriver;
    @FindBy(css = "a[is-permitted-for=\"update.DRIVER-PROFILE\"]")
    private WebElement openSettingsDriver;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/form/div[1]/div[28]/div[1]/div/label/input")
    private WebElement onlyUsaCheckbox;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/form/div[2]/button[1]")
    private WebElement saveButton;
    @FindBy(css = "i[is-permitted-for=\"!read.HOS-DAY-VERIFY\"]")
    private WebElement openHos;
    @FindBy(css = "input[ng-model=\"vm.driver.allowDeleteEvents\"]")
    private WebElement allowDeleteEventsCheckbox;
    @FindBy(css = "input[ng-model=\"vm.driver.allowInsertEvents\"]")
    private WebElement allowInsertEventsCheckbox;
    @FindBy(css = "input[ng-model=\"vm.driver.allowEditEvents\"]")
    private WebElement allowEditEventsCheckbox;
    @FindBy(css = "input[ng-model=\"vm.driver.allowDrivingEvents\"]")
    private WebElement allowDrivingEventsCheckbox;
    @FindBy(css = "input[ng-model=\"vm.driver.allowDrivingEvents\"][class=\"ng-pristine ng-valid ng-empty ng-touched\"]")
    private WebElement emptyCheckBoxDriving;
    @FindBy(css = "input[ng-model=\"vm.driver.allowEditEvents\"][class=\"ng-pristine ng-valid ng-empty ng-touched\"]")
    private WebElement emptyCheckBoxEdit;
    @FindBy(css = "input[ng-model=\"vm.driver.allowInsertEvents\"][class=\"ng-pristine ng-valid ng-empty ng-touched\"]")
    private WebElement emptyCheckBoxInsert;
    @FindBy(css = "input[ng-model='vm.driver.allowDeleteEvents'][class='ng-pristine ng-valid ng-not-empty ng-touched']")
    private WebElement emptyCheckBoxDelete;
    @FindBy(css = "div[ng-model=\"vm.driver.homeTerminalTimezone\"]")
    private WebElement homeTerminalZone;
    @FindBy(css = "input[ng-model=\"vm.driver.firstName\"]")
    private WebElement nameDriver;
    @FindBy(css = "input[ng-model=\"vm.driver.lastName\"]")
    private WebElement lastNameDriver;
    @FindBy(css = "input[ng-model=\"vm.driver.licenseNumber\"]")
    private WebElement licenseDriver;
    @FindBy(css = "div[ng-model=\"vm.driver.licenseState\"]")
    private WebElement licenseState;
    @FindBy(id = "checkbox")
    private WebElement activeDriver;
    @FindBy(css = "a[ng-click=\"grid.appScope.vm.addNewDriver(row.entity.driverId)\"]")
    private WebElement firstNameDriverInColumn;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[1]/div/div/div[1]/company-profile/div/div[2]/div/div/div[2]/div[1]/div[3]/div/div/div/div[1]/div[3]/div[2]/div/div/div/div/div[2]/div")
    private WebElement lastNameDriverInColumn;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div")
    private WebElement driverStatusMessage;
    @FindBy(css = "button[ng-click=\"vm.successCallback()\"]")
    private WebElement acceptButtonChangeStatus;
    @FindBy(css = "div[ng-model=\"vm.filter.status\"]")
    private WebElement changeFilterStatus;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[1]/div/div/div[1]/company-profile/div/div[2]/div/div/div[2]/div[1]/div[1]/div[5]/div/ul[1]/li/div[3]/a/div")
    private WebElement activeStatus;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[1]/div/div/div[1]/company-profile/div/div[2]/div/div/div[2]/div[1]/div[1]/div[5]/div/ul[1]/li/div[4]/a/div")
    private WebElement inactiveStatus;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[1]/div/div/div[1]/company-profile/div/div[2]/div/div/div[2]/div[1]/div[1]/div[5]/div/ul[1]/li/div[5]/a/div")
    private WebElement unavailableStatus;
    @FindBy(css = "div[ng-model=\"vm.driver.status\"]")
    private WebElement changeDriverStatusInSettings;
    @FindBy(id = "ui-select-choices-row-5-2")
    private WebElement unavailableStatusInSettings;
    @FindBy(id = "ui-select-choices-row-5-1")
    private WebElement inactiveStatusInSettings;
    @FindBy(id = "ui-select-choices-row-5-0")
    private WebElement activeStatusInSettings;


    //--------------------------------------------------------- Checkbox

    public Drivers turnOnlyUsa() {
        clickCheckbox(onlyUsaCheckbox, true, "Only USA");
        return this;
    }

    public Drivers disableOnlyUsa() {
        clickCheckbox(onlyUsaCheckbox, false, "Only USA");
        return this;
    }

    public boolean checkStatusOnlyUSA() {
        if (onlyUsaCheckbox.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkStatusCheckbox() {
        waitToVisibilityOf(5, activeDriver);
        if (activeDriver.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public Drivers checkStatusDriver() {
        waitToVisibilityOf(5, activeDriver);
        if (activeDriver.isSelected()) {
            log.info("Status Driver Active");
        } else {
            log.info("Status Driver Inactive ");
        }
        return this;
    }

    public Drivers changeStatusDriverToActive() {
        if (activeDriver.isSelected()) {
            log.info("Status Driver hasn't been changed cause actually status = Active");
        } else {
            ((JavascriptExecutor)driver).executeScript(("arguments[0].click();"), activeDriver);
            //activeDriver.click();
            log.info("Driver Status has been changed to Active.");
        }
        return this;
    }

    public Drivers changeStatusDriverToUnavailableInSettings() {
        waitToVisibilityOf(5, changeDriverStatusInSettings);
        changeDriverStatusInSettings.click();
        waitToVisibilityOf(5, unavailableStatusInSettings);
        unavailableStatusInSettings.click();
        return this;
    }

    public Drivers changeStatusDriverToActiveInSettings() {
        waitToVisibilityOf(5, changeDriverStatusInSettings);
        changeDriverStatusInSettings.click();
        waitToVisibilityOf(5, activeStatusInSettings);
        activeStatusInSettings.click();
        return this;
    }

    public Drivers changeStatusDriverToInactive(String firstname, String lastname) {
        if (!activeDriver.isSelected()) {
            log.info("Status Driver hasn't been changed cause actually status = Inactive");
        } else {
            ((JavascriptExecutor)driver).executeScript(("arguments[0].click();"), activeDriver);
            log.info("Driver Status has been changed to Inactive.");
            waitToVisibilityOf(5, driverStatusMessage);
            Assert.assertEquals(driverStatusMessage.getText(), "Are you sure you want to deactivate driver " + firstname + " " + lastname + "?");
            acceptButtonChangeStatus.click();
        }
        return this;
    }

    public Drivers changeStatusFilter(String status) {
        switch (status) {
            case ("Active"): {
                log.info("Change filter status to Active!");
                waitToVisibilityOf(5, changeFilterStatus);
                changeFilterStatus.click();
                waitToVisibilityOf(5, activeStatus);
                activeStatus.click();
                break;
            }
            case ("Inactive"): {
                log.info("Change filter status to Inactive!");
                waitToVisibilityOf(5, changeFilterStatus);
                changeFilterStatus.click();
                waitToVisibilityOf(5, inactiveStatus);
                inactiveStatus.click();
                break;
            }
            case ("Unavailable"): {
                log.info("Change filter status to Unavailable!");
                waitToVisibilityOf(5, changeFilterStatus);
                changeFilterStatus.click();
                waitToVisibilityOf(5, unavailableStatus);
                unavailableStatus.click();
                break;
            }
        }
        return this;
    }

    public Drivers turnOffAllowInsertEvents() {
        clickCheckbox(allowInsertEventsCheckbox, false, "Allow Insert Events");
        return this;
    }

    public Drivers turnOnAllowInsertEvents() {
        clickCheckbox(allowInsertEventsCheckbox, true, "Allow Insert Events");
        return this;
    }

    public Drivers turnOffAllowEditEvents() {
        clickCheckbox(allowEditEventsCheckbox, false, "Allow Edit Events");
        return this;
    }

    public Drivers turnOnAllowEditEvents() {
        clickCheckbox(allowEditEventsCheckbox, true, "Allow Edit Events");
        return this;
    }

    public Drivers turnOffAllowDrivingEvents() {
        clickCheckbox(allowDrivingEventsCheckbox, false, "Allow Driving Events");
        return this;
    }

    public Drivers turnOnAllowDrivingEvents() {
        clickCheckbox(allowDrivingEventsCheckbox, true, "Allow Driving Events");
        return this;
    }


    public Drivers turnOffAllowDeleteEvents() {
        clickCheckbox(allowDeleteEventsCheckbox, false, "Allow Delete Events");
        return this;
    }



    public Drivers turnOnAllowDeleteEvents () {
        clickCheckbox(allowDeleteEventsCheckbox, true, "Allow Delete Events");
        return this;
    }

    public Drivers saveChangesProfile() {
        waitToVisibilityOf(5, saveButton);
        saveButton.click();
        log.info("Save changes.");
        return this;
    }

    //---------------------------------------------------------

    //----------------------------------------- DriverProperties

    public static String homeZone;
    public static String nameDriverValue;
    public static String lastNameDriverValue;
    public static String driverLicense;
    public static String stateLicense;

    //-----------------------------------------


    public Drivers foundDriver(String firstname, String lastname) throws InterruptedException {
        Integer count = 0;
        waitToVisibilityOfClick(10, nameField);
        nameField.sendKeys(firstname);
        log.info("Web: Input login driver. Driver login: "+firstname);
        waitToVisibilityOfClick(10, lastNameField);
        lastNameField.sendKeys(lastname);
        log.info("Web: Input last name driver. Last name driver: "+lastname);
        while ((!firstNameDriverInColumn.getText().equals(firstname))&&(count!=10)) {
            log.info("Waiting for loading page with the desired driver.");
            count++;
            Thread.sleep(500);
        }
        if (count == 10) {
            Assert.fail("Driver not found! Test failed");
        }
        return this;
    }

    public Drivers foundDriverForLoginName(String loginname) {
        waitToVisibilityOfClick(10, loginField);
        loginField.sendKeys(loginname);
        log.info("Web: Input login driver. Driver login: "+loginname);
        return this;
    }

    public void compareDriver(String firstname) throws InterruptedException {
        //checkTextOnElement(firstNameFieldDriver, firstname);
        Thread.sleep(3000);
        Assert.assertEquals(firstNameFieldDriver.getText(), firstname);
        log.info("Web: Driver found! Name Driver: "+firstname);
    }

    public Drivers openDriverSettings() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!isElementPresent(1, allowEditEventsCheckbox)) {
            waitToVisibilityOfClick(10, openSettingsDriver);
            openSettingsDriver.click();
            log.info("Open driver settings.");
        } else {
            return this;
        }
        return this;
    }

    public Drivers saveAllDriverProperties() {
        waitToVisibilityOf(5, homeTerminalZone);
        homeZone = homeTerminalZone.getText();
        nameDriverValue = nameDriver.getAttribute("value");
        lastNameDriverValue = lastNameDriver.getAttribute("value");
        driverLicense = licenseDriver.getAttribute("value");
        stateLicense = licenseState.getAttribute("value");
        return this;
    }

    public void openHosPage() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitToVisibilityOf(5, openHos);
        String winHandleBefore = driver.getWindowHandle();
        openHos.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }
}
