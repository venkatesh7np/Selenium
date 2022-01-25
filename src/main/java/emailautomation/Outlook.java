package emailautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class Outlook {
    WebDriver driver;
    @Test
    void OpenURL(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1642668841&rver=7.0.6730.0&wp=LBI&wreply=https%3a%2f%2fwww.msn.com%2fen-in%2fhomepage%2fSecure%2fPassport%3fru%3dhttps%253a%252f%252fwww.msn.com%252fen-in%252f%253focid%253dmailsignout%2526pc%253dU591%2526pfr%253d1&lc=1033&id=1184&mkt=en-in&pcexp=True");
        driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("princev7@outlook.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("Venkatesh$7np");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"lightbox\"]/div[3]/div/div[2]/div/div[4]/div[2]/div/div/div/div")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"lightbox\"]/div[3]/div/div[2]/div/div[3]/div[2]/div/div/div[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[1]/div/ul/li[1]/a/h3")).click();
    }
}

