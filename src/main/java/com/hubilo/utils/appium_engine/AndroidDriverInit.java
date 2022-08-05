package com.hubilo.utils.appium_engine;

import com.hubilo.utils.helper.JsonReader;
import com.hubilo.utils.helper.capabilityconfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverInit {
    static JsonReader jsonReader;
    enum caps{PLATFORM_TYPE,APP_NAME,ANDROID_APP_PACKAGE,ANDROID_APP_ACTIVITY,ANDROID_PLATFORM_VERSION,ANDROID_DEVICE_ID}
    public static AppiumDriver<MobileElement> startAndroidDriver(String env) throws MalformedURLException {

        jsonReader =new JsonReader();
        DesiredCapabilities driverCapability = new DesiredCapabilities();
        String path = env.equalsIgnoreCase("release")? capabilityconfig.APP_FILE_PATH_RELEASE : capabilityconfig.APP_FILE_PATH_QAT;
        String apkPath = System.getProperty("user.dir")+ path +jsonReader.getAndroidDesiredCap(String.valueOf(caps.APP_NAME));
        driverCapability.setCapability(MobileCapabilityType.APP, apkPath);
        driverCapability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        driverCapability.setCapability(MobileCapabilityType.PLATFORM_NAME, jsonReader.getAndroidDesiredCap(String.valueOf(caps.PLATFORM_TYPE)));
        driverCapability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, capabilityconfig.APPIUM_NEW_COMMAND_TIMEOUT);
        driverCapability.setCapability(MobileCapabilityType.UDID, jsonReader.getAndroidDesiredCap(String.valueOf(caps.ANDROID_DEVICE_ID)));
        driverCapability.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
        //driverCapability.setCapability(MobileCapabilityType.DEVICE_NAME, jsonReader.getAndroidDesiredCap(String.valueOf(caps.PLATFORM_TYPE)));
        driverCapability.setCapability(MobileCapabilityType.PLATFORM_VERSION, jsonReader.getAndroidDesiredCap(String.valueOf(caps.ANDROID_PLATFORM_VERSION)));
        driverCapability.setCapability(MobileCapabilityType.NO_RESET, true);
        driverCapability.setCapability(MobileCapabilityType.FULL_RESET, false);
//        driverCapability.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
        driverCapability.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        driverCapability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, jsonReader.getAndroidDesiredCap(String.valueOf(caps.ANDROID_APP_PACKAGE)));
        driverCapability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, jsonReader.getAndroidDesiredCap(String.valueOf(caps.ANDROID_APP_ACTIVITY)));
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(
                new URL("http://"+ capabilityconfig.APPIUM_LOCAL_MACHINE_IP+ ":" + capabilityconfig.APPIUM_LOCAL_MACHINE_PORT+"/wd/hub"),driverCapability);
        return driver;
    }


}