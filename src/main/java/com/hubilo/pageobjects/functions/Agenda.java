package com.hubilo.pageobjects.functions;
import com.hubilo.pageobjects.locators.AgendaLocator;
import com.hubilo.utils.helper.Logger;
import com.hubilo.utils.helper.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

public class Agenda extends AgendaLocator {

    private AppiumDriver driver;
    private SoftAssert softAssert = new SoftAssert();

    public Agenda(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    String today = "Today,";
    String futureSessionDate = "Today";
    public void verifyAgenda(String testCaseName, String agendaName) {

        switch (testCaseName) {
            case "verifyAgendaCTA": verifyAgendaCTA(agendaName); break;
            case "verify pagination for session list": verifyPagination(agendaName); break;
            case "verify add to schedule agenda": verifyAddToScheduleAgenda(); break;
            case "verify show live agenda toggle should clickable": verifyLiveAgendaToggle(agendaName); break;
            case "verify engagement": verifyEngagements(agendaName); break;
            case "verify add and remove notes": verifyAddRemoveNotes(agendaName); break;
            case "verify search session": searchSession(agendaName); break;
        }
    }

    @Step("Go to Agenda, Open session {agendaName} and verify Session name, Date and time with Join/Watch session CTA")
    private void verifyAgendaCTA(String agendaName) {
        toggle2LiveSession.click();
        if(driver instanceof IOSDriver)
        {
            Utility.sleep(1000);
            List<MobileElement> sessionsList = (List<MobileElement>) driver.findElements(By.xpath("//XCUIElementTypeStaticText[@name='"+agendaName+"']"));
            sessionsList.stream().filter(element -> element.getText().contains(agendaName)).collect(Collectors.toList()).get(0).click();
        }else {
             Utility.waitElement(driver).until((element)-> Utility.isAvailable(driver,sessionList.get(0)));
             sessionList.stream().filter(element -> element.getText().contains(agendaName)).collect(Collectors.toList()).get(0).click();
             softAssert.assertTrue(Utility.isAvailable(driver, detailSessionDate));
            softAssert.assertTrue(Utility.isAvailable(driver, detailSessionPage));
        }
        softAssert.assertTrue(sessionList.stream().findFirst().get().getText().contains(agendaName));
        sessionJoin_Watch_View_DetailBtn.click();
        Utility.sleep(1000);
        if(driver instanceof AndroidDriver) {
            Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(sessionList.stream().findFirst().get()));
            softAssert.assertTrue(Utility.isAvailable(driver, sessionList.stream().findFirst().get()));
            softAssert.assertTrue(Utility.isAvailable(driver, afterJoinDate));
            Utility.sleep(1000);
        }else{
            Utility.sleep(1000);
            Utility.waitElement(driver).until((element)-> Utility.isAvailable(driver,verifyHBSSessionName));
            softAssert.assertTrue(Utility.isAvailable(driver,verifyHBSSessionName));
            Utility.sleep(1000);
            verifyHBSSessionName.click();
//            Utility.waitElement(driver).until((element)-> Utility.isAvailable(driver,playTab));
//            driver.findElementById("Play").click();
//            Utility.sleep(1000);
//            driver.findElementById("Pause").click();
        }
        sessionBack.click();
        Utility.sleep(1000);
        if(driver instanceof AndroidDriver) {
            try {
                if (fourth.isDisplayed()) {
                    fourth.click();
                    closePIP.click();
                }
            } catch (NoSuchElementException noSuchElementException) {
                noSuchElementException.getMessage();
            }
        }
        softAssert.assertTrue(Utility.isAvailable(driver, showLiveAgendaText));
        toggle2LiveSession.click();
    }

    @Step("Go to Agenda, enable show live session toggle and verify live {agendaName} session should visible")
    private void verifyLiveAgendaToggle(String agendaName) {
        toggle2LiveSession.click();
        if(driver instanceof AndroidDriver) {
            softAssert.assertTrue(sessionList.stream()
                    .filter(element -> element.getText().equalsIgnoreCase(agendaName))
                    .findFirst().isPresent());
        }else{
            List<MobileElement> melement = (List<MobileElement>) driver.findElements(By.xpath("//XCUIElementTypeStaticText[@name='"+agendaName+"']"));
            softAssert.assertTrue(melement.size()>0);
        }
        toggle2LiveSession.click();
    }

