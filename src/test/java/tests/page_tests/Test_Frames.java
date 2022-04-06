package tests.page_tests;
// SELENIUM

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// TEST-NG
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
// PAGE MODELS
import tests.page_object_models.Factory_Frames;
import tests.page_object_models._Init_Factories;
// CUSTOM UTILS
import utils.Drivers;
import utils.Interacts;

public class Test_Frames extends _Base_Test {

    // PROPS

    private final Factory_Frames FRAMES = _Init_Factories.getFactories().getFrames();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_frame();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        FRAMES.navigateTo(HomePageLink);
    }

    /**
     * Test 1 - click a button inside an iframe
     */
    @Test
    public void VerifyButtonInsideIframeIsClickable() {
        // SETUP
        WebDriver driver = Drivers.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement iframe = FRAMES.getIframes().get(0);
        WebElement button;
        String expectedButtonText = "Hurray! You Clicked Me.";
        String actualButtonText = "";

        // INTERACT
        wait.until(ExpectedConditions.elementToBeClickable(iframe));
        driver.switchTo().frame(iframe);
        button = driver.findElement(By.cssSelector("button#Click"));
        Interacts.click(button);
        actualButtonText = button.getText().trim();

        // ASSERT
        Assert.assertEquals(actualButtonText, expectedButtonText);
    }

    /**
     * Test 2 - click a button inside a nested iframe
     */
    @Test
    public void VerifyButtonInsideNestedIframeIsClickable() {
        // SETUP
        WebDriver driver = Drivers.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement iframe = FRAMES.getIframes().get(1);
        WebElement button;
        String expectedButtonText = "Hurray! You Clicked Me.";
        String actualButtonText = "";

        // INTERACT
        // frame 1
        wait.until(ExpectedConditions.elementToBeClickable(iframe));
        driver.switchTo().frame(iframe);
        // frame 2
        WebElement iframe2 = driver.findElement(By.cssSelector("#frame2")); // find the nested iframe
        wait.until(ExpectedConditions.elementToBeClickable(iframe2));
        driver.switchTo().frame(iframe2);

        button = driver.findElement(By.cssSelector("button#Click1"));
        Interacts.click(button);
        actualButtonText = button.getText().

                trim();

        // ASSERT
        Assert.assertEquals(actualButtonText, expectedButtonText);
    }

    /**
     * Test 3 - count iframes
     */
    @Test
    public void VerifyProperNumberOfIframes() {
        // SETUP
        int iframeCount = 0;

        // INTERACT
        iframeCount = FRAMES.searchForIFrames();

        // ASSERT
        Assert.assertEquals(iframeCount, 5);
    }
}
