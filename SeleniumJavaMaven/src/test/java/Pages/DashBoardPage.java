package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DashBoardPage {

    @BeforeTest
    public void BeforeTest(){

    }

    WebDriver driver;
    @Test(priority = 2)
    public void Test01(){
        System.setProperty("webdriver.chrome.driver","D:\\AKA\\Dang ki package\\Browser\\chromedriver-win64\\chromedriver.exe");

        driver=new ChromeDriver();

        driver.get("https://anhtester.com/");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.quit();
    }

    @Test(priority = 1)
    public void Test02(){
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();

        driver.get("https://www.google.com/?hl=vi");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.quit();
    }
}
