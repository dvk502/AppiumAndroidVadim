package logic.loginPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

/*import logic.init.AppiumBaseTest;*/
import logic.init.BasePage;
import logic.init.LocatorName;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;

public class RegistrationPage extends BasePage {
    protected static final Logger log = Logger.getLogger(RegistrationPage.class);

//    @AfterClass
//    public static void closeSession() {
//        AndroidMobileDrivers.driver.quit();
//        System.out.println("Все тесты окончены, сессия закрыта.");
//    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

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
    @AndroidFindBy(id = projectLocator + ":id/license_country_spinner")
    public static MobileElement openCountryList;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
    public static MobileElement chooseCountryFromList;
    @AndroidFindBy(id = projectLocator + ":id/user_info_next_button")
    public static MobileElement saveDriver;
    @AndroidFindBy(id = projectLocator + ":id/fleet_manager_btn")
    public static MobileElement fleetBtn;
    @AndroidFindBy(id = projectLocator + ":id/question_two_no_btn")
    public static MobileElement noDriverFleetBtn;
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
    public static MobileElement selectCountryList;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.Spinner/android.widget.TextView")
    public static MobileElement choosedContry;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
    public static MobileElement chooseUsaCountry;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    public static MobileElement chooseCanadaCountry;
    @AndroidFindBy(id = projectLocator + ":id/address_state_spinner")
    public static MobileElement selectProvince;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.Spinner/android.widget.TextView")
    public static MobileElement choosedProvince;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.Spinner/android.widget.TextView")
    public static MobileElement choosedTimezone;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[8]")
    public static MobileElement chooseProvince;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
    public static MobileElement checkFirstElement;
    @AndroidFindBy(id = projectLocator + ":id/address_city")
    public static MobileElement fieldCity;
    @AndroidFindBy(id = projectLocator + ":id/time_zone_spinner")
    public static MobileElement selectTimeZone;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]")
    public static MobileElement chooseTimeZone;
    @AndroidFindBy(id = projectLocator + ":id/zip_code")
    public static MobileElement zipCodeField;
    @AndroidFindBy(id = projectLocator + ":id/phone_number")
    public static MobileElement phoneNumberField;
    @AndroidFindBy(id = projectLocator + ":id/address_info_save_button")
    public static MobileElement createBtn;
    @AndroidFindBy(id = projectLocator + ":id/accept_checkbox")
    public static MobileElement privacyPolicyBox;
    @AndroidFindBy(id = projectLocator + ":id/accept_button")
    public static MobileElement privacyPolicyAccept;
    @AndroidFindBy(xpath = "//*[@text='Terms of Use']")
    public static MobileElement linkToTermOfUse;
    @AndroidFindBy(id = projectLocator + ":id/back")
    public static MobileElement buttonBackToPrivacyPolicy;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.webkit.WebView/android.webkit.WebView/android.view.View[3]")
    public static MobileElement firstTextBox;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.webkit.WebView/android.webkit.WebView/android.view.View[2]")
    public static MobileElement firstTextBoxAlpha;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.webkit.WebView/android.webkit.WebView/android.view.View[4]")
    public static MobileElement secondTextBox;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.webkit.WebView/android.webkit.WebView/android.view.View[3]")
    public static MobileElement secondTextBoxAlpha;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.webkit.WebView/android.webkit.WebView/android.view.View[2]")
    public static MobileElement secondPageFirstTextBox;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.webkit.WebView/android.webkit.WebView/android.view.View[4]/android.widget.TextView[1]")
    public MobileElement secondPageSecondTextBox;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.webkit.WebView/android.webkit.WebView/android.view.View[4]/android.widget.TextView[1]")
    public MobileElement secondPageSecondTextBoxV2;
    @AndroidFindBy(xpath = "//*[@text='trackensure.com']")
    public static MobileElement linkToTrackEnsure;
    @AndroidFindBy(xpath = "//*[@text='ELD GUIDE BOOK']")
    public static MobileElement fleetManagerToolGuideLink;
    @AndroidFindBy(id = projectLocator + ":id/cancel")
    public static MobileElement cancelPrivacyPolicyButton;
    @AndroidFindBy(id = projectLocator + ":id/snackbar_text")
    public static MobileElement snackBar;

    LocatorName lname = LocatorName.getLocatorNameInstance();

    @Step("Open page registration driver.")
    public RegistrationPage goToDriverRegistration() {
        waitToVisibilityOf(10, registerBtn);
        waitToBeClickable(10, registerBtn);
        registerBtn.click();
        log.info("Open registration page");
        waitToVisibilityOf(10, chooseDriverBtn);
        waitToBeClickable(10, chooseDriverBtn);
        chooseDriverBtn.click();
        log.info("Selecting type registration: DRIVER");
        return this;
    }

    @Step("Entering driver data.")
    public RegistrationPage sendTextInRegisterField(String orgpin, String firstname, String lastname, String email, String pass, String confPass, String licensenumb) throws InterruptedException {
        waitToVisibilityOf(5, fieldOrgPin);
        fieldOrgPin.sendKeys(orgpin);
        log.info("Incoming registration data: OrgPin: " + orgpin);
        fieldFirstName.sendKeys(firstname);
        log.info("Incoming registration data: First name: " + firstname);
        fieldLastName.sendKeys(lastname);
        log.info("Incoming registration data: Last name: " + lastname);
        fieldEmail.sendKeys(email);
        log.info("Incoming registration data: Email: " + email);
        fieldPassword.sendKeys(pass);
        log.info("Incoming registration data: Password: " + pass);
        fieldConfirmPassword.sendKeys(confPass);
        log.info("Incoming registration data: Confirming password: " + confPass);
        fieldLicense.sendKeys(licensenumb);
        log.info("Incoming registration data: License number: " + licensenumb);
        openCountryList.click();
        log.info("Opening country list.");
        chooseCountryFromList.click();
        log.info("Selecting country.");
        rotateDevice();
        log.info("Comparing all displayed information with expected.");
        Assert.assertEquals(fieldOrgPin.getText(), orgpin, textIsDifferent);
        log.info("Text in Org Pin:" + fieldOrgPin.getText() + textMatch);
        Assert.assertEquals(fieldFirstName.getText(), firstname, textIsDifferent);
        log.info("Text in First Name:" + fieldFirstName.getText() + textMatch);
        Assert.assertEquals(fieldLastName.getText(), lastname, textIsDifferent);
        log.info("Text in Last Name:" + fieldLastName.getText() + textMatch);
        Assert.assertEquals(fieldEmail.getText(), email, textIsDifferent);
        log.info("Text in Email:" + fieldEmail.getText() + textMatch);
        Assert.assertEquals(fieldPassword.getText(), pass, textIsDifferent);
        log.info("Text in password:" + fieldPassword.getText() + textMatch);
        Assert.assertEquals(fieldConfirmPassword.getText(), confPass, textIsDifferent);
        log.info("Text in Confirm Password:" + fieldConfirmPassword.getText() + textMatch);
        Assert.assertEquals(fieldLicense.getText(), licensenumb, textIsDifferent);
        log.info("Text in License:" + fieldLicense.getText() + textMatch);
        log.info("All fields match the expected result");
        return this;
    }

    @Step("Check SnackBar on registration page.")
    public RegistrationPage checkSnackBar(String status) {
        waitToVisibilityOf(5, snackBar);
        String textInSnackBar = snackBar.getText();
        log.info("SnackBar appear!");
        switch (status) {
            case ("usdot"): {
                Assert.assertEquals(textInSnackBar, "Invalid USDOT number");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case ("usdot>9"): {
                if (projectName.equals("TE")) {
                    Assert.assertEquals(textInSnackBar, "USDOT number has more than 9 digits");
                } else {
                    Assert.assertEquals(textInSnackBar, "Invalid USDOT number");
                }
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case ("firstname"): {
                Assert.assertEquals(textInSnackBar, "Invalid First Name");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case ("lastname"): {
                Assert.assertEquals(textInSnackBar, "Invalid Last Name");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case ("enterEmail"): {
                Assert.assertEquals(textInSnackBar, "Enter email!");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case ("enterPassword"): {
                Assert.assertEquals(textInSnackBar, "Enter password!");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case ("confirmPassword"): {
                Assert.assertEquals(textInSnackBar, "Confirm password!");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case ("driverLicense"): {
                Assert.assertEquals(textInSnackBar, "License number cannot be empty");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case ("companyName"): {
                Assert.assertEquals(textInSnackBar, "Enter your company name!");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case ("mcnumber"): {
                Assert.assertEquals(textInSnackBar, "Enter MC Number!");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case ("smallPass"): {
                Assert.assertEquals(textInSnackBar, "Password must be at least 8 characters long!");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case ("orgpin"): {
                Assert.assertEquals(textInSnackBar, "Enter organization pin!");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case ("samelicense"): {
                Assert.assertEquals(textInSnackBar, "This Driver's License is already being used!");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case ("longDriverLicense"): {
                Assert.assertEquals(textInSnackBar, "License number must not exceed 20 characters");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case ("vinNumber"): {
                Assert.assertEquals(textInSnackBar, "You use forbidden characters in VIN number");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case ("fuel"): {
                Assert.assertEquals(textInSnackBar, "Fuel Type cannot be empty");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case "Address": {
                Assert.assertEquals(textInSnackBar, "Enter address!");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case "City": {
                Assert.assertEquals(textInSnackBar, "Enter city!");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case "Zip": {
                Assert.assertEquals(textInSnackBar, "Invalid zip/postal code!");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
            case "Phone": {
                Assert.assertEquals(textInSnackBar, "Enter phone number!");
                log.info("Text in SnackBar compare! Text: " + textInSnackBar);
                break;
            }
        }
        return this;
    }

    @Step("Click to save driver button.")
    public RegistrationPage saveBtn() throws InterruptedException {
        waitToVisibilityOf(10, saveDriver);
        waitToBeClickable(10, saveDriver);
        saveDriver.click();
        Thread.sleep(200);
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Completion of driver registration. Click save driver button.");
        return this;
    }

    @Step("Open page with fleet registration.")
    public RegistrationPage goToFleetReg() {
        waitToVisibilityOf(10, registerBtn);
        waitToBeClickable(10, registerBtn);
        registerBtn.click();
        log.info("Open registration page");
        waitToVisibilityOf(10, fleetBtn);
        waitToBeClickable(10, fleetBtn);
        fleetBtn.click();
        log.info("Choose fleet registration");
        return this;
    }

    @Step("Cancel Privacy Policy")
    public RegistrationPage cancelPrivacyPolicy() {
        waitToVisibilityOf(5, cancelPrivacyPolicyButton);
        cancelPrivacyPolicyButton.click();
        log.info("Close Privacy Policy and back to Login Page.");
        return this;
    }

    @Step("Accept Privacy Policy")
    public RegistrationPage privacyPolicy() {
        waitToVisibilityOf(10, lname.pplocator2);
        log.info("Text in Box Privacy Policy found!");
        log.info("Comparing displayed text in Privacy Policy with expected!");
        switch (projectName) {
            case "Smart": {
                Assert.assertEquals(lname.pplocator2.getText(), "If you are a new Smart eLog subscriber on or after August 21, 2017, or if you use the Site on and after this date, this Privacy Policy applies to you.");
                break;
            }
            case "TE": {
                Assert.assertEquals(lname.pplocator2.getText(), "If you are a new TrackEnsure subscriber on or after August 21, 2017, or if you use the Site on and after this date, this Privacy Policy applies to you.");
                break;
            }
            default: {
                Assert.assertEquals(lname.pplocator2.getText(), "If you are a new " + eldName + " subscriber on or after August 21, 2017, or if you use the Site on and after this date, this Privacy Policy applies to you.");
                break;
            }
        }
        switch (projectName) {
            case "TE": {
                Assert.assertEquals(lname.pplocator3.getText(), "We have updated our Privacy Policy to make it more modern and easy to understand, and to bring TrackEnsure, TrackEnsure POD/PAPS/PARS/BOL/Equipment, TrackEnsure ELD, TrackEnsure Fleet, TrackEnsure CVP customers under a single uniform privacy policy. This update is primarily meant to bring our customers under one privacy policy, regardless of the TrackEnsure services you use. In addition, we have modernized our disclosure policy by outlining our use of social media, mobile, and online analytics information. We also describe in more detail how we collect and receive personal information from third parties.");
                break;
            }
            case "Smart": {
                Assert.assertEquals(lname.pplocator3.getText(), "We have updated our Privacy Policy to make it more modern and easy to understand, and to bring Smart eLog, Smart eLog POD/PAPS/PARS/BOL/Equipment, Smart eLog LLC, Smart eLog Fleet customers under a single uniform privacy policy. This update is primarily meant to bring our customers under one privacy policy, regardless of the Smart eLog services you use. In addition, we have modernized our disclosure policy by outlining our use of social media, mobile, and online analytics information. We also describe in more detail how we collect and receive personal information from third parties.");
                break;
            }
            default: {
                Assert.assertEquals(lname.pplocator3.getText(), "We have updated our Privacy Policy to make it more modern and easy to understand, and to bring " + eldName + ", " + eldName + " POD/PAPS/PARS/BOL/Equipment, " + eldName + ", " + eldName + " Fleet customers under a single uniform privacy policy. This update is primarily meant to bring our customers under one privacy policy, regardless of the " + eldName + " services you use. In addition, we have modernized our disclosure policy by outlining our use of social media, mobile, and online analytics information. We also describe in more detail how we collect and receive personal information from third parties.");
                break;
            }
        }
        log.info("Displayed text in Privacy Policy match with expected!");
        switch (projectName) {
            case "TE": {
                log.info("Try to open Terms of Use Page");
                while (isElementPresent(1, linkToTermOfUse)) {
                    try {
                        searchAndClickElementByText("Terms of Use");
                    } catch (Exception e) {
                        log.info("Element \"Terms of Use\" is not present!");
                    }
                }
                log.info("Terms of use opened!");
                log.info("Comparing displayed text in Terms of Use with expected");
                searchAndClickElementByText("Legal Information & Notices");
                waitToVisibilityOf(5, secondPageFirstTextBox);
                Assert.assertEquals(secondPageFirstTextBox.getText(), "Legal Information & Notices");
                Assert.assertEquals(lname.pplocator1.getText(), "These Terms of Use apply to the TrackEnsure located at ");
                log.info("Displayed text in Terms of Use match with expected!");
                log.info("Try to open TrackEnsure site!");
                linkToTrackEnsure.click();
                log.info("TrackEnsure site opened!");
                log.info("Comparing text on TrackEnsure site with expected");
                waitToVisibilityOf(15, fleetManagerToolGuideLink);
                Assert.assertEquals(fleetManagerToolGuideLink.getText(), "ELD GUIDE BOOK");
                log.info("Displayed text on TrackEnsure site match with expected!");
                log.info("Trying to back to Terms of Use!");
                driver.pressKey(new KeyEvent(AndroidKey.BACK));
                log.info("Terms of Use opened!");
                waitToVisibilityOf(4, secondPageFirstTextBox);
                log.info("Trying to back to Privacy Policy page!");
                buttonBackToPrivacyPolicy.click();
                log.info("Privacy Policy opened! Trying to find accept checkbox and Cancel/Accept buttons!");
                waitToVisibilityOf(4, cancelPrivacyPolicyButton);
                waitToBeClickable(4, cancelPrivacyPolicyButton);
                waitToVisibilityOf(10, privacyPolicyBox);
                log.info("Accept checkbox and buttons Cancel/Accept founded!");
                log.info("Trying to accept Privacy Policy");
                privacyPolicyBox.click();
                waitToVisibilityOf(10, privacyPolicyAccept);
                privacyPolicyAccept.click();
                log.info("Privacy Policy accepted!");
                break;
            }
            default: {
                waitToVisibilityOf(10, privacyPolicyBox);
                log.info("The \"Accept\" checkbox and Cancel/Accept buttons are found!");
                log.info("Trying to accept Privacy Policy");
                privacyPolicyBox.click();
                waitToVisibilityOf(10, privacyPolicyAccept);
                privacyPolicyAccept.click();
                log.info("Privacy Policy accepted!");
                break;
            }
        }
        return this;
    }

    @Step("Selecting the type of user registration.")
    public RegistrationPage chooseFleetNoDriver() {
        waitToVisibilityOf(10, noDriverFleetBtn);
        waitToBeClickable(10, noDriverFleetBtn);
        noDriverFleetBtn.click();
        log.info("Choose fleet (not a driver) registration");
        return new RegistrationPage();
    }

    @Step("Entering fleet data.")
    public RegistrationPage fleetNoDriverReg(String cmpnyname, String usdot, String mcnumber, String firstname, String lastname, String email, String pass, String confpass) throws InterruptedException {
        cmpnyName.sendKeys(cmpnyname);
        log.info("Incoming registration data: Name of Company: " + cmpnyname);
        usDot.sendKeys(usdot);
        log.info("Incoming registration data: USDOT Number: " + usdot);
        mcNumber.sendKeys(mcnumber);
        log.info("Incoming registration data: MC Number: " + mcnumber);
        firstName.sendKeys(firstname);
        log.info("Incoming registration data: Name: " + firstname);
        lastName.sendKeys(lastname);
        log.info("Incoming registration data: Last name: " + lastname);
        emailFleet.sendKeys(email);
        log.info("Incoming registration data: Email: " + email);
        passFleet.sendKeys(pass);
        log.info("Incoming registration data: Password: " + pass);
        confirmPassFleet.sendKeys(confpass);
        log.info("Incoming registration data: Confirming password: " + confpass);
        rotateDevice();
        log.info("Comparing all displayed information with expected.");
        Assert.assertEquals(cmpnyName.getText(), cmpnyname);
        log.info("Text in Company Name:" + cmpnyName.getText() + textMatch);
        Assert.assertEquals(usDot.getText(), usdot, textIsDifferent);
        log.info("Text in USDOT:" + usDot.getText() + textMatch);
        Assert.assertEquals(mcNumber.getText(), mcnumber, textIsDifferent);
        log.info("Text in MC Number:" + mcNumber.getText() + textMatch);
        Assert.assertEquals(firstName.getText(), firstname, textIsDifferent);
        log.info("Text in First Name:" + firstName.getText() + textMatch);
        Assert.assertEquals(lastName.getText(), lastname, textIsDifferent);
        log.info("Text in Last Name:" + lastName.getText() + textMatch);
        Assert.assertEquals(emailFleet.getText(), email, textIsDifferent);
        log.info("Text in Email:" + emailFleet.getText() + textMatch);
        Assert.assertEquals(passFleet.getText(), pass, textIsDifferent);
        log.info("Text in Password:" + passFleet.getText() + textMatch);
        Assert.assertEquals(confirmPassFleet.getText(), confpass, textIsDifferent);
        log.info("Text in Confirm Password field:" + confirmPassFleet.getText() + textMatch);
        log.info("All fields match with expected result");
        return this;
    }

    @Step("Entering fleet data.")
    public RegistrationPage fleetNoDriverReg2(String address, String city, String zip, String phone) throws InterruptedException {
        waitToVisibilityOf(5, addressFleet);
        waitToBeClickable(5, addressFleet);
        addressFleet.sendKeys(address);
        log.info("Incoming registration data: Address: " + address);
        selectCountryList.click();
        log.info("Open country list.");
        chooseCanadaCountry.click();
        log.info("Selecting country.");
        selectProvince.click();
        log.info("Open province list.");
        waitToVisibilityOf(5, checkFirstElement);
        waitToBeClickable(5, checkFirstElement);
        chooseProvince.click();
        String province = choosedProvince.getText();
        log.info("Choose province.");
        fieldCity.sendKeys(city);
        log.info("Incoming registration data: City: " + city);
        selectTimeZone.click();
        log.info("Open Time Zone list.");
        waitToVisibilityOf(5, chooseTimeZone);
        waitToBeClickable(5, chooseTimeZone);
        chooseTimeZone.click();
        String timeZone = choosedTimezone.getText();
        log.info("Selecting Time Zone Driver.");
        waitToBeClickable(5, zipCodeField);
        try {
            zipCodeField.sendKeys(zip);
        } catch (WebDriverException e) {
            log.info("LeakCanary is displayed. Waiting to loading app.");
        } finally {
            waitToVisibilityOf(5, zipCodeField);
            zipCodeField.sendKeys(zip);
        }
        log.info("Incoming registration data: ZipCode: " + zip);
        waitToBeClickable(5, phoneNumberField);
        try {
            phoneNumberField.sendKeys(phone);
        } catch (WebDriverException e) {
            log.info("LeakCanary is displayed. Waiting to loading app.");
        } finally {
            waitToVisibilityOf(10, phoneNumberField);
            phoneNumberField.sendKeys(phone);
        }
        log.info("Incoming registration data: Phone number: " + phone);
        rotateDevice();
        log.info("Comparing all displayed information with expected.");
        waitToBeClickable(10, addressFleet);
        Assert.assertEquals(addressFleet.getText(), address, textIsDifferent);
        log.info("Text in Address fleet:" + addressFleet.getText() + textMatch);
        Assert.assertEquals(choosedContry.getText(), "Canada", textIsDifferent);
        log.info("Text in selected Country:" + choosedContry.getText() + textMatch);
        Assert.assertEquals(choosedProvince.getText(), province, textIsDifferent);
        log.info("Text in Province:" + choosedProvince.getText() + textMatch);
        Assert.assertEquals(fieldCity.getText(), city, textIsDifferent);
        log.info("Text in City:" + fieldCity.getText() + textMatch);
        Assert.assertEquals(choosedTimezone.getText(), timeZone, textIsDifferent);
        log.info("Text in Time Zone:" + choosedTimezone.getText() + textMatch);
        Assert.assertEquals(zipCodeField.getText(), zip, textIsDifferent);
        log.info("Text in ZIP Code:" + zipCodeField.getText() + textMatch);
        Assert.assertEquals(phoneNumberField.getText(), phone, textIsDifferent);
        log.info("Text in Phone:" + phoneNumberField.getText() + textMatch);
        log.info("All fields match the expected result");
        return this;
    }

    @Step("Open next page registration.")
    public RegistrationPage nextPageButton() throws InterruptedException {
        waitToVisibilityOf(10, nextPageBtn);
        waitToBeClickable(10, nextPageBtn);
        nextPageBtn.click();
        Thread.sleep(200);
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Open next page.");
        return this;
    }

    @Step("Saving driver.")
    public RegistrationPage saveBtn2() throws InterruptedException {
        waitToVisibilityOf(10, createBtn);
        waitToBeClickable(10, createBtn);
        createBtn.click();
        Thread.sleep(200);
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        log.info("Creating profile.");
        return this;
    }

    @Step("Entering City information...")
    public RegistrationPage inputCity(String city) {
        waitToVisibilityOf(5, fieldCity);
        waitToBeClickable(5, fieldCity);
        fieldCity.sendKeys(city);
        log.info("Incoming registration data: City: " + city);
        return this;
    }

    @Step("Entering Zip information...")
    public RegistrationPage inputZip(String zip) {
        waitToVisibilityOf(5, zipCodeField);
        waitToBeClickable(5, zipCodeField);
        zipCodeField.sendKeys(zip);
        log.info("Incoming registration data: ZIP Code: " + zip);
        return this;
    }

    @Step("Change Country for driver registration...")
    public RegistrationPage chooseCountryFromList(String country) {
        switch (country) {
            case "usa": {
                waitToVisibilityOf(5, selectCountryList);
                selectCountryList.click();
                log.info("Open country list...");
                waitToVisibilityOf(5, chooseUsaCountry);
                log.info("Choose " + country + " country from list...");
                chooseUsaCountry.click();
                break;
            }
            case "canada": {
                waitToVisibilityOf(5, selectCountryList);
                selectCountryList.click();
                log.info("Open country list...");
                waitToVisibilityOf(5, chooseCanadaCountry);
                log.info("Choose " + country + " country from list...");
                chooseCanadaCountry.click();
                break;
            }
        }
        return this;
    }

    @Step("Entering Address information...")
    public RegistrationPage inputAddress(String address) {
        waitToVisibilityOf(5, addressFleet);
        waitToBeClickable(5, addressFleet);
        addressFleet.sendKeys(address);
        log.info("Incoming registration data: Address: " + address);
        return this;
    }

    @Step("Entering Address information...")
    public RegistrationPage inputPhone(String phone) {
        waitToVisibilityOf(5, phoneNumberField);
        waitToBeClickable(5, phoneNumberField);
        phoneNumberField.sendKeys(phone);
        log.info("Incoming registration data: Phone: " + phone);
        return this;
    }

    @Step("Entering fleet data.")
    public RegistrationPage fleetDriverReg(String cmpnyname, String usdot, String mcnumber, String firstname, String lastname, String email, String pass, String confpass, String license) throws InterruptedException {
        cmpnyName.sendKeys(cmpnyname);
        log.info("Incoming registration data: Name of Company: " + cmpnyname);
        usDot.sendKeys(usdot);
        log.info("Incoming registration data: Number: " + usdot);
        mcNumber.sendKeys(mcnumber);
        log.info("Incoming registration data: Number: " + mcnumber);
        firstName.sendKeys(firstname);
        log.info("Incoming registration data: Name: " + firstname);
        lastName.sendKeys(lastname);
        log.info("Incoming registration data: Last name: " + lastname);
        emailFleet.sendKeys(email);
        log.info("Incoming registration data: Email: " + email);
        passFleet.sendKeys(pass);
        log.info("Incoming registration data: Password: " + pass);
        confirmPassFleet.sendKeys(confpass);
        log.info("Incoming registration data: Confirm password: " + confpass);
        fieldLicense.sendKeys(license);
        log.info("Incoming registration data: License: " + license);
        rotateDevice();
        log.info("Comparing all displayed information with expected.");
        Assert.assertEquals(cmpnyName.getText(), cmpnyname, textIsDifferent);
        log.info("Text in Company Name:" + cmpnyName.getText() + textMatch);
        Assert.assertEquals(usDot.getText(), usdot, textIsDifferent);
        log.info("Text in USDOT:" + usDot.getText() + textMatch);
        Assert.assertEquals(mcNumber.getText(), mcnumber, textIsDifferent);
        log.info("Text in MC Number:" + mcNumber.getText() + textMatch);
        Assert.assertEquals(firstName.getText(), firstname, textIsDifferent);
        log.info("Text in First Name:" + firstName.getText() + textMatch);
        Assert.assertEquals(lastName.getText(), lastname, textIsDifferent);
        log.info("Text in Last Name:" + lastName.getText() + textMatch);
        Assert.assertEquals(emailFleet.getText(), email, textIsDifferent);
        log.info("Text in Email:" + emailFleet.getText() + textMatch);
        Assert.assertEquals(passFleet.getText(), pass, textIsDifferent);
        log.info("Text in Password:" + passFleet.getText() + textMatch);
        Assert.assertEquals(confirmPassFleet.getText(), confpass, textIsDifferent);
        log.info("Text in Confirm Password:" + confirmPassFleet.getText() + textMatch);
        Assert.assertEquals(fieldLicense.getText(), license, textIsDifferent);
        log.info("Text in License field" + fieldLicense.getText() + textMatch);
        log.info("All fields match the expected result");
        return this;
    }
}
