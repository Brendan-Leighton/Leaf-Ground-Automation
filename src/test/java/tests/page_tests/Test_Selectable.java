package tests.page_tests;
// SELENIUM
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//TEST-NG
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
// PAGE OBJECTS
import org.testng.annotations.Test;
import tests.page_object_models.Factory_Selectable;
import tests.page_object_models._Init_Factories;
import utils.Drivers;
import utils.Interacts;

import java.util.List;


public class Test_Selectable extends _Base_Test {

    // PROPS

    private final Factory_Selectable SELECTABLE = _Init_Factories.getFactories().getSelectable();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_selectable();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() { SELECTABLE.navigateTo(HomePageLink); }

    /**
     *  Test 1 - select multiple
     */
    @Test
    public void VerifySelectingMultiple() {
        // SETUP
        WebDriver driver = Drivers.getDriver();
        List<WebElement> listEls = SELECTABLE.getSelectableList();
        Actions action = new Actions(driver);

        // INTERACT
        action.keyDown(Keys.CONTROL).perform();
        for (int i = 0; i < listEls.size(); i++) {
            if (i % 2 == 0) Interacts.click(listEls.get(i));
        }
        action.keyUp(Keys.CONTROL).perform();

        // VERIFY
        Assert.assertTrue(listEls.get(0).getAttribute("class").contains("ui-selected"));
        Assert.assertFalse(listEls.get(1).getAttribute("class").contains("ui-selected"));
        Assert.assertTrue(listEls.get(2).getAttribute("class").contains("ui-selected"));
        Assert.assertFalse(listEls.get(3).getAttribute("class").contains("ui-selected"));
        Assert.assertTrue(listEls.get(4).getAttribute("class").contains("ui-selected"));
        Assert.assertFalse(listEls.get(5).getAttribute("class").contains("ui-selected"));
        Assert.assertTrue(listEls.get(6).getAttribute("class").contains("ui-selected"));
    }
}
