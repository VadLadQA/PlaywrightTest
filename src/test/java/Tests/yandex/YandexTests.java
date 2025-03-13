package Tests.yandex;

import Pages.YandexSearch;
import Settings.Config;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class YandexTests extends Config {

    // -------------пример тестов с использованием POM паттерна:
    @Test
    public void genTest() {

        yandexMain.open();
        yandexMain.search("playwright");
        yandexSearch.chkResult("playwright.dev");
        yandexSearch.clickResult("playwright.dev");
        playwrightMain.chkPlaywPage(yandexSearch, "playwright.dev", "Playwright", "Copyright © 2025 Microsoft");
    }

    @Test
    public void test2() {
        yandexMain.open();
        yandexMain.search("java");
        yandexSearch.chkResult("java");
    }

    // --------------пример сгенерированных тестов движком Playwright-а:

//        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
//                    .setHeadless(false));
//            BrowserContext context = browser.newContext();
//            Page page = context.newPage();
//            page.navigate("https://ya.ru/");
//            page.getByPlaceholder("Найдётся всё").click();
//            page.getByPlaceholder("Найдётся всё").fill("playwright");
//            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Найти")).click();
//            assertThat(page.getByLabel("Результаты поиска")).containsText("playwright.dev");
//            Page page1 = page.waitForPopup(() -> {
//                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("playwright.dev")).click();
//            });
//            assertThat(page1.locator("h1")).containsText("Playwright");
//            page1.getByText("Copyright © 2025 Microsoft").click();
//            assertThat(page1.getByRole(AriaRole.CONTENTINFO)).containsText("Copyright © 2025 Microsoft");
//            System.out.println(page1.url());
//        }
}
