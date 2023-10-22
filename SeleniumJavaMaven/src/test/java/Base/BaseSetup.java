package Base;

import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BaseSetup {

    private WebDriver driver;
    static String driverPath="resource\\drivers\\";

    public WebDriver getDriver(){
        return driver;
    }

    private void setDriver(String browserType,String URL){
        switch (browserType){
            case "chrome":
                driver=initChromeDriver(URL);
                break;
            case "firefox":
                driver = initFirefoxDriver(URL);
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver(URL);
        }
    }
    private static WebDriver initChromeDriver(String URL){
        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.driver", "D:\\AKA\\Dang ki package\\Browser\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String URL){
        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    @Parameters({ "browserType", "URL" })
    @BeforeClass
    public void initializeTestBaseSetup(@Optional String browserType, String URL) {
        try {
            // Khởi tạo driver và browser
            setDriver(browserType, URL);
        } catch (Exception e) {
            System.out.println("Error..." + e.getStackTrace().toString());
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
