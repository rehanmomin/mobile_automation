package com.hubilo.pageobjects.functions;

import com.hubilo.pageobjects.locators.LeaderboardLocator;
import com.hubilo.utils.helper.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class Leaderboard extends LeaderboardLocator {

    private AppiumDriver driver;
    private SoftAssert softAssert = new SoftAssert();

    public Leaderboard(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void verifyLeaderboard(String testcase) {
        switch (testcase) {
            case "Leaderboard Page":
                verifyLeaderboardPageUI();
                break;
            case "points Page":
                verifyPointsPageUI();
                break;
            case "user detail":
                verifyProfileDetail();
                break;
            case "loggin user detail":
                verifyLogginProfile();
                break;
    }
    }

   @Step("Go to Leaderboard and verify elements on the screen")
    private void verifyLeaderboardPageUI() {
        gotoLeaderboard();
        softAssert.assertTrue(Utility.isAvailable(driver,leaderboardHeader), "Verify leaderboard header");
        softAssert.assertTrue(Utility.isAvailable(driver,pointsButton),"Verify Points Button on leaderboard page");
        softAssert.assertTrue(selfProfileWithMeText.getText().contains("me"),"Self profile With Me Text");
        softAssert.assertTrue(rankOne.getText().contains("1"),"Rank 1 on leaderboard page");
        softAssert.assertTrue(rankTwo.getText().contains("2"),"Rank 2 on leaderboard page");
       // softAssert.assertTrue(rankThree.getText().contains("3"),"Rank 3 on leaderboard page");
        softAssert.assertAll();
    }

    @Step("Go to Leaderboard, open points screen and verify elements on the screen")
    private void verifyPointsPageUI() {
        pointsButton.click();
        Utility.sleep(1000);
        softAssert.assertTrue(Utility.isAvailable(driver, leaderboardPointsHeader), "verify Leaderboard points header ");
        softAssert.assertTrue(Utility.isAvailable(driver,backIcon) ,"Verify back icon available");
        softAssert.assertTrue(Utility.isAvailable(driver,createPostListing),"Verify create post listing");
        softAssert.assertTrue(pointsOnLeaderboardPointsPage.getText().contains("pts") , "Verify Points on leaderboard points page");
        softAssert.assertTrue(numberOfPointsOnLeaderboardPointsPage.getText().contains("10") , "Verify number of points on leaderboard points page");
        backIcon.click();
        softAssert.assertAll();
    }

    @Step("Go to Leaderboard, Open any profile")
    private void verifyProfileDetail() {
        int x = meeting.getLocation().getX();
        int y = meeting.getLocation().getY();
        String userName = secondUserName.getText();
        if(driver instanceof IOSDriver)
        {
            if(secondUserImage.size()> 0)
            {
                secondUserImage.get(0).click();
            }else{
                secondUserImagefallback.click();
            }
        }else{
            secondUserImage.get(0).click();
        }
        softAssert.assertEquals(verifySecondUser.getText(), userName,"verify profile details");
        Utility.clickCordinate(driver,x,y);
        softAssert.assertAll();
    }

    @Step("Go to Leaderboard, verify loggin profile")
    private void verifyLogginProfile() {
        Utility.waitUntilElement(driver, logginUserName);
        System.out.println("User loggin name : "+logginUserName);
        softAssert.assertTrue(logginUserName.getText().contains(firstRankUserName.getText()),"verifying loggin user name");
        softAssert.assertEquals(logginUserDesignation.getText(), (firstRankUserDesignation.getText()),"verifying designation");
        softAssert.assertEquals(logginUserRank.getText(), (firstRank.getText()),"verifying rank");
        softAssert.assertEquals(logginUserPoints.getText(), (firstRankUserPoints.getText()),"verifying user point");
        if(driver instanceof AndroidDriver) {
            softAssert.assertTrue(Utility.isAvailable(driver, logginUserImage), "verify image display");
        }
        reception.click();
        softAssert.assertAll();
    }

    private void gotoLeaderboard() {
        try{
            if(driver instanceof AndroidDriver){
                Utility.sleep(5000);
                Utility.gotoReception(driver);
            }else {
                meeting.click();
            }

        }catch (NoSuchElementException noSuchElementException){
            noSuchElementException.printStackTrace();
        }
        reception.click();
        Utility.sleep(1000);
        menuIcon.click();
        Utility.sleep(1000);
        leaderBoardIcon.click();
        Utility.sleep(1000);
    }
}
