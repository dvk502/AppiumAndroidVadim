package logic.web.companyProfile;

import logic.init.BasePageWeb;
import logic.init.ListenersWeb;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@org.testng.annotations.Listeners(ListenersWeb.class)
public class General extends BasePageWeb {
    protected static final Logger log = Logger.getLogger(General.class);

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[1]/div/div/div[1]/company-profile/div/div[2]/div/cp-general-tab/div/div[2]/div[8]/div[2]/span")
    public WebElement usDotNumber;

    public static String usDot;

    public General takeUsDotNumber() {
        waitToVisibilityOf(5, usDotNumber);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        usDot = usDotNumber.getText();
        return this;
    }
}
