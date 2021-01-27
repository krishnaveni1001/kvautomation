package us.cargosphere.automation.ratesearch;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.ratesearch.RateSearchPermissionsTabPage;

public class RateSearchPermissionsTabSteps extends BaseStepDefinitions {

	private RateSearchPermissionsTabPage rateSearchPermissionsTabPage;

	public RateSearchPermissionsTabSteps(TestContext context) {
		super(context);
		rateSearchPermissionsTabPage = this.testContext.getPageObjectManager().getRateSearchPermissionsTabPage();

	}

	@Then("^all the below rate search permissions are enabled for Rate search$")
	public void all_the_below_rate_search_permissions_are_checked(DataTable tabs) throws Throwable {
		Thread.sleep(2000);
		List<String> tabs_list = tabs.asList(String.class);
		for (String permission : tabs_list) {
			switch (permission) {
			case "Scope":

				Assert.assertEquals(true, rateSearchPermissionsTabPage.scopeCheck());
				break;
			case "Named Accounts":

				Assert.assertEquals(true, rateSearchPermissionsTabPage.namedAccountsCheck());
				break;
			case "FCL Buy rates":

				Assert.assertEquals(true, rateSearchPermissionsTabPage.fclBuyCheck());
				break;
			case "LCL Buy rates":

				Assert.assertEquals(true, rateSearchPermissionsTabPage.lclBuyCheck());
				break;
			case "FCL Sell rates":

				Assert.assertEquals(true, rateSearchPermissionsTabPage.fclSellCheck());
				break;

			case "LCL Sell rates":

				Assert.assertEquals(true, rateSearchPermissionsTabPage.lclSellCheck());
				break;

			case "View markup on Sell rates":

				Assert.assertEquals(true, rateSearchPermissionsTabPage.markupSellrateCheck());
				break;

			case "VIP 1 discount":

				Assert.assertEquals(true, rateSearchPermissionsTabPage.viponeDiscountCheck());
				break;

			case "VIP 2 discounts":

				Assert.assertEquals(true, rateSearchPermissionsTabPage.viptwoDiscountCheck());
				break;

			}

		}

	}
}
