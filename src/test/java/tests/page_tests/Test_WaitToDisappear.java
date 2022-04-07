package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// TEST-NG
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
// PAGE MODELS
import tests.page_object_models.Factory_WaitToDisappear;
import tests.page_object_models._Init_Factories;
// CUSTOM UTILS
import utils.Drivers;

public class Test_WaitToDisappear extends _Base_Test {

    // PROPS

    private final Factory_WaitToDisappear WAIT = _Init_Factories.getFactories().getWaitToDisappear();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_waitToDisappear();

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
        WebElement buttonToDisappear = WAIT.getButtonToWaitFor();

        // INTERACT
        wait.until(ExpectedConditions.invisibilityOf(buttonToDisappear));

        // ASSERT
        Assert.assertFalse(buttonToDisappear.isDisplayed());
    }
}
