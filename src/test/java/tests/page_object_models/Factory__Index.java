package tests.page_object_models;

// SELENIUM
import org.openqa.selenium.WebElement;
// CUSTOM
import utils.Asserts;
import utils.Drivers;
import utils.Waits;

/**
 * <h3>WebPageFactory METHODS:</h3>
 * <ul>
 *      <li>getUrl(): gets this pages url</li>
 *      <li>getHomeUrl(): gets LeafGround's Home url</li>
 *      <li>navigateTo(): navigate to this page,
 *          <ol>
 *              <li>Go to LeafGround's Home-page</li>
 *              <li>click on the image that links to this page</li>
 *          </ol>
 *      </li>
 * </ul>
 */
public abstract class Factory__Index {
    // PROPS
    private final String pageUrl;
    private final String pageHomeUrl = "http://www.leafground.com/";

    // CONSTRUCTOR
    public Factory__Index(String webPageUrl) {
        pageUrl = webPageUrl;
    }

    /**
     * <h1>Navigate to this page</h1>
     * <ol>
     *     <li>Go to website's homepage</li>
     *     <li>Click on this page's link</li>
     * </ol>
     */
    public void navigateTo(WebElement thisPagesLink) {
        Drivers.getDriver().navigate().to(this.pageHomeUrl); // navigate to home page
        Asserts.navigation_toUrl(this.pageHomeUrl);          // wait for page load and assert correct url
        Waits.forElement_andClick(thisPagesLink);            // wait for element to be clickable and click
        Asserts.navigation_toUrl(this.pageUrl);              // assert url navigated to is this page's url
    }

    /**
     * Get this page's URL
     * @return String : the URL
     */
    public String getUrl() {
        return this.pageUrl;
    }
}

