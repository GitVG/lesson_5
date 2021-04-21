package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class githubIssueTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NNMBER = "#68";

    @Test
    @Link(name = "Base url", value = "https://github.com")
    @Owner("Tester")
    @Tags({@Tag("Web"), @Tag("critical")})
    @Feature("Issues")
    @Story("Поиск в новом репозитории")
    @DisplayName("Поиск по номеру в репозитории")
    public void testIssueSearch() {
        parameter("Repository", REPOSITORY);
        parameter("Issue Number", ISSUE_NNMBER);
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Кликаем на репозиторий" + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Переходим в раздел ссылки", () -> {
            $(withText("Issues")).click();
        });
        step("Проверяем наличие номера", () -> {
            $(withText(ISSUE_NNMBER)).should(Condition.exist);
        });


    }
}