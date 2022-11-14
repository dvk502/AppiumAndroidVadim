package logic.web;

import io.qameta.allure.Step;
import logic.init.BasePage;
import logic.init.BasePageWeb;
import logic.init.ChromeWebDriver;
import logic.init.ListenersWeb;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@org.testng.annotations.Listeners(ListenersWeb.class)
public class LoginPageWeb extends BasePageWeb {

    protected static final Logger log = Logger.getLogger(LoginPageWeb.class);

    @FindBy(id = "email")
    public WebElement inputEmail;
    @FindBy(id = "password")
    public WebElement inputPassword;
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/form/input[5]")
    private WebElement btnSubmitLogin;
    @FindBy(css = "a[onclick=\"localStorage.removeItem('promotionCode'); window.location.href = '../logout.do?actionName=logout';\"]")
    public WebElement logoutButtonInCompany;
    @FindBy(css = "button[ng-click=\"vm.openModalAndLogout()\"]")
    public WebElement logoutButtonOutOfCompany;
    @FindBy(xpath = "/html/body/nav/div/div[2]/ul/li[4]")
    public WebElement clickLogin;
    @FindBy(css = "i[class=\"fa fa-bell fa-4x\"]")
    public WebElement bell;
    @FindBy(css = "[href='http://10.10.1.93:8080/TrackEnsure/login.do']")
    private WebElement loginButton;


    @Step("Логинимся на Веб под админкой (5:test)")
    public LoginPageWeb loginOnWeb(String login, String password) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get(BasePage.webAddressLogin);
        log.info("Web: Follow the link: " + BasePage.webAddressLogin);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (isElementPresent(1, logoutButtonInCompany)) {
            waitToVisibilityOfClick(4, logoutButtonInCompany);
            logoutButtonInCompany.click();
            log.info("Web: Logout of the company.");
//            waitToVisibilityOfClick(5, loginButton);
//            loginButton.click();

        }
        if (isElementPresent(1, logoutButtonOutOfCompany)) {
            waitToVisibilityOfClick(4, logoutButtonOutOfCompany);
            logoutButtonOutOfCompany.click();
            log.info("Web: Logout of the account web.");
//            waitToVisibilityOfClick(5, loginButton);
//            loginButton.click();
        }
        if (isElementPresent(3, bell)) {
            while (isElementPresent(1, bell)) {
                loginButton.click();
                log.info("Web: Click to Login Button.");
            }
        }
        waitToVisibilityOfClick(5, inputEmail);
        inputEmail.sendKeys(login);
        log.info("Web: Input email - " + login + " - on web.");
        waitToVisibilityOfClick(5, inputPassword);
        inputPassword.sendKeys(password);
        log.info("Web: Input password - " + password + " - on web.");
        waitToVisibilityOfClick(5, btnSubmitLogin);
        btnSubmitLogin.click();
        log.info("Web: Click to login button on web.");
        return this;
    }
}


