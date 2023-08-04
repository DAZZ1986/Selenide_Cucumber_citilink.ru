package gb_ru.l8_citilink_selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainMenuBlock {
    private ElementsCollection listCatalogBtn = $$(By.xpath("//a[@href='/catalog/']"));
    private SelenideElement webCatalogBtn;

    private ElementsCollection listLaptopsAndComputersBtn = $$(By.cssSelector("a[class^='css-vrsjnq'][class$='e1mnvjgw0'][data-meta-name='DesktopMenu__category--menu-item'][href='/catalog/noutbuki-i-kompyutery/?ref=mainmenu']"));
    private SelenideElement webLaptopsAndComputersBtn;

    private SelenideElement webGameMonitorsBtn = $(By.xpath("//span/a[@data-meta-name='DesktopMenu__sub-sub-category']/span[text()='Игровые мониторы']"));



    @Step("Кликаем на кнопки: Каталог, Игроые мониторы")
    public GameMonitorsSubMenu clickCatalogBtn() throws InterruptedException {
        //стратегия загрузки страницы - не ждать ее полной прогрузки
        Configuration.pageLoadStrategy = "eager";
        //клик по кнопке "Каталог"
        webCatalogBtn = listCatalogBtn.get(0);
        webCatalogBtn.click();
        Thread.sleep(2000);

        //навести на кнопку Ноутбуки и компьютеры
        webLaptopsAndComputersBtn = listLaptopsAndComputersBtn.get(1);
        webLaptopsAndComputersBtn.hover();

        //клик по кнопке "Игровые мониторы"
        webGameMonitorsBtn.click();
        return page(GameMonitorsSubMenu.class);
    }
}