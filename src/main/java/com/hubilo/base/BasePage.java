package com.hubilo.base;

import com.hubilo.pageobjects.functions.*;
import com.hubilo.utils.helper.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.restassured.path.json.JsonPath;

public class BasePage {

    AppiumDriver<MobileElement> driver;
    public BasePage(AppiumDriver driver){
        this.driver = driver;
    }

    public MultiEvent getMultiEventInstance() {return new MultiEvent(this.driver);}
    public LoginPage getLoginPageInstance(){ return new LoginPage(this.driver);}
    public Reception getReceptionPageInstance(){return new Reception(this.driver);}
    public Profile getUserProfileInstance(){return new Profile(this.driver);}
    public Onboarding getOnboardingInstance() {return new Onboarding(this.driver);}
    public Booth getBoothInstance(){ return new Booth(this.driver);}
    public EventFeed getFeedEventInstance(){ return new EventFeed(this.driver);}
    public Lounge getLoungeInstance(){ return new Lounge(this.driver);}
    public People getPeopleInstance(){ return new People(this.driver);}
    public Rooms getRoomsInstance(){ return new Rooms(this.driver);}
    public Meeting getMeetingInstance() {return new Meeting(this.driver);}
    public Agenda getAgendaInstance() {return new Agenda(this.driver);}
    public SignUp getSignUpInstance() {return new SignUp(this.driver);}
    public Leaderboard getLeaderboardInstance() { return new Leaderboard(this.driver);}
    public One2OneChat getOne2OneChatInstance() { return new One2OneChat(this.driver);}


    public JsonPath getJsonTestData(String filepath) {
        JsonPath jsonPath = JsonPath.from(Utility.getJsonString(filepath));
        return jsonPath;

    }


}