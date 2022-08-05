package UI_Runner;

import com.hubilo.base.BasePage;
import com.hubilo.base.BaseTest;
import com.hubilo.pageobjects.functions.*;
import com.hubilo.pojo.ui.LoginData;
import com.hubilo.utils.dataProvider.DataSupplierJSON;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Feature("Event Feed Functionality")
public class EventFeedExecution extends BaseTest {

    @Story("Event feed Functionality")
    @Description("Event feed initiaization")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, groups = {"Smoke", "Regression"}, alwaysRun = true, enabled = true)
    public void eventFeedInit() {
        eventFeed = basePageThread.get().getFeedEventInstance();
        lifecycle.updateTestCase(testResult -> testResult.setName("Event feed initialization"));
    }

    @Story("Event feed Functionality")
    @Description("Verify post text")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, groups = {"Smoke", "Regression"}, dependsOnMethods = "eventFeedInit", enabled = true)
    public void verifyPostText() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify post text"));
        eventFeed.verifyFeed("post text", "Text posting");
    }

    @Story("Event feed Functionality")
    @Description("Verify post picture")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 3, groups = {"Smoke", "Regression"}, dependsOnMethods = "eventFeedInit", enabled = true)
    public void verifyPostPicture() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify post picture"));
        eventFeed.verifyFeed("post picture", "");
    }

    @Story("Event feed Functionality")
    @Description("Verify post looking for")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 4, groups = {"Smoke", "Regression"}, dependsOnMethods = "eventFeedInit", enabled = true)
    public void verifyLookingFor() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify post looking for"));
        eventFeed.verifyFeed("post looking for", "this is looking for");
    }

    @Story("Event feed Functionality")
    @Description("Verify post offering for")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 5, groups = {"Smoke", "Regression"}, dependsOnMethods = "eventFeedInit", enabled = true)
    public void verifyOfferingFor() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify post offering for"));
        eventFeed.verifyFeed("post offering for", "offering for");
    }

    @Story("Event feed Functionality")
    @Description("Verify post like")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 6, groups = {"Smoke", "Regression"}, dependsOnMethods = "eventFeedInit", enabled = true)
    public void verifyPostLike() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify post like"));
        eventFeed.verifyFeed("post like", "");
    }

    @Story("Event feed Functionality")
    @Description("Verify post comment")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 7, dependsOnMethods = "eventFeedInit", groups = {"Smoke", "Regression"}, enabled = true)
    public void verifyPostComment() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify post comment"));
        eventFeed.verifyFeed("post comment", "this is our comment");
    }
}
