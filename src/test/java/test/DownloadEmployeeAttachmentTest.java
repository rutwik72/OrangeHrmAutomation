package test;

import base.Browser;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.PimPage;

public class DownloadEmployeeAttachmentTest extends Browser {

    @Test
    public void downloadEmployeeAttachmentMethod() throws InterruptedException {
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


        Thread.sleep(3000);

        ChromeOptions options = new ChromeOptions();

        pim.downLoadAttachedFile();
        Thread.sleep(3000);

        logger.info("------------------------Download Employee Attachment test is passed------------------");



    }
}