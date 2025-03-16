package Examples;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class CodeGen {

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
    public void codeGen () {
            page.navigate("https://www.lambdatest.com/selenium-playground/input-form-demo");
            page.getByPlaceholder("Name", new Page.GetByPlaceholderOptions().setExact(true)).click();
            page.getByPlaceholder("Name", new Page.GetByPlaceholderOptions().setExact(true)).fill("Test");
            page.getByPlaceholder("Email", new Page.GetByPlaceholderOptions().setExact(true)).click();
            page.getByPlaceholder("Email", new Page.GetByPlaceholderOptions().setExact(true)).fill("dfsd@tr.com");
            page.getByPlaceholder("Password").click();
            page.getByPlaceholder("Password").fill("123");
            page.getByPlaceholder("Company").click();
            page.getByPlaceholder("Company").fill("12");
            page.getByPlaceholder("Website").fill("4");
            page.getByRole(AriaRole.COMBOBOX).selectOption("AS");
            page.getByPlaceholder("City").click();
            page.getByPlaceholder("City").fill("4");
            page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Address\\*$"))).nth(1).click();
            page.getByPlaceholder("Address 2").fill("5");
            page.getByPlaceholder("Address 1").click();
            page.getByPlaceholder("Address 1").fill("56");
            page.getByPlaceholder("State").click();
            page.getByPlaceholder("State").fill("7");
            page.getByPlaceholder("Zip code").click();
            page.getByPlaceholder("Zip code").fill("88");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
            page.getByText("Thanks for contacting us, we").click();
            assertThat(page.getByText("Thanks for contacting us, we")).containsText("Thanks");
    }


    @After
    public void testDown(){
        page.close();
    }
}
