package com.hubilo.pageobjects.locators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

/**
 * @created: 2022-05-16-10:52 AM
 * @project: Hubilo_App_Automation under @package: @package: com.hubilo.pageobjects.locators
 * @author: Rehan
 **/


public class ProfileLocator {
    @AndroidFindBy(id = "txtEventName")
    @iOSXCUITFindBy(id = "Automation-Appium")
    protected MobileElement selectedEventName;

    @AndroidFindBy(id = "imgUserProfile")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Reception\"`]/XCUIElementTypeButton[6]")
    protected MobileElement gotoProfileBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Reception\"`]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reception']")
    protected MobileElement receptionTab;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Cancel\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"backIcon\"`]")
    protected MobileElement backBtn;

    @AndroidFindBy(id = "imgMyMeetings")
    @iOSXCUITFindBy(id = "ic meet calendar")
    protected MobileElement meetingBtn;

    @AndroidFindBy(id = "tvProfileName")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@index=7]")
    protected List<MobileElement> profileName;

    @AndroidFindBy(id = "tvDesignation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@index= 12]")
    protected List<MobileElement> profileViewDesignation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Profile']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Edit Profile\"]")
    protected MobileElement editProfile;

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeTextField']")
    protected List<MobileElement> inputList;

    @AndroidFindBy(id = "edtIndustry")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"HubiloApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    protected MobileElement industrytxt;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"HubiloApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextView")
    protected MobileElement thisIsAbout;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Save Changes']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Save Changes\"]")
    protected MobileElement saveChanges;

    @iOSXCUITFindBy(id= "Personal Info")
    protected MobileElement  personalInfo;

    @iOSXCUITFindBy(id = "First Name*")
    protected MobileElement aboutClick;

    @AndroidFindBy(id = "edtTxtSearch")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeTextField']")
    protected MobileElement textSearch;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Search\"`]")
    protected MobileElement textSearchEdit;

    @AndroidFindBy(id = "spinnerText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"HubiloApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell")
    protected List<MobileElement> selectOptions;

    @AndroidFindBy(xpath ="//android.widget.TextView[@text='Interest']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Interest\"`]")
    protected MobileElement gotoInterest;

    @AndroidFindBy(id = "txtInterest")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeStaticText']")
    protected List<MobileElement> selectInterests;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Looking & Offering']")
    @iOSXCUITFindBy(id = "Looking & Offering")
    protected MobileElement gotoLookingAndOffering;

    @AndroidFindBy(id = "edtLookingFor")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeTextField']")
    protected List<MobileElement> lookingFor;

    @AndroidFindBy(id = "edtOffering")
    protected List<MobileElement> offeringFor;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"HubiloApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    protected MobileElement offeringForIos;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/cancelBtn")
    @iOSXCUITFindBy(id = "backIcon")
    protected MobileElement back;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Briefcase']")
    protected MobileElement myBriefcase;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bookmark']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Bookmark\"`]")
    protected MobileElement bookmark;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Speakers']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Speakers\"`]")
    protected MobileElement tabSpeakers;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Attendees']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Attendees\"`]")
    protected MobileElement tabAttendees;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Exhibitors']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Exhibitors\"`]")
    protected MobileElement tabExhibitors;

    @AndroidFindBy(id = "ivBookmark")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ic bookmarked\"`][1]")
    protected List<MobileElement> unbookmark;

    @AndroidFindBy(id = "ivBookmark")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeButton']")
    protected List<MobileElement> unbookmarkExb;

    @AndroidFindBy(id = "relPeopleMain")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeCell']")
    protected List<MobileElement> listPeoples;

    @AndroidFindBy(id = "linShaped")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeButton']")
    protected List<MobileElement> listExhibitors;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ticket Invoices']")
    protected MobileElement ticketInvoice;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    protected MobileElement settings;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Language & Time zone']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Language & Time zone\"`]")
    protected MobileElement languageTimezone;

    @AndroidFindBy(id = "txtMessage")
    @iOSXCUITFindBy(id = "Profile updated")
    protected MobileElement toastMessage;

    @iOSXCUITFindBy(id = "Updated successfully")
    protected MobileElement toastMessageiOS;

    @AndroidFindBy(id = "swOnOff24HrTimeFormat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Time Format (24 Hours)\"]")
    protected MobileElement timeFormat24Toggle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeSwitch[@value =1]")
    protected List<MobileElement> Time_Format24;

    @AndroidFindBy(id = "ivBack")
    @iOSXCUITFindBy(id = "ic Close")
    protected MobileElement closeBtn;

    @AndroidFindBy(id = "tvTimezoneSelected")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeTextField']")
    protected List<MobileElement> timezonelabel;

    @AndroidFindBy(id = "imgSelected")
    @iOSXCUITFindBy(xpath = "XCUIElementTypeStaticText")
    protected List<MobileElement> isTimezoneSelected;

    @AndroidFindBy(id = "edtTxtSearch")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Search\"`]")
    protected MobileElement searchBox;

    @AndroidFindBy(id = "spinnerText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"HubiloApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell")
    protected List<MobileElement> listTimeZone;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Logout']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton/XCUIElementTypeStaticText[@name=\"Logout\"]")
    protected MobileElement logout;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"My Briefcase\"`]")
    @AndroidFindBy(id = "lnMyBriefCase")
    protected MobileElement gotoBriefcase;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Notes']")
    @iOSXCUITFindBy(id = "Notes")
    protected MobileElement noteTab;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Agenda']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Agenda\"`][2]")
    protected MobileElement agendaNote;

    @AndroidFindBy(id = "tvNoteName")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable /XCUIElementTypeCell/XCUIElementTypeStaticText[@index = 2]")
    protected List<MobileElement> getAgendaName;

    @AndroidFindBy(id = "tvNoteDescription")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView/XCUIElementTypeTextView")
    protected List<MobileElement> getAgendaNoteDescription;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgDelete")
    @iOSXCUITFindBy(id = "ic delete")
    protected MobileElement deleteAgendaNotes;

    @AndroidFindBy(id = "btnSaveChanges")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Save\"`]")
    protected MobileElement saveTimezone;

    @AndroidFindBy(id = "tvDone")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Done\"`]")
    protected MobileElement doneBtn;

    @AndroidFindBy(id = "tvPositiveButton")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Delete\"`]")
    protected MobileElement confirmDeleteNotes;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"backIcon\"`]")
    @AndroidFindBy(id = "cancelBtn")
    protected MobileElement backBriefCasePage;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"No notes added yet. Start scribbling now\"`]")
    protected List<MobileElement> noNotesMessage;

    @AndroidFindBy(id = "tvPositiveButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Logout\"]")
    protected List<MobileElement> confirmLogout;

    @AndroidFindBy(id = "com.android.systemui:id/dismiss")
    protected MobileElement closePIP;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTabBar[`label == \"Tab Bar\"`]/XCUIElementTypeOther[1]")
    protected MobileElement clickReceptionTab;
}