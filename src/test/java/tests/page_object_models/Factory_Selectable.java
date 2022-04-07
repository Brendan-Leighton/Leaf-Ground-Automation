package tests.page_object_models;
// JAVA
import java.util.List;
// SELENIUM
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
// CUSTOM UTILS
import utils.Urls;

public class Factory_Selectable extends Factory__Index {

    public Factory_Selectable() {
        super(Urls.get("selectable"));
    }

    // LOCATORS
    @FindBy (css = "ol#selectable > li")
    private List<WebElement> selectableList;

    // GETTERS

    public List<WebElement> getSelectableList() { return selectableList; }
}
