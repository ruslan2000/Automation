package by.ruslan.automation.maven.test;

import java.net.MalformedURLException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import by.ruslan.automation.maven.entity.Device;
import by.ruslan.automation.maven.project.spirit.Spirit;
import by.ruslan.automation.maven.utilities.Manager;

public class TestPractice {
	
	private RemoteWebDriver remoteWebDriver;
	private Spirit app;


	@Test(priority = 0)
	public void appTest1() {
		app.clickOk();
		
	}
	

	@Test(priority = 1)
	public void appTest2() {
		
		app.callMenu();
	}

	@Parameters({"device-id"})
	@BeforeTest
	public void beforeTest(String deviceId) throws MalformedURLException {
		
		app = new Spirit();
		Device device = new Device("Android", "7.0", deviceId, null);
		remoteWebDriver = Manager.getRemoteWebDriver(device, app);
		PageFactory.initElements(remoteWebDriver, app);
			
	}

	@AfterTest
	public void afterTest() {
		remoteWebDriver.quit();
	}

}
