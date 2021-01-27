package us.cargosphere.automation.login;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.ForgotPasswordPage;

public class ForgotPasswordSteps extends BaseStepDefinitions{

	private ForgotPasswordPage forgotPwdPage;
	

	
	public ForgotPasswordSteps(TestContext context) {
	        super(context);
	        forgotPwdPage = this.testContext.getPageObjectManager().getForgotPasswordPage();
	    }
	
	@When("^the user enters email \"([^\"]*)\" for reset password$")
	public void enterTheEmailIDForResetPassword(String emailAddress) {
		forgotPwdPage.resetEmail(emailAddress);
	}
	
	@Then("^reset email sent successfully$")
	public void reset_email_success() {
		assertTrue(forgotPwdPage.showsEmailSent());
		//forgotPwdPage.closeCurrentWindow();
	}
	
}
