package com.hubilo.pageobjects.functions;

import com.hubilo.pageobjects.locators.LoginPageLocator;
import com.hubilo.utils.helper.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class LoginPage extends LoginPageLocator {

    private AppiumDriver driver;
    private SoftAssert softAssert = new SoftAssert();

    public enum Keys {
        EMPTY("Invalid Email Address"),
        INVALID_EMAIL("Email format is incorrect"),
        INVALID_PASS("Invalid Password"),
        LOGINCODE_TOAST("Your login code has been sent to your registered email address. Please check your Spam folder if you have not received it");
        private String value;

        private Keys(String value) {
            this.value = value;
        }
    }

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void verifyLogin(String option, String email, String passkey, String eventName) {
        boolean socialLogin = false;
        if (driver instanceof AndroidDriver) {
           // validateAllElementsOnLogin(eventName);
            socialLogin = true;
        }
        switch (option) {
            case "empty email without and with consent": {
                if (driver instanceof AndroidDriver) {
                    emptyEmailWithoutAndWithConsents(socialLogin);
                } else {
                    new SkipException("IOS Limitation for this test case");
                }
                break;
            }
            case "invalid email without and with consent": {
                if (driver instanceof AndroidDriver) {
                    invalidEmailWithoutAndWithConsents("sdfdgfgr2424", socialLogin);
                } else {
                    new SkipException("IOS Limitation for this test case");
                }
                break;
            }

            case "empty password without and with consent": {
                if (driver instanceof AndroidDriver) {
                    emptyPasswordlWithoutAndWithConsents(email);
                } else {
                    new SkipException("IOS Limitation for this test case");
                }
                break;
            }
            case "invalid password without and with consent": {
                if (driver instanceof AndroidDriver) {
                    invalidPasswordlWithoutAndWithConsents(email, "sgrgwerew3434");
                } else {
                    new SkipException("IOS Limitation for this test case");
                }
                break;
            }
            case "valid user and password": {
                validEmailAndPassword(email, passkey, socialLogin);
                break;
            }
            case "different user from OTP": {
                verifyDifferentUserLinkOTPScreen(email, eventName);
                break;
            }
            case "invalid OTP": {
                verifyInvalidOTP(email, "sdfsf323", eventName);
                break;
            }
            case "valid OTP": {
                verifyValidOTP(email, passkey, eventName);
                break;
            }
                case "verify change password bulk": {
                    verifyChangePassword(passkey, passkey);
                    break;
            }
        }
    }

    @Step("Launch app and verify empty email with and without consents")
    private void emptyEmailWithoutAndWithConsents(boolean socialLogin) {
        if (socialLogin)
            validateSocialLogin();
        emailContinueBtn.click();
        softAssert.assertEquals(errorEmail.getText(), "Invalid Email Address");
        softAssert.assertTrue(toastMessage.getText().equalsIgnoreCase("Please accept required user consent"));
        consentCheckbox.click();
        emailContinueBtn.click();
        softAssert.assertEquals(errorEmail.getText(), "Invalid Email Address");
        consentCheckbox.click();
        softAssert.assertAll();
    }

    @Step("Launch app and verify invalid email with and without consents")
    private void invalidEmailWithoutAndWithConsents(String invalid, boolean socialLogin) {
        if (socialLogin)
            validateSocialLogin();
        inputemailId.sendKeys(invalid);
        emailContinueBtn.click();
        softAssert.assertEquals(errorEmail.getText(), "Email format is incorrect");
        softAssert.assertTrue(toastMessage.getText().equalsIgnoreCase("Please accept required user consent"));
        inputemailId.clear();
        inputemailId.sendKeys(invalid);
        consentCheckbox.click();
        emailContinueBtn.click();
        softAssert.assertEquals(errorEmail.getText(), "Email format is incorrect");
        consentCheckbox.click();
    }

    @Step("Launch app and verify empty password with and without consents")
    private void emptyPasswordlWithoutAndWithConsents(String validEmail) {
        inputemailId.sendKeys(validEmail);
        consentCheckbox.click();
        emailContinueBtn.click();
        consentCheckbox.click();
        passwordContinue.click();
        softAssert.assertEquals(errorPasskey.getText(), "Invalid Password");
        softAssert.assertTrue(toastMessage.getText().equalsIgnoreCase("Please accept required user consent"));
        softAssert.assertTrue(loginWithOTPlink.isDisplayed());
        consentCheckbox.click();
        passwordContinue.click();
        softAssert.assertEquals(errorPasskey.getText(), "Invalid Password");
        consentCheckbox.click();
        softAssert.assertAll();
    }

    @Step("Launch app and verify invalid password with and without consents")
    private void invalidPasswordlWithoutAndWithConsents(String validEmail, String invalidPassword) {
        inputemailId.sendKeys(validEmail);
        consentCheckbox.click();
        emailContinueBtn.click();
        inputPassword.sendKeys(invalidPassword);
        consentCheckbox.click();
        passwordContinue.click();
        softAssert.assertTrue(toastMessage.getText().equalsIgnoreCase("Please accept required user consent"));
        softAssert.assertTrue(loginWithOTPlink.isDisplayed());
        inputPassword.clear();
        inputPassword.sendKeys(invalidPassword);
        consentCheckbox.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        passwordContinue.click();
        softAssert.assertTrue(toastMessage.getText().equalsIgnoreCase("Invalid Credentials."));
        consentCheckbox.click();
        softAssert.assertAll();
    }

    @Step("Launch app and verify valid password with and without consents")
    private void validEmailAndPassword(String emailId, String passkey, boolean socialLogin) {
        inputemailId.clear();
        if (socialLogin)
            validateSocialLogin();
        inputemailId.sendKeys(emailId);
        consentCheckbox.click();
        emailContinueBtn.click();
        inputPassword.sendKeys(passkey);
        emailContinueBtn.click();
        softAssert.assertTrue(Utility.isAvailable(driver, isProfileImage));
        softAssert.assertAll();
    }

    // Login via OTP screen
    @Step("Launch app and enter valid email and go to login code and then click on different user link")
    private void verifyDifferentUserLinkOTPScreen(String emailId, String eventName) {
        inputemailId.sendKeys(emailId);
        if (driver instanceof AndroidDriver) {
            if (!Boolean.parseBoolean(consentCheckbox.getAttribute("checked"))) {
                consentCheckbox.click();
            }
        } else {
            consentCheckbox.click();
        }
        emailContinueBtn.click();
        loginWithOTPlink.click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(verifyBtn));
        if (driver instanceof AndroidDriver) {
            //softAssert.assertTrue(toastMessage.getText().contains("Your login code has been sent to your registered email address. Please check your Spam folder if you have not received it"));
        }
        Utility.waitUntilElement(driver, differentUser);
        differentUser.click();
        softAssert.assertAll();
    }

    @Step("Launch app and enter valid email and go to login code and then verify with invalid login code")
    private void verifyInvalidOTP(String emailId, String invalidOTP, String eventName) {
        if (driver instanceof AndroidDriver) {
            inputemailId.sendKeys(emailId);
            emailContinueBtn.click();
            if (!Boolean.parseBoolean(consentCheckbox.getAttribute("checked"))) {
                consentCheckbox.click();
            }
        }
        loginWithOTPlink.click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(verifyBtn));
        if (driver instanceof AndroidDriver) {
            softAssert.assertTrue(loginCodeText.getText().contains(emailId));
        }
        inputOTP.sendKeys(invalidOTP);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        verifyBtn.click();
        softAssert.assertTrue(toastMessage.getText().contains("Invalid Credentials."));
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(backButton)).click();
        softAssert.assertAll();
    }

    @Step("Launch app and enter valid email and go to login code and then verify with valid login code")
    private void verifyValidOTP(String emailId, String validOTP, String eventName) {
        if (driver instanceof AndroidDriver) {
            inputemailId.sendKeys(emailId);
            if (!Boolean.parseBoolean(consentCheckbox.getAttribute("checked"))) {
                consentCheckbox.click();
            }
            emailContinueBtn.click();
        }
        loginWithOTPlink.click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(verifyBtn));
        if (driver instanceof AndroidDriver) {
            softAssert.assertTrue(loginCodeText.getText().contains(emailId));
        }
        validateAllElementsOnOTP(eventName);
        inputOTP.sendKeys(validOTP);
        verifyBtn.click();
        if (driver instanceof AndroidDriver) {
            softAssert.assertTrue(Utility.isAvailable(driver, backButton));
        } else {
            softAssert.assertTrue(logoutBtn.size() > 0);
        }
        skipPassword.click();
        Utility.waitUntilElement(driver, isProfileImage);
        //logoutBtn.get(0).click();
