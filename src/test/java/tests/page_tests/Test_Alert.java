package tests.page_tests;
// SELENIUM
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// TEST-NG
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
// PAGE MODELS
import org.testng.annotations.Test;
import tests.page_object_models.Factory_Alert;
import tests.page_object_models._Init_Factories;
import utils.Drivers;
import utils.Interacts;

public class Test_Alert extends _Base_Test {

    // PROPS

    private final Factory_Alert ALERT = _Init_Factories.getFactories().getAlert();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_alert();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        ALERT.navigateTo(HomePageLink);
    }

    /**
     * Test 1 - Enter and exit an alert
     */
    @Test
    public void VerifyOpenCloseAlert() {
        // SETUP
        WebElement buttonOpenAlert = ALERT.getAlertButtonOne();
        WebDriverWait wait = new WebDriverWait(Drivers.getDriver(), 5);
        WebDriver driver = Drivers.getDriver();

        // INTERACT
        // click button
        wait.until(ExpectedConditions.elementToBeClickable(buttonOpenAlert));
        Interacts.click(buttonOpenAlert);
        // handle alert
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        // assert text we got from alert
        Assert.assertEquals(alertText, "I am an alert box!");
    }

    /**
     * Test 2 - Enter, press OK button, and exit an alert
     */
    @Test
    public void VerifyOpenAlertPressButton() {
        // SETUP
        WebElement buttonOpenAlert = ALERT.getAlertButtonTwo();
        WebDriverWait wait = new WebDriverWait(Drivers.getDriver(), 5);
        WebDriver driver = Drivers.getDriver();

        // INTERACT
        // click button
        wait.until(ExpectedConditions.elementToBeClickable(buttonOpenAlert));
        Interacts.click(buttonOpenAlert);
        // handle alert
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        // assert text we got from alert
        Assert.assertEquals(alertText, "Press a button!");
    }

    /**
     * Test 3 - Enter, type into input, and exit an alert
     */
    @Test
    public void VerifyOpenTypeCloseAlert() {
        // SETUP
        WebElement buttonOpenAlert = ALERT.getAlertButtonThree();
        WebDriverWait wait = new WebDriverWait(Drivers.getDriver(), 5);
        WebDriver driver = Drivers.getDriver();
        String expectedTextInAlert = "Please enter your training institute name";
        String expectedTextAfterSubmit = "You should not have enjoyed learning at GenSpark as compared to TestLeaf! Right?";

        // INTERACT
        // click button
        wait.until(ExpectedConditions.elementToBeClickable(buttonOpenAlert));
        Interacts.click(buttonOpenAlert);
        // handle alert
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText().trim();
        driver.switchTo().alert().sendKeys("GenSpark");
        driver.switchTo().alert().accept();
        String alertInputText = driver.findElement(By.cssSelector("p#result1")).getText().trim();

        // assert text we got from alert
        Assert.assertEquals(alertText, expectedTextInAlert);
        Assert.assertEquals(alertInputText, expectedTextAfterSubmit);
    }

    /**
     * Test 4  - Enter, get text that has line-breaks, and exit an alert
     */
    @Test
    public void VerifyOpenGetTextWithLineBreaksAndExitAlert() {
        // SETUP
        WebElement buttonOpenAlert = ALERT.getAlertButtonThree();
        WebDriverWait wait = new WebDriverWait(Drivers.getDriver(), 5);
        WebDriver driver = Drivers.getDriver();
        String expectedTextInAlert = "Hello\n How are you doing today?";

        // INTERACT
        // click button
        wait.until(ExpectedConditions.elementToBeClickable(buttonOpenAlert));
        Interacts.click(buttonOpenAlert);
        // handle alert
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText().trim();
        driver.switchTo().alert().accept();

        // assert text we got from alert
        Assert.assertEquals(alertText, expectedTextInAlert);
    }
}
