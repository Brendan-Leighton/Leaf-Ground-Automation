package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebElement;
// TEST-NG
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
// CUSTOM - utils
import utils.Asserts;
import utils.Drivers;
// CUSTOM - factories
import tests.page_object_models.Factory_Edit;
import tests.page_object_models._Init_Factories;
import utils.Waits;

/**
 * Tests for the Edit page.
 */
public class Test_Edit extends _Base_Test {

    // PROPS

    private final Factory_Edit EDIT = _Init_Factories.getEdit();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_edit();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        Drivers.getDriver().navigate().to(EDIT.getUrlHome());  // go to Home page
        Asserts.navigation_toUrl(EDIT.getUrlHome());           // Assert correct URL loaded
        Asserts.navigation_fromElement_toUrl(HomePageLink, EDIT.getUrl());  // click on, wait for, and assert proper navigation to this.pageUrl
    }

    @Test
    public void NavbarLogoNavigatesToHomePage() {
        EDIT.TestLogoToHomeButton(HomePageLink);
    }

    /**
     * INPUT 1 - ENTER EMAIL
     */
    @Test
    public void EnterEmail() {
        // SETUP
        String email = "email@email.com";
        WebElement inputField = EDIT.getInputEmail();

        // INTERACTION
        Waits.forElement_andClick(inputField); // wait for input
        inputField.sendKeys(email);            // type email

        // ASSERT
        Assert.assertEquals(inputField.getAttribute("value"), email);
    }

    /**
     * INPUT 2 - APPEND TO TEXT THAT'S ALREADY THERE
     */
    @Test
    public void AppendToText() {

        // SETUP
        String newText = "new text";
        WebElement inputField = EDIT.getInputToAppendTo();
        Waits.forElement(inputField);
        String originalText = inputField.getAttribute("value");

        // INTERACTION
        inputField.sendKeys(newText);

        // ASSERT
        Assert.assertEquals(inputField.getAttribute("value"), originalText + newText);
    }

    /**
     * INPUT 3 - Get the original/default text
     */
    @Test
    public void GetDefaultText() {

        // SETUP
        String originalText = "TestLeaf";
        WebElement inputField = EDIT.getInputToGetTextFrom();

        // INTERACT
        Waits.forElement(inputField);

        // ASSERT
        Assert.assertEquals(inputField.getAttribute("value"), originalText);
    }

    /**
     * INPUT 4 - Clear the default text
     */
    @Test
    public void ClearDefaultText() {

        // SETUP
        WebElement inputField = EDIT.getInputToClear();

        // INTERACT
        Waits.forElement(inputField);
        inputField.clear();

        // ASSERT
        Assert.assertEquals(inputField.getAttribute("value"), "");
    }

    /**
     * INPUT 5 - Verify field is disabled
     */
    @Test
    public void CheckIfDisabled() {

        // SETUP
        WebElement inputField = EDIT.getInputToConfirmIsDisabled();

        // ASSERT
        Assert.assertTrue(new WebDriverWait(Drivers.getDriver(), 5).until(ExpectedConditions.attributeToBe(inputField, "disabled", "true")));
    }
}
