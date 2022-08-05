package com.hubilo.pageobjects.locators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

/**
 * @created: 2022-05-17-1:45 AM
 * @project: Hubilo_App_Automation under @package: @package: com.hubilo.pageobjects.locators
 * @author: Rehan
 **/


public class LoginPageLocator {

    // verify elements on the screen
    @AndroidFindBy(id = "txtEventName")
    @iOSXCUITFindBy(id = "Automation-Appium")
    protected MobileElement selectedEventName;

    @AndroidFindBy(id = "imgClose")
    @iOSXCUITFindBy(id = "backIcon")
    protected MobileElement backButton;

    @AndroidFindBy(id = "txtDetail")
    @iOSXCUITFindBy(id = "Sign in to your account")
    protected MobileElement signInText;

    @AndroidFindBy(id = "tvLanguageLabel")
    @iOSXCUITFindBy(id = "English")
    protected MobileElement languageOption;

    @AndroidFindBy(id = "tvConsentText")
    protected MobileElement consentText;

    @AndroidFindBy(id = "txtDetail")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Enter OTP\"`]")
    protected MobileElement loginCodeText;

    @AndroidFindBy(id = "imgFacebook")
    protected MobileElement facebookLogin;

    @AndroidFindBy(id = "imgLinkedin")
    protected MobileElement linkedLogin;

    @AndroidFindBy(id = "imgGoogle")
    protected MobileElement googleLogin;

    @AndroidFindBy(id = "txtPoweredBy")
    @iOSXCUITFindBy(id = "Powered By Hubilo")
    protected MobileElement poweredByHubilo;

    @AndroidFindBy(id = "imgLogo")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    protected MobileElement hubiloLogo;

    // email id validation check
    @AndroidFindBy(id = "edtEmail")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Email Address']")
    protected MobileElement inputemailId;

    @AndroidFindBy(id = "txtMessage")
    @iOSXCUITFindBy(id = "Invalid Credentials.")
    protected MobileElement toastMessage;

    @AndroidFindBy(id = "txtEmailErr")
    protected MobileElement errorEmail;

    @AndroidFindBy(id = "tvLabel")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    protected MobileElement emailContinueBtn;

    @AndroidFindBy(id = "txtContinue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Continue\"`]")
    protected MobileElement passwordContinue;

    @AndroidFindBy(id = "cbChecked")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"HubiloApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
    protected MobileElement consentCheckbox;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtEmailErr")
    protected MobileElement emailFormatIncorrect;

    // password validation check
    @AndroidFindBy(id="edtPassword")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`value == \"Password\"`]")
    protected MobileElement inputPassword;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvSetUpLater")
    @iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeButton[`label == \"Setup Later\"`]")
    protected MobileElement saveLater;

    @AndroidFindBy(id = "txtPasswordErr")
    protected MobileElement errorPasskey;

    @AndroidFindBy(id = "imgUserProfile")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Reception\"`]/XCUIElementTypeButton[6]")
    protected MobileElement isProfileImage;

    @AndroidFindBy(id = "txtLoginWithCode")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Login with Code\"`]")
    protected MobileElement loginWithOTPlink;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgEventLogo")
    protected MobileElement changePasswordEventLogo;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtEventName")
    protected MobileElement changePasswordEventText;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/edtPassword")
    @iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeSecureTextField[`value == \"Password\"`]")
    protected MobileElement changePassword;


    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtResendCode")
    protected MobileElement resendCodeText;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/etConfirmPassword")
    @iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeSecureTextField[`value == \"Confirm Password\"`]")
    protected MobileElement cnfPassword;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login']")
    @iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeButton[`label == \"Login\"`]")
    protected MobileElement changePasswordLoginBtn;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/tvConfirmPasswordErr")
    protected MobileElement changePasswordError;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgClose")
    protected MobileElement changePasswordLogout;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgLogo")
    protected MobileElement changePasswordHubiloLogo;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtDetail")
    protected MobileElement changePasswordDescription;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtPoweredBy")
    protected MobileElement changePasswordPoweredByHubilo;
    @AndroidFindBy(id = "edtOtp")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Enter OTP']")
    protected MobileElement inputOTP;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/txtDifferentUser")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Different User?']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Different User?\"`]")
    protected MobileElement differentUser;

    @AndroidFindBy(id = "txtVerify")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Verify\"]")
    protected MobileElement verifyBtn;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgClose")
    protected MobileElement verifyBackBtn;

    @AndroidFindBy(id = "txtSkipPassword")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Skip Password\"]")
    protected MobileElement skipPassword;

    @AndroidFindBy(id = "tvPositiveButton")
    @iOSXCUITFindBy(id = "ic logout")
    protected List<MobileElement> logoutBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Logout\"`]")
    protected MobileElement confirmLogout;

}