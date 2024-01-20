package Page_MyAccount.MyDGO;
import Page_MyAccount.MyDGO.MyDGOUIs.LoginPageUI;
import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageMAObject extends BasePage {

    private WebDriver driver;
    public LoginPageMAObject(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public String GetSignInPageTitle(){
        String pageTitle= driver.getTitle();
        return pageTitle;
    }
    public boolean verifySignInPageTitle(String expectText) {
         return GetSignInPageTitle().equals(expectText);
    }

    public void SignIn(String userName,String passWord){
        inputToUserNameTextBox(userName);
        inputToPasswordTextBox(passWord);

    }
    public void inputToUserNameTextBox( String value){
        sendKeyToElement(driver,LoginPageUI.USERNAME_FIELD,value);
    }
    public void inputToPasswordTextBox(String value){
        sendKeyToElement(driver,LoginPageUI.PASSWORD_FIELD,value);
    }
    public LogInInfomationObject openNewAccount(){
        clickToElement(driver,LoginPageUI.HYPERLINK_MTK);
        return new LogInInfomationObject(driver);
    }

}


