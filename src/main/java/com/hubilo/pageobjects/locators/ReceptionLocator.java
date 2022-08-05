package com.hubilo.pageobjects.locators;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

/**
 * @created: 2022-06-28-3:43 PM
 * @project: Mobile_UI_Automation under @package: @package: com.hubilo.pageobjects.locators
 * @author: Rehan
 **/


public class ReceptionLocator {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reception']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Reception\"`]")
    protected MobileElement reception;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Event feed']")
    @iOSXCUITFindBy(id = "Event feed")
    protected MobileElement feedPost;

    @AndroidFindBy(id = "imgLogo")
    protected MobileElement hubiloLogo;

    @AndroidFindBy(id = "toolBarTitle")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Hubilo\"`]")
    protected MobileElement hubiloName;

    @AndroidFindBy(id = "imgMyMeetings")
    @iOSXCUITFindBy(id = "ic meet calendar")
    protected MobileElement meeting;

    @AndroidFindBy(id = "rlImgNotification")
    @iOSXCUITFindBy(id = "ic notification")
    protected MobileElement notification;

    @AndroidFindBy(id = "rlImgChat")
    @iOSXCUITFindBy(id = "ic chat new")
    protected MobileElement chat;

    @AndroidFindBy(id = "imgUserProfile")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Reception\"`]/XCUIElementTypeButton[6]")
    protected MobileElement profileImage;

    @AndroidFindBy(id = "imgEventBanner")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    protected MobileElement eventBanner;

    // live agenda content
    @AndroidFindBy(id = "txtLiveSessionTitle")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Live Agenda\"`][1]")
    protected MobileElement liveSessionText;

    @AndroidFindBy(id = "txtViewAllLiveSessions")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"View all\"`][1]")
    protected MobileElement viewAllLiveSession;

    @AndroidFindBy(id = "txtSessionTimerHeading")
    @iOSXCUITFindBy(id = "Session Started")
    protected MobileElement startedSessionText;

    //  agenda content

    @AndroidFindBy(id = "txtFeatureSessionTitle")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Agenda\"`][1]")
    protected MobileElement sessionText;

    @AndroidFindBy(id = "txtFeatureSession")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Featured\"`][1]")
    protected MobileElement featuredSessionText;

    @AndroidFindBy(id = "txtViewAllFeaturedSession")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"View all\"`][2]")
    protected MobileElement viewAllFeatureSession;

// room content

    @AndroidFindBy(id = "txtFeatureRoomTitle")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Rooms\"`][1]")
    protected MobileElement roomText;

    @AndroidFindBy(id = "txtFeatureRoom")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Featured\"`][1]")
    protected MobileElement featureRoomText;

    @AndroidFindBy(id = "txtRoomsViewAll")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"View all\"`][1]")
    protected MobileElement viewAllRoom;

    // speaker content
    @AndroidFindBy(id = "txtFeatureSpeakerTitle")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Speakers\"`][1]")
    protected MobileElement speakerText;

    @AndroidFindBy(id = "txtFeatureSpeakers")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Featured\"`][1]")
    protected MobileElement featureSpeakerText;

    @AndroidFindBy(id = "txtSpeakersViewAll")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"View all\"`][1]")
    protected List<MobileElement> viewAllSpeaker;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Speakers\"`]")
    protected MobileElement getSpeakerTab;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Attendees\"`]")
    protected MobileElement getAttendeeTab;

    // booth content

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Booth']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Booth\"`][1]")
    protected MobileElement boothText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Featured' and @index='0']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Featured\"`][1]")
    protected MobileElement boothFeatureText;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"View all\"`][1]")
    protected List<MobileElement> viewAllBooth;

    // leaderboard
    @AndroidFindBy(id = "txtLeaderBoardTitle")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Leaderboard\"`][1]")
    protected MobileElement leaderboardText;

    @AndroidFindBy(id = "txtLeaderboardViewAll")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"View all\"`][2]")
    protected List<MobileElement> viewAllLeaderboard;

    @AndroidFindBy(id = "txtToolBarTitle")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Rooms\"`]")
    protected MobileElement pageTitle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Booth\"`]")
    protected MobileElement boothPageTitle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Leaderboard\"`][1]")
    protected MobileElement lbPageTitle;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`value == \"0\"`]")
    protected MobileElement toggleOff;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`value == \"1\"`]")
    protected MobileElement toggleOn;

    @AndroidFindBy(id = "ivBack")
    protected MobileElement backBtn;

}