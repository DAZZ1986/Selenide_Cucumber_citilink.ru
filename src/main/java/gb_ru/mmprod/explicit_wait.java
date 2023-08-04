package gb_ru.mmprod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class explicit_wait {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();  //создали объект настройки драйвера
        chromeOptions.addArguments("--disable-notifications"); //добавили настройку по отключению нотификаций на сайте
        chromeOptions.addArguments("----window-size=1400,1000"); //тут будет запускаться

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));  //Explicit Wait (Явное ожидание) - норм
        Actions builder = new Actions(driver);


        driver.get("https://mmprod.ru/");
        Thread.sleep(2000);

        //наведение на выпадающие пункты меню
        WebElement sub0 = driver.findElement(By.xpath("//a[@title='Рецепты блюд по ингредиентам']"));
        WebElement sub1 = driver.findElement(By.xpath("//a[@title='Рецепты блюд из мяса']//img"));

        builder
                .moveToElement(sub0)
                .moveToElement(sub1)
                .build()
                .perform();

        //Explicit Wait (явное ожидание) - тк веб элемент сабменю3 уже был в DOM дереве, но визуально его не было видно
        //тк он в выпадающем меню, нам явное ожидание подойдет.
        WebElement sub3 = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Блюда из говядины на второе']//img")));
        //клик на сабменю3
        sub3.click();

        //поиск Н1 зачем-то)
        WebElement h1 = driver.findElement(By.xpath("//h1[.='Блюда из говядины на второе']"));




        Thread.sleep(1500);
        driver.quit();
    }
}
