package tests.page_tests;
// SELENIUM

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
// TEST-NG
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
// PAGE MODELS
import org.testng.annotations.Test;
import tests.page_object_models.Factory_Table;
import tests.page_object_models._Init_Factories;

import java.util.List;

public class Test_Table extends _Base_Test {

    // PROPS

    private final Factory_Table TABLE = _Init_Factories.getFactories().getTable();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_table();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        TABLE.navigateTo(HomePageLink);
    }

    /**
     * Count # of columns
     */
    @Test
    public void CountNumberOfColumns() {
        // SETUP
        List<WebElement> tableHeaders = TABLE.getTable().findElements(By.tagName("th"));
        // INTERACT
        // ASSERT
        Assert.assertEquals(tableHeaders.size(), 3);
    }

    /**
     * Count # of rows
     */
    @Test
    public void CountNumberOfRows() {
        // SETUP
        List<WebElement> tableRows = TABLE.getTable().findElements(By.tagName("tr"));
        // INTERACT
        // ASSERT
        Assert.assertEquals(tableRows.size(), 6);
    }

    /**
     * Get the progress value of 'Learn to interact with Elements'
     */
    @Test
    public void VerifyProgressValueOfRow3() {
        // SETUP
        List<WebElement> tableRows = TABLE.getTable().findElements(By.tagName("tr"));
        String rowName = "Learn to interact with Elements";
        String cssSelector1 = "tbody > tr:nth-child(";     // selector 1/2   a number will be put between
        String cssSelector2 = ") > td:nth-child(2) > font";// selector 2/2   these when they're combined
        String cssSelector = null;                         // selector's final result
        String actualValue = null;                         // used for assertion

        // INTERACT
        int rowNum = 1; // used for css selector and incrementing, could have used a fori loop
        for (WebElement row : tableRows) {
            // try because row 1 throws an error due to not having a <td>
            try {
                // the text is a description of the row
                WebElement td = row.findElement(By.tagName("td"));
                String rowText = td.getText().trim();

                // when we find the row with the matching description
                if (rowText.equals(rowName)) {
                    cssSelector = cssSelector1 + rowNum + cssSelector2; // the row number helps us locate the correct row when searching in the next column
                }
            } catch (NoSuchElementException ignore) { // exception thrown from 1st row not having a <td>
            }
            // when we have put together a selector, get the value from the other column
            if (cssSelector != null) {
                actualValue = TABLE.getTable().findElement(By.cssSelector(cssSelector)).getText().trim();
                System.out.println("actualValue: " + actualValue);
                break;
            }
            rowNum++;
        }

        // ASSERT
        Assert.assertEquals(actualValue, "80%");
    }
}
