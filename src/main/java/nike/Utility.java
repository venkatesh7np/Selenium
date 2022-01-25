package nike;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Utility {
    WebDriver driver;
    void openURL(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.nike.com");
    }
    void lowestPrice(String product){
        driver.findElement(By.id("VisualSearchInput")).sendKeys(product);
        driver.findElement(By.id("VisualSearchInput")).sendKeys(Keys.ENTER);
        List<WebElement> list=driver.findElements(By.className("product_msg_info"));
        HashMap<Integer,String> map=new HashMap<Integer, String>();
        for (int indexposition = 1; indexposition <=list.size() ; indexposition++) {
            String item=driver.findElement(By.xpath("//*[@id=\"Wall\"]/div/div[5]/div[2]/main/section/div/div["+indexposition+"]/div/figure/div/div[1]")).getText();
            if (item.contains(product)){
                String price=driver.findElement(By.xpath("//*[@id=\"Wall\"]/div/div[5]/div[2]/main/section/div/div["+indexposition+"]/div/figure/div/div[3]")).getText();
                price=price.replaceAll("[₹,]","");
                int coverted=Integer.parseInt(price);
                map.put(coverted,item);
            }
        }
        List<Integer> prices = new ArrayList<>(map.keySet());
        prices.sort(Comparator.naturalOrder());
        System.out.println(map.get(prices.get(0)));
        System.out.println(prices.get(0));
    }
}
