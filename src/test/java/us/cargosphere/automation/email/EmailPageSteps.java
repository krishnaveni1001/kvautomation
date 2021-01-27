package us.cargosphere.automation.email;

import cucumber.api.java.en.Then;
import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.CucumberRunner;
import us.cargosphere.automation.pages.email.EmailPage;
import us.cargosphere.automation.pages.ResetPasswordPage;
import us.cargosphere.automation.pages.email.PasswordResetEmail;
import us.cargosphere.automation.util.Flags;

import java.util.ArrayList;

public class EmailPageSteps extends BaseStepDefinitions {
	
	 private EmailPage emailPage;

	 private ResetPasswordPage resetPwdPage;

	@And("^user gets the reset password email for \"([^\"]*)\"$")
	public void user_gets_reset_email(String searchStr) throws InterruptedException {
		getEmailPage();
		emailPage.searchForEmail(searchStr);
		Assert.assertEquals("Reset your password",emailPage.getFirstEmailText());
	}

	private void getEmailPage() {
		 String digestUrl = new StringBuilder(CucumberRunner.cmd.getOptionValue(Flags.Long.PROTOCOL)) //
	                .append("://") //
	                .append(CucumberRunner.cmd.getOptionValue(Flags.Long.EMAIL_URL)).toString(); //)
		this.getDriver().get(digestUrl);
		emailPage = new EmailPage(this.getDriver());
	}

	@When("^the user clicks on the reset link$")
	public ResetPasswordPage  user_clicks_on_reset_link() throws InterruptedException {
		emailPage.clickResetPwdLink();
		resetPwdPage = new ResetPasswordPage(this.getDriver());
		return resetPwdPage;
	}

	@Then("^the password is reset to \"([^\"]*)\" through the email link$")
	public void thePasswordIsResetThroughTheEmailLink(String password) throws Throwable {
		String digestUrl = new StringBuilder(CucumberRunner.cmd.getOptionValue(Flags.Long.PROTOCOL)) //
				.append("://") //
				.append(CucumberRunner.cmd.getOptionValue(Flags.Long.EMAIL_URL)) //
				.toString();
		System.out.println("Trying to reach email at url: " + digestUrl);
		this.getDriver().get(digestUrl);
		EmailPage emailPage = new EmailPage(this.getDriver());
		Thread.sleep(2000);

		emailPage.clickPasswordResetEmail();
		Thread.sleep(2000);

		this.getDriver().manage().window().maximize();
		this.getDriver().switchTo().frame(this.getDriver().findElement(By.id("preview-html")));
		PasswordResetEmail passwordResetEmail = new PasswordResetEmail(this.getDriver());
		passwordResetEmail.clickResetLink();
		Thread.sleep(2000);

		ArrayList<String> tabs2 = new ArrayList<String> (this.getDriver().getWindowHandles());
		this.getDriver().switchTo().window(tabs2.get(1));
		Thread.sleep(2000);

		ResetPasswordPage resetPasswordPage = new ResetPasswordPage(this.getDriver());
		resetPasswordPage.resetPassword(password);

		Thread.sleep(2000);
	}
}
