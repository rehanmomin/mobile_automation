package com.hubilo.pageobjects.functions;

import com.hubilo.pageobjects.locators.PeopleLocator;
import com.hubilo.utils.helper.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

public class People extends PeopleLocator {

    private AppiumDriver driver;
    private SoftAssert softAssert = new SoftAssert();

    public People(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void verifyPeople(String testcase, String peopleName, String message) {
        String msg = message.isEmpty() ? "this is default text" : message;
        switch (testcase){
            case "verify speaker and attendee tabs":
                verifyTabs();
                break;
            case "verify bookmark and unbookmark speaker":
                verifybookmarkUnbookmark(peopleName,"speaker",msg);
                break;
            case "verify bookmark and unbookmark attendee":
                verifybookmarkUnbookmark(peopleName,"attendee",msg);
                break;
            case "verify speaker note":
                verifyNote(peopleName,"speaker",msg);
                break;
            case "verify attendee note":
                verifyNote(peopleName,"attendee",msg);
                break;
            case "verify speaker chat":
                verifyChat(peopleName,"speaker",msg);
                break;
            case "verify attendee chat":
                verifyChat(peopleName,"attendee",msg);
                break;
            case "verify speaker create meeting":
                verifyCreateMeeting(peopleName, "speaker");
                break;
            case "verify attendee create meeting":
                verifyCreateMeeting(peopleName, "attendee");
                break;
            case "verify speaker search":
                verifySearch(peopleName,"speaker");
                break;
            case "verify attendee search":
                verifySearch(peopleName,"attendee");
                break;
        }
    }

    private Integer x;
    private Integer y;

    @Step("Go to People section and verify speaker and attendee tabs")
    public void verifyTabs() {
        Utility.sleep(1000);
        Utility.gotoReception(driver);
        reception.click();
        meetingBtn.click();
        reception.click();
        Utility.sleep(1000);
            Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(menuTab));
        menuTab.click();
        if(driver instanceof IOSDriver)
        {
            if(peopleList.size() < 1)
            {
                menuNew.click();
        }}
        people.click();
        Utility.waitUntilElement(driver,getSpeakerTab);
        softAssert.assertEquals(getSpeakerTab.getText(), "Speakers");
        softAssert.assertEquals(getAttendeeTab.getText(), "Attendees");
        x = meeting.getLocation().getX();
        y = meeting.getLocation().getY();
        softAssert.assertAll();
    }

    @Step("verify user able bookmark/unbookmark for user type {peopleType} and user name : {peopleName}")
    private void verifybookmarkUnbookmark(String peopleName, String peopleType, String noteMsg) {
        if (peopleType.contains("speaker")) {
            getSpeakerTab.click();
            profileDetailPage(peopleName,"bookmark",noteMsg);
        }
        if (peopleType.contains("attendee")) {
            getAttendeeTab.click();
            profileDetailPage(peopleName,"bookmark",noteMsg);
        }
    }

    @Step("verify user able to add/delete note for user type {peopleType} and user name : {peopleName}")
    private void verifyNote(String peopleName, String peopleType, String noteMsg) {
        if (peopleType.contains("speaker")) {
            getSpeakerTab.click();
            profileDetailPage(peopleName,"note",noteMsg);
            if(driver instanceof IOSDriver)
            {
                chat.click();
                backChat.click();
                closePeopleDetailPage.click();
            }
        }
        if (peopleType.contains("attendee")) {
            getAttendeeTab.click();
            profileDetailPage(peopleName,"note",noteMsg);
            if(driver instanceof IOSDriver)
            {
                chat.click();
                backChat.click();
                closePeopleDetailPage.click();
            }
        }
    }

    @Step("verify user able to search user type {peopleType} and user name : {peopleName} under all and respective tabs")
    private void verifySearch(String peopleName, String peopleType) {
        if (peopleType.contains("speaker")) {
            getSpeakerTab.click();
            search(peopleName, peopleType);
        }
        if (peopleType.contains("attendee")) {
            getAttendeeTab.click();
            search(peopleName, peopleType);
        }
    }

    @Step("verify user able to create meeting for user type {peopleType} and user name : {peopleName}")
    public void verifyCreateMeeting(String peopleName, String peopleType){
        if (peopleType.contains("speaker")) {
            getSpeakerTab.click();
            meet(peopleName);
        }
        if (peopleType.contains("attendee")) {
            getAttendeeTab.click();
            meet(peopleName);
        }
    }

