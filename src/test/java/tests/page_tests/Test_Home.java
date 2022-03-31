package tests.page_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.page_object_models.Factory_Home;
import tests.page_object_models._Init_Factories;
import utils.Asserts;
import utils.Drivers;
import utils.Urls;

/**
 * Tests for the Home page.
 */
public class Test_Home extends _Base_Test {

    // PROPS
    private Factory_Home HOME = _Init_Factories.getHome();

    @BeforeMethod
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

    @Test
    public void CanNavigateFromHomeToButtonPage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_button(), Urls.get("button"));
    }

    @Test
    public void CanNavigateFromHomeToHyperLinkPage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_hyperlink(), Urls.get("hyperlink"));
    }

    @Test
    public void CanNavigateFromHomeToImagePage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_image(), Urls.get("image"));
    }

    @Test
    public void CanNavigateFromHomeToDropdownPage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_dropdown(), Urls.get("dropdown"));
    }

    @Test
    public void CanNavigateFromHomeToRadioButtonPage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_radioButton(), Urls.get("radioButton"));
    }

    @Test
    public void CanNavigateFromHomeToCheckboxPage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_checkbox(), Urls.get("checkbox"));
    }

    @Test
    public void CanNavigateFromHomeToTablePage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_table(), Urls.get("table"));
    }

    @Test
    public void CanNavigateFromHomeToAlertPage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_alert(), Urls.get("alert"));
    }

    @Test
    public void CanNavigateFromHomeToFramePage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_frame(), Urls.get("frame"));
    }

    @Test
    public void CanNavigateFromHomeToWindowPage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_window(), Urls.get("window"));
    }

    @Test
    public void CanNavigateFromHomeToCalendarPage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_calendar(), Urls.get("calendar"));
    }

    @Test
    public void CanNavigateFromHomeToDraggablePage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_draggable(), Urls.get("draggable"));
    }

    @Test
    public void CanNavigateFromHomeToDroppablePage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_droppable(), Urls.get("droppable"));
    }

    @Test
    public void CanNavigateFromHomeToSelectablePage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_selectable(), Urls.get("selectable"));
    }

    @Test
    public void CanNavigateFromHomeToSortablePage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_sortable(), Urls.get("sortable"));
    }

    @Test
    public void CanNavigateFromHomeToAutoCompoletePage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_autoComplete(), Urls.get("autoComplete"));
    }

    @Test
    public void CanNavigateFromHomeToDownFilesPage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_download(), Urls.get("downFiles"));
    }

    @Test
    public void CanNavigateFromHomeToUploadFilesPage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_upload(), Urls.get("uploadFiles"));
    }

    @Test
    public void CanNavigateFromHomeToTooltipPage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_tooltip(), Urls.get("tooltip"));
    }

    @Test
    public void CanNavigateFromHomeToWaitToDisappearPage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_waitToDisappear(), Urls.get("waitToDisappear"));
    }

    @Test
    public void CanNavigateFromHomeWaitToAppearPage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_waitToAppear(), Urls.get("waitToAppear"));
    }

    @Test
    public void CanNavigateFromHomeWaitForTextChangePage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_waitForTextChange(), Urls.get("waitForTextChange"));
    }

    @Test
    public void CanNavigateFromHomeWaitForAlertPage() {
        Asserts.navigation_fromElement_toUrl(HOME.getPageLink_waitForAlert(), Urls.get("waitForAlert"));
    }
}
