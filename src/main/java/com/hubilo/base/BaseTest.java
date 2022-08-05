package com.hubilo.base;

import com.hubilo.pageobjects.functions.*;
import com.hubilo.utils.appium_engine.AndroidDriverInit;
import com.hubilo.utils.appium_engine.IOSDriverInit;
import com.hubilo.utils.helper.apit_testdata;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;

public abstract class BaseTest {

    protected AppiumDriver driver;
    protected String environment;
    protected AllureLifecycle lifecycle = Allure.getLifecycle();
    protected BasePage basePage;
    protected Agenda agenda;
    protected String eventName;
    protected Rooms rooms;
    protected Onboarding onboarding;
    protected SignUp signUp;
    protected Profile profile;
    protected JsonPath jsonPath;
    protected LoginPage loginPage;
    protected Lounge lounge;
    protected Booth booth;
    protected Meeting meeting;
    protected Reception reception;
    protected EventFeed eventFeed;
    protected One2OneChat one2OneChat;
    protected Leaderboard leaderBoard;
    protected ThreadLocal<BasePage> basePageThread = new ThreadLocal<>();

    @BeforeClass
    @Parameters({"env","platform"})
    public void init(String env, String platform) {
        environment = env;
        try{
            driver = platform.equalsIgnoreCase("android")?
                    AndroidDriverInit.startAndroidDriver(env):
                    IOSDriverInit.getIOSDriver(env);
            apit_testdata.env.set(env);
            apit_testdata.appdriver.set(driver);
            basePage = new BasePage(driver);
        basePageThread.set(basePage);

        }catch (MalformedURLException malformedURLException){
            System.out.println("android driver url exception occurred : "+malformedURLException.getMessage());
        }
        //((CanRecordScreen) driver).startRecordingScreen();
    }


    @AfterTest
    public void quit() throws IOException {
//        String base64Video = ((CanRecordScreen) driver).stopRecordingScreen();
//        Files.write(Paths.get("recording.mov"), Base64.getDecoder().decode(base64Video));
        if(driver!=null){
            //driver.removeApp(ConfigPropertiesReader.ANDROID_APP_PACKAGE);
            driver.quit();
            driver=null;
        }
    }

}