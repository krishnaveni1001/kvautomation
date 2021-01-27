package us.cargosphere.automation.quoting;

import java.util.List;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.quoting.QuotePermissionsTabPage;

public class QuotePermissionsTabPageSteps extends BaseStepDefinitions {

	private QuotePermissionsTabPage quotePermissionsTabPage;

	public QuotePermissionsTabPageSteps(TestContext context) {
		super(context);
		quotePermissionsTabPage = this.testContext.getPageObjectManager().getQuoteermissionsTabPage();

	}

	@Then("^all the Quote permissions are enabled for Quote$")
	public void all_the_Quote_permissions_are_enabled_for_Quote(DataTable quote_tabs) throws Throwable {
		Thread.sleep(2000);
		List<String> quote_tabs_list = quote_tabs.asList(String.class);
		for (String permission : quote_tabs_list) {
			switch (permission) {
			case "Rate Requests":
				Assert.assertEquals(true, quotePermissionsTabPage.rateRequest());
				break;
			case "Customer Quotes":
				Assert.assertEquals(true, quotePermissionsTabPage.customerQuote());
				break;
			case "Update Customer Quotes":
				Assert.assertEquals(true, quotePermissionsTabPage.updateCustomerQuotes());
				break;
			case "View Customer Quotes":
				Assert.assertEquals(true, quotePermissionsTabPage.viewCustomerQuotes());
				break;

			}
		}
	}
}