package logic.fleet;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;

import logic.init.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;


public class CreateDriver extends BasePage {

    protected static final Logger log = Logger.getLogger(CreateDriver.class);

    //Open Add driver page
    @AndroidFindBy (id = projectLocator + ":id/nav_fleet_manager_drivers")
    public MobileElement driversButton;
    //Input driver first name
    @AndroidFindBy (id = projectLocator + ":id/editText_field_first_name_add_driver")
    public MobileElement driverFirstNameField;
    //Input driver last name
    @AndroidFindBy (id = projectLocator + ":id/editText_field_last_name_add_driver")
    public MobileElement driverLastNameField;
    //Input driver license
    @AndroidFindBy (id = projectLocator + ":id/editText_fragment_accessory_add_driver_model")
    public MobileElement driverLicenseField;
    //Open License state spinner
    @AndroidFindBy (id = projectLocator + ":id/add_dr_license_state_spinner")
    public MobileElement licenseStateSpinner;
    //Choose License state - California
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[5]")
    public MobileElement licenseStateChoose;
    //Open Home terminal zone spinner
    @AndroidFindBy (id = projectLocator + ":id/add_dr_timezone")
    public MobileElement homeTimeZoneSpinner;
    //Choose Home Terminal Zone - US/Pacific
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[11]")
    public MobileElement homeTimeZoneChoose;
    //Open Usa Duty Cycle spinner
    @AndroidFindBy (id = projectLocator + ":id/add_dr_usa_duty_cycle")
    public MobileElement usaDutyCycleSpinner;
    //Choose Usa duty cycle - 70/7
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    public MobileElement usaDutyCycleChoose;
    //Open Can duty cycle spinner
    @AndroidFindBy (id = projectLocator + ":id/add_dr_can_duty_cycle")
    public MobileElement canDutyCycleSpinner;
    //Choose can duty cycle - 120/14
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    public MobileElement canDutyCycleChoose;
    //Open Yard Move Spinner
    @AndroidFindBy (id = projectLocator + ":id/add_dr_yard_move")
    public MobileElement yardMoveSpinner;
    //Choose Yard move enable
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    public MobileElement yardMoveChoose;
    //Open Personal Use spinner
    @AndroidFindBy (id = projectLocator + ":id/add_dr_personal_use")
    public MobileElement pcSpinner;
    //Choose Personal use enable
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    public MobileElement pcChoose;
    //Open ELD Exempt spinner
    @AndroidFindBy (id = projectLocator + ":id/add_dr_eld_exempt")
    public MobileElement eldExemptSpinner;
    //Choose ELD Exempt Yes
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    public MobileElement eldExemptChoose;
    //Open App Mode Spinner
    @AndroidFindBy (id = projectLocator + ":id/add_dr_app_mode")
    public MobileElement eldAppModeSpinner;
    //Choose App mode AOBRD
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    public MobileElement eldAppModeChoose;
    //Open Status driver spinner
    @AndroidFindBy (id = projectLocator + ":id/add_dr_status_driver")
    public MobileElement statusDriverSpinner;
    //Chose Status driver Active
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    public MobileElement statusDriverChoose;
    //Input Login name driver
    @AndroidFindBy (id = projectLocator + ":id/editText_field_login_name")
    public MobileElement loginNameField;
    //Input password driver
    @AndroidFindBy (id = projectLocator + ":id/editText_field_password")
    public MobileElement passField;
    //Input confirm password driver
    @AndroidFindBy (id = projectLocator + ":id/editText_field_confirm_password")
    public MobileElement confirmPassField;
    //Press Add Driver button
    @AndroidFindBy (id = projectLocator + ":id/button_fragment_accessory_add_driver")
    public MobileElement addDriverButton;
    @AndroidFindBy (id = projectLocator + ":id/dialog_alert_msg_ok")
    public MobileElement confirmAddDriver;
    @AndroidFindBy (id = projectLocator + ":id/menu_search")
    public MobileElement driverFoundButton;
    @AndroidFindBy (id = projectLocator + ":id/search_src_text")
    public MobileElement driverFoundField;
    @AndroidFindBy (id = projectLocator + ":id/textFirstName")
    public MobileElement checkFirstNameField;
    @AndroidFindBy (id = projectLocator + ":id/textLogin")
    public MobileElement checkLoginField;
    @AndroidFindBy (id = projectLocator + ":id/img_company_profile1")
    public MobileElement createAtLeastOneDriver;
    @AndroidFindBy (id = projectLocator + ":id/driverActive")
    public MobileElement driverStatusActive;
    @AndroidFindBy (id = projectLocator + ":id/driverInActive")
    public MobileElement driverStatusInactive;
    @AndroidFindBy (id = projectLocator + ":id/driverUnavailable")
    public MobileElement driverStatusUnavailable;

