package com.hubilo.utils.helper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;
import com.hubilo.pojo.api.dashboard.DashboardLogin_Data;
import com.hubilo.pojo.api.dashboard.DashboardLogin_Login;
import com.hubilo.pojo.api.setting.SettingGeneral;
import com.hubilo.pojo.api.setting.SettingGeneral_Data;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static com.hubilo.utils.helper.file_locators.*;
import static io.restassured.RestAssured.given;
import static java.lang.Integer.parseInt;

public class DashboardAPISetter {
	public static String getEnv()
	{
		return "release";	//apit_testdata.env.get();
	}

	public String dashboardLogin()
	{
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Content-Type"));
		DashboardLogin_Data dashboardLogin_Data=new DashboardLogin_Data();
		DashboardLogin_Login dashboardLogin_Login=new DashboardLogin_Login();
		dashboardLogin_Data.setEmail(JsonReader.getLoginData("username"));
		dashboardLogin_Data.setPassword(JsonReader.getLoginData("password"));
		dashboardLogin_Data.setCaptchaToken("");
		dashboardLogin_Login.setData(dashboardLogin_Data);
		ObjectMapper objectMapper = new ObjectMapper();
		String nestedJsonPayload = null;
		try {
			nestedJsonPayload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dashboardLogin_Login);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		JsonPath jsonPath =Utility.getApiResponse(request,"post",nestedJsonPayload,"dashboard_login_url");
		String accesstoken=jsonPath.getString("data.token");
		Logger.info("Bearer "+jsonPath.getString("data.token"));
		apit_testdata.token.set(accesstoken);
		return accesstoken;

	}
	public String communityLogin(String[] path,String[] value)
	{
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"v2release");
		RequestSpecification request = given();
		Map<String,String> requestHeaders = new HashMap<>();
		requestHeaders.put("Content-Type","application/json");
		requestHeaders.put("authorization",apit_testdata.accesstoken.get());
		request.headers(requestHeaders);
		String jsonpayload = Utility.updateMultiplePath("src/main/resources/jsonFiles/apirequestjson/login/commuity_login.json",path,value);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonpayload);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		request.body(jsonpayload);
		Response response = request.post(JsonReader.getEndpoints("community_login_url"));
		ResponseBody body = response.getBody();
		JsonPath jsonPath = JsonPath.from(body.asPrettyString());
		Logger.info(jsonPath.getString("$"));
		Logger.info(jsonPath.getString("status"));
		body.asPrettyString();
		apit_testdata.communitytoken.set(jsonPath.getString("success.data.accessToken"));
		Logger.info(apit_testdata.communitytoken.get());
		return apit_testdata.communitytoken.get();

	}
	public static void  Setting()
	{
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"community");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,eventId,organiserId,Content-Type,buildversion"));
		SettingGeneral_Data settingGeneral_Data=new SettingGeneral_Data();
		SettingGeneral settinggeneral=new SettingGeneral();
		settingGeneral_Data.setIsChatEnabled(JsonReader.getSettingApiTestData("ChatEnabled"));
		settingGeneral_Data.setIsMeetingEnabled(JsonReader.getSettingApiTestData("MeetingEnabled"));
		settingGeneral_Data.setIsNotificationEnabled(JsonReader.getSettingApiTestData("NotificationEnabled"));
		settingGeneral_Data.setShowEventDate(JsonReader.getSettingApiTestData("ShowEventDate"));
		settingGeneral_Data.setIsOtpMailSupported(JsonReader.getSettingApiTestData("MailSupported"));
		settingGeneral_Data.setIsHiddenInMultiEventApp(JsonReader.getSettingApiTestData("HiddenInMultiEventApp"));
		settinggeneral.setData(settingGeneral_Data);
		request.body(settinggeneral);
		ObjectMapper objectMapper = new ObjectMapper();
		String nestedJsonPayload = null;
		try {
			nestedJsonPayload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(settinggeneral);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		Utility.getApiResponse(request,"post",nestedJsonPayload,"generalsetting_url");

	}
	public static void settingLogin(String path,String value) throws JsonProcessingException {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,eventId,organiserId,buildversion,Content-Type"));
		String jsonpayload = Utility.changeJsonFile("src/main/resources/jsonFiles/apirequestjson/settings/loginsetting.json",path,value);
		Utility.getApiResponse(request,"put",jsonpayload,"loginsetting_url");
	}

	public static  void onboardingDisable(String[] path, String[] value) {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type,groupId"));
		String jsonpayload = Utility.updateMultiplePath(attendeegroupupdate,path,value);
		System.out.println("onboardingDisable: "+value[1]);
		Utility.getApiResponse(request,"post",jsonpayload,"groups");
	}
	public static void matchmaking(String path,String value) {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type"));
		String jsonpayload = Utility.changeJsonFile(matchmaking,path,value);
		Utility.getApiResponse(request,"put",jsonpayload,"matchmaking");
	}

	public static void getEvents()  {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard")+JsonReader.getEndpoints("events");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,organiserId,Content-Type"));
		Utility.getApiResponse(request,"get","","");
	}
	public static String getGroups(String type) {
		String data="";
		try {
			RestAssured.baseURI = JsonReader.getUrls(getEnv(), "dashboard");
			RequestSpecification request = given();
			request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,organiserId,Content-Type,eventId"));
			JsonPath jsonPath = Utility.getApiResponse(request, "get", "", "groups");
			data = jsonPath.get("data.groupsList.find{it.type=='"+type.toUpperCase()+"'}._id");
			Logger.info("receiver_member_group_id:" + data);
			apit_testdata.groupid.set(data);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	public static  void createAttendee(String[] path,String[] value) {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type"));
		String jsonpayload = Utility.updateMultiplePath(add_attendee,path,value);
		JsonPath jsonPath=Utility.getApiResponse(request,"post",jsonpayload,"createattendee");
		String data=jsonPath.getString("data");
		jsonPath=jsonPath.from(data);
		apit_testdata.attendeenumber.set(jsonPath.getString("userId['$oid']"));
		Logger.info("Attendee number : "+apit_testdata.attendeenumber.get());
	}

	//	public static void createSpeaker(String[] path,String[] value) {
//		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
//		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
//		RequestSpecification request = RestAssured.given();
//		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type"));
//		String jsonpayload = Utility.updateMultiplePath(add_speaker,path,value);
//		JsonPath jsonPath=Utility.getApiResponse(request,"post",jsonpayload,"createattendee");
//		String data=jsonPath.getString("data");
//		jsonPath=jsonPath.from(data);
//		apit_testdata.speakernumber.set(jsonPath.getString("userId['$oid']"));
//		Logger.info("Attendee number : "+apit_testdata.speakernumber.get());
//	}
	public static void searchSpeakerList(String email) {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		apit_testdata.search.set(email);
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type,search"));
		Utility.getApiResponse(request,"get","","speakerlist");
	}


	public static void searchPeople(String email) {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"community");
		RequestSpecification request = given();
		apit_testdata.search.set(email);
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type,search"));
		String jsonpayload = Utility.getJsonString(searchpeople);
		JsonPath jsonPath=Utility.getApiResponse(request,"post",jsonpayload,"peoplelist");
		apit_testdata.search_peopleid.set(jsonPath.getString("data[0].userId"));
		Logger.info("Searched people id  : "+apit_testdata.search_peopleid.get());
	}
	public static void deleteAttendee(String path, String value) {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type"));
		String jsonpayload = Utility.changeJsonFile(delete_attendee,path,value);
		Utility.getApiResponse(request,"post",jsonpayload,"deleteattendee");

	}
	public static void createBooth(String[] path,String[] value){
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type"));
		String jsonpayload = Utility.updateMultiplePath(createbooth,path,value);
		JsonPath jsonPath=Utility.getApiResponse(request,"post",jsonpayload,"createbooth");
		apit_testdata.boothnumber.set(jsonPath.getString("data.ids.exhibitor_id"));
		Logger.info("booth number : "+apit_testdata.boothnumber.get());
		Logger.info("booth name : "+apit_testdata.boothname.get());
	}
	public static void boothEngagementUpdate(String[] path,String[] value) {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"community");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type"));
		String jsonpayload = Utility.updateMultiplePath(engagementupdate,path,value);
		Utility.getApiResponse(request,"post",jsonpayload,"boothengagement");
	}
	public static void boothCTAUpdate(String path,String value) {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type,boothid"));
		String jsonpayload = Utility.changeJsonFile(cta,path,value);
		Utility.getApiResponse(request,"put",jsonpayload,"cta");
	}
	public static void getBoothList(){
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type,page,limit"));
		String jsonpayload = Utility.getJsonString(boothlist);
		request.body(jsonpayload);
		Response response = request.post(JsonReader.getEndpoints("boothlist"));
		ResponseBody body = response.getBody();
		JsonPath jsonPath = JsonPath.from(body.asPrettyString());
		String Status=jsonPath.getString("status");
		Assert.assertTrue(Status.equals("200"));
		if(parseInt(jsonPath.getString("total_count"))>0) {
			apit_testdata.booths.addAll(response.path("data.exhibitor_id"));
			apit_testdata.boothsnames.addAll(response.path("data.name"));
			apit_testdata.booths.forEach(System.out::println);
			apit_testdata.boothsnames.forEach(System.out::println);
		}
	}
	public static void deleteBooth(String path,String value){
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type"));
		String jsonpayload = Utility.changeJsonFile(boothdelete,path,value);
		Utility.getApiResponse(request,"post",jsonpayload,"deletebooth");
	}

	public static void createAgenda(String[] path,String[] value)  {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type"));
		String jsonpayload = Utility.updateMultiplePath(createagenda,path,value);
		JsonPath jsonPath=Utility.getApiResponse(request,"post",jsonpayload,"createagenda");
		apit_testdata.agenda_numbers.add(jsonPath.getString("data.ids.agenda_id"));
		apit_testdata.agendanumber.set(jsonPath.getString("data.ids.agenda_id"));
		apit_testdata.hbsagendanumber.set(jsonPath.getString("data.ids.agenda_id"));
		Logger.info("Agenda number : "+apit_testdata.agendanumber.get());
		Logger.info("Agenda name : "+apit_testdata.agendaname.get());
	}
	public static void deleteAgenda(String agendaid)
	{
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(), "dashboard");
		RequestSpecification request = given();
		apit_testdata.agendanumber.set(agendaid);
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type,agendaid"));
		Utility.getApiResponse(request,"post","","deleteagenda");
	}
	public static  void streamAgenda(String agendaid)
	{
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(), "dashboard");
		RequestSpecification request = given();
		apit_testdata.agendanumber.set(agendaid);
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type,agendaid"));
		String jsonpayload = Utility.getJsonString(streamagenda);
		Utility.getApiResponse(request,"post",jsonpayload,"stream");
	}
	public static void updateAgenda(String[] path,String[] value) {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type,agendaid"));
		String jsonpayload = Utility.updateMultiplePath(updateagenda,path,value);
		Utility.getApiResponse(request,"put",jsonpayload,"updateagenda");
	}
	public static  void createLounge(String[] path,String[] value){
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type"));
		String jsonpayload = Utility.updateMultiplePath(createlounge,path,value);
		JsonPath jsonPath=Utility.getApiResponse(request,"post",jsonpayload,"createlounge");
		apit_testdata.loungenumber.set(jsonPath.getString("$.data[0]._id"));
	}
	public static void getLoungeList() {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"community");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type,limit,page"));
		JsonPath jsonPath=Utility.getApiResponse(request,"get","","listLounge");
		Logger.info(apit_testdata.loungename.get());
		apit_testdata.loungenumber.set(Utility.getLoungeID(jsonPath,apit_testdata.loungename.get()));

	}
	public static void deleteLounge() {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(), "dashboard");
		RequestSpecification request = given();
	//	apit_testdata.loungenumber.set();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type,tableid"));
		Utility.getApiResponse(request,"post","","deletelounge");
	}
	public void updateLounge(String[] path,String[] value) {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type,tableid"));
		String jsonpayload = Utility.updateMultiplePath(updatelounge,path,value);
		Utility.getApiResponse(request,"put",jsonpayload,"updatelounge");
	}
	public static void createRoom(String[] path,String[] value,String type)  {

		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"community");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type"));
		String jsonpayload;
		if(type.equalsIgnoreCase("multi")) {
			jsonpayload = Utility.updateMultiplePath(multiroom, path, value);
			apit_testdata.roomname.set(path[0]);
			JsonPath jsonPath=Utility.getApiResponse(request,"post",jsonpayload,"createroom");
			apit_testdata.roomnumber.set(jsonPath.getString("roomId"));
			Logger.info("room number : "+apit_testdata.roomnumber.get());
			Logger.info("room name : ");
		}
		else if(type.equalsIgnoreCase("moderator")) {
			jsonpayload = Utility.updateMultiplePath(moderatorroom, path, value);
			apit_testdata.roomname.set(path[0]);
			JsonPath jsonPath = Utility.getApiResponse(request, "post", jsonpayload, "createroom");
			apit_testdata.modroomnumber.set(jsonPath.getString("roomId"));
			Logger.info("room number : " + apit_testdata.modroomnumber.get());
			Logger.info("room name : " + apit_testdata.modroomnumber.get());

		}
		else if(type.equalsIgnoreCase("coded")) {
			jsonpayload = Utility.updateMultiplePath(codedroom, path, value);
			apit_testdata.roomname.set(path[0]);
			JsonPath jsonPath = Utility.getApiResponse(request, "post", jsonpayload, "createroom");
			apit_testdata.codedroomnumber.set(jsonPath.getString("roomId"));
			Logger.info("room number : " + apit_testdata.codedroomnumber.get());
			Logger.info("room name : " + apit_testdata.codedroomname.get());
		}

	}
	public void getRoomList(String path,String value)  {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"community");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type,limit,page"));
		String jsonpayload = Utility.changeJsonFile(list_room,path,value);
		Utility.getApiResponse(request,"put",jsonpayload,"listroom");

	}
	public static void deleteRoom(String path,String value)  {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"community");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type"));
		String jsonpayload = Utility.changeJsonFile(delete_room,path,value);
		Utility.getApiResponse(request,"post",jsonpayload,"deleteroom");

	}
	public static void scheduleMeeting(String[] path,String[] value)  {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type"));
		String jsonpayload = Utility.updateMultiplePath(createmeeting,path,value);
		JsonPath jsonPath=Utility.getApiResponse(request,"post",jsonpayload,"schedulemeeting");
		apit_testdata.mettingid.set(jsonPath.getString("data.meeting_id"));
		Logger.info("meeting desc : "+apit_testdata.mettingdescription.get());
		Logger.info("meeting  number : "+apit_testdata.mettingid.get());

	}
	public static void deleteMeeting(String path,String value)  {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type"));
		String jsonpayload = Utility.changeJsonFile(deletemeeting,path,value);
		Utility.getApiResponse(request,"post",jsonpayload,"deletemeeting");
	}
	public static void createEvent(String[] path,String[] value)
	{
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,organiserId,Content-Type"));
		String jsonpayload = Utility.updateMultiplePath(create_event,path,value);
		JsonPath jsonPath=Utility.getApiResponse(request,"post",jsonpayload,"createevent");
		apit_testdata.eventid.set(jsonPath.getString("data.event_id"));
		Logger.info("Event id : "+apit_testdata.eventid.get());
		String[] path1={"Settings.EventId","Settings.EventName"};
		String[] value1={apit_testdata.eventid.get(),apit_testdata.eventname.get()};
		Utility.updateMultiplePath(file_locators.settings,path1,value1);

	}
	public static void deleteEvent()
	{
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type"));

		Utility.getApiResponse(request,"post","","deleteevent");

	}
	public static void liveEvent()
	{
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"community");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type"));
		String jsonpayload = Utility.getJsonString(live_event);;
		Utility.getApiResponse(request,"post",jsonpayload,"liveevent");
	}
	public static void updateBranding(String[] path,String[] value){
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"community");
		RequestSpecification request = given();
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-Type"));
		String jsonpayload = Utility.updateMultiplePath(brand_event,path,value);
		JsonPath jsonPath=Utility.getApiResponse(request,"post",jsonpayload,"brandeventsettting");

	}
	public static void uploadBannerImage() throws IOException {
		Response response=null;
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.baseURI = JsonReader.getUrls(getEnv(),"dashboard");
		RequestSpecification request = given();
		request.formParam("type","base");
		request.formParam("location","community_banner");
		Path fileName = Path.of("C:/Users/ASUS/IdeaProjects/Mobile_UI_Automation/Images/imagebase64.txt");
		String str = Files.readString(fileName);
		request.multiPart("data",str);
		request.headers(Utility.apiHeaderBuilder("Authorization,buildversion,eventId,organiserId,Content-length"));
		request.headers("Content-Type","multipart/form-data; boundary=----WebKitFormBoundary0yrOerLkhO4Z6AbW");
		response = request.post(JsonReader.getEndpoints("eventbannerupload"));
		response.asPrettyString();

	}
	public static void test() throws IOException {

		byte[] fileContent = FileUtils.readFileToByteArray(new File("C:\\Users\\ASUS\\IdeaProjects\\Mobile_UI_Automation\\.idea\\base64files\\community.txt"));
		String encodedString = Base64.getEncoder().encodeToString(fileContent);


		System.out.println(encodedString);
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Authorization", "Bearer " + apit_testdata.token.get());
		requestHeaders.put("buildversion", "565");
		requestHeaders.put("eventId", JsonReader.getSettingApiTestData("EventId"));
		requestHeaders.put("organiserId", JsonReader.getSettingApiTestData("OrganiserId"));
		requestHeaders.put("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundaryJRlEVlQcOrav3qte");
		requestHeaders.put("Content-length","435959");
		given().headers(requestHeaders)
				.multiPart("type", "base")
				.multiPart("location", "community_banner")
				.multiPart("data", encodedString)
				.when()
				.post("https://newdashboard.v2release.demohubilo.com/backend/api/v2/events/uploads")
				.then()
				.statusCode(200);
	}
}