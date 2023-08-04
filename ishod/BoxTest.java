package gb_ru.l4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BoxTest {
    Box box;


    @Nested
    class WhenEmptyBox {
        //тут мы подготовливаем тестовые данные дл€ данного класса, нам нужно гарантированно иметь именно ѕ”—“”ё коробку,
        //тк ниже тест именно на это состо€ние.
        @BeforeEach
        void createEmptyBox() {
            box = new Box();
        }

                 //тест на пустую коробку - должны получить эксепшон который мы сами же создали.
        @Test    //проверка корректности работы вызова нашего ексепшона BoxIsEmptyExeption при соблюдении услови€ в боевом методе
        void whenDeleteBallThenException() {
            Assertions.assertThrows(BoxIsEmptyExeption.class, () -> box.deleteBall()); //читаетс€ как -
        }  //проверить, что выкидываетс€ исключение, когда мы совершаем вызов метода box.deleteBall() у коробки, котора€
           //у нас гарантированно пуста€. ј она будет пуста€ при создании объекта, тк в конструкторе мы устанавливаем 0.





        //класс WhenOneBall мы вложили внутрь класса WhenEmptyBox, дл€ того, чтобы:
        //1.разделение тестов можно сделать вложив тестовые классы в разные папки или создать в одном классе несколько подклассов
        //2.и чтобы использовать аннотацию @BeforeEach у методов вложенного класса WhenOneBall. “к при запуске методов
        //внутреннего класса будут вызыватьс€ аннотации @BeforeEach и другие аннотации от внешнего класса. “оесть перед
        //запуском метода @BeforeEach void addBall(), запуститс€ метод @BeforeEach void createEmptyBox().
        @Nested
        class WhenOneBall {
            //тут мы подготовливаем тестовые данные дл€ всех тестов данного класса, тк класс заточен на тесты в коробке
            //которой лежит именно один м€ч.
            @BeforeEach
            void addBall() {
                box.addBall();
            }

            //проверим что мы не ловим исключение когда пытаемс€ удалить из коробки, в которой есть хот€бы 1 м€ч.
            @Test    //проверка метода deleteBall()
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

                @Test  //тут нужно проверить что м€чи добавл€ютс€ в коробку (проверка метода addBall())
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
