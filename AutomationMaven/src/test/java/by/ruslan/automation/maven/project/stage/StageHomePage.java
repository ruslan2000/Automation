package by.ruslan.automation.maven.project.stage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import by.ruslan.automation.maven.entity.PageObject;

public class StageHomePage extends PageObject {

	@FindBy(className = "modal__header__close-button")
	WebElement closeBtn;

	@FindBy(className = "modalClose modal-close")
	WebElement modalClose;

	@FindBy(xpath = "//div[2]/div[1]/div[3]/header[2]/nav/ul/li[2]/a")
	WebElement women;
	
	@FindBy(partialLinkText = "Help & FAQs")
	WebElement help;
	
	@FindBy(className = "close")
	WebElement alert;

	public StageHomePage(WebDriver driver) throws IOException {
		super(driver);

		//openHomePage("https://uat01.stage.com/");
		openHomePage("http://qa.gordmans.com");

		PageFactory.initElements(driver, this);
		//setCookies();

	}

		
	public void closeAlert() {
		
		alert.click();

		//modalClose.click();
		// driver.switchTo().alert().dismiss();
	}

	public void clickWomen() {
		women.click();
	}

	public void clickHelp() {
		help.click();
	}

}
