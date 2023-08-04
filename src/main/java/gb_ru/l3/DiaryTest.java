package gb_ru.l3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DiaryTest {
    public static void main(String[] args) throws InterruptedException {
        //Сценарий: зайти на сайт https://rabota.ru/, авторизоваться и что то потыкать.

        ChromeOptions chromeOptions = new ChromeOptions();  //создали объект настройки драйвера
        chromeOptions.addArguments("--disable-notifications"); //добавили настройку по отключению нотификаций на сайте
        chromeOptions.addArguments("----window-size=1400,1000"); //тут будет запускаться

        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver(chromeOptions);
        WebDriverWait webDriverWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));

        chromeDriver.get("https://volgograd.rabota.ru/");

/*      пример авторизации без использования Cookies
        WebElement auth = chromeDriver.findElement(By.xpath("//div[@class='user-profile-header__element hidden-md-and-down']//button[@aria-label='Войти']"));   //кнопка войти
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='user-profile-header__element hidden-md-and-down']//button[@aria-label='Войти']")));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='user-profile-header__element hidden-md-and-down']//button[@aria-label='Войти']")));
        auth.click();

        //ввод логина
        WebElement loginLabel = chromeDriver.findElement(By.xpath("//div[@class='input-group__input']/input[@name='login']"));
        loginLabel.sendKeys("art.murtazov@gmail.com");
        //кнопка продолжить
        chromeDriver.findElement(By.xpath("//div[@class='auth-main-step__button-content']")).click();
        Thread.sleep(5000);

        //ввод пароля
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='input-group__input']/input[@name='password']")));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='input-group__input']/input[@name='password']")));
        chromeDriver.findElement(By.xpath("//div[@class='input-group__input']/input[@name='password']")).sendKeys("dazz6891");
        //кнопка продолжить
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Продолжить']")));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Продолжить']")));
        chromeDriver.findElement(By.xpath("//button[@aria-label='Продолжить']")).click();
*/

        //пример авторизации С использованием Cookies
        //добавляем куки в браузер для авторизации
        Cookie cookie = new Cookie("sid", "e2mZIHRJFPJsvH3CUW4gcthjef4ywh9k");
        chromeDriver.manage().addCookie(cookie);
        chromeDriver.navigate().refresh();
        Thread.sleep(5000);
        WebDriver.Timeouts aaa = null;
        aaa.getPageLoadTimeout();

        //пишем в поиск "Свежие вакансии"
        chromeDriver.findElement(By.xpath("//input[@placeholder='Должность, компания']")).sendKeys("Свежие вакансии");
        chromeDriver.findElement(By.xpath("//button[text()='Найти']")).click();
        Thread.sleep(5000);

        //ищем конкретную вакансию
        String vacancyTitle = "Машинист экскаватора, водитель погрузчика";
        List<WebElement> vacancyes = chromeDriver.findElements(By.xpath("//a[@class='vacancy-preview-card__title_border']"));
        vacancyes.stream().filter(p -> p.getText().equals(vacancyTitle)).findFirst().get().click();
        Thread.sleep(5000);

        //кликаем на кнопку профессия
        chromeDriver.findElement(By.xpath("//div[@class='tabs__div']//a[@href='/career']")).click();
        Thread.sleep(5000);



        chromeDriver.quit();
    }
}
