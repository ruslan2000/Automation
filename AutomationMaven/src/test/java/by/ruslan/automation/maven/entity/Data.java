package by.ruslan.automation.maven.entity;

import org.testng.annotations.DataProvider;

/**
 * Data class to provide test data
 * 
 * @author Ruslan
 *
 */

public class Data {
	
	@DataProvider(name="dataId")
	public Object[][] getData() {
		
		Object[][] data = new Object[][]{
			{"D15"},
			{"D14"},
			{""}
		} ;
		
		return data;
	}
	
	@DataProvider(name="dataLogin")
	public Object[][] getCredencial(){
		
		Object[][] data = new Object[][] {
			{"user", "password"},
			{"admin", "admin"}
		};
		
		return data;
	}
	
	@DataProvider(name="dataPassword")
	public Object[][] getPassword(){
		
		Object[][] data = new Object[][] {
			{""},
			{" "},
			{"1"},
			{"a"},
			{"a a "},
			{"1 1"},
			{"123123123"},
			{"asdfasdfs"},
			{"asdfajsdnfjasdjfpsdaijf893ru82039"},
			{"6129376129347612396741296437"},
			{"asdfksldfjksdnfjsdnflnasdflkjnsdlk"},
			{"asdkfmo28uj3fd@?___mdsmfalsdmufe98u87u89u0jadvjo"},
			{"asdkfmo28uj3fd@?___mdsmfalsdmufe98u87DDFKJFJJFu89u0jadvjo"},
			{"@Test12345"}
		};
		
		return data;
	}
	

}
