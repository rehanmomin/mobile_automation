package UI_Runner;

import com.hubilo.base.BasePage;
import com.hubilo.base.BaseTest;
import com.hubilo.pageobjects.functions.*;
import com.hubilo.pojo.ui.LoginData;
import com.hubilo.utils.dataProvider.DataSupplierJSON;
import com.hubilo.utils.helper.apit_testdata;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Feature("Leaderboard Functionality")
public class LeaderboardExecution extends BaseTest{

    @Story("Leaderboard Functionality")
    @Description("Leaderboard inialization")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, groups = {"Smoke", "Regression"}, enabled = true)
    public void LeaderboardInit() {
        leaderBoard = basePageThread.get().getLeaderboardInstance();
        lifecycle.updateTestCase(testResult -> testResult.setName("Leaderboard initialization"));
    }

    @Story("Leaderboard Functionality")
    @Description("Verify Leaderboard Page UI")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2,  groups = {"Smoke", "Regression"}, dependsOnMethods = "LeaderboardInit", enabled = true)
    public void verifyLeaderboardPageUI() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify Leaderboard Page UI"));
        leaderBoard.verifyLeaderboard("Leaderboard Page");
    }

    @Story("Leaderboard Functionality")
    @Description("Verify Leaderboard Points Page UI")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 3,  groups = {"Regression"}, dependsOnMethods = "LeaderboardInit", enabled = true)
    public void verifyPointsPageUI() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify Points Page UI"));
        leaderBoard.verifyLeaderboard("Points Page");
    }

    @Story("Leaderboard Functionality")
    @Description("Verify user detail page")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 4,  groups = {"Smoke", "Regression"}, dependsOnMethods = "LeaderboardInit", enabled = true)
    public void verifyUserDetail() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify user detail"));
        leaderBoard.verifyLeaderboard("user detail");
    }

    @Story("Leaderboard Functionality")
    @Description("Verify loggin user detail")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 5,  groups = {"Smoke", "Regression"}, dependsOnMethods = "LeaderboardInit", enabled = true)
    public void verifyLogginUserDetail() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify loggin user detail"));
        leaderBoard.verifyLeaderboard("loggin user detail");
    }
}
