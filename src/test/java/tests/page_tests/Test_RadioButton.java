package tests.page_tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import tests.page_object_models.Factory_Dropdown;
import tests.page_object_models.Factory_RadioButton;
import tests.page_object_models._Init_Factories;

public class Test_RadioButton extends _Base_Test {

    // PROPS

    private final Factory_RadioButton RADIO = _Init_Factories.getFactories().getRadioButton();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_radioButton();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        RADIO.navigateTo(HomePageLink);
    }
}
