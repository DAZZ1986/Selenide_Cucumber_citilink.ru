package gb_ru.l3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AfishaTest {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();  //создали объект настройки драйвера
        chromeOptions.addArguments("--disable-notifications"); //добавили настройку по отключению нотификаций на сайте
        chromeOptions.addArguments("----window-size=1400,1000"); //тут будет запускаться

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.afisha.ru/volgograd/");
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5000));

        //driver.findElement(By.xpath("//button[text()='Верно']")).isDisplayed();
        //driver.findElement(By.xpath("//button[text()='Верно']")).isEnabled();
        //driver.findElement(By.xpath("//button[text()='Верно']")).click();
        Thread.sleep(15000);

        //действие над веб элементом - пишем в поле поиска
        driver.findElement(By.xpath("//input[@placeholder='Событие, актер, место']")).sendKeys("Брат");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5)); //Explicit Wait (Явное ожидание) - тут
        //создали экз. умного ожидания и если наше какое либо условие не выполниться за 5 сеукунд, то мы упадем. Тоесть условие и
        //как максимум 5 сек. ожидания и далее падаем.

        //Explicit Wait (Явное ожидание) - ждем отображение выпадающих пунктов из поиска по условию ExpectedConditions
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Брат']"))); //этот подойдет
                //если веб елемент есть в хтмл, но скрыт на странице, тоесть не видим, то в данном случае по локатору мы его найдем, тк он там есть.
                //Таким образом мы явно говорим, что мы ждем пока элемент с таким локатором станет видимым!!!!!!
                //Есть в хтмл, не видим на странице. - ждем пока появится в хтмл и станет видимым.
        //webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Брат']")))); //этот подойдет
                //в принцие не было в хтмл странице и появился в следствии каких-то действий, н/п ввод в поиск название фильма "Брат".
                //А тут мы говорим, что мы ждем пока элемент с таким локатором появится в DOM и станет видимым!!!!!!
                //Нет в хтмл, не видим на странице. - ждем пока станет видимым.

        //поиск веб элемента
        WebElement bratMovie = driver.findElement(By.xpath("//a[@title='Брат']"));
        //кликаем на найденный фильм
        bratMovie.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //это просто вариант который нам не подойдет


        Thread.sleep(15000);
        driver.quit();







        //Implicit Wait (Неявное ожидание)
        //Конфигурируется глобально — может быть изменено.
        //как сделать так чтобы неявно задать время в течении которого селениум будет производить попытки дождаться появления какого-то элемента.
        //Тоесть, не так, чтобы если сразу элемент не нашли и сразу упали, а подождать появления элемента какое-то время.
        //пример   -   где мы тут ищем определенный элемент??????????????????????????????77
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));   //это нам поможет если элемента в принципе не было на самой страничке и перед тем как окончательно упасть
                                                                            //он будет в течении 5 секунд пытаться дождаться появления элемента в html страничке. Но это нас не спасет
                                                                            //в случае если нам нужно дождаться чтобы элемент стал видимым.  видимые не видимые??????????????????????

/*      https://tproger.ru/articles/sposoby-ozhidanija-v-java-i-selenium/

        @BeforeMethod (alwaysRun = true)
        public void setUpDriver() {

            //Set up driver
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            //Set implicit waits:

            //1.wait for WebElement
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

            //2.wait for loading page
            driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

            //3.wait for an asynchronous script to finish execution
            driver.manage().timeouts().setScriptTimeout(5000, TimeUnit.MILLISECONDS);
        }

        @Test (description = "Open url")
        public void openUrl() {
           //Open browser
           driver.manage().window().setSize(new Dimension(1280, 970));
           //Get url
           driver.get("https://some_site.com");
           //Search an element
           WebElement element = driver.findElement(By.id("some-id"));
           Assert.assertTrue(element.isDisplayed());

        }

        @AfterMethod (alwaysRun = true)
        public void closeBrowser() {
        //Close browser
            driver.quit();
        }
*/









        //Explicit Wait (Явное ожидание)
        //Конфигурируется для каждого конкретного использования.
        //примеры 1
        //visibilityOf(WebElement element)       - An expectation for checking that an element, known to be present on the DOM of a page, is visible.
        //Условие что известно что БУДЕТ представлен в DOM и виден на странице UI.
        //примеры 2
        //visibilityOfElementLocated(By locator) - An expectation for checking that an element is present on the DOM of a page and visible.
        //Условие что элемент УЖЕ ЕСТЬ в DOM и виден на странице UI. Когда мы ищем элемент по локатору, он может быть видимым, не видымым, но
        //он должен присутствовать в DOM дереве. Этот способ не подойдет если веб эл. появлется в html в следствии опред. манипуляций, например
        //использование поиска и только потом подсказки появляются в html.


        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("element"));
















    }
}
