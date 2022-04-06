package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// TEST-NG
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
// PAGE MODELS
import org.testng.annotations.Test;
import tests.page_object_models._Init_Factories;
import tests.page_object_models.Factory_Window;
import utils.Drivers;
import utils.Interacts;

import java.util.Set;

public class Test_Window extends _Base_Test {

    // PROPS

    private final Factory_Window WINDOW = _Init_Factories.getFactories().getWindow();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_window();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() { WINDOW.navigateTo(HomePageLink); }

    /**
     * Test 1 - click button, new window opens
     */
    @Test
    public void VerifyHomePageOpensInNewWindow() {
        // SETUP
        WebDriver driver = Drivers.getDriver();
        WebElement button = WINDOW.getWindowOne_openHomePageNewWindow();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String startingWindow = driver.getWindowHandle();
        Set<String> windows;

        // INTERACT
        // click button
        wait.until(ExpectedConditions.elementToBeClickable(button));
        Interacts.click(button);
        // get handles
        windows = driver.getWindowHandles();
        // close all except startingWindow
        for (String window : windows) {
            if (!window.equals(startingWindow))
                driver.switchTo().window(window).close();
        }

        // ASSERT
        windows = driver.getWindowHandles();
        Assert.assertEquals(windows.size(), 1);
        Assert.assertTrue(windows.contains(startingWindow));
    }

    /**
     * test 2 - count number of open windows
     */
    @Test
    public void VerifyOpenedWindowCount() {
        // SETUP
        WebDriver driver = Drivers.getDriver();
        WebElement button = WINDOW.getWindowTwo_openMultipleWindows();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Set<String> windows;

        // INTERACT
        // click button
        wait.until(ExpectedConditions.elementToBeClickable(button));
        Interacts.click(button);
        // get handles
        windows = driver.getWindowHandles();

        // ASSERT
        Assert.assertEquals(windows.size(), 3);
    }
}
