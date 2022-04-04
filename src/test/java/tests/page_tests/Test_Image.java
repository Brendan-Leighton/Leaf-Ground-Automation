package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebElement;
// TEST-NG
import org.testng.annotations.BeforeMethod;
// PAGE OBJECTS
import tests.page_object_models.Factory_Image;
import tests.page_object_models._Init_Factories;

public class Test_Image extends _Base_Test {

    // PROPS

    private final Factory_Image IMAGE = _Init_Factories.getFactories().getImage();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_image();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        IMAGE.navigateTo(HomePageLink);
    }
}
