package us.cargosphere.automation.util;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import us.cargosphere.automation.CucumberRunner;

public class BrowserUtil {
	private static final String DRIVER_PATH = CucumberRunner.cmd.getOptionValue(Flags.Long.CHROME_DRIVER_PATH);

	private static BrowserUtil browserUtilInstance = null;
	private WebDriver webDriver;

	public static BrowserUtil getInstance() {
		if (browserUtilInstance == null) {
			browserUtilInstance = new BrowserUtil();
			browserUtilInstance.webDriver = DriverUtil.getWebDriver(DRIVER_PATH, true);
		}
		if (null == browserUtilInstance.webDriver) {
			browserUtilInstance.webDriver = DriverUtil.getWebDriver(DRIVER_PATH, true);			
		}
		return browserUtilInstance;
	}

	public WebDriver getWebDriver() {
		return browserUtilInstance.webDriver;
	}

	public static void close() {
	//	browserUtilInstance.webDriver.close();
	//	browserUtilInstance = null;
	}

	public static void saveToLocalStorage(String key, String value) throws IOException {
		if(browserUtilInstance.webDriver instanceof WebStorage) {
			WebStorage webStorage = (WebStorage) browserUtilInstance.webDriver;
			LocalStorage localStorage = webStorage.getLocalStorage();
			localStorage.setItem(key, value);
		} else {
			throw new IOException("This browser driver does not support local storage.");
		}
	}

	public static String getFromLocalStorage(String key) throws IOException {
		if(browserUtilInstance.webDriver instanceof WebStorage) {
			WebStorage webStorage = (WebStorage) browserUtilInstance.webDriver;
			LocalStorage localStorage = webStorage.getLocalStorage();
			return localStorage.getItem(key);
		} else {
			throw new IOException("This browser driver does not support local storage.");
		}
	}
}
