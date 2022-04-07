package tests.page_object_models;
// CUSTOM UTILS
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Urls;

import java.util.List;

public class Factory_Download extends Factory__Index {
    public Factory_Download() {
        super(Urls.get("downFiles"));
    }

    // LOCATORS
    @FindBy (css = "section.innerblock >div>div>div > a")
    private List<WebElement> links;

    // GETTERS
    public List<WebElement> getLinks() { return links; }
}
