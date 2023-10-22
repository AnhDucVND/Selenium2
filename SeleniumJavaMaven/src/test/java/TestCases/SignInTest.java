package TestCases;

import Base.BaseSetup;
import Pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignInTest extends BaseSetup {

    private WebDriver driver;
    public SignInPage signInPage;
    @BeforeClass
    public void setUp(){
        driver=getDriver();
    }
    @Test
    public void signIn(){
        SignInPage signInPage =new SignInPage(driver);
        signInPage.SignIn("annhduc98","Ab05131998");
        Assert.assertEquals(signInPage.verifySignInPageTitle("My DGO"),true);
    }



}
