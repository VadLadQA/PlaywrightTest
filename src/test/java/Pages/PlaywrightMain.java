package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PlaywrightMain {
    private Page page;

    public PlaywrightMain(Page page) {
        this.page = page;
    }

    public void chkPlaywPage(YandexSearch yandexSearch, String urlR, String textH1, String copyright) {
        Page page1 = yandexSearch.clickResult(urlR);

        assertThat(page1.locator("h1")).containsText(textH1);
        assertThat(page1.getByRole(AriaRole.CONTENTINFO)).containsText(copyright);
        System.out.println(page1.url());

    }
}