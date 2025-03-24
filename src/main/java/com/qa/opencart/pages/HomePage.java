package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;

    // определяем основные локаторы на странице
    private String search = "input[name='search']";
    private String searchIcon = "div#search button";
    private String searchPageHeader = "div#content h1";
    private String myAccLink = "//span[normalize-space()='My Account']";
    private String loginLink = "//a[normalize-space(text())='Login']";

    // конструктор страницы
    public HomePage(Page page) {
        this.page = page;
    }

    // методы/действия на странице (assertions добавлять в pages - bad practice!!!)
    public String getHomePageTitle() {
        String title = page.title();
        System.out.println("Заголовок страницы: " + title);
        return title;
    }

    public String getHomePageURL() {
        String url = page.url();
        System.out.println("ссылка: " + url);
        return url;
    }

    public String doSearch(String productName) {
        page.fill(search, productName);
        page.click(searchIcon);
        String header = page.textContent(searchPageHeader);
        System.out.println("Заголовок в результатах поиска: " + header);
        return header;
    }

    public LoginPage navigateToLoginPage() {
        page.click(myAccLink);
        page.click(loginLink);
        return new LoginPage(page);
    }
}
