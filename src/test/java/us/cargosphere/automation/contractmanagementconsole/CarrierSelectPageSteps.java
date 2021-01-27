package us.cargosphere.automation.contractmanagementconsole;

import cucumber.api.java.en.When;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.contractmanagement.CarrierSelectPage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;
import us.cargosphere.automation.pages.navigation.RateMgmtSubMenu;
import us.cargosphere.automation.pages.ratemanagement.RateMgmtChooseCarrierPage;

public class CarrierSelectPageSteps extends BaseStepDefinitions {

	private RateMgmtChooseCarrierPage carrierPage;

	private NavigationMenuBar navigationMenuBar;
	private RateMgmtSubMenu ratemanagementSubMenu;

	public CarrierSelectPageSteps(TestContext context) {
		super(context);
		carrierPage = this.testContext.getPageObjectManager().getCarrierPage();
	}

}