    @Step("verify user able to chat under user type {peopleType} and user name : {peopleName} profile")
    private void verifyChat(String peopleName, String peopleType, String chatMsg){
        if (peopleType.contains("speaker")) {
            getSpeakerTab.click();
            chat(peopleName,chatMsg);
        }
        if (peopleType.contains("attendee")) {
            getAttendeeTab.click();
            chat(peopleName,chatMsg);
        }
    }


    private void chat(String name, String message){
        Utility.sleep(1000);
        Utility.waitElement(driver).until(ExpectedConditions.
                visibilityOf(selectPeopleName.stream().filter(element -> element.getText().contains(name)).
                        findFirst().get())).click();
        chat.click();
        if(driver instanceof AndroidDriver) {
            softAssert.assertTrue(personName.getText().contains(name));
        } else {
            softAssert.assertTrue(personNameList.get(2).getText().contains(name));
        }
        inputChat.sendKeys(message);
        sendChatBtn.click();
        softAssert.assertTrue(verifyChat.size()>0);
//        threeDots.click();
//        deleteChat.click();
//        confirmDeleteChat.click();
        if(driver instanceof IOSDriver)
        {
            backChat.click();
            closePeopleDetailPage.click();
        }else {
            backChat.click();
            Utility.waitUntilElement(driver, chat);
            Utility.clickCordinate(driver, x, y);
        }
        softAssert.assertAll();
    }

    public void verifyUIMessageBookmark(String peopleName){
        Utility.sleep(1000);
        Utility.waitElement(driver).until(ExpectedConditions.
                visibilityOf(selectPeopleName.stream().filter(element -> element.getText().contains(peopleName)).
                        findFirst().get())).click();
        if (driver instanceof AndroidDriver){
            Utility.scrollUp(driver, notch, x, y);
        }
        softAssert.assertTrue(Utility.isAvailable(driver, chat),"verify chat icon visible");
        softAssert.assertTrue(Utility.isAvailable(driver, bookmarkPeopleDetail), "verify bookmark profile");
        backChat.click();
        softAssert.assertAll();
    }

    public void verifyIsCategory(String type){
        reception.click();
        menuTab.click();
        people.click();
        if(type.equalsIgnoreCase("speakers")){
            softAssert.assertFalse(
                    driver.findElements(
                            MobileBy.xpath("//android.widget.TextView[@text='Speakers']")).size()>0,
                    "verify speaker tab visible");
        } else if (type.equalsIgnoreCase("attendees")) {
            softAssert.assertFalse(
                    driver.findElements(
                            MobileBy.xpath("//android.widget.TextView[@text='Attendees']")).size()>0,
                    "verify attendee tab visible");
        }else{
            softAssert.assertTrue(
                    driver.findElements(
                            MobileBy.xpath("//android.widget.TextView[@text='"+type+"']")).size()>0,
                    "verify updated tab visible");
            System.out.println("invalid category selected");
        }
    }

    public void verifySessionWithSpeaker(String peopleName, boolean isRegistered){
        int m = 0,n = 0;
        Utility.sleep(1000);
        Utility.waitElement(driver).until(ExpectedConditions.
                visibilityOf(selectPeopleName.stream().filter(element -> element.getText().contains(peopleName)).
                        findFirst().get())).click();
        if (driver instanceof AndroidDriver){
            Utility.scrollUp(driver, notch, x, y);
            m = backChat.getLocation().getX();
            n = backChat.getLocation().getY();
        }
        softAssert.assertTrue(Utility.isAvailable(driver, sessionSpeakerHeading), "verify linked session with speaker");
        softAssert.assertTrue(Utility.isAvailable(driver, sessionDateTime), "verify session date time visible");
        softAssert.assertTrue(Utility.isAvailable(driver, sessionName), "verify session name visible");
        sessionName.click();
        softAssert.assertTrue(Utility.isAvailable(driver, verifySessionName), "verify session name on detail page");
        if(isRegistered){
            registerBtn.click();
            softAssert.assertTrue(regStatus.getText().contains("Registration Confirmed"), "register status");
            Utility.sleep(1000);
            //softAssert.assertTrue();
        }
        if(driver instanceof IOSDriver) {
            backChat.click();
            closePeopleDetailPage.click();
        }else {
            Utility.clickCordinate(driver, m, n);
            Utility.sleep(1000);
            Utility.clickCordinate(driver, m, n);
        }
        softAssert.assertAll();
    }

