package by.ruslan.automation.maven.project.spirit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import by.ruslan.automation.maven.entity.App;

public class Spirit extends App {
	
	@FindBy(id = "android:id/up")
	WebElement menu;
	
	@FindBy(className = "android.widget.Button")
	WebElement ok;
	
	public Spirit() {
		super("com.navitaire.nps.spirit", "md59146a50e3100a484539eceeba6a2edd2.MainActivity");
	}
	
	public void callMenu() {
		menu.click();
	}
	
	public void clickOk() {
		ok.click();
	}

}
