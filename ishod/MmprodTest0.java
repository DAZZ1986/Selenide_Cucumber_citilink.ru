package gb_ru.mmprod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;


public class MmprodTest0 {

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
        chromeOptions = new ChromeOptions();  //������� ������ ��������� ��������
        chromeOptions.addArguments("--disable-notifications"); //�������� ��������� �� ���������� ����������� �� �����
        chromeOptions.addArguments("----window-size=1400,1000"); //��� ����� �����������
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(MMPROD_BASE_URL);
    }



    @Test
    public void assertMmprodStaticFunc() {
        //��������� ��������� ������ ������� Simple() � ������ Mmprod
        int result = Mmprod.Simple();
        Assertions.assertEquals(4, result);
/*
        //��� ��� ������� �� ����� �� ��������  BeforeAll BeforeEach and AfterEach !
        ChromeOptions chromeOptions = new ChromeOptions();  //������� ������ ��������� ��������
        chromeOptions.addArguments("--disable-notifications"); //�������� ��������� �� ���������� ����������� �� �����
        chromeOptions.addArguments("----window-size=1400,1000"); //��� ����� �����������
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://mmprod.ru/");
        Thread.sleep(5000);
*/
        //��������� ��� �������� ������������/visible �� ��������
        boolean vis = driver.findElement(By.xpath("//img[@src='/images/category/po-tipu/pervie-bluda.png']")).isDisplayed();
        Assertions.assertEquals(true, vis);
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




    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
