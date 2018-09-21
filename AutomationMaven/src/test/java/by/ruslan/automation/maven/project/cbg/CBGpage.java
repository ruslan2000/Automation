package by.ruslan.automation.maven.project.cbg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import by.ruslan.automation.maven.entity.PageObject;

public class CBGpage extends PageObject{
	
	private WebElement we;
	private String homeURL = "http://hd-test-server:7777/WebCBG/";
	
	@FindBy(name="searchID")
	WebElement searchID;
	
	@FindBy(xpath="//*[@id='table']")
	List<WebElement> list;
	
	@FindBy(xpath="//form/table/tbody/tr[2]/td[4]/input")
	WebElement submitButton;

	public CBGpage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public void openHomeURL() {
		super.openHomePage(homeURL);
		
	}
	
	
	public void search(String str) {
		
		searchID.sendKeys(str);		
		wait.until(ExpectedConditions.visibilityOf(searchID));
		submitButton.click();
		
	}
	
	public int getRows() {
	//	List<WebElement> list = driver.findElements(By.xpath("//*[@id='table']"));
		return list.size();
	}
	
	public void clickOn(int row) {
		//List<WebElement> list = driver.findElements(By.xpath("//*[@id='table']"));
		we = driver.findElement(By.xpath("//table[2]/tbody/tr["+(row+2)+"]/td[1]/a"));
		
		we.click();
	}
	
	public void goToStock() {
		we = driver.findElement(By.xpath("//p[1]/a"));
		we.click();
	}
	
	public void goToLensStock() {
		String partialLinkText = "Go to Lens's";
		we = driver.findElement(By.partialLinkText(partialLinkText));
		we.click();
		
	}
	
}