    @Step ("Open the Drivers page in the Fleet manager menu")
    public CreateDriver openDriversPage() {
        waitToVisibilityOf(10, driversButton);
        waitToBeClickable(10, driversButton);
        driversButton.click();
        log.info("Open the Drivers page in the Fleet manager menu.");
        return this;
    }

    @Step ("Check driver status.")
    public CreateDriver statusDriverCheck(String status) {
        switch (status) {
            case ("Active"):
                waitToVisibilityOf(5, driverStatusActive);
                log.info("Check driver status. Expected status: Active");
                try {
                    Assert.assertEquals(driverStatusActive.getText(), "Active");
                    log.info("Driver status = Active.");
                } catch (AssertionError e) {
                    Assert.fail("Test Failure. Driver Status is not Active ");
                }
                break;
            case ("Inactive"):
                waitToVisibilityOf(5, driverStatusInactive);
                log.info("Check driver status. Expected status: Inactive");
                try {
                    Assert.assertEquals(driverStatusInactive.getText(), "Inactive");
                    log.info("Driver status = Inactive.");
                } catch (AssertionError e) {
                    Assert.fail("Test Failure. Driver Status is not Inactive");
                }
                break;
            case ("Unavailable"):
                waitToVisibilityOf(5, driverStatusUnavailable);
                log.info("Check driver status. Expected status: Unavailable");
                try {
                    Assert.assertEquals(driverStatusUnavailable.getText(), "Unavailable");
                    log.info("Driver status = Unavailable.");
                } catch (AssertionError e) {
                    Assert.fail("Test Failure. Driver Status is not Unavailable ");
                }
                break;
        }
        return this;
    }

    @Step ("Enter the name of the test driver")
    public String firstNameField(String firstname) {
        waitToVisibilityOf(10,driverFirstNameField);
        driverFirstNameField.sendKeys(firstname);
        log.info("Enter the name of the test driver. Name of the driver: "+firstname);
        return firstname;
    }

    @Step ("Enter the lastname of the test driver")
    public String lastNameField(String lastname) {
        waitToVisibilityOf(10, driverLastNameField);
        driverLastNameField.sendKeys(lastname);
        log.info("Enter the lastname of the test driver. Lastname of the driver: "+lastname);
        return lastname;
    }

    @Step ("Click on the button \"Create at least one Driver Account\"")
    public void clicktoAtLeastOneDriverButton() {
        waitToVisibilityOf(15, createAtLeastOneDriver);
        waitToBeClickable(15, createAtLeastOneDriver);
        createAtLeastOneDriver.click();
        log.info("Open the Drivers page using the button 'Create at least one driver account'");
    }

    @Step ("Enter the license number of the test driver")
    public CreateDriver driverLicenseField(String license) {
        waitToVisibilityOf(10, driverLicenseField);
        driverLicenseField.sendKeys(license);
        log.info("Enter the driver's license number. License number: "+license);
        return this;
    }

    @Step ("Choosing a driver's state")
    public CreateDriver licenseStateChoose() {
        waitToVisibilityOf(10, licenseStateSpinner);
        licenseStateSpinner.click();
        log.info("Opening the list of states.");
        waitToVisibilityOf(10, licenseStateChoose);
        String licenseState = licenseStateChoose.getText();
        licenseStateChoose.click();
        log.info("Choosing a driver's state. State: "+licenseState);
        return this;
    }

    @Step ("Choosing the driver's home terminal zone")
    public CreateDriver homeTimeZoneChoose() {
        waitToVisibilityOf(10, homeTimeZoneSpinner);
        homeTimeZoneSpinner.click();
        log.info("Open the list of available time zones for the driver.");
        waitToVisibilityOf(10, homeTimeZoneChoose);
        String homeZone = homeTimeZoneChoose.getText();
        homeTimeZoneChoose.click();
        log.info("Choosing the Driver's Time Zone. Selected Time Zone: "+homeZone);
        return this;
    }

    @Step ("Choosing the USA driver's working cycle")
    public CreateDriver usaDutyCycleChoose() {
        waitToVisibilityOf(10, usaDutyCycleSpinner);
        usaDutyCycleSpinner.click();
        log.info("Open the list of available USA cycles for the driver.");
        waitToVisibilityOf(10, usaDutyCycleChoose);
        String dutyCycleUsa = usaDutyCycleChoose.getText();
        usaDutyCycleChoose.click();
        log.info("Choosing the USA duty cycle for the driver. Selected cycle: "+dutyCycleUsa);
        return this;
    }

    @Step ("Choosing the CAN driver's working cycle")
    public CreateDriver canDutyCycleChoose() {
        waitToVisibilityOf(10, canDutyCycleSpinner);
        canDutyCycleSpinner.click();
        log.info("Open the list of available CAN cycles for the driver.");
        waitToVisibilityOf(10,canDutyCycleChoose);
        String dutyCycleCan = canDutyCycleChoose.getText();
        canDutyCycleChoose.click();
        log.info("Choosing the CAN duty cycle for the driver. Selected cycle: "+dutyCycleCan);
        return this;
    }

