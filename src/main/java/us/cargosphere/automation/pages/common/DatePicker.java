package us.cargosphere.automation.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import us.cargosphere.automation.pages.BasePage;

public class DatePicker extends BasePage {

    @FindBy(how = How.CLASS_NAME, using = "DatePickerBtnSelect")
    private WebElement selectedDate;
    @FindBy(how = How.XPATH, using = "//*[@id=\"theDatePicker\"]/table/tbody/tr[1]/td/table/tbody/tr[2]/td[4]")
    private WebElement nextMonthButton;

    public DatePicker (WebDriver webDriver, WebElement el) {
        super(webDriver, el);
    }

    public void clickSelectedDate () {
        selectedDate.click();
    }

    public void clickNextMonthButton () {
        nextMonthButton.click();
    }

}
