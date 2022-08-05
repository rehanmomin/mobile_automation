package com.hubilo.utils.listners;
import com.hubilo.base.BaseTest;
import com.hubilo.utils.helper.apit_testdata;
import com.hubilo.utils.helper.Utility;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


public class TestListenerManager extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("Test Case ----- "+
                result.getMethod().getMethodName()+" Started");
        Reporter.log("Test Case ----- "+
                result.getMethod().getMethodName()+" Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("Test Case ----- "+
                result.getMethod().getMethodName()+" PASS");
        Reporter.log("Test Case ----- "+
                result.getMethod().getMethodName()+" PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
       driver=this.driver;
        ITestListener.super.onTestFailure(result);
        System.out.println(result.getMethod().getConstructorOrMethod().getName()+"***"+result.getThrowable());
        getBase64Screenshot(apit_testdata.appdriver.get());
        getlogs(result.getMethod().getConstructorOrMethod().getName()+"***"+result.getThrowable());
        Reporter.log(result.getMethod().getConstructorOrMethod().getName()+"***"+result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        System.out.println("Test Case ----- "+
                result.getMethod().getMethodName()+" skipped due to "+result.getThrowable());
        Reporter.log("Test Case ----- "+
                result.getMethod().getMethodName()+" skipped due to "+result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Start ----- "+ context.getName()+ "-----");
        Reporter.log("Start ----- "+ context.getName()+ "-----");
    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println("Start ----- "+ context.getName()+ "-----");
        Reporter.log("End ----- "+ context.getName()+ "-----");
    }

    @Attachment(value="screenshots",type = "image/png")
    public byte[] getBase64Screenshot(AppiumDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
    @Attachment(value="logs",type = "text/plain")
    public String getlogs(String message){
        return message ;
    }
}
