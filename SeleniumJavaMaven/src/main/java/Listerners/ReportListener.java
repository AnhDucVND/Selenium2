package Listerners;

import Utils.AllureManager;
import Utils.ExtentReport.ExtentTestManager;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utils.Log;
import static Utils.ExtentReport.ExtentManager.getExtentReports;
import common.BaseSetup;
import driver.DriverManager;

import java.io.ByteArrayInputStream;


public class ReportListener implements ITestListener {

    WebDriver driver;

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName()
                : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        driver = BaseSetup.getDriver();
        Log.info("Start testing " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", driver);
        //Gọi hàm startRecord video trong CaptureHelpers class
//        try {
//            CaptureHelpers.startRecord(iTestContext.getName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.info("End testing " + iTestContext.getName());
        //Kết thúc và thực thi Extents Report
        getExtentReports().flush();
        //Gọi hàm stopRecord video trong CaptureHelpers class
        //CaptureHelpers.stopRecord();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info(getTestName(iTestResult) + " test is starting...");
        ExtentTestManager.saveToReport(iTestResult.getName(), iTestResult.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(getTestName(iTestResult) + " test is passed.");
        //ExtentReports log operation for passed tests.
        ExtentTestManager.logMessage(Status.PASS, getTestDescription(iTestResult));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        driver = BaseSetup.getDriver();
        Log.error(getTestDescription(iTestResult) + " test is failed.");

        ExtentTestManager.addScreenShot(Status.FAIL, getTestName(iTestResult));
        ExtentTestManager.logMessage(Status.FAIL, iTestResult.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, getTestDescription(iTestResult) + " is failed.");

        //Allure Screenshot custom
        Log.error("Screenshot captured for test case: " + getTestName(iTestResult));
        AllureManager.saveScreenshotPNG(driver);
        AllureManager.saveTextLog(getTestName(iTestResult)+ " failed and screenshot taken!");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.warn(getTestName(iTestResult) + " test is skipped.");
        ExtentTestManager.logMessage(Status.SKIP, getTestName(iTestResult) + " test is skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.error("Test failed but it is in defined success ratio " + getTestName(iTestResult));
        ExtentTestManager.logMessage("Test failed but it is in defined success ratio " + getTestName(iTestResult));
    }
}
