package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Browser {


    protected WebDriver driver;
    public Logger logger;  // should be import Log4j

    @BeforeMethod
    public  void setup (){

        logger = LogManager.getLogger(this.getClass());           // should be Log4j

        System.setProperty("webdriver.chrome.driver","D:\\javapro\\OrangeHRM\\src\\test\\resources\\chromedriver.exe");

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        logger.info("Opened OrangeHRM");  // Adding logs
    }

    @AfterMethod
    public void QuitBrowser(){
        driver.quit();
    }

}
