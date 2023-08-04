package gb_ru.l6_citilink_selenium;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class SuccessOrderMonitorSunWind_SUN_M27BG120 extends BasePage {


    public SuccessOrderMonitorSunWind_SUN_M27BG120(WebDriver driver)
    {
        super(driver);
    }


    @Step("Проверка корректности URL товара")
    public SuccessOrderMonitorSunWind_SUN_M27BG120 checkProductUrl(String expectedProductUrl) {
        String url = driver.getCurrentUrl();
        Assertions.assertEquals(expectedProductUrl, url);
        return this;
    }
}
