package tests.page_object_models;
// JAVA
import java.util.List;
// SELENIUM
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
// CUSTOM UTILS
import utils.Urls;



public class Factory_Frames extends Factory__Index {
    public Factory_Frames() {
        super(Urls.get("frame"));

        frameOne_clickButton = iframes.get(0);
        frameTwo_clickButtonInsideNestedFrame = iframes.get(0);
        frameThree_countFrames = iframes.get(0);
    }

    // LOCATORS
    @FindBy (css = "section.innerblock > div#wrapframe > iframe")
    private List<WebElement> iframes;

    private WebElement frameOne_clickButton;
    private WebElement frameTwo_clickButtonInsideNestedFrame;
    private WebElement frameThree_countFrames;

    // GETTERS

    public List<WebElement> getIframes() {
        return iframes;
    }

    public WebElement getFrameOne_clickButton() {
        return frameOne_clickButton;
    }

    public WebElement getFrameTwo_clickButtonInsideNestedFrame() {
        return frameTwo_clickButtonInsideNestedFrame;
    }

    public WebElement getFrameThree_countFrames() {
        return frameThree_countFrames;
    }
}
