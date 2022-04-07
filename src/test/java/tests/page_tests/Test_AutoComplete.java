package tests.page_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.page_object_models.Factory_AutoComplete;
import tests.page_object_models.Factory_Selectable;
import tests.page_object_models._Init_Factories;
import utils.Drivers;
import utils.Interacts;

import java.util.List;

public class Test_AutoComplete extends _Base_Test {

    // PROPS
    private final Factory_AutoComplete AUTO = _Init_Factories.getFactories().getAutoComplete();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_autoComplete();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        AUTO.navigateTo(HomePageLink);
    }

    /**
     * Test 1 - enter class name using auto complete
     */
    @Test
    public void VerifyAutoCompleteWorks() {
        // SETUP
        WebDriver driver = Drivers.getDriver();
        WebElement inputField = AUTO.getInputField();
        WebElement suggestionsList = AUTO.getSuggestionsList();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String suggestionsLocator = AUTO.getSuggestionsLocator();
        String searchPhrase = "sele";
        String expectedSearchResult = "selenium";

        // INTERACT
        inputField.sendKeys(searchPhrase);
        wait.until(ExpectedConditions.elementToBeClickable(suggestionsList));
        List<WebElement> suggestions = driver.findElements(By.cssSelector(suggestionsLocator));
        // loop
        for (WebElement suggestion : suggestions) {
            String elText = suggestion.getText().toLowerCase();
            if (elText.contains(expectedSearchResult)) {
                suggestion.click();
            }
        };

        // ASSERT
        String actualSearchResult = inputField.getAttribute("value").toLowerCase();
        Assert.assertEquals(actualSearchResult, expectedSearchResult);
    }
}
