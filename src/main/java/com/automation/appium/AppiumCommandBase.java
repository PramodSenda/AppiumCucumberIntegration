package com.automation.appium;


import org.apache.log4j.Logger;

import com.automation.utils.PropertyFileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// TODO: Auto-generated Javadoc
/**
 * The Class AppiumCommandBase.
 */
public class AppiumCommandBase extends DriverInstance{


	/**
	 * Instantiates a new appium command base.
	 *
	 * @param platform the device type
	 */
	public AppiumCommandBase(String platform) {
		super(platform);
		init();
	}

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(AppiumCommandBase.class);

	/** The time out. */
	private int timeOut;

	/** The nativeApp url. */
	private String nativeAppUrl;

	/** The web url. */
	private String webUrl;

	/**
	 * Gets the web url.
	 *
	 * @return the web url
	 */
	public String getWebUrl() {
		return webUrl;
	}

	/**
	 * Sets the web url.
	 *
	 * @param webUrl the new web url
	 */
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	/** The app type. */
	private String appType;

	

	/**
	 * Gets the time out.
	 * 
	 * @return the time out
	 */
	public int getTimeOut() {
		return timeOut;
	}

	/**
	 * Sets the time out.
	 * 
	 * @param timeOut
	 *            the new time out
	 */
	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	/**
	 * Gets the app url.
	 * 
	 * @return the app url
	 */
	public String getNativeAppUrl() {
		return nativeAppUrl;
	}

	/**
	 * Sets the app url.
	 * 
	 * @param appUrl
	 *            the new app url
	 */
	public void setNativeAppUrl(String appUrl) {
		this.nativeAppUrl = appUrl;
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
	 * @param appType
	 *            the new app type
	 */
	public void setAppType(String appType) {
		this.appType = appType;
	}


	/**
	 * Initializes the execution parameters.
	 */
	private void init() {

		PropertyFileReader handler = new PropertyFileReader(
				"/execution.properties");
		setTimeOut(Integer.parseInt(handler.getProperty("TIMEOUT")));
		setNativeAppUrl(handler.getProperty("NATIVE_APP_URL"));
		setWebUrl(handler.getProperty("WEB_APP_URL"));
		setAppType(handler.getProperty("APP_TYPE"));

	}

	/**
	 * Find element in the web page.
	 * 
	 * @param byLocator
	 *            the by locator
	 * @return the web element
	 */
	private WebElement findElement(By byLocator) {

		WebElement element = (new WebDriverWait(getDriver(), getTimeOut()))
				.until(ExpectedConditions.presenceOfElementLocated(byLocator));

		return element;
	}

	/**
	 * Wait for element in the web page.
	 * 
	 * @param byLocator
	 *            the by locator
	 */
	public void waitForElement(By byLocator) {

		findElement(byLocator);
		logger.info("Wait for web element " + byLocator + " to present.");
	}

	/**
	 * Launch the given url.
	 *
	 */
	public void launch() {

		try {
			if ("MobileWeb".equalsIgnoreCase(getAppType())) {
				getDriver().navigate().to(getWebUrl());
				logger.info("Launch the URL " + getWebUrl() + " successfully.");
			} else {
				getDriver().launchApp();
				logger.info("Launch the URL " + getNativeAppUrl()
						+ " successfully.");
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * Type on a web element.
	 * 
	 * @param byLocator
	 *            the by locator
	 * @param text
	 *            the text
	 */
	public void type(By byLocator, String text) {

		try {
			WebElement element = findElement(byLocator);
			element.sendKeys(text);
			logger.info("Typed the value " + text + " in to object "
					+ byLocator);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * Click on a web element.
	 * 
	 * @param byLocator
	 *            the by locator
	 * 
	 */
	public void click(By byLocator) {
		try {
			WebElement element = findElement(byLocator);
			element.click();
			logger.info("Clicked on the object" + byLocator);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * get specific property value of a web element and stores to string
	 * variable.
	 * 
	 * @param property
	 *            the property of the element.
	 * @param byLocator
	 *            the by locator
	 * @return value of the property.
	 */
	public String getElementPropertyToString(String property, By byLocator) {
		String propertyValue = null;
		try {
			WebElement element = findElement(byLocator);
			propertyValue = element.getAttribute(property);
			logger.info("Stored the property value of the object " + byLocator
					+ " property :" + property + "value : " + propertyValue);
		} catch (Exception e) {
			logger.error(e);
		}
		return propertyValue;
	}
	
	/**
	 * Check element present.
	 *
	 * @param byLocator the by locator
	 * @return true, if successful
	 */
	public boolean checkElementPresent(By byLocator){
		try {
			findElement(byLocator);
            return true;
        } catch (Exception e) {
            return false;
        } 
	}

}
