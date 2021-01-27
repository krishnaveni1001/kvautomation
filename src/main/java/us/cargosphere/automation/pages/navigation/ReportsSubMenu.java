package us.cargosphere.automation.pages.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.ratemanagement.RateMgmtChooseCarrierPage;
import us.cargosphere.automation.pages.reports.ContractReportPage;
import us.cargosphere.automation.pages.reports.EsudsDashboardPage;
import us.cargosphere.automation.pages.reports.FutureRateReportPage;
import us.cargosphere.automation.pages.reports.GriReportPage;
import us.cargosphere.automation.pages.reports.QuoteAnalyticReportPage;
import us.cargosphere.automation.pages.reports.QuoteVolumeReportPage;
import us.cargosphere.automation.pages.reports.RateExpirationReportPage;
import us.cargosphere.automation.pages.reports.SudsDashboardPage;
import us.cargosphere.automation.pages.reports.SurchargeTrendDashboardPage;
import us.cargosphere.automation.pages.reports.SystemUsageReprtPage;
import us.cargosphere.automation.pages.reports.TriReportPage;
import us.cargosphere.automation.pages.reports.UserLoginReportPage;
import us.cargosphere.automation.pages.reports.UserRatesearchDashboardPage;
import us.cargosphere.automation.pages.reports.VccReportPage;
import us.cargosphere.automation.pages.reports.BaseTrendDashboardPage;
import us.cargosphere.automation.pages.reports.BunkOmissionReportPage;
import us.cargosphere.automation.pages.reports.ConReqAprReportPage;
import us.cargosphere.automation.pages.reports.ContractDashboardPage;

public class ReportsSubMenu extends BasePage{
	
	@FindBy(how = How.ID, using = "reportsMenuLink")
	private WebElement reportsMenuLink;

	@FindBy(how = How.ID, using = "bunkerOmissionLink")
	private WebElement bunkerOmissionLink;
	
	@FindBy(how = How.ID, using = "contractReportLink")
	private WebElement contractReportLink;
	
	@FindBy(how = How.ID, using = "conReqAprReportLink")
	private WebElement conReqAprReportLink;
	
	@FindBy(how = How.ID, using = "futureRateLink")
	private WebElement futureRateLink;
	
	@FindBy(how = How.ID, using = "griLink")
	private WebElement griLink;
	
	@FindBy(how = How.ID, using = "quoteLink")
	private WebElement quoteLink;
	
	@FindBy(how = How.ID, using = "quoteAnalyticsPermLink")
	private WebElement quoteAnalyticsPermLink;
	
	@FindBy(how = How.ID, using = "rateExpirationLink")
	private WebElement rateExpirationLink;
	
	@FindBy(how = How.ID, using = "vccReportLink")
	private WebElement vccReportLink;
	
	@FindBy(how = How.ID, using = "systemUsagePermLink")
	private WebElement systemUsagePermLink;
	
	@FindBy(how = How.ID, using = "userLoginLink")
	private WebElement userLoginLink;
	
	@FindBy(how = How.ID, using = "triLink")
	private WebElement triLink;
	
	@FindBy(how = How.ID, using = "contractsDashLink")
	private WebElement contractsDashLink;
	
	@FindBy(how = How.ID, using = "esudsDashLink")
	private WebElement esudsDashLink;
	
	@FindBy(how = How.ID, using = "sudsDashLink")
	private WebElement sudsDashLink;
	
	@FindBy(how = How.ID, using = "userRatesearchDashLink")
	private WebElement userRatesearchDashLink;
	
	@FindBy(how = How.ID, using = "baseTrendDashLink")
	private WebElement baseTrendDashLink;
	
	@FindBy(how = How.ID, using = "surTrendDashLink")
	private WebElement surTrendDashLink;
	
	public ReportsSubMenu(WebDriver driver) {
		 super(driver);
	     PageFactory.initElements(driver, this);
	}
	
	public void clickReportMenuLink()
	{
		reportsMenuLink.click();
	}
	
	public BunkOmissionReportPage clickBunkerOmissionLink()
    {
		bunkerOmissionLink.click();
        return new BunkOmissionReportPage(webDriver);
    }
	
	public ContractReportPage clickContractReportLink()
    {
		contractReportLink.click();
        return new ContractReportPage(webDriver);
    }
	public ConReqAprReportPage clickConReqAprReportLink()
    {
		conReqAprReportLink.click();
        return new ConReqAprReportPage(webDriver);
    }
	
	public FutureRateReportPage clickFutureReportLink()
    {
		futureRateLink.click();
        return new FutureRateReportPage(webDriver);
    }
	
	public GriReportPage clickGriReportLink()
    {
		griLink.click();
        return new GriReportPage(webDriver);
    }
	public QuoteVolumeReportPage clickQuoteVolumeReportLink()
    {
		quoteLink.click();
        return new QuoteVolumeReportPage(webDriver);
    }
	public QuoteAnalyticReportPage clickQuoteAnalyticsReportLink()
    {
		quoteAnalyticsPermLink.click();
        return new QuoteAnalyticReportPage(webDriver);	
    }
	public RateExpirationReportPage clickRateExpirationReportLink()
    {
		rateExpirationLink.click();
        return new RateExpirationReportPage(webDriver);
    }
	public VccReportPage clickVccReportLink()
    {
		vccReportLink.click();
        return new VccReportPage(webDriver);
    }
	public SystemUsageReprtPage clickSystemUsageReportLink()
    {
		systemUsagePermLink.click();
        return new SystemUsageReprtPage(webDriver);
    }
	public UserLoginReportPage clickUserLoginReportLink()
    {
		userLoginLink.click();
        return new UserLoginReportPage(webDriver);
    }
	public TriReportPage clickTriReportLink()
    {
		triLink.click();
        return new TriReportPage(webDriver);
    }
	public ContractDashboardPage clickContractDashboardLink()
    {
		contractsDashLink.click();
        return new ContractDashboardPage(webDriver);
    }
	public EsudsDashboardPage clickEsudsDashboardLink()
    {
		esudsDashLink.click();
        return new EsudsDashboardPage(webDriver);
    }
	public SudsDashboardPage clickSudsDashboardLink()
    {
		sudsDashLink.click();
        return new SudsDashboardPage(webDriver);
    }
	
	public UserRatesearchDashboardPage clickUserRatesearchDashboardLink()
    {
		userRatesearchDashLink.click();
        return new UserRatesearchDashboardPage(webDriver);
    }
	public BaseTrendDashboardPage clickBaseTrendDashboardLink()
    {
		baseTrendDashLink.click();
        return new BaseTrendDashboardPage(webDriver);
    }
	public SurchargeTrendDashboardPage clickSurchargeTrendDashboardLink()
    {
		surTrendDashLink.click();
        return new SurchargeTrendDashboardPage(webDriver);
    }
}
