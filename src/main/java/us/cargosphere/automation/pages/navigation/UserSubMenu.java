package us.cargosphere.automation.pages.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

public class UserSubMenu extends BasePage {

    @FindBy(how = How.ID, using = "userType")
    private WebElement userTypeInd;

    public UserSubMenu (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public String getUserTypeInd() {
        return userTypeInd.getAttribute("innerText");
    }
}
