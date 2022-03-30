package tests.page_tests;

import org.testng.annotations.Test;
import tests.page_object_models.Factory_Home;
import tests.page_object_models._Init_Factories;
import utils.Drivers;

public class Test_Home extends _Base_Test {
    private Factory_Home HOME = _Init_Factories.getHome();

    @Test
    public void HomePageLoads() {
        Drivers.getDriver().navigate().to(HOME.getUrl());
    }
}
