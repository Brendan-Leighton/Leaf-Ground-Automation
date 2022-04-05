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

    // GETTERS

    public WebElement getTable() {
        return table;
    }
}
