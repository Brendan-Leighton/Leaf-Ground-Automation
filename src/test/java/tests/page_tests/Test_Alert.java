package tests.page_tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import tests.page_object_models.Factory_Alert;
import tests.page_object_models.Factory_Table;
import tests.page_object_models._Init_Factories;

public class Test_Alert extends _Base_Test {

    // PROPS

    private final Factory_Alert ALERT = _Init_Factories.getFactories().getAlert();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_alert();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        ALERT.navigateTo(HomePageLink);
    }
}
