package gb_ru.l4;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExamplesTest {


    @Test
    void assertExample() {
        //внутрь метода assertThat() мы помещаем наш фактический результат
        assertThat(Functions.isPalindrome("1235412")).isFalse(); //как читется код -
        //проверить что (такая то функция(данные)).expectedCondition/ожидаемый результат;
    }

    @Test
    void assertExample2() {
        assertThat(6).isLessThan(12).isGreaterThan(0);
    }








}
