package us.cargosphere.automation.pages.admin.usermanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.admin.usermanagement.CommonPermissionPage;

import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class SystemAdminPermissionTab extends BasePage {
private NavigationMenuBar naviMenuBar;
    
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}

    @FindBy(how = How.ID, using = "systemAdmin_tab")
    private WebElement systemAdminTab;
	
    
	@FindBy(how = How.ID, using = "mngSysComProfile")
    private WebElement mngCompanyProfile;
	
	@FindBy(how = How.ID, using = "mngSysBU")
    private WebElement mngBusinessUnit;
	
	@FindBy(how = How.ID, using = "mngSysSuperUsr")
    private WebElement mngSuperUser;
	
	@FindBy(how = How.ID, using = "manageAppSetting")
    private WebElement mngAppSetting;
	
	@FindBy(how = How.ID, using = "manageIP")
    private WebElement mngIPAdress;
	
	@FindBy(how = How.ID, using = "mngSysCommGrp")
    private WebElement mngCommGrp;
	
	@FindBy(how = How.ID, using = "mngSysConMarkUp")
    private WebElement mngContractMarkUp;
	
	@FindBy(how = How.ID, using = "mngSysVIPDis")
    private WebElement mngVIPDiscount;
	
	
	@FindBy(how = How.CSS, using = "#mngSysQuoteSet > span")
    private WebElement mngQuoteSetings;
	
	@FindBy(how = How.ID, using = "mngSysQuoteSet")
    private WebElement mngQSetings;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"systemAdmin\"]/div[9]/div[2]/div[1]/span/label/span[2]")
    private WebElement mngVIP1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"systemAdmin\"]/div[9]/div[2]/div[2]/span/label/span[2]")
    private WebElement mngVIP2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"systemAdmin\"]/div[10]/div[2]/div[1]/span/div[1]/label/span[2]")
    private WebElement mngCurrencyBump;
	
	@FindBy(how = How.ID, using = "mngSysCurBump")
    private WebElement curBump;
	
	@FindBy(how = How.ID, using = "mngSysDisclaimer")
    private WebElement mngDisclaimer;
	
	@FindBy(how = How.ID, using = "mngSysValueAdded")
    private WebElement mngValueAdded;
	
	@FindBy(how = How.ID, using = "mngSysTermsCon")
    private WebElement mngTermsCon;
	
	@FindBy(how = How.ID, using = "mngSysQuotePackPre")
    private WebElement mngQuotePackPref;
	
	@FindBy(how = How.ID, using = "mngSysGlobalForw")
    private WebElement mngGlobalForward;
	
	
	
	@FindBy(how = How.ID, using = "mngSysEnableAll")
    private WebElement enableAll;
	
	@FindBy(how = How.ID, using = "mngSysDisableAll")
    private WebElement disableAll;
	
	@FindBy(how = How.ID, using = "register")
    private WebElement saveButton;
	
	@FindBy(how = How.ID, using = "cancelBtn")
    private WebElement cancelButton;
	
	@FindBy(how = How.ID, using = "quickFilter")
   	private WebElement filterId;
    
	
    @FindBy(how = How.XPATH, using = "//*[@id=\"borderLayout_eGridPanel\"]/div[1]/div/div[4]/div[3]/div/div/div/div[2]")
   	private WebElement editUser;
    
    
    public void clickEditLink() {
   	 Actions action = new Actions(webDriver);
   	 action.moveToElement(editUser).doubleClick().perform();
   }
    
    public void EnterUserId(String search) {
    	filterId.click();
    	filterId.clear();
    	filterId.sendKeys(search);
    	filterId.sendKeys(Keys.ENTER);
    }
    
    public void clickSystemAdminTab() {
    	systemAdminTab.click();
    }
	 public void clickSaveButton() {
	    	saveButton.click();
	    }

	 public void clickCancelButton() {
	    	cancelButton.click();
	    }
	 
	 public void clickEnableButton() {
           enableAll.click();
	    }

	 public void clickDisableButton() {
	    	disableAll.click();
	    }
	
	 public void clickEnableVIPButton() {
		 if (mngVIPDiscount.isSelected()) {
			 System.out.println("VIP discount is enabled");
		 } else {
	    	mngVIPDiscount.click();
	    }
	 }
	 
	 public void clickEnableQuoteSettingsButton() {
		 WebDriverWait block = new WebDriverWait(webDriver,10);
		 WebElement modal = block.until(ExpectedConditions.elementToBeClickable(mngQuoteSetings));
		 if (mngQuoteSetings.isSelected()) {
			 System.out.println("quote setting is enabled");
		 }
		 else {
			 mngQuoteSetings.click();
		 }
	 }

	 public void clickEnableCurrencyBumpButton() {
		
		 if (mngCurrencyBump.isSelected()) {
			 System.out.println("Currency Bump is  enabled");
		 } else {

		 WebDriverWait block = new WebDriverWait(webDriver,10);
		 WebElement modal = block.until(ExpectedConditions.elementToBeClickable(mngCurrencyBump));
		 mngCurrencyBump.click();
		 }
	 }
	
	 
	 public void clickDisableVIP1Button() {
		 if (mngVIP1.isEnabled()) {
	    	 mngVIP1.click();}	
	    else {
	    	 System.out.println("VIP1 discount is disabled");}
	 }
	 
	public void clickDisableVIP2Button() {
		    if (mngVIP2.isEnabled()) {
		    	 mngVIP2.click(); }	
		    else {
		    	 System.out.println("VIP2 discount is disabled"); }
	    }
	public boolean showsError() {
	    	 if (webDriver.findElements(By.xpath("//*[@id=\"rightTabPerm\"]/form/div/div[1]/div")).size() > 0) {
	             return true;
	         }
	         return false;
	    }
	    
	 public void clickAlertPopup() {
		webDriver.switchTo().alert().accept();
	    }
	 
	 public SystemAdminPermissionTab(WebDriver webDriver) {
			super(webDriver);
		    PageFactory.initElements(webDriver, this);
		    naviMenuBar = new NavigationMenuBar(webDriver);
		} 
}
