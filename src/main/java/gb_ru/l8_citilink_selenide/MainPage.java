package gb_ru.l8_citilink_selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class MainPage {
    private SelenideElement webAttr = $(By.cssSelector("a[class^='css'][href='tel:+78442433333']"));
    private SelenideElement webSignInButton = $(By.cssSelector("div[data-meta-name='UserButtonContainer']:nth-child(1)"));



    @Step("Клик на кнопку Вход")
    public LoginPage clickSignInButton() {
        //ждем пока загрузится эл. с телефоном
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(attr)));
        webAttr.shouldBe(Condition.visible);

        //просто тестовая проверка по наличию атрибута в веб элементе
        //webDriverWait.until(ExpectedConditions.attributeContains(By.cssSelector(attr), "href", "tel:+78442433333"));
        webAttr.shouldHave(attribute("href", "tel:+78442433333"));

        //клик на кнопку войти
        webSignInButton.click();
        return page(LoginPage.class);
    }
}