package com.hubilo.pageobjects.locators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

/**
 * @created: 2022-05-16-11:10 AM
 * @project: Hubilo_App_Automation under @package: @package: com.hubilo.pageobjects.locators
 * @author: Rehan
 **/


public class MultiEventLocator {

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvOngoingTag")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ongoing\"]")
    protected MobileElement ongoingLive;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvEventTitle")
    protected MobileElement firstFeaturedEventTitle;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvEventDate")
    protected MobileElement firstFeaturedEventDate;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/btnJoinEvent")
    protected MobileElement firstFeaturedEventJoinBtn;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvNoData")
    protected MobileElement noData;

    @AndroidFindBy(xpath = "//*[@resource-id='com.hubilo.v2.dev:id/chipAll']")
    protected MobileElement allEvent;

    @AndroidFindBy(xpath= "//*[@resource-id='com.hubilo.v2.dev:id/chipOngoing']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ongoing\"]")
    protected List<MobileElement> ongoingEventList;

    @AndroidFindBy(xpath = "//*[@resource-id='com.hubilo.v2.dev:id/chipUpcoming']")
    protected MobileElement upcomingEvent;

    @AndroidFindBy(xpath = "//*[@resource-id='com.hubilo.v2.dev:id/chipPast']")
    protected MobileElement pastEvent;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvEventTitle")
    protected List<MobileElement> listEventTile;

    @AndroidFindBy(xpath= "//*[@resource-id='com.hubilo.v2.dev:id/chipOngoing']")
    protected MobileElement ongoingEvent;

    // app controller

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/edtEventId")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Event id\"`]")
    protected MobileElement eventId;

    @iOSXCUITFindBy(id = "Allow")
    protected MobileElement allowNotification;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/edtOrganizerId")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Organisation id\"`]")
    protected MobileElement orgId;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/btnProceed")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"PROCEED\"`]")
    protected MobileElement proceedBtn;

    @iOSXCUITFindBy(id = "MULTI")
    protected MobileElement multiEventSelect;

    @iOSXCUITFindBy(id = "Allow")
    protected MobileElement allowPopup;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"DEV\"`]")
    protected MobileElement devSelected;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Production\"`]")
    protected MobileElement passReleaseEnv;

    @AndroidFindBy(id= "android:id/text1")
    protected List<MobileElement> eventTypeEnvironment;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SINGLE']")
    protected MobileElement selectEventType;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='MULTI']")
    protected MobileElement selectMultiEvent;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='DEV']")
    protected MobileElement selectEnv;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='RELEASE']")
    protected MobileElement selectReleaseEnv;

}