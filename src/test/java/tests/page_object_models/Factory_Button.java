package tests.page_object_models;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    @FindBy(css = "button#size")
    private WebElement buttonFindSize;

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
