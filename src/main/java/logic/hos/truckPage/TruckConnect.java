package logic.hos.truckPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

import logic.init.BasePage;
import logic.init.DateUtil;
import org.apache.log4j.Logger;

import java.util.Date;

import static org.testng.Assert.assertTrue;

public class TruckConnect extends BasePage {

    protected static final Logger log = Logger.getLogger(TruckConnect.class);

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
    public MobileElement truckChooseConnect;
    @AndroidFindBy(id = projectLocator + ":id/loading_msg")
    public MobileElement windowTruckConnect;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    public MobileElement truckNumberElement;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView[2]")
    public MobileElement pt30NumberElement;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView")
    public MobileElement nearbyTrucks;

    private Date startOfChooseTruck;
    private int countClearingTimer;
    DateUtil dateUtil = new DateUtil();

    @Step("Connected to the truck (recursion is possible when connecting to a track)")
    public TruckConnect chooseTruck() {
        if (countClearingTimer == 1) {
            startOfChooseTruck=null;
            countClearingTimer=0;
        }
        try {
            if (this.startOfChooseTruck == null) {
                this.startOfChooseTruck = new Date();
                log.info(startOfChooseTruck);
            }
            if (new Date().after(dateUtil.getDateByDeltaSecond(this.startOfChooseTruck, 30))) {
                log.warn("Timeout found truck! Truck's not found.");
                assertTrue(false);
            }
            if (driver.currentActivity().equals("eld.trackensure.activityforms.host.HostActivity") && (nearbyTrucks.getText().equals("Nearby trucks not found"))) {
                    log.warn("Waiting for the tracks to appear");
                    this.chooseTruck();
                }else {
                    log.info("Trucks appear!");
                    countClearingTimer++;
                    return this;
                }
            }
        catch (Exception e) {

        }
        return this;
    }

    @Step("Try connect to truck!")
    public TruckConnect connectTruck() {
        try {
            log.info("Try connect to truck!");
            String truckNumber = truckNumberElement.getText();
            String pt30Number = pt30NumberElement.getText();
            while (!isElementPresent(1, windowTruckConnect)) {
                truckChooseConnect.click();
            }
            log.info("We clicking and trying connect! Truck number: "+truckNumber+ " PT30 Number: "+pt30Number);
                if (windowTruckConnect.getText().equalsIgnoreCase("Connecting to Truck")) {
                    log.info("Connect to truck! Truck number: "+truckNumber+ " PT30 Number: "+pt30Number);
                    return this;
                } else {
                    log.info("Can't connect to truck. Try again.");
                    return connectTruck();
                }
        } catch (Exception e) {
            log.info("Truck's not found!");
        }
        return this;
    }
}