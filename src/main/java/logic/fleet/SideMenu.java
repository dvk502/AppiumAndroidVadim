package logic.fleet;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

import logic.init.BasePage;
import org.apache.log4j.Logger;

public class SideMenu extends BasePage {
    protected static final Logger log = Logger.getLogger(SideMenu.class);

    @AndroidFindBy(id = projectLocator + ":id/nav_fleet_manager_company_profile")
    public MobileElement companyProfileButton;
    @AndroidFindBy(id = projectLocator + ":id/nav_fleet_manager_drivers")
    public MobileElement driversButton;
    @AndroidFindBy(id = projectLocator + ":id/nav_msg")
    public MobileElement messagesButton;
    @AndroidFindBy(id = projectLocator + ":id/nav_trucks")
    public MobileElement trucksButton;
    @AndroidFindBy(id = projectLocator + ":id/nav_contact_support")
    public MobileElement contactSupportButton;
    @AndroidFindBy(id = projectLocator + ":id/nav_logout")
    public MobileElement logoutButton;

    @Step ("Try find Company profile button in side menu fleet")
    public SideMenu findCompanyProfile() {
        log.info("Try find Company profile button in side menu fleet.");
        waitToVisibilityOf(5, companyProfileButton);
        companyProfileButton.isDisplayed();
        log.info("Company profile button found!");
        return this;
    }

    @Step ("Try find Drivers button in side menu fleet")
    public SideMenu findDrivers() {
        log.info("Try find Drivers button in side menu fleet.");
        driversButton.isDisplayed();
        log.info("Drivers button found!");
        return this;
    }

    @Step ("Try find Trucks button in side menu fleet")
    public SideMenu findTrucks() {
        log.info("Try find Trucks button in side menu fleet.");
        trucksButton.isDisplayed();
        log.info("Trucks button found!");
        return this;
    }

    @Step ("Try find Contact Support button in side menu fleet")
    public SideMenu findContactSupport() {
        log.info("Try find Contact Support button in side menu fleet.");
        contactSupportButton.isDisplayed();
        log.info("Contact support button found!");
        return this;
    }

    @Step ("Try find Logout button in side menu fleet")
    public SideMenu findLogoutButton() {
        log.info("Try find Logout button in side menu fleet.");
        logoutButton.isDisplayed();
        log.info("Logout Button found!");
        return this;
    }
}
