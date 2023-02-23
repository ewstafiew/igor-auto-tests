import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;


public class AuthTest {

    @BeforeEach
    public void setup() {
        open("https://github.com/junit-team/junit4/tree/fixtures");
    }

    @Test    //Аннотация теста
    @DisplayName("проверка ")
    public void shouldAuthorizeTest() {

        TestPages.junit4Page.releasesButton()
                .click();
        TestPages.junit4Page.inputFindByRelease()
                .click();

        sleep(2000);


        //$(".line-clamp-2")
                //.shouldBe(Condition.visible);

    }

}
