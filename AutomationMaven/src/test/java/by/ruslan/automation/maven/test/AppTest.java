package by.ruslan.automation.maven.test;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import by.ruslan.automation.maven.entity.Device;
import by.ruslan.automation.maven.project.goodrx.Drugs;
import by.ruslan.automation.maven.project.goodrx.GoodRx;
import by.ruslan.automation.maven.utilities.Manager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class AppTest {

	private AppiumDriver driver;
	private WebDriverWait wait;
	private Device device;
	private GoodRx app;

	@Test // (priority = 0)
	public void skipGetStarted() throws InterruptedException {
		app.xClick();

	}

	@Test // (priority = 1)
	public void skipAlert() throws InterruptedException {

		try {
			String currentContext = driver.getContext();
			driver.context("NATIVE_APP");
			driver.findElement(By.id("button2")).click();
			driver.context(currentContext);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

	@Test
	public void clickSearchBtn() {
		app.clickSearchBttn();
	}

	@Test(dataProvider = "drugsName", dataProviderClass = Drugs.class) // , priority = 2)
	public void search(String drug) {

		app.searchField(drug);

		app.searchResultClickElement(1);

		app.findPrice();

		try {
			WebElement allow = driver
					.findElement(MobileBy.id("com.android.packageinstaller:id/permission_allow_button"));

			if (allow != null && allow.isDisplayed()) {
				allow.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		for (int i = 0; i < 4; i++) {

			WebElement priceType = app.showPrice(i);

			String type = priceType.getText();

			System.out.print(type + ": ");

			priceType.click();

			switch (type) {
			case "Coupon":
				app.couponPrice();
				break;

			case "Members":
				app.membersPrice();
				break;

			case "Cash (Est)":
				app.cashPrice();
				break;

			case "Discount":

				try {
					driver.findElement(By.id("com.goodrx:id/otc_proceed")).click();
					;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
				}

				app.couponPrice();
				break;

			default:
				break;
			}

			driver.navigate().back();

			try {
				skipAlert();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}

		}
		driver.navigate().back();

		app.clearSearchField();
	}

	@Parameters({ "device-id" })
	@BeforeTest
	public void beforeTest(String deviceId) throws MalformedURLException, InterruptedException {

		app = new GoodRx();
		device = new Device("Android", "8.1", deviceId, null);
		driver = Manager.getAppiumDriver(device, app);
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("imageview_close")));

		PageFactory.initElements(driver, app);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
