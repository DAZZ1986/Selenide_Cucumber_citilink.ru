package gb_ru.mmprod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class implicit_wait {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();  //создали объект настройки драйвера
        chromeOptions.addArguments("--disable-notifications"); //добавили настройку по отключению нотификаций на сайте
        chromeOptions.addArguments("----window-size=1400,1000"); //тут будет запускаться

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://mmprod.ru/");
        driver.manage().timeouts().getPageLoadTimeout();    //Implicit Wait (Неявное ожидание) - убогость








        Thread.sleep(5000);
        driver.quit();

    }
}

