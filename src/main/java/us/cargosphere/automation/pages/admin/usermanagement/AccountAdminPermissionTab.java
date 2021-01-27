package us.cargosphere.automation.pages.admin.usermanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.tools.ant.taskdefs.Sleep;
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

import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class AccountAdminPermissionTab extends BasePage {
	
private NavigationMenuBar naviMenuBar;
    
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}

    @FindBy(how = How.ID, using = "accountAdmin_tab")
    private WebElement accountmAdminTab;
    
    @FindBy(how = How.ID, using = "mngAccEnableAll")
    private WebElement AccEnableAll;
    
    @FindBy(how = How.ID, using = "mngAccDisableAll")
    private WebElement AccDisableAll;
    
    @FindBy(how = How.ID, using = "mngAccUsers")
    private WebElement mngAccUsers;
    
    @FindBy(how = How.ID, using = "mngAccCustExtAgt")
    private WebElement mngAccCustExtAgt;
    
    @FindBy(how = How.ID, using = "mngAccCarriers")
    private WebElement mngAccCarriers;
    
    @FindBy(how = How.ID, using = "mngAccFMCTrf")
    private WebElement mngAccFMCTrf;
    
    @FindBy(how = How.ID, using = "mngAccTrfOrgrec")
    private WebElement mngTarifOrgrecord;
    
//    @FindBy(how = How.ID, using = "mngAccAllUsers")
//    private WebElement mngAllUsers;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"accountAdmin\"]/div[2]/div[2]/div[1]/label[1]/span")
    private WebElement mngAllUsers;

    
    @FindBy(how = How.ID, using = "mngAccSelUsers")
    private WebElement mngSelUsers;

    
    @FindBy(how = How.ID, using = "mngAccSelBU")
    private WebElement selMenuItem;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"rightTabPerm\"]/form/div/div[1]/div")
    private WebElement errorPopup;
    
    
    public void clickAccEnableButton() {
        AccEnableAll.click();
	    }

	 public void clickDisableButton() {
	    	AccDisableAll.click();
	    }
	 
	 public void clickEnableSelBU() {
		 mngSelUsers.click();
	    }
	 
    public void selectBusinessUnit(String bUnit) {
    	mngSelUsers.click();
    	selMenuItem.click();
    	selMenuItem.findElement(By.className("item1")).findElement(By.tagName("li")).findElement(By.className("ng-pristine")).sendKeys(bUnit);
		selMenuItem.findElement(By.className("item2")).findElement(By.tagName("li")).click();
    }
    	
    	   	
    public void clickEnableManageUsers() {
//		 WebDriverWait block = new WebDriverWait(webDriver,10);
//		 WebElement modal = block.until(ExpectedConditions.elementToBeClickable(mngAccUsers));
	//	 System.out.println("users " + mngAccCarriers.isSelected());
		
    	if (mngAccUsers.isSelected()) {
			 System.out.println("enabled"); 
		 }
		 else {
			 mngAccUsers.click();
		 }
		 
    	WebDriverWait block = new WebDriverWait(webDriver,10);
	    WebElement modal = block.until(ExpectedConditions.elementToBeClickable(mngAllUsers));
    	
		 if (mngAllUsers.isSelected()) {
			 System.out.println("enabled" + mngAllUsers.isSelected()); 
			
			 System.out.println("all user permission is enabled");
		 }
		 else {
			 System.out.println("enabled 66" + mngAllUsers.isSelected()); 
			 System.out.println("users 11 " + mngAccUsers.isSelected());
			assertEquals("All users permission should be enabled",true, mngAllUsers.isSelected()); 
		 }
//		 System.out.println("enabled 66" + mngAllUsers.isSelected()); 
//		 System.out.println("users 11 " + mngAccUsers.isSelected());
    }
    
    public void checkAvailablePermission() {
    	if (mngAccUsers.isDisplayed()) {
    		System.out.println("Manage users permission is available");
    	}
    	else {
    		assertEquals("Manage users permission should be available",true, mngAccUsers.isDisplayed()); 
    	}
    	
    	if (mngAccCustExtAgt.isDisplayed()) {
    		System.out.println("Manage Customers and external agents permission is available");
    	}
    	else {
    		assertEquals("Manage customers and external permission should be available",true, mngAccCustExtAgt.isDisplayed()); 
    	}
    	

    	if (mngAccCarriers.isDisplayed()) {
    		System.out.println("Manage carriers permission is available");
    	}
    	else {
    		assertEquals("Manage carriers permission should be available",true, mngAccCarriers.isDisplayed()); 
    	}
    	
    	if (mngAccFMCTrf.isDisplayed()) {
    		System.out.println("Manage FMC tariff users permission is available");
    	}
    	else {
    		assertEquals("Manage FMC tariff users permission should be available",true, mngAccFMCTrf.isDisplayed()); 
    	}
    	
    	if (mngTarifOrgrecord.isDisplayed()) {
    		System.out.println("Manage tariff organization record permission is available");
    	}
    	else {
    		assertEquals("Manage tariff organization record permission should be available",true, mngTarifOrgrecord.isDisplayed()); 
    	}
    }
    
    public boolean catchSelectBUError() {
   	if (webDriver.findElements(By.xpath("//*[@id=\"rightTabPerm\"]/form/div/div[1]/div")).size() > 0) {
//   		int errpop	= webDriver.findElements(By.xpath("//*[@id=\"rightTabPerm\"]/form/div/div[1]/div")).size(); 
//   			if (errpop > 0) {
    	   		 return true;
    //	   		assert.assertTrue("Business unit", true);  
       } 
         return false;
   }
    
    public AccountAdminPermissionTab(WebDriver webDriver) {
		super(webDriver);
	  
	    PageFactory.initElements(webDriver, this);
	    naviMenuBar = new NavigationMenuBar(webDriver);
	} 
    
}