package logic.web.companyProfile;

import logic.init.BasePageWeb;
import logic.init.ListenersWeb;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
@org.testng.annotations.Listeners(ListenersWeb.class)
public class Trucks extends BasePageWeb {
    protected static final Logger log = Logger.getLogger(Trucks.class);

    @FindBy(css = "input[ng-model=\"vm.filter.truckNumber\"]")
    public WebElement truckNumberField;
    @FindBy(css = "a[ng-click=\"grid.appScope.vm.editTruckProfile(row.entity)\"]")
    public WebElement truckCompare;
    @FindBy(css = "div[ng-model=\"vm.selectedGpsProvider\"]")
    public WebElement gpsProvider;
    @FindBy(css = "div[ng-bind-html=\"vm.replaceGPSProviderType(gpsSignalProvider) | highlight: $select.search\"]")
    public WebElement telogps;
    @FindBy(css = "input[ng-model=\"vm.truckProfile.model\"]")
    public WebElement modelTruck;
    @FindBy(css = "input[ng-model=\"vm.truckProfile.vin\"]")
    public WebElement vinNumberTruck;
    @FindBy(css = "input[ng-model=\"vm.truckProfile.licensePlate\"]")
    public WebElement licensePlateTruck;
    @FindBy(css = "input[ng-model=\"vm.truckProfile.modelYear\"]")
    public WebElement modelYearTruck;
    @FindBy(css = "input[ng-model=\"vm.truckProfile.make\"]")
    public WebElement makeTruck;
    @FindBy(css = "button[ng-disabled=\"addTruckForm.$invalid || vm.saveValidation()\"]")
    public WebElement saveTruckButton;



    public Trucks inputTruckNumber(String trucknumber) {
        driver.navigate().refresh();
        waitToVisibilityOf(10, truckNumberField);
        truckNumberField.sendKeys(trucknumber);
        log.info("Input truck number in field.");
        return this;
    }

    public Trucks findTruck(String trucknumber) throws InterruptedException {
        log.info("Find truck with truck number: "+trucknumber);
        Thread.sleep(3000);
        waitToVisibilityOfClick(10, truckCompare);
        Assert.assertEquals(truckCompare.getText(), trucknumber);
        log.info("Truck found!");
        return this;
    }

    public Trucks openTruckPage() {
        waitToVisibilityOf(5, truckCompare);
        truckCompare.click();
        log.info("Open truck page. Truck: " +truckCompare.getText());
        return this;
    }
    
    public Trucks changeGpsProvider() {
        waitToVisibilityOf(5, gpsProvider);
        log.info("Choose GPS Provider - TrackEnsure ELOG");
        gpsProvider.click();
        waitToVisibilityOf(5, telogps);
        telogps.click();
        return this;
    }

    public Trucks changeTruckInformation() {
        waitToVisibilityOf(5, modelTruck);
        modelTruck.clear();
        modelTruck.sendKeys("NewModelTruck");
        vinNumberTruck.clear();
        vinNumberTruck.sendKeys("12312312311231234");
        licensePlateTruck.clear();
        licensePlateTruck.sendKeys("NewLicensePlateTruck");
        makeTruck.clear();
        makeTruck.sendKeys("TestNewMakeTruck");
        modelTruck.clear();
        modelYearTruck.clear();
        modelYearTruck.sendKeys("2018");
        return this;
    }

    public Trucks saveChangesTruck() {
        waitToVisibilityOf(5, saveTruckButton);
        saveTruckButton.click();
        log.info("Save Truck changes.");
        return this;
    }
}
