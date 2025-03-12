package Pages;

import com.microsoft.playwright.Page;

public class SimplePage {

    private final Page page;

    public SimplePage(Page page) {
        this.page = page;
    }

    public Page getPage() {
        return page;
    }

    // метод навигации на страницу simple
    public void goToSimplePage() {
        page.navigate("https://www.qa-practice.com/elements/button/simple"); // ссылка на страницу
    }

    // метод нажатия на кнопку Click
    public void clickBtn(String selectorBtn) {
        page.click(selectorBtn);

    }


}
