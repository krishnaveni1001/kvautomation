package us.cargosphere.automation.pages.ratesearch.compactview.level2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.util.SeleniumUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NamedAccountsTab extends BasePage {
    @FindBy(how = How.CSS, using = "#compactNamedAccountsTab > div.compactNAHeader > span")
    private WebElement namedAccountGroupName;
    @FindBy(how = How.CLASS_NAME, using = "compactNAGroup")
    private WebElement namedAccounts;

    public NamedAccountsTab(WebDriver webDriver, WebElement context) {
        super(webDriver, context);
    }

    public String getNamedAccountGroupName() {
        return namedAccountGroupName.getAttribute("innerText");
    }

    public List<String> getNamedAccounts() {
        return new ArrayList<>(Arrays.asList(SeleniumUtil.getText(namedAccounts, false).split("\n")));
    }
}
