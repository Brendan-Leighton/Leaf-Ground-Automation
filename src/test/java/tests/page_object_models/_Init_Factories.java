package tests.page_object_models;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Factory;
import utils.Drivers;

/**
 * <strong>SINGLETON</strong>
 * <br />
 * Used to initialize all Page Object Models.
 * <br />
 * Use <i>getFactories()</i> to instantiate or access a specific POM.
 */
public class _Init_Factories {
    // THIS
    private static _Init_Factories FACTORIES;
    // POMs
    private final Factory_Home home;
    private final Factory_Edit edit;
    private final Factory_Hyperlinks hyperlinks;
    private final Factory_Button button;
    private final Factory_Image image;
    private final Factory_Dropdown dropdown;
    private final Factory_RadioButton radioButton;
    private final Factory_Checkbox checkbox;
    private final Factory_Table table;
    private final Factory_Alert alert;
    private final Factory_Frames frames;
    private final Factory_Window window;
    private final Factory_Calendar calendar;
    private final Factory_Draggable draggable;
    private final Factory_Droppable droppable;
    private final Factory_Selectable selectable;
    private final Factory_Sortable sortable;
    private final Factory_AutoComplete autoComplete;
    private final Factory_Download download;
    private final Factory_Upload upload;
    private final Factory_Tooltip tooltip;
    private final Factory_WaitToDisappear waitToDisappear;
    private final Factory_WaitToAppear waitToAppear;
    private final Factory_WaitForTextChange waitForTextChange;
    private final Factory_WaitForAlert waitForAlert;

    // CONSTRUCTOR
    private _Init_Factories() {
        // initialize factories
        this.home = new Factory_Home();
        this.edit = new Factory_Edit();
        this.hyperlinks = new Factory_Hyperlinks();
        this.button = new Factory_Button();
        this.image = new Factory_Image();
        this.dropdown = new Factory_Dropdown();
        this.radioButton = new Factory_RadioButton();
        this.checkbox = new Factory_Checkbox();
        this.table = new Factory_Table();
        this.alert = new Factory_Alert();
        this.frames = new Factory_Frames();
        this.window = new Factory_Window();
        this.calendar = new Factory_Calendar();
        this.draggable = new Factory_Draggable();
        this.droppable = new Factory_Droppable();
        this.selectable = new Factory_Selectable();
        this.sortable = new Factory_Sortable();
        this.autoComplete = new Factory_AutoComplete();
        this.download = new Factory_Download();
        this.upload = new Factory_Upload();
        this.tooltip = new Factory_Tooltip();
        this.waitToDisappear = new Factory_WaitToDisappear();
        this.waitToAppear = new Factory_WaitToAppear();
        this.waitForTextChange = new Factory_WaitForTextChange();
        this.waitForAlert = new Factory_WaitForAlert();
    }

    // GETTER / INITIALIZER
    public static _Init_Factories getFactories() {
        if (FACTORIES == null) {
            FACTORIES = new _Init_Factories();
        }
        return FACTORIES;
    }

    /*
     *   PAGE OBJECT GETTERS
     */

    public static Factory_Home getHome() {
        return getFactories().home;
    }

    public static Factory_Edit getEdit() {
        return getFactories().edit;
    }

    public Factory_Hyperlinks getHyperlinks() {
        return hyperlinks;
    }

    public Factory_Image getImage() {
        return image;
    }

    public Factory_Button getButton() {
        return button;
    }

    public Factory_Dropdown getDropdown() {
        return dropdown;
    }

    public Factory_RadioButton getRadioButton() {
        return radioButton;
    }

    public Factory_Checkbox getCheckbox() {
        return checkbox;
    }

    public Factory_Table getTable() {
        return table;
    }

    public Factory_Alert getAlert() { return alert; }

    public Factory_Frames getFrames() { return frames; }

    public Factory_Window getWindow() { return window; }

    public Factory_Calendar getCalendar() { return calendar; }

    public Factory_Draggable getDraggable() { return draggable; }

    public Factory_Droppable getDroppable() { return droppable; }

    public Factory_Selectable getSelectable() { return selectable; }

    public Factory_Sortable getSortable() { return sortable; }

    public Factory_AutoComplete getAutoComplete() { return autoComplete; }

    public Factory_Download getDownload() { return download; }

    public Factory_Upload getUpload() { return upload; }

    public Factory_Tooltip getTooltip() { return tooltip; }

    public Factory_WaitToDisappear getWaitToDisappear() { return waitToDisappear; }

    public Factory_WaitToAppear getWaitToAppear() { return waitToAppear; }

    public Factory_WaitForTextChange getWaitForTextChange() { return waitForTextChange; }

    public Factory_WaitForAlert getWaitForAlert() { return waitForAlert; }
}
