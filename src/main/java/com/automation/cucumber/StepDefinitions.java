package com.automation.cucumber;

import org.apache.log4j.Logger;

import com.automation.appium.AppiumCommandBase;
import com.automation.appium.DriverInstance;
import com.automation.pages.GoogleMainPage;
import com.automation.pages.SearchResultPage;
import com.automation.utils.PropertyFileReader;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


/**
 * The Class StepDefinitions.
 */
public class StepDefinitions {

	/** The test commands. */
	private AppiumCommandBase caller;

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(DriverInstance.class);

	/**
	 * Sets the up env.
	 */
	@Before
	public void setUpEnv() {
		PropertyFileReader handler = new PropertyFileReader(
				"/execution.properties");
		String platform = handler.getProperty("PLATFORM_NAME");
		caller = new AppiumCommandBase(platform);
	}

	/**
	 * Open browser.
	 *
	 */
	@Given("I open an application in a device.$")
	public void openBrowser() {
		caller.launch();
		caller.waitForElement(GoogleMainPage.textFieldSearch);
	}

	/**
	 * Search text.
	 *
	 * @param query the query
	 */
	@Then("I search \"(.*)\" in google page.$")
	public void searchText(String query) {
		caller.type(GoogleMainPage.textFieldSearch, query);
		caller.waitForElement(GoogleMainPage.btnSearch);
		caller.click(GoogleMainPage.btnSearch);
		caller.waitForElement(SearchResultPage.linkAppium);
	}
	
	/**
	 * Tear down.
	 */
	@After
	public void tearDown(){
		caller.quit();
	}

}
