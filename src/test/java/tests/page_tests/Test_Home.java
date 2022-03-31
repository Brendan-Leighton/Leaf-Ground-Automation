package tests.page_tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.page_object_models.Factory_Home;
import tests.page_object_models._Init_Factories;
import utils.Asserts;
import utils.Drivers;
import utils.Urls;

public class Test_Home extends _Base_Test {
    private Factory_Home HOME = _Init_Factories.getHome();

    @BeforeTest
    public void GoToHomePage() {
        Drivers.getDriver().navigate().to(HOME.getUrl());
    }

    @Test (priority = -1)
    public void HomePageLoads() {
        Asserts.navigation_toUrl(HOME.getUrl());
    }

    @Test
    public void CanNavigateFromHomeToEditPage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_edit(), Urls.get("edit"));
    }
}
