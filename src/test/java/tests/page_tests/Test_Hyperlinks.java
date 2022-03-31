package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
// POM's
import org.testng.annotations.Test;
import tests.page_object_models.Factory_Hyperlinks;
import tests.page_object_models._Init_Factories;
// UTILS
import utils.Asserts;
import utils.Drivers;
import utils.Waits;

public class Test_Hyperlinks extends _Base_Test {

    // PROPS

    private final Factory_Hyperlinks HYPERLINKS = _Init_Factories.getFactories().getHyperlinks();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_hyperlink();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        Drivers.getDriver().navigate().to(HYPERLINKS.getUrlHome());  // go to Home page
        Asserts.navigation_toUrl(HYPERLINKS.getUrlHome());           // Assert correct URL loaded
        Asserts.navigation_fromElement_toUrl(HomePageLink, HYPERLINKS.getUrl());  // click on, wait for, and assert proper navigation to this.pageUrl
    }

    @Test
    public void NavbarLogoNavigatesToHomePage() {
        HYPERLINKS.TestLogoToHomeButton(HomePageLink);
    }

    @Test
    public void LinkNavigatesToHomePage() {
        // SETUP
        WebElement link = HYPERLINKS.getLinkHome();

        // INTERACT
        Waits.forElement_andClick(link);

        // VERIFY
        Asserts.navigation_toUrl(HYPERLINKS.getUrlHome());
    }

}
