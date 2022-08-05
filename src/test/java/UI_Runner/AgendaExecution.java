package UI_Runner;

import Api_Runner.ChangeSettings;
import com.hubilo.base.BaseTest;
import com.hubilo.pageobjects.functions.Profile;
import com.hubilo.utils.helper.DashboardAPISetter;
import com.hubilo.utils.helper.Utility;
import com.hubilo.utils.helper.apit_testdata;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static com.hubilo.utils.helper.file_locators.agenda_testdata;


@Feature("Verify Agenda/Session Operations")
public class AgendaExecution extends BaseTest {

    private ChangeSettings changeSettings;

    @Story("Agenda/Session Functionality")
    @Description("Dashboard configurataion for Agenda/Session")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, groups = {"Smoke", "Regression"}, alwaysRun = true, enabled = true)
    public void agendaSessionInit() {
        jsonPath = JsonPath.from(Utility.getJsonString(agenda_testdata));
        changeSettings = new ChangeSettings();

        changeSettings.dashboardLogin().
                searchPeople(jsonPath.getString("agenda.SPEAKER_EMAIL")).
                deleteAttendee(apit_testdata.search_peopleid.get()).
                createUser(jsonPath.getString("agenda.SPEAKER_EMAIL"), jsonPath.getString("agenda.SPEAKER_NAME"), "Mobile Automation","Speaker").
                searchSpeaker(jsonPath.getString("agenda.SPEAKER_NAME")).
                createAgenda(jsonPath.getString("agenda.HBS_AGENDA"), 0, 1).
                streamAgenda(apit_testdata.agendanumber.get()).
                updateAgenda(jsonPath.getString("agenda.HBS_AGENDA") + "PAST", 12, -11, true, apit_testdata.search_peopleid.get()).

                createAgenda(jsonPath.getString("agenda.HBS_AGENDA"), 0, 1).
                streamAgenda(apit_testdata.agendanumber.get()).
                updateAgenda(jsonPath.getString("agenda.HBS_AGENDA") + "FUTURE", 2, 4, true, apit_testdata.search_peopleid.get()).

                createAgenda(jsonPath.getString("agenda.HBS_AGENDA"), 0, 1).
                updateAgenda(jsonPath.getString("agenda.HBS_AGENDA"), 1, 2, true, apit_testdata.search_peopleid.get()).
                streamAgenda(apit_testdata.agendanumber.get()).

                createAgenda(jsonPath.getString("agenda.NAME"), 1, 1).
                streamAgenda(apit_testdata.agendanumber.get()).streamAgenda(apit_testdata.hbsagendanumber.get());

        agenda = basePageThread.get().getAgendaInstance();
        lifecycle.updateTestCase(testResult -> testResult.setName("Agenda configuration:- creation of session - live, past, future from the dashboard"));
    }

    @Story("Agenda/Session Functionality")
    @Description("Verify show live agenda toggle should clickable")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, groups = {"Smoke", "Regression"}, dependsOnMethods = "agendaSessionInit", enabled = true)
    public void verifyShowLiveAgendaToggle() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify show live agenda toggle should clickable"));
        agenda.goToAgendaTab();
        agenda.verifyAgenda("verify show live agenda toggle should clickable", jsonPath.getString("agenda.HBS_AGENDA"));
    }

    @Story("Agenda/Session Functionality")
    @Description("verify Agenda CTA under the session detail page")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 3, groups = {"Smoke", "Regression"}, dependsOnMethods = "agendaSessionInit", enabled = true)
    public void verifyAgendaCTA() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verifyAgendaCTA"));
        agenda.verifyAgenda("verifyAgendaCTA", jsonPath.getString("agenda.HBS_AGENDA"));
    }

    @Story("Agenda/Session Functionality")
    @Description("verify pagination for session list")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 4, groups = {"Regression"}, dependsOnMethods = "agendaSessionInit", enabled = true)
    public void verifyPaginationForSessions() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify pagination for session list"));
        agenda.verifyAgenda("verify pagination for session list", jsonPath.getString("agenda.NAME"));
    }

    @Story("Agenda/Session Functionality")
    @Description("Verify add to schedule agenda")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 5, groups = {"Regression"}, dependsOnMethods = "agendaSessionInit", enabled = true)
    public void verifyAddToScheduleAgenda() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify add to schedule agenda"));
        agenda.verifyAgenda("verify add to schedule agenda", jsonPath.getString("agenda.NAME"));
    }

    @Story("Agenda/Session Functionality")
    @Description("verify add and remove notes")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 6, groups = {"Regression"}, dependsOnMethods = "agendaSessionInit", enabled = true)
    public void verifyAddRemoveNotes() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify add and remove notes"));
        agenda.verifyAgenda("verify add and remove notes", jsonPath.getString("agenda.HBS_AGENDA"));
    }

    @Story("Agenda/Session Functionality")
    @Description("verify search session")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 7, groups = {"Smoke", "Regression"}, dependsOnMethods = "agendaSessionInit", enabled = true)
    public void verifySearchSession() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify search session"));
        agenda.verifyAgenda("verify search session", jsonPath.getString("agenda.NAME"));
    }

    @Story("Agenda/Session Functionality")
    @Description("verify engagement")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 8, groups = {"Smoke", "Regression"}, dependsOnMethods = "agendaSessionInit", enabled = true)
    public void verifyEngagements() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify engagement"));
        agenda.verifyAgenda("verify engagement", jsonPath.getString("agenda.NAME"));
    }

    @Story("Agenda/Session Functionality")
    @Description("verify added note under briefcase")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 9, groups = {"Regression"}, dependsOnMethods = "agendaSessionInit", enabled = true)
    public void verifyAgendaNotesBriefcase() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify added note under briefcase"));
        Profile profile = basePage.getUserProfileInstance();
        profile.verifyAgendaNote(jsonPath.getString("agenda.HBS_AGENDA"), jsonPath.getString("agenda.NOTE"));
    }

    @Story("Agenda/Session Functionality")
    @Description("delete created all agenda/session")
    @Severity(SeverityLevel.BLOCKER)
    @AfterClass
    public void deleteAgenda() {
        lifecycle.updateTestCase(testResult -> testResult.setName("delete created all agenda/session"));
        for (int i = 0; i < apit_testdata.agenda_numbers.size(); i++) {
            DashboardAPISetter.deleteAgenda(apit_testdata.agenda_numbers.get(i));
        }
    }
}