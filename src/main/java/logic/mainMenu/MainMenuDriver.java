package logic.mainMenu;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

import logic.init.BasePage;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MainMenuDriver extends BasePage {

    protected static final Logger log = Logger.getLogger(MainMenuDriver.class);

    @AndroidFindBy(id = projectLocator + ":id/nav_driver_hos")
    public MobileElement hosBtn;
    @AndroidFindBy(id = projectLocator + ":id/nav_driver_inspection_reports")
    public MobileElement dvirBtn;
    @AndroidFindBy(id = projectLocator + ":id/nav_driver_ifta")
    public MobileElement iftaBtn;
    @AndroidFindBy(id = projectLocator + ":id/nav_driver_settings")
    public MobileElement settingsBtn;
    @AndroidFindBy(id = projectLocator + ":id/nav_driver_truck_settings")
    public MobileElement truckSettingsBtn;
    @AndroidFindBy(id = projectLocator + ":id/nav_docs")
    public MobileElement documentsBtn;
    @AndroidFindBy(id = projectLocator + ":id/nav_contact_support")
    public MobileElement contactSupportBtn;
    @AndroidFindBy(id = projectLocator + ":id/nav_logout")
    public MobileElement logoutBtn;
    @AndroidFindBy(id = projectLocator + ":id/nav_logout")
    public MobileElement logoutBtnFleet;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[10]/android.widget.CheckedTextView")
    public MobileElement logoutBtnXpath;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[9]/android.widget.CheckedTextView")
    public MobileElement logoutBtnXpath2;

    @AndroidFindBy(id = projectLocator + ":id/design_menu_item_text")
    public List<MobileElement> menuButtons;

    @Step("Open HOS page.")
    public MainMenuDriver openHos() {
        waitToVisibilityOf(20, hosBtn);
        waitToBeClickable(20, hosBtn);
        hosBtn.click();
        log.info("Open HOS page.");
        return this;
    }

    @Step("Open DVIR page.")
    public MainMenuDriver openDvir() {
        waitToVisibilityOf(20, dvirBtn);
        waitToBeClickable(20, dvirBtn);
        dvirBtn.click();
        log.info("Open DVIR page.");
        return this;
    }

    @Step("Open IFTA page.")
    public MainMenuDriver openIfta() {
        waitToVisibilityOf(20, iftaBtn);
        waitToBeClickable(20, iftaBtn);
        iftaBtn.click();
        log.info("Open IFTA page.");
        return this;
    }

    @Step("Open Settings page.")
    public MainMenuDriver openSettings() {
        waitToVisibilityOf(20, settingsBtn);
        waitToBeClickable(20, settingsBtn);
        settingsBtn.click();
        log.info("Open Settings page.");
        return this;
    }

    @Step("Open Truck settings page.")
    public MainMenuDriver openTruckSettings() {
        waitToVisibilityOf(20, truckSettingsBtn);
        waitToBeClickable(20, truckSettingsBtn);
        truckSettingsBtn.click();
        log.info("Open Truck settings page.");
        return this;
    }

    @Step("Open Contact Support page.")
    public MainMenuDriver openContactSupport() {
        waitToVisibilityOf(20, contactSupportBtn);
        waitToBeClickable(20, contactSupportBtn);
        contactSupportBtn.click();
        log.info("Open Contact Support page.");
        return this;
    }

    public ArrayList<String> buttons = new ArrayList<>();
    @Step("Logout driver.")
    public MainMenuDriver logout() {
        for (MobileElement button : menuButtons) {
            log.info("Text in button: " +button.getText());
            if(button.getText().equals("LOGOUT")) {
                waitToBeClickable(5, button);
                button.click();
            }
        }
        /*waitToVisibilityOf(20, logoutBtn);
        waitToBeClickable(20, logoutBtn);
        logoutBtn.click();*/
        return this;
    }
}
