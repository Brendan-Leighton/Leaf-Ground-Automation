package tests.page_object_models;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Urls;

public class Factory_Droppable extends Factory__Index {
    public Factory_Droppable() {
        super(Urls.get("droppable"));
    }

    // LOCATORS

    @FindBy (css = "div#draggable")
    private WebElement dragEl;

    @FindBy (css = "div#droppable")
    private WebElement dropArea;

    // GETTERS

    public WebElement getDragEl() {
        return dragEl;
    }

    public WebElement getDropArea() {
        return dropArea;
    }
}
