package com.hubilo.pageobjects.functions;

import com.hubilo.pageobjects.locators.ReceptionLocator;
import com.hubilo.utils.helper.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

/**
 * @created: 2022-06-28-3:43 PM
 * @project: Mobile_UI_Automation under @package: @package: com.hubilo.pageobjects.functions
 * @author: Rehan
 **/


public class Reception extends ReceptionLocator {
    private  AppiumDriver driver;
    private SoftAssert softAssert = new SoftAssert();

    public Reception(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void verifyReception(String testcase){
        switch (testcase){
            case "verify banner": verifyReceptionScreen(); break;
            case "verify all live session": verifyLiveAgenda(); break;
            case "verify all session": verifyAgenda(); break;
            case "verify all room": verifyRooms(); break;
            case "verify all speaker": verifySpeakers(); break;
            case "verify all booth": verifyBooth(); break;
            case "verify all leaderboard": verifyLeaderboard(); break;
        }
    }

    @Step("Go to reception screen and verify elements on the screen")
    private void verifyReceptionScreen(){
        if(driver instanceof AndroidDriver){
            Utility.gotoReception(driver);
            Utility.sleep(5000);
        }
        feedPost.click();
        reception.click();
        if(driver instanceof AndroidDriver){
            softAssert.assertTrue(Utility.isAvailable(driver, hubiloLogo));
        }
        softAssert.assertTrue(Utility.isAvailable(driver, hubiloName),"verifying hubilo name");
        softAssert.assertTrue(Utility.isAvailable(driver, meeting),"verifying meeting option");
        softAssert.assertTrue(Utility.isAvailable(driver, notification), "verifying notification option");
        softAssert.assertTrue(Utility.isAvailable(driver, chat), "verifying chat option");
        softAssert.assertTrue(Utility.isAvailable(driver, profileImage), "verifying profile image");
        softAssert.assertTrue(Utility.isAvailable(driver, eventBanner), "verifying event banner");
        softAssert.assertAll();
    }

    @Step("Go to reception screen and verify Live agenda")
    private void verifyLiveAgenda(){
        Utility.sleep(1000);
        softAssert.assertTrue(Utility.isAvailable(driver, startedSessionText), "verifying live session text");
        softAssert.assertTrue(Utility.isAvailable(driver, liveSessionText), "verifying live session option text");
        softAssert.assertTrue(Utility.isAvailable(driver, viewAllLiveSession), "live session view all");
        viewAllLiveSession.click();
        if(driver instanceof AndroidDriver)
        {
            softAssert.assertTrue(pageTitle.getText().contains("Live Agenda"), "verifying live session detail text");
            backBtn.click();
        } else {
            softAssert.assertTrue(Utility.isAvailable(driver, toggleOn));
            reception.click();
        }
        softAssert.assertAll();
    }

    @Step("Go to reception screen and verify Agenda")
    private void verifyAgenda(){
        waitTo(sessionText);
        softAssert.assertTrue(Utility.isAvailable(driver, sessionText), "verifying session text");
        softAssert.assertTrue(Utility.isAvailable(driver, featuredSessionText),"verifying featured session text");
        softAssert.assertTrue(Utility.isAvailable(driver, viewAllFeatureSession), "verifying view featured session");
        viewAllFeatureSession.click();
        if(driver instanceof AndroidDriver) {
            softAssert.assertTrue(pageTitle.getText().contains("Agenda"), "agenda page title");
            backBtn.click();
            Utility.scrollDownByElement(driver, sessionText, liveSessionText);
        } else {
            softAssert.assertTrue(Utility.isAvailable(driver, toggleOff), "verifying session toggle");
            reception.click();
            waitTo(sessionText);
            scrollPage(3);
        }
        softAssert.assertAll();
    }

    @Step("Go to reception screen and verify Rooms")
    private void verifyRooms(){
        if(driver instanceof AndroidDriver) {
            waitTo(roomText);
            softAssert.assertTrue(Utility.isAvailable(driver, roomText), "verifying room text");
        }
        softAssert.assertTrue(Utility.isAvailable(driver, featureRoomText), "verifying featured room text");
        softAssert.assertTrue(Utility.isAvailable(driver, viewAllRoom), "verifying room view all");
        viewAllRoom.click();
        softAssert.assertTrue(pageTitle.getText().contains("Rooms"), "room page title");
        if(driver instanceof AndroidDriver)
        {
            backBtn.click();
            try{
                Utility.scrollDownByElement(driver, roomText, sessionText);
            }catch (NoSuchElementException noSuchElementException){
                noSuchElementException.printStackTrace();
            }
        } else {
            reception.click();
            waitTo(sessionText);
            scrollPage(4);
        }
        softAssert.assertAll();
    }

    @Step("Go to reception screen and verify Speakers")
    private void verifySpeakers(){
        waitTo(speakerText);
        softAssert.assertTrue(Utility.isAvailable(driver, speakerText), "verifying speaker text");
        softAssert.assertTrue(Utility.isAvailable(driver, featureSpeakerText), "verifying featured speaker text");
        softAssert.assertTrue(Utility.isAvailable(driver, viewAllSpeaker.get(0)), "view all feature speaker");
        viewAllSpeaker.get(0).click();
        if(driver instanceof AndroidDriver)
        {
            softAssert.assertTrue(pageTitle.getText().contains("People"), "people page title");
            backBtn.click();
            try{
                Utility.scrollDownByElement(driver, speakerText, roomText);
            }catch (NoSuchElementException noSuchElementException){
                noSuchElementException.printStackTrace();
            }

        } else {
            softAssert.assertTrue(Utility.isAvailable(driver, getSpeakerTab), "verifying people speaker tab");
            softAssert.assertTrue(Utility.isAvailable(driver, getAttendeeTab), "verifying people attendee tab");
            reception.click();
            waitTo(sessionText);
            scrollPage(6);
        }
        softAssert.assertAll();
    }

    @Step("Go to reception screen and verify Booth")
    private void verifyBooth(){
        waitTo(boothText);
        Utility.waitUntilElement(driver, boothText);
        softAssert.assertTrue(Utility.isAvailable(driver, boothText), "verifying booth text");
        softAssert.assertTrue(Utility.isAvailable(driver, boothFeatureText), "verifying featured booth");
        softAssert.assertTrue(Utility.isAvailable(driver, viewAllBooth.get(0)), "verifying view all booth");
        Utility.waitUntilElement(driver, viewAllBooth.get(0));
        viewAllBooth.get(0).click();

        if(driver instanceof AndroidDriver)
        {
            softAssert.assertTrue(pageTitle.getText().contains("Booth"), "verifying booth page title");

            try {
                backBtn.click();
            }catch (NoSuchElementException noSuchElementException){
                reception.click();
            }
            Utility.scrollDownByElement(driver,boothText, speakerText);
        } else {
            softAssert.assertTrue(boothPageTitle.getText().contains("Booth"), "verifying booth page title");
            reception.click();
            waitTo(sessionText);
            scrollPage(6);
        }
        softAssert.assertAll();
    }

    @Step("Go to reception screen and verify Leaderboard")
    private void verifyLeaderboard(){
        waitTo(leaderboardText);
        softAssert.assertTrue(Utility.isAvailable(driver, leaderboardText), "verifying leaderboard text");
        softAssert.assertTrue(Utility.isAvailable(driver, viewAllLeaderboard.get(0)), "verifying view all leaderboard");
        viewAllLeaderboard.get(0).click();
        if(driver instanceof AndroidDriver)
        {
            softAssert.assertTrue(pageTitle.getText().contains("Leaderboard"), "verifying leaderboard page");
            backBtn.click();
        }else {
            softAssert.assertTrue(lbPageTitle.getText().contains("Leaderboard"), "verifying leaderboard page");
            reception.click();
            waitTo(sessionText);
        }
        softAssert.assertAll();
    }


    private void waitTo(MobileElement element){
        Utility.sleep(1000);
        Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(element));
    }
    private void scrollPage(int times)
    {
        for (int i = 0 ; i < times ; i++)
        {
            Utility.scrollDown(driver);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException interruptedException){
                interruptedException.getMessage();
            }
        }
    }
}