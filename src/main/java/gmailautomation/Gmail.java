package gmailautomation;

import com.opencsv.CSVWriter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Gmail {
    WebDriver driver;
    String[] mailDetails;
    @BeforeTest
    void setup(){
        WebDriverManager.chromedriver().setup();
        //checks for the latest version of the specified webdriver binary
        driver=new ChromeDriver();
        //created an instance of chrome driver
        driver.manage().window().maximize();
        //this maximises the current window
        driver.get("https://mail.google.com/");
        //this opens the specified URL
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //waits for the given stipulated time before it moved forward with the code
        driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("venkateshtestemail@gmail.com");
        //finds the enter email id input box and enters the email id given
        driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
        //finds the click button and clicks on it
        WebDriverWait wait=new WebDriverWait(driver,15);
        //waits for 15seconds for the page to load before the code moves forward to next step
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type=\"password\"]"))).sendKeys("Test@123$");
    }
    @Test
    void getMailContent() throws IOException {
        driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
        List<WebElement> list=driver.findElements(By.xpath("//tr[@role=\"row\"]//following-sibling::td[3]/div[2]/span"));
        File file = new File("D:\\Gmail\\gmaildata.csv");
        FileWriter outputfile = new FileWriter(file);
        CSVWriter writer = new CSVWriter(outputfile);
        String[] header = { "senderName", "subject", "time" };
        writer.writeNext(header);
        for (int indexposition = 1; indexposition <=list.size() ; indexposition++) {
            String senderName=driver.findElement(By.xpath("//tr["+indexposition+"][@role=\"row\"]//following-sibling::td[3]/div[2]/span")).getText();
            System.out.println(senderName);
            String subject=driver.findElement(By.xpath("//tr["+indexposition+"][@role=\"row\"]//following-sibling::td[4]/div/div/div/span/span")).getText();
            System.out.println(subject);
            String time=driver.findElement(By.xpath("//tr["+indexposition+"][@role=\"row\"]//following-sibling::td[5]/span")).getText();
            System.out.println(time);
            String[] mailDetails = { senderName, subject, time };
            writer.writeNext(mailDetails);
        }
        writer.close();
    }
    @AfterTest
    void teardown(){
        driver.quit();
    }
}
