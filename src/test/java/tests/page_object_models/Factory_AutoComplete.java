package tests.page_object_models;
// JAVA
import java.util.List;
// SELENIUM
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
// CUSTOM UTILS
import utils.Urls;

public class Factory_AutoComplete extends Factory__Index {
    public Factory_AutoComplete() {
        super(Urls.get("autoComplete"));
    }

    // LOCATORS
    @FindBy (css = "input#tags")
    private WebElement inputField;

    @FindBy (css = "li.ui-menu-item")
    private WebElement suggestionsList;

    // GETTERS

    public WebElement getInputField() { return inputField; }

    public WebElement getSuggestionsList() {
        return suggestionsList;
    }

    public String getSuggestionsLocator() { return "li.ui-menu-item > div"; }
}
