package com.hubilo.pageobjects.functions;

import com.hubilo.pageobjects.locators.RoomsLocator;
import com.hubilo.utils.helper.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import static com.hubilo.utils.helper.file_locators.room_testdata;

public class Rooms extends RoomsLocator {

    private SoftAssert softAssert = new SoftAssert();
    private AppiumDriver driver;

    JsonPath jsonPath;
    public Rooms(AppiumDriver driver) {
        jsonPath=JsonPath.from(Utility.getJsonString(room_testdata));
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }


    public void verifyRoom(String testcase, String roomName, String moderatorName)
    {
        if(testcase.contains(jsonPath.getString("room.ANYONE_ROOM")))
            joinRoom(jsonPath.getString("room.ANYONE_ROOM"));
        else if(testcase.contains(jsonPath.getString("room.SEARCH_ROOM")))
            searchRoom(jsonPath.getString("room.CODED_ROOM"));
        else if(testcase.contains(jsonPath.getString("room.SORTING_A2Z")))
            sortA2Z(jsonPath.getString("room.MOD_ROOM"));
        else if (testcase.contains(jsonPath.getString("room.CODED_ROOM")))
            joinCoded(jsonPath.getString("room.CODED_ROOM"));
        else if (testcase.contains(jsonPath.getString("room.MOD_ROOM")))
            moderatorRoom(jsonPath.getString("room.MOD_ROOM"), jsonPath.getString("room.MOD_USER"));

    }

    private void gotoRoom() {
        Utility.gotoReception(driver);
        Utility.clickIOSReception(driver,reception, meetingBtn);
        Utility.sleep(1000);
        Utility.waitElement(driver).until((element)-> Utility.isAvailable(driver,menuIcon));
        menuIcon.click();
        Utility.sleep(2000);
        rooms.click();
        Utility.sleep(2000);
        softAssert.assertTrue(Utility.isAvailable(driver ,roomHeading));
        softAssert.assertTrue(Utility.isAvailable(driver ,tapNsearch));
        softAssert.assertAll();
    }

    @Step("Go to room section and join anyone to anyone room")
    private void joinRoom(String roomName) {
        gotoRoom();
        roomTitle.stream().
                filter(element -> element.getText().contains(roomName)).
                findFirst().get().click();
        softAssert.assertEquals(verifyRoomTitle.getText(),roomName,"verifyRoomTitle");
        joinRoomBtn.click();
        if(driver instanceof AndroidDriver)
        {
            Utility.permissionAllow(driver);
        }
        if(driver instanceof IOSDriver)
        {
            oKPermission.click();
            oKPermission.click();
        }
        Utility.sleep(1000);
        Utility.waitUntilElement(driver, startDiscussion);
        softAssert.assertEquals(startDiscussion.getText(),jsonPath.getString("room.DESCUSSION"),"startDiscussion");
        startDiscussion.click();
        Utility.waitUntilElement(driver,verifyUsername);
        softAssert.assertEquals(verifyUsername.getText(),jsonPath.getString("room.USER_NAME"),"verifyUsername");
        if(driver instanceof AndroidDriver) {
            softAssert.assertEquals(engagementsRoom.stream().
                    findFirst().get().getText(),jsonPath.getString("room.LIVE_CHAT"),"engagementsRoom");
            engagementsRoom.stream().findFirst().get().click();
        }else {
            softAssert.assertTrue(liveChat.isDisplayed(),"liveChat");
            liveChat.click();
        }
        String chat =jsonPath.getString("room.CHAT");
        inputChat.sendKeys(chat);
        sendChat.click();
        softAssert.assertEquals(verifyChat.getText(),chat,"verifyChat");
        backBtn.click();
        try{
            if(driver instanceof AndroidDriver){
                leaveTheRoom.click();}
        }catch (NoSuchElementException noSuchElementException){
            System.out.println("Exception occurred : "+noSuchElementException.getMessage());
            Utility.waitUntilElement(driver, backBtn);
            backBtn.click();
        }

        softAssert.assertAll();
    }

    @Step("Go to room section and search room by name")
    private void searchRoom(String roomName) {
        Utility.sleep(1000);
        tapNsearch.click();
        Utility.waitUntilElement(driver, tapNsearch);
        tapNsearch.sendKeys(roomName);
        softAssert.assertEquals(roomTitle.stream().findFirst().get().getText(),roomName,"roomTitle");
        searchBackButton.click();
        softAssert.assertAll();
    }

    @Step("Go to room and sorting room by A to Z order")
    private void sortA2Z(String roomName) {
        if(driver instanceof IOSDriver)
        {
            if(startDiscussionList.size() > 0)
            {
                backBtn.click();
            }
        }
        sortBtn.click();
        a2z.click();
        softAssert.assertNotEquals(roomTitle.stream().findFirst().get().getText(),roomName,"roomTitle");
        softAssert.assertAll();
    }

    @Step("Go to room and join coded room")
    private void joinCoded(String RoomName) {
        roomTitle.stream().
                filter(element -> element.getText().contains(RoomName)).
                findFirst().get().click();
        softAssert.assertEquals(verifyRoomTitle.getText(),RoomName,"verifyRoomTitle");
        joinRoomBtn.click();
        softAssert.assertEquals(codedRoomTitle.getText(),RoomName,"codedRoomTitle");
        code.sendKeys("1234");
        joinRoomBtn.click();
        Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(startDiscussion));
        softAssert.assertEquals(startDiscussion.getText(),jsonPath.getString("room.DESCUSSION"),"startDiscussion");
        startDiscussion.click();
        softAssert.assertEquals(verifyUsername.getText(),jsonPath.getString("room.USER_NAME"),"verifyUsername");
        Utility.waitUntilElement(driver, dismissBtn);
        dismissBtn.click();
        Utility.waitUntilElement(driver,leaveTheRoom);
        leaveTheRoom.click();
        softAssert.assertAll();
    }

    @Step("Go to room and join moderated room")
    private void moderatorRoom(String roomName, String moderatorName) {
        Integer x = roomHeading.getLocation().getX();
        Integer y = roomHeading.getLocation().getY();
        Utility.sleep(1000);
        roomTitle.stream().
                filter(element -> element.getText().contains(roomName)).
                findFirst().get().click();
        if(driver instanceof AndroidDriver) {
            softAssert.assertEquals(verifyRoomTitle.getText(),roomName,"verifyRoomTitle");
            softAssert.assertEquals(moderatorTitle.getText(),moderatorName,"joinModeratorBtn");
            softAssert.assertFalse(joinModeratorBtn.isEnabled(),"joinModeratorBtn");
        }else {
            softAssert.assertEquals(moderatedRoom.get(0).getText(),roomName,"moderatedRoom");
            softAssert.assertEquals(moderatedRoom.get(1).getText(),moderatorName,"moderatedRoom name");
            joinModeratorBtn.click();
            softAssert.assertTrue(moderatedRoom.get(0).getText().contains(roomName),"moderatedRoomVerify");
            reception.click();
            reception.click();
        }
        Utility.clickCordinate(driver, x,y);
        softAssert.assertAll();
    }
}