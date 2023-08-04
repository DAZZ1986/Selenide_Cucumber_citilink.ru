package gb_ru.l7;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.ByteArrayInputStream;

//для создания скриншотов после падения
public class TestExtention implements TestWatcher {
    ByteArrayInputStream screenStream;

    public void setScreenStream(ByteArrayInputStream screenStream) {
        this.screenStream = screenStream;
    }

    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.addAttachment("Скриншот перед закрытием браузера: ", screenStream);
        System.out.println("Тест упал!");
    }
}
