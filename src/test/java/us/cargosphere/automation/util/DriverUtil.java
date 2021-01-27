package us.cargosphere.automation.util;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import us.cargosphere.automation.CucumberRunner;

public class DriverUtil {

	protected static WebDriver driver;

	public static WebDriver getWebDriver(String chromedriverPath, boolean headless) {
		System.setProperty("webdriver.chrome.driver", chromedriverPath);
		System.out.println("Using driver path: " + chromedriverPath);
		if (headless) {
			return DriverUtil.getHeadlessDiver(chromedriverPath);
		} else {
			return DriverUtil.getDefaultDriver(chromedriverPath);
		}
	}

	private static WebDriver getHeadlessDiver(String chromedriverPath) {
		ChromeOptions options = DriverUtil.getHadlessOptions();
		driver = new ChromeDriver(options);
		return driver;
	}

	private static ChromeOptions getHadlessOptions() {
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		if (CucumberRunner.cmd.hasOption(Flags.Long.HEADLESS)) {
			options.addArguments("--headless");
		}
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-gpu"); // applicable to windows os only
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--no-sandbox"); // Bypass OS security model
		options.addArguments("--allow-insecure-localhost");
		options.addArguments("window-size=3840x2160");
		options.merge(capabilities);
		return options;
	}

	private static WebDriver getDefaultDriver(String chromedriverPath) {
		driver = new ChromeDriver();
		return driver;
	}

	public static WebElement waitAndGetElementByCssSelector(WebDriver driver, String selector, int seconds) {
		By selection = By.cssSelector(selector);
		return (new WebDriverWait(driver, seconds)).until( // ensure element is visible!
				ExpectedConditions.visibilityOfElementLocated(selection));
	}

	public static void closeDriver() {
		if (driver != null) {
			try {
			driver.close();
				// driver.quit(); // fails in current geckodriver! TODO: Fixme
			} catch (NoSuchMethodError nsme) { // in case quit fails
			} catch (NoSuchSessionException nsse) { // in case close fails
			} catch (SessionNotCreatedException snce) {
			} // in case close fails
			driver = null;
		}
	}
	
	public static String getFromCookie(String key) throws IOException {
		return driver.manage().getCookieNamed(key).getValue();
	
	}
	public static boolean checkIfCookie(String key) throws IOException {
		return driver.manage().getCookieNamed(key)!=null;
	
	}
	
	public static String getFromLocalStorage(String key) throws IOException {
		return (String)((JavascriptExecutor)driver).executeScript(String.format(
	            "return window.localStorage.getItem('%s');", key));

	}
	public static boolean checkIfLocalStorage(String key) throws IOException {
		String value = (String)((JavascriptExecutor)driver).executeScript(String.format(
	            "return window.localStorage.getItem('%s');", key));
		return StringUtils.isNotEmpty(value);

	}
}
