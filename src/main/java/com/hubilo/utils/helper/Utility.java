package com.hubilo.utils.helper;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.jayway.jsonpath.JsonPath.parse;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class Utility {

    public static void gotoReception(AppiumDriver driver){

        if(driver instanceof AndroidDriver)
        {
            boolean status = true;

                sleep(2000);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                new FluentWait<>(driver)
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .pollingEvery(Duration.ofSeconds(1))
                    .withTimeout(Duration.ofSeconds(30))
                    .until(ExpectedConditions.visibilityOf(driver.findElement(
                                     MobileBy.xpath("//android.widget.TextView[@text='Reception']"))));
            driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Reception']")).click();


//            Utility.sleep(10000);
//            //            new WebDriverWait(driver, 300)
//                     .until(ExpectedConditions.visibilityOf(
//                             driver.findElement(
//                                     MobileBy.xpath("//android.widget.TextView[@text='Reception']")))).click();


            }
//            FluentWait wait = new FluentWait(driver)
//                    .pollingEvery(Duration.ofMillis(500))
//                    .ignoring(NoSuchElementException.class)
//                    .withTimeout(Duration.ofSeconds(6000));
//            wait.until(ExpectedConditions.visibilityOf(element));
//            element.click();

    }

    public static void isWaitEmpty(List<MobileElement> list){
        while (list.isEmpty())
            sleep(1000);
    }

    public static void clickIOSReception(AppiumDriver driver, MobileElement element1, MobileElement element2 ){
        if (driver instanceof IOSDriver){
            element1.click();
            element2.click();
            element1.click();
        }
    }

    public static void clickIOSReception(AppiumDriver driver, MobileElement element1){
        if (driver instanceof IOSDriver){
            element1.click();
            element1.click();
        }
    }
    public static void scrollUp(AppiumDriver driver, MobileElement source, Integer x, Integer y){
        Integer sourceX = source.getLocation().getX();
        Integer sourceY = source.getLocation().getY();
        new TouchAction<>((MobileDriver) driver).longPress(PointOption.point(sourceX,sourceY)).
                moveTo(PointOption.point(x,y)).release().perform();
    }

    public static void clickCordinate(AppiumDriver driver, Integer x, Integer y){
        new TouchAction<>(driver).tap(PointOption.point(x,y)).perform();
    }

    public static void swipeToRefresh(AppiumDriver driver, MobileElement element1, MobileElement element2) {
        new TouchAction(driver)
                .longPress(point(element1.getLocation().getX(), element1.getLocation().getY()))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(element2.getLocation().getX(),element2.getLocation().getY()))
                .release().perform();
    }

    public void scrollDownUpToElement(AppiumDriver driver){
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Logout\").instance(0))";
        new TouchAction(driver).press(PointOption.point(550, 640)).waitAction().moveTo(PointOption.point(550, 60)).release().perform();
    }

    public static void scrollDown(AppiumDriver driver){
        Dimension dimension = driver.manage().window().getSize();
        Double scrollHeightStart = dimension.getHeight() *0.5;
        int scrollStart = scrollHeightStart.intValue();
        Double scrollHeightEnd = dimension.getHeight() *0.2;
        int scrollEnd = scrollHeightEnd.intValue();

        new TouchAction<>(driver)
                .press(PointOption.point(0,scrollStart))
                .waitAction(waitOptions(ofMillis(500)))
                .moveTo(PointOption.point(0,scrollEnd))
                .release()
                .perform();
    }

    // Multi-event scrolling test
    public List<MobileElement> scrollTillElementFound(AppiumDriver driver, String eventName){

        //String locator = "//android.widget.TextView[@text='Automation-Appium']";
        return driver.findElements(By.xpath(String.format("//android.widget.TextView[@text='%s']",eventName)));
        //"//android.widget.TextView[@text="+eventName+"]"
    }

    public void startscrolling(AppiumDriver driver, String eventName){
        boolean status = true;
        while (status){
            scrollDown(driver);
            List<MobileElement> elementsLIst = driver instanceof IOSDriver ? driver.findElements(MobileBy.xpath("//*[@type='XCUIElementTypeStaticText']")) : driver.findElements(MobileBy.id("tvEventTitle"));
            //List<MobileElement> elementsLIst = driver.findElements(MobileBy.id("tvEventTitle"));
            if(elementsLIst.stream().filter(mobileElement -> mobileElement.getText().contains(eventName)).findFirst().isPresent()){
                if (driver instanceof IOSDriver){
                    Utility.sleep(2000);
                    driver.findElement(MobileBy.xpath("(//XCUIElementTypeStaticText[@name=\"Automation-Appiummobile\"])[2]")).click();
                }else {
                    driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='"+eventName+"']")).click();
                }
                status = false;
            }

//            if (scrollTillElementFound(driver,eventName).size()>0){
//                scrollTillElementFound(driver, eventName).get(0).click();
//                status = false;
            // }
        }
    }

    public String getScreenshot(AppiumDriver driver) {
        String getScreenshotFileName = file_locators.screenshotPath+"Screenshot_"+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())+".png";
        File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(file, new File(getScreenshotFileName));
        }catch (IOException ioException){
            ioException.getMessage();
        }

        return getScreenshotFileName;
    }


    public List<MobileElement> listEL(AppiumDriver driver){

        return driver.findElements(By.id("com.hubilo.v2.dev:id/tvIndustry"));
    }

    public void scrollTillElementFound(AppiumDriver driver){
        boolean status = true;
        while (status){
            scrollDown(driver);
            if (listEL(driver).size()>0){
                //System.out.println("Last Element found " +listEL(driver).stream().findFirst().get().getText());
                status = false;
            }
        }

    }

    public void scrollToBottom(AppiumDriver driver) {

        int  x = driver.manage().window().getSize().width / 2;
        int start_y = (int) (driver.manage().window().getSize().height * 0.2);
        int end_y = (int) (driver.manage().window().getSize().height * 0.8);
        TouchAction dragNDrop = new TouchAction(driver)
                .longPress(PointOption.point(x,start_y)).waitAction(waitOptions(ofMillis(500)))
                .moveTo(PointOption.point(x, end_y))
                .release();
        dragNDrop.perform();
    }

    public void scrollByText(AppiumDriver driver, String menuText) {

        try {
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + menuText + "\").instance(0));"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] getBase64Screenshot(AppiumDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    public void scrollUp(AppiumDriver driver, MobileElement banner){
        int x = banner.getLocation().getX();
        int y = banner.getLocation().getY();
        new TouchAction(driver).press(PointOption.point(x, y)).waitAction().moveTo(PointOption.point(x, 8)).release().perform();
    }

    public static WebDriverWait waitElement(AppiumDriver driver){
        return new WebDriverWait(driver,120);
    }

    public static void goBack(AppiumDriver driver){
        ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }
    public static String getSessionPaginationDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM");
        return formatter.format(new Date());
    }
    public static void listDropDown(List<MobileElement> list, MobileElement textSearch, String data){
        textSearch.sendKeys(data);
        list.stream().filter((MobileElement element) -> element.getText().contains(data)).findFirst().get().click();
    }

    public static Boolean isAvailable(AppiumDriver driver, MobileElement element){
        return driver instanceof IOSDriver?element.isEnabled():element.isDisplayed();
    }

    public static void permissionAllow(AppiumDriver driver){
        int x=1;
        Utility.sleep(2000);
        while (x<4){
            if(x==1 || x==2){
                new WebDriverWait(driver,300)
                        .until(
                                ExpectedConditions.visibilityOf(
                                        driver.findElement(MobileBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")
                                ))).click();
            } else if (x==3) {
                new WebDriverWait(driver,300)
                        .until(
                                ExpectedConditions.visibilityOf(driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Allow']")
                   ))).click();
            }
            x+=1;
        }
    }

    public static void eventGalleryPermission(AppiumDriver driver, MobileElement element){
        if (driver instanceof AndroidDriver) {
                waitUntilElement(driver, element);
                element.click();
        }
        Utility.sleep(1000);
    }

    public static int getSearchIndex(List<MobileElement> pagination, String searchElementName){
        int index=0;
        for(int i = 0; i<pagination.size();i++){
            if(pagination.get(i).getText().contains(searchElementName)){
                index = i;
            }
        }
        return index;
    }
    public void scrollUpMeeting(AppiumDriver driver, MobileElement banner){
        int x = banner.getLocation().getX();
        int y = banner.getLocation().getY();
        new TouchAction(driver).press(PointOption.point(x, y)).waitAction().moveTo(PointOption.point(x, y-100)).release().perform();
    }

    public static void scrollDownByElement(AppiumDriver driver, MobileElement source, MobileElement target){
        new TouchAction(driver).press(PointOption
                        .point(source.getLocation().getX(), source.getLocation().getY()))
                .waitAction()
                .moveTo(PointOption
                        .point(target.getLocation().getX(), target.getLocation().getY()))
                .release().perform();
    }

    public void swipDown(AppiumDriver driver, MobileElement element){
        int end_y = (int) (driver.manage().window().getSize().height * 0.8);
        int x = element.getLocation().getX();
        int y = element.getLocation().getY();
        new TouchAction(driver).press(PointOption.point(x, y)).waitAction().moveTo(PointOption.point(x, end_y)).release().perform();
    }

    public static void waitUntilElement(AppiumDriver driver, MobileElement element){
        new WebDriverWait(driver,280)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(Duration.ofSeconds(1))
                .withTimeout(Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * method verify whether element is present on screen
     *
     * @param targetElement element to be present
     * @return true if element is present else throws exception
     * @throws InterruptedException Thrown when a thread is waiting, sleeping,
     *                              or otherwise occupied, and the thread is interrupted, either before
     *                              or during the activity.
     */
    public Boolean isElementPresent(AppiumDriver driver,By targetElement) throws InterruptedException {
        Boolean isPresent = driver.findElements(targetElement).size() > 0;
        return isPresent;
    }

    /**
     * method to hide keyboard
     */
    public void hideKeyboard(AppiumDriver driver) {
        ((AppiumDriver) driver).hideKeyboard();
    }

    /**
     * method to go back by Android Native back click
     */
    public void back(AppiumDriver driver) {
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }


    /**
     * method to tap on the screen on provided coordinates
     *
     * @param xPosition x coordinate to be tapped
     * @param yPosition y coordinate to be tapped
     */
    public void tap(AppiumDriver driver,double xPosition, double yPosition) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("startX", xPosition);
        tapObject.put("startY", yPosition);
        js.executeScript("mobile: tap", tapObject);
    }


    /**
     * method to find an element
     *
     * @param locator element to be found
     * @return WebElement if found else throws NoSuchElementException
     */
    public WebElement findElement(AppiumDriver driver,By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element;
        } catch (NoSuchElementException e) {
            Logger.logError(this.getClass().getName(), "findElement", "Element not found" + locator);
            throw e;
        }
    }

    /**
     * method to find all the elements of specific locator
     *
     * @param locator element to be found
     * @return return the list of elements if found else throws NoSuchElementException
     */
    public List<WebElement> findElements(AppiumDriver driver,By locator) {
        try {
            List<WebElement> element = driver.findElements(locator);
            return element;
        } catch (NoSuchElementException e) {
            Logger.logError(this.getClass().getName(), "findElements", "element not found" + locator);
            throw e;
        }
    }

    /**
     * method to get message test of alert
     *
     * @return message text which is displayed
     */
    public String getAlertText(AppiumDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            return alertText;
        } catch (NoAlertPresentException e) {
            throw e;
        }
    }





    /**
     * method to get network settings
     */
    public void getNetworkConnection(AppiumDriver driver) {
        System.out.println(((AndroidDriver) driver).getConnection());
    }


    /**
     * method to set network settings
     *
     * @param airplaneMode pass true to activate airplane mode else false
     * @param wifi         pass true to activate wifi mode else false
     * @param data         pass true to activate data mode else false
     */
    public void setNetworkConnection(AppiumDriver driver,boolean airplaneMode, boolean wifi, boolean data) {

        long mode = 1L;

        if (wifi) {
            mode = 2L;
        } else if (data) {
            mode = 4L;
        }

        ConnectionState connectionState = new ConnectionState(mode);
        ((AndroidDriver) driver).setConnection(connectionState);
        System.out.println("Your current connection settings are :" + ((AndroidDriver) driver).getConnection());
    }


    /**
     * method to get all the context handles at particular screen
     */
    public void getContext(AppiumDriver driver) {
        ((AppiumDriver) driver).getContextHandles();
    }

    /**
     * method to set the context to required view.
     *
     * @param context view to be set
     */
    public void setContext(AppiumDriver driver,String context) {

        Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();

        if (contextNames.contains(context)) {
            ((AppiumDriver) driver).context(context);
            Logger.info("Context changed successfully");
        } else {
            Logger.info(context + "not found on this page");
        }

        Logger.info("Current context" + ((AppiumDriver) driver).getContext());
    }

    /**
     * method to long press on specific element by passing locator
     *
     * @param locator element to be long pressed
     */
    public void longPress(AppiumDriver driver,By locator) {
        try {
            WebElement element = driver.findElement(locator);

            TouchAction touch = new TouchAction((MobileDriver) driver);
            LongPressOptions longPressOptions = new LongPressOptions();
            longPressOptions.withElement(ElementOption.element(element));
            touch.longPress(longPressOptions).release().perform();
            Logger.info("Long press successful on element: " + element);
        } catch (NoSuchElementException e) {
            Logger.logError(this.getClass().getName(), "findElement", "Element not found" + locator);
            throw e;
        }

    }

    /**
     * method to long press on specific x,y coordinates
     *
     * @param x x offset
     * @param y y offset
     */
    public void longPress(AppiumDriver driver,int x, int y) {
        TouchAction touch = new TouchAction((MobileDriver) driver);
        PointOption pointOption = new PointOption();
        pointOption.withCoordinates(x, y);
        touch.longPress(pointOption).release().perform();

        Logger.info("Long press successful on coordinates: " + "( " + x + "," + y + " )");

    }

    /**
     * method to long press on element with absolute coordinates.
     *
     * @param locator element to be long pressed
     * @param x       x offset
     * @param y       y offset
     */
    public void longPress(AppiumDriver driver,By locator, int x, int y) {
        try {
            WebElement element = driver.findElement(locator);
            TouchAction touch = new TouchAction((MobileDriver) driver);
            LongPressOptions longPressOptions = new LongPressOptions();
            longPressOptions.withPosition(new PointOption().withCoordinates(x, y)).withElement(ElementOption.element(element));
            touch.longPress(longPressOptions).release().perform();
            Logger.info("Long press successful on element: " + element + "on coordinates" + "( " + x + "," + y + " )");
        } catch (NoSuchElementException e) {
            Logger.logError(this.getClass().getName(), "findElement", "Element not found" + locator);
            throw e;
        }

    }

    /**
     * method to swipe on the screen on provided coordinates
     *
     * @param startX   - start X coordinate to be tapped
     * @param endX     - end X coordinate to be tapped
     * @param startY   - start y coordinate to be tapped
     * @param endY     - end Y coordinate to be tapped
     * @param duration duration to be tapped
     */

    public void swipe(AppiumDriver driver,double startX, double startY, double endX, double endY, double duration) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        // swipeObject.put("touchCount", 1.0);
        swipeObject.put("startX", startX);
        swipeObject.put("startY", startY);
        swipeObject.put("endX", endX);
        swipeObject.put("endY", endY);
        swipeObject.put("duration", duration);
        js.executeScript("mobile: swipe", swipeObject);
    }


    static String UiScrollable(String uiSelector) {
        return "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ".instance(0));";
    }

    /**
     * method to open notifications on Android
     */

    public void openNotifications(AppiumDriver driver) {
        ((AndroidDriver) driver).openNotifications();
    }



    /**
     * method to click on Element By Name
     *
     * @param elementByName - String element name to be clicked
     */

    public void click(AppiumDriver driver,String elementByName) {
        ((AppiumDriver) driver).findElementByName(elementByName).click();
    }

    /**
     * method to scroll down on screen from java-client 6
     *
     * @param swipeTimes       number of times swipe operation should work
     * @param durationForSwipe time duration of a swipe operation
     */
    public void scrollDown(AppiumDriver driver,int swipeTimes, int durationForSwipe) {
        Dimension dimension = driver.manage().window().getSize();

        for (int i = 0; i <= swipeTimes; i++) {
            int start = (int) (dimension.getHeight() * 0.5);
            int end = (int) (dimension.getHeight() * 0.3);
            int x = (int) (dimension.getWidth() * .5);


            new TouchAction((AppiumDriver) driver).press(PointOption.point(x, start)).moveTo(PointOption.point(x, end))
                    .waitAction(waitOptions(ofMillis(durationForSwipe)))
                    .release().perform();
        }
    }


    /**
     * method to scroll up on screen from java-client 6
     *
     * @param swipeTimes       number of times swipe operation should work
     * @param durationForSwipe time duration of a swipe operation
     */
    public void scrollUp(AppiumDriver driver,int swipeTimes, int durationForSwipe) {
        Dimension dimension = driver.manage().window().getSize();

        for (int i = 0; i <= swipeTimes; i++) {
            int start = (int) (dimension.getHeight() * 0.3);
            int end = (int) (dimension.getHeight() * 0.5);
            int x = (int) (dimension.getWidth() * .5);


            new TouchAction((AppiumDriver) driver).press(PointOption.point(x, start)).moveTo(PointOption.point(x, end))
                    .waitAction(waitOptions(ofMillis(durationForSwipe)))
                    .release().perform();
        }
    }

    public static String changeJsonFile(String filepath, String path, String value) {
        byte[] b1 = new byte[0];
        try {
            b1 = Files.readAllBytes(Paths.get(filepath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String jsonPayload = new String(b1);
        String res = parse(jsonPayload).set(path, value).jsonString();
        return res;
    }
    public static int generateRandomNumber()
    {
        Random ran=new Random();
        return  ran.nextInt(10000);

    }
    /**
     * method to get the jsonstring from a given json file with updated key values at runtime
     *
     * @param filepath
     * @param path
     * @param value
     */
    public static String updateMultiplePath(String filepath, String[] path, String[] value) {
        byte[] b1 = new byte[0];
        try {
            b1 = Files.readAllBytes(Paths.get(filepath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String jsonPayload = new String(b1);
        String res = "";
        res = parse(jsonPayload).set(path[0], value[0]).jsonString();
        for(int i=1;i<path.length;i++)
        {
            res = parse(res).set(path[i], value[i]).jsonString();
        }
        return res;
    }

    /**
     * method to get the jsonstring from a given json file
     *
     * @param filepath
     */
    public static String getJsonString(String filepath) {
        byte[] b1 = new byte[0];
        try {
            b1 = Files.readAllBytes(Paths.get(filepath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String jsonPayload = new String(b1);
        return jsonPayload;
    }

    public static Long epochCreation(String datetime) {
        LocalDateTime localDateTime = LocalDateTime.parse(datetime);
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return instant.toEpochMilli();
    }

    public static JsonPath getApiResponse(RequestSpecification request, String type, String jsonpayload, String endpoint) {
        Response response=null;
        if (type.equalsIgnoreCase("put")) {
            request.body(jsonpayload);
            response = request.put(JsonReader.getEndpoints(endpoint));
        } else if (type.equalsIgnoreCase("post")) {
            request.body(jsonpayload);
            response = request.post(JsonReader.getEndpoints(endpoint));
        } else if(type.equalsIgnoreCase("get")) {
            response = request.get(JsonReader.getEndpoints(endpoint));
        }

        ResponseBody body = response.getBody();
        JsonPath jsonPath = JsonPath.from(body.asPrettyString());
        String Status = jsonPath.getString("status");
        Assert.assertTrue(Status.equals("200"));
        return jsonPath;
    }

    public static void swipeToRefreshMultievent(AppiumDriver driver){
        MobileElement element1 = (MobileElement) driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Hubilo']"));
        MobileElement element2 = (MobileElement) driver.findElement(MobileBy.id("com.hubilo.v2.dev:id/tvAllEventsTag"));
        new TouchAction(driver)
                .press(point(450, 150))
                .waitAction(waitOptions(ofMillis(500)))
                .moveTo(point(450,600))
                .release().perform();
    }
    public static void loginLink(AppiumDriver driver, MobileElement rLogin) {
        new Utility().scrollDown(driver);
        new TouchAction(driver)
                .tap(PointOption.point(708,1793)).perform();
    }
    public static Map<String, String> apiHeaderBuilder(String value) {
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Authorization", "Bearer " + apit_testdata.token.get());
        requestHeaders.put("buildversion", "565");
        requestHeaders.put("eventId", apit_testdata.eventid.get());
        requestHeaders.put("organiserId", JsonReader.getSettingApiTestData("OrganiserId"));
        requestHeaders.put("Content-Type", "application/json;charset=UTF-8");
        requestHeaders.put("groupId", apit_testdata.groupid.get());
        requestHeaders.put("boothid", apit_testdata.boothnumber.get());
        requestHeaders.put("page", "1");
        requestHeaders.put("limit", "500");
        requestHeaders.put("agendaid", apit_testdata.agendanumber.get());
        requestHeaders.put("tableid", apit_testdata.loungenumber.get());
        requestHeaders.put("search",apit_testdata.search.get());
        requestHeaders.put("Content-length","3790");
        String[] key1 = value.split(",");
        Map<String, String> newMap = new HashMap<String, String>();
        for (int i = 0; i < key1.length; i++) {
            for (String str : requestHeaders.keySet()) {
                if (str.equalsIgnoreCase(key1[i])) {
                    newMap.put(str, requestHeaders.get(key1[i]));
                }
            }
        }
        newMap.entrySet().forEach(entry -> {
            Logger.info(entry.getKey() + " " + entry.getValue());
        });
        return newMap;
    }

    public static void sleep(long sec) {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public static String getLoungeID(JsonPath jsonPath,String name) {
        int count = Integer.parseInt(jsonPath.getString("total_count"));
        String loungeid = null;
        for (int i = 0; i < count; i++) {
            if (jsonPath.getString("data[" + i + "].tableName").equalsIgnoreCase(name)) {
                loungeid=jsonPath.getString("data[" + i + "].id");
            }
        }
        Logger.info("Lounge id :"+loungeid);
        return loungeid;
    }

    public static String getPeopleID(JsonPath jsonPath, String name) {
        int count = Integer.parseInt(jsonPath.getString("total_count"));
        String peopleid = null;
        for (int i = 0; i < count; i++) {
            if (jsonPath.getString("data[" + i + "].email").equalsIgnoreCase(name)) {
                peopleid=jsonPath.getString("data[" + i + "].id");
            }
        }
        Logger.info("People id :"+peopleid);
        return peopleid;
    }
    public static String getPastORFutureDates(String time,int day)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = new Date();
        String todate = dateFormat.format(date);
        Calendar cal = Calendar.getInstance();
        if(time.equalsIgnoreCase("Past"))
            cal.add(Calendar.DATE, -day);
        else
            cal.add(Calendar.DATE, day);
        Date todate1 = cal.getTime();
        String fromdate = dateFormat.format(todate1);
        System.out.println(fromdate);
        return fromdate;
    }
    public static String getPastORFutureTime(String time,int hr)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = new Date();
        String todate = dateFormat.format(date);
        Calendar cal = Calendar.getInstance();
        if(time.equalsIgnoreCase("Past"))
            cal.add(Calendar.HOUR, -hr);
        else
            cal.add(Calendar.HOUR, hr);
        Date todate1 = cal.getTime();
        String fromdate = dateFormat.format(todate1);
        System.out.println(fromdate);
        return fromdate;
    }

}