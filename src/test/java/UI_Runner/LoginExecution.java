package UI_Runner;

import Api_Runner.ChangeSettings;
import com.hubilo.base.BaseTest;
import com.hubilo.pageobjects.functions.MultiEvent;
import com.hubilo.pojo.ui.LoginData;
import com.hubilo.utils.dataProvider.DataSupplierJSON;
import com.hubilo.utils.helper.Utility;
import com.hubilo.utils.helper.apit_testdata;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import static com.hubilo.utils.helper.file_locators.booth_testdata;

/**
 * @created: 2022-06-06-10:49 PM
 * @project: Mobile_UI_Automation under @package: @package: UI_Runner
 * @author: Rehan
 **/

@Feature("Login Functionality")
public class LoginExecution extends BaseTest {

    AllureLifecycle lifecycle = Allure.getLifecycle();
    private  ChangeSettings changeSettings;
    @Story("Verify Login with password test cases")
    @Description("Verify multi event and select event from the ongoing events")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, groups = {"SmokeTest","RegressionTest"}, dataProvider = "loginDataJson", dataProviderClass = DataSupplierJSON.class,
            enabled = true)
    public void verifySelectEventFromMultiEventList(LoginData loginData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Select event from multi event list"));
        MultiEvent multiEvent = basePageThread.get().getMultiEventInstance();
        jsonPath= JsonPath.from(Utility.getJsonString(booth_testdata));
        changeSettings=new ChangeSettings();
        changeSettings.dashboardLogin();
        changeSettings.createEvent( Utility.epochCreation(Utility.getPastORFutureTime("past", 1)).toString(),Utility.epochCreation(Utility.getPastORFutureDates("future", 2)).toString(),loginData.getEventName()+"mobile");
        changeSettings.updateUserRestrictionSetting(false);
        changeSettings.createUser("sam@hubilo.com","samul", "macron","Attendee");
        changeSettings.createUser("jam@hubilo.com","jam", "singh","Attendee");
        changeSettings.updateOnboardSetting(false, "attendee");
        changeSettings.updateDefautOTP(loginData.getOtp());
        changeSettings.createBooth(jsonPath.getString("booth.NAME"),jsonPath.getString("booth.DESC"),jsonPath.getString("booth.CATEGORY"));
        try{
            multiEvent.appController(apit_testdata.eventid.get(), loginData.getOrgId(), apit_testdata.eventname.get(), environment);
        }catch (NoSuchElementException noSuchElementException){
            noSuchElementException.printStackTrace();
        }
        multiEvent.selectEvent(loginData);
        loginPage = basePageThread.get().getLoginPageInstance();
        profile = basePageThread.get().getUserProfileInstance();
        eventName = loginData.getEventName();
        loginPage.gotoChangePassword(loginData.getEmail(), loginData.getOtp());
        loginPage.verifyLogin("verify change password bulk", loginData.getEmail(), "qwerty@12", eventName);
        profile.gotoProfile();
        loginPage = profile.logOut(eventName);
        loginPage.gotoChangePassword("jam@hubilo.com", loginData.getOtp());
        loginPage.verifyLogin("verify change password bulk", "jam@hubilo.com", "qwerty@12", eventName);
        profile.gotoProfile();
        loginPage = profile.logOut(eventName);
    }
    @Story("Verify Login with password test cases")
    @Description("Verify Login with empty email")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 2, groups = {"Smoke", "Regression"},
            enabled = true, dataProvider = "loginDataJson", dependsOnMethods = "verifySelectEventFromMultiEventList", dataProviderClass = DataSupplierJSON.class)
    public void verifyEmptyEmailWithoutAndWithConsent(LoginData loginData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify empty email without and with consent"));
        loginPage.verifyLogin("empty email without and with consent", loginData.getEmail(), loginData.getPassword(), loginData.getEventName());
    }

    @Story("Verify Login with password test cases")
    @Description("Verify Login with invalid email")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 3, groups = {"Smoke", "Regression"},
            enabled = true, dataProvider = "loginDataJson", dependsOnMethods = "verifySelectEventFromMultiEventList", dataProviderClass = DataSupplierJSON.class)
    public void verifyInvalidEmailWithoutAndWithConsent(LoginData loginData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify invalid email without and with consent"));
        loginPage.verifyLogin("invalid email without and with consent", loginData.getEmail(), loginData.getPassword(), loginData.getEventName());
    }

    @Story("Verify Login with password test cases")
    @Description("Verify Login with valid email and empty password")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 4, groups = {"Smoke", "Regression"},
            enabled = true, dataProvider = "loginDataJson", dependsOnMethods = "verifySelectEventFromMultiEventList", dataProviderClass = DataSupplierJSON.class)
    public void verifyEmptyPasswordWithoutAndWithConsents(LoginData loginData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify empty password without and with consent"));
        loginPage.verifyLogin("empty password without and with consent", loginData.getEmail(), loginData.getPassword(), loginData.getEventName());
    }

    @Story("Verify Login with password test cases")
    @Description("Verify Login with valid email and invalid password")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 5, groups = {"Smoke", "Regression"},
            enabled = true, dataProvider = "loginDataJson", dependsOnMethods = "verifySelectEventFromMultiEventList", dataProviderClass = DataSupplierJSON.class)
    public void verifyInvalidPasswordWithoutAndWithConsent(LoginData loginData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify invalid password without and with consent"));
        loginPage.verifyLogin("invalid password without and with consent", loginData.getEmail(), loginData.getPassword(), loginData.getEventName());
    }

    @Story("Verify Login with password test cases")
    @Description("Verify Login with valid email and valid password")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6, groups = {"Smoke", "Regression"},
            enabled = true, dataProvider = "loginDataJson", dependsOnMethods = "verifySelectEventFromMultiEventList", dataProviderClass = DataSupplierJSON.class)
    public void verifyValidEmailAndPassword(LoginData loginData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify valid user and password"));
        loginPage.verifyLogin("valid user and password", loginData.getEmail(), loginData.getPassword(), loginData.getEventName());
        profile = basePage.getUserProfileInstance();
        profile.gotoProfile();
        loginPage = profile.logOut(eventName);
    }

    @Story("Verify Login with Login code test cases")
    @Description("Verify Login with different user link")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 7, groups = {"Smoke", "Regression"},
            enabled = true, dataProvider = "loginDataJson", dependsOnMethods = "verifySelectEventFromMultiEventList", dataProviderClass = DataSupplierJSON.class)
    public void verifyDifferentUser(LoginData loginData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify different user from login code"));
        loginPage.verifyLogin("different user from OTP", loginData.getEmail(), loginData.getOtp(), loginData.getEventName());
    }

    @Story("Verify Login with Login code test cases")
    @Description("Verify Login with invalid login code")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 8, groups = {"Smoke", "Regression"},
            enabled = true, dataProvider = "loginDataJson", dependsOnMethods = "verifySelectEventFromMultiEventList", dataProviderClass = DataSupplierJSON.class)
    public void verifyInvalidOTP(LoginData loginData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify invalid login code"));
        loginPage.verifyLogin("invalid OTP", loginData.getEmail(), loginData.getOtp(), loginData.getEventName());
    }

    @Story("Verify Login with Login code test cases")
    @Description("Verify Login with valid login code")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9, groups = {"Smoke", "Regression"},
            enabled = true, dataProvider = "loginDataJson", dependsOnMethods = "verifySelectEventFromMultiEventList", dataProviderClass = DataSupplierJSON.class)
    public void verifyValidOTP(LoginData loginData) {
        lifecycle.updateTestCase(testResult -> testResult.setName("Verify valid login code"));
        loginPage.verifyLogin("valid OTP", loginData.getEmail(), loginData.getOtp(), loginData.getEventName());
    }


}