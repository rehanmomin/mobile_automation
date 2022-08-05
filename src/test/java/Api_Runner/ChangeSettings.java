package Api_Runner;
import com.hubilo.utils.helper.DashboardAPISetter;
import com.hubilo.utils.helper.JsonReader;
import com.hubilo.utils.helper.Utility;
import com.hubilo.utils.helper.apit_testdata;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.hubilo.utils.helper.file_locators.room_testdata;
import static java.lang.String.valueOf;

public class ChangeSettings {

	DashboardAPISetter apicustomsettter;
	public void updateSetting()  {
		apicustomsettter.Setting();
	}

	public void updateUserRestrictionSetting(boolean emailrestrict)
	{

		try {
			if(emailrestrict) {
				DashboardAPISetter.settingLogin("$.data.is_restrict", "1");
			}else {
				DashboardAPISetter.settingLogin("$.data.is_restrict", "0");
			}
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	public void updateDefautOTP(String OTP)
	{
		try {
			DashboardAPISetter.settingLogin("$.data.default_custom_otp",OTP);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateOnboardSetting(boolean flag, String type)
	{
		System.out.println("updateOnboardSetting   =========");
		DashboardAPISetter.getGroups(type);
		String[] path= {"$.data.is_onboarding","$.data._id"};
		int val = flag? 1 : 0;
		String[] value= {valueOf(val),apit_testdata.groupid.get()};

		System.out.println("group id : "+ apit_testdata.groupid.get());

		if(flag)
			DashboardAPISetter.onboardingDisable(path,value);
		else
			DashboardAPISetter.onboardingDisable(path,value);
	}

	public void getListOfEvents() {
		DashboardAPISetter.getEvents();
	}
	public ChangeSettings createUser(String email,String name,String lastname,String type)
	{
		DashboardAPISetter.getGroups(type);
		String[] path= {"$.data.email","$.data.first_name","$.data.last_name","$.data.groups[0]"};
		String[] value= {email,name,lastname,apit_testdata.groupid.get()};
		apit_testdata.attendeename.set(email);
		DashboardAPISetter.createAttendee(path,value);
		return new ChangeSettings();
	}
	//	public ChangeSettings createSpeaker(String email,String name,String lastname) {
//		String[] path= {"$.data.email","$.data.first_name","$.data.last_name"};
//		String[] value= {email,name,lastname};
//		apit_testdata.speakername.set(email);
//		DashboardAPISetter.createSpeaker(path,value);
//		return new ChangeSettings();
//
//	}
	public ChangeSettings searchPeople(String email)
	{
		DashboardAPISetter.searchPeople(email);
		return new ChangeSettings();
	}
	public ChangeSettings searchSpeaker(String email)
	{
		DashboardAPISetter.searchSpeakerList(email);
		return new ChangeSettings();
	}
	public ChangeSettings deleteAttendee(String attendeenum) {
		String path="$.data.ids[0]";
		String value=attendeenum;;
		DashboardAPISetter.deleteAttendee(path,value);
		return  new ChangeSettings();

	}
	public void createBooth(String name,String desc,String categeory) {
		String[] path = {"$.data.name", "$.data.description","$.data.category"};
		String[] value = {name,desc,categeory};
		apit_testdata.boothname.set(name);
		DashboardAPISetter.createBooth(path, value);

	}

	public void getBoothList() {
		DashboardAPISetter.getBoothList();
	}
	public void updateEngagementBooth(String boothid,boolean islivechat,boolean isqna) {
		String[] path ={"$.data.exhibitor_id","$.data.live_chat", "$.data.QnA"};
		String[] value ={boothid, valueOf(islivechat), valueOf(isqna)};
		DashboardAPISetter.boothEngagementUpdate(path,value);
	}

	public void updateBoothCTA(String boothid,String description ) {
		String path = "$.data.cta_description";
		String value = description;
		apit_testdata.boothnumber.set(boothid);
		DashboardAPISetter.boothCTAUpdate(path,value);
	}

	public void deleteBooth(String boothid) {
		String path = "data.booth_ids[0]";
		String value = boothid;
		DashboardAPISetter.deleteBooth(path,value);

	}
	public ChangeSettings createAgenda(String title,int past,int future) {
		String[] path = {"$.data.title","$.data.start_time_milli","$.data.end_time_milli"};
		String[] value = {title,Utility.epochCreation(Utility.getPastORFutureTime("past",past)).toString(), Utility.epochCreation(Utility.getPastORFutureDates("future",future)).toString()};
		apit_testdata.agendaname.set(title);
		apit_testdata.agendastarttime.set(value[1]);
		apit_testdata.agendaendtime.set(value[2]);
		DashboardAPISetter.createAgenda(path, value);
		return new ChangeSettings();
	}

	public void deleteAgenda(String agendaid) {
		DashboardAPISetter.deleteAgenda(agendaid);
	}
	public ChangeSettings streamAgenda(String agendaid) {
		DashboardAPISetter.streamAgenda(agendaid);
		return new ChangeSettings();
	}
	public  ChangeSettings updateAgenda(String  name,int starttime,int endtime,boolean isfeature,String speakerid) {
		String[] path = {"data.name","data.start_time_milli","data.end_time_milli","data.is_featured","data.speakers[0]"};
		String a_starttime;
		String a_endtime;
		int val = isfeature? 1 : 0;
		if(name.contains("FUTURE"))
		{
			a_starttime = Utility.epochCreation(Utility.getPastORFutureDates("future", starttime)).toString();
			a_endtime = Utility.epochCreation(Utility.getPastORFutureDates("future", endtime)).toString();
		}
		else {

			a_starttime = Utility.epochCreation(Utility.getPastORFutureTime("past", starttime)).toString();
			a_endtime = Utility.epochCreation(Utility.getPastORFutureDates("future", endtime)).toString();
		}
		String[] value = {name,a_starttime,a_endtime, valueOf(val),speakerid};
		DashboardAPISetter.updateAgenda(path,value);
		return new ChangeSettings();

	}


	public void createLounge(String name,String boothid,String boothname) {
		String[] value;
		String[] path;
		if(boothid.equals(""))
		{
			path = new String[]{"$.data.name"};
			value = new String[]{name};
		}
		else {
			path = new String[]{"$.data.name", "$.data.exhibitors[0].id", "$.data.exhibitors[0].name"};
			value = new String[]{name, boothid, boothname};
		}
		apit_testdata.loungename.set(name);
		DashboardAPISetter.createLounge(path, value);
	}
	public void deleteLounge() {
		DashboardAPISetter.getLoungeList();
		DashboardAPISetter.deleteLounge();

	}
	public void updateLounge(String loungename,int past,int future) {
		String[] path = {"data.name","data.start_time_milli","data.end_time_milli"};
		String[] value = {loungename, Utility.epochCreation(Utility.getPastORFutureDates("past",past)).toString(), Utility.epochCreation(Utility.getPastORFutureDates("future",future)).toString()};
		apit_testdata.loungename.set(loungename);
		DashboardAPISetter.updateAgenda(path,value);
	}
	//multi,moderator,coded
	public  ChangeSettings createRoom(String roomname,String type,String email,String code) {
		if(type.equalsIgnoreCase("multi")) {
			String[] path = {"$.data.name", "$.data.roomType"};
			String[] value = {roomname, "MULTIPLE"};
			apit_testdata.roomname.set(value[0]);
			DashboardAPISetter.createRoom(path, value, "multi");
		} else if (type.equalsIgnoreCase("moderator"))
		{
			searchPeople(email);
			String[] path ={"$.data.name","$.data.roomType","$.data.shareAVPermission","$.data.avAcceptPermissionUsers[0]"};
			String[] value={roomname,"MULTIPLE","MODERATED",apit_testdata.search_peopleid.get()};
			apit_testdata.modroomname.set(value[0]);
			DashboardAPISetter.createRoom(path, value,"moderator");
		}
		else if (type.equalsIgnoreCase("coded")) {
			String[] path ={"$.data.name","$.data.roomType","$.data.roomCode"};
			String[] value={roomname,"MULTIPLE",code};
			apit_testdata.codedroomnumber.set(value[0]);
			DashboardAPISetter.createRoom(path, value,"coded");
		}

		return new ChangeSettings();
	}
	public void disableMatchmaking(String type,boolean flag) {
		System.out.println("disableMatchmaking=====");
		if(flag) {
			if (type.equalsIgnoreCase("Interest")) {
				String path = "$.data.is_interest";
				DashboardAPISetter.matchmaking(path, "0");
			} else if (type.equalsIgnoreCase("lookingfor")) {
				String path = "$.data.is_looking_for";
				DashboardAPISetter.matchmaking(path, "0");
			} else if (type.equalsIgnoreCase("industry")) {
				String path = "$.data.is_industry";
				DashboardAPISetter.matchmaking(path, "0");
			}
		}
		else
		{
			String path = "$.data.is_industry";
			DashboardAPISetter.matchmaking(path, "1");
		}

	}
	public void deleteRoom(String roomno) {
		String path = "data.roomId[0]";
		String value = roomno;
		DashboardAPISetter.deleteRoom(path,value);
	}
	public void scheduleMeeting(String participation1,String participation2,String time,String desc) {
		searchPeople(participation1);
		String[] path ={"$.data.participant1","$.data.participant2","$.data.meeting_time","$.data.meeting_description"};
		apit_testdata.mettingparticipation1.set(apit_testdata.search_peopleid.get());
		searchPeople(participation2);
		apit_testdata.mettingparticipation2.set(apit_testdata.search_peopleid.get());
		String[] value ={apit_testdata.mettingparticipation1.get(),apit_testdata.mettingparticipation2.get(),time,desc};
		apit_testdata.mettingdescription.set(desc);
		DashboardAPISetter.scheduleMeeting(path, value);
	}

	public ChangeSettings deleteMeeting(String mettingid)
	{
		String path ="data.meeting_ids[0]";
		String value=mettingid;apit_testdata.mettingid.get();
		DashboardAPISetter.deleteMeeting(path, value);
		return new ChangeSettings();

	}

	public ChangeSettings dashboardLogin()
	{
		apicustomsettter = new DashboardAPISetter();
		apicustomsettter.dashboardLogin();
		return new ChangeSettings();
	}

	public void createEvent(String a_starttime,String a_endtime,String eventname)//String email,String attendeename,String agendaname,String desc)
	{
		String[] path = {"data.name", "data.start_time_milli", "data.end_time_milli"};
		apit_testdata.eventname.set(eventname);
		String[] value = {eventname, a_starttime, a_endtime};
		DashboardAPISetter.createEvent(path, value);
		DashboardAPISetter.liveEvent();
	}
	public void updateBranding(boolean flag)
	{
		String[] path = {"data.domainSettings.v2_index_url", "data.isShowOnBoardingBanners"};
		String[] value={apit_testdata.eventname.get(),valueOf(flag)};
		DashboardAPISetter.updateBranding(path,value);
	}

@Test
	public void test() throws IOException//String email,String attendeename,String agendaname,String desc)
	{
		//Create a Attendee
//		createUser("jam1@hubilo.com","attendeename","Mobile Automation","speaker");
		//	searchPeople(email);
		//	deleteAttendee(apit_testdata.search_peopleid.get());
//		createSpeaker(email,attendeename,"Mobile Automation");
//		searchSpeaker(attendeename);
//		//Create multi rooms
//		createMultiRoom("Testing multi room");
//		//create moderator rooms
//		createModeratorRoom("Testing moderator room",apit_testdata.attendeenumber.get());
//		//	Schedule meeting between two users
//		scheduleMeeting("rehan@hubilo.com","sam@hubilo.com",Utility.epochCreation(Utility.getPastORFutureTime("future",3)).toString(),"Mobile automation testing");
//		//Create booth with description
//		createBooth("Mobile automation booth","Dash board api to create this booth");
		//Create ahenda with past feture and current date

		//Stream agenda
		//	streamAgenda(apit_testdata.agendanumber.get());
		//udpate agenda to make past present and feature
//		updateAgenda(apit_testdata.agendaname.get(),apit_testdata.agendastarttime.get(),apit_testdata.agendaendtime.get(),true,apit_testdata.search_peopleid.get());
		//update engament for the booth
//		updateEngagementBooth(apit_testdata.boothnumber.get(),true,true);
//		//create a CTA button for Booth
//		updateBoothCTA(apit_testdata.boothnumber.get(),"Booth CTA updated value");
//		//Create a lounge
////		createLounge("Hubilo m-automation lounge"+ generateRandomNumber(),apit_testdata.boothnumber.get(),apit_testdata.boothname.get());
//
//
//		deleteRoom(apit_testdata.roomnumber.get());
//		deleteRoom(apit_testdata.modroomnumber.get());
//		deleteMeeting(apit_testdata.mettingid.get());
//		deleteAttendee(apit_testdata.attendeenumber.get());
//		deleteLounge(apit_testdata.loungenumber.get());
//		deleteBooth(apit_testdata.boothnumber.get());
//		deleteAgenda(apit_testdata.agendanumber.get());
        dashboardLogin();
		DashboardAPISetter.test();


	}
	JsonPath jsonPath;
	public void test1()
	{
		jsonPath= JsonPath.from(Utility.getJsonString(room_testdata));
		jsonPath.prettyPrint();
	}
	public void deleteEvent()
	{
		DashboardAPISetter.deleteEvent();
	}

}