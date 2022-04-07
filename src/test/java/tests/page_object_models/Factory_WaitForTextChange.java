package tests.page_object_models;
// SELENIUM
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
// CUSTOM UTILS
import utils.Urls;

public class Factory_WaitForTextChange extends Factory__Index {
    public Factory_WaitForTextChange() {
        super(Urls.get("waitForTextChange"));
    }

    // LOCATORS
    @FindBy(css = "button#btn")
    private WebElement button;
    public String expectedButtonText = "Click ME!";

    // GETTERS

    public WebElement getButton() { return button; }
}
