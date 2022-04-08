package tests.page_object_models;
// SELENIUM
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
// CUSTOM UTILS
import utils.Urls;

public class Factory_WaitForAlert extends Factory__Index {

    public Factory_WaitForAlert() { super(Urls.get("waitForAlert")); }

    // LOCATORS
    @FindBy (css = "button#alert") private WebElement button;

    // GETTERS
    public WebElement getButton() { return button; }
}
