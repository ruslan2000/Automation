package by.ruslan.automation.maven.entity;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TryAgain implements IRetryAnalyzer {
	
	private static final int MAX_RETRY = 5;
	private int etempt = 0;

	@Override
	public boolean retry(ITestResult result) {
		if(etempt < MAX_RETRY) {
			System.out.println("Trying again...");
			etempt++;
			return true;
		}
		return false;
	}
	
	

}
