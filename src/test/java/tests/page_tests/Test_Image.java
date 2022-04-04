package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
// TEST-NG
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
// PAGE OBJECTS
import tests.page_object_models.Factory_Image;
import tests.page_object_models._Init_Factories;
// CUSTOM UTILS
import tests.Helpers;
import utils.Asserts;
import utils.Drivers;
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

    /**
     * Image 3 - is mouse clickable? Links to Home page.
     */
    @Test
    public void VerifyImageIsClickableViaMouse() {
        // SETUP
        WebElement image = IMAGE.getImageClickWithKeyboardOrMouse();

        // INTERACT
        Actions mouseClick = new Actions(Drivers.getDriver());
        mouseClick.click(image).perform();

        // ASSERT
        Asserts.navigation_toUrl(IMAGE.getUrlHome());
    }
}
