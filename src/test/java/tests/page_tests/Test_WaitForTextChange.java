package tests.page_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.page_object_models.Factory_WaitForTextChange;
import tests.page_object_models.Factory_WaitToAppear;
import tests.page_object_models._Init_Factories;
import utils.Drivers;

public class Test_WaitForTextChange extends _Base_Test {

    // PROPS

    private final Factory_WaitForTextChange WAIT = _Init_Factories.getFactories().getWaitForTextChange();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_waitForTextChange();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        WAIT.navigateTo(HomePageLink);
    }

    /**
     * Test 1 - wait for button text to change
     */
    @Test
    public void VerifyButtonTextChanges() {
        // SETUP
        WebDriver driver = Drivers.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement button = WAIT.getButton();
        String expectedButtonText = WAIT.expectedButtonText;

        // INTERACT
        wait.until(ExpectedConditions.textToBePresentInElement(button, expectedButtonText));

        // ASSERT
        Assert.assertTrue(button.getText().contains(expectedButtonText));
    }
}
