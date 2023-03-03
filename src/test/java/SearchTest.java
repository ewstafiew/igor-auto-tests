import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Owner("ewstafiew")
@Feature("Выбор ветки и Поиск")
public class SearchTest {

    @BeforeEach
    public void setup() {
        open("https://github.com/junit-team/junit4");
    }



    @Test
    @Story("Смена ветки в GitHub")
    @DisplayName("Переключение на ветку fixtures")
    public void SwitchingToTheFixturesBranch() {

        step("Кликнуть на кнопку выбора ветки", () -> {
            TestPages.junit4Page.branchSelectionButton()
                    .click();
        });

        step("Кликнуть на ветку fixtures", () -> {
            TestPages.junit4Page.itemFixturesBranch()
                    .click();
        });

        step("Открыта страница ветки fixtures", () -> {
            TestPages.junit4Page.branchSelectionButton()
                    .shouldHave(text("fixtures"));
        });
    }



    @MethodSource("searchByNameAndNumbers")
    @ParameterizedTest(name = "{displayName} {0}")
    @Story("Поиск по названию релиза на странице ветки fixtures")
    @DisplayName("Проверка поиска релизов")
    public void checkingTheReleaseSearch(String type, String searchValue) {

        step("Кликнуть на кнопку выбора ветки", () -> {
            TestPages.junit4Page.branchSelectionButton()
                    .click();
        });

        step("Кликнуть на ветку fixtures", () -> {
            TestPages.junit4Page.itemFixturesBranch()
                    .click();
        });

        step("Кликнуть по ссылке 'Releases'", () -> {
            TestPages.junit4Page.releasesButton()
                    .click();
        });

        step("Ввести в инпут 'Find a release' поисковой запрос", () -> {
            TestPages.junit4Page.inputFindByRelease()
                    .sendKeys(searchValue);
        });

        step("Нажать 'enter' на клавиатуре", () -> {
            TestPages.junit4Page.inputFindByRelease()
                    .pressEnter();
        });

        step("В поисковой выдаче отображаются релизы с искомым значением в названии", () -> {
            TestPages.junit4Page.releaseName()
                    .shouldHave(text(searchValue));
        });
    }


    static Stream<Arguments> searchByNameAndNumbers() {
        return Stream.of(
                arguments(
                        "Поисковой запрос",
                        "JUnit"
                ),
                arguments(
                        "Поисковой запрос",
                        "Beta"
                ),
                arguments(
                        "Поисковой запрос",
                        "4.12"
                )
        );
    }
}

