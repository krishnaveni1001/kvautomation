package us.cargosphere.automation.pages.contractmanagement.contractaddmanager.requiredinfopopups;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

public class LCLUnitSelectPopup extends BasePage {

    final String _10000_LBS =  "10000 Lbs";
    final String _40_CUBIC_FT_2000_LBS =  "40 Cubic Ft. 2000 Lbs";
    final String _40_CUBIC_FT_500_LBS = "40 Cubic Ft. 500 Lbs";
    final String CUBIC_FT_100_LBS = "Cubic Ft. 100 Lbs";
    final String CUBIC_FT_20_LBS = "Cubic Ft. 20 Lbs";
    final String CUBIC_FT_50_LBS = "Cubic Ft 50 Lbs";
    final String CUBIC_METER = "Cubic Meter";
    final String CUBIC_METER_1000_KGS = "Cubic Meter 1000 Kgs";
    final String CUBIC_METER_100_KGS = "Cubic Meter 100 Kgs";
    final String CUBIC_METER_240_KGS = "Cubic Meter 240 Kgs";

    @FindBy(how = How.CSS, using = "#selUnitTypeIds > option:nth-child(1)")
    private WebElement unit1000LbsOption;
    @FindBy(how = How.CSS, using = "#selUnitTypeIds > option:nth-child(2)")
    private WebElement unit40CubicFoot2000LbsOption;
    @FindBy(how = How.CSS, using = "#selUnitTypeIds > option:nth-child(3)")
    private WebElement unit40CubicFoot500LbsOption;
    @FindBy(how = How.CSS, using = "#selUnitTypeIds > option:nth-child(4)")
    private WebElement cubicFt100LbsOption;
    @FindBy(how = How.CSS, using = "#selUnitTypeIds > option:nth-child(5)")
    private WebElement cubicFt20LbsOption;
    @FindBy(how = How.CSS, using = "#selUnitTypeIds > option:nth-child(6)")
    private WebElement cubicFt50LbsOption;
    @FindBy(how = How.CSS, using = "#selUnitTypeIds > option:nth-child(7)")
    private WebElement cubicMeterSelectOption;
    @FindBy(how = How.CSS, using = "#selUnitTypeIds > option:nth-child(8)")
    private WebElement cubicMeter1000KgsOption;
    @FindBy(how = How.CSS, using = "#selUnitTypeIds > option:nth-child(9)")
    private WebElement cubicMeter100KgsOption;
    @FindBy(how = How.CSS, using = "#selUnitTypeIds > option:nth-child(10)")
    private WebElement cubicMeter240KgsOption;
    // TODO add remaining LCL unit type selects
    @FindBy(how = How.ID, using = "contTypeSelect")
    private WebElement selectButton;

    public LCLUnitSelectPopup (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void selectUnitType(String unitType) {

        Actions action = new Actions(webDriver);
        action.keyDown(Keys.CONTROL).build().perform();

        switch(unitType) {
            case _10000_LBS:
                unit1000LbsOption.click();
                break;
            case _40_CUBIC_FT_2000_LBS:
                unit40CubicFoot2000LbsOption.click();
                break;
            case _40_CUBIC_FT_500_LBS:
                unit40CubicFoot500LbsOption.click();
                break;
            case CUBIC_FT_100_LBS:
                cubicFt100LbsOption.click();
                break;
            case CUBIC_FT_20_LBS:
                cubicFt20LbsOption.click();
                break;
            case CUBIC_FT_50_LBS:
                cubicFt50LbsOption.click();
                break;
            case CUBIC_METER:
                cubicMeterSelectOption.click();
                break;
            case CUBIC_METER_1000_KGS:
                cubicMeter1000KgsOption.click();
                break;
            case CUBIC_METER_100_KGS:
                cubicMeter100KgsOption.click();
                break;
            case CUBIC_METER_240_KGS:
                cubicMeter240KgsOption.click();
                break;
            default:
                String message = "Invalid LCL unit type: " + unitType + " does not exist or is not implemented.\n";
                throw new IllegalArgumentException(message);
        }

        action.keyUp(Keys.CONTROL).build().perform();
    }

    public void select1000Lbs() {
        selectUnitType(_10000_LBS);
    }

    public void select40CubicFt2000Lbs() {
        selectUnitType(_40_CUBIC_FT_2000_LBS);
    }

    public void select40CubicFt500Lbs() {
        selectUnitType(_40_CUBIC_FT_500_LBS);
    }

    public void selectCubicFt100Lbs() {
        selectUnitType(CUBIC_FT_100_LBS);
    }

    public void selectCubicFt20Lbs() {
        selectUnitType(CUBIC_FT_20_LBS);
    }

    public void selectCubicFt50Lbs() {
        selectUnitType(CUBIC_FT_50_LBS);
    }

    public void selectCubicMeter() {
        selectUnitType(CUBIC_METER);
    }

    public void selectCubicMeter1000Kgs() {
        selectUnitType(CUBIC_METER_1000_KGS);
    }

    public void selectCubicMeter100Kgs() {
        selectUnitType(CUBIC_METER_100_KGS);
    }

   public void selectCubicMeter240Kgs() {
        selectUnitType(CUBIC_METER_240_KGS);
   }

    public void clickSelectButton () {
        selectButton.click();
    }

}
