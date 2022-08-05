package com.hubilo.utils.dataProvider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hubilo.pojo.ui.*;
import com.hubilo.utils.helper.file_locators;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @created: 2022-05-14-11:45 PM
 * @project: Hubilo_App_Automation under @package: @package: com.hubilo.utils.dataProvider
 * @author: Rehan
 **/


public class DataSupplierJSON {
    @DataProvider(name = "loginDataJson")
    public Iterator<LoginData> getLoginDataJson() throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        PayloadJson payloadJSON = objectMapper.readValue(new File(file_locators.json_dataset), PayloadJson.class);
        List<LoginData> list = payloadJSON.getLoginData();
        return list.iterator();
    }

    @DataProvider(name = "signUpDataJson")
    public Iterator<SignUpData> getSignUpJson() throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        PayloadJson payloadJSON = objectMapper.readValue(new File(file_locators.json_dataset), PayloadJson.class);
        List<SignUpData> list = payloadJSON.getSignUpData();
        return list.iterator();
    }

    @DataProvider(name = "bulkSignUp")
    public Iterator<BSignUp> getBulkSignup() throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        BulkData bulkData = objectMapper.readValue(new File(file_locators.bulkData), BulkData.class);
        List<BSignUp> list = bulkData.getBSignUp();
        return list.iterator();
    }

    @DataProvider(name = "bulkProfileOnboarding")
    public Iterator<BProfileOnboarding> getBProfileOnboarding() throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        BulkData bulkData = objectMapper.readValue(new File(file_locators.bulkData), BulkData.class);
        List<BProfileOnboarding> list = bulkData.getBProfileOnboarding();
        return list.iterator();
    }

    @DataProvider(name = "chatBulkMessage")
    public Iterator<BChatMessage> getBChatMessage() throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        BulkData bulkData = objectMapper.readValue(new File(file_locators.bulkData), BulkData.class);
        List<BChatMessage> list = bulkData.getChatMessages();
        return list.iterator();
    }


}

