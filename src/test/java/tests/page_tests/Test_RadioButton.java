package tests.page_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.page_object_models.Factory_Dropdown;
import tests.page_object_models.Factory_RadioButton;
import tests.page_object_models._Init_Factories;
import utils.Waits;

import java.util.List;

public class Test_RadioButton extends _Base_Test {

    // PROPS

    private final Factory_RadioButton RADIO = _Init_Factories.getFactories().getRadioButton();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_radioButton();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        RADIO.navigateTo(HomePageLink);
    }

    /**
     * Radio 1 - select a radio button
     *
     * Test 1 - select yes
     */
    @Test
    public void VerifyOption_yes_IsSelectable() {
        // SETUP
        WebElement radioButton = RADIO.getRadioSelectAnAnswer_yes();

        // INTERACT
        Waits.forElement_andClick(radioButton);

        // VERIFY
        Assert.assertEquals(radioButton.getAttribute("selected"), "true");
    }

    /**
     * Radio 1 - select a radio button
     *
     * Test 2 - select no
     */
    @Test
    public void VerifyOption_no_IsSelectable() {
        // SETUP
        WebElement radioButton = RADIO.getRadioSelectAnAnswer_no();

        // INTERACT
        Waits.forElement_andClick(radioButton);

        // VERIFY
        Assert.assertEquals(radioButton.getAttribute("selected"), "true");
    }

    /**
     * Radio 2 - get default selection
     */
    @Test
    public void VerifyDefaultSelection() {
        // SETUP
        WebElement radioButtonParentEl = RADIO.getRadioFindSelected();
        List<WebElement> radioButtons = radioButtonParentEl.findElements(By.cssSelector("input[type='radio']"));

        // INTERACT
        // VERIFY
        Assert.assertFalse(Boolean.parseBoolean(radioButtons.get(0).getAttribute("checked")));
        Assert.assertTrue(Boolean.parseBoolean(radioButtons.get(1).getAttribute("checked")));
    }
}
