package links;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Myntra {
    public static void main(String[] args) {
        ChromeDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.myntra.com/");


        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("The count of links is: " + links.size());
        for (WebElement link : links) {
            String LinksNames = link.getAttribute("href");
            System.out.println(LinksNames);
        }
    }
}
