package Settings;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserManager {
    // инициализация браузера
    private Playwright playwright;
    private Browser browser;
    private Page page;

    public BrowserManager() {
        playwright = Playwright.create();
        browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    // метод, возвращаемый страницу
    public Page getPage() {
        return page;
    }

    // метод, закрывающий браузер
    public void browserClose(){
        browser.close();
        playwright.close();
    }


}
