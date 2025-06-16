package pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.PreferenceFromCodeLocators;
import utils.DriverFactory;

import java.io.ByteArrayInputStream;

public class PreferenceFromCodePage {
    AppiumDriver driver;

    public PreferenceFromCodePage(AppiumDriver driver) {
        this.driver = driver;
    }

    //Select 'Preferences from code' from hamburger
    public void selectPreferencesFromCode() {
        MobileElement preferencesFromCode = (MobileElement) new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(PreferenceFromCodeLocators.PREFERENCES_FROM_CODE_TEXT_FROM_MENU)));
        preferencesFromCode.click();
        Allure.addAttachment("Select Preferences from Code", new ByteArrayInputStream(DriverFactory.screenshotUtils(driver, "PreferencesFromCodeMenu")));
    }

    //Click on 'Edit Text Preference' menu from hamburger
    public void clickOnEditTextPreference() {
        MobileElement editTextPreferences = (MobileElement) new WebDriverWait(driver, 60)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(PreferenceFromCodeLocators.EDIT_TEXT_PREFERENCES)));
        editTextPreferences.click();
        Allure.addAttachment("Click on Edit Text Preference", new ByteArrayInputStream(DriverFactory.screenshotUtils(driver, "EditTextPreference")));
    }

    //Click on 'Enter Your Favorite animal' field
    public void clickOnEnterYourFavoriteAnimalField() {
        MobileElement enterYourFavoriteAnimal = (MobileElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(PreferenceFromCodeLocators.ENTER_YOUR_FAVOURITEANIMAL_FIELD)));
        enterYourFavoriteAnimal.click();
        enterYourFavoriteAnimal.sendKeys("Dog");
        Allure.addAttachment("Enter value in favourite animal field", new ByteArrayInputStream(DriverFactory.screenshotUtils(driver, "EnterYourFavoriteAnimalField")));
    }

    //Click on OK button from 'Enter your favorite animal' popup
    public void clickOnOKButton() {
        MobileElement okButton = (MobileElement) new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(PreferenceFromCodeLocators.OK_BUTTON)));
        okButton.click();
        Allure.addAttachment("Click on OK button", new ByteArrayInputStream(DriverFactory.screenshotUtils(driver, "OKButton")));
    }

    //Toggle 'Switch Preferences'
    public void clikOnSwitchPreferenceToggleButton() {
        MobileElement switchPreference = (MobileElement) new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(PreferenceFromCodeLocators.SWITCHPREFERENCES_TOGGLEBUTTON)));
        switchPreference.click();
        Allure.addAttachment("Toggle Switch Preference", new ByteArrayInputStream(DriverFactory.screenshotUtils(driver, "SwitchPreferenceToggleButton")));
    }
}