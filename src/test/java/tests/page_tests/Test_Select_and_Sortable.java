package tests.page_tests;
// SELENIUM
import org.openqa.selenium.By;
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
import tests.page_object_models.Factory_Sortable;
import tests.page_object_models._Init_Factories;
import utils.Drivers;
import utils.Interacts;

import java.util.List;


public class Test_Select_and_Sortable extends _Base_Test {

    // PROPS
    // select
    private final Factory_Selectable SELECTABLE = _Init_Factories.getFactories().getSelectable();
    private final WebElement HomePageLink_select = _Init_Factories.getHome().getPageLink_selectable();
    // sort
    private final Factory_Sortable SORTABLE = _Init_Factories.getFactories().getSortable();
    private final WebElement HomePageLink_sort = _Init_Factories.getHome().getPageLink_sortable();

    // TESTS

    /**
     *  Test 1 - Select - select multiple
     */
    @Test
    public void VerifySelectingMultiple() {
        // NAVIGATE
        SELECTABLE.navigateTo(HomePageLink_select);

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

    /**
     *  Test 1 - Sort - sort items
     */
    @Test
    public void VerifySortable() {
        // NAVIGATE
        SORTABLE.navigateTo(HomePageLink_sort);

        // SETUP
        WebDriver driver = Drivers.getDriver();
        WebElement listEl = SORTABLE.getSelectableList();
        Actions action = new Actions(driver);// get <li>
        List<WebElement> listItemEls = listEl.findElements(By.cssSelector("li"));

        // INTERACT
        // move even numbers to the top
        for (int i = 1; i < listItemEls.size(); i++) {
            if (i % 2 == 1) {
                // implement action
                action.dragAndDrop(listItemEls.get(i), listItemEls.get(0)).perform();
            }
        }

        // ASSERT
        // get new order
        List<WebElement> listItemEls_newOrder = listEl.findElements(By.cssSelector("li"));
        // ("Item 2", "Item 4", etc.)
        int[] expectedListOrder = {2, 4, 6, 1, 3, 5, 7};
        // loop & assert
        for (int i = 0; i < listItemEls_newOrder.size(); i++) {
            Assert.assertTrue(listItemEls_newOrder.get(i).getText().contains(String.valueOf(expectedListOrder[i])));
        }

//        // VERIFY
//        Assert.assertTrue(listEls.get(0).getAttribute("class").contains("ui-selected"));
//        Assert.assertFalse(listEls.get(1).getAttribute("class").contains("ui-selected"));
//        Assert.assertTrue(listEls.get(2).getAttribute("class").contains("ui-selected"));
//        Assert.assertFalse(listEls.get(3).getAttribute("class").contains("ui-selected"));
//        Assert.assertTrue(listEls.get(4).getAttribute("class").contains("ui-selected"));
//        Assert.assertFalse(listEls.get(5).getAttribute("class").contains("ui-selected"));
//        Assert.assertTrue(listEls.get(6).getAttribute("class").contains("ui-selected"));
    }
}
