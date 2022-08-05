package UI_Runner;

import Api_Runner.ChangeSettings;
import com.hubilo.base.BaseTest;
import com.hubilo.utils.helper.Utility;
import com.hubilo.utils.helper.apit_testdata;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static com.hubilo.utils.helper.file_locators.booth_testdata;

/**
 * @created: 2022-06-20-12:37 AM
 * @project: Mobile_UI_Automation under @package: @package: UI_Runner
 * @author: preetam
 **/

@Feature("Virtual booth Functionality")
public class BoothExecution extends BaseTest {

    private ChangeSettings changeSettings;
    @Story("Booth Functionality")
    @Description("Dashboard confirgutaion for Booth")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, groups = {"Smoke", "Regression"}, enabled = true)
    public void boothInit() {
        jsonPath= JsonPath.from(Utility.getJsonString(booth_testdata));
        changeSettings=new ChangeSettings();
        booth = basePageThread.get().getBoothInstance();
        lifecycle.updateTestCase(testResult -> testResult.setName("Booth configuration:- creation of booth - from the dashboards"));
        }

    @Story("Booth Functionality")
    @Description("Verify booth category")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, groups = {"Smoke", "Regression"}, dependsOnMethods = "boothInit", enabled = true)
    public void verifyBoothCategory() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify booth category"));
        booth.verifyBooth("verify booth category", jsonPath.getString("booth.CATEGORY"));
    }

    @Story("Booth Functionality")
    @Description("Verify bookmark booth")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 3, groups = {"Regression"}, dependsOnMethods = "boothInit", enabled = true)
    public void verifyBoothBookmark() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify bookmark booth"));
        booth.verifyBooth("verify bookmark booth", jsonPath.getString("booth.CATEGORY"));
    }

    @Story("Booth Functionality")
    @Description("Verify unbookmark booth")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 4, groups = {"Regression"}, dependsOnMethods = "boothInit", enabled = true)
    public void verifyBoothUnBookmark() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify unbookmark booth"));
        booth.verifyBooth("verify unbookmark booth", jsonPath.getString("booth.CATEGORY"));
    }

    @Story("Booth Functionality")
    @Description("Verify booth search")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 5, groups = {"Smoke", "Regression"}, dependsOnMethods = "boothInit", enabled = true)
    public void verifyBoothSearch() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify search booth"));
        booth.verifyBooth("verify search booth", jsonPath.getString("booth.NAME"));
    }

    @Story("Booth Functionality")
    @Description("Verify booth detail page")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 6, groups = {"Smoke", "Regression"}, dependsOnMethods = "boothInit", enabled = true)
    public void verifyBoothDetailPage() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify booth detail page"));
        booth.verifyBooth("verify booth detail page", jsonPath.getString("booth.CATEGORY"));
    }

    @Story("Booth Functionality")
    @Description("verify booth lists")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 7, groups = {"Regression"}, dependsOnMethods = "boothInit", enabled = true)
    public void verifyBoothListing() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify booth lists"));
        booth.verifyBooth("verify booth lists", jsonPath.getString("booth.CATEGORY"));
    }

    @Story("Booth Functionality")
    @Description("delete created booth")
    @Severity(SeverityLevel.BLOCKER)
    @AfterClass
    public void verifyDeleteBooth() {
        lifecycle.updateTestCase(testResult -> testResult.setName("delete create booth"));
        changeSettings.deleteBooth(apit_testdata.boothnumber.get());
    }
}
