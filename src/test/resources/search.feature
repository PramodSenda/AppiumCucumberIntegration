@search
Feature: Android web script executes with appium and cucumber.

  Scenario: Search Appium in google.
    Given I open an application in a device.
    Then I search "Appium" in google page.