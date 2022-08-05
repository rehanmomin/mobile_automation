package com.hubilo.utils.appium_engine;
import com.hubilo.utils.helper.capabilityconfig;
import com.hubilo.utils.helper.JsonReader;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class IOSDriverInit {

    static JsonReader jsonReader;

    public static IOSDriver<MobileElement> getIOSDriver(String env) throws MalformedURLException {

        jsonReader =new JsonReader();

        DesiredCapabilities driverCapability = new DesiredCapabilities();
        String path = env.equalsIgnoreCase("release")? capabilityconfig.APP_FILE_PATH_RELEASE : capabilityconfig.APP_FILE_PATH_QAT;
        String ipaPath = System.getProperty("user.dir")+ path +jsonReader.getIosDesiredCap(String.valueOf("APP_NAME"));
        driverCapability.setCapability(MobileCapabilityType.APP, ipaPath);
        driverCapability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        driverCapability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, capabilityconfig.APPIUM_NEW_COMMAND_TIMEOUT);
        //driverCapability.setCapability(MobileCapabilityType.UDID, ConfigPropertiesReader.ANDROID_DEVICE_ID);
        driverCapability.setCapability(MobileCapabilityType.DEVICE_NAME,jsonReader.getIosDesiredCap("IOS_DEVICE_NAME"));
        driverCapability.setCapability(MobileCapabilityType.PLATFORM_VERSION,jsonReader.getIosDesiredCap("IOS_PLATFORM_VERSION"));
        driverCapability.setCapability(MobileCapabilityType.NO_RESET, true);
       // driverCapability.setCapability("autoAcceptAlerts", true);
        driverCapability.setCapability(MobileCapabilityType.FULL_RESET, false);
        driverCapability.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
        driverCapability.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        // driverCapability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ConfigPropertiesReader.ANDROID_APP_PACKAGE);
        // driverCapability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ConfigPropertiesReader.ANDROID_APP_ACTIVITY);

        IOSDriver<MobileElement> driver = new IOSDriver<MobileElement>(

                new URL("http://"+ capabilityconfig.APPIUM_LOCAL_MACHINE_IP + ":" + capabilityconfig.APPIUM_LOCAL_MACHINE_PORT+"/wd/hub"),driverCapability);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
}