package tests.page_object_models;
// SELENIUM
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
// CUSTOM UTILS
import utils.Urls;

public class Factory_Tooltip extends Factory__Index {
    public Factory_Tooltip() {
        super(Urls.get("tooltip"));
    }

    // LOCATORS
    @FindBy (css = "input#age")
    private WebElement tooltipInputField;

    @FindBy (css = "div[role=\"tooltip\"]")
    private WebElement tooltipPopupDiv;

    // GETTERS

    public WebElement getTooltipInputField() { return tooltipInputField; }

    public WebElement getTooltipPopupDiv() { return tooltipPopupDiv; }
}
