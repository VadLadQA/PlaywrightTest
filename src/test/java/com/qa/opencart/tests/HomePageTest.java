package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {


    @Test
    public void homePageTitleTest() {
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test
    public void homePageUrlTest() {
        String actualUrl = homePage.getHomePageURL();
        Assert.assertEquals(actualUrl, prop.getProperty("url"));
    }

    @DataProvider
    public Object[][] getProductData() {
        return new Object[][] {
                {"Macbook"},
                {"iMac"},
                {"Samsung"}
        };
    }

    @Test(dataProvider = "getProductData")
    public void searchTest(String productName) {
        String actualSearchHeader = homePage.doSearch(productName);
        Assert.assertEquals(actualSearchHeader, "Search - " + productName);
    }

}