    public void verifySimilarProfile(String peopleName){
        int m=0,n=0;
        Utility.sleep(1000);
        Utility.waitElement(driver).until(ExpectedConditions.
                visibilityOf(selectPeopleName.stream().filter(element -> element.getText().contains(peopleName)).
                        findFirst().get())).click();
        if (driver instanceof AndroidDriver){
            Utility.scrollUp(driver, notch, x, y);
            m = backChat.getLocation().getX();
            n = backChat.getLocation().getY();
        }
        softAssert.assertTrue(Utility.isAvailable(driver, similarProfileHeading), "verify similar profile heading");
        similarProfileTile.click();
        if(driver instanceof IOSDriver) {
            backChat.click();
            closePeopleDetailPage.click();
        }else {
            Utility.clickCordinate(driver, m, n);
            Utility.sleep(1000);
            Utility.clickCordinate(driver, m, n);
        }
        softAssert.assertAll();
    }

    public void verifyAttendeeImage(String name){
        Utility.sleep(1000);
        Utility.waitElement(driver).until(ExpectedConditions.
                visibilityOf(selectPeopleName.stream().filter(element -> element.getText().contains(name)).
                        findFirst().get())).click();
        softAssert.assertTrue(Utility.isAvailable(driver, profileImage),"verify image visible");
        if (driver instanceof AndroidDriver){
            Utility.clickCordinate(driver,x,y);
        }
        softAssert.assertAll();
    }
    public void verifyPeopleDetailPage(String name, String design){
        Utility.sleep(1000);
        Utility.waitElement(driver).until(ExpectedConditions.
                visibilityOf(selectPeopleName.stream().filter(element -> element.getText().contains(name)).
                        findFirst().get())).click();
        System.out.println(" people name : "+selectPeopleName.stream().filter(element -> element.getText().contains(name)).
                findFirst().get().getText());
        if (driver instanceof AndroidDriver){
            Utility.scrollUp(driver, notch, x, y);
        }
        softAssert.assertTrue(Utility.isAvailable(driver, profileImage));
        boolean isPeopleName = selectPeopleName.stream().filter(element -> element.getText().contains(name)).findFirst().isPresent();
        softAssert.assertTrue(isPeopleName, " verifying people name opened profile");
        softAssert.assertEquals(desig_org.getText(), design);// designation and organization
        softAssert.assertTrue(Utility.isAvailable(driver, bookmarkPeopleDetail));
        softAssert.assertAll();
    }

    public void verifyAttendeePage(String name){
        getAttendeeTab.click();
        softAssert.assertTrue(Utility.isAvailable(driver, searchInput));
        softAssert.assertTrue(Utility.isAvailable(driver, sortBtn));
        softAssert.assertTrue(Utility.isAvailable(driver, filterBtn));
        softAssert.assertAll();
    }

    public void verifyMeetDescription(String name){
        int m = 0,n=0;
        Utility.sleep(1000);
        Utility.waitElement(driver).until(ExpectedConditions.
                visibilityOf(selectPeopleName.stream().filter(element -> element.getText().contains(name)).
                        findFirst().get())).click();
        System.out.println(" people name : "+selectPeopleName.stream().filter(element -> element.getText().contains(name)).
                findFirst().get().getText());
        if (driver instanceof AndroidDriver){
            Utility.scrollUp(driver, notch, x, y);
            m = backChat.getLocation().getX();
            n = backChat.getLocation().getY();
        }
        meetingSlots.stream().findFirst().get().click();
        softAssert.assertEquals(meetingDescription.getText(), "Hi Samual, I would like to connect with you.","verifying meeting description");
        if (driver instanceof AndroidDriver){
            Utility.clickCordinate(driver, m,n);
            Utility.waitUntilElement(driver, backChat);
            backChat.click();
        }
        softAssert.assertAll();
    }

