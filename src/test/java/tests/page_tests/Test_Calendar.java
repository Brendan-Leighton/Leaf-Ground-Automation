package tests.page_tests;
// SELENIUM
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// TEST-NG
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
// PAGE MODELS
import org.testng.annotations.Test;
import tests.page_object_models.Factory_Calendar;
import tests.page_object_models._Init_Factories;
import utils.Drivers;
import utils.Interacts;

import java.util.List;

public class Test_Calendar extends _Base_Test {

    // PROPS

    private final Factory_Calendar CALENDAR = _Init_Factories.getFactories().getCalendar();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_calendar();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() { CALENDAR.navigateTo(HomePageLink); }

    /**
     * Test 1 - Select 10th day of next month
     */
    @Test
    public void VerifySelectDate() {
        // SETUP
        WebDriver driver = Drivers.getDriver();
        WebElement calendarInput = CALENDAR.getCalendarInput();
        WebElement calendarNextPageButton = CALENDAR.getCalendarButtonNextPage();
        WebElement calendarTable = CALENDAR.getCalendarTable();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String dayOfMonth = "10";

        // INTERACT
        // open calendar
        wait.until(ExpectedConditions.elementToBeClickable(calendarInput));
        Interacts.click(calendarInput);
        // go to next page
        wait.until(ExpectedConditions.elementToBeClickable(calendarNextPageButton));
        Interacts.click(calendarNextPageButton);
        // search for dayOfMonth
        List<WebElement> days = calendarTable.findElements(By.cssSelector("a"));
        for (WebElement day : days) {
            // click on dayOfMonth
            if (day.getText().contains(dayOfMonth)) Interacts.click(day);
        }

        // ASSERT
        String inputText = calendarInput.getAttribute("value").trim();
        String day = inputText.substring(3, 5);
        Assert.assertEquals(day, dayOfMonth);
    }
}
