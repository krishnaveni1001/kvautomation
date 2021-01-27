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
import us.cargosphere.automation.pages.ratesearch.startpage.RateSearchStartPage;
import us.cargosphere.automation.pages.reports.SystemUsageReprtPage;

public class ReportSteps extends BaseStepDefinitions{
	private LoginPage loginPage;
    
	private ReportsSubMenu repSubMenu;
	
	private SystemUsageReprtPage systemReportPage;
	
	public ReportSteps(TestContext context) {
	    super(context);
	}
	 
    @When("^that the user click on report menu$")
	public void thatTheUserClickOnReportMenu() throws Throwable {
    	repSubMenu = new RateSearchStartPage(this.getDriver()).getTopNavigationMenuBar().getReportsNav();
    	repSubMenu.clickReportMenuLink();
	}
	 
    @Then("^that user check all report links$")
	public void thatUserCheckAllReportLinks() throws Throwable {
    	repSubMenu = new RateSearchStartPage(this.getDriver()).getTopNavigationMenuBar().getReportsNav();
    	repSubMenu = repSubMenu.clickBunkerOmissionLink().getNaviMenuBar().getReportsNav();
    	repSubMenu = 	repSubMenu.clickContractReportLink().getNaviMenuBar().getReportsNav();
    	repSubMenu = 	repSubMenu.clickConReqAprReportLink().getNaviMenuBar().getReportsNav();
    	repSubMenu = 	repSubMenu.clickFutureReportLink().getNaviMenuBar().getReportsNav();
    	repSubMenu = 	repSubMenu.clickGriReportLink().getNaviMenuBar().getReportsNav();
    	repSubMenu = 	repSubMenu.clickQuoteVolumeReportLink().getNaviMenuBar().getReportsNav();
    	repSubMenu = 	repSubMenu.clickRateExpirationReportLink().getNaviMenuBar().getReportsNav();
    	repSubMenu = 	repSubMenu.clickVccReportLink().getNaviMenuBar().getReportsNav();
    	repSubMenu = 	repSubMenu.clickUserLoginReportLink().getNaviMenuBar().getReportsNav();
    	//repSubMenu = 	repSubMenu.clickTriReportLink().getNaviMenuBar().getReportsNav();
    	repSubMenu = 	repSubMenu.clickQuoteAnalyticsReportLink().getNaviMenuBar().getReportsNav();
    	systemReportPage = repSubMenu.clickSystemUsageReportLink();
				
		}

		@Then("^the user check all dashboard links$")
		public void theUserCheckAllDashboardLinks() throws Throwable {
			repSubMenu = new SystemUsageReprtPage(this.getDriver()).getNaviMenuBar().getReportsNav();
			repSubMenu = repSubMenu.clickContractDashboardLink().getNaviMenuBar().getReportsNav();
			repSubMenu = repSubMenu.clickEsudsDashboardLink().getNaviMenuBar().getReportsNav();
			repSubMenu = repSubMenu.clickSudsDashboardLink().getNaviMenuBar().getReportsNav();
			repSubMenu = repSubMenu.clickUserRatesearchDashboardLink().getNaviMenuBar().getReportsNav();
			repSubMenu = repSubMenu.clickBaseTrendDashboardLink().getNaviMenuBar().getReportsNav();
			repSubMenu = repSubMenu.clickSurchargeTrendDashboardLink().getNaviMenuBar().getReportsNav();
		}
}
