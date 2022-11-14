package logic.settingsPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import logic.hos.iftaPage.AddFuelPurchase;

import logic.init.BasePage;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.List;

public class Permissions extends BasePage {
    protected static final Logger log = Logger.getLogger(Permissions.class);

    @AndroidFindBy(id = projectLocator + ":id/permission_summary")
    public List <MobileElement> cameraPermissionStatus;
    @AndroidFindBy(id = projectLocator + ":id/permission_switch")
    public List <MobileElement> cameraPermissionSwitch;
    @AndroidFindBy(id = projectLocator + ":id/permission_name")
    public List<MobileElement> permissionName;
    @AndroidFindBy(id = projectLocator + ":id/permission_icon")
    public MobileElement permissionIcon;

    public int cameraPermissionNumberInList = 0;

    @Step("Check camera permission status")
    public Permissions checkCameraPermStatusDisable() {
        waitToVisibilityOf(5, permissionIcon);
        for (MobileElement permission : permissionName) {
            if (permission.getText().equals("Camera")) {
                break;
            } else {
                cameraPermissionNumberInList++;
            }
        }
        log.info("Check if the permission to use the camera is disabled");
        Assert.assertEquals(cameraPermissionStatus.get(cameraPermissionNumberInList).getText(), "OFF");
        Assert.assertEquals(cameraPermissionSwitch.get(cameraPermissionNumberInList).getAttribute("checked"), "false");
        log.info("Permission on camera disabled.");
        return this;
    }

    @Step("Try to enable permission through gray switch.")
    public Permissions clickPermissionThroughSwitch() {
        log.info("Trying click to camera permission switch.");
        cameraPermissionSwitch.get(cameraPermissionNumberInList).click();
        return this;
    }

    @Step("Disable/Enable permission in displayed window.")
    public Permissions choosePermissionStatusInDisplayedWindow(boolean status) {
        if (status) {
            waitToVisibilityOf(5, AddFuelPurchase.acceptPermission);
            AddFuelPurchase.acceptPermission.click();
            log.info("Accept permission in displayed window.");
        } else {
            waitToVisibilityOf(5, AddFuelPurchase.denyPermission);
            AddFuelPurchase.denyPermission.click();
            log.info("Deny permission in displayed window.");
        }
        return this;
    }

}
