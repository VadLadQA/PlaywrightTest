package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    // определяем основные локаторы на странице
    private String emailId = "//input[@placeholder='E-Mail Address']";
    private String passwordID = "//input[@placeholder='Password']";
    private String loginBtn = "//input[@value='Login']";
    private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
    private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

    // конструктор страницы
    public LoginPage(Page page) {
        this.page = page;
    }

    // методы/действия на странице (assertions добавлять в pages - bad practice!!!)
    public String getLoginPageTitle() {
        return page.title();
    }

    public boolean isForgotPwdLinkExists() {
        return page.isVisible(forgotPwdLink);
    }

    public boolean doLogin(String appEmail, String appPassword) {
        System.out.println("Креды: " + appEmail + "/" + appPassword);
        page.fill(emailId, appEmail);
        page.fill(passwordID, appPassword);
        page.click(loginBtn);
        if (page.isVisible(logoutLink)) {
            System.out.println("Юзер успешно вошел в аккаунт");
            return true;
        }
        return false;
    }

}
