package com.hubilo.pageobjects.locators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;

import java.util.List;

/**
 * @created: 2022-05-17-2:06 AM
 * @project: Hubilo_App_Automation under @package: @package: com.hubilo.pageobjects.locators
 * @author: Rehan
 **/


public class RoomsLocator {
    @AndroidFindBy(id = "com.hubilo.v2.dev:id/thirdItem")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTabBar[`label == \"Tab Bar\"`]/XCUIElementTypeButton[3]")
    protected MobileElement menuIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Rooms' and @index='1']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[@name=\"Rooms\"]")
    protected MobileElement rooms;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/roomHeading")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"Rooms\"`]")
    protected MobileElement roomHeading;

    @AndroidFindBy(id = "imgMyMeetings")
    @iOSXCUITFindBy(id = "ic meet calendar")
    protected MobileElement meetingBtn;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/edtTxtSearch")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Search\"`]")
    protected MobileElement tapNsearch;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtEmpty")
    protected MobileElement noResultFountText;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtEmptyDesc")
    protected MobileElement getNoResultFountDescription;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgBack")
    @iOSXCUITFindBy(id = "backIcon")
    protected MobileElement searchBackButton;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgSort")
    @iOSXCUITFindBy(id = "ic sort")
    protected MobileElement sortBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Name (A - Z)']")
    @iOSXCUITFindBy(id = "Name (A - Z)")
    protected MobileElement a2z;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtRoomTitle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@visible='true']")
    protected List<MobileElement> roomTitle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"My Room\"`]")
    protected MobileElement roomText;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtRoomName")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[@index=3]")
    protected MobileElement verifyRoomTitle;

    @iOSXCUITFindBy(id = "My Room")
    protected List<MobileElement> verifyMyRoomTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@visible='true']")
    protected List<MobileElement> moderatedRoom;

    @iOSXCUITFindBy(id = "Coded Room")
    protected MobileElement codedRoom;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtHostName")
    protected MobileElement moderatorTitle;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvLabel")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Join Room\"`]")
    protected MobileElement joinModeratorBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Reception\"`]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reception']")
    protected MobileElement reception;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvLabel")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Join Room\"`]")
    protected MobileElement joinRoomBtn;

    @iOSXCUITFindBy(id = "OK")
    protected MobileElement oKPermission;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvDiscussion")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Start Discussion\"`]")
    protected MobileElement startDiscussion;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Start Discussion\"`]")
    protected List<MobileElement> startDiscussionList;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvTabTitle")
    protected List<MobileElement> engagementsRoom;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/edtSendMessage")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Enter your message\"`]")
    protected MobileElement inputChat;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/ivSend")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ic send message\"`]")
    protected MobileElement sendChat;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtRepliedMessage")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextView[`label == \"This is room chat \"`]")
    protected MobileElement verifyChat;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgCancel")
    @iOSXCUITFindBy(id = "backIcon")
    protected MobileElement backBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Leave the room']")
    @iOSXCUITFindBy(id = "Leave the room")
    protected MobileElement leaveTheRoom;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtUserName")
    @iOSXCUITFindBy(id = "Samual Macron")
    protected MobileElement verifyUsername;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    protected MobileElement whileUseApp;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    protected MobileElement allowBtn;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtTitleWithRoomName")
    @iOSXCUITFindBy(id = "coded room")
    protected MobileElement codedRoomTitle;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/edtRoomCode")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Enter code here....\"`]")
    protected MobileElement code;


    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgRoom")
    protected MobileElement searchRoomImage;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtRoomName")
    protected MobileElement roomName;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtHostName")
    protected List<MobileElement> isHostWithCount;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtDescription")
    protected MobileElement roomDescription;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgCancel")
    protected MobileElement backDis;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/relExitCall")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[1]")
    protected MobileElement dismissBtn;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvDiscussion")
    protected MobileElement discussionBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='People']")
    protected MobileElement peopleTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Live Chat']")
    @iOSXCUITFindBy(id = "Live Chat")
    protected MobileElement liveChat;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Participants']")
    protected MobileElement perticipants;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Spectators']")
    protected MobileElement spectators;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgMuteAudio")
    protected MobileElement audioBtn;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgMuteVideo")
    protected MobileElement videoBtn;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgSwitchCamera")
    protected MobileElement switchCamera;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgScreenShare")
    protected MobileElement screenshareBtn;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtTitle")
    protected MobileElement exitDialogTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Leave the room']")
    protected MobileElement leaveRoom;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvGoSpectorOrEndRoom")
    protected MobileElement spectatorScreen;

}