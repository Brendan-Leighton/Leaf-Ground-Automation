package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebElement;
// TEST-NG
import org.testng.annotations.BeforeMethod;
// PAGE MODELS
import tests.page_object_models.Factory_Tooltip;
import tests.page_object_models._Init_Factories;

public class Test_Tooltip extends _Base_Test {

    // PROPS

    private final Factory_Tooltip TOOLTIP = _Init_Factories.getFactories().getTooltip();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_tooltip();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        TOOLTIP.navigateTo(HomePageLink);
    }
}
