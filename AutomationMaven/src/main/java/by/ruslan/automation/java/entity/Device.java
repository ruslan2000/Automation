package by.ruslan.automation.java.entity;

public class Device {
	private String platformName; //Android
	private String version; //7.0
	private String id; //"ZY2243SKXL"
	private String browserName; //Chrome


	public Device(String platformName, String version, String id, String browserName) {
		this.platformName = platformName;
		this.version = version;
		this.id = id;
		this.browserName = browserName; 
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String name) {
		this.id = id;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}


}
