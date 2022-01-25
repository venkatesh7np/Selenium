package Webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Webtables {
    WebDriver driver;
    String URL="https://www.techlistic.com/p/demo-selenium-practice.html";
    String Node="http://192.168.0.112:4444";


    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities dcp= new DesiredCapabilities();
        dcp.setBrowserName("chrome");
        driver=new RemoteWebDriver(new URL(Node),dcp);

        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);

    }

    @Test(priority = 0)
    public void countStructure() {
        List<WebElement> structure = driver.findElements(By.xpath("//tbody/tr/th"));
        WebElement total = driver.findElement(By.xpath("//td[contains(text(),'4 buildings')]"));
        String str = total.getText();
        String num = String.valueOf(str.charAt(0));
        // System.out.println(num);
        if (structure.size() == Integer.parseInt(num)) {
            System.out.println("number of structure = " + structure.size());
            System.out.println("Total = " + num);
        }

        System.out.println(("=======================TASK2====================="));

    }

    //task 2
    @Test(priority = 1)
    public void print_data() {

        List<WebElement> Row = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr"));
        for (WebElement ele : Row) {
            String Row_wise_data = ele.getText() + "  ";
            System.out.println(Row_wise_data);
        }


        System.out.println(("=====================TASK3==================="));

    }

    //task 3
    @Test(priority = 2)
    public void height() {
        List<WebElement> Burj_khalifa_Row = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[1]"));
        for (WebElement ele : Burj_khalifa_Row) {
            String Burj_height = ele.getText();
            if (Burj_height.contains("829m")) {
                System.out.println("Expected Burj_khalifa_Height and Actual Burj_khalifa_Height are same");
            } else {
                System.out.println("Expected Burj_khalifa_Height and Actual Burj_khalifa_Height are not same");
            }
        }
        int row_count = driver.findElements(By.xpath("//th[@scope='row']")).size();
        for (int i = 1; i < row_count; i++) {
            List<WebElement> structurs = driver.findElements(By.xpath("//tr/th[@scope='row']"));
            List<WebElement> StructureHight = driver.findElements(By.xpath("//tr/td[3]"));
            System.out.println(structurs.get(i).getText() + " is of " + StructureHight.get(i - 1).getText());
        }
        System.out.println("========================Task4===========================");
    }
    @Test(priority = 3)
    public void taskFour(){
        List<WebElement> footerhead = driver.findElements(By.xpath("//table/tfoot/tr/th"));
        List<WebElement> footercells = driver.findElements(By.xpath("//table/tfoot/tr/td"));
        int act_sixthrowColumnCount = footerhead.size() + footercells.size();
        int exp_sixthrowColumnCount = 2;
        if(act_sixthrowColumnCount == exp_sixthrowColumnCount)
           {
               Assert.assertTrue(true);
               System.out.println("Sixth row has 2 columns");
           } else{
                Assert.assertTrue(false);
        }
        }
    }