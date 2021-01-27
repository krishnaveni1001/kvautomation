package us.cargosphere.automation.pages.ratesearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import us.cargosphere.automation.pages.BasePage;

public class TopNavBar extends BasePage {

    @FindBy(how = How.ID, using = "activityMenu")
    private WebElement activityMenuButton;
    @FindBy(how = How.ID, using = "rateSearchMenu")
    private WebElement rateSearchButton;
    @FindBy(how = How.ID, using = "rateMgmtMenu")
    private WebElement rateManagementButton;
    @FindBy(how = How.ID, using = "rateMeshMenu")
    private WebElement rateMeshButton;
    @FindBy(how = How.ID, using = "quoteDashMenu")
    private WebElement quoteDashButton;
    @FindBy(how = How.ID, using = "fmcTariffMenu")
    private WebElement fmcTariffButton;
    @FindBy(how = How.ID, using = "reportsMenu")
    private WebElement reportsButton;
    @FindBy(how = How.ID, using = "analyticsMenu")
    private WebElement analyticsButton;


    public TopNavBar(WebDriver webDriver, WebElement el) {
        super(webDriver, el);
        PageFactory.initElements(webDriver, this);
    }

    public void clickActivityMenuButton () {
        activityMenuButton.click();
    }

    public void clickRateManagementButton () { rateManagementButton.click(); }
}
