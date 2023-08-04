package gb_ru.l5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.dom.model.ShadowRootType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AfishaTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    private final static String AFISHA_BASE_URL = "https://www.afisha.ru/volgograd/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();  //создали объект настройки драйвера
        chromeOptions.addArguments("--disable-notifications"); //добавили настройку по отключению нотификаций на сайте
        chromeOptions.addArguments("----window-size=1700,1000"); //
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        actions = new Actions(driver);
        driver.get(AFISHA_BASE_URL);
    }






    @Test
    void likeMovieTest() {
        //ждем пока не прогрузится список с фильмами //a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]
        webDriverWait.until(d -> d.findElements(By.xpath("//a[@data-test='LINK ITEM-URL' and contains(@href, 'movie')]")).size() > 0);
        //находим нужный нам фильм - тк они рандомятся на странице, просто берем самый первый
        List<WebElement> filmList = driver.findElements(By.xpath("//a[@data-test='LINK ITEM-URL' and contains(@href, 'movie')]"));
        //берем самый первый фильм
        filmList.get(0).click();

        //на стр с фильмом ждем пока прогрузится кнопка "Лайк"
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")));
        //кликаем на кнопку "Лайк"
        driver.findElement(By.xpath(
                "//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")).click();

        //переходим в iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'login')]")));
        //ждем когда появится поле с регистрацией
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        //проверяем что форма регистрации открылась
        Assertions.assertEquals(true, driver.findElement(By.id("login")).isDisplayed());
    }

    @Test
    void hoverCinemaButtonAndClickOkkoLinkTest() throws InterruptedException {
/*
        //тк эти два попапа появляются не всегда то нужно завернуть ожилания visibilityOf через try catch чтобы не падать.
        WebElement city = driver.findElement(By.xpath("//button[text()='Верно']"));
        webDriverWait.until(ExpectedConditions.visibilityOf(city)).click();
        WebElement discount = driver.findElement(By.xpath("//div[@class='popmechanic-close']"));
        webDriverWait.until(ExpectedConditions.visibilityOf(discount)).click();
*/
        //scroll
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(
                "//button[text()='Подписаться']")));
        Thread.sleep(5000);

        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Верно']"))).click();
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='popmechanic-close']"))).click();
        } catch(Exception e){
            System.out.println(e.toString());
        }

        actions.moveToElement(driver.findElement(By.xpath("//nav/a[@href='/volgograd/cinema/']")))  //действие (стройка)
                .clickAndHold(driver.findElement(By.xpath("//nav/a[@href='/volgograd/cinema/']")))  //действие (стройка)
                .build()    //этот метод говорит что мы завершили стройку
                .perform(); //метод нужен для завершения, без него ничего не произойдет

        driver.findElement(By.xpath("//a[text()='Скоро онлайн в Okko' and @data-test='LINK']")).click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        //Thread.sleep(8000);
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.afisha.ru/movie/okko-soon/");
        Thread.sleep(5000);

        //remove element
        WebElement locateElement = driver.findElement (By.xpath ("//div[@data-test='SIDEBAR']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].remove();", locateElement);

        Thread.sleep(5000);
    }











    @AfterEach
    void quitBrowser() {
        driver.quit();
    }

}
