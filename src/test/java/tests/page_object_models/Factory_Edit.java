package tests.page_object_models;

// CUSTOM
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Urls;

/**
 * Page Object Model representing the "edit" page of the LeafGround.com site.
 */
public class Factory_Edit extends Factory__Index {

    // CONSTRUCTOR - only one
    public Factory_Edit(WebDriver driver) {
        // SUPER
        super(Urls.get("edit"));
        // POM FACTORY
        PageFactory.initElements(driver, this);
    }

    // LOCATORS


    // GETTERS
}
