package gb_ru.l4;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExamplesTest {


    @Test
    void assertExample() {
        //������ ������ assertThat() �� �������� ��� ����������� ���������
        assertThat(Functions.isPalindrome("1235412")).isFalse(); //��� ������� ��� -
        //��������� ��� (����� �� �������(������)).expectedCondition/��������� ���������;
    }

    @Test
    void assertExample2() {
        assertThat(6).isLessThan(12).isGreaterThan(0);
    }








}
