import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AuthTest {

    SelenideElement mainSignInButton = $("[href=\"/login\"]");


    //@ParameterizedTest - позволяет выполнять один и тот же тест несколько раз с разными входными данными
    @Test    //Аннотация теста
    @DisplayName("успешная авторизация")
    public void shouldAuthorizeTest() { //shouldAuthorizeTest- нзвание метода
        //открыть страницу https://github.com/
        open("https://github.com/");
        //кликнуть на кнопку sign in
        mainSignInButton.click();
        //заполнить инпуты логина и пароля, посимвольно
        $("#login_field")
                .sendKeys("tt998test@gmail.com");
        $("#password")
                .sendKeys("DnS_5327");
        //нажимаем на кнопку
        $("[name=\"commit\"]")
                .click();
        //проверяем, что мы авторизованы, shouldBe - видимый объект страницы
        $(".line-clamp-2")
                .shouldBe(Condition.visible);
        //sleep(3000); - ожидание
    }

    @MethodSource("incorrectCredentials") //указываем метод с аргументами
    @ParameterizedTest(name = "{displayName} {0}")
    @DisplayName("Авторизация с некорректными данными:")
    public void shoudntAuthorizeTest(String type, String email, String password){
        open("https://github.com/");
        mainSignInButton.click();
        $("#login_field")
                .sendKeys(email);
        $("#password")
                .sendKeys(password);
        $("[name=\"commit\"]")
                .click();
        $(".js-flash-alert")
                .shouldBe(Condition.visible);

    }


    static Stream<Arguments> incorrectCredentials() { //метод с аргументами
        return Stream.of(
                arguments(
                        "зарегистрированный логин и пароль от чужого аккаунта",
                        "tt998test@gmail.com",
                        "DnS_5320"

                ),
                arguments(
                        "незарегистрированный логин и пароль от чужого аккаунта",
                        "tt99811test@gmail.com",
                        "DnS_532011"

                )
        );
    }

}
