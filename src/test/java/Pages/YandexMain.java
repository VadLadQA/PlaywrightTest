package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class YandexMain {
    private Page page;

    public YandexMain(Page page) {
        this.page = page;
    }

    // методы
    public void open(){
        page.navigate("https://ya.ru/");
    }

    public void search(String query){
        page.getByPlaceholder("Найдётся всё").fill(query);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Найти")).click();
    }
}
