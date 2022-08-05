package com.hubilo.pageobjects.functions;

import com.hubilo.pageobjects.locators.OnboardingLocator;
import com.hubilo.pojo.ui.BProfileOnboarding;
import com.hubilo.pojo.ui.SignUpData;
import com.hubilo.utils.helper.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class Onboarding extends OnboardingLocator {

    private AppiumDriver driver;
    private SoftAssert softAssert = new SoftAssert();

    private String verifyFirstName, verifyLastName;
    Utility util = new Utility();

    public Onboarding(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void verifyOnboarding(String testcase, SignUpData signUpData, String eventName) {
        switch (testcase) {
            case "verify onboarding form":
                verifyDetailOnboardingForm(signUpData);
                break;
            case "verify background images":
                setBackgroundImageCover();
                break;
            case "verify social links":
                setSocialDetail(signUpData);
                break;
            case "verify looking for and offerings":
                setLookingForOffering(signUpData);
                break;
            case "verify interests":
                setInterest(signUpData, eventName);
                break;
            case "verify onboarding disabled":
                verifyOnboardingDisable(eventName);
                break;
        }
    }

    @Step("After sign up, user fills onboarding form bulk")
    public void verifyDetailOnboardingFormBulk(BProfileOnboarding bProfileOnboarding) {
        try {
            Utility.waitUntilElement(driver, logoutIcon);
            Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(userFirstTitle.get(0)));
            if (userFirstTitle.get(0).getText().contains(bProfileOnboarding.getFirstName()) || userFirstTitle.get(3).getText().contains(bProfileOnboarding.getFirstName())) {
                if (bProfileOnboarding.getGender().equalsIgnoreCase("Other")) {
                    listGender.get(2).click();
                    if (driver instanceof AndroidDriver) {
                        setOtherGenderOption.sendKeys("Transgender");
                    }
                } else if (bProfileOnboarding.getGender().equalsIgnoreCase("Male")) {
                    listGender.get(0).click();
                } else if (bProfileOnboarding.getGender().equalsIgnoreCase("Female")) {
                    listGender.get(1).click();
                }
                if (driver instanceof AndroidDriver)
                    new Utility().scrollByText(driver, "Designation");

            }
        } catch (NoSuchElementException noSuchElementException) {
            throw new NoSuchElementException("Onboarding form exception occured");
        }
        new Utility().sleep(2000);
        about.sendKeys(bProfileOnboarding.getAbout());
        if (driver instanceof IOSDriver) {
            about_lbl.click();
        }
        designation.sendKeys(bProfileOnboarding.getDesignation());
        if (driver instanceof IOSDriver) {
            about_lbl.click();
        }
        organisation.sendKeys(bProfileOnboarding.getOrganisation());
        if (driver instanceof IOSDriver) {
            about_lbl.click();
        }
        dropDownListHandleWithSearchText(countryDropDown, bProfileOnboarding.getCountry());
        if (driver instanceof AndroidDriver) {
            dropDownListHandleWithSearchText(stateDropDown, bProfileOnboarding.getState());
        }
        city_town.sendKeys(bProfileOnboarding.getCity());
        if (driver instanceof IOSDriver) {
            about_lbl.click();
        }
        industry.click();
        searchIndustryType.sendKeys(bProfileOnboarding.getIndustry());
        if (driver instanceof IOSDriver) {
            select_searchresult.click();
        } else {
            selectIndustryType.stream().filter(element -> element.getText().equalsIgnoreCase(bProfileOnboarding.getIndustry()))
                    .findFirst().get().click();
        }
        if (driver instanceof IOSDriver) {
            Country.click();
        }
        signUpVerifyContinue.click();
        softAssert.assertAll();

    }

    @Step("After sign up, user fills onboarding form")
    private void verifyDetailOnboardingForm(SignUpData signUpData) {
        try {
            Utility.waitUntilElement(driver, getLogoutBtn);
            Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(userFirstTitle.get(0)));
            if (userFirstTitle.get(0).getText().contains(signUpData.getFirstName()) || userFirstTitle.get(3).getText().contains(signUpData.getFirstName())) {
                if (signUpData.getGender().equalsIgnoreCase("Other")) {
                    listGender.get(2).click();
                    if (driver instanceof AndroidDriver) {
                        setOtherGenderOption.sendKeys("Transgender");
                    }
                } else if (signUpData.getGender().equalsIgnoreCase("Male")) {
                    listGender.get(0).click();
                } else if (signUpData.getGender().equalsIgnoreCase("Female")) {
                    listGender.get(1).click();
                }

                new Utility().scrollByText(driver, "Industry");

            }
        } catch (NoSuchElementException noSuchElementException) {
            throw new NoSuchElementException("Onboarding form exception occured");
        }

        about.sendKeys(signUpData.getAbout());
        designation.sendKeys(signUpData.getDesignation());
        organisation.sendKeys(signUpData.getOrganisation());
        dropDownListHandleWithSearchText(countryDropDown, signUpData.getCountry());
        if (driver instanceof AndroidDriver) {
            dropDownListHandleWithSearchText(stateDropDown, signUpData.getState());
        }
        city_town.sendKeys(signUpData.getCity());
        industry.click();
        searchIndustryType.sendKeys(signUpData.getIndustry());
        selectIndustryType.stream().filter(element -> element.getText().equalsIgnoreCase(signUpData.getIndustry()))
                .findFirst().get().click();
        if (driver instanceof IOSDriver) {
            Country.click();
        }
        signUpVerifyContinue.click();
        softAssert.assertAll();
    }

    @Step("After onboarding form, user add and remove background images")
    private void setBackgroundImageCover() {
        if (driver instanceof AndroidDriver) {
            softAssert.assertTrue(Utility.isAvailable(driver, listImageCover.get(1)));
            listImageCover.get(1).click();
            removeImage.click();
            listImageCover.get(3).click();
            gotoNext.click();
        } else {
            gotoNext.click();
        }
        softAssert.assertAll();
    }

    @Step("After user set background image, user enters social links")
    private void setSocialDetail(SignUpData signUpData) {
        List<String> list = Arrays.asList(
                signUpData.getWebsite(), signUpData.getFacebook(), signUpData.getLinkedin(),
                signUpData.getTwitter(), signUpData.getInstagram());

        softAssert.assertTrue(Utility.isAvailable(driver, setSocialLinks.get(0)));
        for (int i = 0; i < setSocialLinks.size(); i++) {
            setSocialLinks.get(i).sendKeys(list.get(i));
            if (driver instanceof IOSDriver) {
                dismissKeyboard.click();
            }
        }
        gotoNext.click();
        softAssert.assertAll();

    }

    @Step("After user enters social details, now user selects looking for and offerings")
    private void setLookingForOffering(SignUpData signUpData) {
        Utility.waitUntilElement(driver, lookingFor);
        softAssert.assertTrue(Utility.isAvailable(driver, lookingFor));
        lookingFor.click();
        dropDownlist(signUpData.getLookingFor());
        softAssert.assertTrue(Utility.isAvailable(driver, offering));
        offering.click();
        dropDownlist(signUpData.getOffering());
        gotoNext.click();
        softAssert.assertAll();
    }

    @Step("After user enters looking for and offerings details, user selects interests")
    private void setInterest(SignUpData signUpData, String eventName) {
        softAssert.assertTrue(Utility.isAvailable(driver, searchIndustryType));
        searchIndustryType.sendKeys(signUpData.getInterest());
        selectInterestTitle.click();
        if (driver instanceof AndroidDriver) {
            gotoNext.click();
        } else {
            dismisskeyboard.click();
            finish.click();
        }
        if (driver instanceof IOSDriver) {
            Utility.waitUntilElement(driver, timezoneSetUpLater);
            timezoneSetUpLater.click();
        } else {
            // if timezone visible
            Utility.waitUntilElement(driver, timezoneSetUpLater);
            timezoneSetUpLater.click();
        }
        softAssert.assertTrue(Utility.isAvailable(driver, notificationImage));
        softAssert.assertAll();
        profileLogout(eventName);
    }

    @Step("Go to profile setting and click on logout")
    private void profileLogout(String eventName) {
        Profile profile = new Profile(driver);
        profile.gotoProfile();
        profile.logOut(eventName);
    }

    private void dropDownListHandleWithSearchText(MobileElement element, String country) {
        element.click();
        searchTextAndClick(country);
    }

    private void searchTextAndClick(String name) {
        searchText.sendKeys(name);
        if (driver instanceof AndroidDriver) {
            selectfromList.stream()
                    .filter(mobileElement -> mobileElement.getText().equals(name))
                    .findFirst()
                    .get().click();
        } else {
            selectfromList.get(2).click();
        }
        selectionDone.click();
    }

    private void dropDownlist(String searchText) {
        searchIndustryType.sendKeys(searchText);
        if (driver instanceof AndroidDriver) {
            selectIndustryType.get(0).click();
        } else
            select_searchresult.click();

    }

    @Step("After sign up, onboarding, background, looking for and offerings and interests should skipped" +
            "User landed on reception screen")
    private void verifyOnboardingDisable(String eventName) {
        Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(timezoneSetUpLater));
        if (driver instanceof AndroidDriver)
            softAssert.assertTrue(Utility.isAvailable(driver, language_timezone));

        timezoneSetUpLater.click();
        softAssert.assertAll();
        profileLogout(eventName);
    }

    public void logout() {
        Utility.sleep(1000);
        logoutIcon.click();
        Utility.sleep(1000);
        confirmLogout.click();
    }

}
