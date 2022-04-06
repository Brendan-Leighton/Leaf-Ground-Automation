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

    public Factory_Alert getAlert() {
        return alert;
    }

    public Factory_Frames getFrames() {
        return frames;
    }
}
