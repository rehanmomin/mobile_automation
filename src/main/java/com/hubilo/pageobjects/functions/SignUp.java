package com.hubilo.pageobjects.functions;

import com.hubilo.pageobjects.locators.SignUpLocator;
import com.hubilo.pojo.ui.BProfileOnboarding;
import com.hubilo.pojo.ui.SignUpData;
import com.hubilo.utils.helper.Utility;
import freemarker.core.CSSOutputFormat;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SignUp extends SignUpLocator {

    private AppiumDriver driver;
    private SoftAssert softAssert = new SoftAssert();

    public SignUp(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @Step("Launch app and Enter EmailId and then Signup page visible")
    public void verifySignUp(String type, SignUpData signUpData, String eventName) {
        switch (type) {
            case "verify Login Now": verifyLoginNow(signUpData, eventName);  break;
            case "Back Button": goBackButtonToLogin(signUpData, eventName); break;
            case "valid details": verifySignValidData(signUpData, eventName); break;
            case "verify email restricted": verifyEmailRestricted(signUpData.getEmail()); break;
        }
    }

    @Step("Enter un-registered email and continue, Signup screen visible fill the input fields")
    public void verifySignUpData(String eventName, String email, String fName, String lName, String nPassword, String cPassword){
        setEmail(email);
        if (driver instanceof AndroidDriver) {
            softAssert.assertEquals(getEventName.getText(), eventName);
            softAssert.assertTrue(inputemailId.getText().contains(email));
        }
        Utility.waitUntilElement(driver, setFirstUser);
        setFirstUser.sendKeys(fName);
        setLastUser.sendKeys(lName);
        setPassword.sendKeys(nPassword);
        setConfirmPassword.sendKeys(cPassword);
        if (driver instanceof AndroidDriver){
            softAssert.assertTrue(Utility.isAvailable(driver, signUpBtnList.get(0)),"signup disable");
        }
        signUpBtnList.get(0).click();
        softAssert.assertTrue(signUpBtnList.size() > 0);
        backButton.click();
        Utility.sleep(1000);
        inputemailId.clear();
        if(driver instanceof IOSDriver) {
            consentCheckbox.click();
        }
        softAssert.assertAll();
    }

    @Step("User enters valid details and click on back to login link")
    private void verifyLoginNow(SignUpData signUpData, String eventName) {
        setEmail(signUpData.getEmail());
        if (driver instanceof IOSDriver) {
            rLogin.click();
        } else {
            Utility.loginLink(driver, rLogin);
        }
        softAssert.assertEquals(getEventName.getText(), eventName);
        softAssert.assertAll();
    }

    @Step("User enters valid details and click on back button")
    private void goBackButtonToLogin(SignUpData signUpData, String eventName) {
        inputemailId.clear();
        setEmail(signUpData.getEmail());
        if(driver instanceof IOSDriver)
        {
            consentCheckbox.click();
        }
        emailContinueBtn.click();
        Utility.sleep(1000);
        backButton.click();
        softAssert.assertEquals(getEventName.getText(), eventName);
        softAssert.assertAll();
    }


    @Step("Restricted flag is true from the dashboard and user trying to login with email :{email}")
    private void verifyEmailRestricted(String email) {
        inputemailId.sendKeys(Utility.generateRandomNumber()+email);
        consentCheckbox.click();
        emailContinueBtn.click();
        softAssert.assertTrue(Utility.isAvailable(driver, emailRestrict));
        inputemailId.clear();
        inputemailId.sendKeys(Utility.generateRandomNumber()+email);
        consentCheckbox.click();
        emailContinueBtn.click();
        inputemailId.clear();
        softAssert.assertAll();
    }

    private void setEmail(String emailId) {
        if (!inputemailId.getText().equalsIgnoreCase(emailId)) {
            inputemailId.sendKeys(+Utility.generateRandomNumber() + emailId);
        }
        if(driver instanceof IOSDriver)
        {
            consentCheckbox.click();
        }else if(!Boolean.parseBoolean(consentCheckbox.getAttribute("checked"))) {
            consentCheckbox.click();
            System.out.println("consents checked : " + consentCheckbox.isSelected());
        }
        emailContinueBtn.click();
        softAssert.assertAll();
    }

    @Step("User enter valid details and click on Signup button")
    public void verifySignValidData(SignUpData signUpData, String eventName) {
        inputemailId.clear();
        consentCheckbox.click();
        setEmail(signUpData.getEmail());
        softAssert.assertEquals(getEventName.getText(), eventName);
        softAssert.assertTrue(inputemailId.getText().contains(signUpData.getEmail()));
        setFirstUser.sendKeys(signUpData.getFirstName());
        setLastUser.sendKeys(signUpData.getLastName());
        setPassword.sendKeys(signUpData.getNewPassword());
        setConfirmPassword.sendKeys(signUpData.getConfirmPassword());
        signUpBtnList.get(0).click();
        softAssert.assertAll();
    }
    public void selectConsent()
    {
        if(driver instanceof IOSDriver) {
            consentCheckbox.click();
        }
    }

    public void verifyWithNewLogin(String registeredEmail, String loginCode) {
        sendEmailID(registeredEmail);
        selectLoginWithCode();
        verifyLoginWithOTP(loginCode);

    }

    @Step("User enters EmailId {email}")
    private void sendEmailID(String email) {
        inputemailId.clear();
        inputemailId.sendKeys(email);
        consentCheckbox.click();
        emailContinueBtn.click();
    }

    @Step("User is at login screen and click on Login with Code")
    private void selectLoginWithCode() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loginwithcode_Btn.click();
    }

    @Step("User is at login code screen and enter valid login code")
    private void verifyLoginWithOTP(String otp) {
        otp_Textarea.sendKeys(otp);
        verify_Btn.click();
        if (driver instanceof AndroidDriver) {
            softAssert.assertTrue(Utility.isAvailable(driver, logout_Btn));
        }
        logout_Btn.click();
        confirmlogout_Btn.click();
        softAssert.assertAll();
    }
    @Step("User enters valid bulk details and click on back to login link")
    public void loginWithBulkData(BProfileOnboarding bProfileOnboarding,String eventName) {
        setEmail(bProfileOnboarding.getEmail());
        softAssert.assertEquals(getEventName.getText(), eventName);
        Utility.waitUntilElement(driver,inputemailId);
        softAssert.assertTrue(inputemailId.getText().contains(bProfileOnboarding.getEmail()));
        setFirstUser.sendKeys(bProfileOnboarding.getFirstName());
        setLastUser.sendKeys(bProfileOnboarding.getLastName());
        setPassword.sendKeys("test");
        setConfirmPassword.sendKeys("test");
        signUpBtnList.get(0).click();
        softAssert.assertAll();
    }

}