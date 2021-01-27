package us.cargosphere.automation.pages.ratesearch.compactview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

public class ShipmentTotalToggle extends BasePage {

    @FindBy(how = How.CSS, using = "#compactPieceTable > div.pieceToggle.middleAlign > div > div:nth-child(1)")
    private WebElement shipmentTotalButton;
    @FindBy(how = How.CSS, using = "#compactPieceTable > div.pieceToggle.middleAlign > div > div:nth-child(2)")
    private WebElement lclRateButotn;

    public ShipmentTotalToggle (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickShipmentTotalButton() {
        shipmentTotalButton.click();
    }

    public void clickLclRateButton() {
        lclRateButotn.click();
    }

    public boolean isShipmentTotalSelected() {
        return shipmentTotalButton.getAttribute("class").contains("optionSelected");
    }

    public boolean isLclRateSelected() {
        return lclRateButotn.getAttribute("class").contains("optionSelected");
    }
}
