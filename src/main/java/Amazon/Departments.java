package Amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Departments {
    public static void main(String[] args) {
        WebDriver driver;
        DataProvider d = new DataProvider();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb");
        List<String> data = new ArrayList<>();
        String Department = "Beauty";
        d.setProduct(Department);

        List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[1]/div[18]/div/div/div/div/div[2]/div[2]/span[3]/span/div[2]//div/label/span"));
        for (WebElement element : elements ){
            String value = element.getText();
            data.add(value);
            System.out.println(value);
        }
        System.out.println();
    if (data.contains(d.getProduct())){
    System.out.println(Department + " is Present");
 }
    else {
    System.out.println(Department +" is not Present");
}
    }
}