//        if (driver instanceof IOSDriver) {
//            confirmLogout.click();
//            softAssert.assertTrue(Utility.isAvailable(driver, backButton));
//        }
        softAssert.assertAll();
    }

    private void validateAllElementsOnLogin(String eventName) {
        List<MobileElement> mobileElementList = Arrays.asList(new MobileElement[]{selectedEventName, backButton, signInText, languageOption, hubiloLogo, poweredByHubilo, emailContinueBtn});
        validateAllElementsOnOTP(mobileElementList);
    }

    private void validateSocialLogin() {
        List<MobileElement> mobileElementList = Arrays.asList(new MobileElement[]{facebookLogin, linkedLogin, googleLogin,});
        validateAllElementsOnOTP(mobileElementList);

    }

    private void validateAllElementsOnOTP(String eventName) {
        Utility.sleep(1000);//selectedEventName removed from MobileElement
        List<MobileElement> mobileElementList = Arrays.asList(new MobileElement[]{backButton, loginCodeText, languageOption, hubiloLogo, poweredByHubilo});
        validateAllElementsOnOTP(mobileElementList);
    }

    private void validateAllElementsOnOTP(List<MobileElement> melements) {
        for (int i = 0; i < melements.size(); i++) {
            Utility.sleep(1000);
            Assert.assertTrue(Utility.isAvailable(driver, melements.get(i)));
        }
    }

    public boolean verifyElementAttribute(MobileElement element, String attrb) {
        return Boolean.parseBoolean(element.getAttribute(attrb));
    }

    public void enterEmailAndConsent(String email) {
        inputemailId.sendKeys(email);
        consentCheckbox.click();
        emailContinueBtn.click();
    }

    public void enterPassword(String pass) {
        inputPassword.clear();
        inputPassword.sendKeys(pass);
        consentCheckbox.click();
        passwordContinue.click();
    }

    public void verifyUserConsentToast() {
        softAssert.assertTrue(toastMessage.getText().equalsIgnoreCase("Please accept required user consent"));
    }

    public void verifyPasswordToast() {
        softAssert.assertEquals(errorPasskey.getText(), "Invalid Password");
    }

    public void verifyEamilTaost() {
        softAssert.assertEquals(errorEmail.getText(), "Email format is incorrect");
    }
    public void gotoChangePassword(String email, String otp) {
        inputemailId.clear();
        inputemailId.sendKeys(email);

        if (driver instanceof AndroidDriver && Boolean.parseBoolean(consentCheckbox.getAttribute("checked"))) {
            consentCheckbox.click();
        }
        else
        {
            consentCheckbox.click();
        }
        emailContinueBtn.click();
        inputOTP.sendKeys(otp);
        verifyBtn.click();

    }
    private void verifyChangePasswordBulk(String password, String confPassword) {
        changePassword.sendKeys(password);
        cnfPassword.sendKeys(confPassword);
        if(!password.equals(confPassword)){
            Utility.waitUntilElement(driver, changePasswordError);
            softAssert.assertEquals(changePasswordError.getText(), "Password Does not Match", "verify error message");
        }
        softAssert.assertFalse(changePasswordLoginBtn.isEnabled());
        softAssert.assertAll();
    }
    private void verifyChangePassword(String password, String confPassword) {
        changePassword.sendKeys(password);
        cnfPassword.sendKeys(confPassword);
        softAssert.assertTrue(changePasswordLoginBtn.isEnabled());
        changePasswordLoginBtn.click();
        saveLater();
        Utility.waitUntilElement(driver, isProfileImage);
        softAssert.assertAll();
    }
    public void saveLater()
    {
        Utility.waitUntilElement(driver, saveLater);
        saveLater.click();
    }

}