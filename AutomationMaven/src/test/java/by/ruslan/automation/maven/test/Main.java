package by.ruslan.automation.maven.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import by.ruslan.automation.maven.utilities.Manager;

public class Main {

	public static void main(String[] args) throws IOException {

		System.out.println(Manager.getProperty("reportDir"));
		
	
		FileUtils.write(new File("c:\\Users\\Ruslan\\Documents\\test.txt"), "Hello\nRuslan","utf-8");

	}
}
