package tests.page_object_models;

// CUSTOM UTILS
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Urls;

public class Factory_Window extends Factory__Index {

    // CONSTRUCTOR
    public Factory_Window() {
        super(Urls.get("window"));
    }

    // LOCATORS
    @FindBy (css = "button#home")
    private WebElement windowOne_openHomePageNewWindow;

    @FindBy (css = "button[onclick=\"openWindows()\"]")
    private WebElement windowTwo_openMultipleWindows;

    @FindBy (css = "button#color[onclick=\"openWindows();\"]")
    private WebElement windowThree_closeMultipleWindowsExceptBeginningWindow;

    @FindBy (css = "button#color[onclick=\"openWindowsWithWait();\"]")
    private WebElement windowFour_waitForTwoWindows;

    // GETTERS

    public WebElement getWindowOne_openHomePageNewWindow() {
        return windowOne_openHomePageNewWindow;
    }

    public WebElement getWindowTwo_openMultipleWindows() {
        return windowTwo_openMultipleWindows;
    }

    public WebElement getWindowThree_closeMultipleWindowsExceptBeginningWindow() {
        return windowThree_closeMultipleWindowsExceptBeginningWindow;
    }

    public WebElement getWindowFour_waitForTwoWindows() {
        return windowFour_waitForTwoWindows;
    }
}
