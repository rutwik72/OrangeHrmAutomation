package test;

import base.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import utilities.ScreenshotUtil;

public class LoginTest extends Browser {


    @Test
    public void Login() throws InterruptedException {

        try {
            LoginPage obj = new LoginPage(driver);

            logger.info("Logging in to orange HRM portal");  // Adding info logs

            Thread.sleep(3000);
            obj.Login();
            String actualhomepagetitle = driver.getTitle();
            System.out.println(actualhomepagetitle);
            String expectedhomepageTitle = "OrangeHRM";

            Thread.sleep(3000);
            ScreenshotUtil.captureScreenshot(driver,"HomePage");

            Assert.assertEquals(actualhomepagetitle, expectedhomepageTitle);
            logger.info("Login successful");

            Thread.sleep(5000);
        }
        catch (Exception e){
            logger.error("Error in login test"+e);                   //error log
            logger.debug("Debug log in login test");               // Debug log
        }

        logger.info("--------------------Login Test finished------------------");


    }
}
