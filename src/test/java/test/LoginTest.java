package test;

import base.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

public class LoginTest extends Browser {


    @Test
    public void Login() throws InterruptedException {

       LoginPage obj = new LoginPage(driver);

        obj.Login();
        String actualhomepagetitle= driver.getTitle();
        System.out.println(actualhomepagetitle);
        String expectedhomepageTitle= "OrangeHRM";

        Assert.assertEquals(actualhomepagetitle,expectedhomepageTitle);

        Thread.sleep(5000);


    }
}
