package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class PimPage {

    WebDriver driver;

    public PimPage(WebDriver driver) {
        this.driver = driver;
    }

    private By AddButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");

    //--------------------------------------------------------------------------------------------------------------------------
    private By Firstname = By.xpath("//input[@placeholder='First Name']");
    private By lastname = By.xpath("//input[@placeholder='Last Name']");
    private By employeeId =By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");
    private By savebutton = By.xpath("//button[@type='submit']");

    //------------------------------------------------------------------------------------------------------------------------
    private By addedName = By.xpath("//h6[@class='oxd-text oxd-text--h6 --strong']");
    private By employeelistbutton = By.xpath("//a[normalize-space()='Employee List']");

    //-----------------------------------------------------search----------------------------------------------------------------------
    private By namesearchbox = By.xpath("(//input[@placeholder='Type for hints...'])[1]");
    private By idsearchbox = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By searchemployeebutton = By.xpath("//button[@type='submit']");

    //-------------------------------------------------------------------------------------------------------------------------------
    private By addAttachmentEmployeePersonalDetail = By.xpath("//button[text()=\" Add \"]");
    private By browsFileButton = By.xpath("//input[@type='file']");
    private By saveFileButton = By.xpath("(//button[text()=\" Save \"])[3]");
    private By uploadedFileName = By.xpath("//div [text()='Dummy_Doc_cv.pdf']");
    private By downLoadAttachedFileButton = By.xpath("//i[@class='oxd-icon bi-download']");

    //-------------------------------------------------------------------------------------------------------------------

    private By nationalityDropdown = By.xpath("(//div[text()=\"-- Select --\"])[1]");
    private By nationalityList = By.xpath("(//div[@class=\"oxd-select-text-input\"])[1]");
    private By indianNationality = By.xpath("//div[text()=\"Indian\"]");
    private By maritalStatusDropdown = By.xpath("(//div[text()=\"-- Select --\"])[2]");
    private By singleStatus = By.xpath("//div[text()=\"Single\"]");
    private By genderMaleRadioButton = By.xpath("//label[text()=\"Male\"]");
    private By dateOfBirthInput = By.xpath("(//input[@placeholder=\"DD, dd-M-yyyy\"])[2]");
    private By personalDetailsSaveButton = By.xpath("(//button[text()=\" Save \"])[1]");


    public String AddNewEmployee(String firstname, String lastnameofemployee) throws InterruptedException {
        driver.findElement(AddButton).click();
        driver.findElement(Firstname).sendKeys(firstname);
        driver.findElement(lastname).sendKeys(lastnameofemployee);
        driver.findElement(employeeId).clear();

        // Generate a random number between 10000 and 99999 (5-digit number)
        Random random = new Random();
        int randomFiveDigitNumber = random.nextInt(90000) + 10000;
        String empid=String.valueOf(randomFiveDigitNumber);

        driver.findElement(employeeId).sendKeys(empid);

        Thread.sleep(3000);
        driver.findElement(savebutton).click();

        Thread.sleep(8000);

        String actualname = driver.findElement(addedName).getText();
        return actualname;
    }

    public void ClickOnEmployeelist() {

        driver.findElement(employeelistbutton).click();

    }

    public void searchForEmployeeWithName(String name) {

        driver.findElement(namesearchbox).sendKeys(name);

        driver.findElement(searchemployeebutton).click();

    }

    public void scrollToEndOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }


    public void addEmployeeAttachment() throws InterruptedException {
        driver.findElement(addAttachmentEmployeePersonalDetail).click();
        driver.findElement(browsFileButton).sendKeys("D:\\javapro\\OrangeHRM\\src\\test\\resources\\Dummy_Doc_cv.pdf");
        scrollToEndOfPage();
        Thread.sleep(2000);
        driver.findElement(saveFileButton).click();
    }

    public String verifyAttachmentFileUpload() {
        String filename = driver.findElement(uploadedFileName).getText();
        return filename;
    }

    public void downLoadAttachedFile() {
        driver.findElement(downLoadAttachedFileButton).click();
    }

    public void updateEmployeePersonalDetails() throws InterruptedException {

        //Dropdown elements was not having select as input type so didnt use Select class


//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(nationalityDropdown)).click().build().perform(); // Open dropdown
//        actions.moveByOffset(0, 900).perform();
//
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(indianNationality)));
//
//        driver.findElement(indianNationality).click();
//
//
//        driver.findElement(maritalStatusDropdown).click();
//        driver.findElement(singleStatus).click();


        driver.findElement(genderMaleRadioButton).click();

        Thread.sleep(3000);
        if (driver.findElement(genderMaleRadioButton).isSelected()) {
            System.out.println("Gender radio button is selected.");
        } else {
            System.out.println("Gender Radio button is not selected.");
        }

        driver.findElement(dateOfBirthInput).sendKeys("Friday, 27-Feb-1998");
        Thread.sleep(3000);

        driver.findElement(personalDetailsSaveButton).click();


    }


}
