package com.hubilo.pageobjects.functions;

import com.hubilo.pageobjects.locators.LoungeLocator;
import com.hubilo.utils.helper.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

public class Lounge extends LoungeLocator {

    private AppiumDriver driver;
    private SoftAssert softAssert = new SoftAssert();
    public Lounge(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void verifyLounge(String testcase, String lounge){
        switch (testcase){
            case "verify lounge screen": verifyLoungeScreen(lounge); break;
            case "verify user able to grab seat": verifyGrabSeat(lounge); break;
            case "verify user image visible after grab seat": verifyUserImageAfterGrabSeat(lounge); break;
            case "verify active lounge after grab seat": verifyActiveTableAfterJoined(lounge); break;
            case "verify user able to leave table": verifyLeaveTable(lounge); break;
            case "verify error message if no active lounges": verifyNoActiveLounges(lounge); break;
            case "verify lounge list": verifyLoungeList(lounge); break;

        }
    }

    private String memberspotsJoined;
    private void verifyLoungeScreen(String lounge) {
        Utility.sleep(1000);
        gotoLounge();
        Utility.sleep(1000);
        Utility.waitElement(driver).until(ExpectedConditions.
                visibilityOf(loungeName.stream().filter(element -> element.getText().contains(lounge)).
                        findFirst().get()));
        softAssert.assertEquals(showActiveTablesText.getText(), "Show Active Tables");
        //softAssert.assertTrue(Utility.isAvailable(driver,showLoungeImage.stream().findFirst().get()));
        softAssert.assertTrue(Utility.isAvailable(driver,memberSpots.stream().findFirst().get()));
        softAssert.assertTrue(Utility.isAvailable(driver,loungeName.stream().
                filter(element -> element.getText().contains(lounge)).
                findFirst().get()));
        softAssert.assertTrue(Utility.isAvailable(driver,loungeDescription.stream().findFirst().get()));
        memberspotsJoined = memberSpots.stream().findFirst().get().getText();
        softAssert.assertAll();
    }

    private void verifyGrabSeat(String lounge) {
        loungeName.stream().filter(element -> element.getText().contains(lounge)).
                findFirst().get().click();
        softAssert.assertTrue(Utility.isAvailable(driver, loungeNameWithSpots));
        softAssert.assertTrue(Utility.isAvailable(driver, availSpots));
        softAssert.assertEquals(joinedPeople.getText().trim(),"No one joined yet");
        Utility.waitUntilElement(driver, grabSeatBtn);
        grabSeatBtn.click();
        softAssert.assertAll();
    }

    private void verifyUserImageAfterGrabSeat(String lounge) {
        Utility.sleep(1000);
        try{
            Utility.swipeToRefresh(driver, showActiveTablesText, loungeDescription.get(0));
            Utility.isAvailable(driver, profileImage);
        }catch (NoSuchElementException noSuchElementException){
            System.out.println("Exception : "+noSuchElementException.getMessage());
        }
        softAssert.assertTrue(Utility.isAvailable(driver, profileImage));
        if(driver instanceof AndroidDriver) {
            softAssert.assertFalse(memberSpots.stream().findFirst().get().getText().contains(memberspotsJoined));
        }
        softAssert.assertTrue(Utility.isAvailable(driver, loungeName.stream().
                filter(element -> element.getText().contains(lounge)).
                findFirst().get()));
        softAssert.assertTrue(Utility.isAvailable(driver, loungeDescription.stream().findFirst().get()));
       // softAssert.assertTrue(Utility.isAvailable(driver, showLoungeImage.stream().findFirst().get()));
        softAssert.assertAll();
    }

    private void verifyActiveTableAfterJoined(String lounge) {
        showActiveToggle.click();
        softAssert.assertTrue(Utility.isAvailable(driver, profileImage));
        if(driver instanceof AndroidDriver) {
            softAssert.assertFalse(memberSpots.stream().findFirst().get().getText().contains(memberspotsJoined));
        }
        softAssert.assertTrue(Utility.isAvailable(driver, loungeName.stream().
                filter(element -> element.getText().contains(lounge)).
                findFirst().get()));
        softAssert.assertTrue(Utility.isAvailable(driver, loungeDescription.stream().findFirst().get()));
     //   softAssert.assertTrue(Utility.isAvailable(driver, showLoungeImage.stream().findFirst().get()));
        if(driver instanceof AndroidDriver) {
            showActiveToggle.click();
        }else {
            performInactiveToggle.click();
        }
        softAssert.assertAll();
    }

    private void verifyLeaveTable(String lounge) {
        Utility.sleep(1000);
        showActiveToggle.click();
        Utility.sleep(1000);
        loungeName.stream().filter(element -> element.getText().contains(lounge)).
                findFirst().get().click();
        Utility.sleep(1000);
        if(driver instanceof AndroidDriver) {
            softAssert.assertTrue(Utility.isAvailable(driver, profileImage));
        } else {
            softAssert.assertTrue(Utility.isAvailable(driver,profileImageAfterJoin));
        }
        softAssert.assertTrue(Utility.isAvailable(driver, loungeNameWithSpots));
       // softAssert.assertTrue(Utility.isAvailable(driver, verifyPeopleNameJoined));
        leaveTable.click();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException interruptedException){
            interruptedException.getMessage();
        }
        if(driver instanceof AndroidDriver) {
            showActiveToggle.click();
        } else {
            performInactiveToggle.click();
        }
        softAssert.assertTrue(Utility.isAvailable(driver, loungeName.stream().filter(element -> element.getText().contains(lounge)).
                findFirst().get()));
      //  softAssert.assertTrue(Utility.isAvailable(driver, loungeDescription.stream().findFirst().get()));
       // softAssert.assertTrue(Utility.isAvailable(driver, showLoungeImage.stream().findFirst().get()));
        softAssert.assertAll();
    }

    private void verifyNoActiveLounges(String lounge) {
        showActiveToggle.click();
        if(driver instanceof AndroidDriver) {
            softAssert.assertEquals(emptyScreen.getText(), "No lounge in progress currently");
            showActiveToggle.click();
        } else {
            softAssert.assertEquals(emptyScreen.getText(), "No Lounge in progress currently");
            performInactiveToggle.click();
        }
        softAssert.assertAll();
    }

    private void verifyLoungeList(String lounge) {
        System.out.println(loungeList.stream().count());
        if(driver instanceof AndroidDriver)
        {
            softAssert.assertTrue(loungeList.stream().count() > 0);
        }else {
            softAssert.assertTrue(loungeList.stream().count() > 0);
        }
        softAssert.assertAll();
        Utility.clickIOSReception(driver,reception);
    }

    private void gotoLounge(){
        Utility.gotoReception(driver);
        Utility.clickIOSReception(driver,reception, meetingBtn);
        Utility.sleep(1000);
        Utility.waitElement(driver).until((element)-> Utility.isAvailable(driver,menuTab));
        menuTab.click();
        lounge.click();
    }
}