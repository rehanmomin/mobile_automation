package com.hubilo.pageobjects.locators;

import com.hubilo.base.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

/**
 * @created: 2022-05-17-1:58 AM
 * @project: Hubilo_App_Automation under @package: @package: com.hubilo.pageobjects.locators
 * @author: Rehan
 **/


public class AgendaLocator{


    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgMyMeetings")
    @iOSXCUITFindBy(id = "ic meet calendar")
    protected MobileElement meetingBtn;

    @AndroidFindBy(id = "fourthItemTitle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Tab Bar\"]/XCUIElementTypeOther[4]")
    protected MobileElement agendaTab;

    @AndroidFindBy(id = "tvMessage")
    protected List<MobileElement> surveyName;

    @AndroidFindBy(id = "startSurvey")
    protected List<MobileElement> surveyStart;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Show Live Agenda']")
    @iOSXCUITFindBy(id = "Show Live Agenda")
    protected List<MobileElement> showLiveAgenda;

    @AndroidFindBy(id = "tvSessionTitle")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeStaticText']")
    protected List<MobileElement> sessionList;

    @iOSXCUITFindBy(id = "No conversations yet.")
    protected MobileElement noConversationYetTextClick;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Live Chat\"]/android.widget.LinearLayout/android.widget.TextView")
    @iOSXCUITFindBy(id = "Live Chat")
    protected MobileElement liveChatEngagement;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Polls\"]/android.widget.LinearLayout/android.widget.TextView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Polls\"`]")
    protected MobileElement pollsEngagement;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"QnA\"]/android.widget.LinearLayout/android.widget.TextView")
    @iOSXCUITFindBy(id = "QnA")
    protected MobileElement q_and_qEngagement;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Attendees\"]/android.widget.LinearLayout/android.widget.TextView")
    @iOSXCUITFindBy(id = "Attendees")
    protected MobileElement attendeesEngagement;

    @AndroidFindBy(id = "imgNote")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ic note new\"`]")
    protected MobileElement notes;

    @AndroidFindBy(id = "edtTakeNote")
    @iOSXCUITFindBy(id = "Take a Note")
    protected MobileElement editNote;

    @AndroidFindBy(id = "txtDelete")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Delete\"`]")
    protected MobileElement deleteNote;

    @AndroidFindBy(id = "txtSubmit")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Save\"`]")
    protected MobileElement saveNote;

    @AndroidFindBy(id = "imgAdd")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"HubiloApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton[2]")
    protected MobileElement addToSchedule;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`value == \"1\"`]")
    protected MobileElement addToScheduleremove;

    @AndroidFindBy(xpath = "//*[@class='android.widget.RadioButton']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText")
    protected List<MobileElement>pagination;

    @iOSXCUITFindBy(id = "View Detail")
    protected List<MobileElement> sessionViewDetail;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Close\"]")
    protected MobileElement pipClose;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Expand\"]")
    protected MobileElement pipExpand;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/swtchLiveSession")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeSwitch")
    protected MobileElement toggle2LiveSession;

    @AndroidFindBy(id = "txtEmpty")
    protected MobileElement emptyLiveSession;

    @AndroidFindBy(id = "imgBack")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"backIcon\"`]")
    protected MobileElement backBtn;

    // search empty text and description
    @AndroidFindBy(id = "txtEmpty")
    protected MobileElement searchNoResultFoundText;

    @AndroidFindBy(id = "txtEmptyDesc")
    protected MobileElement searchNoResultFoundDescription;

    //Session main page
    @AndroidFindBy(xpath = "//*[@class='android.widget.RadioButton']")
    protected List<MobileElement> getListSessionDate;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All']")
    protected MobileElement allTab;

    @AndroidFindBy(id = "tvSessionTime")
    protected MobileElement getSessionTime;

    @AndroidFindBy(id = "tvSessionDate")
    protected MobileElement detailSessionDate;

    @AndroidFindBy(id = "tvSessionCount")
    protected MobileElement getSessionCount;

    @AndroidFindBy(id = "tvStartTimeEndTime")
    protected MobileElement detailSessionPage;
    @AndroidFindBy(id = "txtSessionLive")
    protected MobileElement sessionLiveText;

    @AndroidFindBy(id = "tvSessionSearchInput")
    protected MobileElement isResultFoundWithCount;

    @AndroidFindBy(id = "cancelBtn")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"backIcon\"`]")
    protected MobileElement sessionBack;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"backIcon\"`]")
    protected List<MobileElement> sessionBackList;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/fourthItemIcon")
    protected MobileElement fourth;
    @AndroidFindBy(id = "com.android.systemui:id/dismiss")
    protected MobileElement closePIP;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"HBS Session\"`][1]")
    protected List<MobileElement> clickHBSText;

    @AndroidFindBy(id = "tvSessionDescription")
    protected MobileElement sessionDescription;

    @AndroidFindBy(id = "tvSessionTimeStartEnd")
    protected MobileElement sessionTime;

    @AndroidFindBy(id = "txtSessionTimerHeading")
    protected MobileElement sessionStatus;

    @AndroidFindBy(id = "txtSessionTimer")
    protected MobileElement sessionStartsInTimer;

    @AndroidFindBy(id = "txtJoinSession")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Join Session\"]")
    protected MobileElement sessionJoin_Watch_View_DetailBtn;

    @AndroidFindBy(id = "imgNote")
    protected MobileElement noteBtn;

    @AndroidFindBy(id = "txtTitle")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Take Notes\"`]")
    protected MobileElement noteTitle;

    @AndroidFindBy(id = "imgSearch")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ic search\"`]")
    protected MobileElement searchBtn;

    @AndroidFindBy(id = "edtTxtSearch")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Search\"`]")
    protected MobileElement searchInputBox;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Youtube Session\"`]")
    protected List<MobileElement> youtubeSession;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete this Note?']")
    protected MobileElement confirmDeletePopUp;

    @AndroidFindBy(id = "tvNegativeButton")
    protected MobileElement cancelDelete;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"HBS SessionFUTURE\"`][1]")
    protected MobileElement clickSpeakerTextToEnableBack;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"HBS Session\"`][1]")
    protected MobileElement verifyHBSSessionName;

    @iOSXCUITFindBy(id = "Play")
    protected MobileElement playTab;

    @iOSXCUITFindBy(id = "backIcon")
    protected MobileElement backButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell[4]/XCUIElementTypeOther/XCUIElementTypeOther")
    protected MobileElement futureEvent;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Session will start in\"`]")
    protected List<MobileElement> futureEventList;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Session will start in\"`]")
    protected List<MobileElement> futureEventText;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeOther")
    protected MobileElement pastEvent;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Session Ended\"`]")
    protected List<MobileElement> pastEventText;

    @AndroidFindBy(id = "tvPositiveButton")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Delete\"`]")
    protected List<MobileElement> confirmDelete;

    @AndroidFindBy(id = "txtSessionDate")
    protected MobileElement afterJoinDate;

    @AndroidFindBy(id = "txtLiveSession")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Show Live Agenda\"`]")
    protected MobileElement showLiveAgendaText;

    @AndroidFindBy(id = "com.hubilo.v2.dev:id/imgMyMeetings")
    @iOSXCUITFindBy(id = "ic meet calendar")
    protected MobileElement myMeetings;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Agenda']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Agenda\"`]")
    protected MobileElement meetingAgendaTab;


    @AndroidFindBy(id = "backBtn")
//    @AndroidFindBy(id = "com.hubilo.v2.dev:id/backBtn")
//>>>>>>> 56922513d8dcc77004990f065bafa31bf9834b27
    protected MobileElement backFromJoined;



}