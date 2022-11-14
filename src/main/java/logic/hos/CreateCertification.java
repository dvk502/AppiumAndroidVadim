package logic.hos;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import logic.init.BasePage;
import org.apache.log4j.Logger;

public class CreateCertification extends BasePage {

    protected static final Logger log = Logger.getLogger(CreateCertification.class);


    @AndroidFindBy(id = projectLocator + ":id/events_certification")
    public MobileElement certificationLine;

}
