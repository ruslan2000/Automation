package by.ruslan.automation.maven.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Main {

	public static void main(String[] args) {
		WebDriver driver = new HtmlUnitDriver(true);
		
		driver.get("www.google.com");

	}

}
