package gb_ru.l3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); //Это путь чтобы
        //библиотека силениума знала где находится исполняемый файл хром драйвера

        WebDriver chromeDriver = new ChromeDriver(); //это экз. класса хром драйвера и именно через него мы будем обращаться к
        //библиотеки селениума, чтобы просить выполнить ту или иную команду из библиотеки.

        chromeDriver.get("https://www.google.com/"); //экз. хромдрайвер обращается к методу из библиотеки селениума на открытие
                                                //веб урл.


        //Ниже чтобы не мучиться бесконечно с перебором версий драйвера и Хрома, тк
        //Хром обновляется сам, будем работать через менеджер, который будет сам
        //скачивать нужню версию драйвра под версию моего браузера и сам
        //пропишет путь до драйвера на пк.
        WebDriverManager.firefoxdriver().setup();
        WebDriver firefoxDriver1 = new FirefoxDriver();
        firefoxDriver1.get("https://ya.ru/");


        Thread.sleep(3000);


        //chromeDriver.close();  //закрывает активную вкладку
        chromeDriver.quit();   //закрывает весь браузер
        firefoxDriver1.quit();  //закрывает браузер
    }
}
