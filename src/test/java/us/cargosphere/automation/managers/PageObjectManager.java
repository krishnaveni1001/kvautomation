package us.cargosphere.automation.managers;

import org.openqa.selenium.WebDriver;

import us.cargosphere.automation.pages.admin.usermanagement.SystemAdminPermissionTab;
import us.cargosphere.automation.pages.admin.usermanagement.UserManagementAdminPage;
import us.cargosphere.automation.pages.contractmanagement.CarrierSelectPage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;
import us.cargosphere.automation.pages.navigation.RateMgmtSubMenu;
import us.cargosphere.automation.pages.quoting.NewQuotePage;
import us.cargosphere.automation.pages.quoting.QuotePermissionsTabPage;
import us.cargosphere.automation.pages.quoting.QuotingChangePage;
import us.cargosphere.automation.pages.ratemanagement.RateMgmtChooseCarrierPage;
import us.cargosphere.automation.pages.ratemanagement.RateMgmtFreeTimePage;
import us.cargosphere.automation.pages.ratesearch.startpage.RateSearchStartPage;
import us.cargosphere.automation.pages.reports.BunkOmissionReportPage;
import us.cargosphere.automation.pages.settings.CarriersPage;
import us.cargosphere.automation.pages.settings.ManageFmcUsersPage;
import us.cargosphere.automation.pages.settings.UsersPage;
import us.cargosphere.automation.pages.ForgotPasswordPage;
import us.cargosphere.automation.pages.LoginPage;
import us.cargosphere.automation.pages.ResetPasswordPage;
import us.cargosphere.automation.pages.ratesearch.RateSearchPermissionsTabPage;
import us.cargosphere.automation.pages.ratesearch.RateSearchResultsPage;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.admin.usermanagement.AccountAdminPermissionTab;
import us.cargosphere.automation.pages.admin.usermanagement.CommonPermissionPage;
import us.cargosphere.automation.pages.admin.usermanagement.FmcPermissionTab;

/**
 * <p>
 * The duty of the PageObjectManager is to create the page’s object and to
 * ensure that the same object is not created multiple times.
 * </p>
 * 
 * <p>
 * When combined with {@link TestContext}, we can use the same PageObjectManager
 * and PageObjects across multiple StepDefinition files.
 * </p>
 */
public class PageObjectManager {
	private WebDriver driver;
	private LoginPage loginPage;
	private ForgotPasswordPage forgotPwdPage;
	private ResetPasswordPage resetPwdPage;
	private RateSearchStartPage rateSearchStartPage;
	private RateSearchResultsPage rateSearchResultsPage;
	private CarrierSelectPage carrierSelectPage;
	private NavigationMenuBar navigationMenuBar;
	private NewQuotePage quotePage;
	private UserManagementAdminPage userManagementAdminPage;
	private BunkOmissionReportPage bunkOmissionReportPage;
	private QuotePermissionsTabPage quotePermissionsTabPage;
	private RateSearchPermissionsTabPage rateSearchPermissionsTabPage;
	private ManageFmcUsersPage fmcUsersPage;
	private CarriersPage addCarrierPage;
	private UsersPage addUsersPage;
	private SystemAdminPermissionTab systemAdmPermPage;
	private AccountAdminPermissionTab accountAdmPermPage;
	private CommonPermissionPage commonPermPage;
	private FmcPermissionTab fmcPermPage;
	private RateMgmtFreeTimePage freetimepage;
	private RateMgmtSubMenu ratemanagementSubMenu;
	private RateMgmtChooseCarrierPage carrierPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	public RateMgmtChooseCarrierPage getCarrierPage() {
		return (carrierPage == null) ? carrierPage = new RateMgmtChooseCarrierPage(driver) : carrierPage;
	}

	public RateSearchStartPage getRateSearchStartPage() {
		return (rateSearchStartPage == null) ? rateSearchStartPage = new RateSearchStartPage(driver)
				: rateSearchStartPage;
	}

