package common;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class BasePage {
    private Actions action;
    private WebDriver driver;
    public WebDriverWait wait;
    JavascriptExecutor js;
    private final int timeoutWait=10;

    public BasePage(WebDriver driver){
        this.driver=driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(timeoutWait));
        js=(JavascriptExecutor) driver;
        action=new Actions(driver);
    }

    private WebElement getWebElement(WebDriver driver, String locatorType){
        return driver.findElement(By.xpath(locatorType));
    }
    @Step("Set text {2} on {1}")
    public void sendKeyToElement(WebDriver driver, String locatorType, String textValue){
        WebElement element=this.getWebElement(driver,locatorType);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(textValue);
        //Log.info("Set text: " + textValue + " on element " + locatorType);
    }
    @Step("Click element {1}")
    public void clickToElement(WebDriver driver,String locatorType){
        WebElement element=this.getWebElement(driver,locatorType);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        //Log.info("Click element"+ locatorType);
    }
    public void selectOptionByText(By element,String value){
        Select select=new Select(driver.findElement(element));
        select.selectByVisibleText(value);
    }
    public void verifyTextEquals(String value, String expectedValue){
        String valueStr = value != null ? value.toString() : null;
        String expectedValueStr = expectedValue != null ? expectedValue.toString() : null;
        Assert.assertEquals(value, expectedValue, valueStr + " != " + expectedValueStr);
    }

    public boolean verifyUrl(String url){
        return driver.getCurrentUrl().contains(url);
        //Assert.assertTrue(true,"");
    }

    public void verifyElementText(WebDriver driver,String locatorType, String expectedText){
       String elementText=getText(driver,locatorType);
       String realExpectedText = expectedText;
       Assert.assertEquals(elementText,realExpectedText,elementText+" != "+expectedText);
    }
    public void verifyElementText(String locatorType, String expectedText){
        String elementText=getText(driver,locatorType);
        String realExpectedText = expectedText;
        Assert.assertEquals(elementText,realExpectedText,elementText+" != "+expectedText);
    }
    public String getText(WebDriver driver,String locatorType){
        WebElement element=this.getWebElement(driver,locatorType);
        return element.getText();
    }

    public void wait(int timeout) throws Exception {
     Thread.sleep(timeout*1000);
    }
    public boolean waitForElementPresent(WebDriver driver, String locatorType, int timeout) {
        WebElement waitForElement = null;
        WebDriverWait explicitWait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
        waitForElement= explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorType)));
        if(waitForElement!=null){
            return true;
        }else
            return false;

    }






}
