package logic.web.companyProfile;

import io.appium.java_client.MobileElement;
import logic.hos.dvirPage.AddInspectionReport;
import logic.init.BasePageWeb;
import logic.init.DateUtil;
import logic.init.ListenersWeb;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

@org.testng.annotations.Listeners(ListenersWeb.class)
public class IRPage extends BasePageWeb {
    protected static final Logger log = Logger.getLogger(IRPage.class);

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[1]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div[2]/div/div/div/div[1]/div")
    public WebElement dateField;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[1]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div[2]/div/div/div/div[2]/div")
    public WebElement locationField;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[1]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div[2]/div/div/div/div[3]/div")
    public WebElement truckNumberField;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[1]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div[2]/div/div/div/div[5]/div")
    public WebElement odometerField;
    @FindBy(css = "i[class='fa fa-pencil fa-icon-size']")
    public WebElement editIrButton;
    @FindBy(css = "input[ng-model=\"vm.truckDefects[$index]\"]")
    public List<WebElement> truckDefects;
    @FindBy(css = "input[ng-model=\"vm.trailerDefects[$index]\"]")
    public List<WebElement> trailerDefects;
    @FindBy(css = "div[ng-repeat=\"type in vm.vehicleDefectsList track by $index\"]")
    public List<WebElement> truckDefectsList;
    @FindBy(css = "div[ng-repeat=\"type in vm.trailerDefectsList track by $index\"]")
    public List<WebElement> trailerDefectsList;
    @FindBy(css = "h3[ng-if=\"vm.driverInspectionReport.reportId\"]")
    public WebElement titleIr;
    @FindBy(css = "button[ng-click=\"vm.ok()\"]")
    public WebElement saveIrDefects;
    @FindBy(css = "a[ng-click=\"vm.newInspectionReport()\"]")
    public WebElement newIRButton;
    @FindBy(css = "input[ng-model=\"vm.driverInspectionReport.locationDescription\"]")
    public WebElement locationIRField;
    @FindBy(css = "a[ng-click=\"vm.clickedVehiclesToggle('truck')\"]")
    public WebElement truckIRButtonClick;
    @FindBy(css = "a[ng-click=\"vm.clickedVehiclesToggle('trailer')\"]")
    public WebElement trailerIRButtonClick;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/form/div[2]/div[3]/div[3]/div/oi-select/div[1]/ul/li[1]/input")
    public WebElement selectUnitIR;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/form/div[2]/div[4]/div[1]/div/oi-select/div[1]/ul/li[1]/input")
    public WebElement selectTruckNumberIR;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/form/div[2]/div[3]/div[3]/div/oi-select/div[2]/ul/li[1]")
    public WebElement selectKilometersInUnit;
    @FindBy(css = "input[ng-model=\"vm.driverInspectionReport.trailerNumber\"]")
    public WebElement trailerNumberIR;
    @FindBy(css = "input[ng-model=\"vm.driverInspectionReport.odometer\"]")
    public WebElement odometerIRField;








    AddInspectionReport inspectionReport = new AddInspectionReport();

    String changedMinutes;

    public IRPage openEditIr() {
        waitToVisibilityOf(5, editIrButton);
        editIrButton.click();
        log.info("Opening Edit IR Page.");
        return this;
    }

    public IRPage createNewIR(String location) {
        waitToVisibilityOf(5, newIRButton);
        newIRButton.click();
        log.info("Create new Inspection Report.");
        waitToVisibilityOf(5, locationIRField);
        locationIRField.sendKeys(location);
        truckIRButtonClick.click();
        trailerIRButtonClick.click();
        odometerIRField.sendKeys("5000");
        selectUnitIR.click();
        waitToVisibilityOf(5, selectKilometersInUnit);
        selectKilometersInUnit.click();
        selectTruckNumberIR.sendKeys("TestTruck");
        selectTruckNumberIR.sendKeys(Keys.RETURN);
        trailerNumberIR.sendKeys("TestTrailer");
        return this;
    }

