package test;

import base.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.PimPage;

public class AddNewEmployeeTest extends Browser {


    @Test
    public void InsertNewEmployee() throws InterruptedException {

        LoginPage log=new LoginPage(driver);
        log.Login();

        Thread.sleep(5000);

        HomePage obj=new HomePage(driver);
        obj.ClickOnPim();
        Thread.sleep(4000);

        PimPage obj2= new PimPage(driver);

        String actualname= obj2.AddNewEmployee("Omkar","mane");

        String expectedname ="Omkar mane";
        Assert.assertEquals(actualname,expectedname);

        Thread.sleep(5000);



    }






}
