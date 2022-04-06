package tests.page_tests;
// SELENIUM
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// TEST-NG
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
// PAGE MODELS
import org.testng.annotations.Test;
import tests.page_object_models.Factory_Frames;
import tests.page_object_models._Init_Factories;
import utils.Drivers;
import utils.Interacts;

import java.util.List;

public class Test_Frames extends _Base_Test {

    // PROPS

    private final Factory_Frames FRAMES = _Init_Factories.getFactories().getFrames();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_frame();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() { FRAMES.navigateTo(HomePageLink); }

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
}
