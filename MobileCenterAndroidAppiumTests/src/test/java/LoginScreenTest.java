import com.xamarin.testcloud.appium.EnhancedAndroidDriver;
import com.xamarin.testcloud.appium.Factory;
import io.appium.java_client.MobileBy;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ruslan on 6/6/17.
 */
public class LoginScreenTest {


    @Rule
    public TestWatcher watcher = Factory.createWatcher();
    private EnhancedAndroidDriver<WebElement> driver;
    private static int TimeoutInSeconds = 10;
    private WebDriverWait wait;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion","6.0");
        capabilities.setCapability("app", "/Users/ruslan/projects/MobileCenterAndroidDemo/MobileCenterAndroidAppiumTests/MobileCenterAndroidNative.apk");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("deviceOrientation", "portrait");

        driver = Factory.createAndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, TimeoutInSeconds);
    }

    @After
    public void tearDown() {
        driver.label("Stopping App");
        driver.quit();
    }

    @Test
    public void testTwitterButtonAvailability() {
        By twitterButton = MobileBy.id("com.akvelon.mobilecenterandroiddemo:id/login_twitter_button");

        Assert.assertTrue("Twitter button must exist", isElementPresent(twitterButton));

        WebElement button = driver.findElement(twitterButton);
        Assert.assertTrue("Twitter button must be displayed", button.isDisplayed());
        Assert.assertTrue("Twitter button must be enabled", button.isEnabled());

        String buttonType = button.getTagName();
        Assert.assertEquals("Twitter button must be of button type", buttonType, "android.widget.Button");
    }

    @Test
    public void testFacebookButtonAvailability() {
        By facebookButton = MobileBy.id("com.akvelon.mobilecenterandroiddemo:id/login_facebook_button");

        Assert.assertTrue("Facebook button must exist", isElementPresent(facebookButton));

        WebElement button = driver.findElement(facebookButton);
        Assert.assertTrue("Facebook button must be displayed", button.isDisplayed());
        Assert.assertTrue("Facebook button must be enabled", button.isEnabled());

        String buttonType = button.getTagName();
        Assert.assertEquals("Facebook button must be of button type", buttonType, "android.widget.Button");

        // initiating facebook login process
        button.click();

        // we have to wait before a web view is presented
        try {
            By webView = MobileBy.className("android.webkit.WebView");
            wait.until(ExpectedConditions.visibilityOfElementLocated(webView));
        } catch (TimeoutException | NoSuchElementException e) {
            Assert.fail("Couldn't found web view");
        }

        // we have to wait before the web view's content is loaded
        try {
            By facebookLogInButton = MobileBy.className("android.widget.Button");
            wait.until(ExpectedConditions.visibilityOfElementLocated(facebookLogInButton));
        } catch (TimeoutException | NoSuchElementException e) {
            Assert.fail("Couldn't found log in button on page");
        }

        try {
            By facebookRegisterButton = MobileBy.AccessibilityId("Create account");
            wait.until(ExpectedConditions.visibilityOfElementLocated(facebookRegisterButton));
        } catch (TimeoutException | NoSuchElementException e) {
            Assert.fail("Couldn't found register button on page");
        }
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
