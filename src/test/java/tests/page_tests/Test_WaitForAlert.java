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
import tests.page_object_models.Factory_WaitForAlert;
import tests.page_object_models._Init_Factories;
// CUSTOM UTILS
import utils.Drivers;
import utils.Interacts;

public class Test_WaitForAlert extends _Base_Test {

    // PROPS

    private final Factory_WaitForAlert ALERT = _Init_Factories.getFactories().getWaitForAlert();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_waitForAlert();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        ALERT.navigateTo(HomePageLink);
    }

    /**
     * Test 1 - wait for and close alert
     */
    @Test
    public void VerifyAlertShowsAndCloses() {
        // SETUP
        WebDriver driver = Drivers.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement button = ALERT.getButton();
        String expectedAlertText = "Hurray, Click OK";

        // INTERACT
        wait.until(ExpectedConditions.elementToBeClickable(button));
        Interacts.click(button);
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText().trim();
        driver.switchTo().alert().accept();

        // ASSERT
        Assert.assertEquals(alertText, expectedAlertText);

    }
}
