package gmail;/*
User: Venkatesh
Description: Script

*/
//

import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
public class Gmailscript {
    Properties properties;
    List<WebElement> list;
    CSVWriter writer;
    GmailFrameWork gmailFrameWork=new GmailFrameWork();
    public Gmailscript() throws IOException {
        properties=new Properties();
            FileInputStream fileInputStream=new FileInputStream("C:\\Users\\PrinceV7\\IdeaProjects\\selenium\\src\\main\\java\\gmail\\GmailTestData.properties");
        properties.load(fileInputStream);
        File file = new File("C:\\Users\\PrinceV7\\IdeaProjects\\selenium\\src\\main\\java\\gmail\\GmailContent.csv");
        FileWriter outputfile = new FileWriter(file);
        writer = new CSVWriter(outputfile);
    }
    //We have created objects for the following: property file, FileInputStream, FileWriter, CSVWriter
    @BeforeTest
    void setup(){
        gmailFrameWork.openURL(properties.getProperty("browser"),properties.getProperty("url"));
    }
    //To setup environment for Gmail application
    @Test
    void validateCredentials(){
        gmailFrameWork.validateWebpage(properties.getProperty("expectedHomePageTitle"));
        gmailFrameWork.type(By.xpath("//input[@type=\"email\"]"),properties.getProperty("UserName"));
        gmailFrameWork.click(By.xpath("//span[contains(text(),'Next')]"));
        gmailFrameWork.type(By.xpath("//input[@type=\"password\"]"),properties.getProperty("password"));
        gmailFrameWork.click(By.xpath("//span[contains(text(),'Next')]"));
        list=gmailFrameWork.getElements(By.xpath("//tr[@role=\"row\"]//following-sibling::td[3]/div[2]/span[1]"));
    }
    //Validated the gmail credentials.
    @Test(dependsOnMethods = {"validateCredentials"})
    void getMailDetails() throws IOException {
        for (int position = 1; position <= list.size(); position++) {
            String sender=gmailFrameWork.getElement(By.xpath("//tr["+position+"][@role=\"row\"]//following-sibling::td[3]/div[2]/span[1]")).getText();
            String subject=gmailFrameWork.getElement(By.xpath("//tr["+position+"][@role=\"row\"]//following-sibling::td[4]/div/div/div/span")).getText();
            String time=gmailFrameWork.getElement(By.xpath("//tr["+position+"][@role=\"row\"]//following-sibling::td[5]/span")).getText();
            String[] mailDetails={sender,subject,time};
            writer.writeNext(mailDetails);
        }
        writer.close();

    }
    //To get the mail details like name subject and time or date(for past emails), this method depends on the ValidateCredentialsMethod
    @AfterTest
    void TearDown(){
        //to end the session
        gmailFrameWork.quitSession();
    }
}
