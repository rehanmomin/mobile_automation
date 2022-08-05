package com.hubilo.pageobjects.locators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.CacheLookup;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

/**
 * @created: 2022-05-17-1:58 AM
 * @project: Hubilo_App_Automation under @package: @package: com.hubilo.pageobjects.locators
 * @author: Rehan
 **/


public class BoothLocator {

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/fifthItemIcon")
    @iOSXCUITFindBy(id = "Exhibitors")
    protected MobileElement gotoBooth;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvSponsorCategory")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeStaticText']")
    protected List<MobileElement> categoryList;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/ivViewMore")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ic three dots\"]")
    protected List<MobileElement> threeDots;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvSponsorName")
    protected List<MobileElement> boothName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reception']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Reception\"`]")
    protected MobileElement reception;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    protected MobileElement boothNameFirst;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Share your details\"`]")
    protected MobileElement shareYourDetail;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Cancel\"`]")
    protected MobileElement shareYourDetailCancel;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"View Profile\"`][1]")
    protected MobileElement viewProfile;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/touch_outside")
    protected MobileElement outsideTouch;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvBookMark")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Bookmark\"`]")
    protected MobileElement bookmark;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Live Chat']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Live Chat\"`]")
    protected MobileElement liveChat;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Team Members']")
    @iOSXCUITFindBy(id = "Team Members")
    protected MobileElement teamMember;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Polls']")
    @iOSXCUITFindBy(id ="Polls")
    protected MobileElement polls;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/llBack")
    @iOSXCUITFindBy(id = "close full alpha white")
    protected MobileElement backBooth;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='QnA']")
    @iOSXCUITFindBy(id = "QnA")
    protected MobileElement qAndA;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgMyMeetings")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ic meet calendar\"`]")
    protected MobileElement meeting;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/relNotch")
    @iOSXCUITFindBy(id = "pull-bar")
    protected MobileElement notch;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/edtTxtSearch")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Search\"`]")
    protected MobileElement textSearch;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='All']")
    @iOSXCUITFindBy(id = "All")
    protected MobileElement searchAllTab;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Booth']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Booth\"])[1]")
    protected MobileElement searchBoothTab;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtName")
    protected MobileElement searchResultBoothName;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvCategory")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Exhibitors\"`][1]")
    protected MobileElement searchResultBoothCategory;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgBack")
    @iOSXCUITFindBy(id = "backIcon")
    protected MobileElement backFromSearch;




}