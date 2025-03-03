package Day2;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LaunchBrowser {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage(); // page это страница браузера, 1 вкладка браузера
        page.navigate("https://ecommerce-playground.lambdatest.io/");
        Locator myAccount = page.locator("//a[contains(.,'My account')][@role='button']");
        myAccount.hover();
        page.click("//a[contains(.,'Login')]");
        assertThat(page).hasTitle("Account Login");
        page.getByPlaceholder("E-Mail Address").type("test2@test.com");
        page.getByPlaceholder("Password").type("password");
        page.locator("//input[@value='Login']").click();
        assertThat(page).hasTitle("Account Login");
        Locator warning = page.locator("[class='alert alert-danger alert-dismissible']  ");
        assertThat(warning).containsText("No match for E-Mail Address and/or Password.");
        //допиши проверку наличия ошибки
        page.close();
        browser.close();
        playwright.close();

    }
}
