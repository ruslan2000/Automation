package by.ruslan.automation.maven.test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.ruslan.automation.maven.entity.PageObject;

public class TestImages extends PrepareWebTest {

	private PageObject page;
	private JavascriptExecutor js;

	@BeforeTest
	public void init() {
		page = new PageObject(driver);
		js = (JavascriptExecutor) driver;
	}

	@Test
	public void test() throws InterruptedException {
		//String URL = "https://dev-us.pandora.net/en/gifts/gifts-for-daughters/";
		String URL = "https://dev-us.pandora.net/en/necklaces/view-all";
		page.openHomePage(URL);

		int i = 0;
		while( i < 10) {
			loadMoreImages(js, page);
			i++;
		}
		
		page.showNoImages();
	}

	private void loadMoreImages(JavascriptExecutor js, PageObject page) throws InterruptedException {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		page.sleep(2000);
	}

}
