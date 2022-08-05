package com.hubilo.pageobjects.functions;

import com.hubilo.base.BasePage;
import com.hubilo.pageobjects.locators.MultiEventLocator;
import com.hubilo.pojo.ui.LoginData;
import com.hubilo.utils.helper.Logger;
import com.hubilo.utils.helper.Utility;
import com.hubilo.utils.helper.apit_testdata;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;

import java.time.Duration;


public class MultiEvent extends MultiEventLocator {

    private AppiumDriver driver;

    public MultiEvent(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver, Duration.ofSeconds(10)), this);
    }

    @Step("User selects : {eventName} events")
    private void selectOngoingEvents(String eventName) {

        if (driver instanceof IOSDriver) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            ongoingEventList.get(1).click();
        } else {
            validateElementOnScreen();
            Logger.info("Number of Ongoing-live events : " + ongoingEvent.getText());
            ongoingEvent.click();
        }
        selectFromListEvent(eventName);
    }

    @Step("User selects : {eventName} events")
    private void selectAllEvents(String eventName) {
        Logger.info("Number of Ongoing-live events : " + allEvent.getText());
        allEvent.click();
        selectFromListEvent(eventName);
    }

    @Step("User selects : {eventName} events")
    private void selectUpcomingEvents(String eventName) {
        Logger.info("Number of Ongoing-live events : " + upcomingEvent.getText());
        upcomingEvent.click();

    }

    @Step("User selects : {eventName} events")
    private void selectPastEvents(String eventName) {
        Logger.info("Number of Ongoing-live events : " + pastEvent.getText());
        pastEvent.click();
        selectFromListEvent(eventName);
    }

    private void selectFromListEvent(String eventName) {
        new Utility().startscrolling(driver, eventName);

    }

    private void validateElementOnScreen() {
        Utility.waitUntilElement(driver, ongoingLive);
        Assert.assertTrue(Utility.isAvailable(driver,ongoingLive));
        Assert.assertTrue(Utility.isAvailable(driver,firstFeaturedEventTitle));
        Assert.assertTrue(Utility.isAvailable(driver,firstFeaturedEventDate));
        Assert.assertTrue(Utility.isAvailable(driver,firstFeaturedEventJoinBtn));
    }

    @Step("Launch app and select event from the Multi Event List")
    public void selectEvent(LoginData loginData) {
        //Logger.info("Number of Ongoing-live events : " + allEvent.getText());
        Utility.sleep(1000);
        try{
            if(driver instanceof AndroidDriver){
                Utility.swipeToRefreshMultievent(driver);
            }
        }catch (NoSuchElementException noSuchElementException){
            noSuchElementException.printStackTrace();
        }
        switch (loginData.getEventType()) {
            case "all": selectAllEvents(apit_testdata.eventname.get()); break;
            case "onGoing": selectOngoingEvents(apit_testdata.eventname.get()); break;
            case "upComing": selectUpcomingEvents(apit_testdata.eventname.get()); break;
            case "past": selectPastEvents(apit_testdata.eventname.get()); break;
        }
    }

    public void appController(String eventid, String orgid, String eventtype, String env) {
        try {
            if (driver instanceof AndroidDriver) {
                eventId.sendKeys(eventid);
                orgId.sendKeys(orgid);
                selectEventType.click();
                selectMultiEvent.click();
                selectEnv.click();
                selectReleaseEnv.click();
                proceedBtn.click();
                driver.launchApp();
            } else {
                allowNotification.click();
                eventId.sendKeys(eventid);
                orgId.sendKeys(orgid);
                multiEventSelect.click();
                devSelected.click();
                Utility.clickCordinate(driver, 30, 800);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                Utility.clickCordinate(driver, 30, 800);
                proceedBtn.click();
            }
        }catch (NoSuchElementException noSuchElementException){
            throw new SkipException("app controller screen skipped");
        }
    }
}