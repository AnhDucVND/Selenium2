package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BaseSetup {

    private static WebDriver driver;
    static String driverPath="resource\\drivers\\";
    //Trả về driver đẻ các hàm khác gọi
    public static WebDriver getDriver(){
        return driver;
    }
    //Hàm này để tuỳ chọn Browser. Cho chạy trước khi gọi class này(BeforeClass)
    public WebDriver  setDriver(String browserType){
        switch (browserType){
            case "chrome":
                driver=initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }
    //Khởi tạo cấu hình các Browser để đưa vào Switch case
    private static WebDriver initChromeDriver(){
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver initFirefoxDriver(){
        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

//    @Parameters({ "browserType", "URL" })
//    @BeforeClass
//    public void initializeTestBaseSetup(@Optional String browserType, String URL) {
//        try {
//            // Khởi tạo driver và browser
//            setDriver(browserType);
//        } catch (Exception e) {
//            System.out.println("Error..." + e.getStackTrace().toString());
//        }
//    }

//    @AfterClass
//    public void tearDown() throws Exception {
//        Thread.sleep(2000);
//        driver.quit();
//    }
}
