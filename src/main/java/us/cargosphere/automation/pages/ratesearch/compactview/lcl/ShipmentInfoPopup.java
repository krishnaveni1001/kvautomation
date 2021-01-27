package us.cargosphere.automation.pages.ratesearch.compactview.lcl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.ratesearch.compactview.CompactViewRow;

import java.util.ArrayList;
import java.util.List;

public class ShipmentInfoPopup extends BasePage {

    @FindBy(how = How.CSS, using = "#compactPieceTable > div.pieceTable.middleAlign > div > div > div.pieceTableHeader > span.pieceError.ng-binding")
    private WebElement missingWeightErrorMessage;
    @FindBy(how = How.CSS, using = "#compactPieceTable > div.pieceTable.middleAlign > div > div > div.pieceTableHeader > span.pieceError.ng-binding")
    private WebElement mismatchErrorMessage;
    @FindBy(how = How.CSS, using = "#compactPieceTable > div.pieceTable.middleAlign > div > div > div.compact-pieces-row.tableOptions > div:nth-child(1) > span.middleAlign.redHover > i")
    private WebElement deleteAllButton;
    @FindBy(how = How.CSS, using = "#compactPieceTable > div.pieceTable.middleAlign > div > div > div.compact-pieces-row.tableOptions > div.middleAlign.totalSummary > div:nth-child(1)")
    private WebElement totalVolumeDiv;
    @FindBy(how = How.CSS, using = "#compactPieceTable > div.pieceTable.middleAlign > div > div > div.compact-pieces-row.tableOptions > div.middleAlign.totalSummary > div:nth-child(2)")
    private WebElement totalWeightDiv;
    @FindBy(how = How.ID, using = "saveButton")
    private WebElement saveButton;
    @FindBy(how = How.ID, using = "buttonApplyCancel")
    private WebElement cancelButton;

    public ShipmentInfoPopup (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public List<ShipmentInfoPopupRow> getInfoRows() {
        List<WebElement> webElements = webDriver
                .findElements(By.cssSelector("#compactPieceTable > div.pieceTable.middleAlign > div > div > div.pieceTableContent > div.compact-pieces-row.ng-scope"));
        List<ShipmentInfoPopupRow> rtn = new ArrayList<>();
        int i = 0;
        for (WebElement el : webElements) {
            rtn.add(new ShipmentInfoPopupRow(webDriver, el, i));
            i++;
        }
        return rtn;
    }

    public void clickSaveButton () {
        saveButton.click();
    }

    public void clickCancelButton () {
        cancelButton.click();
    }

    public void clickDeleteAllButton () { deleteAllButton.click(); }

    public String getTotalVolume () {
        String rawText = totalVolumeDiv.getText();
        return rawText.substring(rawText.indexOf(':') + 2).trim();
    }

    public String getTotalWeight() {
        String rawText = totalWeightDiv.getText();
        return rawText.substring(rawText.indexOf(':') + 2).trim();
    }

    public boolean isMissingWeightErrorDisplayed() {
        return missingWeightErrorMessage.isDisplayed();
    }

    public String getMissingWeightErrorMessageValue () {
        return missingWeightErrorMessage.getText();
    }

    public boolean isMismatchedErrorMessageDisplayed() {
        return mismatchErrorMessage.isDisplayed();
    }

    public String getMismatchedErrorMessageValue () {
        return mismatchErrorMessage.getText();
    }
}
