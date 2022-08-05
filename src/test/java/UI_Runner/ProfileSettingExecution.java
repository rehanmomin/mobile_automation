package UI_Runner;

import Api_Runner.ChangeSettings;
import com.hubilo.base.BasePage;
import com.hubilo.base.BaseTest;
import com.hubilo.pageobjects.functions.LoginPage;
import com.hubilo.pageobjects.functions.MultiEvent;
import com.hubilo.pageobjects.functions.Profile;
import com.hubilo.pojo.ui.BProfileOnboarding;
import com.hubilo.pojo.ui.LoginData;
import com.hubilo.pojo.ui.SignUpData;
import com.hubilo.utils.dataProvider.DataSupplierJSON;
import io.qameta.allure.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@Feature("Profile Settings Functionality")
public class ProfileSettingExecution extends BaseTest {
    private ChangeSettings changeSettings;

    @Story("Profile Settings Functionality")
    @Description("Go to profile settings")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, groups = {"Smoke", "Regression"}, alwaysRun = true, enabled = true)
    public void profileInit() {
        lifecycle.updateTestCase(testResult -> testResult.setName("Go to profile setting"));
        profile = basePageThread.get().getUserProfileInstance();
        profile.gotoProfile();
    }

    @Story("Profile Settings Functionality")
    @Description("verify edit profile with new data set")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, groups = {"Regression"},
            dataProvider = "bulkProfileOnboarding", dependsOnMethods = "profileInit", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifyEditProfileWithBulkData(BProfileOnboarding bProfileOnboarding) {
        lifecycle.updateTestCase(testResult -> testResult.setName(bProfileOnboarding.getTC()));
        profile.verifyProfileDataSet(bProfileOnboarding);
    }


    @Story("Profile Settings Functionality")
    @Description("select new insterests")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 4, groups = {"Smoke", "Regression"},
            dataProvider = "signUpDataJson", dependsOnMethods = "profileInit", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifyEditProfileAddRemoveInterests(SignUpData signUpData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("select new insterests"));
        profile.verifyProfile("select new insterests", signUpData);
    }

    @Story("Profile Settings Functionality")
    @Description("select new looking for and offering")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 5, groups = {"Smoke", "Regression"},
            dataProvider = "signUpDataJson", dependsOnMethods = "profileInit", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifyEditProfileLookingforOffering(SignUpData signUpData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("select new looking for and offering"));
        profile.verifyProfile("select new looking for and offering", signUpData);
    }

    @Story("Profile Settings Functionality")
    @Description("verify timezone")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 6, groups = {"Smoke", "Regression"},
            dataProvider = "signUpDataJson", dependsOnMethods = "profileInit", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifyTimezone(SignUpData signUpData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify timezone"));
        profile.verifyProfile("verify timezone", signUpData);
    }

    @Story("Profile Settings Functionality")
    @Description("bookmarked attendees unbookmark")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 7, groups = {"Regression"},
            dataProvider = "signUpDataJson", dependsOnMethods = "profileInit", dataProviderClass = DataSupplierJSON.class, enabled = false)
    public void verifyBookmarkedAttendeesUnbookmark(SignUpData signUpData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("bookmarked attendees unbookmark"));
        profile.verifyProfile("bookmarked attendees unbookmark", signUpData);
    }

    @Story("Profile Settings Functionality")
    @Description("bookmarked speakers unbookmark")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 8, groups = {"Regression"},
            dataProvider = "signUpDataJson", dependsOnMethods = "profileInit", dataProviderClass = DataSupplierJSON.class, enabled = false)
    public void verifyBookmarkedSpeakersUnbookmark(SignUpData signUpData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("bookmarked speakers unbookmark"));
        profile.verifyProfile("bookmarked speakers unbookmark", signUpData);
    }

    @Story("Profile Settings Functionality")
    @Description("bookmark exhibitors unbookmark")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 9, groups = {"Regression"},
            dataProvider = "signUpDataJson", dependsOnMethods = "profileInit", dataProviderClass = DataSupplierJSON.class, enabled = false)
    public void verifyBookmarkedExhibitorsUnbookmark(SignUpData signUpData) {
        profile.verifyProfile("bookmark exhibitors unbookmark", signUpData);
    }

    @Story("Profile Settings Functionality")
    @Description("timezone 24 hour toggle ON/OFF")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 10, groups = {"Smoke", "Regression"},
            dataProvider = "signUpDataJson", dependsOnMethods = "profileInit", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifyTimezone24Hour(SignUpData signUpData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("timezone 24 hour toggle ON/OFF"));
        profile.verifyProfile("timezone 24 hour toggle ON/OFF", signUpData);
    }

    @Story("Profile Settings Functionality")
    @Description("updating industry match making")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 11, groups = {"Regression"}, dependsOnMethods = "profileInit", enabled = false)
    public void verifyIndustryOff() {
        lifecycle.updateTestCase(testResult -> testResult.setName("Industry match making"));
        changeSettings=new ChangeSettings();
        changeSettings.dashboardLogin();
        changeSettings.disableMatchmaking("industry",true);
        profile.verifyMatchmakingUpdated("industry");
    }

    @Story("Profile Settings Functionality")
    @Description("updating interest match making")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 12, groups = {"Regression"}, dependsOnMethods = "profileInit", enabled = false)
    public void verifyInterestOff() {
        lifecycle.updateTestCase(testResult -> testResult.setName("Interest match making"));
        changeSettings.disableMatchmaking("interest",true);
        profile.verifyMatchmakingUpdated("interest");
    }

    @Story("Profile Settings Functionality")
    @Description("updating looking for match making")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 13, groups = {"Regression"}, dependsOnMethods = "profileInit", enabled = false)
    public void verifyLookingAndOfferingForOff() {
        lifecycle.updateTestCase(testResult -> testResult.setName("Looking for match making"));
        changeSettings.disableMatchmaking("lookingfor", true);
        profile.verifyMatchmakingUpdated("lookingfor");
    }

    @Story("Profile Settings Functionality")
    @Description("verify logged out")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 14, groups = {"Smoke", "Regression"}, dependsOnMethods = "profileInit", enabled = true)
    public void verifyUserLoggedout() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify logged out"));
        profile.logOut(eventName);
    }
    @Story("Profile Settings Functionality")
    @Description("Update API flag")
    @Severity(SeverityLevel.BLOCKER)
    @AfterClass(enabled = false)
    public void updateFlag() {
        lifecycle.updateTestCase(testResult -> testResult.setName("Match-making flag update"));
        ChangeSettings changeSettings1 = new ChangeSettings();
        changeSettings1.disableMatchmaking("",false);
        changeSettings1.disableMatchmaking("",false);
        changeSettings1.disableMatchmaking("", false);
    }
}