package com.hubilo.utils.helper;
public interface file_locators {
    String projectPath = System.getProperty("user.dir");
    String screenshotPath = projectPath+"/Screenshot/";
    String xldata = projectPath+"/src/main/resources/dataSource/data.xlsx";
    String desiredCapability= projectPath+"/src/main/resources/jsonFiles/configdata/Appium_Config.json";
    String logindata =projectPath+"/src/main/resources/jsonFiles/testdata/logindata.json";

    String settings= projectPath+"/src/main/resources/jsonFiles/testdata/settings.json";
    String json_dataset=projectPath+"/src/main/resources/jsonFiles/testdata/dataset.json";

    String bulkData = projectPath+"/src/main/resources/jsonFiles/testdata/bulkdata.json";
    String endpointurljsonpath=projectPath+"/src/main/resources/jsonFiles/urls/endpoint.json";
    String baseurljsonpath=projectPath+"/src/main/resources/jsonFiles/urls/baseurl.json";



    //DASHBOARD API FILE LOCATORS
    String event_list=projectPath+"/src/main/resources/jsonFiles/eventlist/events.json";

    String create_event=projectPath+"/src/main/resources/jsonFiles/apirequestjson/event/create_event.json";
    String live_event= projectPath+"/src/main/resources/jsonFiles/apirequestjson//event/live_event.json";

    String brand_event= projectPath+"/src/main/resources/jsonFiles/apirequestjson//event/brandevent.json";
    String room_testdata=projectPath+"/src/main/resources/jsonFiles/testdata/room_testdata.json";

    String agenda_testdata=projectPath+"/src/main/resources/jsonFiles/testdata/agenda_testdata.json";
    String lounge_testdata=projectPath+"/src/main/resources/jsonFiles/testdata/lounge_testdata.json";

    String booth_testdata=projectPath+"/src/main/resources/jsonFiles/testdata/booth_testdata.json";

    String multiroom=projectPath+"/src/main/resources/jsonFiles/apirequestjson/rooms/add_room.json";
    String moderatorroom=projectPath+"/src/main/resources/jsonFiles/apirequestjson/rooms/add_moderator_room.json";

    String codedroom=projectPath+"/src/main/resources/jsonFiles/apirequestjson/rooms/coded_room.json";


    String attendeegroupupdate=projectPath+"/src/main/resources/jsonFiles/apirequestjson/onboarding/attendeegroupupdate.json";

    String matchmaking=projectPath+"/src/main/resources/jsonFiles/apirequestjson/settings/matchmaking.json";
    String add_attendee=projectPath+"/src/main/resources/jsonFiles/apirequestjson/people/add_attendee.json";
    String add_speaker=projectPath+"/src/main/resources/jsonFiles/apirequestjson/people/add_speaker.json";

    String searchpeople= projectPath+"/src/main/resources/jsonFiles/apirequestjson/people/searchpeople.json";
    String delete_attendee= projectPath+"/src/main/resources/jsonFiles/apirequestjson/people/delete_attendee.json";


    String createbooth= projectPath+"/src/main/resources/jsonFiles/apirequestjson/booth/createbooth.json";

    String engagementupdate= projectPath+"/src/main/resources/jsonFiles/apirequestjson/booth/engagementupdate.json";

    String cta= projectPath+"/src/main/resources/jsonFiles/apirequestjson/booth/cta.json";

    String boothlist= projectPath+"/src/main/resources/jsonFiles/apirequestjson/booth/boothlist.json";
    String boothdelete= projectPath+"/src/main/resources/jsonFiles/apirequestjson/booth/delete.json";
    String createagenda= projectPath+"/src/main/resources/jsonFiles/apirequestjson/agenda/createagenda.json";
    String streamagenda= projectPath+"/src/main/resources/jsonFiles/apirequestjson/agenda/stream.json";

    String updateagenda= projectPath+"/src/main/resources/jsonFiles/apirequestjson/agenda/updateagenda.json";
    String createlounge= projectPath+"/src/main/resources/jsonFiles/apirequestjson/lounge/createlounge.json";
    String updatelounge= projectPath+"/src/main/resources/jsonFiles/apirequestjson/lounge/updatelounge.json";
    String list_room= projectPath+"/src/main/resources/jsonFiles/apirequestjson/rooms/list_room.json";
    String delete_room= projectPath+"/src/main/resources/jsonFiles/apirequestjson/rooms/delete_room.json";

    String createmeeting= projectPath+"/src/main/resources/jsonFiles/apirequestjson/meeting/createmeeting.json";
    String deletemeeting= projectPath+"/src/main/resources/jsonFiles/apirequestjson/meeting/deletemeeting.json";




}
