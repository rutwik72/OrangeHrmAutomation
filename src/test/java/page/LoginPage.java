package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private By username = By.xpath("//input[@name='username']");
    private By password= By.xpath("//input[@name='password']");

    private By login = By.xpath("//button[@type='submit']");

    public void Login(){
        driver.findElement(username).sendKeys("Admin");
        driver.findElement(password).sendKeys("admin123");
        driver.findElement(login).click();
    }



}
