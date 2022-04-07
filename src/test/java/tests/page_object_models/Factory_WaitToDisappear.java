package tests.page_object_models;
// SELENIUM
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
// CUSTOM UTILS
import utils.Urls;

public class Factory_WaitToDisappear extends Factory__Index {
    public Factory_WaitToDisappear() {
        super(Urls.get("waitToDisappear"));
    }

    // LOCATORS
    @FindBy(css = "button#btn")
    private WebElement buttonToWaitFor;

    @FindBy(css = "button#btn > b")
    private WebElement buttonText;
    public String expectedButtonText = "I'm going to disapper.Keep looking at me !!";  // disappear typo in HTML

    // GETTERS

    public WebElement getButtonToWaitFor() { return buttonToWaitFor; }
}
