package us.cargosphere.automation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends BasePage{

	@FindBy(how = How.ID, using = "new_password")
    private WebElement newPassword;
	
	@FindBy(how = How.ID, using = "confirm_password")
    private WebElement confirmPassword;
	
	public ResetPasswordPage(WebDriver webDriver) {
	        super(webDriver);
	        PageFactory.initElements(webDriver, this);
	}
	
	public LoginPage resetPassword(String newPwdStr) {
		newPassword.sendKeys(newPwdStr);
		confirmPassword.sendKeys(newPwdStr);
		confirmPassword.sendKeys(Keys.ENTER);
		return new LoginPage(webDriver);
	}
}
