package io.gvTests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com");
    }
    @Step("Поиск по репозиторию")
    public void searchForRepository() {
        String REPOSITORY ="GitVG/lesson_5";
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
    }
    @Step("Переходим в репозиторий")
    public void goToRepository(){
        String REPOSITORY ="GitVG/lesson_5";
        $(By.linkText(REPOSITORY)).click();
    }
    @Step("Кликаем на Issues")
    public void openRepositoryIssues(){
        $(withText("Issues")).click();
    }

    @Step("Проверяем наличие Issue")
    public void controlIssue(){
        String ISSUE_NNMBER = "#1";
        $(withText(ISSUE_NNMBER)).should(Condition.exist);
    }

}
