package by.ruslan.automation.maven.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import by.ruslan.automation.maven.entity.App;
import by.ruslan.automation.maven.entity.Device;

public class Manager {

	private static final String REPORT_DIR = "e:/IT/Automation/Report/";
	private static final String SNAPSHOT_DIR = REPORT_DIR.concat("SnapShot/");

	private static WebDriver driver;
	private static RemoteWebDriver remoteDriver;

	public static WebDriver getWebDriver(String webdriverName) {

		switch (webdriverName.toUpperCase()) {

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

	public static RemoteWebDriver getRemoteWebDriver(Device device, App app) throws MalformedURLException {
		String browserName = "mobileOS";
		DesiredCapabilities capabilities = new DesiredCapabilities(device.getBrowserName(), device.getVersion(),
				Platform.ANY);
		capabilities.setCapability("platformName", device.getPlatformName());
		capabilities.setCapability("deviceName", device.getId());

		capabilities.setCapability("appPackage", app.getAppPackage());
		capabilities.setCapability("appActivity", app.getAppActivity());

		remoteDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		return remoteDriver;
	}

	public static void takeSnapShot(String fileName) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Create a file path

		String fileWithPath = SNAPSHOT_DIR.concat(fileName);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}

	public static Properties getElementsRepository() {
		
		String path = System.getProperty("user.dir").concat("/src/test/resources/webElements.properties");

		Properties elements = new Properties();

		InputStream input;
		
		try {
			input = new FileInputStream(new File(path));
			
			elements.load(input);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return elements;
	}
	// working branch

}
