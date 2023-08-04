package gb_ru.l6;

import gb_ru.l6_citilink_selenium.MainPage;
import gb_ru.l7.AdditionalLogger;
import gb_ru.l7.TestExtention;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.io.ByteArrayInputStream;

import static org.openqa.selenium.OutputType.BYTES;

@Story("Добавление товара в корзину")
@ExtendWith(TestExtention.class)    //эта аннотация не используется
public class PageObjectCitilinkTest {
    //переход на гл стр https://www.citilink.ru - ок
    //авторизация - ок
    //клик на меню "Каталог" - ок
    //Ноутбуки и компьютеры - "Игровые мониторы" - ок
    //переход на карточку https://www.citilink.ru/product/monitor-sunwind-27-sun-m27bg120-chernyi-ips-8ms-16-9-hdmi-mat-250cd-1772343/ - ок
    //клик: удалить товар из корзины, добавить в корзину - ок
    //нажать в попаппе "Продолжить покупки" - ок
    //проверка урл карточки товара https://www.citilink.ru/product/monitor-sunwind-27-sun-m27bg120-chernyi-ips-8ms-16-9-hdmi-mat-250cd-1772343/ - ок

    WebDriver driver;
    static ChromeOptions options;

    @RegisterExtension
    TestExtention watcher = new TestExtention();    //для создания скриншотов после падения, создали экз. класса

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--window-size=1350,1050");
        options.addArguments("--remote-allow-origins=*");
    }
    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new AdditionalLogger()).decorate(new ChromeDriver(options));
        driver.get("https://www.citilink.ru/");
    }



    @Test
    @DisplayName("Имя теста - доб. товара в корзину.")
    @Feature("Корзина")
    @TmsLink("123")
    void checkPayWayBySBP() throws InterruptedException {
        Allure.step("Тест стартовал.");
        new MainPage(driver)
                .clickSignInButton()
                .login("tanadana29@gmail.com", "tanadana2929D1")
                .mainMenuBlock.clickCatalogBtn()
                .clickOnProductBtn()
                .addToBasket()
                .continueToBuying()
                .checkProductUrl("https://www.citilink.ru/product/monitor-sunwind-27-sun-m27bg120-chernyi-ips-8ms-16-9-hdmi-mat-250cd-1772343/");
        Thread.sleep(1000);
        Allure.step("Тест завершен.");
    }



    @AfterEach
    void fillBrowser() {
        watcher.setScreenStream(new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(BYTES)));  //для создания скриншотов после падения

        LogEntries logggEntries = driver.manage().logs().get(LogType.BROWSER); //выводим в allure отчет ошибки из браузера из вкладки консоль
        for (LogEntry item: logggEntries) {
            Allure.addAttachment("Элемент лога браузера: ", item.getMessage());
        }

        driver.quit();
        Allure.step("Браузер уничтожен.");
    }
}