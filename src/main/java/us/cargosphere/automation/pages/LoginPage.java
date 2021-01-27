package us.cargosphere.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.navigation.FMCSubMenu;

/**
 * The User Login Page.
 */
public class LoginPage extends BasePage {

    @FindBy(how = How.ID, using = "userId")
    private WebElement usernameField;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordField;

    @FindBy(how = How.ID, using = "envType")
    private WebElement envType;
    
    @FindBy(how = How.ID, using = "forgot_password")
    private WebElement resetPasswordLink;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        
        // Check that we are on the correct page.
        if (!webDriver.getCurrentUrl().contains("/ptrade")) {
            throw new IllegalStateException("This is not a login page. Currently on: " + webDriver.getCurrentUrl());
        }
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        passwordField.sendKeys(Keys.ENTER);
        return;
    }

    public boolean showsInvalidError() {
        if (webDriver.findElements(By.className("err")).size() > 0) {
            return true;
        }
        return false;
    }

    public String getEnvType() {
        return envType.getAttribute("value");
    }
    
    public ForgotPasswordPage clickForgotPassword() {
    	resetPasswordLink.click();
    	 return new ForgotPasswordPage(webDriver);
    }
}
