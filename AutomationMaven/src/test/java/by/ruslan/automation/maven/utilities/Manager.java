package by.ruslan.automation.maven.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import by.ruslan.automation.maven.entity.App;
import by.ruslan.automation.maven.entity.Device;

public class Manager {

	private static WebDriver driver;
	private static RemoteWebDriver remoteDriver;

	public static WebDriver getWebDriver(String webDriverName) {

		switch (webDriverName.toUpperCase()) {

		case "CHROME":
			System.setProperty("webdriver.driver.chrome", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			return driver;

		case "FIREFOX":
			System.setProperty("webdriver.driver.firefox", "src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			return driver;

		default: // Headless Browser Driver
			driver = new HtmlUnitDriver(true);
			// driver = new PhantomJSDriver();
			return driver;
		}
	}

	// SSL Certificate Error Handling
	public static WebDriver getSSLWebDriver(String webDriverName) {

		switch (webDriverName.toUpperCase()) {

		case "CHROME":
			System.setProperty("webdriver.driver.chrome", "src/main/resources/chromedriver.exe");
			// Deprecated for Java - using ChromeOptions instead

			// DesiredCapabilities sslHandler = DesiredCapabilities.chrome();
			// sslHandler.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			// driver = new ChromeDriver(sslHandler);

			ChromeOptions chromeOptions = new ChromeOptions();

			chromeOptions.setAcceptInsecureCerts(true);
			chromeOptions.addArguments("start-maximized"); // maximizing Browser
			driver = new ChromeDriver(chromeOptions);

			return driver;

		case "FIREFOX":
			System.setProperty("webdriver.driver.firefox", "src/main/resources/geckodriver.exe");

			FirefoxProfile ffProfile = new FirefoxProfile(new File(getProperty("ffProfile")));

			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(FirefoxDriver.PROFILE, ffProfile);

			FirefoxOptions ffOptions = new FirefoxOptions(capabilities);
			ffOptions.setAcceptInsecureCerts(true);

			driver = new FirefoxDriver(ffOptions);

			return driver;

		default: // Headless Browser Driver
			driver = new HtmlUnitDriver(true);
			// driver = new PhantomJSDriver();
			return driver;
		}

	}

	public static RemoteWebDriver getRemoteWebDriver(Device device, App app) throws MalformedURLException {
		// String browserName = "mobileOS";

		DesiredCapabilities capabilities = new DesiredCapabilities(device.getBrowserName(), device.getVersion(),
				Platform.ANY);

		capabilities.setCapability("platformName", device.getPlatformName());
		capabilities.setCapability("deviceName", device.getId());

		capabilities.setCapability("appPackage", app.getAppPackage());
		capabilities.setCapability("appActivity", app.getAppActivity());

		remoteDriver = new RemoteWebDriver(new URL(getProperty("hostURL")), capabilities);

		return remoteDriver;
	}

	public static void takeSnapShot(String fileName) throws Exception {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		String fileWithPath = getProperty("reportDir").concat(getProperty("projectName")).concat("SnapShot/" + fileName);

		File DestFile = new File(fileWithPath);

		FileUtils.copyFile(SrcFile, DestFile);

	}


	public static String getProperty(String str) {

		String path = System.getProperty("user.dir").concat("/src/test/resources/webElements.properties");

		Properties elements = new Properties();

		InputStream input;

		try {
			input = new FileInputStream(new File(path));

			elements.load(input);

		} catch (IOException e) {

			e.printStackTrace();
		}

		return elements.getProperty(str);
	}

}
