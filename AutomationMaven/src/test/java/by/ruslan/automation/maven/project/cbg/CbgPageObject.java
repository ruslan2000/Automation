package by.ruslan.automation.maven.project.cbg;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import by.ruslan.automation.maven.entity.PageObject;

public class CbgPageObject extends PageObject{
	
	public String homeURL = "http://hd-test-server:7777/WebCBG/";
	
	//search input
	@FindBy(name="searchID")
	WebElement searchID;
	
	//search output
	@FindBy(xpath="//*[@id='table']")
	List<WebElement> list;
	
	//search submit button
	@FindBy(xpath="//form/table/tbody/tr[2]/td[4]/input")
	WebElement submitButton;

	
	//Go to CGB's stock link
	@FindBy(xpath="//p[1]/a")
	WebElement goToStock;
	
	//Go to Lens's stock link
	@FindBy(partialLinkText = "Go to Lens's")
	WebElement goToLensStock;
	
	

	public CbgPageObject(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public void openHomeURL() {
		super.openHomePage(homeURL);
	}
	
	
	public void search(String str) {
		
		wait.until(ExpectedConditions.visibilityOf(searchID));
		searchID.sendKeys(str);		
		submitButton.click();
		
	}
	
	public int getRows() {
		return list.size();
	}
	
	/*
	public void clickOn(int row) {
		//List<WebElement> list = driver.findElements(By.xpath("//*[@id='table']"));
		WebElement we = driver.findElement(By.xpath("//table[2]/tbody/tr["+(row+2)+"]/td[1]/a"));
		we.click();
	}
	*/
	
	public void goToStock() {
		goToStock.click();
	}
	
	public void goToLensStock() {
		goToLensStock.click();
		
	}

}
