package com.hubilo.pageobjects.functions;

import com.hubilo.pageobjects.locators.EventFeedLocator;
import com.hubilo.utils.helper.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class EventFeed extends EventFeedLocator {
    private AppiumDriver driver;
    private SoftAssert softAssert = new SoftAssert();

    public EventFeed(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void verifyFeed(String testcase, String text) {
        switch (testcase) {
            case "post text":
                verifyPostText(text);
                break;
            case "post picture":
                verifyPostPicture();
                break;
            case "post looking for":
                verifyPostLookingFor(text);
                break;
            case "post offering for":
                verifyPostOfferingFor(text);
                break;
            case "post like":
                verifyLikePost();
                break;
            case "post comment":
                verifyCommentPost(text);
                break;
        }
    }

    private void gotoFeed(){
        reception.click();
        Utility.sleep(1000);
        Utility.waitUntilElement(driver,feedPost);
        feedPost.click();
        feedPost.click();
    }
    @Step("Go to event and create {type}, verify toast message and then delete created post")
    private void verifyPostText(String postText){
        Utility.gotoReception(driver);
        gotoFeed();
        Utility.waitUntilElement(driver, shareWhatsOnYourMind);
        shareWhatsOnYourMind.click();
        if(driver instanceof IOSDriver)
        {
            allowAccessToAllPhotos.click();
        }
        inputText.sendKeys(postText);
        postBtn.click();
        validateToastMessage("created");
        //verifyPost();
    }

    @Step("Go to event and create {type}, verify toast message and then delete created post")
    private void verifyPostPicture(){
        gotoFeed();
        if(driver instanceof AndroidDriver) {
            Utility.sleep(1000);
            Utility.waitUntilElement(driver, shareWhatsOnYourMind);
            shareWhatsOnYourMind.click();
        }else{
            shareWhatsOnYourMind.click();
        }
        Utility.waitUntilElement(driver, galleryBtn);
        galleryBtn.click();
        Utility.sleep(2000);
        if(driver instanceof AndroidDriver) {
            Utility.waitUntilElement(driver, addPicture);
        }
        addPicture.click();
        Utility.sleep(1000);
        if(driver instanceof AndroidDriver)
        {
            Utility.waitUntilElement(driver, shutterBtn);
            shutterBtn.click();
            Utility.waitUntilElement(driver, doneCaptureImage);
            doneCaptureImage.click();
        }
        Utility.sleep(1000);
        Utility.waitUntilElement(driver, postBtn);
        postBtn.click();
        validateToastMessage("created");
        //verifyPost();
    }

    @Step("Go to event and create {type}, verify toast message and then delete created post")
    private void verifyPostLookingFor(String lookingForText){
        reception.click();
        gotoFeed();
        Utility.sleep(1000);
        Utility.waitUntilElement(driver, shareWhatsOnYourMind);
        shareWhatsOnYourMind.click();
        audioBtn.click();
        lookingFor.click();
        inputText.sendKeys(lookingForText);
        postBtn.click();
        validateToastMessage("created");
        //verifyPost();
    }

    @Step("Go to event and create {type}, verify toast message and then delete created post")
    private void verifyPostOfferingFor(String offeringPostText){
        reception.click();
        gotoFeed();
        Utility.sleep(1000);
        Utility.waitUntilElement(driver, shareWhatsOnYourMind);
        shareWhatsOnYourMind.click();
        audioBtn.click();
        offeringFor.click();
        inputText.sendKeys(offeringPostText);
        postBtn.click();
        validateToastMessage("created");
        //verifyPost();
    }

    @Step("Go to event and create {type}, verify toast message and then delete created post")
    private void verifyLikePost(){
        gotoFeed();
        Utility.sleep(1000);
        if(driver instanceof IOSDriver)
        {
            Utility.scrollDown(driver);
        }
        Utility.waitUntilElement(driver, likeCount.get(0));
        String likeCountText = likeCount.get(0).getText();
        likeBtn.click();
        Utility.sleep(1000);
        if(driver instanceof AndroidDriver)
        {
            Utility.waitUntilElement(driver, likeCount.get(0));
            softAssert.assertFalse(likeCount.get(0).getText().equals(likeCountText));
        }else {
            softAssert.assertTrue(likeCount.size() == 0);
            meetingBtn.click();
            reception.click();
        }
    }

    @Step("Go to event and create {type}, verify toast message and then delete created post")
    private void verifyCommentPost(String commentText){
        reception.click();
        gotoFeed();
        Utility.sleep(1000);
        Utility.scrollDown(driver);
        Utility.waitUntilElement(driver, commentCount.get(0));
        String commentCounts = commentCount.get(0).getText();
        comment.click();
        Utility.waitUntilElement(driver, inputComment);
        inputComment.sendKeys(commentText);
        sendcomment.click();
        Utility.waitUntilElement(driver, back);
        back.click();
        if(driver instanceof AndroidDriver)
        {
            Utility.sleep(1000);
            Utility.waitUntilElement(driver,commentCount.get(0));
            softAssert.assertFalse(commentCount.get(0).getText().equals(commentCounts));
        }else {
            softAssert.assertTrue(commentCount.size() == 0);
            meetingBtn.click();
            reception.click();
        }
    }

    private void verifyPost() {
        reception.click();
        Utility.sleep(1000);
        feedPost.click();
    }

    private void verifyDelete() {
        softAssert.assertTrue(Utility.isAvailable(driver, verifyText));
        threedots.click();
        delete.click();
        confirmDelete.click();
        validateToastMessage("deleted");
        verifyPost();
    }

    private void validateToastMessage(String s) {
        if (s.equalsIgnoreCase("created")) {
            softAssert.assertEquals(toast.getText(), "Feed created successfully");
            if (Utility.isAvailable(driver,toast)) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        } else {
            softAssert.assertEquals(toast.getText(), "This Feed has been deleted.");
            if (Utility.isAvailable(driver,toast)) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }
}

