package Tests;

import Pages.SimplePage;
import Settings.BrowserManager;
import com.microsoft.playwright.Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class SimplePageTests {
    // инициализируем переменные браузера и страницы
    private BrowserManager browserManager;
    private SimplePage simplePage;

    @Before
    public void setUp() {
        browserManager = new BrowserManager(); // создаем экземпляр браузера
        Page page = browserManager.getPage(); // вызываем метод, возвращаемый страницу
        simplePage = new SimplePage(page); // создаем экземпляр simple страницы
    }

    @Test
    public void openSimple() {
        simplePage.goToSimplePage(); // навигируемся на simple страницу
        String pageTitle = simplePage.getPage().title(); // заносим заголовок страницы в переменную
        System.out.println(pageTitle); // выводим в консоль заголовок страницы
        String expectedTitle = "Buttons | Simple Button | QA Practice"; // ожидаемое название заголовка заносим в переменную
        assertEquals("not equal", expectedTitle, pageTitle); //сравниваем с актуальным заголовком
    }

    @Test
    public void simpleClickBtn() {
        simplePage.goToSimplePage();
        simplePage.clickBtn("#submit-id-submit");
        String btnResult = simplePage.getPage().locator("#result").textContent().trim(); // получение текста кнопки с удалением всех пробелов
        System.out.println(btnResult);
        String expectedBtnName = "Submitted";
        assertEquals("not equal",expectedBtnName,btnResult);
    }

    @After
    public void closeSimple() {
        browserManager.browserClose(); // закрываем браузер

    }
}