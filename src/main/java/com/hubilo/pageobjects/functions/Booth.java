package com.hubilo.pageobjects.functions;

import com.hubilo.pageobjects.locators.BoothLocator;
import com.hubilo.utils.helper.Logger;
import com.hubilo.utils.helper.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class Booth extends BoothLocator {

    private AppiumDriver driver;
    private SoftAssert softAssert = new SoftAssert();

    Integer x, y;
    public Booth(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void verifyBooth(String testCaseName, String value) {

        switch (testCaseName) {
            case "verify booth category": {
                verifyBoothCategory(value);
                break;
            }
            case "verify bookmark booth": {
                verifyBookmark();
                break;
            }
            case "verify unbookmark booth": {
                verifyUnBookmark();
                break;
            }
            case "verify search booth": {
                verifySearchBooth(value);
                break;
            }
            case "verify booth detail page": {
                verifyDetailPage();
                break;
            }
            case "verify booth lists": {
                verifyVirtualBoothList(value);
                break;
            }
        }
    }

    private void gotoBooth(){
        Utility.gotoReception(driver);
        Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(gotoBooth));
        gotoBooth.click();
        x = meeting.getLocation().getX();
        y = meeting.getLocation().getY();
    }
    @Step("Go to Virtual booth tab, verify category of the booth")
    private void verifyBoothCategory(String category) {
        gotoBooth();
        softAssert.assertTrue(categoryList.stream().
                filter(element -> element.getText().contains(category)).findFirst().isPresent());
//        softAssert.assertTrue(categoryList.stream().
//                filter(element -> element.getText().contains("Exhibitors")).findFirst().isPresent());
        softAssert.assertAll();
    }

    @Step("Go to Virtual booth tab, click on three dots and click on bookmark")
    private void verifyBookmark() {
        threeDots.stream().findFirst().get().click();
        if(driver instanceof AndroidDriver) {
            softAssert.assertTrue(boothName.stream().findFirst().isPresent());
        }else{
            softAssert.assertTrue(Utility.isAvailable(driver,viewProfile));
        }
        bookmark.click();
        Utility.clickCordinate(driver,x,y);
        softAssert.assertAll();
    }

    @Step("Go to Virtual booth tab, click on three dots and click on unbookmark")
    private void verifyUnBookmark() {
        threeDots.stream().findFirst().get().click();
        if(driver instanceof AndroidDriver) {
            softAssert.assertTrue(boothName.stream().findFirst().isPresent());
        }else{
            softAssert.assertTrue(Utility.isAvailable(driver,viewProfile));
        }
        bookmark.click();
        Utility.clickCordinate(driver,x,y);
        threeDots.stream().findFirst().get().click();
        bookmark.click();
        Utility.clickCordinate(driver,x,y);
        softAssert.assertAll();
    }

    @Step("Go to Virtual booth tab, click on search button")
    private void verifySearchBooth(String searchValue) {
        textSearch.click();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException interruptedException){interruptedException.printStackTrace();}
        textSearch.sendKeys(searchValue);
        searchAllTab.click();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException interruptedException){interruptedException.printStackTrace();}
        if(driver instanceof IOSDriver)
        {
            List<MobileElement> melement = (List<MobileElement>) driver.findElements(By.xpath("//XCUIElementTypeStaticText[@name='"+searchValue+"']"));
            softAssert.assertTrue(melement.size() > 0);
            softAssert.assertTrue(Utility.isAvailable(driver,searchResultBoothCategory));
        }else {
            softAssert.assertTrue(Utility.isAvailable(driver,searchResultBoothName));
            softAssert.assertTrue(Utility.isAvailable(driver,searchResultBoothCategory));
        }
        searchBoothTab.click();
        if(driver instanceof IOSDriver)
        {
            List<MobileElement> melement = (List<MobileElement>) driver.findElements(By.xpath("//XCUIElementTypeStaticText[@name='"+searchValue+"']"));
            softAssert.assertTrue(melement.size() > 0);
            softAssert.assertTrue(Utility.isAvailable(driver,searchResultBoothCategory));
        }else {
            softAssert.assertTrue(Utility.isAvailable(driver,searchResultBoothName));
            softAssert.assertTrue(Utility.isAvailable(driver,searchResultBoothCategory));
        }
        backFromSearch.click();
        softAssert.assertAll();
    }

    @Step("Go to Virtual booth detail page")
    private void verifyDetailPage() {

        if(driver instanceof AndroidDriver) {
            boothName.stream().findFirst().get().click();
            Utility.sleep(1000);
            Utility.scrollUp(driver, notch, x, y);
        }else {
            boothNameFirst.click();
            Utility.sleep(1000);
            Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(shareYourDetail));
            shareYourDetail.click();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException interruptedException){interruptedException.printStackTrace();}
            shareYourDetailCancel.click();
        }
        Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(liveChat));
        liveChat.click();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException interruptedException){interruptedException.printStackTrace();}
        Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(teamMember));
        teamMember.click();
        Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(polls));
        polls.click();
        Utility.waitElement(driver).until(ExpectedConditions.visibilityOf(qAndA));
        qAndA.click();
        backBooth.click();
        softAssert.assertAll();
    }

    @Step("Go to Virtual booth tab, verify list of virtual booth")
    private void verifyVirtualBoothList(String Category) {
        if(driver instanceof AndroidDriver)
        {
            if (boothName.stream().count()>0){
                Reporter.log("Booth : "+boothName.stream().sorted());
                Logger.info("Booth : "+boothName.stream().sorted());
            }
        }else {
            List<MobileElement> mCategory = (List<MobileElement>) driver.findElements(By.xpath("(//XCUIElementTypeStaticText[@name='"+Category+"'])[1]"));
            softAssert.assertTrue(mCategory.size() > 0);
        }
        reception.click();
    }

}