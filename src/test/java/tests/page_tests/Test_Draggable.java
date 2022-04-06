package tests.page_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.page_object_models.Factory_Calendar;
import tests.page_object_models.Factory_Draggable;
import tests.page_object_models._Init_Factories;
import utils.Drivers;

public class Test_Draggable extends _Base_Test {

    // PROPS

    private final Factory_Draggable DRAGGABLE = _Init_Factories.getFactories().getDraggable();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_draggable();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        DRAGGABLE.navigateTo(HomePageLink);
    }

    /**
     *
     */
    @Test
    public void VerifyCanDragElement() {
        // SETUP
        WebDriver driver = Drivers.getDriver();
        WebElement draggableEl = DRAGGABLE.getDraggableDiv();
        WebElement containerEl = DRAGGABLE.getContainerDiv();

        int draggable_dragEl_X = draggableEl.getLocation().getX();
        int draggable_dragEl_Y = draggableEl.getLocation().getY();
        int xOffset = 50;
        int yOffset = 75;

        // move draggable element
        Actions drag = new Actions(driver);
        drag.dragAndDropBy(draggableEl, xOffset, yOffset).perform();

        // assert draggable has moved
        Assert.assertEquals(draggableEl.getLocation().getX(), draggable_dragEl_X + xOffset);
        Assert.assertEquals(draggableEl.getLocation().getY(), draggable_dragEl_Y + yOffset);
    }

}
