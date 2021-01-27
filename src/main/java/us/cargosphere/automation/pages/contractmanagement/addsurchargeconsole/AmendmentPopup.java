package us.cargosphere.automation.pages.contractmanagement.addsurchargeconsole;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

public class AmendmentPopup extends BasePage {

    @FindBy(how = How.ID, using = "amendmentName")
    private WebElement amendmentNameInput;
    @FindBy(how = How.CSS, using = "body > div.modal.fade.ng-isolate-scope.in > div > div > div.modal-footer.ng-scope > button:nth-child(2)")
    private WebElement skipButton;

    public AmendmentPopup (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickSkipButton () {
        skipButton.click();
    }
}