    @Step("Go to Agenda, verify past session tab and future session tab")
    private void verifyPagination(String agendaName) {
       if(driver instanceof AndroidDriver){
            Utility.sleep(1000);
            Utility.waitUntilElement(driver, pagination.stream().findFirst().get());
            System.out.println(pagination.get(0).getText());
            int index = Utility.getSearchIndex(pagination, today);
            pagination.get(index).click();
            softAssert.assertTrue(sessionList.stream().count() > 0);
            pagination.get(index+1).click();
            softAssert.assertTrue(sessionList.stream().count() > 0);
        }else{
            agendaTab.click();
           agendaTab.click();
           Utility.waitUntilElement(driver, pagination.stream().findFirst().get());
           int index = Utility.getSearchIndex(pagination, today);
           if(index >= 1)
           {
               pagination.get(index-1).click();
           }else{
               pagination.get(index).click();
           }
          // int paginationSize = pagination.size();
          // pagination.get(paginationSize-2).click();
          // System.out.println(pastEventText.size());
            softAssert.assertTrue(pastEventText.size() > 0);
           //pagination.get(paginationSize-1).click();
           pagination.get(index+1).click();
           System.out.println(futureEventText.size());
           softAssert.assertTrue(futureEventText.size() > 0);
           agendaTab.click();
        }
    }

