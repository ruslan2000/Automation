package by.ruslan.automation.java.app;

import java.net.MalformedURLException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import by.ruslan.automation.java.entity.Device;
import by.ruslan.automation.java.goodrx.GoodRx;
import by.ruslan.automation.java.utils.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class GoodRxTest {
	
	private AppiumDriver driver;
	private WebDriverWait wait;
	private Device device;

	private GoodRx app;


	public void skipGetStarted() throws InterruptedException {
		app.xClick();
	}
	

	public void skipAlert(String button) throws InterruptedException {
		
		String currentContext = driver.getContext();
		driver.context("NATIVE_APP");
		driver.findElement(By.id(button)).click();
		driver.context(currentContext);	
	}
	
	public void clickSearch() {
		
		app.clickSearchBttn();	
	}
	
	public void search(String drug) throws InterruptedException{
		
		app.searchField(drug);
		System.out.println(drug);	
				
		app.searchResultClickElement(2);
		
		app.findPrice();
		
		Thread.sleep(2000);
		
		try {
			WebElement allow = driver.findElement(MobileBy.id("com.android.packageinstaller:id/permission_allow_button"));
			
			if(allow != null && allow.isDisplayed()) {
				allow.click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		app.showPrice(1);
		
		driver.navigate().back();
		driver.navigate().back();
		
		app.clearSearchField();
	}
	
	

	public void beforeTest(String deviceId) throws MalformedURLException, InterruptedException {

		app = new GoodRx();
		device = new Device("Android", "8.1", deviceId, null);

		driver = DriverFactory.getAppiumDriver(device, app);	
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("imageview_close")));
	
		PageFactory.initElements(driver, app);		
		
	}

	public void afterTest() {
		driver.quit();
	}
	

	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		GoodRxTest test = new GoodRxTest();
		
		String deviceID = "ZY2243SKXL";
		
		test.beforeTest(deviceID);
		test.skipGetStarted();
		test.skipAlert("button2");
		test.clickSearch();
		test.search("Aspirin");
		
		test.afterTest();
		
	}
	


}
