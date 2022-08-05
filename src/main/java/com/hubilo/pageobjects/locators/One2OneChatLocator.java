package com.hubilo.pageobjects.locators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class One2OneChatLocator {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reception']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Reception\"`]")
    protected MobileElement reception;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgChat")
    @iOSXCUITFindBy(id = "ic chat new")
    protected MobileElement chat;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/nameToolbar")
    @iOSXCUITFindBy(id = "Messages")
    protected MobileElement messageTitle;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/cancelBtn")
    @iOSXCUITFindBy(id = "backIcon")
    protected MobileElement cancelBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"New Chat\"`]")
    protected MobileElement newChatHeader;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"New Chat\"`]")
    protected List<MobileElement> newChatHeaderList;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/edtTxtSearch")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    protected MobileElement searchUser;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgNewChat")
    @iOSXCUITFindBy(id = "ic new chat")
    protected MobileElement newChat;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvUserName")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@index=2]/XCUIElementTypeCell/XCUIElementTypeStaticText")
    protected List<MobileElement> userName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@index=1]/XCUIElementTypeCell[@index=1]/XCUIElementTypeStaticText[@index=0]")
    protected List<MobileElement> userNameiOS;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/profilePic")
    protected MobileElement userProfilePic;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/edtSendMessage")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeWindow//XCUIElementTypeOther/XCUIElementTypeTextView")
    protected MobileElement chatInput;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgSend")
    @iOSXCUITFindBy(id = "ic send message")
    protected MobileElement sendChat;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvChatPersonName")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther[@index=3]/XCUIElementTypeOther/XCUIElementTypeButton")
    protected MobileElement chatUserName;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvTextMessage")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeTextView/XCUIElementTypeTextView")
    protected List<MobileElement> verifyChat;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/launchGiphyBtn")
    @iOSXCUITFindBy(id = "ic gif")
    protected MobileElement gifyOption;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/searchInput")
    @iOSXCUITFindBy(id = "TEXT_FIELD")
    protected MobileElement searchInputGify;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/suggestionLeftImage")
    protected List<MobileElement> suggestedGify;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[@index=1]")
    protected List<MobileElement> gifyList;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/gifView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[@index=1]/XCUIElementTypeTextView")
    protected MobileElement sendVerifyGify;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[@index=1]/XCUIElementTypeTextView")
    protected List<MobileElement> sendVerifyGifyList;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtEmpty")
    @iOSXCUITFindBy(id = "No conversation available")
    protected MobileElement emptyScreen;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/menuIcon")
    @iOSXCUITFindBy(id = "Delete Chat")
    protected MobileElement deleteIcon;


    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvMessage")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeTable[@index=1]/XCUIElementTypeCell[@index=1]/XCUIElementTypeStaticText[@index=1]")
    protected List<MobileElement> userChat;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgThreeDots")
    @iOSXCUITFindBy(id = "ic more vertical")
    protected MobileElement threeDots;

    @iOSXCUITFindBy(id = "ic more horizontal")
    protected MobileElement horzThreeDots;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvPostTime")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@index=1]/XCUIElementTypeCell[@index=1]/XCUIElementTypeStaticText[@index=2]")
    protected List<MobileElement> postTime;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtViewProfile")
    @iOSXCUITFindBy(id = "View Profile")
    protected MobileElement userViewProfile;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgDelete")
    @iOSXCUITFindBy(id = "Delete")
    protected MobileElement deleteAllChatImage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Delete\"`]")
    protected MobileElement confirmDelete;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    protected MobileElement textField;

    @iOSXCUITFindBy(id = "ic Close")
    protected MobileElement closeChat;

//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete']")
//    protected MobileElement confirmDelete;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgMyMeetings")
    @iOSXCUITFindBy(id = "ic meet calendar")
    protected MobileElement meeting;

}
