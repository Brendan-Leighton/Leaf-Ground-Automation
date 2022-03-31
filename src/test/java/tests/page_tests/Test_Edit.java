package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebElement;
// TEST-NG
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
// CUSTOM - utils
import utils.Asserts;
import utils.Drivers;
// CUSTOM - factories
import tests.page_object_models.Factory_Edit;
import tests.page_object_models._Init_Factories;

/**
 * Tests for the Edit page.
 */
public class Test_Edit extends _Base_Test {

    // PROPS

    private final Factory_Edit EDIT = _Init_Factories.getEdit();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_edit();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        Drivers.getDriver().navigate().to(EDIT.getUrlHome());  // go to Home page
        Asserts.navigation_toUrl(EDIT.getUrlHome());           // Assert correct URL loaded
        Asserts.navigation_fromElement_toUrl(HomePageLink, EDIT.getUrl());  // click on, wait for, and assert proper navigation to this.pageUrl
    }

    @Test
    public void NavbarLogoNavigatesToHomePage() {
        EDIT.TestLogoToHomeButton(HomePageLink);
    }
}
