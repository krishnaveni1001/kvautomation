package us.cargosphere.automation.reports;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

import javax.xml.bind.DatatypeConverter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.ForgotPasswordPage;
import us.cargosphere.automation.pages.LoginPage;
import us.cargosphere.automation.pages.ResetPasswordPage;
import us.cargosphere.automation.pages.navigation.ReportsSubMenu;
import us.cargosphere.automation.pages.quoting.NewQuotePage;
import us.cargosphere.automation.pages.ratesearch.startpage.RateSearchStartPage;
import us.cargosphere.automation.pages.reports.BunkOmissionReportPage;
import us.cargosphere.automation.pages.reports.SystemUsageReprtPage;

public class BunkOmSteps  extends BaseStepDefinitions {

	private  BunkOmissionReportPage bunkomReport;

	public BunkOmSteps(TestContext context) {
		super(context);
		bunkomReport = this.testContext.getPageObjectManager().getBunkOmissionReportPage();
	}


	@And("^user select \"([^\"]*)\" to send report$")
	public void userSelectToSendReport(String userName) throws Throwable {
		bunkomReport.SelectAvailableUser(userName);
	}


	@And("^user click on the move button$")
	public void userclickOnTheMoveButton() throws Throwable {
		bunkomReport.ClickMoveButton();
	}


	@And("^user enter emailid \"([^\"]*)\" to send report$")
	public void userEnterEmailidToSendReport(String emailid) throws Throwable {
		bunkomReport.EnterEmail(emailid);
	}


	@Then("^user click on generate report button$")
	public void userClickOnGenerateReportButton() throws Throwable {
		bunkomReport.ClickGenerateReport();
	}


}