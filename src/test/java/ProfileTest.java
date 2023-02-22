import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class ProfileTest {

    MainPage mainPaige = new MainPage();

    @Test
    @DisplayName("Успешная авторизация")
    public void shouldAuthorizeTest2() {
        TestPages.mainPage.mainSignInButton().click();
    }



}
