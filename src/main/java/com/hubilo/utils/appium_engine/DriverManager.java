package com.hubilo.utils.appium_engine;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @created: 2022-07-25-12:23 PM
 * @project: Mobile_UI_Automation under @package: @package: com.hubilo.utils.appium_engine
 * @author: preetam
 **/


public class DriverManager {

    private static DriverManager driverManager = null;
    private ThreadLocal<AppiumDriver> threadLocal = new ThreadLocal<AppiumDriver>();

    private DriverManager(){

    }
    public void setDriver(AppiumDriver driver){
        threadLocal.set(driver);
    }

    public AppiumDriver getDriver(){
       return threadLocal.get();
    }

    public void removeDriver(){
        threadLocal.remove();
    }

    public static DriverManager getDriverInstance(){
        return driverManager==null ? new DriverManager() : driverManager;
    }
}
