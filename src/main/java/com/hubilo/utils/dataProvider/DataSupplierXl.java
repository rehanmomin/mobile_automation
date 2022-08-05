package com.hubilo.utils.dataProvider;
import com.hubilo.utils.helper.file_locators;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.io.IOException;


public class DataSupplierXl {
    public enum edata { EVENT_TYPE, EVENT_NAME, EMAIL,PASSWORD, IS_OTP,OTP,NEW_PASSWORD,CONFIRM_PASSWORD};
    @DataProvider(name = "loginData")
    public Object[] getLoginData() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(file_locators.json_dataset);
        Object obj = (jsonParser).parse(reader);
        JSONObject eventdetails = (JSONObject) obj;
        JSONArray eventdetailsArray = (JSONArray) eventdetails.get("Data");
        String data[] = new String[eventdetailsArray.size()];
        for (int i = 0; i < eventdetailsArray.size(); i++) {
            JSONObject events = (JSONObject) eventdetailsArray.get(i);
            String eventType = (String) events.get(edata.EVENT_TYPE);
            String eventName = (String) events.get(edata.EVENT_NAME);
            String emailId = (String) events.get(edata.EMAIL);
            String password = (String) events.get(edata.PASSWORD);
            String isOTP = (String) events.get(edata.IS_OTP);
            String otp = (String) events.get(edata.OTP);
            String newPassword = (String) events.get(edata.NEW_PASSWORD);
            String confirmNewPassword = (String) events.get(edata.CONFIRM_PASSWORD);
            //String comments = (String) events.get("comments");
            data[i] = eventType + "," + eventName+"," + emailId + "," + password +","+ isOTP + "," + otp +","+ newPassword + "," + confirmNewPassword ;
        }
        return data;
    }


}
