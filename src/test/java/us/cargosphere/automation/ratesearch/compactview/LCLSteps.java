package us.cargosphere.automation.ratesearch.compactview;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.pages.ratesearch.compactview.CompactView;
import us.cargosphere.automation.pages.ratesearch.compactview.ShipmentTotalToggle;
import us.cargosphere.automation.pages.ratesearch.compactview.lcl.ShipmentInfoPopup;
import us.cargosphere.automation.pages.ratesearch.compactview.lcl.ShipmentInfoPopupRow;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LCLSteps extends BaseStepDefinitions {


    private CompactView compactView;

    public LCLSteps (TestContext context) {
        super(context);
        compactView = this.testContext.getPageObjectManager().getRateSearchResultsPage().getCompactView();
    }

    @Then("^the shipment info popup is empty$")
    public void theShipmentInfoPopupIsEmpty() throws InterruptedException {
        List<ShipmentInfoPopupRow> rows = compactView.getShipmentInfoPopup().getInfoRows();
        assertEquals("Expected only one info row in empty popup", 1, rows.size());
        assertTrue("Expected shipment info to be empty", rows.get(0).isEmpty());
        Thread.sleep(1000);
    }


    @When("^the user sets the LCL Toggle to LCL Rate$")
    public void theUserSetsTheLCLToggleToLCLRate() {
        ShipmentTotalToggle toggle = compactView.getShipmentTotalToggle();
        if(toggle.isShipmentTotalSelected()) {
            toggle.clickLclRateButton();
        }
    }

    @When("^the user sets the LCL Toggle to Shipment Total$")
    public void theUserSetsTheLCLToggleToShipmentTotal() {
        ShipmentTotalToggle toggle = compactView.getShipmentTotalToggle();
        if(toggle.isLclRateSelected()) {
            toggle.clickShipmentTotalButton();
        }
    }

    @When("^the user enters the shipment info for row (\\d+)$")
    public void the_user_enter_shipment_info(int rowNum, DataTable shipInfo) throws Throwable {
        ShipmentInfoPopupRow infoRow = compactView.getShipmentInfoPopup().getInfoRows().get(rowNum);
        List<Map<String,String>> data = shipInfo.asMaps(String.class,String.class);
        infoRow.setQuantity(data.get(0).get("Quantity"));
        infoRow.setPieceType(data.get(0).get("Piece Type"));
        infoRow.setDimensionType(data.get(0).get("Dimen Type"));
        infoRow.setLength(data.get(0).get("Length"));
        infoRow.setWidth(data.get(0).get("Width"));
        infoRow.setHeight(data.get(0).get("Height"));
        infoRow.setMeasureType(data.get(0).get("Measure Type"));
        infoRow.setUnitWeight(data.get(0).get("Unit Weight"));
        infoRow.setWeightType(data.get(0).get("Weight Type"));
    }

    @When("^the user saves the shipment info$")
    public void theUserSavesTheShipmentInfo() throws InterruptedException {
        compactView.getShipmentInfoPopup().clickSaveButton();
        Thread.sleep(500);
    }

    @Then("^the shipment info for row (\\d+) is$")
    public void theShipmentInfoForRowIs(int rowNum, DataTable shipInfo) {
        ShipmentInfoPopupRow infoRow = compactView.getShipmentInfoPopup().getInfoRows().get(rowNum);
        List<Map<String,String>> data = shipInfo.asMaps(String.class,String.class);
        assertEquals("Expected quantity to match", data.get(0).get("Quantity"), infoRow.getQuantity());
        assertEquals("Expected piece type to match", data.get(0).get("Piece Type"), infoRow.getPieceType());
        assertEquals("Expected dim type to match", data.get(0).get("Dimen Type"), infoRow.getDimensionType());
        assertEquals("Expected length to match", data.get(0).get("Length"), infoRow.getLength());
        assertEquals("Expected width to match", data.get(0).get("Width"), infoRow.getWidth());
        assertEquals("Expected height to match", data.get(0).get("Height"), infoRow.getHeight());
        assertEquals("Expected measure type to match", data.get(0).get("Measure Type"), infoRow.getMeasureType());
        assertEquals("Expected unit weight to match", data.get(0).get("Unit Weight"), infoRow.getUnitWeight());
        assertEquals("Expected weight type to match", data.get(0).get("Weight Type"), infoRow.getWeightType());
    }

    @When("^the user clears the shipment info$")
    public void theUserClearsTheShipmentInfo() throws InterruptedException {
        ShipmentInfoPopup popup = compactView.getShipmentInfoPopup();
        popup.clickDeleteAllButton();
        popup.clickSaveButton();
        Thread.sleep(500);
    }

    @Then("^the total volume is \"([^\"]*)\"$")
    public void theTotalVolumeIs(String expected) {
        ShipmentInfoPopup popup = compactView.getShipmentInfoPopup();
        assertEquals(expected, popup.getTotalVolume());
    }

    @Then("^the total weight is \"([^\"]*)\"$")
    public void theTotalWeightIs(String expected) {
        ShipmentInfoPopup popup = compactView.getShipmentInfoPopup();
        assertEquals(expected, popup.getTotalWeight());
    }

    @When("^the user clicks cancel on the shipment info popup$")
    public void theUserClicksCancelOnTheShipmentInfoPopup() {
        compactView.getShipmentInfoPopup().clickCancelButton();
    }

    @Then("^the LCL toggle is set to LCL Rate$")
    public void theLCLToggleIsSetToLCLRate() {
        assertTrue(compactView.getShipmentTotalToggle().isLclRateSelected());
    }

    @Then("^the shipment info missing weight error message is visible$")
    public void theShipmentInfoMissingInfoErrorMessageIsVisible() {
        assertTrue(compactView.getShipmentInfoPopup().isMissingWeightErrorDisplayed());
    }

    @Then("^the shipment info mismatched units error message is visible$")
    public void theShipmentInfoMismatchedUnitsErrorMessageIsVisible() {
        assertTrue(compactView.getShipmentInfoPopup().isMismatchedErrorMessageDisplayed());
    }
}
