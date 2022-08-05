package UI_Runner;

import Api_Runner.ChangeSettings;
import com.hubilo.base.BaseTest;
import com.hubilo.utils.helper.Utility;
import com.hubilo.utils.helper.apit_testdata;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static com.hubilo.utils.helper.file_locators.room_testdata;

/**
 * @created: 2022-06-20-12:37 AM
 * @project: Mobile_UI_Automation under @package: @package: UI_Runner
 * @author: Rehan
 **/

@Feature("Room Functionality")
public class RoomExecution extends BaseTest {
    private ChangeSettings changeSettings;

    @Story("Room Functionality")
    @Description("Dashboard configuration for Rooms")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, groups = {"Smoke", "Regression"}, enabled = true)
    public void roomInit() {
        changeSettings = new ChangeSettings();
        jsonPath= JsonPath.from(Utility.getJsonString(room_testdata));

        changeSettings.dashboardLogin()
                .createRoom(jsonPath.getString("room.ANYONE_ROOM"),jsonPath.getString("room.ANYONE2ANYONE"),
                        jsonPath.getString("room.MOD_EMAIL"),jsonPath.getString("room.ROOM_CODE"))
                .createRoom(jsonPath.getString("room.CODED_ROOM"),jsonPath.getString("room.CODED"),
                        jsonPath.getString("room.MOD_EMAIL"),jsonPath.getString("room.ROOM_CODE"))
                .createRoom(jsonPath.getString("room.MOD_ROOM"),jsonPath.getString("room.MODERATED"),
                        jsonPath.getString("room.MOD_EMAIL"),jsonPath.getString("room.ROOM_CODE"));
        rooms = basePageThread.get().getRoomsInstance();
        lifecycle.updateTestCase(testResult -> testResult.setName("Rooms Configuration - creation of multiple room from dashboard"));
    }

    @Story("Room Functionality")
    @Description("Verify anyone to anyone room")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, groups = {"Smoke", "Regression"}, dependsOnMethods = "roomInit", enabled = true)
    public void verifyAnyone2AnyoneRoom() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify anyone to anyone room"));
        rooms.verifyRoom("anyone to anyone room", "My Room", jsonPath.getString("room.USER_NAME"));
    }

    @Story("Room Functionality")
    @Description("verify search room")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 3, groups = {"Smoke", "Regression"}, dependsOnMethods = "roomInit", enabled = true)
    public void verifySearchRoom() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify search room"));
        rooms.verifyRoom("search room", "My Room", jsonPath.getString("room.USER_NAME"));

    }

    @Story("Room Functionality")
    @Description("verify sorting A to Z room")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 4, groups = {"Smoke", "Regression"}, dependsOnMethods = "roomInit", enabled = true)
    public void verifySortingAToZ() {
        lifecycle.updateTestCase(testResult -> testResult.setName("sorting A to Z room"));
        rooms.verifyRoom("sorting A to Z room", "My Room", jsonPath.getString("room.USER_NAME"));
    }

    @Story("Room Functionality")
    @Description("verify coded room")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 5, groups = {"Smoke", "Regression"}, dependsOnMethods = "roomInit", enabled = true)
    public void verifyCodedRoom() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify coded room"));
        rooms.verifyRoom("coded room", "Coded Room", jsonPath.getString("room.USER_NAME"));
    }

    @Story("Room Functionality")
    @Description("verify moderated room")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 6, groups = {"Smoke", "Regression"}, dependsOnMethods = "roomInit", enabled = true)
    public void verifyModeratedRoom() {
        lifecycle.updateTestCase(testResult -> testResult.setName("verify moderated room"));
        rooms.verifyRoom("moderated room", "Room Moderated", jsonPath.getString("room.MOD_USER"));
        changeSettings.deleteRoom(apit_testdata.roomnumber.get());
        changeSettings.deleteRoom(apit_testdata.modroomnumber.get());
        changeSettings.deleteRoom(apit_testdata.codedroomnumber.get());
    }

    @Story("Room Functionality")
    @Description("delete all created rooms")
    @Severity(SeverityLevel.BLOCKER)
    @AfterClass
    public void deleteCreatedRooms() {
        lifecycle.updateTestCase(testResult -> testResult.setName("delete all created rooms"));
        changeSettings.deleteRoom(apit_testdata.roomnumber.get());
        changeSettings.deleteRoom(apit_testdata.modroomnumber.get());
        changeSettings.deleteRoom(apit_testdata.codedroomnumber.get());
    }


}
