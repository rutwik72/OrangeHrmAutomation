package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Browser {


    protected WebDriver driver;

    @BeforeMethod
    public  void setup (){
        System.setProperty("webdriver.chrome.driver","D:\\javapro\\OrangeHRM\\src\\test\\resources\\chromedriver.exe");

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    public void QuitBrowser(){
        driver.quit();
    }

}
