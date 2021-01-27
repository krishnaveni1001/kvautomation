package us.cargosphere.automation.login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.CucumberRunner;
import us.cargosphere.automation.util.BrowserUtil;
import us.cargosphere.automation.util.Flags;

public class StepDefinitions extends BaseStepDefinitions {

	
	
	@Given("^that user selects the \"([^\"]*)\" environment$")
	public void userSelectEnvironment(String env) throws Throwable {
		String environmentPassword = BaseStepDefinitions.envs.get(env);
		
		String digestUrl = new StringBuilder(CucumberRunner.cmd.getOptionValue(Flags.Long.PROTOCOL)) //
				.append("://") //
				.append(env) //
				.append(":") //
				.append(environmentPassword) //
				.append("@") //
				.append(CucumberRunner.cmd.getOptionValue(Flags.Long.BASE_URL)) //
				.append("/ptrade/jsp/Digest.jsp") //
				.toString();
		System.out.println("Trying url: " + digestUrl);
		this.getDriver().get(digestUrl);
		Thread.sleep(2000);
	}
	
	
	@Then("^the user logs in with login id \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void userLogsWithLoginId(String user, String userPassword) throws Throwable {

		String digestUrl = new StringBuilder(CucumberRunner.cmd.getOptionValue(Flags.Long.PROTOCOL)) //
				.append("://") //
				.append(CucumberRunner.cmd.getOptionValue(Flags.Long.BASE_URL)) //
				.append("/ptrade/jsp/Digest.jsp") //
				.toString();
		System.out.println("Trying url: " + digestUrl);
		this.getDriver().get(digestUrl);
		Thread.sleep(2000);
		this.getDriver().findElement(By.id("userId")).sendKeys(user);
		this.getDriver().findElement(By.id("password")).sendKeys(userPassword);
		this.getDriver().findElement(By.id("password")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	@Given("^that Admin user is logging into \"([^\"]*)\" environment$")
	public void adminUserLoggingIntoGivenEnvironment(String user, String env) throws Throwable {
		
		String digestUrl = new StringBuilder(CucumberRunner.cmd.getOptionValue(Flags.Long.PROTOCOL)) //
				.append("://") //
				.append("ad"+env) //
				.append(":") //
				.append("admin") //
				.append("@") //
				.append(CucumberRunner.cmd.getOptionValue(Flags.Long.BASE_URL)) //
				.append("/ptrade/jsp/admin/DigestAdmin.jsp") //
				.toString();
		System.out.println("Trying url: " + digestUrl);
		this.getDriver().get(digestUrl);
		Thread.sleep(2000);
	}
	
	@Then("^the Admin user logging in with login id \"([^\"]*)\" and \"([^\"]*)\"$")
	public void adminUserLogsWithLoginId(String user, String userPassword) throws Throwable {

		this.getDriver().findElement(By.id("txtUName")).sendKeys(user);
		this.getDriver().findElement(By.id("txtPWord")).sendKeys(userPassword);
		this.getDriver().findElement(By.id("txtPWord")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
}
