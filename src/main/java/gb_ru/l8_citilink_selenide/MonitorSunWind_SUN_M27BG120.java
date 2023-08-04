package gb_ru.l8_citilink_selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MonitorSunWind_SUN_M27BG120 {
    private SelenideElement webMinusBtn = $(By.xpath("//span//*[@href='#minus']"));
    private SelenideElement webBasketBtn = $(By.xpath("//span[text()='В корзину']"));
    private SelenideElement webContinueBtn = $(By.xpath("//span[text()='Продолжить покупки']"));




    @Step("Удаление и добавление товара в корзину")
    public MonitorSunWind_SUN_M27BG120 addToBasket() {
        try {
            webMinusBtn.shouldBe(Condition.enabled).click();
        } catch (UIAssertionError e){
            e.toString();
        }
        webBasketBtn.shouldBe(Condition.enabled).click();
        return this;
    }

    @Step("Продолжение покупок")
    public SuccessOrderMonitorSunWind_SUN_M27BG120 continueToBuying() {
        webContinueBtn.click();
        String aaa1 = "";
        return page(SuccessOrderMonitorSunWind_SUN_M27BG120.class);
    }

}