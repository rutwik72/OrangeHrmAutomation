package test;

import base.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

public class LoginTest extends Browser {


    @Test
    public void Login() throws InterruptedException {

        try {
            LoginPage obj = new LoginPage(driver);

            logger.info("Logging in to orange HRM portal");  // Adding info logs


            obj.Login();
            String actualhomepagetitle = driver.getTitle();
            System.out.println(actualhomepagetitle);
            String expectedhomepageTitle = "OrangeHRM";

            Assert.assertEquals(actualhomepagetitle, expectedhomepageTitle);
            logger.info("Login successful");

            Thread.sleep(5000);
        }
        catch (Exception e){
            logger.error("Error in login test");                   //error log
            logger.debug("Debug log in login test");               // Debug log
        }

        logger.info("--------------------Login Test finished------------------");


    }
}
