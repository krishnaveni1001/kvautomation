package us.cargosphere.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Abstract class representation of a page in the UI. Page Object Model pattern
 */
public abstract class BasePage {

	protected WebDriver webDriver;

	protected BasePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	

	/**
	 * Constructor used for page fragments
	 * 
	 * @param searchContext
	 */
	public BasePage(WebDriver webDriver, WebElement searchContext) {
		// Enable an implicit wait of ten seconds for attempted UI interactions
	   webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.webDriver = webDriver;
		this.webDriver.manage().window().maximize();
		PageFactory.initElements(new DefaultElementLocatorFactory(searchContext), this);
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}
	
	
	

	public String getTitle() {
		return webDriver.getTitle();
	}
	
	public void closeCurrentWindow() {
		   String base = webDriver.getWindowHandle();
		   Set<String> set = webDriver.getWindowHandles();
		   set.remove(base);
		   assert set.size()==1;

		   webDriver.switchTo().window(set.toString());

		   webDriver.close();
		   webDriver.switchTo().window(base);
	}
}