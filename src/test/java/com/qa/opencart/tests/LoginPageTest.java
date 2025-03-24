package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void loginPageNavigationTest() {
        loginPage = homePage.navigateToLoginPage();
        String actLoginPageTitle = loginPage.getLoginPageTitle();
        System.out.println("Заголовок страницы логина: " + actLoginPageTitle);
        Assert.assertEquals(actLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void forgotPwdLinkExistTest() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExists());
    }

    @Test(priority = 3)
    public void appLoginTest() {
        Assert.assertTrue(loginPage.doLogin(prop.getProperty("email").trim(), prop.getProperty("password").trim()));
    }


}
