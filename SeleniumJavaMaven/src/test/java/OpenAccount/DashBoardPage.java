package OpenAccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DashBoardPage {

    @BeforeTest
    public void BeforeTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\AKA\\Dang ki package\\Browser\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://anhtester.com/");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    WebDriver driver;
    @Test
    public void TC_01() {

    }
}



