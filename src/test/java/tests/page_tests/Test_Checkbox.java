package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebElement;
// TEST-NG
import org.testng.annotations.BeforeMethod;
// PAGE OBJECTS
import tests.page_object_models.Factory_Checkbox;
import tests.page_object_models._Init_Factories;

public class Test_Checkbox extends _Base_Test {

    // PROPS

    private final Factory_Checkbox CHECKBOX = _Init_Factories.getFactories().getCheckbox();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_checkbox();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        CHECKBOX.navigateTo(HomePageLink);
    }
}
