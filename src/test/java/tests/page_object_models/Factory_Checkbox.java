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

    // LOCATOR
    @FindBy (css = "section.innerblock:nth-child(1) div")
    private List<WebElement> CheckboxeQuestions;

    // ANSWERS DATA
    private int[] question_1_answers = {0, 2};

    // GETTERS

    public List<WebElement> getCheckboxeQuestions() {
        return CheckboxeQuestions;
    }

    public int[] getQuestion_1_answers() {
        return question_1_answers;
    }
}
