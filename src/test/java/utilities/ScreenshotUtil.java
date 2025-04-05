package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName){

        String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
        String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + testName + "_" + timestamp + ".png";

        TakesScreenshot ts = (TakesScreenshot) driver;                                 //casting 'TakesScreenshot' is interface
        File src = ts.getScreenshotAs(OutputType.FILE);                              // taking screenshot

        try {
            FileHandler.copy(src, new File(screenshotPath));                     //Copying to respective folder
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
}
