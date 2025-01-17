package test;

import base.Browser;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.PimPage;

public class SearchEmployee extends Browser {

    @Test
    public void searchEmplyeeData() throws InterruptedException {
        LoginPage loginpageobj = new LoginPage(driver);
        HomePage homepageobj = new HomePage(driver);


        loginpageobj.Login();
        Thread.sleep(5000);
        homepageobj.ClickOnPim();

        PimPage pimobj = new PimPage(driver);
        String actualname = pimobj.AddNewEmployee("Omkar", "Kulkarni");
        System.out.println(actualname);

        Thread.sleep(5000);

        pimobj.ClickOnEmployeelist();

       Thread.sleep(3000);
        pimobj.searchForEmployeeWithName("Omkar Kulkarni");


        Thread.sleep(5000);


    }
}
