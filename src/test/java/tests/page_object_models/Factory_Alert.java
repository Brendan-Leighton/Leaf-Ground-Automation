package tests.page_object_models;
// SELENIUM
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
// CUSTOM UTILS
import utils.Urls;

public class Factory_Alert extends Factory__Index {
    public Factory_Alert() {
        super(Urls.get("alert"));
    }

    // LOCATORS
    @FindBy (css = "button[onclick=\"normalAlert()\"")
    private WebElement AlertButtonOne;
    @FindBy (css = "button[onclick=\"confirmAlert()\"")
    private WebElement AlertButtonTwo;
    @FindBy (css = "button[onclick=\"confirmPrompt()\"")
    private WebElement AlertButtonThree;
    @FindBy (css = "button[onclick=\"lineBreaks()\"")
    private WebElement AlertButtonFour;

    // GETTERS

    public WebElement getAlertButtonOne() {
        return AlertButtonOne;
    }

    public WebElement getAlertButtonTwo() {
        return AlertButtonTwo;
    }

    public WebElement getAlertButtonThree() {
        return AlertButtonThree;
    }

    public WebElement getAlertButtonFour() {
        return AlertButtonFour;
    }
}
