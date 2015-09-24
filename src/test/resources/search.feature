@search
Feature: Android web script executes with appium and cucumber.

  Scenario Outline: Search Appium in google.
    Given I open an application in a device.
    Then I search "<query>" in google page.
    Examples:
    |query|
    |Appium|
    |Selenium|