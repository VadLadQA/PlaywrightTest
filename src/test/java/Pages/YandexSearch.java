package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class YandexSearch {
    private Page page;

    public YandexSearch(Page page) {
        this.page = page;
    }

    public void chkResult(String url) {
        assertThat(page.getByLabel("Результаты поиска")).containsText(url);
    }

    public Page clickResult(String urlR) {
        return page.waitForPopup(() -> {
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(urlR)).click();
        });
    }
}
