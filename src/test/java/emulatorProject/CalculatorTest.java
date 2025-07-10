package emulatorProject;
import io.appium.java_client.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DriverFactory;
import pages.ApiDemosPage;
import pages.TouchPaintPage;
import pages.PreferenceFromCodePage;

public class CalculatorTest {

    static AppiumDriver driver;

    @BeforeMethod
    public void setUp() {
        try {
            DriverFactory driverFactory = new DriverFactory();
            driverFactory.deviceCapabilities();
            driver = driverFactory.getDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @After
    public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}

}
