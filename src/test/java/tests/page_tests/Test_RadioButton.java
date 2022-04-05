package tests.page_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.page_object_models.Factory_Dropdown;
import tests.page_object_models.Factory_RadioButton;
import tests.page_object_models._Init_Factories;
import utils.Waits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_RadioButton extends _Base_Test {

    // PROPS

    private final Factory_RadioButton RADIO = _Init_Factories.getFactories().getRadioButton();
    private final WebElement HomePageLink = _Init_Factories.getHome().getPageLink_radioButton();

    // TESTS

    @BeforeMethod
    public void GoToThisPage() {
        RADIO.navigateTo(HomePageLink);
    }

    /**
     * Radio 1 - select a radio button
     * <p>
     * Test 1 - select yes
     */
    @Test
    public void VerifyOption_yes_IsSelectable() {
        // SETUP
        WebElement radioButton = RADIO.getRadioSelectAnAnswer_yes();

        // INTERACT
        Waits.forElement_andClick(radioButton);

        // VERIFY
        Assert.assertEquals(radioButton.getAttribute("selected"), "true");
    }

    /**
     * Radio 1 - select a radio button
     * <p>
     * Test 2 - select no
     */
    @Test
    public void VerifyOption_no_IsSelectable() {
        // SETUP
        WebElement radioButton = RADIO.getRadioSelectAnAnswer_no();

        // INTERACT
        Waits.forElement_andClick(radioButton);

        // VERIFY
        Assert.assertEquals(radioButton.getAttribute("selected"), "true");
    }

    /**
     * Radio 2 - get default selection
     */
    @Test
    public void VerifyDefaultSelection() {
        // SETUP
        WebElement radioButtonParentEl = RADIO.getRadioFindSelected();
        List<WebElement> radioButtons = radioButtonParentEl.findElements(By.cssSelector("input[type='radio']"));

        // INTERACT
        // VERIFY
        Assert.assertFalse(Boolean.parseBoolean(radioButtons.get(0).getAttribute("checked")));
        Assert.assertTrue(Boolean.parseBoolean(radioButtons.get(1).getAttribute("checked")));
    }

    /**
     * Radio 3 - Select based on label text
     * <p>
     * Test Method -
     *
     * @param age int : age that determines radio button selection
     * @param expectedAnswer int :
     *                       <ol>
     *                       <li>Ages 1 - 20</li>
     *                       <li>Ages 21 - 40</li>
     *                       <li>Ages 40 +</li>
     *                       </ol>
     */
    public void Radio3Test(int age, int expectedAnswer) {
        // BASE CASES
        if (age < 1 || age > 120) {
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(false);
            return;
        }


        // SETUP
        WebElement radioButtonParentEl = RADIO.getRadioPickOptionProgramatically();
        List<WebElement> radioButtons = radioButtonParentEl.findElements(By.cssSelector("input.myradio"));
        String[] optionsText = radioButtonParentEl.getText().trim().split("years");
        List<List<Integer>> options = new ArrayList<>();

        // INTERACT
        // get options
        for (int i = 0; i < 3; i++) {
            System.out.println("Button Text: " + radioButtons.get(i).getText());
            String[] parsedLabel = optionsText[i].split(" ");
            System.out.println("parsedLabel: " + Arrays.toString(parsedLabel));
            List<Integer> newRange = new ArrayList<>();
            for (String word : parsedLabel) {
                try {
                    Integer num = Integer.parseInt(word);
                    newRange.add(num);
                } catch (Exception ignore) {}
            }
            if (newRange.size() == 1) { // catch the last option which only mentioned the # 40 -> "Above 40"
                int oldNum = newRange.get(0);
                newRange.remove(0);
                newRange.add(0, oldNum + 1);
                newRange.add(120); // options w/1 number are for any age that number or greater, people probably won't be older than 120
            }
            options.add(newRange);
        }
        // select option
        System.out.println("OPTIONS: " + options.toString());
        for (int i = 0; i < options.size(); i++) {
            if (age >= options.get(i).get(0) && age <= options.get(i).get(1)) {
                System.out.println("option clicked (value attr): " + radioButtons.get(i).getAttribute("value"));
                radioButtons.get(i).click();
            }
        }
        // VERIFY
        switch (expectedAnswer) {
            case 1:
                Assert.assertTrue(Boolean.parseBoolean(radioButtons.get(0).getAttribute("checked")));
                Assert.assertFalse(Boolean.parseBoolean(radioButtons.get(1).getAttribute("checked")));
                Assert.assertFalse(Boolean.parseBoolean(radioButtons.get(2).getAttribute("checked")));
                break;
            case 2:
                Assert.assertFalse(Boolean.parseBoolean(radioButtons.get(0).getAttribute("checked")));
                Assert.assertTrue(Boolean.parseBoolean(radioButtons.get(1).getAttribute("checked")));
                Assert.assertFalse(Boolean.parseBoolean(radioButtons.get(2).getAttribute("checked")));
                break;
            case 3:
                Assert.assertFalse(Boolean.parseBoolean(radioButtons.get(0).getAttribute("checked")));
                Assert.assertFalse(Boolean.parseBoolean(radioButtons.get(1).getAttribute("checked")));
                Assert.assertTrue(Boolean.parseBoolean(radioButtons.get(2).getAttribute("checked")));
                break;
            default:
                Assert.assertTrue(false); // if the 3 cases above fail, we want to fail the test
                break;
        }
    }

    /**
     * Radio 3
     * test age: 1
     */
    @Test
    public void VerifyRadio3_AgeIs1() {
        Radio3Test(1, 1);
    }

    /**
     * Radio 3
     * test age: 20
     */
    @Test
    public void VerifyRadio3_AgeIs20() {
        Radio3Test(20, 1);
    }

    /**
     * Radio 3
     * test age: 21
     */
    @Test
    public void VerifyRadio3_AgeIs21() {
        Radio3Test(21, 2);
    }

    /**
     * Radio 3
     * test age: 40
     */
    @Test
    public void VerifyRadio3_AgeIs40() {
        Radio3Test(40, 2);
    }

    /**
     * Radio 3
     * test age: 41
     */
    @Test
    public void VerifyRadio3_AgeIs41() {
        Radio3Test(41, 3);
    }
}
