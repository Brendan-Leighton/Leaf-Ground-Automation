package tests.page_object_models;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Urls;

public class Factory_RadioButton extends Factory__Index {

    // CONSTRUCTOR - only 1
    public Factory_RadioButton() {
        super(Urls.get("radioButton"));
    }

    // LOCATORS
    @FindBy (css = "section.innerblock div:nth-child(1) >div>div input#yes")
    private WebElement radioSelectAnAnswer;

    @FindBy (css = "section.innerblock div:nth-child(4) >div>div")
    private WebElement radioFindSelected;

    @FindBy (css = "section.innerblock div:nth-child(7) >div>div")
    private WebElement radioPickOptionProgramatically;

    // GETTERS

    public WebElement getRadioSelectAnAnswer() { return radioSelectAnAnswer; }
    public WebElement getRadioFindSelected() { return radioFindSelected; }
    public WebElement getRadioPickOptionProgramatically() { return radioPickOptionProgramatically; }
}
