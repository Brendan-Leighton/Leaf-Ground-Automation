package tests.page_tests;

// SELENIUM : web driver
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
// TEST-NG
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
// CUSTOM
import tests.page_object_models._Init_Factories;
import utils.Asserts;
import utils.Drivers;
import utils.Waits;

public class _Base_Test {

    public Actions actions;

    @BeforeSuite
    public void setup() {
        // INITIALIZE WEB-DRIVER
        WebDriver driver = Drivers.getDriver();
        driver.manage().window().maximize();
        _Init_Factories poms = _Init_Factories.getFactories();
        Waits waits = Waits.getWaits();
        Asserts asserts = Asserts.getAsserts();

        // INITIALIZE UTILS - these require a WebDriver
        actions = new Actions(driver);
    }

    @AfterSuite
    public void teardown() { Drivers.quit(); }
}