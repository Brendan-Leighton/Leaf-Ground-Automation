package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebElement;
// TEST-NG
import org.testng.annotations.BeforeMethod;
// PAGE MODELS
import tests.page_object_models.Factory_Table;
import tests.page_object_models._Init_Factories;

public class Test_Table extends _Base_Test {

    // PROPS

    private final Factory_Table TABLE = _Init_Factories.getFactories().getTable();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_table();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        TABLE.navigateTo(HomePageLink);
    }
}
