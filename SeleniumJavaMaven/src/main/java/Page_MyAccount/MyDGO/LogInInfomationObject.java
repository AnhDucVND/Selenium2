package Page_MyAccount.MyDGO;

import Page_MyAccount.MyDGO.MyDGOUIs.LogInInfomationUI;
import common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LogInInfomationObject extends BasePage {
    WebDriver driver;

    public LogInInfomationObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public boolean verifyURL(){
        return driver.getCurrentUrl().contains("");
    }

    public void verifyTitleText(){
        verifyTextEquals(getText(driver,LogInInfomationUI.PAGE_TEXT),"Thông tin đăng nhập");
    }
    @Step("Điền thông tin đăng nhập")
    public void inputLoginInfomation(String identityNo,String userName,String passWord,String rePassword) throws Exception {
        inputToIdentityNoTextBox(identityNo);
        inputToUsernameTextBox(userName);
        inputToPasswordTextBox(passWord);
        inputToRePasswordTextBox(rePassword);
        wait(5);
        clicktoPolicyCheckBox();
        wait(1);
        clicktoNextButton();
    }
    @Step("Điền username")
    private void inputToUsernameTextBox(String userName) {
        sendKeyToElement(driver,LogInInfomationUI.USERNAME_FIELD,userName);
    }
    @Step("Điền CCCD")
    public void inputToIdentityNoTextBox(String identityNo){
        sendKeyToElement(driver, LogInInfomationUI.IDENTITYNO_FIELD,identityNo);
    }
    @Step("Điền password")
    public void inputToPasswordTextBox(String passWord){
        sendKeyToElement(driver, LogInInfomationUI.PASSWORD_FIELD,passWord);
    }
    public void inputToRePasswordTextBox(String rePassword){
        sendKeyToElement(driver, LogInInfomationUI.REPASSWORD_FIELD,rePassword);
    }
    public void clicktoPolicyCheckBox(){
        clickToElement(driver,LogInInfomationUI.POLICY_CHECKBOX);
    }
    public ContactInformationObject clicktoNextButton(){
        clickToElement(driver,LogInInfomationUI.NEXT_BUTTON);
        return new ContactInformationObject(driver);
    }


}
