package com.hubilo.pageobjects.functions;

import com.hubilo.pageobjects.locators.ProfileLocator;
import com.hubilo.pojo.ui.BProfileOnboarding;
import com.hubilo.pojo.ui.SignUpData;
import com.hubilo.utils.helper.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Profile extends ProfileLocator {
    private AppiumDriver driver;
    private SoftAssert softAssert = new SoftAssert();

    String[] newData = {
            "Jatin",
            "Shamra",
            "It can be challenging to write about yourself. However, " +
                    "the good news is if you follow the formula and tips below, you should be able to generate an engaging About Me statement," +
                    " without too much of a struggle.",
            "Customer Support",
            "Amazon India",
            "Customer Service",
            "Agriculture",
            "Marketing Executive",
            "Salesperson"
    };
    List<String> listData = Arrays.asList(newData);
    private String interest = listData.get(6);
    Utility utility = new Utility();

    public Profile(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verifyProfile(String option, SignUpData signUpData) {
        switch (option) {
            //     case "personal detail with new data": verifyEditProfileWithNewData(signUpData); break;
            //    case "personal detail change new data": verifyEditProfileChangeNewData(signUpData); break;
            case "select new insterests":
                setInterest(listData, signUpData);
                break;
            case "select new looking for and offering":
                setLookingforAndOffering(listData, signUpData);
                break;
            case "bookmarked speakers unbookmark":
                bookmarkedUnBookmarkSpeakers();
                break;
            case "bookmarked attendees unbookmark":
                bookmarkedUnBookmarkAttendees();
                break;
            case "bookmark exhibitors unbookmark":
                bookmarkedUnBookmarkExhibitors();
                break;
            case "verify timezone":
                verifyTimezone();
                break;
            case "timezone 24 hour toggle ON/OFF":
                changeTimezone24();
                break;
        }
    }

    public void gotoProfile() {

        if (driver instanceof IOSDriver) {
            receptionTab.click();
        } else {
            //Utility.gotoReception(driver);
        }
        Utility.waitUntilElement(driver,gotoProfileBtn);
        gotoProfileBtn.click();
    }

    private void verifyProfileSettingView(SignUpData signUpData) {
        String name = signUpData.getFirstName() + " " + signUpData.getLastName();
        String designation = signUpData.getDesignation() + " @ " + signUpData.getOrganisation();
        if (driver instanceof AndroidDriver) {
            softAssert.assertTrue(profileName.get(0).getText().equals(name));
            softAssert.assertTrue(profileViewDesignation.get(0).getText().equals(designation));
        } else {
            softAssert.assertTrue(profileName.get(2).getText().equals(name));
            softAssert.assertTrue(profileViewDesignation.get(2).getText().equals(designation));
        }
    }

    public void iOSEditProfileData(BProfileOnboarding bProfileOnboarding) {
        inputList.get(0).clear();
        inputList.get(0).sendKeys(bProfileOnboarding.getFirstName());
        aboutClick.click();
        inputList.get(1).clear();
        inputList.get(1).sendKeys(bProfileOnboarding.getLastName());
        aboutClick.click();
        thisIsAbout.clear();
        thisIsAbout.sendKeys(bProfileOnboarding.getAbout());
        aboutClick.click();
        inputList.get(2).clear();
        inputList.get(2).sendKeys(bProfileOnboarding.getDesignation());
        aboutClick.click();
        inputList.get(3).clear();
        inputList.get(3).sendKeys(bProfileOnboarding.getOrganisation());
        aboutClick.click();
        aboutClick.click();
    }

    private void verifyPersonalInfo(BProfileOnboarding bProfileOnboarding) {

        if (driver instanceof AndroidDriver) {
            utility.waitElement(driver).until(ExpectedConditions.visibilityOf(inputList.get(0))).sendKeys(bProfileOnboarding.getFirstName());
            utility.waitElement(driver).until(ExpectedConditions.visibilityOf(inputList.get(1))).sendKeys(bProfileOnboarding.getLastName());
            utility.waitElement(driver).until(ExpectedConditions.visibilityOf(inputList.get(2))).sendKeys(bProfileOnboarding.getAbout());
            utility.waitElement(driver).until(ExpectedConditions.visibilityOf(inputList.get(3))).sendKeys(bProfileOnboarding.getDesignation());
            utility.scrollDownUpToElement(driver);
            utility.waitElement(driver).until(ExpectedConditions.visibilityOf(inputList.get(4))).sendKeys(bProfileOnboarding.getOrganisation());

        }
        if (driver instanceof IOSDriver) {
            iOSEditProfileData(bProfileOnboarding);
        }
        if (driver instanceof AndroidDriver) {
            industrytxt.click();
            utility.listDropDown(selectOptions, textSearch, bProfileOnboarding.getIndustry());
        } else {
            industrytxt.click();
            textSearchEdit.sendKeys(bProfileOnboarding.getIndustry());
            selectOptions.get(0).click();
        }
        Utility.sleep(2000);
        if(driver instanceof IOSDriver)
        {
            Utility.scrollDown(driver);
        }else {
            Utility.waitUntilElement(driver, saveChanges);
        }
        saveChanges.click();
        Utility.sleep(2000);
        Utility.waitUntilElement(driver, back);
        back.click();
        String name = bProfileOnboarding.getFirstName() + " " + bProfileOnboarding.getLastName();
        String designation = bProfileOnboarding.getDesignation() + " at " + bProfileOnboarding.getOrganisation();
        if (driver instanceof AndroidDriver) {
            Utility.waitUntilElement(driver, profileName.stream().findFirst().get());
            System.out.println("Designation : " + designation);
            System.out.println("bulk Designation : " + profileViewDesignation.get(0).getText());
            softAssert.assertTrue(profileName.get(0).getText().equals(name), "name match");
            editProfile.click();
            back.click();
            String design_org = profileViewDesignation.get(0).getText();
            softAssert.assertTrue(design_org.equals(designation), "designation match");
        } else {
            Utility.sleep(2000);
            System.out.println(profileViewDesignation.get(0).getText());
            System.out.println(designation);
        //    softAssert.assertTrue(profileViewDesignation.get(0).getText().equals(designation));
            editProfile.click();
            Utility.sleep(2000);
            softAssert.assertTrue(inputList.get(0).getText().equals(bProfileOnboarding.getFirstName()));
            softAssert.assertTrue(inputList.get(1).getText().equals(bProfileOnboarding.getLastName()));
            back.click();
        }
        softAssert.assertAll();
    }

    private void setInterest(List<String> listDatas, SignUpData signUpData) {
        editProfile.click();
        gotoInterest.click();
        // removing existing
        if (listDatas.get(6).equals("Agriculture")) {
            utility.listDropDown(selectInterests, textSearch, signUpData.getInterest());
        } else {
            utility.listDropDown(selectInterests, textSearch, interest);
        }
        if (driver instanceof IOSDriver) {
            textSearch.clear();
        }
        utility.listDropDown(selectInterests, textSearch, listDatas.get(6));
        if (driver instanceof IOSDriver) {
            personalInfo.click();
            gotoInterest.click();
        }
        saveChanges.click();
        if (driver instanceof AndroidDriver) {
            softAssert.assertTrue(toastMessage.getText().contains("Updated successfully"), "set interest toast message failed");
        } else {
            softAssert.assertTrue(toastMessage.getText().contains("Profile updated"), "set interest toast message failed");
        }
        Utility.waitUntilElement(driver, back);
        back.click();
        softAssert.assertAll();
    }

    private void setLookingforAndOffering(List<String> listDatas, SignUpData signUpData) {
        editProfile.click();
        gotoLookingAndOffering.click();
        lookingFor.get(0).click();
        if (driver instanceof AndroidDriver) {
            utility.listDropDown(selectOptions, textSearch, listDatas.get(7));
            offeringFor.get(0).click();
            utility.listDropDown(selectOptions, textSearch, listDatas.get(8));
        } else {
            textSearchEdit.sendKeys(listDatas.get(7));
            selectOptions.get(0).click();
            offeringForIos.click();
            textSearchEdit.sendKeys(listDatas.get(8));
            selectOptions.get(0).click();
        }
        saveChanges.click();
        if (driver instanceof AndroidDriver) {
            softAssert.assertTrue(toastMessage.getText().contains("Updated successfully"), "set Looking for get toast failed");
        } else {
            softAssert.assertTrue(toastMessage.getText().contains("Profile updated"), "set Looking for get toast failed");
        }
        Utility.waitUntilElement(driver, back);
        back.click();
        softAssert.assertAll();
    }

    private void verifyElement(SignUpData signUpData) {
        Assert.assertEquals(inputList.get(0).getText(), signUpData.getFirstName());
        Assert.assertEquals(inputList.get(1).getText(), signUpData.getLastName());
        Assert.assertEquals(inputList.get(2).getText(), signUpData.getAbout());
        Assert.assertEquals(inputList.get(3).getText(), signUpData.getDesignation());
        Assert.assertEquals(inputList.get(4).getText(), signUpData.getOrganisation());
        // Assert.assertEquals(inputList.get(5).getText(), signUpData.getIndustry());
    }

    public void gotoMyBriefCase() {
        myBriefcase.click();
        backBtn.click();
    }

    private void bookmarkedUnBookmarkAttendees() {
        bookmark.click();
        tabAttendees.click();
        long count = listPeoples.stream().count();
        System.out.println(count);
        softAssert.assertTrue(count > 0);
        //backBtn.click();
        // bookmark.click();
        //tabAttendees.click();
        unbookmark.stream().findFirst().get().click();
        System.out.println(listPeoples.stream().count());
        softAssert.assertTrue(listPeoples.stream().count() < count);
        backBtn.click();
        softAssert.assertAll();
    }

    private void bookmarkedUnBookmarkSpeakers() {
        bookmark.click();
        //tabSpeakers.click();
        long count = listPeoples.stream().count();
        System.out.println(count);
        softAssert.assertTrue(count > 0);
        backBtn.click();
        bookmark.click();
        // tabSpeakers.click();
        unbookmark.stream().findFirst().get().click();
        System.out.println(listPeoples.stream().count());
        softAssert.assertTrue(listPeoples.stream().count() < count);
        backBtn.click();
        softAssert.assertAll();
    }

    private void bookmarkedUnBookmarkExhibitors() {
        bookmark.click();
        tabExhibitors.click();
        long count = listExhibitors.stream().count();
        System.out.println(count);
        softAssert.assertTrue(count > 0);
        // backBtn.click();
        // bookmark.click();
        // tabExhibitors.click();
        unbookmarkExb.get(2).click();
        System.out.println(listExhibitors.stream().count());
        softAssert.assertTrue(listExhibitors.stream().count() < count);
        backBtn.click();
        softAssert.assertAll();
    }

    public void gotoTicketInvoice() {
        ticketInvoice.click();
        backBtn.click();
    }

    public void gotoSettings() {
        settings.click();
        backBtn.click();
    }

    private void verifyTimezone() {
        String[] timezone = {
                "Denver",
                "Kolkata"
        };
        languageTimezone.click();
        searchAndSelectTimezone(timezone[0]);
        languageTimezone.click();
        searchAndSelectTimezone(timezone[1]);

    }

    private void searchAndSelectTimezone(String timezoneName) {
        timezonelabel.get(0).click();
        searchBox.sendKeys(timezoneName);
        if (driver instanceof IOSDriver) {
            listTimeZone.get(0).click();
        } else {
            listTimeZone.stream().filter(element -> element.getText().contains(timezoneName)).findFirst().get().click();
        }
        // System.out.println(listTimeZone.stream().filter(element -> element.getText().contains(timezoneName)).findFirst().get().getText());
        //softAssert.assertTrue(isTimezoneSelected.stream().count() <= 2);
        doneBtn.click();
        softAssert.assertTrue(timezonelabel.get(0).getText().contains(timezoneName));
        saveTimezone.click();
        gotoProfile();
        languageTimezone.click();
        Utility.waitUntilElement(driver, timezonelabel.stream().findFirst().get());
        System.out.println("timezone label " + timezonelabel.get(0).getText());
        softAssert.assertTrue(timezonelabel.get(0).getText().contains(timezoneName), "get timezone failed");
        backBtn.click();
        softAssert.assertAll();
    }

    public void changeTimezone24() {
        if (driver instanceof AndroidDriver && !timeFormat24Toggle.isSelected()) {
            timeFormat24Toggle.click();
            softAssert.assertTrue(toastMessage.getText().contains("Updated successfully"), "Time zone 24 toast failed to get");
        } else {
            timeFormat24Toggle.click();
            softAssert.assertTrue(toastMessageiOS.getText().contains("Updated successfully"));
        }
        Utility.waitUntilElement(driver, closeBtn);
        closeBtn.click();
        gotoProfileBtn.click();
        if (driver instanceof AndroidDriver) {
            Utility.waitUntilElement(driver, timeFormat24Toggle);
            softAssert.assertTrue(Boolean.parseBoolean(timeFormat24Toggle.getAttribute("checked")), "24 not checked");
        } else {
            softAssert.assertTrue(Time_Format24.size() > 0, "24 not checked");
        }
        timeFormat24Toggle.click();
        softAssert.assertAll();
    }

    public LoginPage logOut(String eventName) {
        Utility.sleep(1000);
        if(driver instanceof AndroidDriver) {
            utility.scrollDownUpToElement(driver);
            Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(logout)).click();
        }else {
            driver.findElementById("Logout").click();
        }
        if (driver instanceof AndroidDriver) {
            confirmLogout.get(0).click();
        } else {
            confirmLogout.get(0).click();
        }
        //   Assert.assertTrue(this.selectedEventName.getText().equalsIgnoreCase(eventName));
        return new LoginPage(driver);
    }

    public void verifyAgendaNote(String agendaName, String noteMessage) {
        gotoProfile();
        gotoBriefcase.click();
        noteTab.click();
        agendaNote.click();
//        softAssert.assertTrue(getAgendaName.stream().
//                filter((element -> element.getText().equalsIgnoreCase(agendaName))).
//                findFirst().isPresent());
        Utility.sleep(1000);
        softAssert.assertTrue(getAgendaNoteDescription.stream().
                filter((element -> element.getText().equalsIgnoreCase(noteMessage))).
                findFirst().isPresent());
        softAssert.assertTrue(getAgendaName.stream().filter((element -> element.getText().equalsIgnoreCase(agendaName))).findFirst().isPresent());
        deleteAgendaNotes.click();
        if (driver instanceof AndroidDriver) {
//            try {
//                confirmDeleteNotes.click();
//                if (closePIP.isDisplayed()) {
//                    closePIP.click();
//                }
//            } catch (NoSuchElementException noSuchElementException) {
//                noSuchElementException.getMessage();
//            }
            confirmDeleteNotes.click();
            Utility.waitUntilElement(driver, toastMessage);
            softAssert.assertTrue(toastMessage.getText().contains("Note deleted successfully."));
            Utility.waitUntilElement(driver, back);
        } else {
            confirmDeleteNotes.click();
        }
        back.click();
        closeBtn.click();
        Utility.sleep(1000);
        meetingBtn.click();
        Utility.waitUntilElement(driver, receptionTab);
        receptionTab.click();
        softAssert.assertAll();
    }

    public void verifyMatchmakingUpdated(String type) {
        closeBtn.click();
        gotoProfileBtn.click();
        Utility.waitUntilElement(driver, editProfile);
        editProfile.click();
        if (type.equalsIgnoreCase("interest")) {
            if (driver instanceof AndroidDriver)
                Assert.assertFalse(driver.findElements(By.xpath("//android.widget.TextView[@text='Interest']")).size() > 0);
            else
                Assert.assertFalse(driver.findElements(By.xpath("**/XCUIElementTypeStaticText[`label == 'Interest']")).size() > 0);

        } else if (type.equalsIgnoreCase("lookingfor")){
            if (driver instanceof AndroidDriver)
                Assert.assertFalse(driver.findElements(By.xpath("//android.widget.TextView[@text='Looking & Offering']")).size() > 0);
            else
                Assert.assertFalse(driver.findElements(By.id("Looking & Offering")).size() > 0);
        }else if (type.equalsIgnoreCase("industry")){
            if (driver instanceof AndroidDriver){
                utility.scrollDownUpToElement(driver);
                Utility.sleep(1000);
                Assert.assertFalse(driver.findElements(By.xpath("//android.widget.TextView[@text='Industry']")).size() > 0);
            }
            else {
                Assert.assertFalse(driver.findElements(By.xpath(
                        "//XCUIElementTypeApplication[@name=\"HubiloApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField"
                )).size() > 0);
            }
        }
        back.click();
    }

    public void verifyProfileDataSet(BProfileOnboarding bProfileOnboarding) {
        editProfile.click();
        verifyPersonalInfo(bProfileOnboarding);
    }
}