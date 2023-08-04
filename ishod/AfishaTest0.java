package gb_ru.l5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AfishaTest0 {

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
    void likeMovieTest() throws InterruptedException {
        //ждем пока не прогрузится список с фильмами
        webDriverWait.until(d -> d.findElements(By.xpath("//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]")).size() > 0);


        //нашли все фильмы на странице (//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')] - применяем несколько условий)
        List<WebElement> filmsList = driver.findElements(By.xpath("//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]"));
        //фильтруем список фильмов по какому-то запросу и кликаем на наш фильм
        WebElement film = filmsList.stream().filter(f -> f.getText().contains("Гипнотик")).findFirst().get();
        film.click();


        WebElement footer = driver.findElement(By.xpath("//div[contains(div, 'Для лиц старше')]"));
        actions.scrollToElement(footer);
        Thread.sleep(15000);
        actions.scrollToElement(film);
        Thread.sleep(15000);
        //клик по фильму
        //WebElement filmGipnotik = driver.findElement(By.xpath("//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]//div[text()='Гипнотик']"));
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(filmGipnotik));
        //filmGipnotik.click();

        Thread.sleep(5000);


        //кликаем на кнопку "Лайк"
        //driver.findElement(By.xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")).click();
        //переход в айфрейм формы аторизации
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'login')]")));
        //в айфрейме ищем поле для ввода логина, делаем проверку что данное поле отображается
        //Assertions.assertEquals(driver.findElement(By.id("login")).isDisplayed(), true);
    }

    @Test
    void likeMovieTest2() throws InterruptedException {
/*
        driver.get("https://www.afisha.ru/volgograd/cinema/");
        Thread.sleep(2000);
        webDriverWait.until(d -> d.findElements(By.xpath("//div[text()='Яга и книга заклинаний']")).size() > 0);
        //List<WebElement> films = driver.findElements(By.xpath("//div[text()='Яга и книга заклинаний']"));

        WebElement pushkin = driver.findElement(By.xpath("//button[text()='Пушкинская карта']"));
        Thread.sleep(2000);
        pushkin.click();
        Thread.sleep(5000);
*/
        //ждем пока не прогрузится список с фильмами
        webDriverWait.until(d -> d.findElements(By.xpath("//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]")).size() > 0);
        //находим нужный нам фильм - тк они рандомятся на странице, просто берем самый первый
        List<WebElement> filmList = driver.findElements(By.xpath("//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]"));
        //берем самый первый фильм
        filmList.get(0).click();
        Thread.sleep(15000);


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










    @AfterEach
    void quitBrowser() {
        driver.quit();
    }

}
