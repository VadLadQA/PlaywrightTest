package Settings;

import Pages.PlaywrightMain;
import Pages.YandexMain;
import Pages.YandexSearch;
import com.microsoft.playwright.*;
import org.testng.annotations.BeforeSuite;

public class Config {
    // инициализация всех страниц
    protected Page page;
    protected Browser browser;
    protected BrowserContext context;
    protected YandexMain yandexMain;
    protected YandexSearch yandexSearch;
    protected PlaywrightMain playwrightMain;

    @BeforeSuite
    public void beforeSuite() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();

        yandexMain = new YandexMain(page);
        yandexSearch = new YandexSearch(page);
        playwrightMain =new PlaywrightMain(page);
    }
}
