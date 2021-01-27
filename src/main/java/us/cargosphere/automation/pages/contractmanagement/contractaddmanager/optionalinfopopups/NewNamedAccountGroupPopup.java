package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.optionalinfopopups;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.domain.UIContractDataLoad;
import us.cargosphere.automation.domain.UIContractDataLoad.Contract.NamedAccountGroup;
import us.cargosphere.automation.pages.BasePage;

import java.util.List;
import java.util.Set;

public class NewNamedAccountGroupPopup extends BasePage {

    @FindBy(how = How.CSS, using = "#trAddSpecificNamedAcct > td > table > tbody > tr:nth-child(2) > td:nth-child(1) > span > a")
    private WebElement addNewNamedAccountButton;
    @FindBy(how = How.CSS, using = "#trNewCommGroup > td > span > input[type=radio]:nth-child(1)")
    private WebElement byCompanyRadio;
    @FindBy(how = How.CSS, using = "#trNewCommGroup > td > span > input[type=radio]:nth-child(2)")
    private WebElement byEmailRadio;
    @FindBy(how = How.CSS, using = "#trNewCommGroup > td > span > input[type=radio]:nth-child(3)")
    private WebElement byContactRadio;
    @FindBy(how = How.ID, using = "namedAcct")
    private WebElement addByInfoTextInput;
    @FindBy(how = How.ID, using = "namedAcctList")
    private WebElement namedAccountSelect;
    @FindBy(how = How.ID, using = "newNamedAcctGroupName")
    private WebElement newNamedAccountGroupNameTextInput;
    @FindBy(how = How.CSS, using = "#divNewNamedAcctButton > input:nth-child(1)")
    private WebElement addNamedAccountGroupButton;
    @FindBy(how = How.CSS, using = "#divNewNamedAcctButton > input:nth-child(2)")
    private WebElement closeButton;

    public NewNamedAccountGroupPopup (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void addNewNamedAccountGroup(NamedAccountGroup namedAccountGroup) throws InterruptedException {
        for(String namedAccount : namedAccountGroup.getNamedAccounts()) {
            addNamedAccountToGroup(namedAccount);
        }
        newNamedAccountGroupNameTextInput.click();
        newNamedAccountGroupNameTextInput.sendKeys(namedAccountGroup.getNamedAccountGroupName());
        addNamedAccountGroupButton.click();
        Thread.sleep(200);
        webDriver.switchTo().alert().dismiss();
    }

    public void addNamedAccountToGroup (String namedAccount) throws InterruptedException {
        addByInfoTextInput.click();
        addByInfoTextInput.sendKeys(namedAccount);
        Thread.sleep(1000);
        // If named account exists, add from search bar
        if(selectNamedAccountFromResult(namedAccount)){
            return;
        }

        // Otherwise add through named account popup window
        addThroughNewNamedAccountWindow(namedAccount);
        namedAccountSelect.click();
        Thread.sleep(400);
        // For some reason entering a different search string than the one
        // just will get the autocomplete dropdown working again...
        // TODO figure out why this works and implement something more intuitive
        addByInfoTextInput.click();
        Thread.sleep(400);
        addByInfoTextInput.sendKeys("dummyValue");
        Thread.sleep(400);
        addByInfoTextInput.click();
        Thread.sleep(400);
        addByInfoTextInput.sendKeys(namedAccount);
        Thread.sleep(500);
        selectNamedAccountFromResult(namedAccount);

    }

    public boolean selectNamedAccountFromResult(String namedAccount) {
        List<WebElement> namedAccountSearchResults=  webDriver.findElements(By.className(
                "ui-corner-all"
        ));
        for(WebElement element : namedAccountSearchResults) {
            if(element.getAttribute("innerText").equals(namedAccount)) {
                element.click();
                addByInfoTextInput.clear();
                return true;
            }
        }
        return false;
    }

    public void addThroughNewNamedAccountWindow(String namedAccount) throws InterruptedException {
        addNewNamedAccountButton.click();
        Thread.sleep(200);

        String mainHandle = webDriver.getWindowHandle();
        String popupHandle = "";
        Set<String> handles = webDriver.getWindowHandles();

        if(handles.size() > 2) {
            throw new IllegalStateException("Found too many popups when adding named account.");
        }

        // Switch webDriver control to the non-main window.
        for(String handle : handles) {
            if(!handle.equals(mainHandle)) {
                webDriver.switchTo().window(handle);
            }
            System.out.println("Found handle: " + handle);
        }

        WebElement companyNameInput = webDriver.findElement(By.id("companyName"));
        companyNameInput.click();
        companyNameInput.sendKeys(namedAccount);

        WebElement addCustomerAgentButton = webDriver.findElement(By.id("submitButton"));
        addCustomerAgentButton.click();

        // Close popup
        webDriver.findElement(By.cssSelector(
                "body > form > div > table:nth-child(1) > tbody > tr > td:nth-child(3) > a")).click();

        // Return webDriver control to main window
        webDriver.switchTo().window(mainHandle);
    }

    public void clickByCompanyRadio () {
        byCompanyRadio.click();
    }

    public void clickByEmailRadio () {
        byEmailRadio.click();
    }

    public void clickByContactRadio () {
        byContactRadio.click();
    }

    public void clickAddByInfoTextInput () {
        addByInfoTextInput.click();
    }

    public void typeIntoAddByInfoTextInput (String namedAcctGroupInfo) {
        clickAddByInfoTextInput();
        addByInfoTextInput.sendKeys(namedAcctGroupInfo);
    }

    public void clickNamedAccountSelect () {
        namedAccountSelect.click();
    }

    public void clickNewNamedAccountGroupNameTextInput () {
        newNamedAccountGroupNameTextInput.click();
    }

    public void typeIntoNewNamedAccountGroupNameTextInput (String namedAcctGroupName) {
        clickNewNamedAccountGroupNameTextInput();
        newNamedAccountGroupNameTextInput.sendKeys(namedAcctGroupName);
    }

    public void clickAddNamedAccountGroupButton() {
        addNamedAccountGroupButton.click();
    }

    public void clickCloseButton () {
        closeButton.click();
    }

}
