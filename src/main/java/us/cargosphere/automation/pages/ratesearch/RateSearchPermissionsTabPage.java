package us.cargosphere.automation.pages.ratesearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import us.cargosphere.automation.pages.BasePage;

public class RateSearchPermissionsTabPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//ui-switch[@name='scopeToggle']//span[@class='switch switch-medium checked']")
	private WebElement scope;

	@FindBy(how = How.XPATH, using = "//ui-switch[@name='namedAcctToggle']//span[@class='switch switch-medium checked']")
	private WebElement namedAccounts;

	@FindBy(how = How.XPATH, using = "//ui-switch[@name='fclBuyToggle']//span[@class='switch switch-medium checked']")
	private WebElement fclBuy;

	@FindBy(how = How.XPATH, using = "//ui-switch[@name='lclBuyToggle']//span[@class='switch switch-medium checked']")
	private WebElement lclBuy;

	@FindBy(how = How.XPATH, using = "//ui-switch[@name='fclSellToggle']//span[@class='switch switch-medium checked']")
	private WebElement fclSell;

	@FindBy(how = How.XPATH, using = "//ui-switch[@name='lclSellToggle']//span[@class='switch switch-medium checked']")
	private WebElement lclSell;

	@FindBy(how = How.CSS, using = "#rateSearch > div:nth-child(14) > div > div > ui-switch > span")
	private WebElement markupSellrate;

	@FindBy(how = How.XPATH, using = "//ui-switch[@name='mra1Toggle']//span[@class='switch switch-medium checked']")
	private WebElement viponeDiscount;

	@FindBy(how = How.XPATH, using = "//ui-switch[@name='mra2Toggle']//span[@class='switch switch-medium checked']")
	private WebElement viptwoDiscount;

	public RateSearchPermissionsTabPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	public boolean scopeCheck() {
		if (scope.isEnabled())
			return true;
		else
			return false;
	}

	public boolean namedAccountsCheck() {
		if (namedAccounts.isEnabled())
			return true;
		else
			return false;
	}

	public boolean fclBuyCheck() {
		if (fclBuy.isEnabled())
			return true;
		else
			return false;
	}

	public boolean lclBuyCheck() {
		if (lclBuy.isEnabled())
			return true;
		else
			return false;
	}

	public boolean fclSellCheck() {
		if (fclSell.isEnabled())
			return true;
		else
			return false;
	}

	public boolean lclSellCheck() {
		if (lclSell.isEnabled())
			return true;
		else
			return false;
	}

	public boolean markupSellrateCheck() {
		if (markupSellrate.isEnabled())
			return true;
		else
			return false;
	}

	public boolean viponeDiscountCheck() {
		if (viponeDiscount.isEnabled())
			return true;
		else
			return false;
	}

	public boolean viptwoDiscountCheck() {
		if (viptwoDiscount.isEnabled())
			return true;
		else
			return false;
	}

}
