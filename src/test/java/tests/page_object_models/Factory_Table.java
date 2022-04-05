package tests.page_object_models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.OkHttpClient;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Asserts;
import utils.Drivers;
import utils.Urls;
import utils.Waits;

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
