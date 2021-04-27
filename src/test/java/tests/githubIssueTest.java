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
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class githubIssueTest {
     String REPOSITORY = "GitVG/lesson_5";
     String ISSUE_NNMBER = "#1";

    @Test
      public void testIssueSearch() {
        parameter("Repository", REPOSITORY);
        parameter("Issue Number", ISSUE_NNMBER);
        open("https://github.com");
        $x("//*[@class = 'js-site-search-form']").click();
        $x("//input[@aria-label='Search GitHub']").setValue(REPOSITORY);
        $x("//input[@aria-label='Search GitHub']").pressEnter();
        $x("//*[@class='f4 text-normal']/a['GitVG/lesson_5']").click();
        $x("//li[@class='d-flex']/a[@href='/GitVG/lesson_5/issues']").click();
        $x("//span[@class='opened-by']").shouldHave(text(ISSUE_NNMBER));

    }

}
