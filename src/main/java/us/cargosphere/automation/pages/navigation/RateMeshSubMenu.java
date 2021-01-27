package us.cargosphere.automation.pages.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.ratemesh.AirRateSearchInRatemeshPage;
import us.cargosphere.automation.pages.ratemesh.GuestSystemMgmtPage;
import us.cargosphere.automation.pages.ratemesh.OceanRateSearchInRateMeshpage;
import us.cargosphere.automation.pages.ratemesh.RateShareReqPage;
import us.cargosphere.automation.pages.ratemesh.RsnCompanyInbondPage;
import us.cargosphere.automation.pages.ratemesh.RsnCompanyOutbondPage;
import us.cargosphere.automation.pages.ratemesh.RsnConnMgmtPage;
import us.cargosphere.automation.pages.ratemesh.RsnInvMgmtPage;
import us.cargosphere.automation.pages.ratemesh.RsnPrivacySetPage;
import us.cargosphere.automation.pages.settings.CompanyProfilePage;

public class RateMeshSubMenu extends BasePage{
	@FindBy(how = How.ID, using = "rateShareReqLink")
	private WebElement	rateShareReqLink;
	
	@FindBy(how = How.ID, using = "RSNInvMgmtLink")
	private WebElement RSNInvMgmtLink;	
	
	@FindBy(how = How.ID, using = "RSNConnMgmtLink")
	private WebElement RSNConnMgmtLink;	
	
	@FindBy(how = How.ID, using = "RSNCompanyInLink")
	private WebElement RSNCompanyInLink;	
	
	@FindBy(how = How.ID, using = "rateSearchInRateMeshLink")
	private WebElement rateSearchInRateMeshLink;
	
	@FindBy(how = How.ID, using = "airRateSearchLink")
	private WebElement airRateSearchLink;	
	
	@FindBy(how = How.ID, using = "GSMLink")
	private WebElement GSMLink;
	
	@FindBy(how = How.ID, using = "RSNCompanyOutLink")
	private WebElement RSNCompanyOutLink;
	
	@FindBy(how = How.ID, using = "RSNPrivacySetLink")
	private WebElement RSNPrivacySetLink;
	
	public RateMeshSubMenu(WebDriver driver, WebElement el) {
		 super(driver, el);
	     PageFactory.initElements(driver, this);
	}
	
	public RateShareReqPage clickRateShareReqLink()
	{
		rateShareReqLink.click();
	    return new RateShareReqPage(webDriver);
	}	
	
	public RsnInvMgmtPage clickRSNInvMgmtLink()
	{
		RSNInvMgmtLink.click();
	    return new RsnInvMgmtPage(webDriver);
	}
	public RsnConnMgmtPage clickRSNConnMgmtLink()
	{
		RSNConnMgmtLink.click();
	    return new RsnConnMgmtPage(webDriver);
	}

	public RsnCompanyInbondPage clickRSNCompanyInLink()
	{
		RSNCompanyInLink.click();
	    return new RsnCompanyInbondPage(webDriver);
	}
	
	public OceanRateSearchInRateMeshpage clickRateSearchInRateMeshLink()
	{
		rateSearchInRateMeshLink.click();
	    return new OceanRateSearchInRateMeshpage(webDriver);
	}
	
	public AirRateSearchInRatemeshPage clickAirRateSearchLink()
	{
		airRateSearchLink.click();
	    return new AirRateSearchInRatemeshPage(webDriver);
	}
	
	public GuestSystemMgmtPage clickGSMLink()
	{
		GSMLink.click();
	    return new GuestSystemMgmtPage(webDriver);
	}
	
	public RsnCompanyOutbondPage clickRSNCompanyOutLink()
	{
		RSNCompanyOutLink.click();
	    return new RsnCompanyOutbondPage(webDriver);
	}

	public RsnPrivacySetPage clickRSNPrivacySetLink()
	{
		RSNPrivacySetLink.click();
	    return new RsnPrivacySetPage(webDriver);
	}
	
	
}
