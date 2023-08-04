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
        System.out.println("����� ���������� ���� ��� ����� ����� ������� ������.");
        logger.info("����� ���������� ���� ��� ����� ����� ������� ������.");
    }

    @BeforeEach
    void beforeEach() {
        logger.error("����� ���������� ���� ��� ����� ����� ������� ������.");
        //�� ���� ���� ������ ������ ���� ������ � ������ ����� ���������� � ������� ������������� ������ ��� �����
        //�������� ������� �����.
    }






    //��������� ��� ��������� ����� ������ Given When Then
    //Given - ��� ��� �����, ������ �������� ������
    //When - �����, ������ ��� �� ����� ������, ������ �������� ����� isPalindrom
    //Then - ������ ������� true
    @Test
    @DisplayName("����� �������� ���������� � �� ������ ���-��� ��������")
    void givenisPalindromeWhenCallisPalindromeThenTrue() {
        boolean result = isPalindrome("1234321");
        //Assertions.assertTrue(result);
        Assertions.assertEquals(true, result);
    }

    @Test
    @DisplayName("����� �������� ���������� � ������ ���-��� ��������")
    void givenisPalindromeWhenCallisPalindromeThenTrue1() {
        boolean result = isPalindrome("123321");
        //Assertions.assertTrue(result);
        Assertions.assertEquals(true, result);
    }







    //���� ������������ ���� ���������� (@ValueSource, @CsvSource)

    //���� ����� ����, ��� ������������ ����, ��� ������ ����, ��� ��������� �������� ������,
    //� ������, ����� �������� ������ �������� ������ ��� ��������� � �������� �����.
    @ParameterizedTest
    @ValueSource(strings = {"123321", "1234321", "1233211111"})
    void isPalindromeTestWithDataProvider(String word) {
        boolean result = isPalindrome(word);
        Assertions.assertEquals(true, result);
    }

    //��� ������ � ������ ������� ��������� � ��� ������� �������� ���� ����� ��������� ���������.
    @ParameterizedTest
    @CsvSource({"123, false", "123321, true", "1, true", "22, true"})
    void csvTest(String word, boolean expectedResult) {
        boolean actualResult = isPalindrome(word);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    //��� ����� ������������ � �������� ��������� �������� ������ �������� �����, ������� �����
    //���������� ��� ������. ��� ����� ������� �������� ����� Cat, ��� � �������� �������
    //������������ �� ����������� ���� �������� ������.
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







    //�������� ����� ���������� AssertJ Core
    @Test
    void assertJ() {
        assertThat(isPalindrome("1234321")).isTrue();
    }

    //���������
    @Test
    @Disabled("�� ������ �������� ������")  //��� ��������� �������� �������� ������� ����� ��� ������� ���� ������ ������
    void assertJDisable() {
        assertThat(isPalindrome("1234321")).isTrue();
    }

    @Test
    @Tag("smoke")  //��� ��������� �������� �������� ��� ������, ��� ���������� ������ �� ���������. ��������� ����� �
        //������������ Tag ����� ��������� ����� �������� �������� mvn test -D groups=smoke
    void assertJTag() {
        assertThat(isPalindrome("1234321")).isTrue();
    }








    @AfterEach
    void afterEach() {
        System.out.println("����� ���������� 1 ��� ����� ������� ����� ������.");
        //driver.quit();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("����� ���������� ���� ��� ����� ���� ������ ������.");
    }
}
