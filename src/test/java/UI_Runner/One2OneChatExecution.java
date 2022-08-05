package UI_Runner;

import Api_Runner.ChangeSettings;
import com.hubilo.base.BaseTest;
import com.hubilo.pojo.ui.BChatMessage;
import com.hubilo.utils.dataProvider.DataSupplierJSON;
import com.hubilo.utils.helper.Utility;
import com.hubilo.utils.helper.apit_testdata;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@Feature("One To One Chat Functionality")
public class One2OneChatExecution extends BaseTest{

    private String attendeeName = "Attendee", speakerName = "Speaker";
    private ChangeSettings changeSettings;

    @Story("One To One Chat Functionality")
    @Description("Create user using Dashboard API")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, groups = {"Smoke", "Regression"}, enabled = true)
    public void one2OneChatInit() {
        changeSettings = new ChangeSettings();
        String sRandom = String.valueOf(Utility.generateRandomNumber());
        changeSettings.dashboardLogin().createUser(attendeeName+sRandom+"@hubilo.com",attendeeName, sRandom,"Attendee");
        attendeeName = attendeeName+" "+sRandom;
        changeSettings.dashboardLogin().createUser(speakerName+sRandom+"@hubilo.com",speakerName, sRandom,"Speaker");
        speakerName = speakerName+" "+sRandom;
        one2OneChat = basePageThread.get().getOne2OneChatInstance();
        System.out.println("attendee : "+attendeeName);
        System.out.println("attendee : "+attendeeName);
        lifecycle.updateTestCase(testResult -> testResult.setName("create user using dashboard api"));
    }

    @Story("One To One Chat Functionality")
    @Description("Verify One To One Chat option on reception screen")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, groups = {"Smoke", "Regression"}, dependsOnMethods = "one2OneChatInit", enabled = true)
    public void verifyChatOnReception() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify one to chat reception"));
        one2OneChat.verifyOne2OneChat("verify one to chat reception", "","");
    }

    @Story("One To One Chat Functionality")
    @Description("Verify new chat people search")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 3,  groups = {"Regression"}, dependsOnMethods = "one2OneChatInit", enabled = true)
    public void verifySearchSpeakerNewChat() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify search speaker"));
        one2OneChat.verifyOne2OneChat("verify new chat people search", speakerName,"");
    }

    @Story("One To One Chat Functionality")
    @Description("Verify user able to text chat")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 4,  groups = {"Regression"}, dependsOnMethods = "one2OneChatInit", dataProvider = "chatBulkMessage", dataProviderClass = DataSupplierJSON.class,
            enabled = true)
    public void verifySpeakerTextChat(BChatMessage bChatMessage) {
        lifecycle.updateTestCase(testResult -> testResult.setName(bChatMessage.getTC()));
        one2OneChat.verifyOne2OneChat("verify text chat", speakerName, bChatMessage.getMessage());
    }

    @Story("One To One Chat Functionality")
    @Description("Verify user able to delete text chat")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 5,  groups = {"Regression"}, dependsOnMethods = "one2OneChatInit", enabled = false)
    public void verifyDeleteSpeakerTextChat() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker text chat delete"));
        one2OneChat.verifyOne2OneChat("verify delete text chat", speakerName,"");
    }

    @Story("One To One Chat Functionality")
    @Description("Verify user able to GIF chat")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 6,  groups = {"Regression"}, dependsOnMethods = "one2OneChatInit", enabled = true)
    public void verifySpeakerGIFChat() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker GIF chat"));
        one2OneChat.verifyOne2OneChat("verify GIF chat",speakerName,"Happy Birthday");
    }

    @Story("One To One Chat Functionality")
    @Description("Verify user able to delete GIF")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 7,  groups = {"Regression"}, dependsOnMethods = "one2OneChatInit", enabled = false)
    public void verifyDeleteSpeakerGIFChat() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify speaker GIF chat delete"));
        if(driver instanceof AndroidDriver){
            one2OneChat.back();
        }
        one2OneChat.verifyOne2OneChat("verify delete GIF chat", speakerName,"");
    }


    @Story("One To One Chat Functionality")
    @Description("Verify new chat people search")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 8,  groups = {"Regression"}, dependsOnMethods = "one2OneChatInit", enabled = true)
    public void verifySearchAttendeeNewChat() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify search attendee"));
        if(driver instanceof IOSDriver){
            one2OneChat.back();
        }
        one2OneChat.verifyOne2OneChat("verify new chat people search", attendeeName,"");
    }

    @Story("One To One Chat Functionality")
    @Description("Verify user able to text chat")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 9,  groups = {"Regression"},dependsOnMethods = "one2OneChatInit", dataProvider = "chatBulkMessage", dataProviderClass = DataSupplierJSON.class,
            enabled = true)
    public void verifyAttendeeTextChat(BChatMessage bChatMessage) {
        lifecycle.updateTestCase(testResult -> testResult.setName(bChatMessage.getTC()));
        one2OneChat.verifyOne2OneChat("verify text chat", attendeeName, bChatMessage.getMessage());
    }

    @Story("One To One Chat Functionality")
    @Description("Verify user able to delete GIF")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 10,  groups = {"Regression"}, dependsOnMethods = "one2OneChatInit",enabled = true)
    public void verifyDeleteAttendeeTextChat() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify attendee text chat delete"));
        if(driver instanceof AndroidDriver){
            one2OneChat.back();
        }
        one2OneChat.verifyOne2OneChat("verify delete text chat", attendeeName,"");
    }
    @Story("One To One Chat Functionality")
    @Description("Verify user able to GIF chat")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 11,  groups = {"Regression"}, dependsOnMethods = "one2OneChatInit",enabled = true)
    public void verifyAttendeeGIFChat() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify attendee GIF chat"));
        one2OneChat.verifyOne2OneChat("verify GIF chat",attendeeName,"Happy Birthday");
    }

    @Story("One To One Chat Functionality")
    @Description("Verify user able to search peoples from existing list")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 13,  groups = {"Smoke", "Regression"}, dependsOnMethods = "one2OneChatInit", enabled = true)
    public void verifySearchSpeakerExistingList() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify search people existing list"));
        if (driver instanceof IOSDriver){
            one2OneChat.back();
        }
        one2OneChat.verifyOne2OneChat("verify search people existing list",speakerName,"Good Night");
    }

    @Story("One To One Chat Functionality")
    @Description("Verify user able to delete chat under message")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 14,  groups = {"Smoke", "Regression"}, dependsOnMethods = "one2OneChatInit", enabled = true)
    public void verifyDeleteSpeakerAllChat() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify delete all chat existing people"));
        one2OneChat.verifyOne2OneChat("verify delete all chat existing people", speakerName,"");
    }

    @Story("One To One Chat Functionality")
    @Description("Verify user able to search peoples from existing list")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 15,  groups = {"Smoke", "Regression"}, dependsOnMethods = "one2OneChatInit", enabled = true)
    public void verifySearchAttendeeExistingList() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify search people existing list"));
        if(driver instanceof IOSDriver) {
            one2OneChat.gotoiOSOne2OneChat();}
        one2OneChat.verifyOne2OneChat("verify search people existing list",attendeeName,"Good Night");
    }


    @Story("One To One Chat Functionality")
    @Description("Verify user able to delete chat under message")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 16,  groups = {"Smoke", "Regression"}, dependsOnMethods = "one2OneChatInit", enabled = true)
    public void verifyDeleteAttendeeAllChat() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify delete all chat existing people"));
        one2OneChat.verifyOne2OneChat("verify delete all chat existing people", attendeeName,"");
    }

    @Story("One To One Chat Functionality")
    @Description("Delete all user from dashboard and go to reception")
    @Severity(SeverityLevel.BLOCKER)
    @AfterClass
    public void verifyDeleteAllUserNavigateToReception() {
        lifecycle.updateTestCase(testResult -> testResult.setName("Delete all people and navigate to reception"));
        if(driver instanceof AndroidDriver)
        {
            one2OneChat.back();
        }else {
            one2OneChat.iOSCloseChat();
            one2OneChat.iOSCloseChat();
        }
        changeSettings.deleteAttendee(apit_testdata.attendeenumber.get());
        changeSettings.deleteAttendee(apit_testdata.speakernumber.get());
    }

}
