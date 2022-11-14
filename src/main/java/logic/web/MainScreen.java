package logic.web;

import logic.init.BasePageWeb;
import logic.init.ListenersWeb;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@org.testng.annotations.Listeners(ListenersWeb.class)
public class MainScreen extends BasePageWeb{
    protected static final Logger log = Logger.getLogger(MainScreen.class);

    @FindBy(css = "div[ng-click=\"['dispatcher', 'dispatcher TL'].includes(vm.currentUserType) ? vm.replaceLocation('customers') : vm.goToState('customers')\"]")
    public WebElement customersButton;
    @FindBy(css = "button[ng-disabled=\"vm.isSearching\"]")
    public WebElement search;


    public MainScreen openCustomers() {
        waitToVisibilityOfClick(10, customersButton);
        customersButton.click();
        log.info("Web: Open the section Customers");
        if (!isElementPresent(2, search)) {
            return openCustomers();
        } else {
            return this;
        }
    }
}
