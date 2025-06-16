package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;
import locators.ApiDemosLocators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;
import java.io.ByteArrayInputStream;

public class ApiDemosPage {
    static AppiumDriver driver;
    public ApiDemosPage(AppiumDriver driver) {
        this.driver = driver;
    }

     public void selectGraphics() {
        MobileElement graphicsMenu = (MobileElement) new WebDriverWait(driver, 60)
                .until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(ApiDemosLocators.GRAPHICS_TEXT_FROM_MENU)));
        graphicsMenu.click();
         Allure.addAttachment("Click on Graphics Menu", new ByteArrayInputStream(DriverFactory.screenshotUtils(driver, "GraphicsMenu")));
     }
        //Select 'Preferences' from hamburger
        public void selectPreferences() {
        MobileElement preferences = (MobileElement) new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(ApiDemosLocators.PREFERENCE_FROM_MENU)));
        preferences.click();
        Allure.addAttachment("Click on Preferences Menu", new ByteArrayInputStream(DriverFactory.screenshotUtils(driver, "PreferencesMenu")));
    }


}