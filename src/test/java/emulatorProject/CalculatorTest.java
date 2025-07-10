package emulatorProject;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DriverFactory;
import pages.ApiDemosPage;
import pages.TouchPaintPage;
import pages.PreferenceFromCodePage;

public class CalculatorTest {
    DriverFactory driverFactory = new DriverFactory();
    AndroidDriver driver;

    @BeforeMethod
    public void setUp() {
        try {
            driverFactory.deviceCapabilities();
            driver = driverFactory.getDriver();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Driver initialization failed: " + e.getMessage());
        }
    }

    @Test
    public void test() {
        ApiDemosPage apiDemos = new ApiDemosPage(driver);
        TouchPaintPage touchPaint = new TouchPaintPage(driver);
        PreferenceFromCodePage preferencesFromCode = new PreferenceFromCodePage(driver);
        apiDemos.selectGraphics();
        touchPaint.scrollToDown();
        touchPaint.touchPaint();
        touchPaint.zoomIn();
        touchPaint.zoomOut();
        touchPaint.goToBackPage(2);
        apiDemos.selectPreferences();
        preferencesFromCode.selectPreferencesFromCode();
        preferencesFromCode.clickOnEditTextPreference();
        preferencesFromCode.clickOnEnterYourFavoriteAnimalField();
        preferencesFromCode.clickOnOKButton();
        preferencesFromCode.clikOnSwitchPreferenceToggleButton();
    }
}
