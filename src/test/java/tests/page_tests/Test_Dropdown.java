package tests.page_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.page_object_models.Factory_Dropdown;
import tests.page_object_models.Factory_Image;
import tests.page_object_models._Init_Factories;
import utils.Waits;

import java.util.List;

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
     * Dropdown 2 - Select via value attribute
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
}
