package us.cargosphere.automation.pages.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.fmc.CreateTariffFclPage;
import us.cargosphere.automation.pages.fmc.CreateTariffLclPage;
import us.cargosphere.automation.pages.fmc.FmcTariffViewerPage;
import us.cargosphere.automation.pages.fmc.NraFinderPage;
import us.cargosphere.automation.pages.fmc.TariffConsolePage;
import us.cargosphere.automation.pages.reports.ContractReportPage;

public class FMCSubMenu extends BasePage{

	@FindBy(how = How.ID, using = "createTariffLinkFCL")
	private WebElement createTariffLinkFCL;
	
	@FindBy(how = How.ID, using = "triFinderLink")
	private WebElement triFinderLink;
	
	@FindBy(how = How.ID, using = "createTariffLinkLCL")
	private WebElement createTariffLinkLCL;
	
	@FindBy(how = How.ID, using = "nraFinderLink")
	private WebElement nraFinderLink;
	
	@FindBy(how = How.ID, using = "fmcTariffviewerLink")
	private WebElement fmcTariffviewerLink;
	
	public FMCSubMenu(WebDriver driver) {
		 super(driver);
	     PageFactory.initElements(driver, this);
	}


public CreateTariffFclPage clickCreateTariffFclLink()
{
	createTariffLinkFCL.click();
    return new CreateTariffFclPage(webDriver);
}
public CreateTariffLclPage clickCreateTariffLclLink()
{
	createTariffLinkLCL.click();
    return new CreateTariffLclPage(webDriver);
}
public TariffConsolePage clickTariffConsoleLink()
{
	triFinderLink.click();
    return new TariffConsolePage(webDriver);
}
public FmcTariffViewerPage clickFmcTariffViwerLink()
{
	fmcTariffviewerLink.click();
    return new FmcTariffViewerPage(webDriver);
}
public NraFinderPage clickNraFinderLink()
{
	nraFinderLink.click();
    return new NraFinderPage(webDriver);
}
}