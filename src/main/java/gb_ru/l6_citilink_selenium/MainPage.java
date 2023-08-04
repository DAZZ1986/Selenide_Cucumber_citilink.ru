package gb_ru.l6_citilink_selenium;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BasePage {
    public MainMenuBlock mainMenuBlock;

    private final String attr = "a[class^='css'][href='tel:+78442433333']";

    private final String signInButton = "div[data-meta-name='UserButtonContainer']:nth-child(1)";
    @FindBy(css = signInButton)
    private WebElement webSignInButton;


    public MainPage(WebDriver driver) {
        super(driver);
        mainMenuBlock = new MainMenuBlock(driver);
    }


    @Step("Клик на кнопку Вход")
    public LoginPage clickSignInButton() {
        //DesiredCapabilities dcap = new DesiredCapabilities();
        //dcap.setCapability("pageLoadStrategy", "eager");
        //String aaa = "asd";
        //ждем пока загрузится эл. с телефоном
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(attr)));
        //просто тестовая проверка по наличию атрибута в веб элементе
        //webDriverWait.until(ExpectedConditions.attributeContains(By.cssSelector(attr), "href", "tel:+78442433333"));
        //клик на кнопку войти
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signInButton)));
        webSignInButton.click();
        return new LoginPage(driver);
    }
}