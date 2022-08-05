package com.hubilo.pageobjects.locators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

/**
 * @created: 2022-05-17-2:04 AM
 * @project: Hubilo_App_Automation under @package: @package: com.hubilo.pageobjects.locators
 * @author: Rehan
 **/


public class EventFeedLocator {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reception']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Reception\"`]")
    protected MobileElement reception;

    @AndroidFindBy(id = "imgMyMeetings")
    @iOSXCUITFindBy(id = "ic meet calendar")
    protected MobileElement meetingBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Event feed']")
    @iOSXCUITFindBy(id = "Event feed")
    protected MobileElement feedPost;

    @AndroidFindBy(id = "llHeader")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Share what's on your mind?\"`]")
    protected MobileElement shareWhatsOnYourMind;

    @iOSXCUITFindBy(id = "Allow Access to All Photos")
    protected MobileElement allowAccessToAllPhotos;

    @AndroidFindBy(id = "etFeedText")
    @iOSXCUITFindBy(id ="Share what's on your mind?")
    protected MobileElement inputText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Post']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Post\"`]")
    protected MobileElement postBtn;

    @AndroidFindBy(id = "feedTime")
    protected MobileElement verifyText;

    //@AndroidFindBy(id = "linShap")
    @AndroidFindBy(id = "llTemplateBackground")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeCell']")
    protected List<MobileElement> listPost;

    @AndroidFindBy(id = "tvCount")
    protected MobileElement wordCount;

    @AndroidFindBy(id = "ivGallery")
    @iOSXCUITFindBy(id = "ic img video")
    protected MobileElement galleryBtn;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    protected MobileElement getAllowAccessToAllPhotos;

    @AndroidFindBy(id = "rlAddPicture")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    protected MobileElement addPicture;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='While using the app']")
    protected MobileElement allowforeground;

    @AndroidFindBy(id = "com.android.camera2:id/shutter_button")
    protected MobileElement shutterBtn;

    @AndroidFindBy(id = "com.android.camera2:id/done_button")
    protected MobileElement doneCaptureImage;

    @AndroidFindBy(id = "ivFeedImage")
    protected MobileElement verifyCapturedImage;

    @AndroidFindBy(id = "ivVideo")
    protected MobileElement videoBtn;

    @AndroidFindBy(id = "ivAudio")
    @iOSXCUITFindBy(id = "ic introduction")
    protected MobileElement audioBtn;

    @AndroidFindBy(id = "tvLookingFor")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"I'm looking for\"`]")
    protected MobileElement lookingFor;

    @AndroidFindBy(id = "tvOffering")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"I'm offering\"`]")
    protected MobileElement offeringFor;

    @AndroidFindBy(id = "ivLike")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ic like\"`][1]")
    protected MobileElement likeBtn;

    @AndroidFindBy(id = "tvLikeCount")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"0 likes\"`][1]")
    protected List<MobileElement> likeCount;

    @AndroidFindBy(id = "tvCommentCounts")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \" 0 comments\"`][1]")
    protected List<MobileElement> commentCount;

    @AndroidFindBy(id = "tvComment")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Add Comment\"`][1]")
    protected MobileElement comment;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.MultiAutoCompleteTextView")
    @iOSXCUITFindBy(id = "Add Comment")
    protected MobileElement inputComment;

    @AndroidFindBy(id = "ivSend")
    @iOSXCUITFindBy(id = "ic send message")
    protected MobileElement sendcomment;

    @AndroidFindBy(id = "imgMore")
    protected MobileElement threedots;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='ivDelete']")
    protected MobileElement delete;

    @AndroidFindBy(id = "tvPositiveButton")
    protected MobileElement confirmDelete;



    @AndroidFindBy(id = "ivPollBar")
    protected MobileElement pollBtn;

    @AndroidFindBy(id = "ivBack")
    @iOSXCUITFindBy(id = "backIcon")
    protected MobileElement back;

    @AndroidFindBy(id = "profilePic")
    protected MobileElement profilePic;

    @AndroidFindBy(id = "txtMessage")
    @iOSXCUITFindBy(id = "Feed created successfully")
    protected MobileElement toast;



}
