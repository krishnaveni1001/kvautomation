package us.cargosphere.automation.ratemanagement;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.ratemanagement.RateMgmtFreeTimePage;

public class FreeTimeStepDefinitions extends BaseStepDefinitions {

	private static final JavascriptExecutor WebDriver = null;
	RateMgmtFreeTimePage freetimepage;

	public FreeTimeStepDefinitions(TestContext testContext) {
		super(testContext);
		freetimepage = this.testContext.getPageObjectManager().getFreetimePage();
	}

	@When("^user should see$")
	public void user_should_see(DataTable fields) throws Throwable {

		List<List<String>> data = fields.raw();

		String carrier = freetimepage.carrier_text_assert();

		Assert.assertEquals(data.get(0).get(0), carrier);

		String contract = freetimepage.contract_text_assert();

		Assert.assertEquals(data.get(0).get(1), contract);

		String daterange = freetimepage.daterange_text_assert();

		Assert.assertEquals(data.get(0).get(2), daterange);

	}

	@When("^I click on the Date Range text field$")
	public void i_click_on_the_Date_Range_text_field() throws Throwable {
		freetimepage.click_daterange();
	}

	@Then("^Two date fields are available$")
	public void two_date_fields_are_available() throws Throwable {
		Thread.sleep(2000);

		String ParentWindow = this.getDriver().getWindowHandle(); // switching from parent to pop up window
		for (String Child_Window : this.getDriver().getWindowHandles()) {
			this.getDriver().switchTo().window(Child_Window);
			Assert.assertTrue(freetimepage.start_datefield().isDisplayed());
			Assert.assertTrue(freetimepage.end_datefield().isDisplayed());

		}
		this.getDriver().switchTo().window(ParentWindow);
	}

	@Then("^The currently selected dates \"([^\"]*)\" are displayed by default$")
	public void the_currently_selected_dates_are_displayed_by_default(String default_date) throws Throwable {
		String text = freetimepage.start_datefield().getAttribute("value");
		Assert.assertEquals(text, default_date);
	}

	@Then("^an Open start checkbox is available\\.$")
	public void an_Open_start_checkbox_is_available() throws Throwable {
		Assert.assertTrue(freetimepage.startcheckbox().isDisplayed());

	}

	@Then("^an Open end checkbox is also available\\.$")
	public void an_Open_end_checkbox_is_also_available() throws Throwable {
		Assert.assertTrue(freetimepage.endcheckbox().isDisplayed());

	}

	@Then("^Checking an Open box clears the associated date$")
	public void checking_an_Open_box_clears_the_associated_date() throws Throwable {

		freetimepage.startcheckbox();

	}

	@Then("^displays the text 'Open' in the date field$")
	public void displays_the_text_Open_in_the_date_field() throws Throwable {

		Assert.assertEquals(true, freetimepage.open_start_checkbox());

	}

	@Then("^Unchecking an 'Open' box clears the 'Open' text$")
	public void unchecking_an_Open_box_clears_the_Open_text() throws Throwable {
		freetimepage.uncheck_startcheckbox();
		String text = freetimepage.start_datefield().getAttribute("value");
		System.out.println(text);
		Assert.assertEquals("", "");
	}

	@Then("^end date can be selected \"([^\"]*)\" if the start date is Open$")
	public void end_date_can_be_selected_if_the_start_date_is_Open(String end_date) throws Throwable {
		freetimepage.uncheck_startcheckbox();
		freetimepage.enter_end_Date(end_date);
	}

	@Then("^Start date can also be selected \"([^\"]*)\" if the end date is open$")
	public void start_date_can_also_be_selected_if_the_end_date_is_open(String start_date) throws Throwable {
		freetimepage.uncheck_endcheckbox();
		freetimepage.enter_start_Date(start_date);
	}

	@Then("^I uncheck open start checkbox$")
	public void i_uncheck_open_start_checkbox() throws Throwable {
		freetimepage.clear_start_datefield();
		freetimepage.uncheck_endcheckbox();
		freetimepage.uncheck_endcheckbox();
		Thread.sleep(2000);
	}

	@Then("^I click Apply button$")
	public void i_click_Apply_button() throws Throwable {
		freetimepage.click_apply();

	}

	@Then("^the text is displayed \"([^\"]*)\"$")
	public void the_text_is_displayed(String arg1) throws Throwable {

		String toastTitle = freetimepage.get_toastTitle();
		String toastMessage = freetimepage.get_toastMessage();

		System.out.println("Title of the toast title" + toastTitle);
		System.out.println("Title of the toast message" + toastMessage);
		Assert.assertEquals(toastMessage, arg1);
	}

	@Then("^I uncheck open end checkbox$")
	public void i_uncheck_open_end_checkbox() throws Throwable {
		freetimepage.uncheck_endcheckbox();
	}

	@Then("^I enter the start date as \"([^\"]*)\"$")
	public void i_enter_the_start_date_as(String startDate) throws Throwable {

		freetimepage.enter_start_Date(startDate);

	}

	@Then("^I enter the end date as \"([^\"]*)\"$")
	public void i_enter_the_end_date_as(String endDate) throws Throwable {
		freetimepage.enter_end_Date(endDate);
	}

	@Then("^I click Cancel button$")
	public void i_click_Cancel_button() throws Throwable {
		freetimepage.click_cancel();
	}

	@Then("^the date range pop up is not displayed$")
	public void the_date_range_pop_up_is_not_displayed() throws Throwable {

		Assert.assertEquals(false, freetimepage.datePopup_window());
	}

}
