package io.gvTests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class BaseSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com");
    }
    @Step("Поиск по репозиторию")
    public void searchForRepository() {
        String REPOSITORY ="GitVG/lesson_5";
        $x("//*[@class = 'js-site-search-form']").click();
        $x("//input[@aria-label='Search GitHub']").setValue(REPOSITORY);
        $x("//input[@aria-label='Search GitHub']").pressEnter();
    }
    @Step("Переходим в репозиторий")
    public void goToRepository(){
        String REPOSITORY ="GitVG/lesson_5";
        $x("//*[@class='f4 text-normal']/a['{REPOSITORY}']").click();
    }
    @Step("Кликаем на Issues")
    public void openRepositoryIssues(){
        $x("//li[@class='d-flex']/a[@href='/GitVG/lesson_5/issues']").click();
    }

    @Step("Проверяем наличие Issue")
    public void controlIssue(){
        String ISSUE_NNMBER = "#1";
        $x("//span[@class='opened-by']").shouldHave(text(ISSUE_NNMBER));
    }

}
