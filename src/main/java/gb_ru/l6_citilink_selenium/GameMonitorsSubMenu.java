package gb_ru.l6_citilink_selenium;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class GameMonitorsSubMenu extends BasePage {

    private final String productBtn = "//div[contains(@data-meta-product-id, '1772343')]/a[@href='/product/monitor-sunwind-27-sun-m27bg120-chernyi-ips-8ms-16-9-hdmi-mat-250cd-1772343/']";
    @FindBy(xpath = productBtn)
    private WebElement webProductBtn;



    public GameMonitorsSubMenu(WebDriver driver) {
        super(driver);
    }



    @Step("Клик на целевую карточку товара")
    public MonitorSunWind_SUN_M27BG120 clickOnProductBtn() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5000));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productBtn)));
        webProductBtn.click();
        return new MonitorSunWind_SUN_M27BG120(driver);
    }




}