    @Step("Go to Agenda, Open future session and add to schedule, go to meetings tab and verify agenda present")
    private void verifyAddToScheduleAgenda() {
        if(driver instanceof AndroidDriver){
            //System.out.println(pagination.stream().filter(element -> element.getText().contains(futureSessionDate)).findFirst().get().getText());
            int size = pagination.size();
            pagination.get(size-1).click();
            String futureSessionName = Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(sessionList.stream().findFirst().get())).getText();
            Logger.info("session future : "+futureSessionName);
            if(driver instanceof AndroidDriver){
                sessionList.stream().findFirst().get().click();
            }else {
                sessionList.get(1).click();
            }
            addToSchedule.click();
            Utility.goBack(driver);
            myMeetings.click();
            meetingAgendaTab.click();
            softAssert.assertTrue(sessionList.stream().findFirst().isPresent());
            goToAgendaTab();
            pagination.get(size-1).click();
            sessionList.stream().filter(element -> element.getText().contains(futureSessionName)).findFirst().get().click();
            addToSchedule.click();
            Utility.goBack(driver);
            softAssert.assertAll();
        }else{
            agendaTab.click();
            int index = Utility.getSearchIndex(pagination, today);
            pagination.get(index+1).click();
         //   int size = pagination.size();
          //  pagination.get(size-1).click();
          //  futureEvent.click();
            futureEventList.get(0).click();
            Utility.waitElement(driver).until((element)-> Utility.isAvailable(driver,addToSchedule));
            addToSchedule.click();
         //   if(sessionViewDetail.size() >0) {
                sessionViewDetail.get(0).click();
//            }else {
//                sessionJoin_Watch_View_DetailBtn.click();
//            }
            if(sessionBackList.size() > 0)
            {
                sessionBack.click();
            }else {
                Utility.waitElement(driver).until((element)-> Utility.isAvailable(driver,liveChatEngagement));
                liveChatEngagement.click();
                noConversationYetTextClick.click();
                sessionBack.click();
            }
       //     Utility.waitElement(driver).until(ExpectedConditions.stalenessOf(clickSpeakerTextToEnableBack));
//            clickSpeakerTextToEnableBack.click();
            myMeetings.click();
            meetingAgendaTab.click();
      //      Utility.waitElement(driver).until((element)-> Utility.isAvailable(driver,futureEventList.get(0)));
            softAssert.assertTrue(futureEventList.size()>0);
            agendaTab.click();
            agendaTab.click();
           // Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(futureEvent));
           // futureEvent.click();
            pagination.get(index+1).click();
           // pagination.get(size-1).click();
            futureEventList.get(0).click();
            addToScheduleremove.click();
            sessionViewDetail.get(0).click();
            if(sessionBackList.size() > 0)
            {
                sessionBack.click();
            }else {
                Utility.waitElement(driver).until((element)-> Utility.isAvailable(driver,liveChatEngagement));
                liveChatEngagement.click();
                noConversationYetTextClick.click();
                sessionBack.click();
            }
            //softAssert.assertAll();
        }
    }


    @Step("join session {agendaName} and verify all engagements")
    private void verifyEngagements(String agendaName){
        Utility.waitElement(driver).until((element)-> Utility.isAvailable(driver,toggle2LiveSession));
        //toggle2LiveSession.click();
        new Utility().scrollDown(driver);
        if(driver instanceof IOSDriver)
        {
            new Utility().scrollDown(driver);
        }
        Utility.sleep(1000);
        sessionList.stream().
                filter((element -> element.getText().contains(agendaName))).
                findFirst().get().click();
        Utility.sleep(1000);
        sessionJoin_Watch_View_DetailBtn.click();
        Utility.sleep(1000);
        Utility.waitElement(driver).until((element)-> Utility.isAvailable(driver,liveChatEngagement));
        liveChatEngagement.click();
        Utility.sleep(1000);
        Utility.waitElement(driver).until((element)-> Utility.isAvailable(driver,pollsEngagement));
        pollsEngagement.click();
        Utility.waitElement(driver).until((element)-> Utility.isAvailable(driver,q_and_qEngagement));
        q_and_qEngagement.click();
        Utility.waitElement(driver).until((element)-> Utility.isAvailable(driver,attendeesEngagement));
        attendeesEngagement.click();
        if(driver instanceof AndroidDriver) {
            backFromJoined.click();
            Utility.goBack(driver);
        }else {
            liveChatEngagement.click();
            noConversationYetTextClick.click();
            sessionBack.click();
            meetingBtn.click();
            agendaTab.click();
            agendaTab.click();
        }
    }

    @Step("Open session {agendaName} detail page and add remove notes")
    private void verifyAddRemoveNotes(String agendaName){
        Utility.waitElement(driver).until((element)-> Utility.isAvailable(driver,toggle2LiveSession));
        Integer x = meetingBtn.getLocation().getX();
        Integer y = meetingBtn.getLocation().getY();
        toggle2LiveSession.click();
        sessionList.stream().
                filter((element -> element.getText().equalsIgnoreCase(agendaName))).
                findFirst().get().click();
        notes.click();
        Assert.assertTrue(Utility.isAvailable(driver, noteTitle));
        editNote.sendKeys("This is my notes, need to delete");
        deleteNote.click();
        if(driver instanceof AndroidDriver) {
//            try{
//                confirmDelete.get(0).click();
//                if (closePIP.isDisplayed()){
//                    closePIP.click();
//                }
//            }catch (NoSuchElementException noSuchElementException){
//                noSuchElementException.getMessage();
//            }
            Utility.waitUntilElement(driver, confirmDelete.get(0));
            confirmDelete.stream().findFirst().get().click();
        }else {
            confirmDelete.get(1).click();
        }
        Utility.waitUntilElement(driver, notes);
        notes.click();
        editNote.sendKeys("This is note description");
        saveNote.click();
        Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(sessionJoin_Watch_View_DetailBtn));
        if(driver instanceof IOSDriver ){
            sessionJoin_Watch_View_DetailBtn.click();
            sessionBack.click();
            meetingBtn.click();
            agendaTab.click();
        } else {
            Utility.sleep(1000);
            Utility.clickCordinate(driver,x,y);
        }
    }

    @Step("Click on search button and enter session name : {agendaName}")
    private void searchSession(String agendaName){
        searchBtn.click();
        searchInputBox.sendKeys("Youtube Session");
        if(driver instanceof AndroidDriver) {
            Utility.sleep(1000);
            Assert.assertTrue(Utility.isAvailable(driver, sessionList.stream().findFirst().get()));
            backBtn.click();
            softAssert.assertAll();
        }else{
            Assert.assertTrue(youtubeSession.size()>0);
            backBtn.click();
            agendaTab.click();
        }
    }

    public void goToAgendaTab() {
        Utility.gotoReception(driver);
        agendaTab.click();
        Utility.sleep(1000);
        softAssert.assertTrue(showLiveAgenda.size()>0);
        softAssert.assertAll();
    }

    public void goToAgendaTab1() {
        if (Utility.isAvailable(driver,agendaTab) && driver instanceof AndroidDriver) {
            agendaTab.click();
            softAssert.assertTrue(showLiveAgenda.size()>0);
            softAssert.assertAll();
        }else {
            agendaTab.click();
        }
    }

    private void goToLiveAgenda() {
        Utility.waitUntilElement(this.driver, toggle2LiveSession);
        try {
            if (sessionList.size() >= 0) {
                softAssert.assertTrue(Utility.isAvailable(driver, getSessionTime));
                softAssert.assertTrue(Utility.isAvailable(driver, getSessionCount));
            }
        } catch (NoSuchElementException noSuchElementException) {
            noSuchElementException.getMessage();
        }
        softAssert.assertAll();
    }
}