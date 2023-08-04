package gb_ru.mmprod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;


public class MmprodTest {

    WebDriver driver;
    ChromeOptions chromeOptions;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String MMPROD_BASE_URL = "https://mmprod.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setBrowser() {
        chromeOptions = new ChromeOptions();  //создали объект настройки драйвера
        chromeOptions.addArguments("--disable-notifications"); //добавили настройку по отключению нотификаций на сайте
        chromeOptions.addArguments("----window-size=1400,1000"); //тут будет запускаться
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(MMPROD_BASE_URL);
    }



    @Test
    public void assertMmprodStaticFunc() {
        //проверяем результат работы функции Simple() в классе Mmprod
        int result = Mmprod.Simple();
        Assertions.assertEquals(4, result);
/*
        //ЭТО тут добавил тк нихуя не работают  BeforeAll BeforeEach and AfterEach !
        ChromeOptions chromeOptions = new ChromeOptions();  //создали объект настройки драйвера
        chromeOptions.addArguments("--disable-notifications"); //добавили настройку по отключению нотификаций на сайте
        chromeOptions.addArguments("----window-size=1400,1000"); //тут будет запускаться
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://mmprod.ru/");
        Thread.sleep(5000);
*/
        //проверяем что картинка отображается/visible на странице
        boolean vis = driver.findElement(By.xpath("//img[@src='/images/category/po-tipu/pervie-bluda.png']")).isDisplayed();
        Assertions.assertEquals(true, vis);
        boolean click = driver.findElement(By.xpath("//img[@src='/images/category/po-tipu/pervie-bluda.png']")).isEnabled();
        Assertions.assertEquals(true, click);
        boolean select = driver.findElement(By.xpath("//img[@src='/images/category/po-tipu/pervie-bluda.png']")).isSelected();
        Assertions.assertEquals(false, select);
    }

    @Test
    public void assertMmprodUnStaticFunc() {
        Mmprod obj = new Mmprod();
        int res = obj.SimpleUnStatic();
        Assertions.assertEquals(4, res);
    }

    @Test
    public void assertj() {
        assertThat(Mmprod.Simple()).isEqualTo(4);
        assertThat(6).isLessThan(10).isGreaterThan(0);
    }




    @Test
    public void actionsTest1() throws InterruptedException {
        Thread.sleep(8000);
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Рецепты блюд по ингредиентам']")));
        actions.moveToElement(driver.findElement(By.xpath("//a[@title='Рецепты блюд по ингредиентам']")))  //действие (стройка)
                .clickAndHold(driver.findElement(By.xpath("//a[@title='Рецепты блюд по ингредиентам']")))  //действие (стройка)
                .build()    //этот метод говорит что мы завершщили стройку
                .perform(); //метод нужен для завершения, без него ничего не произойдет
        Thread.sleep(8000);
    }




    @Test
    public void actionsTest2() throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        ((JavascriptExecutor)driver).executeScript("\"Let element = document.evaluate(\\\"//img[@src='/images/category/po-tipu/pervie-bluda.png']\\\", document, null, element.singleNodeValue.remove()\"");
        Thread.sleep(3000);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Карта сайта']")));
        WebElement footer = driver.findElement(By.xpath("//a[.='Карта сайта']"));
        footer.click();
        Thread.sleep(3000);
    }





    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
