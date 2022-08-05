package com.hubilo.pageobjects.functions;

import com.hubilo.pageobjects.locators.One2OneChatLocator;
import com.hubilo.utils.helper.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class One2OneChat extends One2OneChatLocator {

    private AppiumDriver driver;
    private SoftAssert softAssert = new SoftAssert();

    public One2OneChat(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void verifyOne2OneChat(String testcase, String peopleName, String chat) {
        switch (testcase) {
            case "verify one to chat reception":
                gotoOne2OneChat();
                break;
            case "verify search people existing list":
                verifySearchPeopleExistingList(peopleName, chat);
                break;
            case "verify new chat people search":
                verifySearchPeopleNewChat(peopleName);
                break;
            case "verify text chat":
                textChat(peopleName, chat);
                break;
            case "verify GIF chat":
                chatGIF(peopleName, chat);
                break;
            case "verify delete text chat":
                deleteTextChatGify(peopleName);
                break;
            case "verify delete GIF chat":
                deleteTextChatGify(peopleName);
                break;
            case "verify delete all chat existing people":
                deleteAllChatExistingPeople(peopleName);
                break;
        }
    }

    @Step("Go to reception and then go to 1-1 chat message")
    private void gotoOne2OneChat() {
        Utility.gotoReception(driver);
        reception.click();
        chat.click();
        softAssert.assertEquals(messageTitle.getText(), "Messages", "verify message screen");
        softAssert.assertAll();
    }

    @Step("Go to One to One chat, search new people name : {peopleName}")
    private void verifySearchPeopleNewChat(String peopleName) {
        Utility.waitUntilElement(driver, newChat);
        newChat.click();
        Utility.waitUntilElement(driver, searchUser);
        searchUser.sendKeys(peopleName);
        Utility.sleep(1000);
        if (driver instanceof AndroidDriver) {
            softAssert.assertEquals(messageTitle.getText(), "New Chat", "verify title");
            softAssert.assertTrue(Utility.isAvailable(driver, userProfilePic), "verify profile image visible");
        } else {
            softAssert.assertEquals(newChatHeader.getText(), "New Chat", "verify title");
        }
        Utility.sleep(1000);
        softAssert.assertEquals(userName.stream().findAny().get().getText(), peopleName, "verify search user name");
        userName.stream().findFirst().get().click();
        softAssert.assertTrue(Utility.isAvailable(driver, emptyScreen), "verify empty chat");
        softAssert.assertAll();
    }

    @Step("Go to One to One chat, verify people name : {peopleName} and chat: {textChat}")
    private void textChat(String peopleName, String textChat) {
        chatInput.sendKeys(textChat);
        sendChat.click();
        Utility.waitUntilElement(driver, chatUserName);
        Utility.sleep(1000);
        if (driver instanceof AndroidDriver) {
            softAssert.assertEquals(chatUserName.getText(), peopleName, "verify chat person name");
        }
        boolean state =verifyChat.stream().filter(element -> element.getText().contains(textChat)).findFirst().isPresent();
        softAssert.assertTrue(state
                , "verify send chat");
        if (driver instanceof IOSDriver) {
            chatInput.clear();
        }
        softAssert.assertAll();
    }

    @Step("Go to One to One chat, verify people name : {peopleName} and chat: {GIFName}")
    private void chatGIF(String peopleName, String GIFName) {
        userName.stream().findFirst().get().click();
        if (driver instanceof AndroidDriver) {
            softAssert.assertEquals(chatUserName.getText(), peopleName, "verify chat person name");
        }
        gifyOption.click();
        Utility.sleep(1000);
        Utility.waitUntilElement(driver, searchInputGify);
        searchInputGify.sendKeys(GIFName);
        Utility.sleep(1000);
        Utility.isWaitEmpty(gifyList);
        Utility.waitUntilElement(driver, gifyList.stream().findFirst().get());
        gifyList.stream().findFirst().get().click();
        if (driver instanceof AndroidDriver) {
            Utility.waitUntilElement(driver, sendVerifyGify);
        }
        Utility.sleep(1000);
        sendChat.click();
        if(driver instanceof AndroidDriver) {
            Utility.waitUntilElement(driver, sendVerifyGify);
            softAssert.assertTrue(Utility.isAvailable(driver, sendVerifyGify),"verify send gify");
        softAssert.assertTrue(Utility.isAvailable(driver, sendVerifyGify),"verify send gify");
            Utility.waitUntilElement(driver, sendVerifyGify);
            softAssert.assertTrue(Utility.isAvailable(driver, sendVerifyGify), "verify send gify");
        } else {
            System.out.println("Verifying the last message should not contain text field");
            Utility.sleep(1000);
            softAssert.assertTrue(sendVerifyGifyList.size() < 1);
        }
        softAssert.assertAll();
    }

    @Step("Go to One to One chat, verify people name : {peopleName} and delete chat/gify")
    private void deleteTextChatGify(String peopleName) {
        Utility.waitUntilElement(driver, newChat);
        newChat.click();
        Utility.waitUntilElement(driver, searchUser);
        searchUser.sendKeys(peopleName);
        Utility.sleep(1000);
        userName.stream().findFirst().get().click();
        Utility.waitUntilElement(driver, chatUserName);
        softAssert.assertEquals(chatUserName.getText(), peopleName, "verify chat person name");
        threeDots.click();
        Utility.waitUntilElement(driver, deleteIcon);
        deleteIcon.click();
        Utility.waitUntilElement(driver, confirmDelete);
        confirmDelete.click();
        //softAssert.assertTrue(Utility.isAvailable(driver, emptyScreen), "verify empty chat");
        if(driver instanceof IOSDriver) {
            if(newChatHeaderList.size() < 1) {
                cancelBtn.click();
            }
        }
        softAssert.assertAll();
    }

    @Step("Go to One to One chat, search existing people name : {peopleName} and chat: {textChat}")
    private void verifySearchPeopleExistingList(String peopleName, String textChat) {
        newChat.click();
        Utility.waitUntilElement(driver, searchUser);
        searchUser.sendKeys(peopleName);
        Utility.sleep(1000);
        userName.stream().findFirst().get().click();
        Utility.sleep(1000);
        if (driver instanceof AndroidDriver) {
            softAssert.assertEquals(chatUserName.getText(), peopleName, "verify chat person name");
        }
        gifyOption.click();
        Utility.waitUntilElement(driver, searchInputGify);
        searchInputGify.sendKeys(textChat);
        Utility.isWaitEmpty(gifyList);
        Utility.sleep(2000);
        gifyList.stream().findAny().get().click();
        if (driver instanceof AndroidDriver) {
            Utility.waitUntilElement(driver, sendVerifyGify);
        }
        sendChat.click();
        if (driver instanceof AndroidDriver) {
            softAssert.assertTrue(Utility.isAvailable(driver, sendVerifyGify), "verify send gify");
        } else {
            System.out.println("Verifying the last message should not contain text field");
            softAssert.assertTrue(sendVerifyGifyList.size() < 1);
        }
        chatInput.sendKeys(textChat);
        Utility.sleep(1000);
        sendChat.click();
        softAssert.assertTrue(verifyChat.stream().filter(element -> element.getText().contains(textChat)).findFirst().isPresent()
                , "verify send chat");
        cancelBtn.click();
        if (driver instanceof IOSDriver) {
            cancelBtn.click();
            textField.clear();
        }
        Utility.waitUntilElement(driver, searchUser);
        searchUser.sendKeys(peopleName);

        if (driver instanceof AndroidDriver) {
            Utility.waitUntilElement(driver, userName.stream().findFirst().get());
            softAssert.assertTrue(Utility.isAvailable(driver, userProfilePic), "verify profile pic visible");
            softAssert.assertEquals(userName.stream().findFirst().get().getText(), peopleName, "verify chat person name");
        } else {
            //   softAssert.assertEquals(userNameiOS.get(0).getText(), peopleName, "verify chat person name");
        }
        Utility.sleep(1000);
        softAssert.assertTrue(Utility.isAvailable(driver, userChat.get(0)), "verify chat visible");
        softAssert.assertTrue(Utility.isAvailable(driver, postTime.get(0)), "verify post time visible");
        softAssert.assertAll();
    }

    @Step("Go to One to One chat, verify delete all chat people name : {peopleName}")
    private void deleteAllChatExistingPeople(String peopleName) {
        if (driver instanceof AndroidDriver) {
            threeDots.click();
        } else {
            horzThreeDots.click();
        }
        softAssert.assertTrue(Utility.isAvailable(driver, userViewProfile), "verify user profile option visible");
        softAssert.assertTrue(Utility.isAvailable(driver, deleteAllChatImage), "verify delete all chat visible");
        deleteAllChatImage.click();
        Utility.sleep(1000);
        confirmDelete.click();
        if (driver instanceof IOSDriver) {
            textField.clear();
        }
        softAssert.assertAll();
    }

    public void back() {
        Utility.waitUntilElement(driver, cancelBtn);
        cancelBtn.click();
        if (driver instanceof IOSDriver) {
            cancelBtn.click();
        }
    }

    public void gotoiOSOne2OneChat() {
        chat.click();
    }

    public void iOSCloseChat() {
        closeChat.click();
    }
}
