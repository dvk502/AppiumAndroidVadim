package logic.hos.coDriverPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;

import logic.init.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

public class CoDriverPage extends BasePage {

    protected static final Logger log = Logger.getLogger(CoDriverPage.class);

    @AndroidFindBy(id = projectLocator + ":id/team_switch_button")
    public MobileElement switchActiveDriver;
    @AndroidFindBy(accessibility = "Navigate up")
    public MobileElement backToMainMenuBtn;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_right_button")
    public MobileElement confirmSwapBtn;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_msg_message")
    public MobileElement checkAlertBlock;
    @AndroidFindBy(id = projectLocator + ":id/dialog_alert_msg_ok")
    public MobileElement confirmAlertMsg;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView[2]")
    public MobileElement openCoDriverPage;
    @AndroidFindBy(id = projectLocator + ":id/co_driver_icon")
    public MobileElement openCoDriverLogin;
    @AndroidFindBy(id = projectLocator + ":id/login_name")
    public MobileElement loginField;
    @AndroidFindBy(id = projectLocator + ":id/login_password")
    public MobileElement passField;
    @AndroidFindBy(id = projectLocator + ":id/login_button")
    public MobileElement loginButton;
    @AndroidFindBy(id = projectLocator + ":id/driver_icon")
    public MobileElement chooseCurrentDriver;
    @AndroidFindBy(id = projectLocator + ":id/co_driver_ds_status")
    public MobileElement coDriverStatus;


    @Step("Open co-drivers logbook")
    public CoDriverPage openCoDriversLogBook() {
        waitToVisibilityOf(5, coDriverStatus);
        coDriverStatus.click();
        //Assert.assertEquals(checkAlertBlock.getText(), "Show co-driver's logbook?");
        //confirmSwapBtn.click();
        return this;
    }

    @Step("Back to the main menu.")
    public CoDriverPage goToMainMenu() {
        if (isElementPresent(1, backToMainMenuBtn)) {
            backToMainMenuBtn.click();
            log.info("We are trying to return to the main menu.");
            try {
                waitToVisibilityOf(5, driver.findElement(By.id(projectLocator + ":id/driver_toolbar_flag")));
                log.info("We are back to the main menu.");
                return this;
            } catch (TimeoutException | NoSuchElementException e) {
                if (driver.currentActivity().equals("eld.trackensure.activityforms.teamswitch.TeamSwitchActivity")) {
                    backToMainMenuBtn.click();
                    return goToMainMenu();
                }
            }
        }
        return this;
    }

    @Step("Opening the page with the addition of Co-Driver.")
    public CoDriverPage coDriverOpenLoginPage() {
        waitToVisibilityOf(20, openCoDriverLogin);
        waitToBeClickable(20, openCoDriverLogin);
        openCoDriverLogin.click();
        log.info("Opening the page with the addition of Co-Driver.");
        return this;
    }

    @Step("Scrolling the page hoping to find the right button.")
    public CoDriverPage moveToCoDriver() {
        waitToVisibilityOf(10, backToMainMenuBtn);
        waitToBeClickable(10, backToMainMenuBtn);
        if (driver.getOrientation().toString().equals("Portrait")) {
            new TouchAction(driver).press(PointOption.point(13, 725)).moveTo(PointOption.point(13, 121)).release().perform(); // СКРОЛЛ ВКЛЮЧАЕМ ЕСЛИ ПЕРЕВЕРНУТ ПЛАНШЕТ
        }
        log.info("Scrolling the page hoping to find the right button.");
        return this;
    }

    @Step("Co-Driver authorization (Login and password).")
    public CoDriverPage coDriverLogin(String login, String pass) {
        waitToVisibilityOf(10, loginField);
        waitToBeClickable(10, loginField);
        loginField.sendKeys(login);
        passField.sendKeys(pass);
        loginButton.click();
        log.info("Co-Driver authorization. Login: " + login + ". Password: " + pass + "");
        return this;
    }

    @Step("Co-Driver authorization from another organization.")
    public CoDriverPage loginCoDriverFromOG(String login, String pass) {
        waitToVisibilityOf(10, loginField);
        waitToBeClickable(10, loginField);
        loginField.sendKeys(login);
        passField.sendKeys(pass);
        loginButton.click();
        log.info("Co-Driver authorization from another organization. Login: " + login + ". Password: " + pass + "");
        return this;
    }

    @Step("We check the display of a pop-up window about the prohibition of authorization of Co-Driver from another organization.")
    public CoDriverPage checkTextFromAlert() {
        waitToVisibilityOf(10, checkAlertBlock);
        log.info("We check the display of a pop-up window about the prohibition of authorization of Co-Driver from another organization.");
        Assert.assertEquals(checkAlertBlock.getText(), "The co-driver is part of a different company. This is not allowed for team driving.");
        confirmAlertMsg.click();
        log.info("The pop-up window about the prohibition of authorization of Co-Driver from another organization is displayed correctly.");
        return this;
    }

    //
    @Step("Checking the display of a warning about adding a co-driver without the Internet.")
    public CoDriverPage checkTextFromAlertConnection() {
        waitToVisibilityOf(10, checkAlertBlock);
        log.info("Checking the display of a warning about adding a co-driver without the Internet.");
        Assert.assertEquals(checkAlertBlock.getText(), "There is no internet connection");
        confirmAlertMsg.click();
        log.info("The warning window about adding a co-driver without the Internet was displayed correctly.");
        return this;
    }

    @Step("Swap the Current Driver and Co-Driver.")
    public CoDriverPage switchDriver() {
        waitToVisibilityOf(10, switchActiveDriver);
        waitToBeClickable(10, switchActiveDriver);
        switchActiveDriver.click();
        log.info("Swap the Current Driver and Co-Driver.");
        return this;
    }

    @Step("We confirm the swap of drivers.")
    public CoDriverPage confirmSwapDrivers() {
        waitToVisibilityOf(10, confirmSwapBtn);
        waitToBeClickable(10, confirmSwapBtn);
        confirmSwapBtn.click();
        log.info("We confirm the swap of drivers.");
        return this;
    }

    @Step("Selecting the current driver on the Co-Driver page.")
    public CoDriverPage chooseCurrentDriver() {
        waitToVisibilityOf(10, chooseCurrentDriver);
        waitToBeClickable(10, chooseCurrentDriver);
        chooseCurrentDriver.click();
        log.info("Current driver selected.");
        return this;
    }
}