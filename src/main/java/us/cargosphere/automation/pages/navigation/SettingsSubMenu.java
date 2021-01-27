package us.cargosphere.automation.pages.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.fmc.CreateTariffFclPage;
import us.cargosphere.automation.pages.settings.BusinessUnitPage;
import us.cargosphere.automation.pages.settings.CarriersPage;
import us.cargosphere.automation.pages.settings.CompanyProfilePage;
import us.cargosphere.automation.pages.settings.ContractMarkupPage;
import us.cargosphere.automation.pages.settings.CountryRestrictPage;
import us.cargosphere.automation.pages.settings.CurrencyAdjFactorPage;
import us.cargosphere.automation.pages.settings.CustomerExtAgentsPage;
import us.cargosphere.automation.pages.settings.DisclaimersPage;
import us.cargosphere.automation.pages.settings.GlobalForwarderPage;
import us.cargosphere.automation.pages.settings.IndustryCommGroupPage;
import us.cargosphere.automation.pages.settings.IpAddressPermPage;
import us.cargosphere.automation.pages.settings.ManageAppSettingsPage;
import us.cargosphere.automation.pages.settings.ManageFmcUsersPage;
import us.cargosphere.automation.pages.settings.QuotePackagePrefPage;
import us.cargosphere.automation.pages.settings.TariffOrgRecordPage;
import us.cargosphere.automation.pages.settings.TermsConditionsPage;
import us.cargosphere.automation.pages.settings.UsersPage;
import us.cargosphere.automation.pages.settings.ValueAddedTaxPage;
import us.cargosphere.automation.pages.settings.VipDiscountPage;

public class SettingsSubMenu extends BasePage{
	
	
	@FindBy(how = How.ID, using = "userMenuLink")
	private WebElement usersLink;
	
	@FindBy(how = How.ID, using = "customerExtAgentsLink")
	private WebElement customerExtAgentsLink;
	
	@FindBy(how = How.ID, using = "carriersListLink")
	private WebElement carriersListLink;
	
	@FindBy(how = How.ID, using = "businessUnitsLink")
	private WebElement businessUnitsLink;
	
	@FindBy(how = How.ID, using = "companyProfileLink")
	private WebElement companyProfileLink;
	
	@FindBy(how = How.ID, using = "tariffOrgRecordLink")
	private WebElement tariffOrgRecordLink;
	
	@FindBy(how = How.ID, using = "manageFMCUsersLink")
	private WebElement manageFMCUsersLink;
	
	@FindBy(how = How.ID, using = "manageAppSettingsLink")
	private WebElement manageAppSettingsLink;
	
	@FindBy(how = How.ID, using = "ipAddressPermLink")
	private WebElement ipAddressPermLink;
	
	@FindBy(how = How.ID, using = "countryRestrictLink")
	private WebElement countryRestrictLink;
	
	@FindBy(how = How.ID, using = "indCommGroupsLink")
	private WebElement indCommGroupsLink;
	
	@FindBy(how = How.ID, using = "contractMarkUpLink")
	private WebElement contractMarkUpLink;
	
	@FindBy(how = How.ID, using = "mraDiscountsLink")
	private WebElement mraDiscountsLink;
	
	@FindBy(how = How.ID, using = "currencyAdjustFactorLink")
	private WebElement currencyAdjustFactorLink;
	
	@FindBy(how = How.ID, using = "valueAddedTaxLink")
	private WebElement valueAddedTaxLink;
	
	@FindBy(how = How.ID, using = "quotePackagePrefLink")
	private WebElement quotePackagePrefLink;
	
	@FindBy(how = How.ID, using = "disclaimersLink")
	private WebElement disclaimersLink;
	
	@FindBy(how = How.ID, using = "termsConditionsLink")
	private WebElement termsConditionsLink;
	
	@FindBy(how = How.ID, using = "globalForwarderLink")
	private WebElement globalForwarderLink;
	
	public SettingsSubMenu(WebDriver driver) {
		 super(driver);
	     PageFactory.initElements(driver, this);
	}
	
	public UsersPage clickUsersLink()
	{
		usersLink.click();
	    return new UsersPage(webDriver);
	}
	
	public CustomerExtAgentsPage clickcustomerExtAgentsLink()
	{
		customerExtAgentsLink.click();
	    return new CustomerExtAgentsPage(webDriver);
	}	

	public CarriersPage clickCarriersLink()
	{
		carriersListLink.click();
	    return new CarriersPage(webDriver);
	}	
	
	public BusinessUnitPage clickBusinessUnitLink()
	{
		businessUnitsLink.click();
	    return new BusinessUnitPage(webDriver);
	}
	
	public CompanyProfilePage clickCompanyProfileLink()
	{
		companyProfileLink.click();
	    return new CompanyProfilePage(webDriver);
	}	
	
	public TariffOrgRecordPage clickTariffOrgRecordLink()
	{
		tariffOrgRecordLink.click();
	    return new TariffOrgRecordPage(webDriver);
	}
	
	public ManageFmcUsersPage clickmanageFMCUsersLinkk()
	{
		manageFMCUsersLink.click();
	    return new ManageFmcUsersPage(webDriver);
	}
	
	public ManageAppSettingsPage clickmanageAppSettingsLink()
	{
		manageAppSettingsLink.click();
	    return new ManageAppSettingsPage(webDriver);
	}
	
	public ManageFmcUsersPage clickmanageFMCUsersLink()
	{
		manageFMCUsersLink.click();
	    return new ManageFmcUsersPage(webDriver);
	}	
	
	public IpAddressPermPage clickIpAddressPermLink()
	{
		ipAddressPermLink.click();
	    return new IpAddressPermPage(webDriver);
	}
	
	public CountryRestrictPage clickCountryRestrictLink()
	{
		countryRestrictLink.click();
	    return new CountryRestrictPage(webDriver);
	}
	
	public IndustryCommGroupPage clickIndCommGroupsLink()
	{
		indCommGroupsLink.click();
	    return new IndustryCommGroupPage(webDriver);
	}
	
	public ContractMarkupPage clickContractMarkUpLink()
	{
		contractMarkUpLink.click();
	    return new ContractMarkupPage(webDriver);
	}
	
	public VipDiscountPage clickMraDiscountsLink()
	{
		mraDiscountsLink.click();
	    return new VipDiscountPage(webDriver);
	}
	
	public CurrencyAdjFactorPage clickCurrencyAdjustFactorLink()
	{
		currencyAdjustFactorLink.click();
	    return new CurrencyAdjFactorPage(webDriver);
	}
	
	public ValueAddedTaxPage clickValueAddedTaxLink()
	{
		valueAddedTaxLink.click();
	    return new ValueAddedTaxPage(webDriver);
	}
	
	public QuotePackagePrefPage clickQuotePackagePrefLink()
	{
		quotePackagePrefLink.click();
	    return new QuotePackagePrefPage(webDriver);
	}
	public DisclaimersPage clickDisclaimersLink()
	{
		disclaimersLink.click();
	    return new DisclaimersPage(webDriver);
	}
	
	public TermsConditionsPage clickTermsConditionsLink()
	{
		termsConditionsLink.click();
	    return new TermsConditionsPage(webDriver);
	}
	
	public GlobalForwarderPage  clickGlobalForwarderLink()
	{
		globalForwarderLink.click();
	    return new GlobalForwarderPage(webDriver);
	}
	
}
