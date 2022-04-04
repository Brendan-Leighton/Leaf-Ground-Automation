package tests.page_object_models;

// CUSTOM
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Urls;

/**
 * Page Object Model representing the "edit" page of the LeafGround.com site.
 */
public class Factory_Edit extends Factory__Index {

    // CONSTRUCTOR - only one
    public Factory_Edit() {
        // SUPER
        super(Urls.get("edit"));
    }

    // LOCATORS

    @FindBy (css = "input#email")
    private WebElement inputEmail;

    @FindBy (css = "input[value='Append ']")
    private WebElement inputToAppendTo;

    @FindBy (css = "input[value='TestLeaf']")
    private WebElement inputToGetTextFrom;

    @FindBy (css = "input[value='Clear me!!']")
    private WebElement inputToClear;

    @FindBy (css = "input[disabled='true']")
    private WebElement inputToConfirmIsDisabled;

    // GETTERS


    public WebElement getInputEmail() {
        return inputEmail;
    }

    public WebElement getInputToAppendTo() {
        return inputToAppendTo;
    }

    public WebElement getInputToGetTextFrom() {
        return inputToGetTextFrom;
    }

    public WebElement getInputToClear() {
        return inputToClear;
    }

    public WebElement getInputToConfirmIsDisabled() {
        return inputToConfirmIsDisabled;
    }
}
