package utils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class DriverFactory {

    private AndroidDriver driver;

    public void deviceCapabilities() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Medium Phone"); // Match your AVD name
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "16.0"); // Match your AVD version
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");
        caps.setCapability("avd", "Medium_Phone"); // Optional: Auto-launch emulator

        // For better stability
        caps.setCapability("appWaitActivity", "*");
        caps.setCapability("appWaitDuration", 60000);

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AndroidDriver(url, caps);
        System.out.println("Appium device started..");
    }

    public AndroidDriver getDriver() {
        return driver;
    }

    public static byte[] screenshotUtils(WebDriver driver, String name) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

