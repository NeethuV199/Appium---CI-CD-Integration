# 📱 Appium Test Automation project

Appium supports both **Android** and **iOS** platforms, allowing you to write tests in various programming languages such as **Java**, **Python**, **Ruby**, and **JavaScript**.  
This project provides a basic structure for writing cross-platform mobile automation tests using **Java**.

--------------------------------------------------------------------

# 🚀 Getting Started

### ✅ Prerequisites

To set up and run this project, ensure you have the following installed:

- **Java Development Kit (JDK)**
- **Appium Server** (`npm install -g appium`)
- **Node.js** – [Download here](https://nodejs.org/)
- **Android SDK** (with emulator or real device access)
- **Appium client libraries** for your chosen language
- **Appium Inspector** (for element inspection)
- **An IDE** like IntelliJ IDEA, Eclipse, or VS Code
- **Maven or Gradle** (for Java projects)
- **TestNG or JUnit** (if using Java)
- **Python / Ruby / JavaScript** (if using non-Java language)
- **Allure** (or any other reporting tool)
- **Git** (for version control)

You’ll also need a mobile application:
- `.apk` file for Android
- `.ipa` file for iOS

----------------------------------------------------------------------

# 📂 Project Structure

```
ApiDemoProject/
├── src/ 
│   ├── main/
│   │   ├── java/
│   │   │   ├── locators/                   # App locators (XPath/CSS/ID)
│   │   │   │   ├── ApiDemosLocators.java             
│   │   │   │   ├── PreferenceFromCodeLocators.java   
│   │   │   ├── pages/                      # Page Object classes
│   │   │   │   ├── ApiDemosPage.java                   
│   │   │   │   ├── PreferenceFromCodePage.java         
│   │   │   │   ├── TouchPaintPage.java                 
│   │   │   ├── utils/                      # Reusable utilities/helpers
│   │   │   │   ├── DriverFactory.java      # Manages WebDriver setup, capabilities, etc.        
│   ├── test/
│   │   ├── java/   
│   │   │   ├── emulatorProject/            # Emulator-specific test suites           
│   │   │   │   ├── CalculatorTest.java                   
├── pom.xml                                 # Maven config (dependencies/plugins)
├── allure-results/                         # Allure raw test data
├── .gitignore                              # Git exclusion rules
├── README.md                               # Project docs (setup/usage)
```

# 🚀 How To Install above mentioned prerequisites Tests

### 1. Install Java Development Kit (JDK)
- Download and install the JDK from the [Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use OpenJDK.
- Set the `JAVA_HOME` environment variable to point to your JDK installation directory.
- Add the `bin` directory of the JDK to your system's `PATH` variable.
- Verify the installation by running:
  ```bash
  java -version
  ```
### 2. Install Appium Server
- Install Node.js from the [official website](https://nodejs.org/).
- Open a terminal and run the following command to install Appium globally:
  ```bash
  npm install -g appium
  ```
### 3. Install Appium Client Libraries
- For Java, add the Appium Java client dependency to your `pom.xml` if using Maven:
  ```xml
  <dependency>
      <groupId>io.appium</groupId>
      <artifactId>java-client</artifactId>
      <version>8.0.0</version>
  </dependency>
  ```
- For other languages, refer to the respective package manager (e.g., `pip` for Python, `gem` for Ruby, `npm` for JavaScript) to install the Appium client library.
- For Python, you can install the Appium client using:
  ```bash
  pip install Appium-Python-Client
  ```
### 4. Install Appium Inspector
- Download the Appium Inspector from the [Appium GitHub releases page](https://github.com/appium/appium-inspector/releases)
- Install it and run the application to inspect elements in your mobile app.
- Ensure you have the correct Appium server URL and desired capabilities set in the inspector.
- For iOS, you may need to install additional dependencies like `carthage` or `cocoapods` for managing iOS libraries.
- For Android, ensure you have the Android SDK installed and configured properly.
- For iOS, ensure you have Xcode installed and configured properly.
- For Android, you can set up an emulator using Android Studio or use a real device connected via USB.
- For iOS, you can set up a simulator using Xcode or use a real device connected via USB.
- For Android, ensure you have the correct `ANDROID_HOME` environment variable set to your Android SDK path.
- For iOS, ensure you have the correct `XCODE_HOME` environment variable set to your Xcode path.

### 5. How to set up Android Studio and Android SDK
- Download and install Android Studio from the [official website](https://developer.android.com/studio).
- Open Android Studio and go to `Configure` > `SDK Manager`.
- Ensure you have the latest Android SDK and tools installed.
- Set up an Android Virtual Device (AVD) for testing:
  - Go to `Configure` > `AVD Manager`.
  - Create a new virtual device with the desired specifications (e.g., Pixel 4, API level 30).
  - Start the AVD to ensure it runs correctly.

### 6. Install Allure for Reporting
- Download Allure from the [Allure website](https://allurereport.org/docs/install/).
- Follow the installation instructions for your operating system.
- Add Allure to your project by including the necessary dependencies in your `pom.xml` or build.gradle file.
- For Maven, add the following to your `pom.xml`:
  ```xml
  <dependency>
      <groupId>io.qameta.allure</groupId>
      <artifactId>allure-java-commons</artifactId>
      <version>2.13.8</version>
  </dependency>
  ```
### 7. Install Git
- Download and install Git from the [official website](https://git-scm.com/downloads).
- Set up Git by configuring your username and email:
  ```bash
  git config --global user.name "Your Name"
  git config --global user.email "

# 🚀 Step by Step Guide to Run Tests

### 1. Set Up Appium Server
- Start the Appium server using the command:
  ```bash
    appium --allow-cors
    ```
### 2. Configure Desired Capabilities 
- Modify the `DriverFactory.java` file to set your desired capabilities for the Android/iOS device or emulator.
- For Android, ensure you have the correct `appPackage`, `deviceName`, `automationName`, `platformName`, `platformVersion`, `app`, `avd` set for your application.
- For iOS, set the appropriate capabilities like `bundleId`, `udid`, etc.

This is an example code snippet for configuring Appium capabilities:

```java
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumConfig {
public static DesiredCapabilities getAndroidCaps() {
DesiredCapabilities caps = new DesiredCapabilities();
caps.setCapability("platformName", "Android");
caps.setCapability("deviceName", "Pixel_6_Pro");
caps.setCapability("platformVersion", "13.0");  // Match your device/emulator
caps.setCapability("deviceName", "Pixel_6_Pro");  
caps.setCapability("automationName", "UiAutomator2");
return caps;
}
}

```

### 3. Write down the Test Cases
- Create test classes in the `src/test/java` directory.
- Use the Page Object Model (POM) to structure your tests.
- Use the locators defined in the `locators` package to interact with UI elements.

### 4. Run Tests
- Use your IDE to run the test classes directly or use Maven/Gradle commands.
- For Maven, you can run:
  ```bash
  mvn clean test
  ```
### Allure Reporting
- After running tests, Allure report will automatically generate in the `allure-results` directory.
- To view the report, run:
  ```bash
  allure serve allure-results
  ```
- This will start a local server and open the Allure report in your default web browser.






