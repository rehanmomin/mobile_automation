package UI_Runner;

import Api_Runner.ChangeSettings;
import com.hubilo.base.BasePage;
import com.hubilo.base.BaseTest;
import com.hubilo.pageobjects.functions.LoginPage;
import com.hubilo.pageobjects.functions.Lounge;
import com.hubilo.pageobjects.functions.MultiEvent;
import com.hubilo.pageobjects.functions.Profile;
import com.hubilo.pojo.ui.LoginData;
import com.hubilo.utils.dataProvider.DataSupplierJSON;
import com.hubilo.utils.helper.Utility;
import com.hubilo.utils.helper.apit_testdata;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static com.hubilo.utils.helper.file_locators.agenda_testdata;
import static com.hubilo.utils.helper.file_locators.lounge_testdata;

/**
 * @created: 2022-06-20-12:37 AM
 * @project: Mobile_UI_Automation under @package: @package: UI_Runner
 * @author: preetam
 **/

@Feature("Lounge Functionality")
public class LoungeExecution extends BaseTest {
    private ChangeSettings changeSettings;
    @Story("Verify Lounge")
    @Description("Dashboard confirgutaion for Lounge")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, groups = {"Smoke", "Regression"}, enabled = true)
    public void loungeInit() {
        jsonPath= JsonPath.from(Utility.getJsonString(lounge_testdata));
        changeSettings=new ChangeSettings();
        changeSettings.dashboardLogin().createLounge(jsonPath.getString("lounge.NAME"),"","");
        lounge = basePageThread.get().getLoungeInstance();
        lifecycle.updateTestCase(testResult -> testResult.setName("Lounge configuration:- creation of lounge - from the dashboards"));
    }

    @Story("Verify Lounge")
    @Description("verify lounge screen")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, groups = {"Smoke", "Regression"}, dependsOnMethods = "loungeInit", enabled = true)
    public void verifyLoungeScreen() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify lounge screen"));
        lounge.verifyLounge("verify lounge screen",jsonPath.get("lounge.NAME"));
    }

    @Story("Verify Lounge")
    @Description("verify lounge grab seat")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 3, groups = {"Smoke", "Regression"}, dependsOnMethods = "loungeInit", enabled = true)
    public void verifyGrabSeat() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify user able to grab seat"));
        lounge.verifyLounge("verify user able to grab seat",jsonPath.get("lounge.NAME"));
    }

    @Story("Verify Lounge")
    @Description("verify after grab seat lounge")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 4, groups = {"Smoke", "Regression"}, dependsOnMethods = "loungeInit", enabled = true)
    public void verifyImageAfterGrabSeat() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify user image visible after grab seat"));
        lounge.verifyLounge("verify user image visible after grab seat",jsonPath.get("lounge.NAME"));
    }

    @Story("Verify Lounge")
    @Description("verify active after grab seat")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 5, groups = {"Smoke", "Regression"},  dependsOnMethods = "loungeInit", enabled = true)
    public void verifyActiveAfterGrabSeat() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify active lounge after grab seat"));
        lounge.verifyLounge("verify active lounge after grab seat",jsonPath.get("lounge.NAME"));
    }

    @Story("Verify Lounge")
    @Description("verify leave table")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 6, groups = {"Smoke", "Regression"}, dependsOnMethods = "loungeInit", enabled = true)
    public void verifyLeaveTable() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify user able to leave table"));
        lounge.verifyLounge("verify user able to leave table",jsonPath.get("lounge.NAME"));
    }

    @Story("Verify Lounge")
    @Description("verify no active tables")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 7, groups = {"Regression"}, dependsOnMethods = "loungeInit", enabled = true)
    public void verifyNoActiveTables() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify error message if no active louges"));
        lounge.verifyLounge("verify error message if no active louges",jsonPath.get("lounge.NAME"));
    }

    @Story("Verify Lounge")
    @Description("verify lounge list")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 8, groups = {"Regression"}, dependsOnMethods = "loungeInit", enabled = true)
    public void verifyListLounge() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify lounge list"));
        lounge.verifyLounge("verify lounge list",jsonPath.get("lounge.NAME"));
    }
    @Story("Verify Lounge")
    @Description("delete created lounges")
    @Severity(SeverityLevel.BLOCKER)
    @AfterClass
    public void deleteLounge() {
        lifecycle.updateTestCase(testResult -> testResult.setName("delete created lounges"));
        changeSettings.deleteLounge();
    }

}
