package gb_ru.l8_citilink_selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private SelenideElement webEmailField = $(By.cssSelector("input[name='login']"));
    private SelenideElement webPassField = $(By.cssSelector("input[name='pass']"));

    private ElementsCollection enterBtns = $$(By.cssSelector("button[data-meta-name][data-meta-disabled='true'] > span[class^='css']"));
    private SelenideElement enterBtn = $(By.xpath("//button[@data-meta-name and @data-meta-disabled='false']/span[contains(text(),'Войти')]"));



    @Step("Авторизация")
    public MainPage login(String login, String password) throws InterruptedException {
        webEmailField.sendKeys(login);
        webPassField.setValue(password);
        //enter btn
        //enterBtn = enterBtns.last();                        //вариант 1 - взял последний веб эл.
        //enterBtn = enterBtns.findBy(Condition.text("Войти")); //вариант 2 - взял веб эл. по условию
        enterBtn.shouldBe(Condition.enabled, Duration.ofSeconds(5));
        enterBtn.shouldBe(Condition.interactable, Duration.ofSeconds(5));
        enterBtn.click();

        return page(MainPage.class);  //в selenide мы отдаем класс след. стр. вот таким вот образом
    }
}
