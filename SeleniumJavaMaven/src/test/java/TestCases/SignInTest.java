package TestCases;

import Listerners.ReportListener;
import Page_MyAccount.MyDGO.LogInInfomationObject;
import Page_MyAccount.MyDGO.LoginPageMAObject;
import Utils.AllureManager;
import Utils.Log;
import common.BasePage;
import common.BaseSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;
import Listerners.*;

@Listeners(ReportListener.class)
@Epic("MY Account")

public class SignInTest extends BaseSetup {
    private WebDriver driver;
    private BasePage basePage;
    private LoginPageMAObject loginPageMAObject;
    private LogInInfomationObject logInInfomationObject;
    private String browserType,userName, passWord,identityNo;



    @BeforeClass
    @Description("Khởi tạo trình duyêt")
    public void beforeClass() {
        //driver = getDriver();
        driver=new BaseSetup().setDriver("chrome");
        basePage = new BasePage(driver);
        userName = "annhduc989999";
        passWord = "Ab05131998";
        identityNo="234294857231";

    }

    @Test(priority = 1, description = "Myaccount và tạo tài khoản")
    @Step("Mở trang MA")
    public void TC_01_LoginPageMA(Method result) throws Exception {
        loginPageMAObject = new LoginPageMAObject(driver);
        driver.get("https://myaccount.vndirect.com.vn/login");
        logInInfomationObject = loginPageMAObject.openNewAccount();
        basePage.wait(5);

    }
    @Test(priority = 2,description = "NHập thông tin tin tài khoản")
    @Step("Nhập thông tin tài khoản")
    public void TC02_OpenAllAccount() throws Exception {
        logInInfomationObject.inputLoginInfomation(identityNo,userName,passWord,passWord);
        basePage.wait(5);
    }


}
