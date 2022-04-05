package tests.page_tests;
// SELENIUM
import org.openqa.selenium.By;
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
}
