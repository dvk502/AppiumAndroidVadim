package logic.loginPage;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.qameta.allure.Step;

import logic.init.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

public class CheckPass extends BasePage {

    protected static final Logger log = Logger.getLogger(CheckPass.class);

    LoginPage lp = new LoginPage();

    @AndroidFindBy(id = projectLocator + ":id/show_password_button")
    public MobileElement showPassBtn;

    @Step("Input Credentials.")
    public CheckPass inputCredentials() {
        waitToVisibilityOf(10, lp.loginField);
        waitToBeClickable(10, lp.loginField);
        lp.loginField.sendKeys("statustest1");
        lp.passField.sendKeys("test12345");
        log.info("Login Current Driver!");
        int a = 0;
        return this;
    }

    @Step("Show password in field.")
    public CheckPass showPass() {
        log.info("Making the password visible!");
        waitToVisibilityOf(10, showPassBtn);
        waitToBeClickable(10, showPassBtn);
        int cordsX = showPassBtn.getCenter().getX();
        int cordsY = showPassBtn.getCenter().getY();
        tapPoints(cordsX, cordsY);
        return this;
    }

    @Step("Compare passwords.")
    public CheckPass comparePass() {
        log.info("Checking the entered password with the displayed!");
        String inputPass = lp.passField.getText();
        if (inputPass.equals("test12345")) {
            log.info("The entered password matches the displayed one! Password entered: test12345. Displayed password: " + inputPass);
        } else {
            String displayedPass = lp.passField.getText();
            log.info("The entered password does not match the displayed one! Password entered: test12345. Displayed password: " + displayedPass);
            driver.executeScript("client:client.setTestStatus(false)");
        }
        return this;
    }

}
