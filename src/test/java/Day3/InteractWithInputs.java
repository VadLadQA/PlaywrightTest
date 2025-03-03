package Day3;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InteractWithInputs {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        // check the text of message
        page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        page.locator("input#user-message").type("Hello Man");
        page.locator("id=showInput").click();
        String message = page.locator("#message").textContent();
        System.out.println(message);
        assertThat(page.locator("#message")).hasText("Hello Man");

        // type vs fill
        page.navigate("https://www.lambdatest.com/selenium-playground/generate-file-to-download-demo");
        page.locator("#textbox").fill("Data entered in the below textarea will be download with file name 'Lambdainfo.txt'. Data entered in the below textarea will be download with file name 'Lambdainfo.txt'.");

        // get input values
        page.navigate("https://letcode.in/edit");
        String inputValue = page.locator("#getMe").inputValue();
        System.out.println(inputValue);

        String placeholderValue = page.locator("#fullName").getAttribute("placeholder");
        System.out.println(placeholderValue);

        Locator fullNameLocator = page.locator("#fullName");
        assertThat(fullNameLocator).hasAttribute("placeholder","Enter first & last name");

        // clear default value in the field
        page.locator("id=clearMe").clear();

        // checkbox
        page.navigate("https://www.lambdatest.com/selenium-playground/checkbox-demo");
        Locator isAge = page.locator("#isAgeSelected");
        assertThat(isAge).not().isChecked();
        isAge.check();
        assertThat(isAge).isChecked();

        playwright.close();
    }
}
