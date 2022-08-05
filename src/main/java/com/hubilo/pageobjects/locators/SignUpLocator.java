package com.hubilo.pageobjects.locators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

/**
 * @created: 2022-05-17-2:07 AM
 * @project: Hubilo_App_Automation under @package: @package: com.hubilo.pageobjects.locators
 * @author: preetam
 **/


public class SignUpLocator {

    @AndroidFindBy(id = "txtEventName")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[@index=0]")
    protected MobileElement getEventName;

    @AndroidFindBy(id = "edtEmail")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeTextField']")
    protected MobileElement inputemailId;

    @AndroidFindBy(id = "tvLabel")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Continue\"`]")
    protected MobileElement emailContinueBtn;

    @AndroidFindBy(id = "cbChecked")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[@name=\"I agree to the Terms and Conditions and Privacy Policy\"]/../..//XCUIElementTypeButton")
    protected MobileElement consentCheckbox;

    @AndroidFindBy(id = "edtPassword")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`value == \"Password\"`]")
    protected MobileElement passWord;


    @AndroidFindBy(id = "edtFirstName")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"First Name\"`]")
    protected MobileElement setFirstUser;

    @AndroidFindBy(id = "edtLastName")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Last Name\"`]")
    protected MobileElement setLastUser;

    @AndroidFindBy(id = "edtPassword")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`value == \"Password\"`]")
    protected MobileElement setPassword;

    @AndroidFindBy(id = "edtConfirmPassword")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`value == \"Confirm Password\"`]")
    protected MobileElement setConfirmPassword;

    @AndroidFindBy(id = "tvLabel")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Sign Up\"`]")
    protected List<MobileElement> signUpBtnList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Already have an account? Login now']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Login\"`]")
    protected MobileElement rLogin;

    @AndroidFindBy(id = "imgClose")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"backIcon\"`]")
    protected MobileElement backButton;

    // Profile Verify

    @AndroidFindBy(id = "txtTitle")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeStaticText']")
    protected MobileElement userFirstTitle;

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

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='About']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"About\"`][2]")
    protected MobileElement about;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Designation']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Designation\"`]")
    protected MobileElement designation;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Organisation']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Organisation\"`]")
    protected MobileElement organisation;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Country']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Country\"`]")
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

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='State']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"State\"`]")
    protected MobileElement stateDropDown;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='City/Town']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"City/Town\"`]")
    protected MobileElement city_town;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Industry']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Industry\"`]")
    protected MobileElement industry;

    @AndroidFindBy(id = "edtTxtSearch")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Search\"`]")
    protected MobileElement searchIndustryType;

    @AndroidFindBy(id = "spinnerText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"HubiloApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell")
    protected MobileElement selectIndustryType;

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

    // social links
    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeTextField']")
    protected List<MobileElement> setSocialLinks;

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

    //verifylogged in
    @AndroidFindBy(id = "imgNotification")
    @iOSXCUITFindBy(id = "ic notification")
    protected MobileElement notificationImage;

    @AndroidFindBy(id = "relCustomToast")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Unregistered e-mail ID. Enter registered e-mail ID.\"`]")
    protected MobileElement emailRestrict;

    @AndroidFindBy(id = "txtLoginWithCode")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Login with Code\"`]")
    protected MobileElement loginwithcode_Btn;

    @AndroidFindBy(id = "edtOtp")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Enter OTP']")
    protected MobileElement otp_Textarea;

    @AndroidFindBy(id = "tvLabel")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Verify\"]")
    protected MobileElement verify_Btn;

    @AndroidFindBy(id = "txtDifferentUser")
    protected MobileElement differentuser;

    @AndroidFindBy(id = "tvTime")
    protected MobileElement resendlogincode;

    @AndroidFindBy(id = "frmCancel")
    @iOSXCUITFindBy(id = "ic logout")
    protected MobileElement logout_Btn;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/ivReceptionClose")
    protected MobileElement logoutIcon;
    @AndroidFindBy(id = "tvPositiveButton")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Logout\"`]")
    protected MobileElement confirmlogout_Btn;

    @AndroidFindBy(id = "tvHeader")
    protected MobileElement language_timezone;

    @AndroidFindBy(id = "imgUserProfile")
    protected MobileElement profile;

    @AndroidFindBy(id = "linLogout")
    protected MobileElement profilelogout_Btn;

    @AndroidFindBy(id = "imgUserProfile")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Reception\"`]/XCUIElementTypeButton[6]")
    protected MobileElement gotoProfileBtn;


    @AndroidFindBy(id = "txtEventName")
    @iOSXCUITFindBy(id = "Automation-Appium")
    protected MobileElement currentEventName;


}