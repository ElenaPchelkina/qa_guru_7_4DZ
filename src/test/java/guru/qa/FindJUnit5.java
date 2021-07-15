package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FindJUnit5 {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void shouldFindJUnit5(){
        // открыть https://github.com/selenide/selenide
        open("https://github.com/selenide/selenide");
        // перейти в wiki
        $(".js-repo-nav").$(byText("Wiki")).click();
        // раскрыть список и кликнуть на SoftAssertions
        $("#wiki-pages-box").$(byText("Show 1 more pages…")).click();
        $(byText("SoftAssertions")).click();
        // проверить что внутри есть пример кода для JUnit
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }

}
