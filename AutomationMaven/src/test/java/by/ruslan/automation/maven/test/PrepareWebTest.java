package by.ruslan.automation.maven.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import by.ruslan.automation.maven.utilities.Manager;

public class PrepareWebTest {

	protected WebDriver driver;

	@Parameters({ "webdriver-name" })
	@BeforeTest
	public void beforeAllTests(String webdriverName) {
		
		System.out.println("Opening browser...");
		
		//driver = Manager.getWebDriver(webdriverName);
		driver = Manager.getSSLWebDriver(webdriverName);
		
		//driver.manage().window().maximize();
		
	}

	@AfterTest
	public void afterAllTests() {
		driver.quit();
		System.out.println("Closing browser...");
	}

}
