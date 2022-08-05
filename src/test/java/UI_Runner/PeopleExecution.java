package UI_Runner;

import Api_Runner.ChangeSettings;
import com.hubilo.base.BasePage;
import com.hubilo.base.BaseTest;
import com.hubilo.pageobjects.functions.LoginPage;
import com.hubilo.pageobjects.functions.MultiEvent;
import com.hubilo.pageobjects.functions.People;
import com.hubilo.pageobjects.functions.Profile;
import com.hubilo.pojo.ui.LoginData;
import com.hubilo.utils.dataProvider.DataSupplierJSON;
import com.hubilo.utils.helper.Utility;
import com.hubilo.utils.helper.apit_testdata;
import io.qameta.allure.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@Feature("Verify People operations")
public class PeopleExecution extends BaseTest {

    private People people;
    private String attendeeName="Attendee", speakerName="Speaker";
    ChangeSettings changeSettings;

    @Story("Speaker/Attendee Functionality")
    @Description("Dashboard configuration for People")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, groups = {"Smoke", "Regression"}, enabled = true)
    public void peopleInit() {
        changeSettings = new ChangeSettings();
        String sRandom = String.valueOf(Utility.generateRandomNumber());
        changeSettings.dashboardLogin().createUser(attendeeName+sRandom+"@hubilo.com",attendeeName, sRandom,"Attendee");
        attendeeName = attendeeName+" "+sRandom;
        changeSettings.dashboardLogin().createUser(speakerName+sRandom+"@hubilo.com",speakerName, sRandom,"Speaker");
        speakerName = speakerName+" "+sRandom;
        people = basePageThread.get().getPeopleInstance();
        lifecycle.updateTestCase(testResult -> testResult.setName("People configuration:- creation and deletion of Attendee/Speaker - from the dashboards"));

    }

    @Story("Speaker/Attendee Functionality")
    @Description("Verify speaker and attended tabs")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifySpeakerAttendeeTabs() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker and attended tabs"));
        people.verifyPeople("verify speaker and attendee tabs","people","");
    }

    @Story("Speaker/Attendee Functionality")
    @Description("Verify speaker and attended tabs")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifyMessageBookmark() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker and attended tabs"));
        people.verifyUIMessageBookmark(attendeeName);
    }

    @Story("Speaker/Attendee Functionality")
    @Description("Verify speaker and attended tabs")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifySimilarProfile() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker and attended tabs"));
        people.verifySimilarProfile(attendeeName);
    }

    @Story("Speaker/Attendee Functionality")
    @Description("Verify speaker and attended tabs")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifyAttendeePage() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker and attended tabs"));
        people.verifyAttendeePage(attendeeName);
    }

    @Story("Speaker/Attendee Functionality")
    @Description("Verify speaker and attended tabs")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifyIsCategorySpeaker() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker and attended tabs"));
        people.verifyIsCategory("speakers");
    }

    @Story("Speaker/Attendee Functionality")
    @Description("Verify speaker and attended tabs")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifyIsCategoryAttendee() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker and attended tabs"));
        people.verifyIsCategory("attendees");
    }

    @Story("Speaker/Attendee Functionality")
    @Description("Verify speaker and attended tabs")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifyIsCategoryUpdated() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker and attended tabs"));
        people.verifyIsCategory("deligates");
    }


    @Story("Speaker/Attendee Functionality")
    @Description("Verify speaker and attended tabs")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifySpeakerSession() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker and attended tabs"));
        people.verifySessionWithSpeaker(speakerName, false);
    }

    @Story("Speaker/Attendee Functionality")
    @Description("Verify speaker and attended tabs")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifyAttendeeImage() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker and attended tabs"));
        people.verifyAttendeeImage(attendeeName);
    }

    @Story("Speaker/Attendee Functionality")
    @Description("Verify speaker and attended tabs")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifySpeakerSessionRegister() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker and attended tabs"));
        people.verifySessionWithSpeaker(speakerName, true);
    }

    @Story("Speaker/Attendee Functionality")
    @Description("verify speaker create meeting")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 3, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifySpeakerDetailPage() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker detail page"));
        people.verifyPeopleDetailPage(speakerName,"");
    }

    @Story("Speaker/Attendee Functionality")
    @Description("verify speaker create meeting")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 4, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifyAttendeeDetailPage() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify attende detail page"));
        people.verifyPeopleDetailPage(attendeeName,"");
    }

    @Story("Speaker/Attendee Functionality")
    @Description("verify bookmark and unbookmark speaker")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 3, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifyBookmarkUnbookmarkSpeaker() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify bookmark and unbookmark speaker"));
        people.verifyPeople("verify bookmark and unbookmark speaker",speakerName,"");
    }

    @Story("Speaker/Attendee Functionality")
    @Description("verify bookmark and unbookmark attendee")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 4, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifyBookmarkUnbookmarkAttendee() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify bookmark and unbookmark attendee"));
        people.verifyPeople("verify bookmark and unbookmark attendee",attendeeName,"");
    }

    @Story("Speaker/Attendee Functionality")
    @Description("verify speaker note")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 5, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifySpeakerNote() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker note"));
        people.verifyPeople("verify speaker note",speakerName,"this is our speaker note");
    }

    @Story("Speaker/Attendee Functionality")
    @Description("verify Attendee note")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 6, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifyAttendeeNote() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify Attendee note"));
        people.verifyPeople("verify attendee note",attendeeName,"this is our attendee note");
    }

    @Story("Speaker/Attendee Functionality")
    @Description("verify speaker chat")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 7, groups = {"Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifySpeakerChat() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker chat"));
        people.verifyPeople("verify speaker chat",speakerName,"this is speaker chat testing");
    }

    @Story("Speaker/Attendee Functionality")
    @Description("verify Attendee chat")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 8, groups = {"Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifyAttendeeChat() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify Attendee chat"));
        people.verifyPeople("verify attendee chat",attendeeName, "this is attendee chat testing");
    }

    @Story("Speaker/Attendee Functionality")
    @Description("verify speaker create meeting")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 9, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifyMeetingDescription() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker meeting description"));
        people.verifyMeetDescription(speakerName);
    }

    @Story("Speaker/Attendee Functionality")
    @Description("verify speaker create meeting")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 9, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifyAgendaForMeet() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify agenda for meet attendee"));
        people.verifyMeetLang_AgendaForMeet(attendeeName);
    }

    @Story("Speaker/Attendee Functionality")
    @Description("verify speaker create meeting")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 9, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifyCreateMeetingSpeaker() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker create meeting"));
        people.verifyPeople("verify speaker create meeting",speakerName,"");
    }

    @Story("Speaker/Attendee Functionality")
    @Description("verify attendee create meeting")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 10, groups = {"Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifyCreateMeetingAttendee() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify attendee create meeting"));
        people.verifyPeople("verify attendee create meeting",attendeeName,"");
    }
    @Story("Speaker/Attendee Functionality")
    @Description("verify speaker search")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 11, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifySpeakerSearch() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker search"));
        people.verifyPeople("verify speaker search",speakerName,"");
    }

    @Story("Speaker/Attendee Functionality")
    @Description("verify Attendee search")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 12, groups = {"Smoke", "Regression"}, dependsOnMethods = "peopleInit", enabled = true)
    public void verifyAttendeeSearch() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify attendee search"));
        people.verifyPeople("verify attendee search",attendeeName,"");
    }
    @Story("Speaker/Attendee Functionality")
    @Description("delete all created peoples")
    @Severity(SeverityLevel.BLOCKER)
    @AfterClass
    public void deleteCreatedPeoples() {
        lifecycle.updateTestCase(testResult -> testResult.setName("delete all created Speaker/Attendee"));
        changeSettings.deleteAttendee(apit_testdata.attendeenumber.get());
        changeSettings.deleteAttendee(apit_testdata.speakernumber.get());
    }
}

