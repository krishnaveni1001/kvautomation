package us.cargosphere.automation.pages.ratesearch.compactview.lcl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import us.cargosphere.automation.pages.BasePage;

public class ShipmentInfoPopupRow extends BasePage {

    private final WebElement quantityInput;
    private final Select pieceTypeSelect;
    private final Select dimensionTypeSelect;
    private final WebElement lengthInput;
    private final WebElement widthInput;
    private final WebElement heightInput;
    private final WebElement totalVolumeInput;
    private final Select measureTypeSelect;
    private final WebElement unitWeightInput;
    private final WebElement totalWeightInput;
    private final Select weightTypeSelect;

    public ShipmentInfoPopupRow(WebDriver webDriver, WebElement container, int rowNum) {

        super(webDriver, container);
        String baseSelector = "#compactPieceTable > div.pieceTable.middleAlign > div > div > div.pieceTableContent > ";
        String containerSelector = baseSelector + "div:compact-pieces-row.ng-scope";

        quantityInput = webDriver.findElement(By.id("quantity-" + rowNum));
        pieceTypeSelect = new Select(webDriver.findElement(By.id("piece-type-" + rowNum)));
        dimensionTypeSelect = new Select(webDriver.findElement(By.id("dimen-type-" + rowNum)));
        lengthInput = webDriver.findElement(By.id("length-" + rowNum));
        widthInput = webDriver.findElement(By.id("width-" + rowNum));
        heightInput = webDriver.findElement(By.id("height-" + rowNum));
        totalVolumeInput = webDriver.findElement(By.id("total-volume-" + rowNum));
        measureTypeSelect = new Select(webDriver.findElement(By.id("measure-type-" + rowNum)));
        unitWeightInput = webDriver.findElement(By.id("unit-weight-" + rowNum));
        totalWeightInput = webDriver.findElement(By.id("total-weight-" + rowNum));
        weightTypeSelect = new Select(webDriver.findElement(By.id("weight-type-" + rowNum)));

    }

    public String getQuantity () {
        return quantityInput.getAttribute("value");
    }

    public void setQuantity (String quantity) throws InterruptedException {
        quantityInput.click();
        quantityInput.sendKeys(quantity);
    }

    public String getPieceType () {
        return pieceTypeSelect.getFirstSelectedOption().getText().trim();
    }

    public void setPieceType (String piece) {
        pieceTypeSelect.selectByVisibleText(piece);
    }

    public String getDimensionType () {
        return dimensionTypeSelect.getFirstSelectedOption().getText().trim();
    }

    public void setDimensionType (String dimensionType) {
        dimensionTypeSelect.selectByVisibleText(dimensionType);
    }

    public String getLength () {
        return lengthInput.getAttribute("value");
    }
    
    public void setLength (String length) {
        lengthInput.click();
        lengthInput.sendKeys(length);
    }

    public String getWidth () {
        return widthInput.getAttribute("value");
    }

    public void setWidth (String width) {
        widthInput.click();
        widthInput.sendKeys(width);
    }
    
    public String getHeight () {
        return heightInput.getAttribute("value");
    }

    public void setHeight (String height) {
        heightInput.click();
        heightInput.sendKeys(height);
    }

    public String getTotalVolume () {
        return totalVolumeInput.getAttribute("value");
    }

    public void setTotalVolume (String totalVolume) {
        totalVolumeInput.click();
        totalVolumeInput.sendKeys(totalVolume);
    }

    public String getMeasureType () {
        return measureTypeSelect.getFirstSelectedOption().getText().trim();
    }

    public void setMeasureType (String measureType) {
        measureTypeSelect.selectByVisibleText(measureType);
    }

    public String getUnitWeight () {
        return unitWeightInput.getAttribute("value");
    }

    public void setUnitWeight (String unitWeight) {
        unitWeightInput.click();
        unitWeightInput.sendKeys(unitWeight);
    }

    public String getTotalWeight () {
        return totalWeightInput.getAttribute("value");
    }

    public void setTotalWeight (String totalWeight) {
        totalVolumeInput.click();
        totalVolumeInput.sendKeys(totalWeight);
    }

    public String getWeightType () {
        return weightTypeSelect.getFirstSelectedOption().getText().trim();
    }

    public void setWeightType (String weightType) {
        weightTypeSelect.selectByVisibleText(weightType);
    }

    public boolean isEmpty () {
        return getQuantity().isEmpty() &&
                getPieceType().isEmpty() &&
                getDimensionType().isEmpty() &&
                getLength().isEmpty() &&
                getWidth().isEmpty() &&
                getHeight().isEmpty() &&
                getTotalVolume().isEmpty() &&
                getMeasureType().isEmpty() &&
                getUnitWeight().isEmpty() &&
                getTotalWeight().isEmpty() &&
                getWeightType().isEmpty();
    }
}