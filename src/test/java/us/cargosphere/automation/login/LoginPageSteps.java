package us.cargosphere.automation.login;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.CucumberRunner;
import us.cargosphere.automation.email.EmailPageSteps;
import us.cargosphere.automation.pages.ForgotPasswordPage;
import us.cargosphere.automation.pages.LoginPage;
import us.cargosphere.automation.pages.ResetPasswordPage;
import us.cargosphere.automation.util.DriverUtil;
import us.cargosphere.automation.util.Flags;

public class LoginPageSteps extends BaseStepDefinitions {
    private LoginPage loginPage;
    
    private ForgotPasswordPage forgotPwdPage;

	private ResetPasswordPage resetPwdPage;
    /**
     * Replaced by userLogsIntoEnv and userlogsIn
     */
    @Deprecated
    @Given("^that user \"([^\"]*)\" is logged into \"([^\"]*)\" environment$")
    public void userIsLoggedInToEnvironment(String user, String env) throws Throwable {
        String environmentPassword = BaseStepDefinitions.envs.get(env);
        String userPassword = BaseStepDefinitions.users.get(user);
        String digestUrl = new StringBuilder(CucumberRunner.cmd.getOptionValue(Flags.Long.PROTOCOL)) //
                .append("://") //
                .append(env) //
                .append(":") //
                .append(environmentPassword) //
                .append("@") //
                .append(CucumberRunner.cmd.getOptionValue(Flags.Long.BASE_URL)) //
                .toString();
        System.out.println("Trying url: " + digestUrl);
        this.getDriver().get(digestUrl);
        Thread.sleep(2000);
        this.getDriver().findElement(By.id("login_manually")).click();
        this.getDriver().findElement(By.name("environmentCode")).sendKeys(env);
        this.getDriver().findElement(By.name("environmentPassword")).sendKeys(environmentPassword);
        this.getDriver().findElement(By.name("environmentPassword")).sendKeys(Keys.ENTER);
        
        this.getDriver().findElement(By.id("userId")).sendKeys(user);
        this.getDriver().findElement(By.id("password")).sendKeys(userPassword);
        this.getDriver().findElement(By.id("password")).sendKeys(Keys.ENTER);
    }

    @Given("^a user is on the login page for the \"([^\"]*)\" environment$")
    public void userLogsIntoEnv(String env) {
        String environmentPassword = BaseStepDefinitions.envs.get(env);
        String digestUrl = new StringBuilder(CucumberRunner.cmd.getOptionValue(Flags.Long.PROTOCOL)).append("://")
//                .append(env).append(":").append(environmentPassword).append("@")
                .append(CucumberRunner.cmd.getOptionValue(Flags.Long.BASE_URL))
                .toString();
        System.out.println("Trying url: " + digestUrl);
        this.getDriver().get(digestUrl);
        Boolean isPresent = this.getDriver().findElements(By.id("login_manually")).size() > 0;
        if(isPresent) {
        	this.getDriver().findElement(By.id("login_manually")).click();
            this.getDriver().findElement(By.name("environmentCode")).sendKeys(env);
            this.getDriver().findElement(By.name("environmentPassword")).sendKeys(environmentPassword);
            this.getDriver().findElement(By.name("environmentPassword")).sendKeys(Keys.ENTER);
        }

        // This should throw an error if the user is not actually on the loginPage.
        loginPage = new LoginPage(this.getDriver());
    }

    @Given("^user clicks on forgot password and lands on Forgot password page$")
    public ForgotPasswordPage user_clicks_on_forgot_password() {
    	loginPage.clickForgotPassword();
    	forgotPwdPage = new ForgotPasswordPage(this.getDriver());
    	return forgotPwdPage;
    }
    
    @When("^the user logs in as \"([^\"]*)\"$")
    public void userlogsIn(String username) {
        String password = BaseStepDefinitions.users.get(username);
        loginPage.login(username, password);
    }

    @When("^the user logs in as \"([^\"]*)\" with the password \"([^\"]*)\"$")
    public void userLogsInWithPassword(String userName, String password) { loginPage.login(userName, password);
    }

    @When("^the user logs in as \"([^\"]*)\" with the wrong password$")
    public void userLoginFail_wrongPassword(String username) {
        String password = BaseStepDefinitions.users.get(username);
        loginPage.login(username, password + "a");
    }

    @When("^the user logs in as \"([^\"]*)\" with a misspelled username but correct password$")
    public void userLoginFail_wrongUsername(String username) {
        String password = BaseStepDefinitions.users.get(username);
        loginPage.login(username + "a", password);
    }

    @Then("^the user has auth tokens")
    public void userHasTokens() throws IOException {
        String authTokens = DriverUtil.getFromLocalStorage("authTokens");
        assertFalse(authTokens.isEmpty());
    }

    @Then("^an invalid username/password error is shown$")
    public void an_invalid_username_password_error_is_shown() {
        assertTrue(loginPage.showsInvalidError());
    }

    @Then("^the user is on the login page for the \"([^\"]*)\" environment$")
    public void user_is_on_login_page_for_env(String env) {
        loginPage = new LoginPage(this.getDriver());
        assertEquals(env.toUpperCase(), loginPage.getEnvType().toUpperCase());
    }
    
    @Given("^that user with email \"([^\"]*)\" forgots password and lands on reset password page through the email link$")
	public void forgot_password_reset_email_success(String email) throws InterruptedException {
		LoginPageSteps loginSteps = new LoginPageSteps();
		loginSteps.userLogsIntoEnv("qaauto");
		forgotPwdPage = loginSteps.user_clicks_on_forgot_password();
		forgotPwdPage.resetEmail(email);
		assertTrue(forgotPwdPage.showsEmailSent());
		EmailPageSteps emailSteps = new EmailPageSteps();
		emailSteps.user_gets_reset_email(email);
		resetPwdPage = emailSteps.user_clicks_on_reset_link();
	}
    
}
