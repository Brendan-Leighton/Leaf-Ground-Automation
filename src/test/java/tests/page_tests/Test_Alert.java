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
}
