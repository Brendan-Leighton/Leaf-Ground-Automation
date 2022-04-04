package tests.page_object_models;
// SELENIUM
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
// CUSTOM UTILS
import utils.Urls;

public class Factory_Button extends Factory__Index {

    // CONSTRUCTOR - only one
    public Factory_Button() {
        // SUPER DUPER
        super(Urls.get("button"));
    }

    // LOCATORS

    @FindBy(css = "button#home")
    private WebElement buttonHome;

    @FindBy(css = "button#position")
    private WebElement buttonFindPosition;
    public Point expectedLocation = new Point(240, 304);

    @FindBy(css = "button#color")
    private WebElement buttonFindColor;
    public String button3Color = "lightgreen";

    @FindBy(css = "button#size")
    private WebElement buttonFindSize;
    public Dimension button4ExpectedSize = new Dimension(123, 20);

    // GETTERS

    public WebElement getButtonHome() {
        return buttonHome;
    }

    public WebElement getButtonFindPosition() {
        return buttonFindPosition;
    }

    public WebElement getButtonFindColor() {
        return buttonFindColor;
    }

    public WebElement getButtonFindSize() {
        return buttonFindSize;
    }
}
