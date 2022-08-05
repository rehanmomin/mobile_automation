package com.hubilo.pageobjects.locators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;

public class LeaderboardLocator {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reception']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Reception\"`]")
    protected MobileElement reception;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Tab Bar\"]/XCUIElementTypeButton[3]")
    @AndroidFindBy(id = "com.hubilo.v2.dev:id/thirdItem")
    protected MobileElement menuIcon;

    @iOSXCUITFindBy(xpath ="//XCUIElementTypeTable/XCUIElementTypeCell[@index=7]/XCUIElementTypeStaticText[@name= 'Leaderboard']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Leaderboard' and @index='1']")
    protected MobileElement leaderBoardIcon;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Leaderboard\"`][1]")
    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtLeaderHeading")
    protected MobileElement leaderboardHeader;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"Leaderboard\"`]/XCUIElementTypeButton")
    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtPoints")
    protected MobileElement pointsButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[@index=4]/XCUIElementTypeStaticText[@index=1]")
    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtFourthUserName")
    protected MobileElement selfProfileWithMeText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[@index=4]/XCUIElementTypeStaticText[@index=1]")
    protected List<MobileElement> selfProfileWithMeTextList;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[@index=1]/XCUIElementTypeStaticText[@index=7]")
    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtFirstRank")
    protected MobileElement rankOne;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[@index=1]/XCUIElementTypeStaticText[@index=3]")
    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtSecondRank")
    protected MobileElement rankTwo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[@index=1]/XCUIElementTypeStaticText[@index=12]")
    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtThirdRank")
    protected MobileElement rankThree;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Leaderboard Points\"`]")
    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtHeader")
    protected MobileElement leaderboardPointsHeader;

    @iOSXCUITFindBy(id = "backIcon")
    @AndroidFindBy(id = "com.hubilo.v2.dev:id/ivReceptionClose")
    protected MobileElement backIcon;

    @iOSXCUITFindBy(id = "Create Post")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Create Post']")
    protected MobileElement createPostListing;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[@index=1]/XCUIElementTypeStaticText[@index=1]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]")
    protected MobileElement pointsOnLeaderboardPointsPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[@index=1]/XCUIElementTypeStaticText[@index=0]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    protected MobileElement numberOfPointsOnLeaderboardPointsPage;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtFourthUserName")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[@index=4]/XCUIElementTypeStaticText[@index=1]")
    protected MobileElement logginUserName;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtFourthUserDesignation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[@index=4]/XCUIElementTypeStaticText[@index=2]")
    protected MobileElement logginUserDesignation;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgFourthUser")
    protected MobileElement logginUserImage;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtFourthUserRank")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[@index=4]/XCUIElementTypeStaticText[@index=6]")
    protected MobileElement logginUserRank;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtFourthUserPoints")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[@index=4]/XCUIElementTypeStaticText[@index=0]")
    protected MobileElement logginUserPoints;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtFirstRank")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[@index=1]/XCUIElementTypeStaticText[@index=7]")
    protected MobileElement firstRank;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtFirstUserName")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeTable/XCUIElementTypeCell[@index=1]/XCUIElementTypeStaticText[@index=4]")
    protected MobileElement firstRankUserName;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtFirstUserDesignation")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeTable/XCUIElementTypeCell[@index=1]/XCUIElementTypeStaticText[@index=5]")
    protected MobileElement firstRankUserDesignation;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtFirstUserPoints")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeTable/XCUIElementTypeCell[@index=1]/XCUIElementTypeStaticText[@index=6]")
    protected MobileElement firstRankUserPoints;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgSecondUser")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeTable/XCUIElementTypeCell[@index=1]/XCUIElementTypeButton[@index=8]")
    protected List<MobileElement> secondUserImage;

    @iOSXCUITFindBy(xpath ="//XCUIElementTypeTable/XCUIElementTypeCell[@index=1]/XCUIElementTypeButton[@index=14]")
    protected MobileElement secondUserImagefallback;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtSecondUserName")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[@index=1]/XCUIElementTypeStaticText[@index=1]")
    protected MobileElement secondUserName;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtName")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@index=2]//XCUIElementTypeCell[@index=1]/XCUIElementTypeStaticText[@index=4]")
    protected MobileElement verifySecondUser;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgMyMeetings")
    @iOSXCUITFindBy(id = "ic meet calendar")
    protected MobileElement meeting;

}
