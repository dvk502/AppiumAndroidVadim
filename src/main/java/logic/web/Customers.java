package logic.web;

import logic.init.BasePageWeb;
import logic.init.ListenersWeb;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@org.testng.annotations.Listeners(ListenersWeb.class)
public class Customers extends BasePageWeb{
    protected static final Logger log = Logger.getLogger(Customers.class);

    @FindBy(css = "input[placeholder=\"Organization\"]")
    private WebElement orgName;
    @FindBy(css = "i[class ='fa fa-sign-in fa-icon-size")
    private WebElement loginOrgTestCompany;
    @FindBy (css = "button[ng-click='vm.searchOrganizations()']")
    private WebElement searchButton;
    @FindBy(xpath = "/html/body/admin-view/div/div/div/ui-view/customers/div/div/div[2]/div/div[1]/div/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div[5]/div/p")
    private WebElement companyName;

    public static String carrier;

    public Customers findOrganization(String orgname) {
        waitToVisibilityOfClick(10, orgName);
        orgName.sendKeys(orgname);
        waitToVisibilityOfClick(5, searchButton);
        searchButton.click();
        log.info("Web: Input organization credentials.");
        return this;
    }

    public void openTestCompany() {
        waitToVisibilityOfClick(10, loginOrgTestCompany);
        log.info("Web: Open the found organization: "+ companyName.getText()+ ".");
        carrier = companyName.getText();
        loginOrgTestCompany.click();
    }
}
