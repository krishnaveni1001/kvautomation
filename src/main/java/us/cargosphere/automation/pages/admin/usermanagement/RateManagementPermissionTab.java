package us.cargosphere.automation.pages.admin.usermanagement;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class RateManagementPermissionTab extends BasePage {
	
private NavigationMenuBar naviMenuBar;

private WebElement enableAllButton;   
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	} 


    @FindBy(how = How.ID, using = "rateMgmt_tab")
    private WebElement rateMgmt_tab;
    
    @FindBy(how = How.ID, using = "rateMgmtMngCarCont")
    private WebElement rateMgmtMngCarCont;
    
    @FindBy(how = How.ID, using = "rateMgmtUserIntContOwn")
    private WebElement rateMgmtUserIntContOwn;
    
    @FindBy(how = How.ID, using = "rateMgmtMngLevel3Sur")
    private WebElement rateMgmtMngLevel3Sur;
    
    @FindBy(how = How.ID, using = "rateMgmtEnableAll")
    private WebElement rateMgmtEnableAll;
    
    @FindBy(how = How.ID, using = "rateMgmtDisableAll")
    private WebElement rateMgmtDisableAll;
    
    @FindBy(how = How.ID, using = "rateMgmtConsoleRates")
    private WebElement rateMgmtConsoleRates;
    
    @FindBy(how = How.ID, using = "rateMgmtAuditRates")
    private WebElement rateMgmtAuditRates;
    
    @FindBy(how = How.ID, using = "rateMgmtSudsCont")
    private WebElement rateMgmtSudsCont;
    
    @FindBy(how = How.ID, using = "rateMgmtLevel2Cont")
    private WebElement rateMgmtLevel2Cont;
    
    @FindBy(how = How.ID, using = "rateMgmtAllCont")
    private WebElement rateMgmtAllContract;
    
    @FindBy(how = How.ID, using = "rateMgmtSelCont")
    private WebElement rateMgmtSelContract;
    
    @FindBy(how = How.ID, using = "rateMgmtLimitCont")
    private WebElement rateMgmtLimitContract;
    
    @FindBy(how = How.ID, using = "rateMgmtL     ")
    private WebElement rateMgmtFreeTime;
	
    public void checkMngCarrierContractEnabled() {
    if (rateMgmtMngCarCont.isSelected()) {
		 System.out.println("Create and manage tariff is enabled -" + rateMgmtMngCarCont.isSelected());
	 }
	 else {
		 rateMgmtMngCarCont.click();
	 }
    
}
    public void clickRateMgmtEnableButton() {
        rateMgmtEnableAll.click();
	    }

    public void clickRateMgmtDisableButton() {
	    	rateMgmtDisableAll.click();
	    }
    
    public void enabledMngCarrierContractPermission() {
        if (rateMgmtMngCarCont.isSelected()) {
    		 System.out.println("Manage carrier contract is enabled -" + rateMgmtMngCarCont.isSelected());
        }
    	 
    	 else {
    		 rateMgmtMngCarCont.click();
    	 }
        

		 if (rateMgmtConsoleRates.isSelected()) {
			 System.out.println("Console view and update contract rate is enabled -" + rateMgmtConsoleRates.isSelected());}
   		 else {
   			 assertEquals("Console view and update contract rate should be Enabled", true, rateMgmtConsoleRates.isSelected());  
   		 }
   	 

		 if (rateMgmtAuditRates.isSelected()) {
			 System.out.println("Audit review and approve contract rate is enabled -" + rateMgmtAuditRates.isSelected());
		 	}
   		 else {
   			 assertEquals("Audit review and approve contract rate should be Enabled", true, rateMgmtAuditRates.isSelected());  
   		 	}
    
    	if (rateMgmtSudsCont.isSelected()) {
    		System.out.println("SUDS upload contract and amendment is enabled -" + rateMgmtSudsCont.isSelected());}
		else {
			 assertEquals("SUDS upload contract and amendment should be Enabled", true, rateMgmtSudsCont.isSelected());  
		 	}
    	
    	if (rateMgmtLevel2Cont.isSelected()) {
    		System.out.println("Level 2 surcharges Manage surchargess within a contract is enabled -" + rateMgmtLevel2Cont.isSelected());}
		else {
			 assertEquals("Level 2 surcharges Manage surchargess within a contract should be Enabled", true, rateMgmtLevel2Cont.isSelected());  
		 	}

    	
	}
    
    public void checkDefaultWithMngCarrierContEnabled() throws InterruptedException {
    	if (rateMgmtMngCarCont.isSelected()) {
   		 System.out.println("Manage carrier contract is enabled -" + rateMgmtMngCarCont.isSelected());
    	}
   	 
   	 	else {
   		 rateMgmtMngCarCont.click();
   	 	}
    	
    	if (rateMgmtAllContract.isSelected()) {
    		System.out.println(" User can manage - All contract is enabled -" + rateMgmtAllContract.isSelected());}
		else {
			 assertEquals("User can manage- All contract should be Enabled", true, rateMgmtAllContract.isSelected());  
		 	}
    	Thread.sleep(2000);
    	if (rateMgmtSelContract.isEnabled()) {
    		System.out.println("User can manage -Selected contracts only is enabled -" + rateMgmtSelContract.isEnabled());}
		else {
			 assertEquals("User can manage -Selected contracts only should be Enabled", true, rateMgmtSelContract.isEnabled());  
		 	}
    	Thread.sleep(2000);
    	if (rateMgmtLimitContract.isEnabled()) {
    		System.out.println("User can manage -Limit by contract attribute is enabled -" + rateMgmtLimitContract.isEnabled());}
		else {
			 assertEquals("User can manage - Limit by contract attribute should be Enabled", true, rateMgmtLimitContract.isEnabled());  
		 	}
    	
    	
    }
    
    
    public void checkAvailableRateMgmtPermission() {
    	if (rateMgmtMngCarCont.isDisplayed()) {
    		System.out.println("Manage carrier contract is available");
    	}
    	else {
    		assertEquals("Manage carrier contract should be available",true, rateMgmtMngCarCont.isDisplayed()); 
    	}
    	
    	if (rateMgmtUserIntContOwn.isDisplayed()) {
    		System.out.println("User can be an internal contract owner is available");
    	}
    	else {
    		assertEquals("User can be an internal contract owner should be available",true, rateMgmtUserIntContOwn.isDisplayed()); 
    	}
    	
    	if (rateMgmtMngLevel3Sur.isDisplayed()) {
    		System.out.println("Manage Level 3 Surcharges is available");
    	}
    	else {
    		assertEquals("Manage Level 3 Surcharges should be available",true, rateMgmtMngLevel3Sur.isDisplayed()); 
    	}
    
    }
    
    public void enabledSelectedContract() {
    	
    	
    }
    
    
    public RateManagementPermissionTab(WebDriver webDriver) {
    	super(webDriver);
    	  
    	    PageFactory.initElements(webDriver, this);
    	    naviMenuBar = new NavigationMenuBar(webDriver);
    	    this.enableAllButton = webDriver.findElement(By.id("rateMgmtEnableAll"));
    	} 

    public void clickEnableAllButton () {
        enableAllButton.click();
    }

}
