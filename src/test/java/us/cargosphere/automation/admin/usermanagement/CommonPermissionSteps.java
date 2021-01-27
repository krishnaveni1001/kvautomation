package us.cargosphere.automation.admin.usermanagement;

import cucumber.api.java.en.And;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.admin.usermanagement.CommonPermissionPage;

public class CommonPermissionSteps extends BaseStepDefinitions{
	
	private CommonPermissionPage commonPermPage;			
	public CommonPermissionSteps(TestContext context) {
		super(context);
	commonPermPage = this.testContext.getPageObjectManager().getPermPage();
	
	} 

}