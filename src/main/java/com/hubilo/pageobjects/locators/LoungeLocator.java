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


public class LoungeLocator {

    @AndroidFindBy(id = "thirdItem")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTabBar[`label == \"Tab Bar\"`]/XCUIElementTypeButton[3]")
    protected MobileElement menuTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Lounge']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Lounge\"`]")
    protected MobileElement lounge;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Reception\"`]")
    protected MobileElement reception;

    @AndroidFindBy(id = "imgMyMeetings")
    @iOSXCUITFindBy(id = "ic meet calendar")
    protected MobileElement meetingBtn;

    @AndroidFindBy(id = "txtLiveLounge")
    @iOSXCUITFindBy(id = "Show Active Tables")
    protected MobileElement showActiveTablesText;

    @AndroidFindBy(id = "imgExhibitorLogo")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    protected List<MobileElement> showLoungeImage;

    @AndroidFindBy(id = "txtLoungeName")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView//XCUIElementTypeStaticText[@index =1]")
    protected List<MobileElement> loungeName;

    @AndroidFindBy(id = "txtLoungeDescription")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView//XCUIElementTypeStaticText[@index =2]")
    protected List<MobileElement> loungeDescription;

    @AndroidFindBy(id = "txtMemberCount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[@index =0]")
    protected List<MobileElement> memberSpots;


    @AndroidFindBy(id = "txtTitle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"HubiloApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    protected MobileElement loungeNameWithSpots;

    @AndroidFindBy(id = "txtPeopleJoined")
    @iOSXCUITFindBy(id = "No one joined yet")
    protected MobileElement joinedPeople;

    @AndroidFindBy(id = "txtAvailableSpots")
    @iOSXCUITFindBy(id= "8 spots are available")
    protected MobileElement availSpots;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Grab a Seat']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Grab a Seat\"`]")
    protected MobileElement grabSeatBtn;

    @AndroidFindBy(id = "imgProfileBg")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    protected MobileElement profileImage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeImage")
    protected MobileElement profileImageAfterJoin;

    @AndroidFindBy(id = "swtchLiveLounge")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`value == \"0\"`]")
    protected MobileElement showActiveToggle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`value == \"1\"`]")
    protected MobileElement performInactiveToggle;

    // verify leave table screen

    @AndroidFindBy(id = "txtPeopleJoined")
    @iOSXCUITFindBy(id = "Samual joined")
    protected MobileElement verifyPeopleNameJoined;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Leave table']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Leave\"`]")
    protected MobileElement leaveTable;

    @AndroidFindBy(id = "relRounded")
    @iOSXCUITFindBy (xpath = "//XCUIElementTypeCollectionView//XCUIElementTypeStaticText[@index =1]")
    protected List<MobileElement> loungeList;

    @AndroidFindBy(id = "txtEmpty")
    @iOSXCUITFindBy(id = "No Lounge in progress currently")
    protected MobileElement emptyScreen;

}
