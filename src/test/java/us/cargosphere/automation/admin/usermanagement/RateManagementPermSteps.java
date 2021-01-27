package us.cargosphere.automation.admin.usermanagement;

import cucumber.api.java.en.And;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.admin.usermanagement.RateManagementPermissionTab;

public class RateManagementPermSteps extends BaseStepDefinitions{
	
	private RateManagementPermissionTab rateMgmtAdmPermPage;	
	public RateManagementPermSteps(TestContext context) {
		super(context);
//	rateMgmtAdmPermPage = this.testContext.getPageObjectManager().getRateManagPermPage();
	
	} 
	

	@And("^user clicks on enable all button on ratemanagement tab$")
	public void userClicksOnEnableAllButtonOnRatemanagementTab() throws Throwable {
		rateMgmtAdmPermPage.clickRateMgmtEnableButton();
	}


	@And("^user clicks on disable all button on ratemanageent tab$")
	public void userClicksOnDisableAllButtonOnRatemanageentTab() throws Throwable {
		rateMgmtAdmPermPage.clickRateMgmtDisableButton();
	}
	
	
}
