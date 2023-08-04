package gb_ru.l6_citilink_selenium;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MonitorSunWind_SUN_M27BG120 extends BasePage {
    private final String minusBtn = "//span//*[@href='#minus']";
    @FindBy(xpath = minusBtn)
    private WebElement webMinusBtn;

    private final String basketBtn = "//span[text()='В корзину']";
    @FindBy(xpath = basketBtn)
    private WebElement webBasketBtn;

    private final String continueBtn = "//span[text()='Продолжить покупки']";
    @FindBy(xpath = continueBtn)
    private WebElement webContinueBtn;



    public MonitorSunWind_SUN_M27BG120(WebDriver driver) {
        super(driver);
    }



    @Step("Удаление и добавление товара в корзину")
    public MonitorSunWind_SUN_M27BG120 addToBasket() {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(minusBtn)));
            webMinusBtn.click();
        } catch (Exception e){
            e.toString();
        }
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(basketBtn)));
        webBasketBtn.click();
        return this;
    }

    @Step("Продолжение покупок")
    public SuccessOrderMonitorSunWind_SUN_M27BG120 continueToBuying() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(continueBtn)));
        webContinueBtn.click();
        return new SuccessOrderMonitorSunWind_SUN_M27BG120(driver);
    }

}