package com.automation.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * The Class ExecuteFeatureFiles.
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags= "@search", features="src/test/resources")
class ExecuteFeatureFiles {

}


