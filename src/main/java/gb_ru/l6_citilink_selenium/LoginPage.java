package gb_ru.l6_citilink_selenium;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends BasePage{
    private final String emailField = "input[name='login']";
    @FindBy(css = emailField)
    private WebElement webEmailField;

    private final String passField = "input[name='pass']";
    @FindBy(css = passField)
    private WebElement webPassField;

    private final String enterBtns = "button[data-meta-name][data-meta-disabled='true'] > span[class^='css']";
    private WebElement enterBtn;



    public LoginPage(WebDriver driver) {
        super(driver);
    }



    @Step("Авторизация")
    public MainPage login(String login, String password) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(emailField)));
        webEmailField.sendKeys(login);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(passField)));
        webPassField.sendKeys(password);

        //enter btn
        List<WebElement> webEnterBtnsList = driver.findElements(By.cssSelector(enterBtns));
        enterBtn = webEnterBtnsList.get(webEnterBtnsList.size() - 1); //взял последний веб эл.
        webDriverWait.until(ExpectedConditions.elementToBeClickable(enterBtn));
        enterBtn.click();

        return new MainPage(driver);    //тут переменную driver видит только после прописывания
    }                                   //наследования extends BasePage.
}