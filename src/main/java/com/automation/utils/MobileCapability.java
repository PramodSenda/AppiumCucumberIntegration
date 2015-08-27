package com.automation.utils;

import org.openqa.selenium.remote.CapabilityType;


// TODO: Auto-generated Javadoc
/**
 * The Interface MobileCapability.
 */
public interface MobileCapability extends CapabilityType {

	// Appium server capabilities
	/** The automation name. */
	String AUTOMATION_NAME = "automationName";
	
	/** The platform name. */
	String PLATFORM_NAME = "platformName";
	
	/** The platform version. */
	String PLATFORM_VERSION = "platformVersion";
	
	/** The device name. */
	String DEVICE_NAME = "deviceName";
	
	/** The app. */
	String APP = "app";
	
	/** The browser name. */
	String BROWSER_NAME = "browserName";
	
	/** The new command timeout. */
	String NEW_COMMAND_TIMEOUT = "newCommandTimeout";
	
	/** The auto launch. */
	String AUTO_LAUNCH = "autoLaunch";
	
	/** The language. */
	String LANGUAGE = "language";
	
	/** The locale. */
	String LOCALE = "locale";
	
	/** The udid. */
	String UDID = "udid";
	
	/** The orientation. */
	String ORIENTATION = "orientation";
	
	/** The auto webview. */
	String AUTO_WEBVIEW = "autoWebview";
	
	/** The no reset. */
	String NO_RESET = "noReset";
	
	/** The full reset. */
	String FULL_RESET = "fullReset";

	// Appium server capabilities (ANDROID ONLY)
	/** The app activity. */
	String APP_ACTIVITY = "appActivity";
	
	/** The app package. */
	String APP_PACKAGE = "appPackage";
	
	/** The app wait activity. */
	String APP_WAIT_ACTIVITY = "appWaitActivity";
	
	/** The app wait package. */
	String APP_WAIT_PACKAGE = "appWaitPackage";
	
	/** The device ready timeout. */
	String DEVICE_READY_TIMEOUT = "deviceReadyTimeout";
	
	/** The android coverage. */
	String ANDROID_COVERAGE = "androidCoverage";
	
	/** The enable performance logging. */
	String ENABLE_PERFORMANCE_LOGGING = "enablePerformanceLogging";
	
	/** The android device ready timeout. */
	String ANDROID_DEVICE_READY_TIMEOUT = "androidDeviceReadyTimeout";
	
	/** The android device socket. */
	String ANDROID_DEVICE_SOCKET = "androidDeviceSocket";
	
	/** The avd. */
	String AVD = "avd";
	
	/** The avd launch timeout. */
	String AVD_LAUNCH_TIMEOUT = "avdLaunchTimeout";
	
	/** The avd ready timeout. */
	String AVD_READY_TIMEOUT = "avdReadyTimeout";
	
	/** The avd args. */
	String AVD_ARGS = "avdArgs";
	
	/** The use keystore. */
	String USE_KEYSTORE = "useKeystore";
	
	/** The keystore path. */
	String KEYSTORE_PATH = "keystorePath";
	
	/** The keystore password. */
	String KEYSTORE_PASSWORD = "keystorePassword";
	
	/** The key alias. */
	String KEY_ALIAS = "keyAlias";
	
	/** The key password. */
	String KEY_PASSWORD = "keyPassword";
	
	/** The chromedriver executable. */
	String CHROMEDRIVER_EXECUTABLE = "chromedriverExecutable";
	
	/** The auto webview timeout. */
	String AUTO_WEBVIEW_TIMEOUT = "autoWebviewTimeout";
	
	/** The intent action. */
	String INTENT_ACTION = "intentAction";
	
	/** The intent category. */
	String INTENT_CATEGORY = "intentCategory";
	
	/** The intent flags. */
	String INTENT_FLAGS = "intentFlags";
	
	/** The optional intent arguments. */
	String OPTIONAL_INTENT_ARGUMENTS = "optionalIntentArguments";
	
	/** The dont stop app on reset. */
	String DONT_STOP_APP_ON_RESET = "dontStopAppOnReset";
	
	/** The unicode keyboard. */
	String UNICODE_KEYBOARD = "unicodeKeyboard";
	
	/** The reset keyboard. */
	String RESET_KEYBOARD = "resetKeyboard";
	
	/** The no sign. */
	String NO_SIGN = "noSign";
	
	/** The ignore unimportant views. */
	String IGNORE_UNIMPORTANT_VIEWS = "ignoreUnimportantViews";
	
	/** The disable android watchers. */
	String DISABLE_ANDROID_WATCHERS = "disableAndroidWatchers";

	// Appium server capabilities (IOS ONLY)
	/** The calendar format. */
	String CALENDAR_FORMAT = "calendarFormat";
	
	/** The bundle id. */
	String BUNDLE_ID = "bundleId";
	
	/** The launch timeout. */
	String LAUNCH_TIMEOUT = "launchTimeout";
	
	/** The location services enabled. */
	String LOCATION_SERVICES_ENABLED = "locationServicesEnabled";
	
	/** The location services authorized. */
	String LOCATION_SERVICES_AUTHORIZED = "locationServicesAuthorized";
	
	/** The auto accept alerts. */
	String AUTO_ACCEPT_ALERTS = "autoAcceptAlerts";
	
	/** The auto dismiss alerts. */
	String AUTO_DISMISS_ALERTS = "autoDismissAlerts";
	
	/** The native instruments lib. */
	String NATIVE_INSTRUMENTS_LIB = "nativeInstrumentsLib";
	
	/** The native web tap. */
	String NATIVE_WEB_TAP = "nativeWebTap";
	
	/** The safari initial url. */
	String SAFARI_INITIAL_URL = "safariInitialUrl";
	
	/** The safari allow popups. */
	String SAFARI_ALLOW_POPUPS = "safariAllowPopups";
	
	/** The safari ignore fraud warning. */
	String SAFARI_IGNORE_FRAUD_WARNING = "safariIgnoreFraudWarning";
	
	/** The safari open links in background. */
	String SAFARI_OPEN_LINKS_IN_BACKGROUND = "safariOpenLinksInBackground";
	
	/** The keep key chains. */
	String KEEP_KEY_CHAINS = "keepKeyChains";
	
	/** The localizable strings dir. */
	String LOCALIZABLE_STRINGS_DIR = "localizableStringsDir";
	
	/** The process arguments. */
	String PROCESS_ARGUMENTS = "processArguments";
	
	/** The inter key delay. */
	String INTER_KEY_DELAY = "interKeyDelay";
	
	/** The show ios log. */
	String SHOW_IOS_LOG = "showIOSLog";
	
	/** The send key strategy. */
	String SEND_KEY_STRATEGY = "sendKeyStrategy";
	
	/** The screenshot wait timeout. */
	String SCREENSHOT_WAIT_TIMEOUT = "screenshotWaitTimeout";
	
	/** The wait for app script. */
	String WAIT_FOR_APP_SCRIPT = "waitForAppScript";

	/** The selendroid port. */
	String SELENDROID_PORT = "selendroidPort";
	// Sauce-specific
	/** The appium version. */
	String APPIUM_VERSION = "appiumVersion";
}
