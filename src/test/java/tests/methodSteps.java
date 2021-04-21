package tests;

import io.gvTests.BaseSteps;
import org.junit.jupiter.api.Test;

public class methodSteps {
    public BaseSteps steps = new BaseSteps();

    @Test
    public void testIssueSearch(){
        steps.openMainPage();
        steps.searchForRepository();
        steps.goToRepository();
        steps.openRepositoryIssues();
        steps.controlIssue();


    }

}
