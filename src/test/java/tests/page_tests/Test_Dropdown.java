package tests.page_tests;
// SELENIUM

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
// TEST-NG
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
// PAGE OBJECTS
import tests.page_object_models.Factory_Dropdown;
import tests.page_object_models._Init_Factories;
// CUSTOM UTILS
import utils.Drivers;
import utils.Waits;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test_Dropdown extends _Base_Test {

    // PROPS

    private final Factory_Dropdown DROPDOWN = _Init_Factories.getFactories().getDropdown();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_dropdown();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        DROPDOWN.navigateTo(HomePageLink);
    }

    /**
     * Dropdown 1 - Select via index
     */
    @Test
    public void VerifyIsOptionSelectableViaIndex() {
        // SETUP
        WebElement selectEl = DROPDOWN.getDropdownSelectViaIndex();
        List<WebElement> optionEls = selectEl.findElements(By.tagName("option"));
        WebElement optionToClick = optionEls.get(DROPDOWN.dropdownOptionIndex);

        // INTERACT
        Waits.forElement_andClick(selectEl);
        Waits.forElement_andClick(optionToClick);

        // VERIFY
        Assert.assertEquals(optionToClick.getAttribute("selected"), "true");
    }

    /**
     * Dropdown 2 - Select via text
     */
    @Test
    public void VerifyIsOptionSelectableViaText() {
        // SETUP
        WebElement selectEl = DROPDOWN.getDropdownSelectViaText();
        List<WebElement> optionEls = selectEl.findElements(By.tagName("option"));
        WebElement optionToClick = null;

        // INTERACT
        for (WebElement el : optionEls) {
            if (el.getText().equals(DROPDOWN.dropdownOptionString)) {
                optionToClick = el;
                break;
            }
        }
        Waits.forElement_andClick(selectEl);
        Waits.forElement_andClick(optionToClick);

        // VERIFY
        assert optionToClick != null;
        Assert.assertEquals(optionToClick.getAttribute("selected"), "true");
    }

    /**
     * Dropdown 3 - Select via value attribute
     */
    @Test
    public void VerifyIsOptionSelectableViaValue() {
        // SETUP
        WebElement selectEl = DROPDOWN.getDropdownSelectViaValue();
        List<WebElement> optionEls = selectEl.findElements(By.tagName("option"));
        WebElement optionToClick = null;

        // INTERACT
        for (WebElement el : optionEls) {
            if (el.getAttribute("value").equals(DROPDOWN.dropdownOptionValue)) {
                optionToClick = el;
                break;
            }
        }
        Waits.forElement_andClick(selectEl);
        Waits.forElement_andClick(optionToClick);

        // VERIFY
        assert optionToClick != null;
        Assert.assertEquals(optionToClick.getAttribute("selected"), "true");
    }

    /**
     * Dropdown 4 - count the option-tags
     */
    @Test
    public void VerifyCountOfOptions() {
        // SETUP
        WebElement selectEl = DROPDOWN.getDropdownSelectViaValue();
        int optionsCount = selectEl.findElements(By.tagName("option")).size();

        // INTERACT
        // VERIFY
        Assert.assertEquals(optionsCount, DROPDOWN.dropdownCountExpected);
    }

    /**
     * Dropdown 5 - select via SendKeys
     */
    @Test
    public void VerifyIsOptionSelectableViaSendKeys() {
        // SETUP
        WebElement selectEl = DROPDOWN.getDropdownSelectViaSendKeys();
        WebElement optionToSelect = selectEl.findElement(By.xpath("option[@value='1']"));

        // INTERACT
        Waits.forElement_andClick(selectEl);
        selectEl.sendKeys(Keys.ARROW_DOWN);
        selectEl.sendKeys(Keys.ENTER);

        // VERIFY
        Assert.assertEquals(optionToSelect.getAttribute("selected"), "true");
    }

    /**
     * Dropdown 6 - select after scroll
     */
    @Test
    public void VerifyIsSelectableAfterScroll() {
        // SETUP
        WebElement selectEl = DROPDOWN.getDropdownSelectAfterScroll();
        List<WebElement> options = selectEl.findElements(By.tagName("option"));
        WebElement optionToSelect = options.get(DROPDOWN.dropdownScrollOption);

        // INTERACT
        Waits.forElement(selectEl);
        JavascriptExecutor js = (JavascriptExecutor) Drivers.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", optionToSelect);
        optionToSelect.click();

        // VERIFY
        Assert.assertNull(options.get(1).getAttribute("selected"));
        Assert.assertNull(options.get(2).getAttribute("selected"));
        Assert.assertNull(options.get(3).getAttribute("selected"));
        Assert.assertEquals(options.get(4).getAttribute("selected"), "true");
    }
}
