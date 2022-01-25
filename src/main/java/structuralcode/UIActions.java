package structuralcode;

// Test Case Id:1
// Test Case Description:
// 1.Open a Web page
// 2.Find elements:Email, Password, Login button
// 3.If yes:Perform action, click on Login
// 4.If no: Display Web elements not found


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UIActions
{
    public static WebDriver driver;
    public static Properties properties;
    public boolean isElementsPresent( WebElement element){

        if(element.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }
    public  String getPageTitle(){

        return driver.getTitle();
    }
    public void ValueInTextBox(WebElement element, String textValue){

        if(isElementsPresent(element)){
            element.sendKeys(textValue);
        }else {
            System.out.println("WebElement is not found ");
        }

    }
    public void Click(WebElement element){
        if(isElementsPresent(element)){
            element.click();
        }else {
            System.out.println("WebElement is not found ");
        }
    }
    public void Launch_Browser(String url){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);

    }
    public void getPropertyFile(){

        properties= new Properties();
        String propertiesPath = System.getProperty("user.dir");
        try {
            properties.load(new FileInputStream(propertiesPath+"/src/main/java/structuralCode/Locators.properties"));
        } catch (IOException e) {
            System.out.println("File is not found in the given path");
        }
    }
}
