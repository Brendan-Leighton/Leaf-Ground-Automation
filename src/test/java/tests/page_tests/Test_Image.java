package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebElement;
// TEST-NG
import org.testng.annotations.BeforeMethod;
// PAGE OBJECTS
import org.testng.annotations.Test;
import tests.Helpers;
import tests.page_object_models.Factory_Image;
import tests.page_object_models._Init_Factories;
import utils.Asserts;
import utils.Urls;

public class Test_Image extends _Base_Test {

    // PROPS

    private final Factory_Image IMAGE = _Init_Factories.getFactories().getImage();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_image();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        IMAGE.navigateTo(HomePageLink);
    }

    /**
     * Image 1 - links to home page
     */
    @Test
    public void VerifyImageNavigatesToHomePage() {
        // SETUP
        WebElement image = IMAGE.getImageGoHome();

        // INTERACT
        // VERIFY
        Asserts.navigation_fromElement_toUrl(image, Urls.get("home"));
    }

    /**
     * Image 2 - is image broken, does it connect?
     */
    @Test
    public void VerifyImageIsBroken_doesntMakeConnection() {
        // SETUP
        // INTERACT
        // ASSERT
        Helpers.Link_IsUnableToMakeConnection(IMAGE.getImageIsBroken());
    }
}
