package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignInPage {

    private WebDriver driver;

    private By inputUsername=By.xpath("//input[@placeholder='Nhập tên đăng nhập']");
    private By inputPassword=By.xpath("//input[@id='typepassword']");
    private By btnLogin=By.xpath("//span[contains(text(),\"Đăng nhập\")]/parent::button");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }


    public String GetSignInPageTitle(){
        String pageTitle= driver.getTitle();
        return pageTitle;
    }
    public boolean verifySignInPageTitle(String expectText) {
         return GetSignInPageTitle().equals(expectText);
    }

    public void SignIn(String userName,String passWord){
        EnterUserName(userName);
        EnterPassword(passWord);
        ClickLogin();

    }

    private void EnterUserName(String userName){
        WebElement element=driver.findElement(inputUsername);
        Assert.assertEquals(element.isDisplayed() && element.isEnabled(),true);
        element.sendKeys(userName);
    }

    private void EnterPassword(String password){
        WebElement element=driver.findElement(inputPassword);
        Assert.assertEquals(element.isDisplayed() && element.isEnabled(),true);
        element.sendKeys(password);
    }

    private void ClickLogin(){
        WebElement element=driver.findElement(btnLogin);
        Assert.assertEquals(element.isDisplayed() && element.isEnabled(),true);
        element.click();
    }

}
