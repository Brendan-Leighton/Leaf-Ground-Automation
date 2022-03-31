package tests.page_object_models;

// SELENIUM
import org.openqa.selenium.WebElement;
// CUSTOM
import org.openqa.selenium.support.FindBy;
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
    private final String pageHomeUrl = "http://www.leafground.com/home.html";
    private final String pageLandingPageUrl = "http://www.leafground.com/";

    // CONSTRUCTOR

    public Factory__Index(String webPageUrl) {
        pageUrl = webPageUrl;
    }

    // LOCATORS & GETTERS

    @FindBy (css = "img[alt='logo Testleaf']")
    public WebElement navbarLogo;

    public WebElement getNavbarLogo() {
        return navbarLogo;
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

    /**
     * Get this site's Home URL {@link "http://www.leafground.com/"}
     * @return String : the URL
     */
    public String getUrlHome() {
        return this.pageHomeUrl;
    }

    /**
     * Test for verifying the Logo in the Navbar properly brings the user back to the Home page.
     * @param thisPagesLink Web Element : The link on the Home page that navigate to this.pageUrl
     */
    public void TestLogoToHomeButton(WebElement thisPagesLink) {
        // go to home page
        Drivers.getDriver().navigate().to(this.pageLandingPageUrl);
        // click link that navigates to this.pageUrl and assert
        Asserts.navigation_fromElement_toUrl(thisPagesLink, this.pageUrl);
        // wait for and click the logo in the navbar
        Waits.forElement_andClick(this.navbarLogo);
        // assert we made it back to the Home page
        Asserts.navigation_toUrl(this.pageHomeUrl);

    }
}

