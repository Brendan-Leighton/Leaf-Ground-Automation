package tests.page_object_models;
// SELENIUM
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
// CUSTOM UTILS
import utils.Urls;

public class Factory_WaitToAppear extends Factory__Index {
    public Factory_WaitToAppear() {
        super(Urls.get("waitToAppear"));
    }

    // LOCATORS
    @FindBy (css = "button#btn")
    private WebElement buttonToWaitFor;

    // GETTERS

    public WebElement getButtonToWaitFor() { return buttonToWaitFor; }
}
