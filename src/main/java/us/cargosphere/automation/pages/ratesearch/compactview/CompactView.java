package us.cargosphere.automation.pages.ratesearch.compactview;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.ratesearch.ResultsView;
import us.cargosphere.automation.pages.ratesearch.compactview.filters.FilterControls;
import us.cargosphere.automation.pages.ratesearch.compactview.lcl.ShipmentInfoPopup;

public class CompactView extends BasePage implements ResultsView {

    @FindBy(how = How.CSS, using = ".cartInfo > .alignFlexRight > strong[ng-bind=\"comFilters.resultsTotal\"]")
    WebElement resultsTotal;
    @FindBy(how = How.CLASS_NAME, using = "ag-header-cell-text")
    private List<WebElement> columnHeaders;
    @FindBy(how = How.ID, using = "dropdownMenuButton")
    private WebElement dropdownMenuButton;
    @FindBy(how = How.ID, using = "dropdownMenuPieces")
    private WebElement piecesDropdownButton;
    @FindBy(how = How.XPATH, using = "//img[@id='ag-carrier-0']")
    private WebElement carrierLogo;
    @FindBy(how = How.XPATH, using = "//img[@id='ag-owner-0']")
    private WebElement ownerLogo;

    public CompactView(WebDriver webDriver, WebElement searchContext) {
        super(webDriver, searchContext);
    }

    @Override
    public int getResultCount() {
        return Integer.parseInt(resultsTotal.getAttribute("innerText"));
    }

    public List<CompactViewRow> getRows() {
        List<WebElement> webElements = webDriver
                .findElements(By.cssSelector(".ag-center-cols-container > .ag-row[row-id]"));
        List<CompactViewRow> rtn = new ArrayList<>();
        for (WebElement el : webElements) {
            rtn.add(new CompactViewRow(webDriver, el));
        }
        return rtn;
    }

    public FilterControls getFilterControls() {
        return new FilterControls(webDriver, webDriver.findElement(
                By.cssSelector("#compactViewTemplate > compact-filters")));
    }

    public CompactViewRow getRowByIndex(int rowNum) {
        return new CompactViewRow(webDriver, webDriver.findElement(
                By.cssSelector(".ag-center-cols-container > .ag-row[row-id=\"" + Integer.toString(rowNum) + "\"]")));
    }

    public List<String> getColumnNames() {
        List<String> columnNames = new ArrayList<>();

        for(WebElement header : columnHeaders) {
            columnNames.add(header.getAttribute("innerText"));
        }

        return columnNames;
    }

    public Dropdown getDropDown () {
        showDropDownMenu();
        return new Dropdown(webDriver, webDriver.findElement(
                By.id("compactViewDropdown")
        ));
    }

    public void moveColumnToPosition(String colName, int positionIndex) {
        Actions builder = new Actions(webDriver);

        List<String> columnNames = getColumnNames();

        int colIndex = columnNames.indexOf(colName);

        if(colIndex == -1) {
            throw new IllegalArgumentException("Invalid column name not in header:" + colName);
        }

        if (positionIndex == colIndex){
            return;
        }

        WebElement column1 = columnHeaders.get(colIndex);
        WebElement targetColumn = columnHeaders.get(positionIndex);

        Action dragAndDrop1 = builder.clickAndHold(column1)
                .moveToElement(targetColumn)
                .release(column1)
                .build();

        dragAndDrop1.perform();
    }

    public void showDropDownMenu() {
        if(dropdownMenuButton.getAttribute("aria-expanded").equals("false")){
            dropdownMenuButton.click();
        }
    }
    
    public Boolean showCarrierLogo() throws InterruptedException {
        Thread.sleep(2000);
      	return carrierLogo.isDisplayed();
      }

    public Boolean showOwnerLogo() throws InterruptedException {

        return carrierLogo.isDisplayed();
    }

    public ShipmentTotalToggle getShipmentTotalToggle() {
        return new ShipmentTotalToggle(webDriver,
                webDriver.findElement(By.cssSelector("#compactPieceTable > div.pieceToggle.middleAlign > div")));
    }

    public ShipmentInfoPopup getShipmentInfoPopup() {
        WebElement shipmentInfoPopup = webDriver.findElement(By.cssSelector("#compactPieceTable > div.pieceTable.middleAlign > div > div"));
        if(!shipmentInfoPopup.isDisplayed()) {
            piecesDropdownButton.click();
        }
        return new ShipmentInfoPopup(webDriver,
                webDriver.findElement(By.cssSelector("#compactPieceTable > div.pieceTable.middleAlign > div > div")));
    }

    public boolean isPiecesDropdownButtonDisplayed () {
        return piecesDropdownButton.isDisplayed();
    }
}