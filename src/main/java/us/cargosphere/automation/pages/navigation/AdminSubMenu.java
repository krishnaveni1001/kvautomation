package us.cargosphere.automation.pages.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

public class AdminSubMenu extends BasePage {

    @FindBy(how = How.ID, using = "usersLink")
    private WebElement userButton;

    public AdminSubMenu (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickUserButton() {
        userButton.click();
    }
}
