package tests.page_tests;
// SELENIUM
import org.openqa.selenium.WebElement;
// TEST-NG
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
// PAGE MODELS
import org.testng.annotations.Test;
import tests.page_object_models.Factory_Upload;
import tests.page_object_models._Init_Factories;
import utils.Drivers;
import utils.Interacts;

import java.io.File;

public class Test_Upload extends _Base_Test {

    // PROPS
    private final Factory_Upload UPLOAD = _Init_Factories.getFactories().getUpload();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_upload();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        UPLOAD.navigateTo(HomePageLink);
    }

    /**
     * Test 1 - upload file
     */
    @Test
    public void VerifyFileUploads() {
        // SETUP
        WebDriverWait wait = new WebDriverWait(Drivers.getDriver(), 5);
        WebElement input = UPLOAD.getInputFile();
        String uploadFilePath = UPLOAD.getUploadFilePath();

        // INTERACT
        wait.until(ExpectedConditions.elementToBeClickable(input));
        input.sendKeys(uploadFilePath);

        // ASSERT
        Assert.assertEquals(input.getAttribute("value"), UPLOAD.getExpectedFilePath());
    }
}
