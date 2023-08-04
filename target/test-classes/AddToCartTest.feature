Feature: Имя теста - доб. товара в корзину.

  Background:
    Given Предусловие: пользователдь зашел на сайт.

  @hook
    @close
  Scenario Outline:
    When Клик на кнопку Вход
    And Авторизация
    And Кликаем на кнопки: Каталог, Игроые мониторы
    And Выбрать диагональ монитора '<Inches>'
    And Клик на целевую карточку товара '<URL>'
    And Удаление и добавление товара в корзину
    And Продолжение покупок
    Then Проверка корректности цены товара '<price>'
    Examples:
      | Inches        | URL  | price |
      | от 23" до 26" | https://www.citilink.ru/product/monitor-digma-23-8-progress-24p501f-temno-seryi-ips-led-7ms-16-9-hdmi-1895757/ | 10 890 |
      | от 27" до 30" | https://www.citilink.ru/product/monitor-sunwind-27-sun-m27bg120-chernyi-ips-8ms-16-9-hdmi-mat-250cd-1772343/   | 15 890 |