    public IRPage refreshIRPage() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
        log.info("Update DVIR page on WEB");
        return this;
    }

    public IRPage changeMinuteIfOneSymbol() {
        changedMinutes = AddInspectionReport.minutes;
        /*if(Integer.parseInt(inspectionReport.minutes)<10) {
            changedMinutes = "0" + changedMinutes;
        }*/
        return this;
    }

    public IRPage checkIfAllTruckCheckboxesActivated() {
        waitToVisibilityOf(10, titleIr);
        for (WebElement element : truckDefects) {
            int countCheckbox = truckDefects.indexOf(element);
            Assert.assertTrue(element.isSelected(), "Truck Checkbox - " + truckDefectsList.get(countCheckbox).getText() + " - with number " + (truckDefects.indexOf(element)+1) + " not activated.");
            log.info("Truck Checkbox - " + truckDefectsList.get(countCheckbox).getText() + " - with number " + (truckDefects.indexOf(element)+1) + " activated!");
        }
        log.info(" ------- All Truck Checkboxes activated!  ------- ");
        return this;
    }

    public IRPage checkIfAllTrailerCheckboxesActivated() {
        waitToVisibilityOf(10, titleIr);
        for (WebElement element : trailerDefects) {
                int countCheckbox = trailerDefects.indexOf(element);
                Assert.assertTrue(element.isSelected(), "Trailer Checkbox - " + trailerDefectsList.get(countCheckbox).getText() + " - with number " + (trailerDefects.indexOf(element)+1) + " not activated.");
                log.info("Trailer Checkbox - " + trailerDefectsList.get(countCheckbox).getText() + " - with number " + (trailerDefects.indexOf(element)+1) + " activated!");
        }
        log.info(" ------- All Trailer Checkboxes activated!  ------- ");
        return this;
    }

    public IRPage checkIfAllTruckCheckboxesDeactivated() {
        waitToVisibilityOf(10, titleIr);
        for (WebElement element : truckDefects) {
            int countCheckbox = truckDefects.indexOf(element);
            if (!element.isSelected()) {
                log.info("Truck Checkbox - " + truckDefectsList.get(countCheckbox).getText() + " - with number " + (truckDefects.indexOf(element) + 1) + " not activated!");
            } else {
                Assert.fail("Truck Checkbox - " + truckDefectsList.get(countCheckbox).getText() + " - with number " + (truckDefects.indexOf(element)+1) + " activated.");
            }
        }
        log.info(" ------- All Truck Checkboxes Deactivated!  ------- ");
        return this;
    }

    public IRPage checkIfAllTrailerCheckboxesDeactivated() {
        waitToVisibilityOf(10, titleIr);
        for (WebElement element : trailerDefects) {
            int countCheckbox = trailerDefects.indexOf(element);
            if (!element.isSelected()) {
                log.info("Trailer Checkbox - " + trailerDefectsList.get(countCheckbox).getText() + " - with number " + (trailerDefects.indexOf(element)+1) + " not activated!");
            } else {
                Assert.fail("Trailer Checkbox - " + trailerDefectsList.get(countCheckbox).getText() + " - with number " + (trailerDefects.indexOf(element)+1) + " activated.");
            }
        }
        log.info(" ------- All Trailer Checkboxes Deactivated!  ------- ");
        return this;
    }

    public IRPage turnOffAllTruckCheckboxes() {
        waitToVisibilityOf(10, titleIr);
        for (WebElement element : truckDefects) {
            int countCheckbox = truckDefects.indexOf(element);
            element.click();
            log.info("Disable Truck Checkbox - " + truckDefectsList.get(countCheckbox).getText() + " - with number " + (truckDefects.indexOf(element)+1));
        }
        log.info(" ------- All Truck Checkboxes disabled!  ------- ");
        return this;
    }

    public IRPage turnOffAllTrailerCheckboxes() {
        waitToVisibilityOf(10, titleIr);
        for (WebElement element : trailerDefects) {
            int countCheckbox = trailerDefects.indexOf(element);
            element.click();
            log.info("Disable Trailer Checkbox - " + trailerDefectsList.get(countCheckbox).getText() + " - with number " + (trailerDefects.indexOf(element)+1));
        }
        log.info(" ------- All Trailer Checkboxes disabled!  ------- ");
        return this;
    }

    public IRPage turnOnAllTruckCheckboxes() {
        for (WebElement element : truckDefects) {
            int countCheckbox = truckDefects.indexOf(element);
            element.click();
            log.info("Enable Truck Checkbox - " + truckDefectsList.get(countCheckbox).getText() + " - with number " + (truckDefects.indexOf(element)+1));
        }
        log.info(" ------- All Truck Checkboxes Enabled!  ------- ");
        return this;
    }

    public IRPage turnOnAllTrailerCheckboxes() {
        for (WebElement element : trailerDefects) {
            int countCheckbox = trailerDefects.indexOf(element);
            element.click();
            log.info("Enable Trailer Checkbox - " + trailerDefectsList.get(countCheckbox).getText() + " - with number " + (trailerDefects.indexOf(element)+1));
        }
        log.info(" ------- All Trailer Checkboxes Enabled!  ------- ");
        return this;
    }

    public IRPage saveIrDefects() {
        waitToVisibilityOf(5, saveIrDefects);
        saveIrDefects.click();
        log.info("Save IR Defects.");
        return this;
    }

    public IRPage compareDataIR() {
        DateUtil date = new DateUtil();
        changeMinuteIfOneSymbol();
        waitToVisibilityOf(5, dateField);
        log.info("Compare displayed date in app and displayed date on WEB.");
        if (!dateField.getText().isEmpty()) {
            if (Integer.parseInt(AddInspectionReport.resultHours) > 9) {
                Assert.assertEquals(dateField.getText(), DateUtil.formattedCurrentDateIRWeb(null) + " " + AddInspectionReport.resultHours + ":" + changedMinutes);
            } else {
                Assert.assertEquals(dateField.getText(), DateUtil.formattedCurrentDateIRWeb(null) + " " + "0" + AddInspectionReport.resultHours + ":" + changedMinutes);
            }
        } else {
            log.error("Report date IR is empty!");
        }
        log.info("Date match! Date in app: "+ DateUtil.formattedCurrentDateIRWeb(null)+" " + AddInspectionReport.resultHours + ":"+ changedMinutes +", Date on WEB: " + dateField.getText());
        log.info("Compare displayed location in app and displayed location on WEB.");
        Assert.assertEquals(locationField.getText(), AddInspectionReport.location);
        log.info("Location match! Location in app: " + AddInspectionReport.location + ", location on WEB: " + locationField.getText());
        log.info("Compare displayed Truck number in app and displayed Truck number on WEB.");
        Assert.assertEquals(truckNumberField.getText(), AddInspectionReport.truckNumber);
        log.info("Truck number match! Truck number in app: " + AddInspectionReport.truckNumber + ", truck number on WEB: " + truckNumberField.getText());
        log.info("Compare displayed odometer in app and displayed odometer on WEB.");
        Assert.assertEquals(odometerField.getText(), AddInspectionReport.odometer);
        log.info("Odometer match! Displayed odometer in app: " + AddInspectionReport.odometer + ", odometer on WEB: " + odometerField.getText());
        return this;
    }
}
