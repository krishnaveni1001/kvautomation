package us.cargosphere.automation.pages.ratesearch.compactview.level2;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import us.cargosphere.automation.util.SeleniumUtil;

public class ContractTabAmendmentRow {
    String number;
    String administrator;
    String receivedDate;
    String notes;

    public ContractTabAmendmentRow(WebElement context) {
        number = SeleniumUtil.getText(context.findElement(By.className("number")), false);
        administrator = SeleniumUtil.getText(context.findElement(By.className("administrator")), false);
        receivedDate = SeleniumUtil.getText(context.findElement(By.className("receivedDate")), false);
        notes = SeleniumUtil.getText(context.findElement(By.className("notes")), false);
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAdministrator() {
        return this.administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    public String getReceivedDate() {
        return this.receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ContractTabAmendmentRow)) {
            return false;
        }
        ContractTabAmendmentRow contractTabAmendmentRow = (ContractTabAmendmentRow) o;
        return Objects.equals(number, contractTabAmendmentRow.number)
                && Objects.equals(administrator, contractTabAmendmentRow.administrator)
                && Objects.equals(receivedDate, contractTabAmendmentRow.receivedDate)
                && Objects.equals(notes, contractTabAmendmentRow.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, administrator, receivedDate, notes);
    }

    @Override
    public String toString() {
        return "{" +
            " number='" + getNumber() + "'" +
            ", administrator='" + getAdministrator() + "'" +
            ", receivedDate='" + getReceivedDate() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }

}