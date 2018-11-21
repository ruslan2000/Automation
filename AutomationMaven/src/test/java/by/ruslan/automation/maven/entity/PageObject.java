package by.ruslan.automation.maven.entity;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object Model class of the Page Object Design Pattern
 * 
 * @author Ruslan
 *
 */

public class PageObject {

	@FindBy(tagName = "a")
	List<WebElement> links;
	
	@FindBy(tagName = "img")
	List<WebElement> images;

	protected WebDriver driver;
	protected WebDriverWait wait;
	private String homeURL;

	public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 5);
	}

	public void openHomePage(String homeURL) {
		this.homeURL = homeURL;
		System.out.println("Opening home url...");
		driver.get(homeURL);
	}

	public String getTitle() {
		String title = driver.getTitle();
		System.out.println("The page title is: " + title);
		return title;
	}

	public void closePage() {
		driver.close();
	}

	public void cleanPage() {
		driver.manage().deleteAllCookies();
		System.out.println("Cookies cleaned");
	}

	public void goBack() {
		driver.navigate().back();
	}
	
	public void closeAlert() {
		driver.switchTo().alert().dismiss();
	}

	public void sleep(int millis) throws InterruptedException {
		Thread.sleep(millis);
	}
	
	//scroll the screen to the element
	public void moveTo(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
	
	public List<WebElement> findAllImages(){
		return images;
	}
	
	public void findBrokenLinks() {
		HttpURLConnection huc = null;
		int respCode = 200;

		for (WebElement link : links) {

			String url = link.getAttribute("href");

			if (url == null || url.isEmpty()) {
				System.out.println(url + " - is either not configured for anchor tag or it is empty");
				continue;
			}

			if (!url.startsWith(homeURL)) {
				System.out.println(url + " - belongs to another domain, skipping it.");
				continue;
			}

			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if (respCode >= 400) {
					System.out.println(url + " is a broken link");
				} else {
					// System.out.println(url + " is a valid link");
				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
