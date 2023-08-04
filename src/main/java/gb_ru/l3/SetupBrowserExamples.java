package gb_ru.l3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupBrowserExamples {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();  //скачали chromedriver.exe и добавили путь до драйвера

        ChromeOptions chromeOptions = new ChromeOptions();     //создали объект настройки драйвера
        chromeOptions.addArguments("--disable-notifications"); //добавили настройку по отключению нотификаций на сайте
        chromeOptions.addArguments("user-agent=Googlebot/w.1 (+http://www.google.com/bot.html)");
        //chromeOptions.addArguments("--headless"); //тут будет запускаться браузер без головы, тоесть без интерфейса

        WebDriver driver = new ChromeDriver(chromeOptions);  //создали объект драйвера и передали в него как аргумент настройки
        driver.get("https://google.com");
        Thread.sleep(2000);

        driver.quit();
    }
}
