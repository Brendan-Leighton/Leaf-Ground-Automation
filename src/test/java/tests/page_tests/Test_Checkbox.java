package tests.page_tests;
// SELENIUM
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
// TEST-NG
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
// PAGE OBJECTS
import org.testng.annotations.Test;
import tests.page_object_models.Factory_Checkbox;
import tests.page_object_models._Init_Factories;

import java.util.List;

public class Test_Checkbox extends _Base_Test {

    // PROPS

    private final Factory_Checkbox CHECKBOX = _Init_Factories.getFactories().getCheckbox();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_checkbox();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        CHECKBOX.navigateTo(HomePageLink);
    }

    /**
     * Select languages you know
     */
    @Test
    public void VerifySelectingMultiple() {
        // SETUP
        List<WebElement> checkboxes = CHECKBOX.getCheckboxeQuestions().get(0).findElements(By.tagName("input"));
        WebElement checkbox_Java = checkboxes.get(0);
        WebElement checkbox_VB = checkboxes.get(1);
        WebElement checkbox_SQL = checkboxes.get(2);
        WebElement checkbox_C = checkboxes.get(3);
        WebElement checkbox_CPP = checkboxes.get(4);

        // INTERACT
        for(int num : CHECKBOX.getQuestion_1_answers()) {
            checkboxes.get(num).click();
        }

        // ASSERT
        Assert.assertEquals(checkbox_Java.getAttribute("checked"), "true");
        Assert.assertNull(checkbox_VB.getAttribute("checked"));
        Assert.assertEquals(checkbox_SQL.getAttribute("checked"), "true");
        Assert.assertNull(checkbox_C.getAttribute("checked"));
        Assert.assertNull(checkbox_CPP.getAttribute("checked"));
    }
}
