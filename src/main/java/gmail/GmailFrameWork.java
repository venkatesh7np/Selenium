package gmail;/*
User: Venkatesh
Description: Gmail reusable script

*/
//contains all the reusable methods.
//open browser, url, getElement which is called in isElementPresent method, validateWebpage,
//type, click, getElemets, These methods which are called in the script

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GmailFrameWork {
    WebDriver driver;
    public GmailFrameWork(){
    }
    WebElement getElement(By locater){
        return driver.findElement(locater);
    }
    boolean isElementPresent(By locater) {
        try {
            if (getElement(locater).isDisplayed())
                return true;
            else {
                WebDriverWait wait = new WebDriverWait(driver, 12);
                wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
                return true;
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Webelement Not Found");
            return false;
        }catch (TimeoutException timeoutException){
            System.out.println("Webelement Not Found");
            return false;
        }
    }
    void type(By locater,String value){
        if (isElementPresent(locater))
            getElement(locater).sendKeys(value);
    }
    void click(By locater){
        if (isElementPresent(locater))
            getElement(locater).click();
    }
    void select(By locater,String value){
        new Select(getElement(locater)).selectByVisibleText(value);
    }
    void openBrowser(String browser){
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "Firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "ie" -> {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            }
            default -> System.out.println("Browser Not Found");
        }
    }
    void openURL(String browser,String url){
        openBrowser(browser);
        try {
            driver.get(url);
        } catch (WebDriverException webDriverException) {
            System.out.println("Environment not set Properly");
        }
    }
    List<WebElement> getElements(By locater){
        try {
            WebDriverWait wait= new WebDriverWait(driver, 12);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locater));
        } catch (TimeoutException timeoutException) {
            System.out.println("Gmail login Failed");
        }
        return driver.findElements(locater);

    }

    void validateWebpage(String expectedTitle){
        String actualTitle= driver.getTitle();
        if (actualTitle.equals(expectedTitle))
            System.out.println("Page Successfully Validated");
        else System.out.println("Page Not Validated");
    }
    void quitSession(){
        driver.quit();
    }
}
