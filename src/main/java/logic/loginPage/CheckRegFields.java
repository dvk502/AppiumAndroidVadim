package logic.loginPage;

import com.google.common.collect.ImmutableList;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

import logic.init.BasePage;
import logic.init.ImageSelector;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class CheckRegFields extends BasePage {

    protected static final Logger log = Logger.getLogger(CheckRegFields.class);

    @AndroidFindBy(id = projectLocator + ":id/register_button")
    public static MobileElement registerBtn;
    @AndroidFindBy(id = projectLocator + ":id/driver_btn")
    public static MobileElement chooseDriverBtn;
    @AndroidFindBy(id = projectLocator + ":id/org_pin")
    public static MobileElement fieldOrgPin;
    @AndroidFindBy(id = projectLocator + ":id/first_name")
    public static MobileElement fieldFirstName;
    @AndroidFindBy(id = projectLocator + ":id/last_name")
    public static MobileElement fieldLastName;
    @AndroidFindBy(id = projectLocator + ":id/email")
    public static MobileElement fieldEmail;
    @AndroidFindBy(id = projectLocator + ":id/password")
    public static MobileElement fieldPassword;
    @AndroidFindBy(id = projectLocator + ":id/confirm_password")
    public static MobileElement fieldConfirmPassword;
    @AndroidFindBy(id = projectLocator + ":id/driver_license_number")
    public static MobileElement fieldLicense;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Spinner/android.widget.TextView")
    public static MobileElement listCountry;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
    public static MobileElement chooseCountry;
    @AndroidFindBy(id = projectLocator + ":id/user_info_next_button")
    public static MobileElement saveDriver;
    @AndroidFindBy(id = projectLocator + ":id/fleet_manager_btn")
    public static MobileElement fleetBtn;
    @AndroidFindBy(id = projectLocator + ":id/question_two_no_btn")
    public static MobileElement noDriverFleetBtn;
    @AndroidFindBy(id = projectLocator + ":id/question_two_yes_btn")
    public static MobileElement driverFleetBtn;
    @AndroidFindBy(id = projectLocator + ":id/company_name")
    public static MobileElement cmpnyName;
    @AndroidFindBy(id = projectLocator + ":id/usdot")
    public static MobileElement usDot;
    @AndroidFindBy(id = projectLocator + ":id/mc_number")
    public static MobileElement mcNumber;
    @AndroidFindBy(id = projectLocator + ":id/first_name")
    public static MobileElement firstName;
    @AndroidFindBy(id = projectLocator + ":id/last_name")
    public static MobileElement lastName;
    @AndroidFindBy(id = projectLocator + ":id/email")
    public static MobileElement emailFleet;
    @AndroidFindBy(id = projectLocator + ":id/password")
    public static MobileElement passFleet;
    @AndroidFindBy(id = projectLocator + ":id/confirm_password")
    public static MobileElement confirmPassFleet;
    @AndroidFindBy(id = projectLocator + ":id/user_info_next_button")
    public static MobileElement nextPageBtn;
    @AndroidFindBy(id = projectLocator + ":id/address")
    public static MobileElement addressFleet;
    @AndroidFindBy(id = projectLocator + ":id/address_country_spinner")
    public static MobileElement selectCountry;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    public static MobileElement chooseCanadaCountry;
    @AndroidFindBy(id = projectLocator + ":id/address_state_spinner")
    public static MobileElement selectProvince;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[8]")
    public static MobileElement chooseProvince;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
    public static MobileElement checkFirstElement;
    @AndroidFindBy(id = projectLocator + ":id/address_city")
    public static MobileElement fieldCity;
    @AndroidFindBy(id = projectLocator + ":id/time_zone_spinner")
    public static MobileElement selectTimeZone;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[4]")
    public static MobileElement chooseTimeZone;
    @AndroidFindBy(id = projectLocator + ":id/zip_code")
    public static MobileElement zipCodeField;
    @AndroidFindBy(id = projectLocator + ":id/phone_number")
    public static MobileElement phoneNumberField;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")
    public static MobileElement createBtn;
    @AndroidFindBy(id = projectLocator + ":id/owner_operator_btn")
    public static MobileElement ownerChoose;
    @AndroidFindBy(accessibility = "Navigate up")
    public static MobileElement backToRegistration;
    @AndroidFindBy(id = projectLocator + ":id/driver_btn")
    public static MobileElement driverReg;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_msg_message")
    public static MobileElement licenseAlert;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_msg_ok")
    public static MobileElement licenseAlertOk;

    List<String> zipListUsa = new ArrayList<>(ImmutableList.of("11111", "11111-1111"));
    List<String> zipListCanada = new ArrayList<>(ImmutableList.of("a1a1a1", "a1a 1a1", "11111", "A1A1A1", "a1A1a1"));
    List<String> zipListFailSetUsa = new ArrayList<>(ImmutableList.of("1111", "1111-11111", "111111", "111111111", "aaaaaa", "a1a1a1", "111 111", "a1a 1a1"));
    List<String> zipListFailSetCanada = new ArrayList<>(ImmutableList.of("11111-1111", "a1a a1a", "111 aaa", "aaa 111", "1111-11111"));
    RegistrationPage regPage = new RegistrationPage();


    @Step("Open page registration driver.")
    public CheckRegFields goToDriverRegistration(){
        registerBtn.click();
        log.info("Open registration page");
        chooseDriverBtn.click();
        log.info("Choose driving registration");
        return this;
    }

    @Step("Entering driver data.")
    public CheckRegFields sendTextInRegistrField(String orgpin, String firstname, String lastname, String email, String pass, String confPass, String licensenumb){
        fieldOrgPin.sendKeys(orgpin);
        log.info("Incoming registration data: OrgPin: " +orgpin);
        fieldFirstName.sendKeys(firstname);
        log.info("Incoming registration data: First name: " +firstname);
        fieldLastName.sendKeys(lastname);
        log.info("Incoming registration data: OrgPin: " +lastname);
        fieldEmail.sendKeys(email);
        log.info("Incoming registration data: Email: " +email);
        fieldPassword.sendKeys(pass);
        log.info("Incoming registration data: Password: " +pass);
        fieldConfirmPassword.sendKeys(confPass);
        log.info("Incoming registration data: Confirm password: " +confPass);
        fieldLicense.sendKeys(licensenumb);
        log.info("Incoming registration data: License number: " +licensenumb);
        listCountry.click();
        log.info("Open country list.");
        chooseCountry.click();
        log.info("Selecting country.");
        return this;
    }

    @Step("Click to save driver button.")
    public CheckRegFields saveBtn() {
        waitToVisibilityOf(10, saveDriver);
        waitToBeClickable(10, saveDriver);
        saveDriver.click();
        log.info("Completion of driver registration. Click save driver button.");
        return this;
    }

    @Step("Back to main menu.")
    public CheckRegFields backToRegMenu() {
        waitToVisibilityOf(10, backToRegistration);
        waitToBeClickable(10, backToRegistration);
        backToRegistration.click();
        log.info("Back to main menu.");
        return this;
    }

    @Step ("Open registration page.")
    public CheckRegFields goToReg() {
        waitToVisibilityOf(10, registerBtn);
        waitToBeClickable(10, registerBtn);
        registerBtn.click();
        log.info("Open registration page.");
        return this;
    }

    @Step ("Open Owner registration page.")
    public CheckRegFields chooseOwner() {
        waitToVisibilityOf(10, ownerChoose);
        waitToBeClickable(10, ownerChoose);
        ownerChoose.click();
        log.info("Open Owner registration page.");
        return this;
    }


    @Step("Open page fleet registration.")
    public CheckRegFields goToFleetReg () {
        waitToVisibilityOf(10, fleetBtn);
        waitToBeClickable(10, fleetBtn);
        fleetBtn.click();
        log.info("Choose fleet registration.");
        return this;
    }

    @Step("Open Driver registration page.")
    public CheckRegFields driverRegPage() {
        waitToVisibilityOf(10, driverReg);
        waitToBeClickable(10, driverReg);
        driverReg.click();
        log.info("Choose driver registration.");
        return this;
    }

    @Step("Selecting the type of user registration.")
    public CheckRegFields chooseFleetNoDriver () {
        waitToVisibilityOf(10, noDriverFleetBtn);
        waitToBeClickable(10, noDriverFleetBtn);
        noDriverFleetBtn.click();
        log.info("Choose fleet (not a driver) registration");
        return this;
    }

    @Step("Selecting the type of user registration.")
    public CheckRegFields chooseFleetDriver () {
        waitToVisibilityOf(10, driverFleetBtn);
        waitToBeClickable(10, driverFleetBtn);
        driverFleetBtn.click();
        log.info("Choose fleet (driver) registration");
        return this;
    }

    @Step("Input data in required fields. First Company Name check, Leave empty.")
    public CheckRegFields checkFieldsFleetDriver(String usdot,String mcnumber,String firstname,String lastname,String email,String pass,String confpass, String license) {
       log.info("Check required field Company name. Leave empty.");
        usDot.sendKeys(usdot);
        log.info("Incoming registration data: USDOT Number: "+usdot);
        mcNumber.sendKeys(mcnumber);
        log.info("Incoming registration data: MC Number: "+mcnumber);
        firstName.sendKeys(firstname);
        log.info("Incoming registration data: Name: "+firstname);
        lastName.sendKeys(lastname);
        log.info("Incoming registration data: Last name: "+lastname);
        emailFleet.sendKeys(email);
        log.info("Incoming registration data: Email: "+email);
        passFleet.sendKeys(pass);
        log.info("Incoming registration data: Password: "+pass);
        confirmPassFleet.sendKeys(confpass);
        log.info("Incoming registration data: Confirm password: "+confpass);
        fieldLicense.sendKeys(license);
        log.info("Incoming registration data: License: "+license);
        return this;
    }

    @Step("Input data in required fields. First Company Name check, Leave empty.")
    public CheckRegFields checkFieldsOwner(String usdot,String mcnumber,String firstname,String lastname,String email,String pass,String confpass, String license) {
//        cmpnyName.sendKeys(cmpnyname);
        log.info("Check required field Company name. Leave empty.");
        usDot.sendKeys(usdot);
        log.info("Incoming registration data: USDOT Number: "+usdot);
        mcNumber.sendKeys(mcnumber);
        log.info("Incoming registration data: MC Number: "+mcnumber);
        firstName.sendKeys(firstname);
        log.info("Incoming registration data: Name: "+firstname);
        lastName.sendKeys(lastname);
        log.info("Incoming registration data: Last name: "+lastname);
        emailFleet.sendKeys(email);
        log.info("Incoming registration data: Email: "+email);
        passFleet.sendKeys(pass);
        log.info("Incoming registration data: Password: "+pass);
        confirmPassFleet.sendKeys(confpass);
        log.info("Incoming registration data: Confirm password: "+confpass);
        fieldLicense.sendKeys(license);
        log.info("Incoming registration data: License: "+license);
        return this;
    }

    @Step("Input data in required fields. First Organization pin check, Leave empty.")
    public CheckRegFields checkFieldsDriver(String firstname,String lastname,String email,String pass,String confpass, String license) {
//        cmpnyName.sendKeys(cmpnyname);
        log.info("Check required field Organization pin. Leave empty.");
        firstName.sendKeys(firstname);
        log.info("Incoming registration data: Name: "+firstname);
        lastName.sendKeys(lastname);
        log.info("Incoming registration data: Last name: "+lastname);
        emailFleet.sendKeys(email);
        log.info("Incoming registration data: Email: "+email);
        passFleet.sendKeys(pass);
        log.info("Incoming registration data: Password: "+pass);
        confirmPassFleet.sendKeys(confpass);
        log.info("Incoming registration data: Confirm password: "+confpass);
        fieldLicense.sendKeys(license);
        log.info("Incoming registration data: License: "+license);
        return this;
    }

    @Step("Input data in required fields. First Company Name check, Leave empty.")
    public CheckRegFields checkFieldsFleetNoDriver(String usdot,String mcnumber,String firstname,String lastname,String email,String pass,String confpass) {
        log.info("Check required field Company name. Leave empty.");
        usDot.sendKeys(usdot);
        log.info("Incoming registration data: USDOT Number: "+usdot);
        mcNumber.sendKeys(mcnumber);
        log.info("Incoming registration data: MC Number: "+mcnumber);
        firstName.sendKeys(firstname);
        log.info("Incoming registration data: Name: "+firstname);
        lastName.sendKeys(lastname);
        log.info("Incoming registration data: Last name: "+lastname);
        emailFleet.sendKeys(email);
        log.info("Incoming registration data: Email: "+email);
        passFleet.sendKeys(pass);
        log.info("Incoming registration data: Password: "+pass);
        confirmPassFleet.sendKeys(confpass);
        log.info("Incoming registration data: Confirm password: "+confpass);
        return this;
    }

    @Step("Input data in Company Name field. Clear USDOT Number field.")
    public CheckRegFields checkUsdot(String cmpnyname) {
        cmpnyName.sendKeys(cmpnyname);
        log.info("Incoming registration data: Name of Company: "+cmpnyname);
        usDot.clear();
        log.info("Clearing usDot field. Check if this field is required.");
        return this;
    }

    @Step("Input data in USDOT Number field. Clear MC Number Field.")
    public CheckRegFields checkMcNumber(String usdot) {
        usDot.sendKeys(usdot);
        log.info("Incoming registration data: Number: "+usdot);
        mcNumber.clear();
        log.info("Clearing usDot field. Check if this field is required.");
        return this;
    }

    @Step("Input data in MC Number field. Clear First Name field.")
    public CheckRegFields checkFirstName(String mcnumber) {
        mcNumber.sendKeys(mcnumber);
        log.info("Incoming registration data: Number: "+mcnumber);
        firstName.clear();
        log.info("Clearing First name field. Check if this field is required.");
        return this;
    }

    @Step("Input short First name")
    public CheckRegFields checkShortFirstName(String firstname) {
        log.info("Incoming registration data: short First name: " + firstname);
        firstName.sendKeys(firstname);
        return this;
    }

    @Step("Input short Last name")
    public CheckRegFields checkShortLastName(String lastname) {
        log.info("Incoming registration data: short Last name: " + lastname);
        lastName.sendKeys(lastname);
        return this;
    }

    @Step("Input long First name")
    public CheckRegFields checkLongFirstName(String firstname) {
        log.info("Incoming registration data: long First name: " + firstname);
        firstName.sendKeys(firstname);
        return this;
    }

    @Step("Input long Last name")
    public CheckRegFields checkLongLastName(String lastname) {
        log.info("Incoming registration data: long Last name: " + lastname);
        lastName.sendKeys(lastname);
        return this;
    }


    @Step("Input data in MC Number field. Clear First Name field.")
    public CheckRegFields checkFirstNameDriver(String orgpin) {
        fieldOrgPin.sendKeys(orgpin);
        log.info("Incoming registration data: MC Number: "+orgpin);
        firstName.clear();
        log.info("Clearing First name field. Check if this field is required.");
        return this;
    }

    @Step("Input data in First Name field. Clear Last Name field.")
    public CheckRegFields checkLastName(String firstname) {
        firstName.sendKeys(firstname);
        log.info("Incoming registration data: First name fleet. Name: "+firstname);
        lastName.clear();
        log.info("Clearing Last name field. Check if this field is required.");
        return this;
    }

    @Step("Input data in Last Name field. Clear Email field.")
    public CheckRegFields checkEmail(String lastname) {
        lastName.sendKeys(lastname);
        log.info("Incoming registration data: Last name fleet. Last name: "+lastname);
        emailFleet.clear();
        log.info("Clearing Email field. Check if this field is required.");
        return this;
    }

    @Step("Input data in Email field. Clear Password field.")
    public CheckRegFields checkPass(String email) {
        emailFleet.sendKeys(email);
        log.info("Incoming registration data: Email fleet: "+email);
        passFleet.clear();
        log.info("Clearing password field. Check if this field is required.");
        return this;
    }

    @Step("Input data in Email field. Clear Confirm password field.")
    public CheckRegFields checkConfPass(String pass) {
        passFleet.sendKeys(pass);
        log.info("Incoming registration data: Password fleet: "+pass);
        confirmPassFleet.clear();
        log.info("Clearing confirm password field. Check if this field is required.");
        return this;
    }

    @Step("Input data in Password field. Clear License field.")
    public CheckRegFields checkLicense(String confpass) {
        confirmPassFleet.sendKeys(confpass);
        log.info("Incoming registration data: Confirm Password fleet: "+confpass);
        fieldLicense.clear();
        log.info("Clearing license field. Check if this field is required.");
        return this;
    }

    @Step("Entering fleet data.")
    public CheckRegFields inputTextFleetFields2(String adress,String city,String zip,String phone) {
        waitToVisibilityOf(20,addressFleet);
        waitToBeClickable(20,addressFleet);
        addressFleet.sendKeys(adress);
        log.info("Incoming registration data: Address fleet: "+adress);
        selectCountry.click();
        log.info("Open country list.");
        chooseCanadaCountry.click();
        log.info("Selecting country.");
        selectProvince.click();
        log.info("Open province list.");
        waitToVisibilityOf(20,checkFirstElement);
        waitToBeClickable(20,checkFirstElement);
        chooseProvince.click();
        log.info("Selecting province.");
        fieldCity.sendKeys(city);
        log.info("Incoming registration data: Driver city: "+city);
        selectTimeZone.click();
        log.info("Open Time Zone list.");
        waitToVisibilityOf(20,chooseTimeZone);
        waitToBeClickable(20, chooseTimeZone);
        chooseTimeZone.click();
        log.info("Selecting Time Zone Driver.");
        zipCodeField.sendKeys(zip);
        log.info("Incoming registration data: Driver zip code: "+zip);
        phoneNumberField.sendKeys(phone);
        log.info("Incoming registration data: Driver Phone Number: "+phone);
        return this;
    }

    @Step("Click to button Next Page.")
    public CheckRegFields nextPageButton() {
        waitToVisibilityOf(10, nextPageBtn);
        waitToBeClickable(10, nextPageBtn);
        nextPageBtn.click();
        log.info("Click to button Next Page.");
        return this;
    }

    @Step("Check set of ZIP codes for Usa...")
    public CheckRegFields checkSetZipCodesUsa() {
        for (String s : zipListUsa) {
            checkZipField(s);
            waitToBeClickable(5, regPage.createBtn);
            regPage.createBtn.click();
            regPage.cancelPrivacyPolicy();
        }
        return this;
    }

    @Step("Check set of ZIP codes for Canada...")
    public CheckRegFields checkSetZipCodesCanada() {
        for (String s : zipListCanada) {
            checkZipField(s);
            waitToBeClickable(5, regPage.createBtn);
            regPage.createBtn.click();
            regPage.cancelPrivacyPolicy();
        }
        return this;
    }

    @Step("Check set of Fail Zip Codes for Usa...")
    public CheckRegFields checkSetFailCodesUsa() {
        for (String s : zipListFailSetUsa) {
            checkZipField(s);
            waitToBeClickable(5, regPage.createBtn);
            regPage.createBtn.click();
            regPage.checkSnackBar("Zip");
        }
        return this;
    }

    @Step("Check set of Fail Zip Codes for Canada...")
    public CheckRegFields checkSetFailCodesCanada() {
        for (String s : zipListFailSetCanada) {
            checkZipField(s);
            waitToBeClickable(5, regPage.createBtn);
            regPage.createBtn.click();
            regPage.checkSnackBar("Zip");
        }
        return this;
    }

    @Step("Check ZIP/Postal Code field")
    public CheckRegFields checkZipField(String zip) {
        waitToVisibilityOf(5, zipCodeField);
        waitToBeClickable(5, zipCodeField);
        log.info("Incoming registration data: Zip Code: " + zip);
        zipCodeField.sendKeys(zip);
        return this;
    }

    @Step("Saving driver.")
    public CheckRegFields saveBtn2() {
        waitToVisibilityOf(10, createBtn);
        waitToBeClickable(10, createBtn);
        createBtn.click();
        log.info("Creating profile.");
        return this;
    }

    @Step("Input password < 8 char's")
    public CheckRegFields smallpass(String smallpass,String confsmallpass) {
        fieldPassword.sendKeys(smallpass);
        log.info("Incoming registration data: password < 8 chars for check toast.");
        fieldConfirmPassword.sendKeys(confsmallpass);
        log.info("Incoming registration data: confirm password < 8 chars for check toast.");
        return this;
    }

    @Step("Input password > 8 char's")
    public CheckRegFields longsPass(String longpass,String conflongpass) {
        fieldPassword.sendKeys(longpass);
        log.info("Incoming registration data: password > 8 chars for check toast.");
        fieldConfirmPassword.sendKeys(conflongpass);
        log.info("Incoming registration data: confirm password > 8 chars for check toast.");
        return this;
    }

    @Step("Input USDOT only symbols.")
    public CheckRegFields usdotSymbols(String symbols, String pass, String confPass) {
        log.info("Incoming registration data: Only symbols in USDOT field.");
        fieldPassword.sendKeys(pass);
        fieldConfirmPassword.sendKeys(confPass);
        usDot.sendKeys(symbols);
        return this;
    }
    @Step("Input license > 25 char's")
    public CheckRegFields longLicense(String longLicense) {
        fieldLicense.sendKeys(longLicense);
        log.info("Incoming registration data: license > 25 char's for check toast.");
        return this;
    }

    @Step("Input license")
    public CheckRegFields licenseInput(String license) {
        fieldLicense.sendKeys(license);
        log.info("Incoming registration data: License.");
        return this;
    }

    @Step("Input USDOT")
    public CheckRegFields usdotInput(String usdot) {
        usDot.sendKeys(usdot);
        log.info("Incoming registration data: USDOT Number.");
        return this;
    }
}
