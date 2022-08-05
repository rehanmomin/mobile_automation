package com.hubilo.pageobjects.locators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.CacheLookup;

import java.util.List;

/**
 * @created: 2022-05-17-2:05 AM
 * @project: Hubilo_App_Automation under @package: @package: com.hubilo.pageobjects.locators
 * @author: Rehan
 **/


public class PeopleLocator {


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reception']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Reception\"`]")
    protected MobileElement reception;

    @AndroidFindBy(id = "thirdItem")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTabBar[`label == \"Tab Bar\"`]/XCUIElementTypeButton[3]")
    protected MobileElement menuTab;

    @AndroidFindBy(id = "imgMyMeetings")
    @iOSXCUITFindBy(id = "ic meet calendar")
    protected MobileElement meetingBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='People']")
    @iOSXCUITFindBy(id = "People")
    protected MobileElement people;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/relNotch")
    protected MobileElement notch;

    @iOSXCUITFindBy(id = "People")
    protected List<MobileElement> peopleList;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Tab Bar\"]/XCUIElementTypeButton[3]")
    protected MobileElement menuNew;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Speakers']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Speakers\"`]")
    protected MobileElement getSpeakerTab;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Speakers\"`]")
    protected List<MobileElement> getSpeakerTabList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Attendees']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Attendees\"`]")
    protected MobileElement getAttendeeTab;


    @AndroidFindBy(id = "imgMyMeetings")
    @iOSXCUITFindBy(id = "ic meet calendar")
    protected MobileElement meeting;

    @AndroidFindBy(id = "txtName")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeStaticText']")
    protected List<MobileElement> selectPeopleName;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtDesignation")
    protected MobileElement desig_org;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/edtTxtSearch")
    protected MobileElement searchInput;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgSort")
    protected MobileElement sortBtn;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgFilter")
    protected MobileElement filterBtn;

    @AndroidFindBy(id = "txtBookmark")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Bookmark\"`]")
    protected MobileElement bookmarkPeopleDetail;

    @AndroidFindBy(id = "edtTxtSearch")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Search\"`]")
    protected MobileElement search;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='All']")
    @iOSXCUITFindBy(id = "All")
    protected MobileElement allTab;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Speakers']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Speakers\"`]")
    protected MobileElement speakerTab;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Attendees']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Attendees\"`][1]" )
    protected MobileElement attendeeTab;

    @AndroidFindBy(id = "txtSpeaker")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText")
    protected MobileElement searchSpeakerLabel;

    @AndroidFindBy(id = "txtDelegate")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText")
    protected MobileElement searchAttendeeLabel;

    @AndroidFindBy(id = "txtEmpty")
    protected MobileElement emptyChat;

    @iOSXCUITFindBy(id = "Event feed")
    protected MobileElement feedPost;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtTimeZone")
    protected MobileElement meetingLanguage;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtAgendaForMeet")
    protected MobileElement agendaForMeet;



    @AndroidFindBy(id = "imgBack")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"backIcon\"`]")
    protected MobileElement backSearch;

    @AndroidFindBy(id = "tvAddNotes")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Add note\"`]")
    protected MobileElement notes;

    @AndroidFindBy(id = "edtTakeNote")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeTextView']")
    protected MobileElement takeNote;

    @AndroidFindBy(id = "txtSubmit")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Save\"`]")
    protected MobileElement saveBtn;

    @AndroidFindBy(id = "txtDelete")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Delete\"`]")
    protected MobileElement deleteBtn;

    @AndroidFindBy(id = "txtDate")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@index='0']")
    protected List<MobileElement> meetingSlots;

    @AndroidFindBy(id = "edtMeetingMsg")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"HubiloApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeTextView")
    protected MobileElement meetingDescription;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Create']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Create\"`]")
    protected MobileElement createMeeting;

    @AndroidFindBy(id = "txtChat")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Chat\"`]")
    protected MobileElement chat;

    @AndroidFindBy(id = "tvChatPersonName")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Bookmark Speaker\"`]")
    protected MobileElement personName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[@index='0']")
    protected List<MobileElement> personNameList;

    @AndroidFindBy(id = "edtSendMessage")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Enter your message\"`]")
    protected MobileElement inputChat;

    @AndroidFindBy(id = "imgSend")
    @iOSXCUITFindBy(id = "ic send message")
    protected MobileElement sendChatBtn;

    @AndroidFindBy(id = "tvTextMessage")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeTextView")
    protected List<MobileElement> verifyChat;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtSimilarProfileHeading")
    protected MobileElement similarProfileHeading;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/linSessionTime")
    protected MobileElement sessionDateTime;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtSessionName")
    protected MobileElement sessionName;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvSessionTitle")
    protected MobileElement verifySessionName;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtRegister")
    protected MobileElement registerBtn;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtStatus")
    protected MobileElement regStatus;


    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtSessionHeading")
    protected MobileElement sessionSpeakerHeading;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/relPeopleMain")
    protected MobileElement similarProfileTile;

    @AndroidFindBy(id = "imgThreeDots")
    @iOSXCUITFindBy(id = "ic more vertical")
    protected MobileElement threeDots;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete Chat']")
    @iOSXCUITFindBy(id = "Delete Chat")
    protected MobileElement deleteChat;

    @AndroidFindBy(id = "tvPositiveButton")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Delete\"`]")
    protected MobileElement confirmDeleteChat;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Delete\"`]")
    protected List<MobileElement> confirmDeleteChatList;

    @AndroidFindBy(id = "cancelBtn")
    @iOSXCUITFindBy(id = "backIcon")
    protected MobileElement backChat;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgProfile")
    protected MobileElement profileImage;

    @iOSXCUITFindBy(id = "close full alpha white")
    protected MobileElement closePeopleDetailPage;

    @AndroidFindBy(id = "/hierarchy/android.widget.Toast")
    protected MobileElement getToast;
}