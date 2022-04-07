package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// TEST-NG
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
// PAGE MODELS
import tests.page_object_models.Factory_WaitToAppear;
import tests.page_object_models._Init_Factories;
// CUSTOM UTILS
import utils.Drivers;

public class Test_WaitToAppear extends _Base_Test {

    // PROPS

    private final Factory_WaitToAppear WAIT = _Init_Factories.getFactories().getWaitToAppear();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_waitToAppear();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        WAIT.navigateTo(HomePageLink);
    }

    /**
     * Test 1 - wait for button to appear
     */
    @Test
    private void VerifyButtonAppears() {
        // SETUP
        WebDriver driver = Drivers.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Actions action = new Actions(driver);
        WebElement buttonToAppear = WAIT.getButtonToWaitFor();

        // INTERACT
        wait.until(ExpectedConditions.visibilityOf(buttonToAppear));

        // ASSERT
        Assert.assertEquals(buttonToAppear.getText().trim(), "Voila! I'm here Guys");
    }
}
