package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Asserts;
import utils.Drivers;
import utils.Urls;
import utils.Waits;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Helpers {

    /**
     * Test a broken link to verify it's broken by trying to make a connection to the link's URL.
     * @param linkElement : The element that links to another webpage.
     * @return boolean : TRUE if unable to make connection, FALSE if able to make connection.
     */
    public static boolean Link_IsUnableToMakeConnection(WebElement linkElement) {
        // SETUP
        boolean result = false;
        String urlHref = linkElement.getAttribute("href");

        // BLOOD SWEAT & TEARS
        try {
            if (urlHref != null) {
                URL url = new URL(urlHref);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                result = (urlConnection.getResponseCode() >= 400);
            }
        } catch (IOException e) {
            result = true;
        }

        //RETURN
        return result;
    }

    /**
     * Verify a broken link navigates to a 404 page. This function handles the assertion.
     * @param linkElement : The element that links to a non-existing webpage.
     */
    public static void Link_IsNavigatingTo404Page(WebElement linkElement) {
        // SETUP
        // INTERACT
        Waits.forElement_andClick(linkElement);

        // VERIFY
        Assert.assertEquals(Urls.get("404"), Drivers.getDriver().getCurrentUrl());

        // CLEANUP
        Drivers.getDriver().navigate().back(); // go back to previous page incase the test calles for more actions
    }
}
