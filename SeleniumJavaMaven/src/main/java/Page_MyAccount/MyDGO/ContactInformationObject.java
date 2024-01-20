package Page_MyAccount.MyDGO;

import Page_MyAccount.MyDGO.MyDGOUIs.ContactInformationUI;
import Page_MyAccount.MyDGO.MyDGOUIs.LogInInfomationUI;
import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactInformationObject extends BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ContactInformationObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputContactInfomation(String fullName, String mobilePhone,String email,String methodOfContact){
        inputToFullNameTextBox(fullName);
        inputToEmailTextBox(mobilePhone);
        inputToEmailTextBox(email);
        clickToCreateAccountButton();


    }

    public void inputToFullNameTextBox(String fullName) {
        sendKeyToElement(driver, ContactInformationUI.FULLNAME_FIELD,fullName);

    }
    public void inputToMobilePhoneTextBox(String mobilePhone){
        sendKeyToElement(driver, ContactInformationUI.MOBILEPHONE_FIELD,mobilePhone);
    }
    public void inputToEmailTextBox(String email){
        sendKeyToElement(driver, ContactInformationUI.EMAIL_FIELD,email);
    }
    public void selectMethodOfContact(String methodOfContact){
        switch (methodOfContact) {
            case "mobilePhone":
                clickToElement(driver,ContactInformationUI.MOBILEPHONE_RATIO_BUTTON);
                break;
            case "email":
                clickToElement(driver,ContactInformationUI.EMAIL_RATIO_BUTTON);
                break;

        }
    }
    public void clickToCreateAccountButton(){
        clickToElement(driver,ContactInformationUI.CREATE_ACCOUNT_BUTTON);
    }
    public void clicktoBackButton(){
        clickToElement(driver,ContactInformationUI.BACK_BUTTON);
    }
    public void inputOTPAndConfirm(String OTP){
        driver.findElement(By.xpath("//input[@class=\"input  \"]")).sendKeys(OTP);
        driver.findElement(By.xpath("//button[text()=\"Xác nhận\"]")).click();

    }

}
