package com.hubilo.pageobjects.locators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class OnboardingLocator {
    @AndroidFindBy(id = "txtTitle")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeStaticText']")
    protected List<MobileElement> userFirstTitle;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/ivReceptionClose")

    protected MobileElement getLogoutBtn;

    @AndroidFindBy(id = "txtProgress")
    protected MobileElement progressBar;
    @AndroidFindBy(id = "frmCancel")
    protected MobileElement logoutBtn;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='First Name*']")
    protected MobileElement verifyFirstNameOnboarding;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Last Name*']")
    protected MobileElement verifyLastNameOnboarding;
    @AndroidFindBy(id = "llGenderContainer")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"HubiloApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable")
    protected List<MobileElement> listGender;
    @AndroidFindBy(id = "//android.widget.EditText[@index='6']")
    protected MobileElement setOtherGenderOption;


    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index=7]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@index =3]//XCUIElementTypeTextView")
    protected MobileElement about;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"About\"`][1]")
    protected MobileElement about_lbl;


    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index=9]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@index =4]//XCUIElementTypeTextField")
    protected MobileElement designation;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index=11]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@index =5]//XCUIElementTypeTextField")
    protected MobileElement organisation;
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.EditText[@index=13]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@index =6]//XCUIElementTypeTextField")
    protected MobileElement countryDropDown;
    @AndroidFindBy(id = "etTxtSearch")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Search\"`]")
    protected MobileElement searchText;
    @AndroidFindBy(id = "tvItemName")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeStaticText']")
    protected List<MobileElement> selectfromList;
    @AndroidFindBy(id = "tvDone")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Done\"`]")
    protected MobileElement selectionDone;
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.EditText[@index=15]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@index =7]//XCUIElementTypeTextField")
    protected MobileElement stateDropDown;
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index=17]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@index =8]//XCUIElementTypeTextField")
    protected MobileElement city_town;
    @AndroidFindBy(id = "com.hubilo.v2.dev:id/edtIndustry")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@index =9]//XCUIElementTypeTextField")
    protected MobileElement industry;
    @AndroidFindBy(id = "edtTxtSearch")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Search\"`]")
    protected MobileElement searchIndustryType;
    @iOSXCUITFindBy(id = "Country")
    protected MobileElement Country;
    @AndroidFindBy(id = "spinnerText")
    @iOSXCUITFindBy(xpath = "UIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell")
    protected List<MobileElement> selectIndustryType;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell//XCUIElementTypeStaticText[@index=1]")
    protected MobileElement select_searchresult;
    @AndroidFindBy(id = "txtContinue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Continue\"`]")
    protected MobileElement signUpVerifyContinue;
    // set Background Image
    @AndroidFindBy(id = "img_cover")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeCell']")
    protected List<MobileElement> listImageCover;
    @AndroidFindBy(id = "imgTick")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ic delete comment\"`][1]")
    protected MobileElement removeImage;
    @AndroidFindBy(id = "txtPrevious")
    protected MobileElement gotoPrevious;
    @AndroidFindBy(id = "txtContinue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Next\"`]")
    protected MobileElement gotoNext;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Finish\"`]")
    protected MobileElement finish;
    @iOSXCUITFindBy(id = "Interest")
    protected MobileElement dismisskeyboard;
    // social links
    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeTextField']")
    protected List<MobileElement> setSocialLinks;
    @iOSXCUITFindBy(id = "Social Profile Connections")
    protected MobileElement dismissKeyboard;
    // looking for and offering
    @AndroidFindBy(id = "edtLookingFor")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Select looking for\"`]")
    protected MobileElement lookingFor;
    @AndroidFindBy(id = "edtOffering")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Select offering\"`]")
    protected MobileElement offering;
    //interest
    @AndroidFindBy(id = "relRounded")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Consulting\"`]")
    protected MobileElement selectInterestTitle;



    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Setup later']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Setup Later\"]")
    protected MobileElement timezoneSetUpLater;

    //verifylogged in
    @AndroidFindBy(id = "imgNotification")
    @iOSXCUITFindBy(id = "ic notification")
    protected MobileElement notificationImage;

    @AndroidFindBy(id = "imgUserProfile")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Reception\"`]/XCUIElementTypeButton[6]")
    protected MobileElement gotoProfileBtn;

    @iOSXCUITFindBy(id = "Logout")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"linLogout\"]/android.widget.ImageView")
    protected MobileElement logoutbutton;

    @AndroidFindBy(id = "tvPositiveButton")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Logout\"`]")
    protected MobileElement confirmLogout;

    @AndroidFindBy(id = "txtEventName")
    @iOSXCUITFindBy(id = "Automation-Appium")
    protected MobileElement currentEventName;

    @AndroidFindBy(id = "tvHeader")
    protected MobileElement language_timezone;

    @AndroidFindBy(id = "imgUserProfile")
    protected MobileElement profile;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/ivReceptionClose")
    @iOSXCUITFindBy(id = "ic logout")
    protected MobileElement logoutIcon;
}