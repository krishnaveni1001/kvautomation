package us.cargosphere.automation.pages.email;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.ResetPasswordPage;

public class EmailPage extends BasePage {

	public EmailPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
	
	@FindBy(how = How.ID, using = "search")
    private WebElement searchEmail;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div[2]/div[1]/div[2]/span")
    private WebElement firstMail;
	
	@FindBy(how = How.ID, using = "preview-html")
    private WebElement previewHtml;
	
	@FindBy(how = How.ID, using = "resetLink")
    private WebElement resetLink;

	/**
	 * Searches for an email using the search bar.
	 * @param searchStr - the search string
	 */
	public void searchForEmail(String searchStr) {
		searchEmail.sendKeys(searchStr);
		searchEmail.sendKeys(Keys.ENTER);
	}

	public void  clickFirstEmail () {
		firstMail.click();
	}

	/**
	 * Clicks the first email with a subject line that matches any of our password reset emails,
	 * including the Welcome email and the standard Forgot Password email.
	 */
	public void clickPasswordResetEmail () {
		List<WebElement> emailList = webDriver.findElements(By.className("msglist-message"));
		for(WebElement email : emailList) {
			String subject = email.findElement(By.className("subject")).getText();
			if(subject.equals("Welcome to Cargosphere") || subject.equals("Reset your password")) {
				email.click();
				return;
			}
		}
		throw new IllegalStateException("No password reset email found in mail box.");
	}

	public String getFirstEmailText() {
		return firstMail.getText();
	}

	/**
	 * Finds and clicks the reset password link within the reset password email.
	 */
	public void clickResetPwdLink() {
		firstMail.click();
		webDriver.switchTo().frame(previewHtml);
		resetLink.click();
		ArrayList<String> tabs2 = new ArrayList<String> (webDriver.getWindowHandles());
		webDriver.switchTo().window(tabs2.get(1));
	}
}
