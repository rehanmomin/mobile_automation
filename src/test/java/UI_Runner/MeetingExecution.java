package UI_Runner;

import Api_Runner.ChangeSettings;
import com.hubilo.base.BasePage;
import com.hubilo.base.BaseTest;
import com.hubilo.pageobjects.functions.*;
import com.hubilo.pojo.ui.LoginData;
import com.hubilo.utils.dataProvider.DataSupplierJSON;
import com.hubilo.utils.helper.Utility;
import com.hubilo.utils.helper.apit_testdata;
import io.qameta.allure.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@Feature("Schedule Meeting Functionality")
public class MeetingExecution extends BaseTest {

    private String attendeeName="Attendee", speakerName="Speaker";
    private ChangeSettings changeSettings;

    @Story("Meeting Functionality")
    @Description("Dashboard configuration for Meetings")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, groups = {"Smoke", "Regression"}, enabled = true)
    public void meetingInit() {
        changeSettings = new ChangeSettings();
        String sRandom = String.valueOf(Utility.generateRandomNumber());
        changeSettings.dashboardLogin().createUser(attendeeName+sRandom+"@hubilo.com",attendeeName, sRandom,"Attendee");
        attendeeName = attendeeName+" "+sRandom;
        changeSettings.dashboardLogin()
                .scheduleMeeting(attendeeName, "sam@hubilo.com", Utility.epochCreation(Utility.getPastORFutureTime("future",3)).toString(),"this is meeting from api");
         meeting = basePageThread.get().getMeetingInstance();
        lifecycle.updateTestCase(testResult -> testResult.setName("Meeting configuration:- creation of Meeting - from the dashboards"));
    }

    @Story("Meeting Functionality")
    @Description("Verify meeting screen")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, dependsOnMethods = "meetingInit", groups = {"Smoke", "Regression"}, enabled = true)
    public void verifyMeetingScreen() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify meeting screen"));
        meeting.verifyMeeting("verify meeting screen");
    }

    @Story("Meeting Functionality")
    @Description("Verify meeting setup")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 3, groups = {"Smoke", "Regression"}, dependsOnMethods = "meetingInit", enabled = true)
    public void verifyMeetingSetup() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify meeting setup"));
        People people = basePage.getPeopleInstance();
        people.verifyTabs();
        people.verifyPeople("verify attendee create meeting",attendeeName,"");
        meeting.verifyMeeting("verify meeting setup");

    }

    @Story("Meeting Functionality")
    @Description("Verify withdraw meeting")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 4, groups = {"Smoke", "Regression"}, dependsOnMethods = "meetingInit", enabled = true)
    public void verifyWithdrawMeeting() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify withdraw meeting"));
        meeting.verifyMeeting("verify withdraw meeting");
    }

    @Story("Meeting Functionality")
    @Description("Verify join meeting")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 5, groups = {"Smoke", "Regression"}, dependsOnMethods = "meetingInit", enabled = true)
    public void verifyJoinMeeting() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify join meeting"));
        meeting.verifyMeeting("verify join meeting");
    }

    @Story("Meeting Functionality")
    @Description("Verify cancel meeting")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 6, groups = {"Smoke", "Regression"}, dependsOnMethods = "meetingInit", enabled = true)
    public void verifyCancelMeeting() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify cancel meeting"));
        meeting.verifyMeeting("verify cancel meeting");
        changeSettings.deleteAttendee(apit_testdata.attendeenumber.get());
    }

    @Story("Meeting Functionality")
    @Description("delete all created peoples")
    @Severity(SeverityLevel.BLOCKER)
    @AfterClass
    public void deleteCreatedPeoples() {
        lifecycle.updateTestCase(testResult -> testResult.setName("delete all created peoples"));
        changeSettings.deleteAttendee(apit_testdata.attendeenumber.get());
    }
}
