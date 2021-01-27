package us.cargosphere.automation.pages.admin.usermanagement;


import static org.junit.Assert.assertEquals;

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

public class FmcPermissionTab  extends BasePage {
	
private NavigationMenuBar naviMenuBar;
    
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}



    @FindBy(how = How.ID, using = "fmc_tab")
    private WebElement fmc_tab;
	

    @FindBy(how = How.ID, using = "mngFmcCrtMngTrf")
    private WebElement mngFmcCreateTrf;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"mngFmcCrtMngTrf\"]/span/input")
    private WebElement mngFmcCreateTrfCheck;
    // To check the isselected value
  
    @FindBy(how = How.ID, using = "mngFmcRevRelTrf")
    private WebElement mngFmcRevRelTrf;
    
    
    @FindBy(how = How.ID, using = "//*[@id=\"mngFmcRevRelTrf\"]/span/input")
    private WebElement mngFmcRevRelTrfCheck;

    @FindBy(how = How.ID, using = "mngFmcViewTrf")
    private WebElement mngFmcViewTrf;

    @FindBy(how = How.XPATH, using = "//*[@id=\"mngFmcViewTrf\"]/span/input")
    private WebElement mngFmcViewTrfCheck;
    
    @FindBy(how = How.ID, using = "mngFmcViewTrfFMC")
    private WebElement mngFmcViewTrfFMC;
    
    @FindBy(how = How.ID, using = "mngFmcViewNegRateAgr")
    private WebElement mngFmcViewNegRateAgr;
    
    @FindBy(how = How.ID, using = "mngFmcReqAprRls")
    private WebElement mngFmcReqAprRls;
    
	@FindBy(how = How.ID, using = "fmcEnableAll")
    private WebElement fmcEnableAll;
    

	@FindBy(how = How.ID, using = "fmcDisableAll")
    private WebElement fmcDisableAll;
	
	
	 public void clickFmcEnableButton() {
	        fmcEnableAll.click();
		    }

	 public void clickFmcDisableButton() {
		    	fmcDisableAll.click();
		    }
	
	 public void clickEnableCreateMngTrf() {
			 
			 if (mngFmcCreateTrfCheck.isSelected()) {
				 System.out.println("Create and manage tariff is enabled --" +mngFmcCreateTrf.isSelected() );
			 }
			 else {
				 mngFmcCreateTrf.click(); 
			 } 
		 }
		 
		 public void checkReqAprRelDefaut() {
//			 WebDriverWait block = new WebDriverWait(webDriver,10);
//			 WebElement modal = block.until(ExpectedConditions.elementToBeClickable(mngFmcCreateTrf));
			 if (mngFmcCreateTrfCheck.isSelected()) {
				 System.out.println("Create and manage tariff is enabled -" + mngFmcCreateTrfCheck.isSelected());
			 }
			 else {
				 mngFmcCreateTrf.click();
			 }
			 
			 if (mngFmcReqAprRls.isSelected()) {
				 System.out.println("Require approval for release is enabled");
			 }
			 else {
				assertEquals("Require approval for release is disabled", true, mngFmcReqAprRls.isSelected());
		 }
			 
		 }
		 
		 public void viewTariffValidationWithCreateTrf() {
			 if (mngFmcCreateTrf.isEnabled()) {
			
				 if (mngFmcViewTrf.isEnabled()) {
					 mngFmcViewTrf.click();
				 }
				 System.out.println("Create and manage tariff is enabled -" + mngFmcViewTrf.isSelected() );
			 }
			 else {
				 mngFmcCreateTrf.click();
				 	if (mngFmcViewTrf.isEnabled()) {
					 mngFmcViewTrf.click();
				 	}
			 	}
			 }

		 public void viewTariffValidationWithReviewTrf() {
			
			 if (mngFmcRevRelTrf.isSelected()) {
			
				 if (mngFmcViewTrf.isEnabled()) {
					 mngFmcViewTrf.click();
				 }
			 }
			 else {
				 mngFmcRevRelTrf.click();
				 	if (mngFmcViewTrf.isEnabled()) {
					 mngFmcViewTrf.click();
				 	}
			 	}
			 }
		 
		 public void checkViewTariffPermission() {
			 if (mngFmcCreateTrfCheck.isSelected()) {
				 if (mngFmcViewTrfCheck.isSelected()) {
					 System.out.println("View tariff is enabled ---" + mngFmcViewTrfCheck.isSelected() );
					 assertEquals("View tariff is Enabled", true, mngFmcViewTrfCheck.isSelected()); 
				 }
				 else
				 {
					 assertEquals("View tariff is disabled", true, mngFmcViewTrfCheck.isSelected()); 
				 }
			 }
			
		 }
		 
		 public boolean showsError() {
	    	 if (webDriver.findElements(By.xpath("//*[@id=\"rightTabPerm\"]/form/div/div[1]/div")).size() > 0) {
	             return true;
	         }
	         return false;
	    }
	
		 public void checkAvailableFMCPermission() {
		    	if (mngFmcCreateTrf.isDisplayed()) {
		    		System.out.println("Create and Manage tariff permission is available");
		    	}
		    	else {
		    		assertEquals("Create and manage permission should be available",true, mngFmcCreateTrf.isDisplayed()); 
		    	}
		    	
		    	if (mngFmcRevRelTrf.isDisplayed()) {
		    		System.out.println("Review and release tariff permission is available");
		    	}
		    	else {
		    		assertEquals("Review and release permission should be available",true, mngFmcRevRelTrf.isDisplayed()); 
		    	}
		    	
		    	if (mngFmcViewTrf.isDisplayed()) {
		    		System.out.println("View tariffs permission is available");
		    	}
		    	else {
		    		assertEquals("Review and release permission should be available",true, mngFmcViewTrf.isDisplayed()); 
		    	}
		    	
		    	if (mngFmcViewTrfFMC.isDisplayed()) {
		    		System.out.println("View tariffs as FMC user permission is available");
		    	}
		    	else {
		    		assertEquals("View tariffs as FMC user  permission should be available",true, mngFmcViewTrfFMC.isDisplayed()); 
		    	}
		    	
		    	if (mngFmcViewNegRateAgr.isDisplayed()) {
		    		System.out.println("View Negotiated Rate Agreements permission is available");
		    	}
		    	else {
		    		assertEquals("View Negotiated Rate Agreements permission should be available",true, mngFmcViewNegRateAgr.isDisplayed()); 
		    	}
		    	
		 } 
		 
public  FmcPermissionTab(WebDriver webDriver) {
	super(webDriver);
	  
	    PageFactory.initElements(webDriver, this);
	    naviMenuBar = new NavigationMenuBar(webDriver);
	} 
}