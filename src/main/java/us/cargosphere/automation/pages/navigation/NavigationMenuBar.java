package us.cargosphere.automation.pages.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.ratesearch.RateSearchStartPage;

public class NavigationMenuBar extends BasePage{
	
		@FindBy(how = How.ID, using = "rateSearchMenu")
		private WebElement rateSearchNav;

		@FindBy(how = How.ID, using = "rateMgmtMenu")
		private WebElement rateMgmtNav;

		@FindBy(how = How.ID, using = "rateMeshMenu")
		private WebElement rateMeshNav;
		
		@FindBy(how = How.ID, using = "quotingMenu")
		private WebElement quotingNav;
		
		@FindBy(how = How.ID, using = "fmcMenu")
		private WebElement fmcNav;
		
		@FindBy(how = How.ID, using = "reportsMenuLink")
		private WebElement reportsNav;
		
		@FindBy(how = How.ID, using = "adminMenuLink")
		private WebElement adminNav;

		@FindBy(how = How.ID, using = "userMenuLink")
		private WebElement userNav;
	
		public NavigationMenuBar(WebDriver driver) {
			 super(driver);
		     PageFactory.initElements(driver, this);
		}

		public boolean isRateSearchNavVisible() {
			return rateSearchNav.isDisplayed();
		}

		public void clickRateSearchNav() {
			rateSearchNav.click();
		}

	    public boolean isRateMgmtNavVisible() {
			return rateMgmtNav.isDisplayed();
		}

	    public void clickRateMgmtNav() {
			rateMgmtNav.click();
		}

		public RateMgmtSubMenu getRateMgmtNav()
	    {
	    	// Click button if rate management sub menu not already open
	    	if(!webDriver.findElement(By.cssSelector("#rateMgmtMenu > ul")).isDisplayed()){
	    		clickRateMgmtNav();
			}
	        return new RateMgmtSubMenu(webDriver);
	    }
		
		public ReportsSubMenu getReportsNav()
	    {
	    	// Click button if reports sub menu not already open
	    	if(!webDriver.findElement(By.cssSelector("#reportsMenu > ul")).isDisplayed()){
	    		clickReportsNav();
			}
	        return new ReportsSubMenu(webDriver);
	    }

	    public boolean isRateMeshNavVisible() {
			return rateMeshNav.isDisplayed();
		}

		public void clickRateMeshNav() {
			rateMeshNav.click();
		}

		public RateMeshSubMenu getRateMeshSubmenu() {
			WebElement rateMeshSubmenu = webDriver.findElement(By.cssSelector("#rateMeshMenu > ul"));
			if(!rateMeshSubmenu.isDisplayed()) {
				clickRateMeshNav();
			}
			return new RateMeshSubMenu(webDriver, rateMeshSubmenu);
		}

	    public boolean isQuotingNavVisible () {
			return quotingNav.isDisplayed();
		}

		public QuotingSubMenu clickQuotingNav()
	    {
			quotingNav.click();
	        return new QuotingSubMenu(webDriver);
	    }

	    public boolean isFmcNavVisible() {
			return fmcNav.isDisplayed();
		}

		public FMCSubMenu clickFmcNav()
	    {
			fmcNav.click();
	        return new FMCSubMenu(webDriver);
	    }

	    public boolean isReportsNavVisible() {
			return reportsNav.isDisplayed();
		}

		public ReportsSubMenu clickReportsNav()
	    {
			reportsNav.click();
	        return new ReportsSubMenu(webDriver);
	    }

	    public boolean isAdminMenuButtonVisible () {
			return adminNav.isDisplayed();
		}

		public void clickAdminMenuGear () {
			adminNav.click();
		}

		public AdminSubMenu getAdminSubMenu () {
			WebElement adminSubMenuElement = webDriver.findElement(By.cssSelector("#adminMenu > ul"));
			if(!adminSubMenuElement.isDisplayed()) {
				clickAdminMenuGear();
			}
			return new AdminSubMenu(webDriver, adminSubMenuElement);
		}

	    public void clickUserSubMenu() {
			userNav.click();
		}

	    public UserSubMenu getUserSubMenu() {
			WebElement userSubMenuElement = webDriver.findElement(By.cssSelector("#userMenu > ul"));
			if(!userSubMenuElement.isDisplayed()) {
				clickUserSubMenu();
			}
			return new UserSubMenu(webDriver, userSubMenuElement);
		}
}
