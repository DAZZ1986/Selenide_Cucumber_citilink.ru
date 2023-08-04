package gb_ru.l8_citilink_selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.*;

public class GameMonitorsSubMenu  {

    private ElementsCollection listMonitorsInches = $$(By.xpath("//span[starts-with(text(), 'от ')] [not(contains(text(), 'кд'))] [not(ancestor::button)]"));
    private SelenideElement agreenmant = $(By.xpath("//span[text()='Я согласен']"));

    @Step("Выбрать диагональ монитора")
    public GameMonitorsSubMenu chooseMonitorSize(String inch) {
        //String aaa = listMonitorsInches.last().getText();
        //listMonitorsInches.last().click();
        try {
            agreenmant.click();
        } catch(UIAssertionError e) {
            e.toString();
        }
        listMonitorsInches.findBy(Condition.text(inch)).click();
        return this;
    }



    private String urlProd23 = "https://www.citilink.ru/product/monitor-digma-23-8-progress-24p501f-temno-seryi-ips-led-7ms-16-9-hdmi-1895757/";
    private String urlProd27 = "https://www.citilink.ru/product/monitor-sunwind-27-sun-m27bg120-chernyi-ips-8ms-16-9-hdmi-mat-250cd-1772343/";

    private ElementsCollection listProductBtn23 = $$(By.xpath("//div[contains(@data-meta-product-id, '1895757')]/a[@href='/product/monitor-digma-23-8-progress-24p501f-temno-seryi-ips-led-7ms-16-9-hdmi-1895757/']"));
    private ElementsCollection listProductBtn27 = $$(By.xpath("//div[contains(@data-meta-product-id, '1772343')]/a[@href='/product/monitor-sunwind-27-sun-m27bg120-chernyi-ips-8ms-16-9-hdmi-mat-250cd-1772343/']"));
    private SelenideElement webProductBtn23;
    private SelenideElement webProductBtn27;



    @Step("Клик на целевую карточку товара")
    public MonitorSunWind_SUN_M27BG120 clickOnProductBtn(String url) throws InterruptedException {
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5000));
        if(url.equals(urlProd23)) {
            webProductBtn23 = listProductBtn23.get(0);

            //scroll element to the center
            webProductBtn23.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");

            webProductBtn23.shouldBe(Condition.visible);
            webProductBtn23.shouldBe(Condition.interactable);
            webProductBtn23.click();

        } else if (url.equals(urlProd27)) {
            webProductBtn27 = listProductBtn27.get(0);

            //scroll element to the center
            webProductBtn27.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");

            webProductBtn27.shouldBe(Condition.visible);
            webProductBtn27.shouldBe(Condition.interactable);
            webProductBtn27.click();
        }
        return page(MonitorSunWind_SUN_M27BG120.class);
    }

}
