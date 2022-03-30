package tests.page_object_models;
// PARENT CLASS
import org.testng.annotations.Test;
// SELENIUM
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Props;

public class Factory_Home extends Factory__Index {

    public Factory_Home(WebDriver driver) {
        // SUPER
        super(Props.getProp("home"));
        // POM FACTORY
        PageFactory.initElements(driver, this);
    }
}
