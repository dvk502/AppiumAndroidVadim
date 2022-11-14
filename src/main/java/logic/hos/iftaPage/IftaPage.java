package logic.hos.iftaPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

import logic.init.BasePage;
import org.apache.log4j.Logger;

public class IftaPage extends BasePage {
    protected static final Logger log = Logger.getLogger(IftaPage.class);

    @AndroidFindBy (id = projectLocator + ":id/ifta_date_arrow_left")
    public static MobileElement dateLeft;
    @AndroidFindBy (id = projectLocator + ":id/ifta_date_arrow_right")
    public static MobileElement dateRight;
    @AndroidFindBy (id = projectLocator + ":id/ifta_date")
    public static MobileElement iftaDate;
    @AndroidFindBy (xpath = "//*[@text='Add Fuel Purchase']")
    public static MobileElement addIfta;

    @Step("Add new Fuel Purchase")
    public IftaPage addFuel() {
        waitToVisibilityOf(5, addIfta);
        addIfta.click();
        log.info("Add new Fuel Purchase.");
        return this;
    }
}
