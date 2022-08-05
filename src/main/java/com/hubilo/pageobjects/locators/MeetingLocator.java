package com.hubilo.pageobjects.locators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

/**
 * @created: 2022-05-17-2:05 AM
 * @project: Hubilo_App_Automation under @package: @package: com.hubilo.pageobjects.locators
 * @author: Rehan
 **/


public class MeetingLocator {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reception']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Reception\"`]")
    protected MobileElement reception;

    @AndroidFindBy(id = "imgMyMeetings")
    @iOSXCUITFindBy(id = "ic meet calendar")
    protected MobileElement meetingBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Meetings']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Meetings\"`]")
    protected MobileElement meetingTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Agenda']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Agenda\"`][1]")
    protected MobileElement agendaTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No Upcoming Meetings']")
    protected MobileElement noMeetingAvailable;

    @AndroidFindBy(id = "tvMeetingDate")
    protected List<MobileElement> meetingDate;


    @AndroidFindBy(id = "txtMeetingTime")
    protected List<MobileElement> meetingTime;

    @AndroidFindBy(id = "tvMeetingStatus")
    protected List<MobileElement> meetingStatus;

    @AndroidFindBy(id = "txtUserName")
    @iOSXCUITFindBy(id = "Samul Macron")
    protected List<MobileElement> meetingUserName;

    @AndroidFindBy(id = "txtAbout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"HubiloApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeTextView")
    protected List<MobileElement> meetingDescription;

    @AndroidFindBy(id = "txtDesignationAtOrganization")
    protected List<MobileElement> desorg;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Withdraw']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Withdraw\"`]")
    protected List<MobileElement> meetingWithdraw;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cancel']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Cancel\"`]")
    protected List<MobileElement> meetingCancel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Join Meeting']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Join Meeting\"`]")
    protected List<MobileElement> meetingJoin;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    protected MobileElement recordAudionVideoPermission;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    protected MobileElement storagePermission;

    @AndroidFindBy(id = "toolBarTitle")
    protected MobileElement meetingWithTitle;

    @AndroidFindBy(id = "imgProfile")
    protected MobileElement otherUserProfilePic;

    @AndroidFindBy(id = "relExitCall")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[1]")
    protected MobileElement meetingExit;

    @AndroidFindBy(id = "imgMuteAudio")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[2]")
    protected MobileElement meetingAudioBtn;

    @AndroidFindBy(id = "imgMuteVideo")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`value == \"1\"`]")
    protected MobileElement meetingVideoBtn;

    @AndroidFindBy(id = "imgSwitchCamera")
    @iOSXCUITFindBy(id = "D2602EE3 E171 4FB6 B73F 344095")
    protected MobileElement meetingSwitchCameraBtn;

    @AndroidFindBy(id = "imgScreenShare")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[5]")
    protected MobileElement shareScreen;

    @AndroidFindBy(id = "txtTime")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[6]")
    protected MobileElement meetingTimer;

    @AndroidFindBy(id = "imgCancel")
    protected MobileElement meetingBackBtn;

    @AndroidFindBy(id = "imgProfileCircle")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeImage")
    protected MobileElement meetingMyProfilePic;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Do you want to cancel the meeting...']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Do you want to cancel the meeting...\"`]")
    protected MobileElement meetingCancelTitle;

    @AndroidFindBy(id = "edtCancelReason")
    @iOSXCUITFindBy(id = "Provide a reason (optional)")
    protected MobileElement meetingCancelReasonInputBox;

    @AndroidFindBy(id = "txtSubmit")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Confirm\"`]")
    protected MobileElement confirmCancel;

    @AndroidFindBy(id = "llMySchedule")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell")
    protected List<MobileElement> meetingTiles;

}
