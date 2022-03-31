package tests.page_object_models;
// SELENIUM
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
// CUSTOM
import utils.Urls;

/**
 * Page Object Model representing the home page of the LeafGround.com site.
 */
public class Factory_Home extends Factory__Index {

    // CONSTRUCTOR - only one

    public Factory_Home(WebDriver driver) {
        // SUPER
        super(Urls.get("home"));
        // POM FACTORY
        PageFactory.initElements(driver, this);
    }

    // LOCATORS
    // header logo
    @FindBy (css = "aside#block-bku55abec0ab0897")
    public WebElement pageLink_logoHeader;

    // footer logo
    @FindBy (css = "div#wrapper-wcf55abec0ab022b a[href='pages/http://testleaf.com']")
    public WebElement pageLink_logoFooter;

    @FindBy (css = "a[href='pages/Edit.html']")
    public WebElement pageLink_edit;

    @FindBy (css = "a[href='pages/Button.html']")
    public WebElement pageLink_button;

    @FindBy (css = "a[href='pages/Link.html']")
    public WebElement pageLink_link;

    @FindBy (css = "a[href='pages/Image.html']")
    public WebElement pageLink_image;

    @FindBy (css = "a[href='pages/Dropdown.html']")
    public WebElement pageLink_dropdown;

    @FindBy (css = "a[href='pages/radio.html']")
    public WebElement pageLink_radio;

    @FindBy (css = "a[href='pages/checkbox.html']")
    public WebElement pageLink_checkbox;

    @FindBy (css = "a[href='pages/table.html']")
    public WebElement pageLink_table;

    @FindBy (css = "a[href='pages/Alert.html']")
    public WebElement pageLink_alert;

    @FindBy (css = "a[href='pages/frame.html']")
    public WebElement pageLink_frame;

    @FindBy (css = "a[href='pages/Window.html']")
    public WebElement pageLink_window;

    @FindBy (css = "a[href='pages/Calendar.html']")
    public WebElement pageLink_calendar;

    @FindBy (css = "a[href='pages/drag.html']")
    public WebElement pageLink_draggable;

    @FindBy (css = "a[href='pages/drop.html']")
    public WebElement pageLink_droppable;

    @FindBy (css = "a[href='pages/selectable.html']")
    public WebElement pageLink_selectable;

    @FindBy (css = "a[href='pages/sortable.html']")
    public WebElement pageLink_sortable;

    @FindBy (css = "a[href='pages/autoComplete.html']")
    public WebElement pageLink_autoComplete;

    @FindBy (css = "a[href='pages/download.html']")
    public WebElement pageLink_download;

    @FindBy (css = "a[href='pages/upload.html']")
    public WebElement pageLink_upload;

    @FindBy (css = "a[href='pages/tooltip.html']")
    public WebElement pageLink_tooltip;

    @FindBy (css = "a[href='pages/disapper.html']")  // "disapper" is misspelled in sites' HTML
    public WebElement pageLink_waitToDisappear;

    @FindBy (css = "a[href='pages/appear.html']")
    public WebElement pageLink_waitToAppear;

    @FindBy (css = "a[href='pages/TextChange.html']")
    public WebElement pageLink_waitForTextChange;

    @FindBy (css = "a[href='pages/alertappear.html']") // "alertappear" incorrect camelCase in HTML
    public WebElement pageLink_waitForAlert;

    // GETTERS

    public WebElement getPageLink_edit() {
        return pageLink_edit;
    }

    public WebElement getPageLink_logoHeader() {
        return pageLink_logoHeader;
    }

    public WebElement getPageLink_logoFooter() {
        return pageLink_logoFooter;
    }

    public WebElement getPageLink_button() {
        return pageLink_button;
    }

    public WebElement getPageLink_link() {
        return pageLink_link;
    }

    public WebElement getPageLink_image() {
        return pageLink_image;
    }

    public WebElement getPageLink_dropdown() {
        return pageLink_dropdown;
    }

    public WebElement getPageLink_radio() {
        return pageLink_radio;
    }

    public WebElement getPageLink_checkbox() {
        return pageLink_checkbox;
    }

    public WebElement getPageLink_table() {
        return pageLink_table;
    }

    public WebElement getPageLink_alert() {
        return pageLink_alert;
    }

    public WebElement getPageLink_frame() {
        return pageLink_frame;
    }

    public WebElement getPageLink_window() {
        return pageLink_window;
    }

    public WebElement getPageLink_calendar() {
        return pageLink_calendar;
    }

    public WebElement getPageLink_draggable() {
        return pageLink_draggable;
    }

    public WebElement getPageLink_droppable() {
        return pageLink_droppable;
    }

    public WebElement getPageLink_selectable() {
        return pageLink_selectable;
    }

    public WebElement getPageLink_sortable() {
        return pageLink_sortable;
    }

    public WebElement getPageLink_autoComplete() {
        return pageLink_autoComplete;
    }

    public WebElement getPageLink_download() {
        return pageLink_download;
    }

    public WebElement getPageLink_upload() {
        return pageLink_upload;
    }

    public WebElement getPageLink_tooltip() {
        return pageLink_tooltip;
    }

    public WebElement getPageLink_waitToDisappear() {
        return pageLink_waitToDisappear;
    }

    public WebElement getPageLink_waitToAppear() {
        return pageLink_waitToAppear;
    }

    public WebElement getPageLink_waitForTextChange() {
        return pageLink_waitForTextChange;
    }

    public WebElement getPageLink_waitForAlert() {
        return pageLink_waitForAlert;
    }
}
