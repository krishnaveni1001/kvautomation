package us.cargosphere.automation.pages.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.quoting.CurrentQuotePage;
import us.cargosphere.automation.pages.quoting.NewQuotePage;
import us.cargosphere.automation.pages.quoting.NewRfqPage;
import us.cargosphere.automation.pages.quoting.QuotingChangePage;
import us.cargosphere.automation.pages.quoting.RfqQuoteFinderPage;
import us.cargosphere.automation.pages.ratemesh.GuestSystemMgmtPage;
import us.cargosphere.automation.pages.ratemesh.RsnCompanyOutbondPage;

public class QuotingSubMenu extends BasePage{

	@FindBy(how = How.ID, using = "newRFQLink")
	private WebElement newRFQLink;
	
	@FindBy(how = How.ID, using = "newQuoteLink")
	private WebElement newQuoteLink;
	
	@FindBy(how = How.ID, using = "RFQQuoteFinderLink")
	private WebElement RFQQuoteFinderLink;
	
	@FindBy(how = How.ID, using = "quotingChange")
	private WebElement quotingChange;
	
	@FindBy(how = How.ID, using = "currentQuote")
	private WebElement currentQuote;
	
	public QuotingSubMenu(WebDriver driver) {
		 super(driver);
	     PageFactory.initElements(driver, this);
	}


public NewRfqPage clickNewRFQLink()
{
	newRFQLink.click();
    return new NewRfqPage(webDriver);
}

public NewQuotePage clickNewQuoteLink()
{
	newQuoteLink.click();
    return new NewQuotePage(webDriver);
}

public RfqQuoteFinderPage clickRFQQuoteFinderLink()
{
	RFQQuoteFinderLink.click();
    return new RfqQuoteFinderPage(webDriver);
}

public QuotingChangePage clickQuotingChange()
{
	quotingChange.click();
    return new QuotingChangePage(webDriver);
}

public CurrentQuotePage clickCurrentQuote()
{
	currentQuote.click();
    return new CurrentQuotePage(webDriver);
}
}