package tests.page_object_models;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Urls;

public class Factory_Upload extends Factory__Index {
    public Factory_Upload() {
        super(Urls.get("uploadFiles"));
    }

    // LOCATORS
    @FindBy (css = "input[type=\"file\"]")
    private WebElement inputFile;

    // GETTERS

    public WebElement getInputFile() { return inputFile; }
}
