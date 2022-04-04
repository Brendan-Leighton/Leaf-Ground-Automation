package tests.page_tests;
// SELENIUM
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
// TEST-NG
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
// PAGE OBJECTS
import tests.page_object_models.Factory_Button;
import tests.page_object_models._Init_Factories;
// CUSTOM UTILS
import utils.Asserts;
import utils.Urls;
import utils.Waits;

public class Test_Button extends _Base_Test {

    // PROPS

    private final Factory_Button BUTTON = _Init_Factories.getFactories().getButton();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_button();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        BUTTON.navigateTo(HomePageLink);
    }

    /**
     * BUTTON 1 - Navigates to home
     */
    @Test
    public void VerifyButtonNavigatesToHomePage() {
        // SETUP

        // INTERACT
        Waits.forElement_andClick(BUTTON.getButtonHome());

        // ASSERT
        Asserts.navigation_toUrl(Urls.get("home"));
    }

    /**
     * BUTTON 2 - Find button position
     */
    @Test
    public void VerifyButtonPosition() {
        // SETUP
        WebElement buttonToLocate = BUTTON.getButtonFindPosition();

        // INTERACT
        Point actualLocation = buttonToLocate.getLocation();

        // ASSERT
        Assert.assertEquals(actualLocation, BUTTON.expectedLocation);
    }
}
