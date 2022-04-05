package tests.page_object_models;
// SELENIUM
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
// CUSTOM UTILS
import utils.Urls;

import java.util.List;

public class Factory_Checkbox extends Factory__Index {
    public Factory_Checkbox() {
        super(Urls.get("checkbox"));
    }

    // LOCATORS

    @FindBy (css = "section.innerblock:nth-child(1) div")
    private List<WebElement> CheckboxeQuestions;

    // GETTERS

    public List<WebElement> getCheckboxeQuestions() {
        return CheckboxeQuestions;
    }
}
