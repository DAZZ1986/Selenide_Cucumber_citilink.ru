package gb_ru.l8_cucumber;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import gb_ru.l8_citilink_selenide.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class CucumberStepDefinitionTest {
    @Given("Предусловие: пользователдь зашел на сайт.")
    public void предусловиеПользователдьЗашелНаСайт() {
        Configuration.timeout = 5000;
        Configuration.pageLoadStrategy = "eager";
        open("https://www.citilink.ru/");
    }

    @When("^Клик на кнопку Вход$")
    public void кликНаКнопкуВход() {
        new MainPage().clickSignInButton();
    }

    @And("^Авторизация$")
    public void авторизация() throws InterruptedException {
        new LoginPage().login("tanadana29@gmail.com", "tanadana2929D1");
    }

    @And("^Кликаем на кнопки: Каталог, Игроые мониторы$")
    public void кликаемНаКнопкиКаталогИгроыеМониторы() throws InterruptedException {
        new MainMenuBlock().clickCatalogBtn();
    }

    @And("Выбрать диагональ монитора {string}")
    public void выбратьДиагональМонитора(String inch) {
        new GameMonitorsSubMenu().chooseMonitorSize(inch);
    }

    @And("Клик на целевую карточку товара {string}")
    public void кликНаЦелевуюКарточкуТовараURL(String URL) throws InterruptedException {
        new GameMonitorsSubMenu().clickOnProductBtn(URL);
    }

    @And("^Удаление и добавление товара в корзину$")
    public void удалениеИДобавлениеТовараВКорзину() {
        new MonitorSunWind_SUN_M27BG120().addToBasket();
    }

    @And("^Продолжение покупок$")
    public void продолжениеПокупок() {
        new MonitorSunWind_SUN_M27BG120().continueToBuying();
    }

    @Then("Проверка корректности цены товара {string}")
    public void проверкаКорректностиЦеныТовараPrice(String price) {
        new SuccessOrderMonitorSunWind_SUN_M27BG120().checkProductPrice(price);
    }

    @After(value = "@close")
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

}