	public RateSearchResultsPage getRateSearchResultsPage() {
		return (rateSearchResultsPage == null) ? rateSearchResultsPage = new RateSearchResultsPage(driver)
				: rateSearchResultsPage;
	}

	public CarrierSelectPage getCarrierSelectPage() {
		return (carrierSelectPage == null) ? carrierSelectPage = new CarrierSelectPage(driver) : carrierSelectPage;
	}

	public ForgotPasswordPage getForgotPasswordPage() {
		return (forgotPwdPage == null) ? forgotPwdPage = new ForgotPasswordPage(driver) : forgotPwdPage;
	}

	public RateMgmtFreeTimePage getFreetimePage() {
		return (freetimepage == null) ? freetimepage = new RateMgmtFreeTimePage(driver) : freetimepage;
	}

	public ResetPasswordPage getResetPasswordPage() {
		return (resetPwdPage == null) ? resetPwdPage = new ResetPasswordPage(driver) : resetPwdPage;
	}

	public NavigationMenuBar getNavigationMenuBar() {
		return (navigationMenuBar == null) ? navigationMenuBar = new NavigationMenuBar(driver) : navigationMenuBar;
	}

	public NewQuotePage getQuotePage() {
		return (quotePage == null) ? quotePage = new NewQuotePage(driver) : quotePage;
	}

	public BunkOmissionReportPage getBunkOmissionReportPage() {
		return (bunkOmissionReportPage == null) ? bunkOmissionReportPage = new BunkOmissionReportPage(driver)
				: bunkOmissionReportPage;
	}

	public ManageFmcUsersPage getFmcPage() {
		return (fmcUsersPage == null) ? fmcUsersPage = new ManageFmcUsersPage(driver) : fmcUsersPage;
	}

	public CarriersPage getCarriersPage() {
		return (addCarrierPage == null) ? addCarrierPage = new CarriersPage(driver) : addCarrierPage;
	}

	public UsersPage getUsersPage() {
		return (addUsersPage == null) ? addUsersPage = new UsersPage(driver) : addUsersPage;
	}

	public SystemAdminPermissionTab getSysAdmPermPage() {
		return (systemAdmPermPage == null) ? systemAdmPermPage = new SystemAdminPermissionTab(driver)
				: systemAdmPermPage;
	}

	public AccountAdminPermissionTab getAccountAdmPermPage() {
		return (accountAdmPermPage == null) ? accountAdmPermPage = new AccountAdminPermissionTab(driver)
				: accountAdmPermPage;
	}

	public RateMgmtSubMenu getsubmenuPage() {
		return (ratemanagementSubMenu == null) ? ratemanagementSubMenu = new RateMgmtSubMenu(driver)
				: ratemanagementSubMenu;
	}

	public FmcPermissionTab getfmPermPage() {
		return (fmcPermPage == null) ? fmcPermPage = new FmcPermissionTab(driver) : fmcPermPage;
	}

	public CommonPermissionPage getPermPage() {
		return (commonPermPage == null) ? commonPermPage = new CommonPermissionPage(driver) : commonPermPage;
	}

	public UserManagementAdminPage getUserManagementAdminPage() {
		return (userManagementAdminPage == null) ? userManagementAdminPage = new UserManagementAdminPage(driver)
				: userManagementAdminPage;

	}

	public QuotePermissionsTabPage getQuoteermissionsTabPage() {
		return (quotePermissionsTabPage == null) ? quotePermissionsTabPage = new QuotePermissionsTabPage(driver)
				: quotePermissionsTabPage;
	}

	public RateSearchPermissionsTabPage getRateSearchPermissionsTabPage() {
		return (rateSearchPermissionsTabPage == null)
				? rateSearchPermissionsTabPage = new RateSearchPermissionsTabPage(driver)
				: rateSearchPermissionsTabPage;
	}

}