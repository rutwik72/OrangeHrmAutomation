package test;

import base.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.PimPage;

public class UploadEmployeeAttachmentTest extends Browser {

    @Test
    public void uploadEmployeeAttachmentTestMethod() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.Login();

        Thread.sleep(3000);
        HomePage homepg = new HomePage(driver);
        homepg.ClickOnPim();

        Thread.sleep(5000);

        PimPage pim = new PimPage(driver);
        pim.AddNewEmployee("omkar", "mane");

        Thread.sleep(3000);
        pim.scrollToEndOfPage();
        Thread.sleep(3000);
        pim.addEmployeeAttachment();
        Thread.sleep(3000);

        String actualFileName = pim.verifyAttachmentFileUpload();

        String expectedFileName = "Dummy_Doc_cv.pdf";
        Assert.assertEquals(actualFileName, expectedFileName);


    }

}
