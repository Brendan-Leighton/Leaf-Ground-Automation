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
        File downloadsFolder = new File("C:\\Users\\br3nd\\Downloads");
        int downloadsFolder_startingSize = Objects.requireNonNull(downloadsFolder.listFiles()).length;
        int downloadsFolder_endingSize;

        // get BEFORE download folder size
        // INTERACT
        wait.until(ExpectedConditions.elementToBeClickable(link));
        Interacts.click(link);
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep was stopped");
        }
        downloadsFolder_endingSize = Objects.requireNonNull(downloadsFolder.listFiles()).length;

        // ASSERT
        Assert.assertEquals(downloadsFolder_endingSize, downloadsFolder_startingSize + 1);
    }
}
