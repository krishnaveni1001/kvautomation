package us.cargosphere.automation.admin.usermanagement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.And;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.admin.usermanagement.FmcPermissionTab;

public class FmcPermSteps  extends BaseStepDefinitions{
	
	private FmcPermissionTab fmcPermPage;			
	public FmcPermSteps(TestContext context) {
		super(context);
	fmcPermPage = this.testContext.getPageObjectManager().getfmPermPage();
	} 
	
	@And("^user clicks on disable all button on fmc tab$")
	public void userClicksOnDisableAllButtonOnFmcTab() throws Throwable {
	fmcPermPage.clickFmcDisableButton();
	}

	@And("^user clicks on enable button on fmc tab$")
	public void userClicksOnEnableButtonOnFmcTab() throws Throwable {
		
		fmcPermPage.clickFmcEnableButton();
	}

	@And("^user enable Create and manage tariff and check require approval for release is enabled$")
	public void userEnableCreateAndManageTariffAndCheckRequireApprovalForReleaseIsEnabled() throws Throwable {
	//	fmcPermPage.clickEnableCreateMngTrf();
		fmcPermPage.checkReqAprRelDefaut();
		Thread.sleep(5000);	
	}

	@And("^user check view tariff permission$")
	public void userCheckViewTariffPermission() throws Throwable {
		fmcPermPage.clickEnableCreateMngTrf();
		fmcPermPage.checkViewTariffPermission();
	}

	@And("^user check view tariff permission validation with create tariff permission$")
	public void userCheckViewTariffPermissionValidationWithCreateTariffPermission() throws Throwable {
		fmcPermPage.clickEnableCreateMngTrf();
		fmcPermPage.viewTariffValidationWithCreateTrf();
		Thread.sleep(5000);	
	}

	@And("^user get the error message$")
	public void userGetTheErrorMessage() throws Throwable {
		fmcPermPage.showsError();
		Thread.sleep(5000);	
		System.out.println("error" +fmcPermPage.showsError()); 
		assertTrue(fmcPermPage.showsError());
	}

	 @And("^user check view tariff permission validation with review and release tariff permission$")
	public void userCheckViewTariffPermissionValidationWithReviewAndReleaseTariffPermission() throws Throwable {
	//	fmcPermPage.clickEnableCreateMngTrf();
		Thread.sleep(5000);	
		fmcPermPage.viewTariffValidationWithReviewTrf();
		Thread.sleep(5000);	
		
	}

	@And("^user check available permissions on FMC tab$")
	public void userCheckAvailablePermissionsOnFMCTab() throws Throwable {
		fmcPermPage.checkAvailableFMCPermission();
		Thread.sleep(5000);	
	}
	
	
}

