package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private By PIM= By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]");


    public void ClickOnPim(){
        driver.findElement(PIM).click();
    }



}
