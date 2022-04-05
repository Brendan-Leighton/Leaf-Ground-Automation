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
        Assert.assertTrue(checkbox_Java.isSelected()); // True
        Assert.assertFalse(checkbox_VB.isSelected());  // F
        Assert.assertTrue(checkbox_SQL.isSelected());  // True
        Assert.assertFalse(checkbox_C.isSelected());   // F
        Assert.assertFalse(checkbox_CPP.isSelected()); // F
    }

    /**
     * Make sure the checkbox is checked
     */
    @Test
    public void VerifyCheckboxIsChecked() {
        // SETUP
        List<WebElement> checkboxes = CHECKBOX.getCheckboxeQuestions().get(1).findElements(By.tagName("input"));
        WebElement checkbox = checkboxes.get(0);

        // INTERACT
        // ASSERT
        Assert.assertTrue(checkbox.isSelected());
    }

    /**
     * Only deselect the checked boxes
     */
    @Test
    public void VerifyAbleToDeleteCheckboxes() {
        // SETUP
        List<WebElement> checkboxes = CHECKBOX.getCheckboxeQuestions().get(2).findElements(By.tagName("input"));

        // INTERACT
        for(WebElement el : checkboxes) {
            try {
                if (el.getAttribute("checked").equals("true")) el.click();
            } catch (NullPointerException ignore) {}
        }

        // ASSERT
        Assert.assertFalse(checkboxes.get(0).isSelected());
        Assert.assertFalse(checkboxes.get(1).isSelected());
    }

    /**
     * Select languages you know
     */
    @Test
    public void VerifySelectAll() {
        // SETUP
        List<WebElement> checkboxes = CHECKBOX.getCheckboxeQuestions().get(3).findElements(By.tagName("input"));
        WebElement checkbox_1 = checkboxes.get(0);
        WebElement checkbox_2 = checkboxes.get(1);
        WebElement checkbox_3 = checkboxes.get(2);
        WebElement checkbox_4 = checkboxes.get(3);
        WebElement checkbox_5 = checkboxes.get(4);
        WebElement checkbox_6 = checkboxes.get(5);

        // INTERACT
        for(WebElement el : checkboxes) {
            if (!el.isSelected()) el.click();
        }

        // ASSERT
        Assert.assertTrue(checkbox_1.isSelected());
        Assert.assertTrue(checkbox_2.isSelected());
        Assert.assertTrue(checkbox_3.isSelected());
        Assert.assertTrue(checkbox_4.isSelected());
        Assert.assertTrue(checkbox_5.isSelected());
        Assert.assertTrue(checkbox_6.isSelected());
    }
}