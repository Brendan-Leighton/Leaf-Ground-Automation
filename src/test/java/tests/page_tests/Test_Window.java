package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// TEST-NG
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
    private String startingWindow;

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        startingWindow = Drivers.getDriver().getWindowHandle();
        WINDOW.navigateTo(HomePageLink);
    }

    @AfterMethod
    public void SwitchToStartingWindow() {
        CloseExtraWindows();
        Drivers.getDriver().switchTo().window(startingWindow);
    }

    /**
     * Closes all the windows the ddriver has opened except the starting window set in the @BeforeMethod
     */
    private void CloseExtraWindows() {
        // get handles
        Set<String> windows = Drivers.getDriver().getWindowHandles();
        // close all except startingWindow
        for (String window : windows) {
            if (!window.equals(startingWindow))
                Drivers.getDriver().switchTo().window(window).close();
        }
    }


    /**
     * Test 1 - click button, new window opens
     */
    @Test ()
    public void VerifyHomePageOpensInNewWindow() {
        // SETUP
        WebDriver driver = Drivers.getDriver();
        WebElement button = WINDOW.getWindowOne_openHomePageNewWindow();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String startingWindow = driver.getWindowHandle();
        String newWindow = null;
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
                newWindow = window;
        }

        // ASSERT
        windows = driver.getWindowHandles();
        Assert.assertEquals(windows.size(), 2);
        Assert.assertTrue(windows.contains(startingWindow));
        Assert.assertTrue(windows.contains(newWindow));
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

    /**
     * Test 3 - close all windows except the startingWindow
     */
    @Test
    public void VerifyCanClassAllButStartingWindow() {
        // SETUP
        WebDriver driver = Drivers.getDriver();
        WebElement button = WINDOW.getWindowThree_closeMultipleWindowsExceptBeginningWindow();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String startingWindow = driver.getWindowHandle();
        Set<String> windows;

        // INTERACT
        // click button
        wait.until(ExpectedConditions.elementToBeClickable(button));
        Interacts.click(button);
        CloseExtraWindows();

        // ASSERT
        windows = driver.getWindowHandles();
        Assert.assertEquals(windows.size(), 1);
        Assert.assertTrue(windows.contains(startingWindow));
    }

    /**
     * Test 4 - wait for window
     */
    @Test
    public void VerifyCanWaitForWindows() {
        // SETUP
        WebDriver driver = Drivers.getDriver();
        WebElement button = WINDOW.getWindowFour_waitForTwoWindows();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String startingWindow = driver.getWindowHandle();
        Set<String> windows;

        // INTERACT
        // click button
        wait.until(ExpectedConditions.elementToBeClickable(button));
        Interacts.click(button);

        try {
            Thread.sleep(5500);
        } catch (InterruptedException ignore) {}

        // ASSERT
        windows = driver.getWindowHandles();
        Assert.assertEquals(windows.size(), 3);
    }
}
