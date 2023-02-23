package pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class Junit4Page {

    public SelenideElement releasesButton() {

        return $("[href=\"/junit-team/junit4/releases\"]").as("кнопка Releases");
    }

    public SelenideElement inputFindByRelease() {

        return $("#release-filter").as("инпут поиска релизов");






    }

}

