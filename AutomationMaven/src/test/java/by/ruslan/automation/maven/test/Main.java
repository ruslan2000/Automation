package by.ruslan.automation.maven.test;

import java.io.IOException;
import java.util.Properties;

import by.ruslan.automation.maven.utilities.Manager;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		
		Properties elements = Manager.getElementsRepository();
		
		
		
		System.out.println(elements.getProperty("searchButton"));
		
		
		//WebDriver driver = Manager.getWebDriver("chrome");
		
		//driver.get("https://www.google.com");

	}

}
