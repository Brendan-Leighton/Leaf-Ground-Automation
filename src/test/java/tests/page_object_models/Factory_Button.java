package tests.page_object_models;

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

    @FindBy(css = "section:nth-child(1) > div:nth-child(1) >div>div> a")
    private WebElement linkHome;

    // GETTERS
}
