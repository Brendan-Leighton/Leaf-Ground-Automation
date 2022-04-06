package tests.page_object_models;
// SELENIUM
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
// CUSTOM UTILS
import utils.Urls;

public class Factory_Table extends Factory__Index {

    // CONSTRUCTOR
    public Factory_Table() {
        super(Urls.get("table"));
    }

    // LOCATORS

    @FindBy(css = "table[cellspacing=\"0\"]")
    private WebElement table;

    // DATA
    public String ExpectedResultQ4 = "tbody tr:nth-child(5) td:nth-child(3) input";

    // GETTERS

    public WebElement getTable() {
        return table;
    }
}
