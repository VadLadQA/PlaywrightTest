package com.qa.opencart.factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    // инициализация браузера

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public Page initBrowser(String browserName) {
        System.out.println("Браузер: " + browserName);
        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome ").setHeadless(false));
                break;

            default:
                System.out.println("Неверное имя браузера. Введите корректное имя браузера...");
                break;
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("https://naveenautomationlabs.com/opencart/");

        return page;
    }
}
