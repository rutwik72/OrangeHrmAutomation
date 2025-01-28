package test;

import base.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.PimPage;

public class UpdateEmployeePersonalDetailsTest extends Browser {

    @Test
    public void updateEmployeePersonalDetailsMethod() throws InterruptedException {
        LoginPage log=new LoginPage(driver);
        log.Login();

        Thread.sleep(5000);

        HomePage home=new HomePage(driver);
        home.ClickOnPim();
        Thread.sleep(4000);

        PimPage pim= new PimPage(driver);
        String actualname= pim.AddNewEmployee("Omkar","mane");
        String expectedname ="Omkar mane";
        Assert.assertEquals(actualname,expectedname);

        Thread.sleep(5000);

        pim.updateEmployeePersonalDetails();

        Thread.sleep(3000);



    }

}
