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
        ChromeOptions chromeOptions = new ChromeOptions();  //������� ������ ��������� ��������
        chromeOptions.addArguments("--disable-notifications"); //�������� ��������� �� ���������� ����������� �� �����
        chromeOptions.addArguments("----window-size=1700,1000"); //
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        actions = new Actions(driver);
        driver.get(AFISHA_BASE_URL);
    }





    @Test
    void likeMovieTest() throws InterruptedException {
        //���� ���� �� ����������� ������ � ��������
        webDriverWait.until(d -> d.findElements(By.xpath("//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]")).size() > 0);


        //����� ��� ������ �� �������� (//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')] - ��������� ��������� �������)
        List<WebElement> filmsList = driver.findElements(By.xpath("//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]"));
        //��������� ������ ������� �� ������-�� ������� � ������� �� ��� �����
        WebElement film = filmsList.stream().filter(f -> f.getText().contains("��������")).findFirst().get();
        film.click();


        WebElement footer = driver.findElement(By.xpath("//div[contains(div, '��� ��� ������')]"));
        actions.scrollToElement(footer);
        Thread.sleep(15000);
        actions.scrollToElement(film);
        Thread.sleep(15000);
        //���� �� ������
        //WebElement filmGipnotik = driver.findElement(By.xpath("//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]//div[text()='��������']"));
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(filmGipnotik));
        //filmGipnotik.click();

        Thread.sleep(5000);


        //������� �� ������ "����"
        //driver.findElement(By.xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")).click();
        //������� � ������� ����� ����������
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'login')]")));
        //� �������� ���� ���� ��� ����� ������, ������ �������� ��� ������ ���� ������������
        //Assertions.assertEquals(driver.findElement(By.id("login")).isDisplayed(), true);
    }

    @Test
    void likeMovieTest2() throws InterruptedException {
/*
        driver.get("https://www.afisha.ru/volgograd/cinema/");
        Thread.sleep(2000);
        webDriverWait.until(d -> d.findElements(By.xpath("//div[text()='��� � ����� ����������']")).size() > 0);
        //List<WebElement> films = driver.findElements(By.xpath("//div[text()='��� � ����� ����������']"));

        WebElement pushkin = driver.findElement(By.xpath("//button[text()='���������� �����']"));
        Thread.sleep(2000);
        pushkin.click();
        Thread.sleep(5000);
*/
        //���� ���� �� ����������� ������ � ��������
        webDriverWait.until(d -> d.findElements(By.xpath("//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]")).size() > 0);
        //������� ������ ��� ����� - �� ��� ���������� �� ��������, ������ ����� ����� ������
        List<WebElement> filmList = driver.findElements(By.xpath("//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]"));
        //����� ����� ������ �����
        filmList.get(0).click();
        Thread.sleep(15000);


        //�� ��� � ������� ���� ���� ����������� ������ "����"
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")));
        //������� �� ������ "����"
        driver.findElement(By.xpath(
                "//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")).click();

        //��������� � iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'login')]")));
        //���� ����� �������� ���� � ������������
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        //��������� ��� ����� ����������� ���������
        Assertions.assertEquals(true, driver.findElement(By.id("login")).isDisplayed());

    }










    @AfterEach
    void quitBrowser() {
        driver.quit();
    }

}
