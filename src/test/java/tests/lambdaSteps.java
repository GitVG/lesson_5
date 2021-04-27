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

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class lambdaSteps {
    private static final String REPOSITORY = "GitVG/lesson_5";
    private static final String ISSUE_NNMBER = "#1";

    @Test
    public void testIssueSearch() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $x("//*[@class = 'js-site-search-form']").click();
            $x("//input[@aria-label='Search GitHub']").setValue(REPOSITORY);
            $x("//input[@aria-label='Search GitHub']").pressEnter();
        });
        step("Кликаем на репозиторий" + REPOSITORY, () -> {
            $x("//*[@class='f4 text-normal']/a['{REPOSITORY}']").click();
        });
        step("Переходим в раздел ссылки", () -> {
            $x("//li[@class='d-flex']/a[@href='/GitVG/lesson_5/issues']").click();
        });
        step("Проверяем наличие номера", () -> {
            $x("//span[@class='opened-by']").shouldHave(text(ISSUE_NNMBER));
        });
    }
}
