package tests.page_object_models;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Urls;

public class Factory_Calendar extends Factory__Index {
    public Factory_Calendar() {
        super(Urls.get("calendar"));
    }

    // LOCATORS
    @FindBy (css = "input#datepicker")
    private WebElement calendarInput;

    @FindBy (css = "a[title='Next']")
    private WebElement calendarButtonNextPage;

    @FindBy (css = "table.ui-datepicker-calendar")
    private WebElement calendarTable;

    // GETTERS

    public WebElement getCalendarInput() {
        return calendarInput;
    }

    public WebElement getCalendarButtonNextPage() {
        return calendarButtonNextPage;
    }

    public WebElement getCalendarTable() {
        return calendarTable;
    }
}
