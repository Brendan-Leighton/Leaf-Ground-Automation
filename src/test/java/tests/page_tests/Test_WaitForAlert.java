package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebElement;
// TEST-NG
import org.testng.annotations.BeforeMethod;
// PAGE MODELS
import tests.page_object_models.Factory_WaitForAlert;
import tests.page_object_models._Init_Factories;

public class Test_WaitForAlert extends _Base_Test {

    // PROPS

    private final Factory_WaitForAlert ALERT = _Init_Factories.getFactories().getWaitForAlert();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_waitForAlert();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        ALERT.navigateTo(HomePageLink);
    }
}
