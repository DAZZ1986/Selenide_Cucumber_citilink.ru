package gb_ru.l6_citilink_selenium;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainMenuBlock extends BasePage {
    private final String listCatalogBtnLoc = "span[class^='css-']";
    private WebElement webCatalogBtn;

    private final String listLaptopsAndComputersBtnLoc = "a[class^='css-vrsjnq'][class$='e1mnvjgw0'][data-meta-name='DesktopMenu__category--menu-item'][href='/catalog/noutbuki-i-kompyutery/?ref=mainmenu']";
    private WebElement webLaptopsAndComputersBtn;

    //private final String gameMonitorsBtn = "//span/a[@data-meta-name='DesktopMenu__sub-sub-category']/span[text()='Игровые мониторы']";
    @FindBy(xpath = "//span/a[@data-meta-name='DesktopMenu__sub-sub-category']/span[text()='Игровые мониторы']")
    private WebElement webGameMonitorsBtn;


    public MainMenuBlock(WebDriver driver) {
        super(driver);
    }


    @Step("Кликаем на кнопки: Каталог, Игроые мониторы")
    public GameMonitorsSubMenu clickCatalogBtn() throws InterruptedException {
        DesiredCapabilities dcap = new DesiredCapabilities();
        dcap.setCapability("pageLoadStrategy", "eager");

        //клик по кнопке "Каталог"
        List<WebElement> listCatalogBtn = driver.findElements(By.cssSelector(listCatalogBtnLoc));
        webCatalogBtn = listCatalogBtn.get(1);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webCatalogBtn));
        webCatalogBtn.click();
        Thread.sleep(2000);

        //навести на кнопку Ноутбуки и компьютеры
        List<WebElement> listLaptopsAndComputersBtn = driver.findElements(By.cssSelector(listLaptopsAndComputersBtnLoc));
        webLaptopsAndComputersBtn = listLaptopsAndComputersBtn.get(1);
        webDriverWait.until(ExpectedConditions.visibilityOf(webLaptopsAndComputersBtn));
        actions.moveToElement(webLaptopsAndComputersBtn)
                .build()
                .perform();

        //клик по кнопке "Игровые мониторы"
        webGameMonitorsBtn.click();
        return new GameMonitorsSubMenu(driver);
    }
}