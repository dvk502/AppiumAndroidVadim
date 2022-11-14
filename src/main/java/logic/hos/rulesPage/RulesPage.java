package logic.hos.rulesPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

import logic.init.BasePage;
import org.apache.log4j.Logger;

public class RulesPage extends BasePage {

    protected static final Logger log = Logger.getLogger(RulesPage.class);

    @AndroidFindBy(id = "android:id/text1")
    public MobileElement currentRules;
    @AndroidFindBy(id = projectLocator + ":id/spinner_fragment_screen_rules_country")
    public MobileElement currentRulesSpinner;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    public MobileElement chooseCanRules;
    @AndroidFindBy(id = projectLocator + ":id/button_fragment_screen_rules_cycle_hours")
    public MobileElement openCycleHoursPage;

    public static String countryP;

    @Step("Checking the current rules.")
    public RulesPage checkCountry() {
        waitToVisibilityOf(10, currentRules);
        waitToBeClickable(10, currentRules);
            currentRules.getText();
            countryP = currentRules.getText();
            log.info("Current Rules: " + countryP);
            return this;
    }

    @Step("Open Spinner Current Rule")
    public RulesPage changeRules() {
        waitToVisibilityOf(10, currentRules);
        waitToBeClickable(10, currentRules);
        currentRules.click();
        log.info("Open spinner Current Rules.");
        return this;
    }

    @Step("Choose CAN rules")
    public RulesPage chooseCan() {
        waitToVisibilityOf(10, chooseCanRules);
        waitToBeClickable(10, chooseCanRules);
        chooseCanRules.click();
        log.info("Choose Canada Rules in Spinner");
        return this;
    }

    @Step("Open View Cycle Hours Page")
    public void openCycleHours() {
        waitToVisibilityOf(10, openCycleHoursPage);
        waitToBeClickable(10, openCycleHoursPage);
        openCycleHoursPage.click();
        log.info("Open View Cycle Hours page.");
    }
}

