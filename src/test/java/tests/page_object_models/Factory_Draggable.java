package tests.page_object_models;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Urls;

public class Factory_Draggable extends Factory__Index {
    public Factory_Draggable() {
        super(Urls.get("draggable"));
    }

    // LOCATORS
    @FindBy (css = "div#mydiv")
    private WebElement containerDiv;

    @FindBy (css = "div#draggable")
    private WebElement draggableDiv;

    // GETTERS


    public WebElement getContainerDiv() {
        return containerDiv;
    }

    public WebElement getDraggableDiv() {
        return draggableDiv;
    }
}
