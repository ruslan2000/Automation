package by.ruslan.automation.maven.test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.ruslan.automation.maven.entity.PageObject;

public class JavascriptTest extends PrepareWebTest {

	private JavascriptExecutor js;
	private PageObject page;

	@BeforeMethod
	public void beforeMethod() {
		js = (JavascriptExecutor) driver;
		page = new PageObject(driver);
	}

	@Test
	public void f() throws InterruptedException {

		page.openHomePage("http://moneyboats.com/");

		page.sleep(1000);

		// Vertical scroll down by 600 pixels
		// js.executeScript("window.scrollBy(0,600)");
		// till the very bottom
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		page.sleep(1000);

		// Vertical scroll up
		js.executeScript("window.scrollTo(0, 0)");

		page.sleep(1000);
	}

	@AfterMethod
	public void afterMethod() {
		page.cleanPage();
	}

}
