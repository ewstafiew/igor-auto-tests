import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthTest {

    @Test    //Аннотация теста
    public void shouldAuthorizeTest() { //shouldAuthorizeTest- нзвание метода
        //открыть страницу https://github.com/
        open("https://github.com/");
        //кликнуть на кнопку sign in
        $("[href=\"/login\"]").click();
        //заполнить инпуты логина и пароля, посимвольно
        $("#login_field").sendKeys("tt998test@gmail.com");
        $("#password").sendKeys("DnS_5327");
        //нажимаем на кнопку
        $("[name=\"commit\"]").click();
        //проверяем, что мы авторизованы, shouldBe - видимый объект страницы
        $(".line-clamp-2").shouldBe(Condition.visible);
        //sleep(3000); - ожидание
    }
}
