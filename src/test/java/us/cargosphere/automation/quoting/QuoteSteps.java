package us.cargosphere.automation.quoting;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.quoting.NewQuotePage;

public class QuoteSteps extends BaseStepDefinitions {

	private NewQuotePage quotePage;

	public QuoteSteps(TestContext context) {
		super(context);
		quotePage = this.testContext.getPageObjectManager().getQuotePage();

	}

	@When("^user adds Locations to create quote$")
	public void user_adds_Locations_to_create_quote(DataTable location) throws Throwable {

		List<Map<String, String>> lstInputlocations = location.asMaps(String.class, String.class);
		quotePage.origin(lstInputlocations.get(0).get("Origin"));
		quotePage.destination(lstInputlocations.get(0).get("Destination"));
	}

	@When("^user adds dates from \"([^\"]*)\" to \"([^\"]*)\" for quote$")
	public void user_adds_dates_from_to_for_quote(String effdate, String expdate) throws Throwable {
		quotePage.start_Date(effdate);
		quotePage.end_Date(expdate);
	}

	@When("^user adds commodity \"([^\"]*)\"$")
	public void user_adds_commodity(String commodity) throws Throwable {
		quotePage.send_commodity(commodity);
	}

	@When("^user adds Container types for quote$")
	public void user_adds_Container_types_for_quote(DataTable cntr) throws Throwable {
		List<String> cntrList = cntr.asList(String.class);
		quotePage.container_select(cntrList);
	}

	@When("^I enter buyrate$")
	public void i_enter_buyrate(DataTable buy_rate) throws Throwable {
		List<Map<String, String>> rate = buy_rate.asMaps(String.class, String.class);
		quotePage.enter_buy_rate(rate.get(0).get("Buy Rate"));

	}

	@When("^I add an agent \"([^\"]*)\"$")
	public void i_add_an_agent(String agent) throws Throwable {
		quotePage.add_agent(agent);

	}

	@When("^I select \"([^\"]*)\"$")
	public void i_select(String arg1) throws Throwable {
		quotePage.select_agent_assignment(arg1);
	}

	@When("^I assign a agent \"([^\"]*)\"$")
	public void i_assign_a_agent(String agent) throws Throwable {
		quotePage.send_agent(agent);

	}

	@When("^I select the Agent$")
	public void i_select_the_Agent() throws Throwable {
		quotePage.select_agent();
	}

	@When("^I create a quote$")
	public void i_create_a_quote() throws Throwable {
		quotePage.create_quote();

	}

	@Then("^Quote is created$")
	public void quote_is_created() throws Throwable {
		quotePage.created_quote_landing_page();
	}

}
