package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebElement;
// TEST-NG
import org.testng.annotations.BeforeMethod;
// PAGE MODELS
import tests.page_object_models.Factory_Calendar;
import tests.page_object_models._Init_Factories;

public class Test_Calendar extends _Base_Test {

    // PROPS

    private final Factory_Calendar CALENDAR = _Init_Factories.getFactories().getCalendar();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_calendar();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() { CALENDAR.navigateTo(HomePageLink); }
}
