package Examples;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Screenshots {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(true));
        Page page = browser.newPage();
        page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        System.out.println(page.title());

        // screenshot
        Page.ScreenshotOptions scrshtOptions = new Page.ScreenshotOptions();
        page.screenshot(scrshtOptions.setPath(Paths.get("./snaps/scr.png")));

        // full screenshot
        page.screenshot(scrshtOptions.setFullPage(true).setPath(Paths.get("./snaps/fullscreen.jpg")));

        // locator screenshot
        Locator bookBtn = page.locator("//button[normalize-space(text())='Book a Demo']");
        bookBtn.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./snaps/locator.png")));
        Locator header = page.locator("#header");
        header.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./snaps/header.png")));



        page.close();
        playwright.close();

    }
}
