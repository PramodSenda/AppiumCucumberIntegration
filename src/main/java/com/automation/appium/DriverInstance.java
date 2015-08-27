package com.automation.appium;

import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.automation.utils.*;


// TODO: Auto-generated Javadoc
/**
 * The Class DriverInstance.
 */
public class DriverInstance {

	/** The Appium driver. */
	private AppiumDriver driver;

	/** The host ip. */
	private String hostIp = "";
	
	/** The host port. */
	private String hostPort = "";
	
	/** The device name. */
	private String deviceName = "";
	
	/** The app url. */
	private String appUrl = "";
	
	/** The platform name. */
	private String platformName = "";
	
	/** The platform version. */
	private String platformVersion = "";
	
	/** The mobile udid. */
	private String mobileUDID = "";
	
	/** The browser type. */
	private String browserType = "";
	
	/** The app type. */
	private String appType = "";

	/**
	 * Gets the driver.
	 * 
	 * @return the driver
	 */
	public AppiumDriver getDriver() {
		return driver;
	}

	/**
	 * Sets the driver.
	 * 
	 * @param driver
	 *            the new web driver
	 */
	public void setDriver(AppiumDriver driver) {
		this.driver = driver;
	}

	/**
	 * Maximize the browser.
	 */
	public void maximize() {
		driver.manage().window().maximize();
	}

	/**
	 * Quit the browser instance.
	 */
	public void quit() {
		if (!"NATIVE_APP".equalsIgnoreCase(driver.getContext())) {
			driver.close();
		}
		driver.quit();
	}

	/**
	 * Gets the browser type.
	 *
	 * @return the browser type
	 */
	public String getBrowserType() {
		return browserType;
	}

	/**
	 * Sets the browser type.
	 *
	 * @param browserType the new browser type
	 */
	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}

	/**
	 * Gets the mobile udid.
	 *
	 * @return the mobile udid
	 */
	public String getMobileUDID() {
		return mobileUDID;
	}

	/**
	 * Sets the mobile udid.
	 *
	 * @param mobileUDID the new mobile udid
	 */
	public void setMobileUDID(String mobileUDID) {
		this.mobileUDID = mobileUDID;
	}

	/**
	 * Gets the host.
	 *
	 * @return the host
	 */
	public String getHost() {
		return hostIp;
	}

	/**
	 * Sets the host.
	 *
	 * @param host the new host
	 */
	public void setHost(String host) {
		this.hostIp = host;
	}

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public String getPort() {
		return hostPort;
	}

	/**
	 * Sets the port.
	 *
	 * @param port the new port
	 */
	public void setPort(String port) {
		this.hostPort = port;
	}

	/**
	 * Gets the device name.
	 *
	 * @return the device name
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * Sets the device name.
	 *
	 * @param deviceName the new device name
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}


	/**
	 * Gets the app url.
	 *
	 * @return the app url
	 */
	public String getAppUrl() {
		return appUrl;
	}

	/**
	 * Sets the app url.
	 *
	 * @param appUrl the new app url
	 */
	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	/**
	 * Gets the platform name.
	 *
	 * @return the platform name
	 */
	public String getPlatformName() {
		return platformName;
	}

	/**
	 * Sets the platform name.
	 *
	 * @param platformName the new platform name
	 */
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	/**
	 * Gets the platform version.
	 *
	 * @return the platform version
	 */
	public String getPlatformVersion() {
		return platformVersion;
	}

	/**
	 * Sets the platform version.
	 *
	 * @param platformVersion the new platform version
	 */
	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}

	/**
	 * Gets the app type.
	 *
	 * @return the app type
	 */
	public String getAppType() {
		return appType;
	}

	/**
	 * Sets the app type.
	 *
	 * @param appType the new app type
	 */
	public void setAppType(String appType) {
		this.appType = appType;
	}

	/**
	 * Instantiates a new web browser.
	 *
	 * @param platform the device type
	 */
	public DriverInstance(String platform) {

		try {
			init();
			String remoteUrl = "http://" + getHost() + ":" + getPort()
					+ "/wd/hub";
			if ("Android".equalsIgnoreCase(platform)) {
				driver = new AndroidDriver(new URL(remoteUrl),
						this.generateDesiredCapabilities());

			} else if ("IOS".equalsIgnoreCase(platform)) {
				driver = new IOSDriver(new URL(remoteUrl),
						this.generateDesiredCapabilities());
			} else {
				throw new Exception("Given platform is not implemented.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initializes the execution parameters.
	 */
	private void init() {

		PropertyFileReader handler = new PropertyFileReader(
				"/execution.properties");
		setHost(handler.getProperty("HOST_IP"));
		setPort(handler.getProperty("HOST_PORT"));
		setDeviceName(handler.getProperty("DEVICE_NAME"));
		setAppUrl(handler.getProperty("NATIVE_APP_URL"));
		setPlatformName(handler.getProperty("PLATFORM_NAME"));
		setPlatformVersion(handler.getProperty("PLATFORM_VERSION"));
		setMobileUDID(handler.getProperty("UDID"));
		setBrowserType(handler.getProperty("BROWSER_TYPE"));
		setAppType(handler.getProperty("APP_TYPE"));
	}

	/**
	 * Generate desired capabilities.
	 *
	 * @return the desired capabilities
	 * @throws Exception the exception
	 */
	public DesiredCapabilities generateDesiredCapabilities() throws Exception {

		DesiredCapabilities capabilities = generateCommonDesiredCapabilities();

		if ("MobileWEB".equalsIgnoreCase(getAppType())) {
			capabilities.setCapability(MobileCapability.AUTO_LAUNCH, true);
			capabilities.setCapability(MobileCapability.BROWSER_NAME,
					getBrowserType());
		} else {
			capabilities.setCapability(MobileCapability.AUTO_LAUNCH, false);
			capabilities.setCapability(MobileCapability.APP, getAppUrl());
			capabilities.setCapability(MobileCapability.NO_RESET, true);
		}
		return capabilities;

	}

	/**
	 * Generate desired capabilities.
	 *
	 * @return the desired capabilities
	 * @throws Exception the exception
	 */
	protected DesiredCapabilities generateCommonDesiredCapabilities()
			throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapability.DEVICE_NAME,
				getDeviceName());
		capabilities.setCapability(MobileCapability.PLATFORM_NAME,
				getPlatformName());
		capabilities.setCapability(MobileCapability.PLATFORM_VERSION,
				getPlatformVersion());
		capabilities.setCapability(MobileCapability.NEW_COMMAND_TIMEOUT, 9000);

		if (getPlatformName().equalsIgnoreCase("IOS")) {
			if (!getMobileUDID().equals("")) {
				capabilities.setCapability(MobileCapability.UDID,
						getMobileUDID());
			}
			capabilities.setCapability(MobileCapability.SHOW_IOS_LOG, true);
		}

		return capabilities;
	}
}
