package UI_Runner;

import Api_Runner.ChangeSettings;
import com.hubilo.base.BaseTest;
import com.hubilo.utils.helper.DashboardAPISetter;
import com.hubilo.utils.helper.Utility;
import com.hubilo.utils.helper.apit_testdata;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static com.hubilo.utils.helper.file_locators.*;


@Feature("Verify Reception operations")
public class ReceptionExecution extends BaseTest {

    ChangeSettings changeSettings;
    @Story("Reception Functionality")
    @Description("Dashboard configuration for Reception")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, groups = {"Smoke", "Regression"}, alwaysRun = true, enabled = true)
    public void receptionInit() {
        changeSettings=new ChangeSettings();
    // booth creation
        jsonPath= JsonPath.from(Utility.getJsonString(booth_testdata));
        changeSettings.dashboardLogin().createBooth(jsonPath.getString("booth.NAME"),
                jsonPath.getString("booth.DESC"),jsonPath.getString("booth.CATEGORY"));

    // rooms creation
        jsonPath= JsonPath.from(Utility.getJsonString(room_testdata));
        changeSettings.dashboardLogin()
                .createRoom(jsonPath.getString("room.ANYONE_ROOM"),jsonPath.getString("room.ANYONE2ANYONE"),
                        jsonPath.getString("room.MOD_EMAIL"),jsonPath.getString("room.ROOM_CODE"));

    // speaker creation
        String speakerName="Speaker";
        String sRandom = String.valueOf(Utility.generateRandomNumber());
        changeSettings.dashboardLogin().createUser(speakerName+sRandom+"@hubilo.com",speakerName, sRandom,"Speaker");

   //  agenda creation
        jsonPath = JsonPath.from(Utility.getJsonString(agenda_testdata));
        changeSettings.dashboardLogin().
                searchPeople(jsonPath.getString("agenda.SPEAKER_EMAIL")).
                deleteAttendee(apit_testdata.search_peopleid.get()).
                createUser(jsonPath.getString("agenda.SPEAKER_EMAIL"), jsonPath.getString("agenda.SPEAKER_NAME"), "Mobile Automation","Speaker").
                searchSpeaker(jsonPath.getString("agenda.SPEAKER_NAME")).

                createAgenda(jsonPath.getString("agenda.HBS_AGENDA"), 0, 1).
                updateAgenda(jsonPath.getString("agenda.HBS_AGENDA"), 1, 2, true, apit_testdata.search_peopleid.get()).
                streamAgenda(apit_testdata.agendanumber.get()).

                createAgenda(jsonPath.getString("agenda.NAME"), 1, 1).
                streamAgenda(apit_testdata.agendanumber.get()).streamAgenda(apit_testdata.hbsagendanumber.get());
        reception = basePageThread.get().getReceptionPageInstance();
        lifecycle.updateTestCase(testResult -> testResult.setName("Reception configuration - from the dashboards"));
        driver.launchApp();

    }
    @Story("Reception Functionality")
    @Description("Verify reception banner")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2,  dependsOnMethods = "receptionInit", groups = {"Smoke", "Regression"}, enabled = true)
    public void verifyReceptionBanner() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify reception screen banner"));
        reception.verifyReception("verify banner");
    }

    @Story("Reception Functionality")
    @Description("Verify Live Agenda")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 3,  groups = {"Smoke", "Regression"}, dependsOnMethods = "receptionInit", enabled = true)
    public void verifyLiveAgenda() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify live agenda"));
        reception.verifyReception("verify all live session");
    }

    @Story("Reception Functionality")
    @Description("Verify all Agenda on the reception")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 4,  groups = {"Smoke", "Regression"}, dependsOnMethods = "receptionInit", enabled = true)
    public void verifyAgenda() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify all agenda"));
        reception.verifyReception("verify all session");
    }

    @Story("Reception Functionality")
    @Description("verify all room on the reception")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 5,  groups = {"Smoke", "Regression"}, dependsOnMethods = "receptionInit", enabled = true)
    public void verifyRoom() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify all room"));
         reception.verifyReception("verify all room");
    }

    @Story("Reception Functionality")
    @Description("verify all speaker on the reception")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 6,  groups = {"Smoke", "Regression"}, dependsOnMethods = "receptionInit", enabled = true)
    public void verifySpeaker() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify all speaker"));
        reception.verifyReception("verify all speaker");
    }

    @Story("Reception Functionality")
    @Description("verify all booth on the reception")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 7,  groups = {"Smoke", "Regression"}, dependsOnMethods = "receptionInit", enabled = true)
    public void verifyBooth() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify all booth"));
        reception.verifyReception("verify all booth");
    }

    @Story("Reception Functionality")
    @Description("verify all leaderboard on the reception")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 8,  groups = {"Smoke", "Regression"}, dependsOnMethods = "receptionInit", enabled = true)
    public void verifyLeaderboard() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify all leaderboard"));
        reception.verifyReception("verify all leaderboard");
    }

    @Story("Reception Functionality")
    @Description("delete created entities")
    @Severity(SeverityLevel.BLOCKER)
    @AfterClass
    public void deleteAllCreatedEntities() {
        lifecycle.updateTestCase(testResult -> testResult.setName("delete created entities"));
        changeSettings.deleteBooth(apit_testdata.boothnumber.get());
        changeSettings.deleteRoom(apit_testdata.roomnumber.get());
        changeSettings.deleteAttendee(apit_testdata.speakernumber.get());
//        for (int i = 0; i < apit_testdata.agenda_numbers.size(); i++) {
//            DashboardAPISetter.deleteAgenda(apit_testdata.agenda_numbers.get(i));
//        }
    }
}