package us.cargosphere.automation.pages.quoting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;

public class QuotePermissionsTabPage extends BasePage {
	
	@FindBy(how = How.XPATH, using = "//ui-switch[@id='mngQutCrtReq']//span[@class='switch switch-medium checked']")
	private WebElement rateRequest;

	@FindBy(how = How.XPATH, using = "//ui-switch[@id='mngQutCrtCustQuote']//span[@class='switch switch-medium checked']")
	private WebElement customerQuote;

	@FindBy(how = How.XPATH, using = "//ui-switch[@id='mngQutUptAprCustQuote']//span[@class='switch switch-medium checked']")
	private WebElement updateCustomerQuote;

	@FindBy(how = How.XPATH, using = "//ui-switch[@id='mngQutViewCustQuotes']//span[@class='switch switch-medium checked']")
	private WebElement viewCustomerQuote;
	
	
	public QuotePermissionsTabPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	
	public boolean rateRequest() {
		if (rateRequest.isEnabled())
			return true;
		else
			return false;
	}

	public boolean customerQuote() {
		if (customerQuote.isEnabled())
			return true;
		else
			return false;
	}

	public boolean updateCustomerQuotes() {
		if (updateCustomerQuote.isEnabled())
			return true;
		else
			return false;
	}

	public boolean viewCustomerQuotes() {
		if (viewCustomerQuote.isEnabled())
			return true;
		else
			return false;
	}

}

	

