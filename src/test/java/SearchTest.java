import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class SearchTest {

    @BeforeEach
    public void setup() {
        open("https://github.com/junit-team/junit4");
    }


    @Test
    @DisplayName("Переключение на ветку fixtures")
    public void SwitchingToTheFixturesBranch() {
        TestPages.junit4Page.branchSelectionButton()
                .click();
        TestPages.junit4Page.itemFixturesBranch()
                .click();
        TestPages.junit4Page.branchSelectionButton()
                .shouldHave(text("fixtures"));
    }

    @MethodSource("searchByNameAndNumbers")
    @ParameterizedTest(name = "{displayName} {0}")
    @DisplayName("проверка поиска релизов")
    public void checkingTheReleaseSearch(String type, String searchText) {
        TestPages.junit4Page.branchSelectionButton()
                .click();
        TestPages.junit4Page.itemFixturesBranch()
                .click();
        TestPages.junit4Page.releasesButton()
                .click();
        TestPages.junit4Page.inputFindByRelease()
                .sendKeys(searchText);
        TestPages.junit4Page.inputFindByRelease()
                .pressEnter();
        TestPages.junit4Page.releaseName()
                .shouldHave(text(searchText));
    }


    static Stream<Arguments> searchByNameAndNumbers() {
        return Stream.of(
                arguments(
                        "поиск по тексту в названии",
                        "JUnit"
                ),
                arguments(
                        "поиск по тексту в названии",
                        "Beta"
                ),
                arguments(
                        "поиск по цифрам в названии",
                        "4.12"
                )
        );
    }
}

