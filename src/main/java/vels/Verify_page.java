package vels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verify_page extends Reusable
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/links");

        Reusable reusable = new Reusable();
        reusable.links(driver);

        driver.navigate().to("https://demoqa.com/automation-practice-form");
        System.out.println("--------------Verifying Check Boxes-------------" );
        reusable.checkBoxes(driver);

        driver.navigate().to("https://demoqa.com/alerts");
        driver.findElement(By.id("confirmButton")).click();
        reusable.cancelDialogBox(driver);
        System.out.println("--------------DialogBox Accepted-------------" );

        driver.findElement(By.id("confirmButton")).click();
        reusable.conformDialogBox(driver);
        System.out.println("--------------DialogBox Dismissed-------------" );

        driver.navigate().to("https://demoqa.com/sortable");
        System.out.println("--------------Printing List Data---------------");
        reusable.listData(driver);
    }
}
