package logic.fleet;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

import logic.init.BasePage;
import logic.init.ImageSelector;
import logic.init.LocatorName;
import logic.loginPage.LoginPage;
import logic.loginPage.RegistrationPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class CreateTruck extends BasePage {

    protected static final Logger log = Logger.getLogger(CreateTruck.class);


    LoginPage loginPage = new LoginPage();

    public String numberTruck;
    public String vinNumberTruck;
    public String numberLicense;
    public String make;
    public String model;
    public String year;
    public String fuelTypeText;

    @AndroidFindBy (id = projectLocator + ":id/menu_add")
    public MobileElement addTruckButton;
    @AndroidFindBy (id = projectLocator + ":id/nav_trucks")
    public MobileElement truckPageOpenButton;
    @AndroidFindBy (id = projectLocator + ":id/editText_fragment_accessory_add_truck_number")
    public MobileElement truckNumberField;
    @AndroidFindBy (id = projectLocator + ":id/editText_fragment_accessory_add_truck_device")
    public MobileElement eldDeviceField;
    @AndroidFindBy (id = projectLocator + ":id/editText_fragment_accessory_add_truck_vin")
    public MobileElement vinNumberField;
    @AndroidFindBy (id = projectLocator + ":id/editText_fragment_accessory_add_truck_license")
    public MobileElement licensePlateField;
    @AndroidFindBy (id = projectLocator + ":id/editText_fragment_accessory_add_truck_make")
    public MobileElement makeField;
    @AndroidFindBy (id = projectLocator + ":id/editText_fragment_accessory_add_truck_model")
    public MobileElement modelField;
    @AndroidFindBy (id = projectLocator + ":id/editText_fragment_accessory_add_truck_model_year")
    public MobileElement modelYearField;
    @AndroidFindBy (id = projectLocator + ":id/fuel_type_spinner")
    public MobileElement fuelTypeChoose;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[8]")
    public MobileElement fuelType;
    @AndroidFindBy (id = projectLocator + ":id/button_fragment_accessory_add_truck")
    public MobileElement truckSaveButton;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1] ")
    public MobileElement firstTruck;
    @AndroidFindBy (id = "org.swift.eld:id/truckNumber")
    public MobileElement firstTruckSwift;
    @AndroidFindBy (id = "org.alfa.eld:id/truckNumber")
    public MobileElement firstTruckAlfa;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    public MobileElement secondTruck;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    public MobileElement thirdTruck;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    public MobileElement fourthTruck;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    public MobileElement fifthTruck;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[6]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    public MobileElement sixthTruck;
    @AndroidFindBy (id = projectLocator + ":id/menu_search")
    public MobileElement truckFoundButton;
    @AndroidFindBy (id = projectLocator + ":id/search_src_text")
    public MobileElement truckFoundField;
    @AndroidFindBy (id = projectLocator + ":id/img_company_profile2")
    public MobileElement createAtLeastOneTruckRecord;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[11]")
    public MobileElement emptyFuelType;
    @AndroidFindBy (id = projectLocator + ":id/truckNumber")
    public MobileElement truckNumberId;
    @AndroidFindBy (id = projectLocator + ":id/dialog_alert_msg_message")
    public MobileElement displayedMessage;
    @AndroidFindBy (id = projectLocator + ":id/dialog_alert_msg_ok")
    public MobileElement confirmMessage;

    LocatorName lname = LocatorName.getLocatorNameInstance();

    @Step("Check require fields.")
    public CreateTruck checkRequireFields(String wrongVin, String truckNumber, String eldDevice, String vin, String license, String truckmake, String model, String year) throws InterruptedException, IOException {
        ImageSelector imageSelector = new ImageSelector();
        RegistrationPage registrationPage = new RegistrationPage();
        eldDeviceNumber(eldDevice);
        licensePlate(license);
        makeTruck(truckmake);
        modelTruck(model);
        modelYearTruck(year);
        fuelType();
        fuelTypeChoose();
        truckSave();
        imageSelector.truckNumber();
        truckNumberFld(truckNumber);
        vinNumberField.clear();
        truckSave();
        imageSelector.vinNumber();
        vinNumber(vin);
        licensePlateField.clear();
        truckSave();
        imageSelector.licenseNumberEmpty();
        licensePlate(license);
        fuelTypeChoose.click();
        scrollToAnElementByText(driver, "Biodiesel");
        Thread.sleep(1000);
        waitToBeClickable(5, emptyFuelType);
        emptyFuelType.click();
        truckSave();
        registrationPage.checkSnackBar("fuel");
        vinNumberField.sendKeys(wrongVin);
        truckSave();
        imageSelector.wrongVinNumberLess();
        return this;
    }

    @Step("Input login fleet on login page.")
    public CreateTruck loginFleet(String login) {
        waitToVisibilityOf(10, loginPage.loginField);
        waitToBeClickable(10, loginPage.loginField);
        loginPage.loginField.sendKeys(login);
        log.info("Input fleet login on login page. Login: "+login);
        return this;
    }

    @Step("Confirm displayed message about empty trucklist.")
    public CreateTruck emptyTruckList() {
        if(isElementPresent(2, displayedMessage)) {
            Assert.assertEquals("There are no trucks in the company. You can add a truck by clicking the \"+\" button", displayedMessage.getText());
            confirmMessage.click();
            log.info("Confirm displayed message about empty truck list.");
        }
        return this;
    }

    @Step("Input password fleet on login page")
    public CreateTruck  passFleet(String pass) {
        waitToVisibilityOf(10, loginPage.passField);
        waitToBeClickable(10, loginPage.passField);
        loginPage.passField.sendKeys(pass);
        log.info("Input fleet password on login page. Password: "+pass);
        return this;
    }

    @Step ("Click to Button \"Create at least one Truck record\"")
    public CreateTruck clicktoAtLeastOneTruckButton() {
        waitToVisibilityOf(10, createAtLeastOneTruckRecord);
        waitToBeClickable(10, createAtLeastOneTruckRecord);
        createAtLeastOneTruckRecord.click();
        log.info("Open trucks page from button 'Create at least one Truck record'");
        return this;
    }

    @Step ("Login button press.")
    public CreateTruck loginBtnPress() {
        waitToVisibilityOf(10, loginPage.loginButton);
        waitToBeClickable(10, loginPage.loginButton);
        loginPage.loginButton.click();
        log.info("Press to login button.");
        return this;
    }

    @Step ("Open page add truck.")
    public CreateTruck addButton() {
        waitToVisibilityOf(15, addTruckButton);
        waitToBeClickable(10, addTruckButton);
        addTruckButton.click();
        log.info("Click to Add truck button.");
        return this;
    }

    @Step ("Open truck page.")
    public CreateTruck truckPageOpen() {
        waitToVisibilityOf(10, truckPageOpenButton);
        waitToBeClickable(10, truckPageOpenButton);
        truckPageOpenButton.click();
        log.info("Open truck page.");
        return this;
    }

    @Step ("Input truck number.")
    public String truckNumberFld(String trucknumber) {
        waitToVisibilityOf(10, truckNumberField);
        truckNumberField.sendKeys(trucknumber);
        numberTruck = truckNumberField.getText();
        log.info("Input truck number. Number: "+trucknumber);
        log.info("Get number truck. Number truck: "+numberTruck);
        return trucknumber;
    }

    @Step ("Input ELD Device number.")
    public CreateTruck eldDeviceNumber(String elddevice) {
        rotateDevice();
        waitToVisibilityOf(10, eldDeviceField);
        waitToBeClickable(10, eldDeviceField);
        eldDeviceField.sendKeys(elddevice);
        log.info("Input ELD Device number. ELD Number: "+elddevice);
        return this;
    }

    @Step ("Input VIN Number truck.")
    public CreateTruck vinNumber(String vinnumber) {
        waitToVisibilityOf(10, vinNumberField);
        waitToBeClickable(10, vinNumberField);
        vinNumberField.sendKeys(vinnumber);
        vinNumberTruck = vinnumber;
        log.info("Input VIN Number. VIN Number: "+vinnumber);
        return this;
    }

    @Step ("Input wrong VIN Number truck.")
    public CreateTruck vinNumberCheck15Symbols(String vinnumber) {
        waitToVisibilityOf(10, vinNumberField);
        waitToBeClickable(10, vinNumberField);
        vinNumberField.sendKeys(vinnumber);
        log.info("Input wrong VIN Number. VIN Number: "+vinnumber);
        return this;
    }

    @Step ("Check alert about wrong VIN Number truck.")
    public CreateTruck checkVinNumberAlert() throws IOException {
        ImageSelector imageSelector = new ImageSelector();
        log.info("Check alert about wrong VIN Number.");
        imageSelector.wrongVinNumberHigher();
        return this;
    }

    @Step ("Input license plate truck.")
    public CreateTruck licensePlate(String licenseplate) {
        waitToVisibilityOf(10, licensePlateField);
        waitToBeClickable(10, licensePlateField);
        licensePlateField.sendKeys(licenseplate);
        numberLicense = licenseplate;
        log.info("Input License plate number. License plate Number: "+licenseplate);
        return this;
    }

    @Step ("Input make truck.")
    public CreateTruck makeTruck(String truckmake) {
        waitToVisibilityOf(10, makeField);
        waitToBeClickable(10, makeField);
        makeField.sendKeys(truckmake);
        make = truckmake;
        log.info("Input Make truck. Make: "+truckmake);
        return this;
    }

    @Step ("Input Model Truck.")
    public CreateTruck modelTruck(String truckmodel) {
        waitToVisibilityOf(10, modelField);
        waitToBeClickable(10, modelField);
        modelField.sendKeys(truckmodel);
        model = truckmodel;
        log.info("Input Model truck. Model: "+truckmodel);
        return this;
    }

    @Step ("Input Model Year.")
    public CreateTruck modelYearTruck(String modelyear) {
        waitToVisibilityOf(10, modelYearField);
        waitToBeClickable(10, modelYearField);
        modelYearField.sendKeys(modelyear);
        year = modelyear;
        log.info("Input Model Year truck. Model year: "+modelyear);
        return this;
    }

    @Step ("Choose fuel type.")
    public CreateTruck fuelType() {
        waitToVisibilityOf(10, fuelTypeChoose);
        waitToBeClickable(10, fuelTypeChoose);
        fuelTypeChoose.click();
        log.info("Choose fuel type truck.");
        return this;
    }

    @Step ("Choose Methanol fuel type.")
    public CreateTruck fuelTypeChoose() {
        waitToVisibilityOf(10, fuelType);
        waitToBeClickable(10, fuelType);
        String typeFuel = fuelType.getText();
        fuelType.click();
        fuelTypeText = fuelTypeChoose.getText();
        log.info("Choose methanol fuel type. Displayed type of Fuel: "+typeFuel);
        return this;
    }

    @Step ("Click to save truck button.")
    public CreateTruck truckSave() {
        rotateDevice();
        waitToVisibilityOf(20, truckSaveButton);
        waitToBeClickable(20, truckSaveButton);
        truckSaveButton.click();
        log.info("Click to save truck button.");
        return this;
    }

    @Step ("Click to open search trucks button.")
    public CreateTruck truckFoundButton() {
        waitToVisibilityLocated(10, By.id(projectLocator + ":id/menu_search"));
        truckFoundButton.click();
        log.info("Click to open search trucks button.");
        return this;
    }

    @Step ("Input number of truck to search field.")
    public CreateTruck truckFoundField() {
        waitToVisibilityOf(10, truckFoundField);
        waitToBeClickable(10, truckFoundField);
        truckFoundField.sendKeys(numberTruck);
        log.info("Input number of truck to search field.");
        return this;
    }

    @Step ("Input number of truck to search field.")
    public CreateTruck truckFoundFieldName(String truckNumber) {
        waitToVisibilityOf(10, truckFoundField);
        waitToBeClickable(10, truckFoundField);
        truckFoundField.sendKeys(truckNumber);
        log.info("Input number of truck to search field.");
        return this;
    }

    @Step ("Check truck on page.")
    public CreateTruck truckFindonDriverFleet() {
        waitToVisibilityOf(10, truckNumberId);
        waitToBeClickable(10, truckNumberId);
        if (truckNumberId.getText().equals(numberTruck)) {
            log.info("Truck found. Number truck: "+numberTruck);
            truckNumberId.click();
            return this;
        }
        else {
            Assert.fail("Truck not found!");
            return this;
        }
    }

    @Step ("Check truck on page.")
    public CreateTruck truckFind() {
        waitToVisibilityOf(10, lname.firstTruck);
        waitToBeClickable(10, lname.firstTruck);
        if (lname.firstTruck.getText().equals(numberTruck)) {
            log.info("Truck found. Number truck: "+numberTruck);
            lname.firstTruck.click();
            return this;
        }
        else {
            Assert.fail("Truck not found!");
            return this;
        }
    }

    @Step ("Check truck on page.")
    public CreateTruck truckOpenName(String truckNumber) {
        waitToVisibilityOf(10, lname.firstTruck);
        waitToBeClickable(10, lname.firstTruck);
        if (lname.firstTruck.getText().equals(truckNumber)) {
            log.info("Truck found. Number truck: "+truckNumber);
            lname.firstTruck.click();
            return this;
        }
        else {
            Assert.fail("Truck not found!");
            return this;
        }
    }

    @Step ("Comparing truck data's")
    public CreateTruck truckDataCompare(String truckName, String eldNumber, String vinNumber, String licensePlate, String make, String model, String modelYear) {
        waitToVisibilityOf(5,truckNumberField);
        log.info("Compare information about truck.");
        Assert.assertEquals(truckNumberField.getText(), truckName);
        Assert.assertEquals(eldDeviceField.getText(), eldNumber);
        Assert.assertEquals(vinNumberField.getText(), vinNumber);
        Assert.assertEquals(licensePlateField.getText(), licensePlate);
        Assert.assertEquals(makeField.getText(), make);
        Assert.assertEquals(modelField.getText(), model);
        Assert.assertEquals(modelYearField.getText(), modelYear);
        log.info("All info about truck matches!");
        return this;
    }

    @Step ("Compare VIN number truck.")
    public CreateTruck vinTruckCompare() {
        rotateDevice();
        waitToVisibilityOf(10, vinNumberField);
        //waitToBeClickable(10, vinNumberField);
        Assert.assertEquals(vinNumberField.getText(),vinNumberTruck);
//        vinNumberTruck.equals(vinNumberField.getText());
        log.info("Truck Vin number compare!");
        return this;
    }

    @Step ("Compare number license truck.")
    public CreateTruck licenseTruckCompare() {
        waitToVisibilityOf(10, licensePlateField);
        waitToBeClickable(10, licensePlateField);
        Assert.assertEquals(licensePlateField.getText(),numberLicense);
//        numberLicense.equals(licensePlateField.getText());
        log.info("License number compare!");
        return this;
    }

    @Step ("Compare make truck.")
    public CreateTruck makeCompare() {
        waitToVisibilityOf(10, makeField);
        waitToBeClickable(10, makeField);
        Assert.assertEquals(makeField.getText(),make);
//        make.equals(makeField.getText());
        log.info("Make compare!");
        return this;
    }

    @Step ("Compare model truck.")
    public CreateTruck modelFieldCompare() {
        waitToVisibilityOf(10, modelField);
        waitToBeClickable(10, modelField);
        Assert.assertEquals(modelField.getText(),model);
//        model.equals(modelField.getText());
        log.info("Truck model compare!");
        return this;
    }

    @Step ("Compare model year truck.")
    public CreateTruck modelYearCompare() {
        waitToVisibilityOf(10, modelYearField);
        waitToBeClickable(10, modelYearField);
        Assert.assertEquals(modelYearField.getText(),year);
//        year.equals(modelYearField.getText());
        log.info("Model year compare!");
        return this;
    }

    @Step ("Compare fuel type truck.")
    public CreateTruck fuelTypeCompare() {
        waitToVisibilityOf(10, fuelTypeChoose);
        waitToBeClickable(10, fuelTypeChoose);
        Assert.assertEquals(fuelTypeChoose.getText(),fuelTypeText);
//        fuelTypeText.equals(fuelTypeChoose.getText());
        log.info("Truck fuel type compare!");
        return this;
    }

}
