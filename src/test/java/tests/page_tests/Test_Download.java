package tests.page_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.page_object_models.Factory_AutoComplete;
import tests.page_object_models.Factory_Download;
import tests.page_object_models._Init_Factories;
import utils.Drivers;
import utils.Interacts;

import java.io.File;
import java.util.Objects;


public class Test_Download extends _Base_Test {

    // PROPS
    private final Factory_Download DOWNLOAD = _Init_Factories.getFactories().getDownload();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_download();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        DOWNLOAD.navigateTo(HomePageLink);
    }

    /**
     *
     */
    @Test
    public void VerifyExcelDownloadLink() {
        // SETUP
        WebDriver driver = Drivers.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement link = DOWNLOAD.getLinks().get(0);
        File downloadsFolder_before = new File("C:\\Users\\br3nd\\Downloads");
        int downloadsFolder_startingSize = downloadsFolder_before.listFiles().length;
        File downloadsFolder_after;
        int downloadsFolder_endingSize;

        // get BEFORE download folder size
        // INTERACT
        wait.until(ExpectedConditions.elementToBeClickable(link));
        Interacts.click(link);
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException ignore) {}
        downloadsFolder_after = new File("\\Users\\br3nd\\Downloads");
        downloadsFolder_endingSize = Objects.requireNonNull(downloadsFolder_after.listFiles()).length;

        // ASSERT
        Assert.assertEquals(downloadsFolder_endingSize, downloadsFolder_startingSize + 1);
    }
}
