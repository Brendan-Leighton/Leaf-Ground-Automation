package tests.page_object_models;
// JAVA
import java.util.List;
// SELENIUM
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
// CUSTOM UTILS
import utils.Drivers;
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

    private final WebElement frameOne_clickButton;
    private final WebElement frameTwo_clickButtonInsideNestedFrame;
    private final WebElement frameThree_countFrames;

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

    /**
     * Recursively search for iframes
     */
    public int searchForIFrames() {
        WebDriver driver = Drivers.getDriver();

        // get all iframes
        List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));

        // initialize count with iframes who are a direct descendant of the current element
        int iFrameCount = iframes.size();

        // determine if recursion is necessary
        if (iframes.size() > 0) {
            for (WebElement frame : iframes) {
                driver.switchTo().frame(frame);
                iFrameCount += searchForIFrames();
                driver.switchTo().parentFrame();
            }
        }

        // return count of all iframes who're descendants of this element
        return iFrameCount;
    }
}
