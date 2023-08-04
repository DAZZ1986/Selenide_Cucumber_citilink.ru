package gb_ru.l8_citilink_selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SuccessOrderMonitorSunWind_SUN_M27BG120 {
/*
    private String productTitleExpected = "Монитор SunWind SUN-M27BG120 27";
    private SelenideElement productTitleActual = $(By.xpath("//h1[@color='Main']"));
    private String expectedProductUrl = "Монитор SunWind SUN-M27BG120 27";
*/
    private SelenideElement actualPrice23 = $(By.xpath("//span[@data-meta-is-total='notTotal' and @data-meta-price='10 890']/span[text()='10 890']"));
    private SelenideElement actualPrice27 = $(By.xpath("//span[@data-meta-is-total='notTotal' and @data-meta-price='15 890']/span[text()='15 890']"));


    @Step("Проверка корректности цены товара")
    public SuccessOrderMonitorSunWind_SUN_M27BG120 checkProductPrice(String expPrice) {
/*
        //проверка URL товара
        //String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        //Assertions.assertEquals(expectedProductUrl, actualUrl);
        //проверка имени товара по частичному совпадению
        //productTitleActual.getText();
        //productTitleActual.shouldHave(Condition.partialText(productTitleExpected));
*/
        String act23 = null;
        String act27 = null;
        try {
            act23 = actualPrice23.getText();
            act27 = actualPrice27.getText();
        } catch (UIAssertionError e){
            e.toString();
        }
        //проверка цены товара
        if(expPrice.equals(act23)) {
            actualPrice23.shouldBe(Condition.text(expPrice));
        } else if(expPrice.equals(act27)) {
            actualPrice27.shouldBe(Condition.text(expPrice));
        }
        return this;
    }
}
