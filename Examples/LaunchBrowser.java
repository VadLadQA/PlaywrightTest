package Examples;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LaunchBrowser {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage(); // page это страница браузера, 1 вкладка браузера

        page.navigate("https://ecommerce-playground.lambdatest.io/");
        Locator myAccount = page.locator("//a[contains(.,'My account')][@role='button']");
        myAccount.hover(); // наведение мышки на локатор
        page.click("//a[contains(.,'Login')]");
        assertThat(page).hasTitle("Account Login");
        page.getByPlaceholder("E-Mail Address").type("test2@test.com"); // заполнить поле e-mail
        page.getByPlaceholder("Password").type("password"); // заполнить поле password
        page.locator("//input[@value='Login']").click();

        // проверка наличия и теста warning-а
        assertThat(page).hasTitle("Account Login");
        Locator warning = page.locator("[class='alert alert-danger alert-dismissible']  ");
        String messageWarn = warning.textContent();
        System.out.println(messageWarn);
        assertThat(warning).containsText("No match for E-Mail Address and/or Password.");

        // полное закрытие инициализированных элементов. В большинстве случаев достаточно только последнего - playwright.close().
        page.close();
        browser.close();
        playwright.close();

    }
}
