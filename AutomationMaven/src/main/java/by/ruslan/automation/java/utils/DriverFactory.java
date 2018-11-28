package by.ruslan.automation.java.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import by.ruslan.automation.java.entity.App;
import by.ruslan.automation.java.entity.Device;
import io.appium.java_client.AppiumDriver;

public class DriverFactory {
	
	
	public static AppiumDriver getAppiumDriver(Device device, App app) throws MalformedURLException {
		// String browserName = "mobileOS";

		DesiredCapabilities capabilities = new DesiredCapabilities(device.getBrowserName(), device.getVersion(),
				Platform.ANY);

		capabilities.setCapability("platformName", device.getPlatformName());
		capabilities.setCapability("deviceName", device.getId());

		capabilities.setCapability("appPackage", app.getAppPackage());
		capabilities.setCapability("appActivity", app.getAppActivity());

		AppiumDriver driver = new AppiumDriver(new URL(getProperty("hostURL")), capabilities);

		return driver;
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
