package com.hubilo.utils.helper;
import io.restassured.path.json.JsonPath;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader
{
    static JsonPath jsonPath;
    public  String getAndroidDesiredCap(String key)
    {
        String value="";
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(file_locators.desiredCapability))
        {
            Object obj = jsonParser.parse(reader);
            jsonPath= JsonPath.from(obj.toString());
            value =jsonPath.getString("ANDROID."+key);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return value;
    }
    public  String getIosDesiredCap(String key)
    {
        String value="";
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(file_locators.desiredCapability))
        {
            Object obj = jsonParser.parse(reader);
            jsonPath= JsonPath.from(obj.toString());
            value =jsonPath.getString("IOS."+key);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return value;
    }
    public static  String getUrls(String env,String key)
    {
        String value="";
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(file_locators.baseurljsonpath))
        {
            Object obj = jsonParser.parse(reader);
            jsonPath= JsonPath.from(obj.toString());
            value =jsonPath.getString(env+"."+key);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return value;
    }
    public static  String getEndpoints(String key)
    {
        String value="";
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(file_locators.endpointurljsonpath))
        {
            Object obj = jsonParser.parse(reader);
            jsonPath= JsonPath.from(obj.toString());
            value =jsonPath.getString("endpoint."+key);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return value;
    }
    public static  String getLoginData(String key)
    {
        String value="";
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(file_locators.logindata))
        {
            Object obj = jsonParser.parse(reader);
            jsonPath= JsonPath.from(obj.toString());
            value =jsonPath.getString("LoginData."+key.trim());
            System.out.println(value);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return value;
    }
    public static  String getSettingApiTestData(String key)
    {
        String value="";
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(file_locators.settings))
        {
            Object obj = jsonParser.parse(reader);
            jsonPath= JsonPath.from(obj.toString());
            value =jsonPath.getString("Settings."+key);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return value;
    }
    public static  String getReportFilePAth(String key)
    {
        String value="";
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(file_locators.desiredCapability))
        {
            Object obj = jsonParser.parse(reader);
            jsonPath= JsonPath.from(obj.toString());
            value =jsonPath.getString("Report."+key);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return value;
    }

    public static  String getComminityLogin(String key)
    {
        String value="";
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(file_locators.json_dataset))
        {
            Object obj = jsonParser.parse(reader);
            jsonPath= JsonPath.from(obj.toString());
            value =jsonPath.getString("signUpData[0]."+key);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return value;
    }
}