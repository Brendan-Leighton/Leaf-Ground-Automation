package tests.page_tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.page_object_models.Factory_Button;
import tests.page_object_models._Init_Factories;
import utils.Asserts;
import utils.Drivers;
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
}
