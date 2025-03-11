package Examples;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class TestAnnotations {

    Playwright playwright;
    Browser browser;
    Page page;

    @Before
    public void setUp(){
        playwright = Playwright.create();
        browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();

    }

    @Test
    public void verifyLogin () {
        page.navigate("http://app.vwo.com/#/login");
        page.locator("#login-username").fill("93npu2yyb0@eslix.com");
        page.locator("#login-password").fill("Wingify@123");
        page.click("#js-login-btn");
//        Assert.assertEquals("Dashboard",page.title());
    }

    @Test
    public void verivyMessage(){
        assertThat(page.locator("#js-notification-box-msg")).containsText("email");
    }

    @After
    public void testDown(){
        page.close();
    }
}
