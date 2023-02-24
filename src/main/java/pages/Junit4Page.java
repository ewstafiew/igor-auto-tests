package pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.reflect.Array.get;

public class Junit4Page {

    public SelenideElement branchSelectionButton() {

        return $(".btn.css-truncate").as("кнопка выбора веток");
    }

    public SelenideElement itemFixturesBranch() {

        return $("[href=\"https://github.com/junit-team/junit4/tree/fixtures\"]").as("элемент ветки fixtures");
    }

    public SelenideElement releasesButton() {

        return $("[href=\"/junit-team/junit4/releases\"]").as("кнопка Releases");
    }

    public SelenideElement inputFindByRelease() {

        return $("#release-filter").as("инпут поиска релизов");
    }

    public SelenideElement releaseName() {

        return $(".Link--primary").as("название релиза");
    }
}

