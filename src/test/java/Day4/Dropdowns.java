package Day4;

import com.microsoft.playwright.*;

public class Dropdowns {
    public static void main(String[] args) {
        String selectURL = "https://www.lambdatest.com/selenium-playground/select-dropdown-demo";
        String jQueryURL = "https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo";

        // launch browser - var1
//        Playwright playwright = Playwright.create();
//        Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        Page page = browser.newPage();
        // launch browser - var2
        Page page = Playwright.create().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
        page.navigate(selectURL);

        // find locator with Dropdown List by Value
        Locator dayLocator = page.locator("select#select-demo");
        dayLocator.selectOption("Wednesday");

    }
}
