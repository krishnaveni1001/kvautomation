package us.cargosphere.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BasePage{
	
	@FindBy(how = How.ID, using = "reset_email")
    private WebElement emailAddressField;
	
	public ForgotPasswordPage(WebDriver webDriver) {
	        super(webDriver);
	        PageFactory.initElements(webDriver, this);

	        // Check that we are on the correct page.
	        if (!webDriver.getCurrentUrl().contains("ptrade/jsp/ForgotPassword.jsp")) {
	            throw new IllegalStateException("This is not the forgot password page. Currently on: " + webDriver.getCurrentUrl());
	        }
	    }
	
	public void resetEmail(String emailAddr) {
		 	emailAddressField.sendKeys(emailAddr);
		 	emailAddressField.sendKeys(Keys.ENTER);
	        return;
	}
	
	 public boolean showsEmailSent() {
	        if (webDriver.findElements(By.className("email_sent")).size() > 0) {
	            return true;
	        }
	        return false;
	}
}
