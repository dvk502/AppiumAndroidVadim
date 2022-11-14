package logic.hos.iftaPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import logic.hos.header.Header;

import logic.init.BasePage;
import logic.init.ChangePermissions;
import logic.init.LocatorName;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.IOException;
import java.util.Map;

public class AddFuelPurchase extends BasePage {
    protected static final Logger log = Logger.getLogger(AddFuelPurchase.class);

    @AndroidFindBy(id = projectLocator + ":id/spinner_activity_form_ifta_truck_number")
    public static MobileElement truckNumberChoose;
    @AndroidFindBy(id = projectLocator + ":id/spinner_activity_form_ifta_country")
    public static MobileElement countryChoose;
    @AndroidFindBy(id = projectLocator + ":id/spinner_activity_form_ifta_state")
    public static MobileElement stateChoose;
    @AndroidFindBy(id = projectLocator + ":id/spinner_activity_form_ifta_vendor")
    public static MobileElement vendorChoose;
    @AndroidFindBy(id = projectLocator + ":id/spinner_activity_form_ifta_fuel_type")
    public static MobileElement fuelTypeChoose;
    @AndroidFindBy(id = projectLocator + ":id/editText_activity_form_ifta_volume")
    public static MobileElement volumeInput;
    @AndroidFindBy(id = projectLocator + ":id/editText_activity_form_ifta_total_cost")
    public static MobileElement totalCostInput;
    @AndroidFindBy(id = projectLocator + ":id/editText_activity_form_ifta_cost_per_unit")
    public static MobileElement costPerUnitInput;
    @AndroidFindBy(id = projectLocator + ":id/textView_activity_form_ifta_receipt")
    public static MobileElement receiptImageButton;
    @AndroidFindBy(id = projectLocator + ":id/button_activity_form_ifta_confirm")
    public static MobileElement confirmAddIftaButton;
    @AndroidFindBy(id = projectLocator + ":id/dialog_image_picker_gallery")
    public static MobileElement galleryChooseImageButton;
    @AndroidFindBy(id = projectLocator + ":id/dialog_image_picker_camera")
    public static MobileElement cameraChooseImageButton;
    @AndroidFindBy(id = projectLocator + ":id/dialog_image_picker_scan")
    public static MobileElement scanImageButton;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
    public static MobileElement permissionMessage;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    public static MobileElement acceptPermission;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    public static MobileElement denyPermission;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button")
    public static MobileElement denyPermissionAndDontAsk;
    @AndroidFindBy(id = "android:id/message")
    public static MobileElement androidDenyPermissionMessage;
    @AndroidFindBy(xpath = "//*[@text='OK']")
    public static MobileElement closeAndroidMessage;
    @AndroidFindBy(id = "com.android.documentsui:id/app_icon")
    public static MobileElement galleryCheck;
    @AndroidFindBy(id = "com.android.settings:id/entity_header_title")
    public static MobileElement androidTitleApp;
    @AndroidFindBy(id = "com.google.android.documentsui:id/app_icon")
    public MobileElement androidGalleryIcon;
    @AndroidFindBy (id = "com.sec.android.gallery3d:id/smart_album_image")
    public MobileElement androidGalleryIconTrendy;
    @AndroidFindBy (id = "com.sec.android.app.camera:id/shutter_button")
    public MobileElement cameraIconShutter;


    LocatorName locatorName = LocatorName.getLocatorNameInstance();
    String revokeCam = "adb shell pm revoke com.trackensure.eld.debug android.permission.CAMERA";
    String grantCam = "adb shell pm grant com.trackensure.eld.debug android.permission.CAMERA";
    ChangePermissions changePermissions = new ChangePermissions();

    @Step("Adding information about fuel purchase.")
    public AddFuelPurchase inputDataFuel(String volume, String totalcost, String costPU) {
        Header header = new Header();
        waitToBeClickable(5, volumeInput);
        volumeInput.setValue(volume);
        log.info("Input Volume - " + volume);
        totalCostInput.setValue(totalcost);
        log.info("Input Total Cost - " + totalcost);
        costPerUnitInput.setValue(costPU);
        log.info("Input Cose per Unit - " + costPU);
        return this;
    }

    @Step("Check accept permission window.")
    public AddFuelPurchase checkAcceptPermission() {
        waitToBeClickable(5, receiptImageButton);
        receiptImageButton.click();
        waitToBeClickable(5, galleryChooseImageButton);
        galleryChooseImageButton.click();
        log.info("Try add Gallery receipt image");
        log.info("Check appear permission message.");
        Assert.assertEquals(permissionMessage.getText(), "Разрешить приложению " + eldName + " снимать фото и видео?");
        log.info("Permission message appear! Accept permission.");
        acceptPermission.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Waiting to open Android Gallery.");
        waitToVisibilityOf(5, locatorName.galleryWindow);
        if (isElementPresent(2, locatorName.galleryWindow)) {
            log.info("Android Gallery appear!");
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            waitToBeClickable(3, galleryChooseImageButton);
//            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        }
        log.info("Try add camera receipt image");
        try {
            Runtime.getRuntime().exec(revokeCam);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*waitToVisibilityOf(5, cameraChooseImageButton);
        cameraChooseImageButton.click();
        waitToVisibilityOf(5,cameraIconShutter);
        if (isElementPresent(2, cameraIconShutter)) {
            log.info("Android Camera appear!");
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            waitToBeClickable(3, cameraChooseImageButton);
//            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        }*/
        return this;
    }

    @Step("Check deny permission window.")
    public AddFuelPurchase checkDenyPermissionCamera() {
        waitToBeClickable(5, receiptImageButton);
        receiptImageButton.click();
        waitToBeClickable(5, cameraChooseImageButton);
        cameraChooseImageButton.click();
        log.info("Check appear permission message.");
        Assert.assertEquals(permissionMessage.getText(), "Разрешить приложению " + eldName + " снимать фото и видео?");
        log.info("Permission message appear! Deny permission.");
        waitToBeClickable(5, denyPermissionAndDontAsk);
        denyPermissionAndDontAsk.click();
        Assert.assertEquals(androidDenyPermissionMessage.getText(), "Photo Gallery Access Denied");
        log.info("Deny permission message appear! Impossible to load photo from camera");
        closeAndroidMessage.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Waiting to open Android Window with settings app.");
        waitToBeClickable(5, androidTitleApp);
        if(isElementPresent(2, androidTitleApp)) {
            log.info("Android window with settings appear!");
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            waitToBeClickable(3, galleryChooseImageButton);
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        }
        return this;
    }

    @Step("Check deny permission window.")
    public AddFuelPurchase checkDenyPermissionGallery() {
        galleryChooseImageButton.click();
        log.info("Try add Gallery receipt image");
        log.info("Check appear permission message.");
        Assert.assertEquals(permissionMessage.getText(), "Разрешить приложению " + eldName + " снимать фото и видео?");
        log.info("Permission message appear! Deny permission.");
        denyPermissionAndDontAsk.click();
        Assert.assertEquals(androidDenyPermissionMessage.getText(), "Photo Gallery Access Denied");
        log.info("Deny permission message appear! Impossible to load photo from camera");
        closeAndroidMessage.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Waiting to open Android Window with settings app.");
        waitToBeClickable(5, androidTitleApp);
        if(isElementPresent(2, androidTitleApp)) {
            log.info("Android window with settings appear!");
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        }
        return this;
    }
}
