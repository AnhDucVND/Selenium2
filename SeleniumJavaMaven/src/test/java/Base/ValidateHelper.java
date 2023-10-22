package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.interactions.Actions;


import java.util.concurrent.TimeUnit;

public class ValidateHelper {

    @BeforeTest
    public void BeforeTest(){

    }

    WebDriver driver;
    @Test(priority = 1)
    public void Test01(){
        System.setProperty("webdriver.chrome.driver","D:\\AKA\\Dang ki package\\Browser\\chromedriver-win64\\chromedriver.exe");

        driver=new ChromeDriver();

        driver.get("https://myaccount.vndirect.com.vn/");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String expectedTitle="Anh Tester Automation Testing";

        String actualTitle=driver.getTitle();

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(actualTitle,"Nguyễn Anh Đức");

        softAssert.assertEquals(actualTitle,expectedTitle);



        Actions action = new Actions(driver);

        String userName="annhduc98";
        String pass="Ab05131998";

        WebElement inputUsername=driver.findElement(By.xpath("//input[@placeholder='Nhập tên đăng nhập']"));
        WebElement inputPass=driver.findElement(By.xpath("//input[@id='typepassword']"));
        WebElement btn_Login=driver.findElement(By.xpath("//span[contains(text(),'Đăng nhập')]"));

        action.sendKeys(inputUsername,userName).build().perform();
        action.sendKeys(inputPass,pass).build().perform();
        action.click(btn_Login).build().perform();
        WebElement logo_VND=driver.findElement(By.xpath("//div[@id='logo-image']"));
        Assert.assertEquals(logo_VND.isDisplayed(),true);
        softAssert.assertAll();






        driver.quit();
    }

    @Test(priority = 2)
    public void Test02(){
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();

        driver.get("https://www.google.com/?hl=vi");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.quit();
    }
}