    public void verifyMeetLang_AgendaForMeet(String name){
        int m = 0,n=0;
        Utility.sleep(1000);
        Utility.waitElement(driver).until(ExpectedConditions.
                visibilityOf(selectPeopleName.stream().filter(element -> element.getText().contains(name)).
                        findFirst().get())).click();
        System.out.println(" people name : "+selectPeopleName.stream().filter(element -> element.getText().contains(name)).
                findFirst().get().getText());
        if (driver instanceof AndroidDriver){
            Utility.scrollUp(driver, notch, x, y);
            m = backChat.getLocation().getX();
            n = backChat.getLocation().getY();
        }
        meetingSlots.stream().findFirst().get().click();
        softAssert.assertTrue(Utility.isAvailable(driver, meetingLanguage),"verify language timezone");
        softAssert.assertTrue(Utility.isAvailable(driver, agendaForMeet),"verify Agenda for meeting");
        if (driver instanceof AndroidDriver){
            Utility.clickCordinate(driver, m,n);
            Utility.waitUntilElement(driver, backChat);
            backChat.click();
        }
        softAssert.assertAll();
    }


    private void meet(String name){
        Utility.sleep(1000);
        Utility.waitElement(driver).until(ExpectedConditions.
                visibilityOf(selectPeopleName.stream().filter(element -> element.getText().contains(name)).
                        findFirst().get())).click();
        System.out.println(" people name : "+selectPeopleName.stream().filter(element -> element.getText().contains(name)).
                findFirst().get().getText());
        if (driver instanceof AndroidDriver){
            Utility.scrollUp(driver, notch, x, y);
        }
        meetingSlots.stream().findFirst().get().click();
        softAssert.assertTrue(Utility.isAvailable(driver, meetingDescription));
        createMeeting.click();
        softAssert.assertTrue(Utility.isAvailable(driver, notes));
        if(driver instanceof IOSDriver)
        {
            chat.click();
            backChat.click();
            closePeopleDetailPage.click();
        }else {
            Utility.waitUntilElement(driver, backChat);
            backChat.click();
            //Utility.clickCordinate(driver, x, y);
        }
        softAssert.assertAll();
    }
    private void profileDetailPage(String name, String type, String noteMsg) {
        //softAssert.assertTrue(title.stream().findFirst().get().getText().contains(name));
        Utility.sleep(1000);
        Utility.waitElement(driver).until(ExpectedConditions.
                visibilityOf(selectPeopleName.stream().filter(element -> element.getText().contains(name)).
                        findFirst().get())).click();
        if (type.contains("bookmark")) {
            bookmarkPeopleDetail.click();
            System.out.println(" user bookmark ");
        }
        else if (type.contains("unbookmark")){
            bookmarkPeopleDetail.click();
            System.out.println(" user bookmark ");
        }
        else if (type.contains("note")) {
            notes.click();
            if(takeNote.getText().contains(noteMsg)) {
                deleteBtn.click();
                if(driver instanceof AndroidDriver) {
                    confirmDeleteChat.click();
                }else {
                    confirmDeleteChatList.get(1).click();
                }
            }else {
                takeNote.sendKeys(noteMsg);
                saveBtn.click();
            }
        }
        Utility.sleep(1000);
        Utility.clickCordinate(driver, x, y);
        softAssert.assertAll();
    }


    private void search(String name, String peopleType) {
        search.click();
        //Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(search));
        Utility.sleep(1000);
        search.sendKeys(name);
        allTab.click();
        if (peopleType.contains("speaker")) {
            softAssert.assertTrue(Utility.isAvailable(driver, searchSpeakerLabel));
            softAssert.assertTrue(selectPeopleName.stream().
                    filter(element -> element.getText().contains(name)).count() > 0);
            speakerTab.click();
            softAssert.assertTrue(selectPeopleName.stream().
                    filter(element -> element.getText().contains(name)).count() > 0);
        }
        if (peopleType.contains("attendee")) {
            softAssert.assertTrue(Utility.isAvailable(driver, searchAttendeeLabel));
            softAssert.assertTrue(selectPeopleName.stream().
                    filter(element -> element.getText().contains(name)).count() > 0);
            attendeeTab.click();
            softAssert.assertTrue(selectPeopleName.stream().
                    filter(element -> element.getText().contains(name)).count() > 0);
        }
        backSearch.click();
        softAssert.assertAll();
    }

    public void SimilarProfile(String attendeeName) {

    }
}