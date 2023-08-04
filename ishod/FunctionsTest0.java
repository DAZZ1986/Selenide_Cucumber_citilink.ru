package gb_ru.l4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static gb_ru.l4.Functions.isPalindrome;
import static org.assertj.core.api.Assertions.assertThat;

public class FunctionsTest0 {

    private static Logger logger = LoggerFactory.getLogger("FunctionsTest");

    @BeforeAll
    static void beforeAll() {
        System.out.println("Метод выполнится один раз перед всеми тестами класса.");
        logger.info("Метод выполнится один раз перед всеми тестами класса.");
    }

    @BeforeEach
    void beforeEach() {
        logger.error("Метод выполнится один раз перед всеми тестами класса.");
        //по сути суда кладем строки кода оторые в каждом тесте одинаковые и требуют инициализации каждый раз перед
        //запуском каждого теста.
    }






    //Парадигма для написания имени текста Given When Then
    //Given - что нам даное, тоесть тестовые данные
    //When - когда, тоесть что мы будем делать, тоесть вызывать метод isPalindrom
    //Then - должен вернуть true
    @Test
    @DisplayName("Метод проверки полиндрома с не четным кол-вом символов")
    void givenisPalindromeWhenCallisPalindromeThenTrue() {
        boolean result = isPalindrome("1234321");
        //Assertions.assertTrue(result);
        Assertions.assertEquals(true, result);
    }

    @Test
    @DisplayName("Метод проверки полиндрома с четным кол-вом символов")
    void givenisPalindromeWhenCallisPalindromeThenTrue1() {
        boolean result = isPalindrome("123321");
        //Assertions.assertTrue(result);
        Assertions.assertEquals(true, result);
    }







    //НИЖЕ ИСПОЛЬЗОВАЛИ ДАТА ПРОВАЙДЕРЫ (@ValueSource, @CsvSource)

    //Ниже пишем тест, без дублирования кода, как делали выше, при изменении тестовых данных,
    //а просто, будем подавать разные тестовые данные как аргументы в тестовый метод.
    @ParameterizedTest
    @ValueSource(strings = {"123321", "1234321", "1233211111"})
    void isPalindromeTestWithDataProvider(String word) {
        boolean result = isPalindrome(word);
        Assertions.assertEquals(true, result);
    }

    //Тут массив с даными которые проверяем и для каждого значения сами пишем ожидаемый результат.
    @ParameterizedTest
    @CsvSource({"123, false", "123321, true", "1, true", "22, true"})
    void csvTest(String word, boolean expectedResult) {
        boolean actualResult = isPalindrome(word);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    //Тут будем использовать в качестве источника тестовых данных реальный метод, который будет
    //сравнивать эти данные. Для этого примера создадми класс Cat, что в качестве примера
    //использовать не примитивные типы тестовых данных.
    @ParameterizedTest
    @MethodSource("catAndAgeDataProvider")
    void catEqualsAgeTest(Cat cat, Integer age) {
        Assertions.assertEquals(cat.getAge(), age);
    }

    private static Stream<Arguments> catAndAgeDataProvider() {
        return Stream.of(
                Arguments.of(new Cat("Test1", 10), 10),
                Arguments.of(new Cat("Test2", 11), 111),
                Arguments.of(new Cat("Test3", 12), 12)
        );
    }







    //Проверки через библиотеку AssertJ Core
    @Test
    void assertJ() {
        assertThat(isPalindrome("1234321")).isTrue();
    }

    //АННОТАЦИИ
    @Test
    @Disabled("Не готовы тестовые данные")  //эта аннотация выключит проверку данного тесте при запуске всех тестов класса
    void assertJDisable() {
        assertThat(isPalindrome("1234321")).isTrue();
    }

    @Test
    @Tag("smoke")  //эта аннотация является заметкой или эпиком, для разделения тестов по критериям. Запустить тесты с
        //определенным Tag можно запустить через терминал командой mvn test -D groups=smoke
    void assertJTag() {
        assertThat(isPalindrome("1234321")).isTrue();
    }








    @AfterEach
    void afterEach() {
        System.out.println("Метод выполнится 1 раз после каждого теста класса.");
        //driver.quit();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Метод выполнится один раз после всех тестов класса.");
    }
}
