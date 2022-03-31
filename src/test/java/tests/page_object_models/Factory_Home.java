package tests.page_object_models;
// PARENT CLASS
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
// SELENIUM
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Urls;

public class Factory_Home extends Factory__Index {

    public Factory_Home(WebDriver driver) {
        // SUPER
        super(Urls.get("home"));
        // POM FACTORY
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "a[href='pages/Edit.html']")
    public WebElement pageLink_edit;

    public WebElement getPageLink_edit() {
        return pageLink_edit;
    }
}
