package by.ruslan.automation.maven.entity;

public class App {
	
	private String appPackage; //"com.navitaire.nps.spirit"
	private String appActivity; //"md59146a50e3100a484539eceeba6a2edd2.MainActivity"
	
	//protected RemoteWebDriver remoteWebDriver;
	
	public App(String appPackage, String appActivity) {
		this.appPackage = appPackage;
		this.appActivity = appActivity;
	}

	public String getAppPackage() {
		return appPackage;
	}

	public void setAppPackage(String appPackage) {
		this.appPackage = appPackage;
	}

	public String getAppActivity() {
		return appActivity;
	}

	public void setAppActivity(String appActivity) {
		this.appActivity = appActivity;
	}
	
	/*
	public void initializeDriver(RemoteWebDriver remoteWebDriver) {
		this.remoteWebDriver = remoteWebDriver;
	}
	*/
	
}
