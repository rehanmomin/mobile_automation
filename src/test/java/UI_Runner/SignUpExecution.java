package UI_Runner;

import Api_Runner.ChangeSettings;
import com.hubilo.base.BaseTest;
import com.hubilo.pageobjects.functions.MultiEvent;
import com.hubilo.pojo.ui.BProfileOnboarding;
import com.hubilo.pojo.ui.BSignUp;
import com.hubilo.pojo.ui.LoginData;
import com.hubilo.pojo.ui.SignUpData;
import com.hubilo.utils.dataProvider.DataSupplierJSON;
import com.hubilo.utils.helper.Utility;
import com.hubilo.utils.helper.apit_testdata;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@Feature("SignUp and Onboarding Functionality")
public class SignUpExecution extends BaseTest {

    private  ChangeSettings changeSettings;
    @Story("Verify SignUp page")
    @Description("Verify multi event and select event from the ongoing events")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, groups = {"Smoke", "Regression"},
            dataProvider = "loginDataJson", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifyMultiEventAndLoginScreen(LoginData loginData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Launch app and Select event from multi event"));
        MultiEvent multiEvent = basePageThread.get().getMultiEventInstance();
        changeSettings=new ChangeSettings();
        changeSettings.updateOnboardSetting(true, "attendee");
        changeSettings.disableMatchmaking("",false);
//        multiEvent.
//                appController(apit_testdata.eventid.get(),loginData.getOrgId(), loginData.getEvent(), environment);
//        multiEvent.selectEvent(loginData);
        eventName = apit_testdata.eventname.get();
        signUp = basePageThread.get().getSignUpInstance();
    }

    @Story("Verify SignUp page")
    @Description("Verify user trying to signup with restricted access enabled")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2, groups = {"Regression"},
            dataProvider = "signUpDataJson", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifyLoginRestricted(SignUpData signUpData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify email restricted"));
        changeSettings.dashboardLogin().updateUserRestrictionSetting(true);
        signUp.verifySignUp("verify email restricted", signUpData,eventName);
        changeSettings.dashboardLogin().updateUserRestrictionSetting(false);
    }
    @Story("Verify SignUp page")
    @Description("Verify user able to login with new Login code")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 3, groups = {"Regression"},
            dataProvider = "loginDataJson", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifyOTPLogin(LoginData loginData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify login with new login code"));
        changeSettings.dashboardLogin().updateDefautOTP(loginData.getOtp());
        signUp.verifyWithNewLogin(loginData.getEmail(), loginData.getOtp());
    }

    @Story("Verify SignUp page")
    @Description("Verify user trying to signup with different sets of data")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4, groups = {"Regression"},
            dataProvider = "bulkSignUp", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifySignupDataSet(BSignUp bSignUp) {
        lifecycle.updateTestCase(testResult -> testResult.setName(bSignUp.getTC()));
        signUp.verifySignUpData(eventName, bSignUp.getEmail(),bSignUp.getFirstName(),bSignUp.getLastName(),
                bSignUp.getNewPassword(), bSignUp.getConfirmPassword());
    }

    @Story("Verify SignUp page")
    @Description("Verify back to login link")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 5, groups = {"Regression"},
            dataProvider = "signUpDataJson", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifyBackLoginNow(SignUpData signUpData)  {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify login now"));
        signUp.verifySignUp("verify Login Now",signUpData,eventName);
    }

    @Story("Verify SignUp page")
    @Description("Verify user should able to go back from signup page")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 6, groups = {"Regression"},
            dataProvider = "signUpDataJson", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifyBackButton(SignUpData signUpData)  {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify back button to login page"));
        signUp.verifySignUp("Back Button",signUpData,eventName);
    }

    @Story("Verify SignUp page")
    @Description("Verify user should able to sign up with valid details")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7, groups = {"Smoke", "Regression"},
            dataProvider = "signUpDataJson", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifySignUpDetails(SignUpData signUpData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify with valid details"));
        changeSettings.dashboardLogin().updateOnboardSetting(true,"attendee");
        signUp.verifySignUp("valid details",signUpData,eventName);

    }
    @Story("Verify Onboarding page")
    @Description("Verify user should able to fill onboarding form")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8,  groups = {"Smoke", "Regression"},
            dataProvider = "bulkProfileOnboarding", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifyOnboardingDetails(BProfileOnboarding bProfileOnboarding) {
        lifecycle.updateTestCase(testResult -> testResult.setName(bProfileOnboarding.getTC()));
        onboarding = basePageThread.get().getOnboardingInstance();
        onboarding.logout();
        signUp.loginWithBulkData(bProfileOnboarding,eventName);
        onboarding.verifyDetailOnboardingFormBulk(bProfileOnboarding);
    }

    @Story("Verify Onboarding page")
    @Description("Verify user should able to change background images")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9, groups = {"Smoke", "Regression"},
            dataProvider = "signUpDataJson", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifyBackgroundCover(SignUpData signUpData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify add remove background images"));
        onboarding.verifyOnboarding("verify background images", signUpData, eventName);
    }

    @Story("Verify Onboarding page")
    @Description("Verify user should able to add social links")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 10, groups = {"Smoke", "Regression"},
            dataProvider = "signUpDataJson", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifySocialDetails(SignUpData signUpData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify user add social links"));
        onboarding.verifyOnboarding("verify social links", signUpData, eventName);
    }
    @Story("Verify Onboarding page")
    @Description("Verify user should able to select looking for and offerings")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 11, groups = {"Smoke", "Regression"},
            dataProvider = "signUpDataJson", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifyLookingForAndOffering(SignUpData signUpData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify user selects looking for and offerings"));
        onboarding.verifyOnboarding("verify looking for and offerings", signUpData, eventName);
    }

    @Story("Verify Onboarding page")
    @Description("Verify user should able to select interests and logout from reception")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 12, groups = {"Smoke", "Regression"},
            dataProvider = "signUpDataJson", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifyInterests(SignUpData signUpData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify user selects interests"));
        onboarding.verifyOnboarding("verify interests", signUpData, eventName);
    }

    @Story("Verify Onboarding page")
    @Description("Verify user should not see onboarding form")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 13, groups = {"Smoke", "Regression"},
            dataProvider = "signUpDataJson", dataProviderClass = DataSupplierJSON.class, enabled = true)
    public void verifyOnboardingDisable(SignUpData signUpData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify with onboarding disabled from dashboard"));
        changeSettings.dashboardLogin().updateOnboardSetting(false, "attendee");
        signUp.selectConsent();
        signUp.verifySignValidData(signUpData,eventName);
        onboarding.verifyOnboarding("verify onboarding disabled", signUpData, eventName);
    }

    @Story("Verify Onboarding page")
    @Description("Verify updating flag")
    @Severity(SeverityLevel.BLOCKER)
    @AfterClass
    public void verifyOnboardingUpdate() {
        lifecycle.updateTestCase(testResult -> testResult.setName("Updating Onboarding flag"));
        changeSettings.dashboardLogin().updateOnboardSetting(true, "attendee");
        changeSettings.deleteEvent();
    }
}