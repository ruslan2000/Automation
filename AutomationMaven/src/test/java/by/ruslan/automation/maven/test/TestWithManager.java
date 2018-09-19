package by.ruslan.automation.maven.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import by.ruslan.automation.maven.entity.Data;
import by.ruslan.automation.maven.project.cbg.CbgPageObject;
import by.ruslan.automation.maven.utilities.Manager;

public class TestWithManager {

	private WebDriver driver;
	private CbgPageObject page;

	@Test
	public void testStock() throws InterruptedException {

		page.goToStock();
		
	//	page.sleep(100);
	}
	
	@Test
	public void testLenses() throws InterruptedException {
	
		page.goToLensStock();
		
	//	page.sleep(100);
	}
	
	@Ignore
	@Test(dataProvider = "dataPassword", dataProviderClass = Data.class)
	public void searchCBGs(String id) {
		page.search(id);
	}

	@Parameters({"webdriver-name"})
	@BeforeTest
	public void setUp(String webdriverName) {   //@Optional("chrome")
		driver = Manager.getWebDriver(webdriverName);
		page = new CbgPageObject(driver);		
	}

	@AfterTest
	public void cleanAll() {
		driver.close();
	}

	@BeforeMethod
	public void prepareTest() {
		page.openHomeURL();
	}
	
	@AfterMethod
	public void clean() {
		page.cleanPage();
	}

}
