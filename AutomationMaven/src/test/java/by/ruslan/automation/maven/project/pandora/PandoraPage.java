package by.ruslan.automation.maven.project.pandora;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import by.ruslan.automation.maven.entity.PageObject;
import by.ruslan.automation.maven.utilities.Manager;

public class PandoraPage extends PageObject{
	
	@FindBy(className = "load-more-button")
	WebElement loadMoreBtn;
	

	private JavascriptExecutor js;
	
	
	public PandoraPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loadMoreImages() throws InterruptedException {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,-500)");
		sleep(2000);
		
		if(loadMoreBtn.isDisplayed()) {
			loadMoreBtn.click();
		}
	}
	 
	
	public void showNoImages() throws Exception {
		js.executeScript("window.scrollTo(0,500)");
		
		for(WebElement image : findAllImages()) {
			if(image.getAttribute("src").contains("no-image.png") || image.getAttribute("alt").contains("null")) {
				//String xpath = "//*[@src=\'" + image.getAttribute("src") + "\']/../../../div[6]/a[@class=\'name-link\']";
				//xpath = "//*[@src=\'" + image.getAttribute("src") + "\']";
								
				System.out.println(image.getAttribute("src") + " LOCATION: " + image.getLocation());
				System.out.println(image.getAttribute("title"));
				
				js.executeScript("arguments[0].scrollIntoView(true)", image);
				
				moveTo(image);
				
				Manager.takeSnapShot(image.getAttribute("title") + ".png");
				
				
				
			}
		}
	}

}
