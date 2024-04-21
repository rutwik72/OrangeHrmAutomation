package test;

import base.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.PimPage;

public class AddNewEmployee extends Browser {


    @Test
    public void InsertNewEmployee() throws InterruptedException {

        LoginPage log=new LoginPage(driver);
        log.Login();

        Thread.sleep(5000);

        HomePage obj=new HomePage(driver);
        obj.ClickOnPim();
        Thread.sleep(2000);

        PimPage obj2= new PimPage(driver);

        String actualname= obj2.AddNewEmployee("Amey","mane");
        System.out.println(actualname);
        String expectedname ="Amey mane";
        Assert.assertEquals(actualname,expectedname);



    }






}
