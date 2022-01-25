package structuralcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Interactions
{
    public void script(){
        UIActions uiActions = new UIActions();
        Verifications verifications = new Verifications();
        uiActions.getPropertyFile();
        uiActions.Launch_Browser(uiActions.properties.getProperty("Page_Url"));
        WebElement email = uiActions.driver.findElement(By.xpath(uiActions.properties.getProperty("email")));
        WebElement password = uiActions.driver.findElement(By.xpath(uiActions.properties.getProperty("password")));
        WebElement login = uiActions.driver.findElement(By.xpath(uiActions.properties.getProperty("Login_Button")));
        email.clear();
        uiActions.ValueInTextBox(email,uiActions.properties.getProperty("Login_Username"));
        password.clear();
        uiActions.ValueInTextBox(password,uiActions.properties.getProperty("Login_Password"));
        uiActions.Click(login);
        verifications.verifyPageTitle("Swag Labs");

    }

    public static void main(String[] args) {
        Interactions interaction = new Interactions();
        interaction.script();

    }

}
