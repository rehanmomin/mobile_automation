package com.hubilo.pageobjects.functions;

import com.hubilo.pageobjects.locators.MeetingLocator;
import com.hubilo.utils.helper.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class Meeting extends MeetingLocator {

    private AppiumDriver driver;
    private SoftAssert softAssert = new SoftAssert();

    public Meeting(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void verifyMeeting(String testcase) {
        switch (testcase) {
            case "verify meeting screen": verifyMeetingScreen(); break;
            case "verify meeting setup": verifyMeetingSetup();  break;
            case "verify withdraw meeting": verifyWithdraw();  break;
            case "verify join meeting": verifyJoinMeeting(); break;
            case "verify cancel meeting": verifyCancelMeeting(); break;
        }
    }

    private void gotoMeeting() {
        Utility.gotoReception(driver);
        reception.click();
        reception.click();
        Utility.waitElement(driver).until((element)-> Utility.isAvailable(driver,meetingBtn));
        meetingBtn.click();
    }

    @Step("Go to meeting tab and verify elements on the screen")
    private void verifyMeetingScreen() {
        gotoMeeting();
        softAssert.assertTrue(Utility.isAvailable(driver, meetingTab));
        softAssert.assertTrue(Utility.isAvailable(driver, agendaTab));
        meetingBtn.click();
        if(driver instanceof AndroidDriver) {
            softAssert.assertTrue(Utility.isAvailable(driver, meetingDate.stream().findFirst().get()));
            softAssert.assertTrue(Utility.isAvailable(driver, meetingUserName.stream().findFirst().get()));
            softAssert.assertTrue(Utility.isAvailable(driver, meetingStatus.stream().findFirst().get()));
        } else {
            softAssert.assertTrue(Utility.isAvailable(driver, meetingCancel.stream().findFirst().get()));
            softAssert.assertTrue(Utility.isAvailable(driver, meetingJoin.stream().findFirst().get()));
            softAssert.assertTrue(Utility.isAvailable(driver, meetingDescription.stream().findFirst().get()));
            reception.click();
            reception.click();
        }
        softAssert.assertAll();
    }

    @Step("Go to people schedule meeting then go to meeting section and verify meeting scheduled visible")
    private void verifyMeetingSetup() {
        meetingBtn.click();
        meetingTab.click();
        softAssert.assertTrue(Utility.isAvailable(driver, meetingWithdraw.stream().findFirst().get()));
        softAssert.assertAll();
    }

    @Step("Go to meeting section and withdraw meeting which is already requested")
    private void verifyWithdraw() {
        Integer count = meetingTiles.size();
        if(driver instanceof AndroidDriver) {
            meetingWithdraw.stream().forEach(element -> element.click());
            for (MobileElement element : meetingWithdraw)
                element.click();
        }else{
            meetingWithdraw.get(0).click();
        }
        softAssert.assertTrue(count > meetingTiles.size());
        softAssert.assertAll();
    }

    @Step("Meeting already setup by another user/Dashboard, Go to meeting section and join meeting and verify all elements after joined")
    private void verifyJoinMeeting() {
        Utility.waitUntilElement(driver, meetingJoin.stream().findFirst().get());
        meetingJoin.stream().findFirst().get().click();
        Utility.sleep(2000);
        softAssert.assertTrue(Utility.isAvailable(driver, meetingMyProfilePic));
        softAssert.assertTrue(Utility.isAvailable(driver, meetingUserName.stream().findFirst().get()));
        softAssert.assertTrue(Utility.isAvailable(driver, meetingExit));
        softAssert.assertTrue(Utility.isAvailable(driver, meetingAudioBtn));
        softAssert.assertTrue(Utility.isAvailable(driver, meetingVideoBtn));
        softAssert.assertTrue(Utility.isAvailable(driver, shareScreen));
        if(driver instanceof AndroidDriver) {
            softAssert.assertTrue(Utility.isAvailable(driver, meetingTimer));
            softAssert.assertTrue(Utility.isAvailable(driver, meetingSwitchCameraBtn));
        }
        meetingExit.click();
        softAssert.assertAll();
    }

    @Step("Meeting already setup by another user/dashboard, Go to meeting section press cancel to cancel meeting with reason")
    private void verifyCancelMeeting() {
        meetingCancel.stream().findFirst().get().click();
        softAssert.assertTrue(Utility.isAvailable(driver, meetingCancelTitle));
        meetingCancelReasonInputBox.sendKeys("I am not interested..");
        confirmCancel.click();
        reception.click();
        softAssert.assertAll();
    }
}