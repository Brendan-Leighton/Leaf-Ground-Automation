package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// TEST-NG
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
// PAGE MODELS
import org.testng.annotations.Test;
import tests.page_object_models.Factory_Tooltip;
import tests.page_object_models._Init_Factories;
import utils.Drivers;

public class Test_Tooltip extends _Base_Test {

    // PROPS

    private final Factory_Tooltip TOOLTIP = _Init_Factories.getFactories().getTooltip();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_tooltip();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        TOOLTIP.navigateTo(HomePageLink);
    }

    /**
     * Test 1 - does tooltip display?
     */
    @Test
    public void VerifyTooltipDisplays() {
        // SETUP
        WebDriver driver = Drivers.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Actions action = new Actions(driver);
        WebElement inputField = TOOLTIP.getTooltipInputField();
        WebElement tooltip = TOOLTIP.getTooltipPopupDiv();

        // INTERACT
        wait.until(ExpectedConditions.elementToBeClickable(inputField));
        action.moveToElement(inputField).perform();
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            System.out.println("*****\nsome shit is going down\n*****\n\nThread.sleep in Test_Tooltip");
            e.printStackTrace();
            System.out.println("*****\nsome shit went down\n*****");
        }

        // ASSERT
        String tooltipText = tooltip.getText().trim();
        Assert.assertEquals(tooltipText, "Enter your Name");
    }
}
