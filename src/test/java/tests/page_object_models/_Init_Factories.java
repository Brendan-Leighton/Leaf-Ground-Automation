package tests.page_object_models;

import org.openqa.selenium.WebDriver;
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

    // CONSTRUCTOR
    private _Init_Factories(WebDriver driver) {
        // initialize factories
         this.home = new Factory_Home(driver);
         this.edit = new Factory_Edit(driver);
         this.hyperlinks = new Factory_Hyperlinks(driver);
    }

    // GETTER / INITIALIZER
    public static _Init_Factories getFactories() {
        if (FACTORIES == null) {
            FACTORIES = new _Init_Factories(Drivers.getDriver());
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
    public Factory_Hyperlinks getHyperlinks() { return hyperlinks; }
}
