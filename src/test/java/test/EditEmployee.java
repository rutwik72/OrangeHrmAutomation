package test;

import base.Browser;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.PimPage;

public class EditEmployee extends Browser {

    @Test
    public void editEmployeeData() throws InterruptedException {
        LoginPage loginpageobj = new LoginPage(driver);
        HomePage homepageobj= new HomePage(driver);


        loginpageobj.Login();
        Thread.sleep(5000);
        homepageobj.ClickOnPim();

        PimPage pimobj= new PimPage(driver);
        String actualname= pimobj.AddNewEmployee("Rutwik","Kulkarni");
        System.out.println(actualname);

        Thread.sleep(5000);

        pimobj.ClickOnEmployeelist();

        String empid= "";
        pimobj.searchforemployee(actualname,empid);

        Thread.sleep(5000);






    }
}
