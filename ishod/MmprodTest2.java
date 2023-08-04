package gb_ru.mmprod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static gb_ru.mmprod.Mmprod.Simple;



public class MmprodTest2 {


    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    private final static String MMPROD_BASE_URL = "https://mmprod.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //actions = new Actions(driver);
        driver.get(MMPROD_BASE_URL);
    }



    @Test
    public void assertMmprodStaticFunc() {
        int result = Simple();
        //Assertions.assertTrue(result);
        Assertions.assertEquals(4, result);

        //assertThat(Mmprod.Simple("12345412")).isFalse();
        //assertThat(6).isLessThan(10).isGreaterThan(0);

        //проверяем что форма регистрации открылась
        //boolean vis = driver.findElement(By.xpath("//div[@class='name']//a[text()='Первые блюда']")).isDisplayed();
        //Assertions.assertEquals(false, vis);
    }

    @Test
    public void assertMmprodUnStaticFunc() {
        Mmprod obj = new Mmprod();
        int res = obj.SimpleUnStatic();
        Assertions.assertEquals(4, res);
    }







}
