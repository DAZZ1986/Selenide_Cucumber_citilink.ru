package gb_ru.l4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BoxTest {
    Box box;


    @Nested
    class WhenEmptyBox {
        //��� �� �������������� �������� ������ ��� ������� ������, ��� ����� �������������� ����� ������ ������ �������,
        //�� ���� ���� ������ �� ��� ���������.
        @BeforeEach
        void createEmptyBox() {
            box = new Box();
        }

                 //���� �� ������ ������� - ������ �������� �������� ������� �� ���� �� �������.
        @Test    //�������� ������������ ������ ������ ������ ��������� BoxIsEmptyExeption ��� ���������� ������� � ������ ������
        void whenDeleteBallThenException() {
            Assertions.assertThrows(BoxIsEmptyExeption.class, () -> box.deleteBall()); //�������� ��� -
        }  //���������, ��� ������������ ����������, ����� �� ��������� ����� ������ box.deleteBall() � �������, �������
           //� ��� �������������� ������. � ��� ����� ������ ��� �������� �������, �� � ������������ �� ������������� 0.





        //����� WhenOneBall �� ������� ������ ������ WhenEmptyBox, ��� ����, �����:
        //1.���������� ������ ����� ������� ������ �������� ������ � ������ ����� ��� ������� � ����� ������ ��������� ����������
        //2.� ����� ������������ ��������� @BeforeEach � ������� ���������� ������ WhenOneBall. �� ��� ������� �������
        //����������� ������ ����� ���������� ��������� @BeforeEach � ������ ��������� �� �������� ������. ������ �����
        //�������� ������ @BeforeEach void addBall(), ���������� ����� @BeforeEach void createEmptyBox().
        @Nested
        class WhenOneBall {
            //��� �� �������������� �������� ������ ��� ���� ������ ������� ������, �� ����� ������� �� ����� � �������
            //������� ����� ������ ���� ���.
            @BeforeEach
            void addBall() {
                box.addBall();
            }

            //�������� ��� �� �� ����� ���������� ����� �������� ������� �� �������, � ������� ���� ������ 1 ���.
            @Test    //�������� ������ deleteBall()
            void deleteBall() throws BoxIsEmptyExeption {
                box.deleteBall();
                Assertions.assertEquals(0, box.getBallsCount());
            }





            @Nested
            class WhenALotOfBalls {
                @BeforeEach
                void addBall() {
                    box.addBall();
                    box.addBall();
                    box.addBall();
                    box.addBall();
                }

                @Test  //��� ����� ��������� ��� ���� ����������� � ������� (�������� ������ addBall())
                void deleteBall() throws BoxIsEmptyExeption {
                    Assertions.assertEquals(5, box.getBallsCount());
                }
            }


        }





        @Nested
        class TestCl {


        }



    }
}