    @Step ("Turning on the Yard Move function for the driver")
    public CreateDriver yardMoveChoose() {
        waitToVisibilityOf(10,yardMoveSpinner);
        yardMoveSpinner.click();
        log.info("Opening the list of Yard Move states.");
        waitToVisibilityOf(10, yardMoveChoose);
        String yardMoveStatus = yardMoveChoose.getText();
        yardMoveChoose.click();
        log.info("Turn on Yard Move for the driver. Current status Yard Move: "+yardMoveStatus);
        return this;
    }

    @Step ("Turning on the Personal Convenience function for the driver")
    public CreateDriver pcChoose() {
        waitToVisibilityOf(10, pcSpinner);
        pcSpinner.click();
        log.info("Opening the list of states Personal Convenience.");
        waitToVisibilityOf(10, pcChoose);
        String pcStatus = pcChoose.getText();
        pcChoose.click();
        log.info("Turn on Personal Convenience for the driver. Current status Personal Convenience: "+pcStatus);
        return this;
    }

  /*  public CreateDriver eldExemptChoose() {
        waitToVisibilityOf(10, eldExemptSpinner);
        eldExemptSpinner.click();
        waitToVisibilityOf(10,eldExemptChoose);
        eldExemptChoose.click();
        return this;
    }

    public CreateDriver appModeChoose() {
        waitToVisibilityOf(10, eldAppModeSpinner);
        eldAppModeSpinner.click();
        waitToVisibilityOf(10, eldAppModeChoose);
        eldAppModeChoose.click();
        return this;
    }

    public CreateDriver statusChoose() {
        waitToVisibilityOf(10, statusDriverSpinner);
        statusDriverSpinner.click();
        log.info("Open Driver Status list.");
        waitToVisibilityOf(10, statusDriverChoose);
        String driverStatus = statusDriverChoose.getText();
        statusDriverChoose.click();
        log.info("Choose Driver Status. Driver Status: "+driverStatus);
        return this;
    } */

    @Step("Enter login driver's test")
    public CreateDriver loginNameInput(String login) {
        waitToVisibilityOf(10, loginNameField);
        loginNameField.sendKeys(login);
        log.info("Enter login driver's test: "+login);
        return this;
    }

    @Step("Enter password driver's test")
    public CreateDriver passFieldInput(String pass) {
        waitToVisibilityOf(10, passField);
        waitToBeClickable(10, passField);
        passField.sendKeys(pass);
        log.info("Enter password driver's test: "+pass);
        return this;
    }

    @Step("Enter confirm password driver's test")
    public CreateDriver confPassInput(String confpass) {
     waitToVisibilityOf(10, confirmPassField);
        try {
            confirmPassField.sendKeys(confpass);
        } catch (WebDriverException e) {
            log.info("LeakCanary is displayed. Waiting to loading app.");
        } finally {
            waitToVisibilityOf(10, confirmPassField);
            confirmPassField.sendKeys(confpass);
        }
     log.info("Enter confirm password driver's test: "+confpass);
     return this;
    }

    @Step("Click on the save driver button")
    public CreateDriver addDriverButtonClick() {
        waitToVisibilityOf(10, addDriverButton);
        addDriverButton.click();
        log.info("Click on the save driver button.");
        return this;
    }

    @Step("Scroll the application to the save driver button")
    public CreateDriver moveToSaveButton() {
        new TouchAction(driver).press(PointOption.point(9, 725)).moveTo(PointOption.point(9, 121)).release().perform();
        log.info("Scroll the application to the save driver button.");
        return this;
    }

    @Step ("Confirm adding a driver")
    public CreateDriver confirmDriverAdd() {
        waitToVisibilityOf(10, confirmAddDriver);
        confirmAddDriver.click();
        log.info("Confirm adding a driver.");
        return this;
    }

    @Step("Click on the driver search icon in the list.")
    public CreateDriver driverFoundButton() {
        waitToVisibilityOf(10, driverFoundButton);
        driverFoundButton.click();
        log.info("Click on the driver search icon in the list.");
        return this;
    }

    @Step ("Enter the driver's name in the search.")
    public CreateDriver driverFoundField(String name) {
        waitToVisibilityOf(10, driverFoundField);
        driverFoundField.sendKeys(name);
        log.info("Enter the driver's name in the search.");
        return this;
    }

    @Step ("Trying to find a driver name in the list displayed by the search.")
    public CreateDriver driverNameFoundList(String name) {
        waitToVisibilityOf(10, checkFirstNameField);
        Assert.assertEquals(checkFirstNameField.getText(), name);
        log.info("Driver found! Name of the driver: "+name);
        return this;
    }
    @Step ("Trying to find a driver login in the list displayed by the search.")
    public CreateDriver driverLoginFoundList(String login) {
        waitToVisibilityOf(10, checkLoginField);
        Assert.assertEquals(checkLoginField.getText(), login);
        log.info("Driver found! Name of the driver: "+login);
        return this;
    }
}
