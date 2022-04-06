package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebElement;
// TEST-NG
import org.testng.annotations.BeforeMethod;
// PAGE MODELS
import tests.page_object_models.Factory_Frames;
import tests.page_object_models._Init_Factories;

public class Test_Frames extends _Base_Test {

    // PROPS

    private final Factory_Frames FRAMES = _Init_Factories.getFactories().getFrames();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_alert();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        FRAMES.navigateTo(HomePageLink);
    }
}
