package tests.page_object_models;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Urls;

public class Factory_Image extends Factory__Index {

    // CONSTRUCTOR - only one
    public Factory_Image() {
        super(Urls.get("image"));
    }

    // LOCATORS

    @FindBy(css = "section.innerblock > div.example:nth-child(1) img")
    private WebElement imageGoHome;

    @FindBy(css = "section.innerblock > div.example:nth-child(4) img")
    private WebElement imageIsBroken;

    @FindBy(css = "section.innerblock > div.example:nth-child(7) img")
    private WebElement imageClickWithKeyboardOrMouse;

    // GETTERS


    public WebElement getImageGoHome() {
        return imageGoHome;
    }

    public WebElement getImageIsBroken() {
        return imageIsBroken;
    }

    public WebElement getImageClickWithKeyboardOrMouse() {
        return imageClickWithKeyboardOrMouse;
    }
}
