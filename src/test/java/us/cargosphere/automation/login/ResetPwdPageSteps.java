package us.cargosphere.automation.login;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.LoginPage;
import us.cargosphere.automation.pages.ResetPasswordPage;
import us.cargosphere.automation.util.DriverUtil;

public class ResetPwdPageSteps extends BaseStepDefinitions{
	
	private ResetPasswordPage resetPwdPage;
	
	private LoginPage loginPage;
	
	public ResetPwdPageSteps(TestContext context) {
        super(context);
        resetPwdPage = this.testContext.getPageObjectManager().getResetPasswordPage();
    }
	
	@When("^the user tries to reset the password as \"([^\"]*)\"$")
	public void userResetsThePassword(String resetPwd) {
		loginPage  = resetPwdPage.resetPassword(resetPwd);
	}
	
	@Then("^the user resets and lands on login page$")
	public LoginPage userSeesTheresetResult() {
		System.out.println(loginPage.getTitle());
		return loginPage;
		 //assertEquals(result, loginPage.getTitle());
	}
	
	 @Then("^the user \"([^\"]*)\" logins with given password \"([^\"]*)\" results \"([^\"]*)\"$")
	 public void userLoginsResults(String loginId, String newPassword, String result) throws IOException {
    	 loginPage.login(loginId, newPassword);
    	 assertEquals((Boolean.valueOf(result)), DriverUtil.checkIfCookie("access_token"));
	 }
	 
}
