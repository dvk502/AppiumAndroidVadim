package logic.init;

import io.appium.java_client.MobileElement;
import logic.fleet.CreateTruck;
import logic.hos.dvirPage.AddInspectionReport;
import logic.hos.header.Header;
import logic.hos.iftaPage.AddFuelPurchase;
import logic.loginPage.RegistrationPage;

public class LocatorName extends BasePage {

    public static class LocatorNameHolder {
        private static final LocatorName LOCATOR_NAME = new LocatorName();
    }

    public static LocatorName getLocatorNameInstance() {
        return LocatorNameHolder.LOCATOR_NAME;
    }

    RegistrationPage registrationPage = new RegistrationPage();
    CreateTruck createTruck = new CreateTruck();
    AddFuelPurchase fuel = new AddFuelPurchase();
    Header header = new Header();
    AddInspectionReport addIr = new AddInspectionReport();

    public MobileElement p1;
    public MobileElement firstTruck;
    public MobileElement pplocator1;
    public MobileElement pplocator2;
    public MobileElement pplocator3;
    public MobileElement galleryWindow;
    public MobileElement dotButton;
    public MobileElement inspectionReportToolbar;
    public MobileElement statusBtn;
    public MobileElement logsButton;

    private LocatorName() {
        switch (projectName) {
            case "TE":
                log.info("Choose locators for TE.");
                pplocator1 = registrationPage.secondPageSecondTextBox;
                pplocator2 = registrationPage.firstTextBox;
                pplocator3 = registrationPage.secondTextBox;
                firstTruck = createTruck.firstTruck;
                galleryWindow = fuel.androidGalleryIcon;
                dotButton = header.dotInspectBtn;
                inspectionReportToolbar = addIr.addInspectionReportToolbar;
                statusBtn = header.statusBtn;
                logsButton = header.logsBtn;
                break;
            case "Swift":
                log.info("Choose locators for Swift.");
                pplocator1 = registrationPage.secondPageSecondTextBoxV2;
                pplocator2 = registrationPage.firstTextBox;
                pplocator3 = registrationPage.secondTextBox;
                firstTruck = createTruck.firstTruckSwift;
                galleryWindow = fuel.androidGalleryIcon;
                dotButton = header.dotInspectBtn;
                inspectionReportToolbar = addIr.addInspectionReportToolbar;
                statusBtn = header.statusBtn;
                logsButton = header.logsBtn;
                break;
            case "Alfa":
                log.info("Choose locators for Alfa.");
                pplocator1 = registrationPage.secondPageSecondTextBox;
                pplocator2 = registrationPage.firstTextBoxAlpha;
                pplocator3 = registrationPage.secondTextBoxAlpha;
                firstTruck = createTruck.firstTruckAlfa;
                galleryWindow = fuel.androidGalleryIconTrendy;
                dotButton = header.dotInspectBtnTrendy;
                inspectionReportToolbar = addIr.addInspectionReportToolbar;
                statusBtn = header.statusBtn;
                logsButton = header.logsBtn;
                break;
            case "Vista":
                log.info("Choose locators for Vista.");
                pplocator1 = registrationPage.secondPageSecondTextBox;
                pplocator2 = registrationPage.firstTextBoxAlpha;
                pplocator3 = registrationPage.secondTextBoxAlpha;
                firstTruck = createTruck.firstTruck;
                galleryWindow = fuel.androidGalleryIconTrendy;
                dotButton = header.dotInspectBtnTrendy;
                inspectionReportToolbar = addIr.iRToolbarTrendy;
                statusBtn = header.statusBtn;
                logsButton = header.logsBtn;
                break;
            case "Smart":
                log.info("Choose locators for Smart.");
                pplocator1 = registrationPage.secondPageSecondTextBox;
                pplocator2 = registrationPage.firstTextBoxAlpha;
                pplocator3 = registrationPage.secondTextBoxAlpha;
                firstTruck = createTruck.firstTruck;
                galleryWindow = fuel.androidGalleryIconTrendy;
                dotButton = header.dotInspectBtnSmart;
                inspectionReportToolbar = addIr.addInspectionReportToolbar;
                statusBtn = header.statusBtnSmart;
                logsButton = header.logsBtnSmart;
                break;
            case "Trendy":
                log.info("Choose locators for Trendy.");
                pplocator1 = registrationPage.secondPageSecondTextBox;
                pplocator2 = registrationPage.firstTextBox;
                pplocator3 = registrationPage.secondTextBox;
                firstTruck = createTruck.firstTruck;
                galleryWindow = fuel.androidGalleryIconTrendy;
                dotButton = header.dotInspectBtnTrendy;
                inspectionReportToolbar = addIr.iRToolbarTrendy;
                statusBtn = header.statusBtn;
                logsButton = header.logsBtn;
                break;
            case "Sharp":
                log.info("Choose locators for Sharp.");
                pplocator1 = registrationPage.secondPageSecondTextBox;
                pplocator2 = registrationPage.firstTextBox;
                pplocator3 = registrationPage.secondTextBox;
                firstTruck = createTruck.firstTruck;
                galleryWindow = fuel.androidGalleryIconTrendy;
                dotButton = header.dotInspectBtnTrendy;
                inspectionReportToolbar = addIr.addInspectionReportToolbar;
                statusBtn = header.statusBtn;
                logsButton = header.logsBtn;
                break;
        }
    }
}
