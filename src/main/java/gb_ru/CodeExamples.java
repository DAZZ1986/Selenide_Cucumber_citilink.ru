package gb_ru;

public class CodeExamples {

    /*
        //добавляем куки в браузер для авторизации
        Cookie cookie = new Cookie("_identity_", "b93f798fbdd5be8aa711c4855f27b1c7332f4d4d2ec93356f6a555bf08c730afa%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3577957%2C%22OqeuUnyXgCBdXbp203Daff2u-iXn2Fye%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        //удаляем куки из браузера для логаута
        //driver.manage().deleteCookieNamed("_identity_");
        //driver.navigate().refresh();





        //переключаемся в iframe и обратно
        //пример 1
        //chromeDriver.switchTo().frame(chromeDriver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        //chromeDriver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        //выходим из iframe
        //chromeDriver.switchTo().parentFrame();
        //chromeDriver.findElement(By.xpath("login_btn")).click();

        //пример 2
        chromeDriver.switchTo().frame(chromeDriver.findElement(By.xpath("//div[@id='vk_groups']")));
        chromeDriver.findElement(By.xpath("//a[text()='Rabota.ru в Волгограде. Группа портала Rabota.ru']")).click();
        Thread.sleep(2000);
        chromeDriver.switchTo().parentFrame();






        //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='brandSlider']/div[1]/div/div/div/img)[50]")));
        //element.click();
        if (auth0.isDisplayed() && auth0.isEnabled()) {
            auth0.click();
        }
        //chromeDriver.findElement(By.xpath("//div[@class='user-profile-header__element hidden-md-and-down']//button[@aria-label='Войти']")).click();   //кнопка войти


        //изменение локатора на ходу
        chromedriver.findElement(By.xpath(String.format("//a[text()='%s']", postTitle)));   //вместо %s будет подставлено значение из переменной postTitle,
        такми образом мы можзем поменять наш локатор на ходу.

















        Заметки:
        Элементы в html страницах ::before  ::after  такие элементы найти нельзя, тк они не присутствуют в DOM дереве,
        они нужно для того, чтобы навесить на них какой либо css стиль.















    */
}
