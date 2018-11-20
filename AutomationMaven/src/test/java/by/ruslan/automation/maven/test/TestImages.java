package by.ruslan.automation.maven.test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.ruslan.automation.maven.entity.PageObject;

public class TestImages extends PrepareWebTest{
	
	
	private PageObject page;
	private JavascriptExecutor js;
	
	@BeforeTest
	public void init() {
		page = new PageObject(driver);
		js = (JavascriptExecutor) driver;
	}
	
	@Test
	public void test() throws InterruptedException {
		String URL = "https://dev-us.pandora.net/en/gifts/gifts-for-daughters/";
		page.openHomePage(URL);
		
		page.sleep(2000);
		
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		page.sleep(5000);
		
		page.showNoImages();
	}

}
