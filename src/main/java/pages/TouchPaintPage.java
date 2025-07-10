package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.ApiDemosLocators;
import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.Arrays;
import utils.DriverFactory;

public class TouchPaintPage {

    AppiumDriver driver;

    public TouchPaintPage(AppiumDriver driver) {
        this.driver = driver;
    }

    //Scroll down to the page
    @Step("Scroll down to the Touch Paint section")
    public void scrollToDown() {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
        Allure.addAttachment("Scroll to down", new ByteArrayInputStream(DriverFactory.screenshotUtils(driver, "ScrollToDown")));
    }

    // Click on 'Touch Paint' option under Graphics
    @Step("Click on 'Touch Paint' option under Graphics")
    public void touchPaint() {
        MobileElement touchPaintOption = (MobileElement) new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(ApiDemosLocators.TOUCHPAINT_TEXT_FROM_MENU)));
        touchPaintOption.click();
        Allure.addAttachment("Click on Touch Paint", new ByteArrayInputStream(DriverFactory.screenshotUtils(driver, "TouchPaintMenu")));
    }

    //Zoom in the page
    @Step("Zoom in on the Touch Paint page")
    public void zoomIn() {
        // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int centerX = size.width / 2;
        int centerY = size.height / 2;

        // Start points: fingers farther apart
        int startOffset = 120;
        int endOffset = 250;

        // Finger 1: upper-left to further upper-left
        Point startPoint1 = new Point(centerX - startOffset, centerY - startOffset);
        Point endPoint1 = new Point(centerX - endOffset, centerY - endOffset);

        // Finger 2: lower-right to further lower-right
        Point startPoint2 = new Point(centerX + startOffset, centerY + startOffset);
        Point endPoint2 = new Point(centerX + endOffset, centerY + endOffset);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Sequence sequence1 = new Sequence(finger1, 0);
        sequence1.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startPoint1.x, startPoint1.y));
        sequence1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence1.addAction(new Pause(finger1, Duration.ofMillis(400)));
        sequence1.addAction(finger1.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endPoint1.x, endPoint1.y));
        sequence1.addAction(new Pause(finger1, Duration.ofMillis(200)));
        sequence1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Sequence sequence2 = new Sequence(finger2, 0);
        sequence2.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startPoint2.x, startPoint2.y));
        sequence2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence2.addAction(new Pause(finger2, Duration.ofMillis(400)));
        sequence2.addAction(finger2.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endPoint2.x, endPoint2.y));
        sequence2.addAction(new Pause(finger2, Duration.ofMillis(200)));
        sequence2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(sequence1, sequence2));
        Allure.addAttachment("Zoom In", new ByteArrayInputStream(DriverFactory.screenshotUtils(driver, "ZoomIn")));
    }

    //Zoom out the page
    @Step("Zoom out on the Touch Paint page")
    public void zoomOut() {
        // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int centerX = size.width / 2;
        int centerY = size.height / 2;

        // Start points: fingers closer together
        int startOffset = 250;  // Larger start offset for zoom-out
        int endOffset = 120;    // Smaller end offset for zoom-out

        // Finger 1: upper-left to closer upper-left
        Point startPoint1 = new Point(centerX - startOffset, centerY - startOffset);
        Point endPoint1 = new Point(centerX - endOffset, centerY - endOffset);

        // Finger 2: lower-right to closer lower-right
        Point startPoint2 = new Point(centerX + startOffset, centerY + startOffset);
        Point endPoint2 = new Point(centerX + endOffset, centerY + endOffset);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Sequence sequence1 = new Sequence(finger1, 0);
        sequence1.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startPoint1.x, startPoint1.y));
        sequence1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence1.addAction(new Pause(finger1, Duration.ofMillis(400)));
        sequence1.addAction(finger1.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endPoint1.x, endPoint1.y));
        sequence1.addAction(new Pause(finger1, Duration.ofMillis(200)));
        sequence1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Sequence sequence2 = new Sequence(finger2, 0);
        sequence2.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startPoint2.x, startPoint2.y));
        sequence2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence2.addAction(new Pause(finger2, Duration.ofMillis(400)));
        sequence2.addAction(finger2.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endPoint2.x, endPoint2.y));
        sequence2.addAction(new Pause(finger2, Duration.ofMillis(200)));
        sequence2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(sequence1, sequence2));
        Allure.addAttachment("Zoom Out", new ByteArrayInputStream(DriverFactory.screenshotUtils(driver, "ZoomOut")));
    }

    //Go back to previous page
    @Step("Go back {0} page(s) from Touch Paint")
    public void goToBackPage(int times) {
        for (int i = 0; i < times; i++) {
            driver.navigate().back();
            Allure.addAttachment("Go Back Page " + (i + 1), new ByteArrayInputStream(DriverFactory.screenshotUtils(driver, "GoBackPage" + (i + 1))));
        }
    }
}