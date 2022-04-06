package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebElement;
// TEST-NG
import org.testng.annotations.BeforeMethod;
// PAGE MODELS
import tests.page_object_models._Init_Factories;
import tests.page_object_models.Factory_Window;

public class Test_Window extends _Base_Test {

    // PROPS

    private final Factory_Window WINDOW = _Init_Factories.getFactories().getWindow();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_frame();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() { WINDOW.navigateTo(HomePageLink); }
}
