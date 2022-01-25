package vels;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class Reusable {
    public static WebDriver driver;

    public void links(WebDriver driver) {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("The count of links is: " + links.size());
        for (WebElement link : links) {
            String LinksNames = link.getAttribute("href");
            System.out.println(link.getText() + "----" + LinksNames);
        }
    }

    public void cancelDialogBox(WebDriver driver) throws InterruptedException {
        Alert CancelAlert = driver.switchTo().alert();
        Thread.sleep(2000);
        CancelAlert.dismiss();
    }

    public void conformDialogBox(WebDriver driver) throws InterruptedException {
        Alert ConfAlert = driver.switchTo().alert();
        Thread.sleep(2000);
        ConfAlert.accept();
    }

    public void checkBoxes(WebDriver driver) {
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement cbox : checkBoxes) {
            if (cbox.isSelected()) {
                System.out.println(" is Checked");
            } else {
                System.out.println(" is not Checked");
            }

        }
    }
    public void listData(WebDriver driver)
    {
        List<WebElement> lData = driver.findElements(By.xpath("//div[@class='vertical-list-container mt-4']//child::div"));
        for(WebElement ele:lData){
            String Data= ele.getText();
            System.out.println(Data);
        }

    }//div[@class='vertical-list-container mt-4']//child::div
}//div[@class='custom-control custom-checkbox custom-control-inline']//following-sibling::label
