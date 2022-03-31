package tests.page_tests;

import org.testng.annotations.Test;
import tests.page_object_models.Factory_Home;
import tests.page_object_models._Init_Factories;
import utils.Asserts;
import utils.Drivers;
import utils.Urls;

public class Test_Home extends _Base_Test {
    private Factory_Home HOME = _Init_Factories.getHome();

    @Test (priority = 0)
    public void HomePageLoads() {
        Drivers.getDriver().navigate().to(HOME.getUrl());
    }

    @Test (priority = 1)
    public void CanNavigateFromHomeToEditPage() {
        Drivers.getDriver().navigate().to(HOME.getUrl());
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_edit(), Urls.get("edit"));
    }
}
