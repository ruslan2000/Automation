package by.ruslan.automation.maven.test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.ruslan.automation.maven.project.stage.LoginPage;
import by.ruslan.automation.maven.project.stage.StageHomePage;

public class StageTest extends PrepareWebTest{
	
	private StageHomePage homePage;
	
	@BeforeMethod
	public void login() throws IOException {
		//homePage = new LoginPage(driver).login("rusel2000@gmail.com", "test12345");
				
		homePage = new StageHomePage(driver); 
	}

	@Test
	public void test() throws InterruptedException {
		//homePage.closeAlert();
		
		//PageObject page = new PageObject(driver);
		//homePage.openHomePage("https://qa.gordmans.com");
		
		homePage.sleep(2000);
		
		homePage.closeAlert();
		
		homePage.findBrokenLinks();
		
		//homePage.clickHelp();;
		
		//homePage.sleep(2000);
		
		//homePage.findBrokenLinks();
	}

}
