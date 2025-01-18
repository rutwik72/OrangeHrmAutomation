package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PimPage {

    WebDriver driver;

    public PimPage(WebDriver driver) {
        this.driver = driver;
    }

    private By AddButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");

    //--------------------------------------------------------------------------------------------------------------------------
    private By Firstname = By.xpath("//input[@placeholder='First Name']");
    private By lastname = By.xpath("//input[@placeholder='Last Name']");
    private By savebutton = By.xpath("//button[@type='submit']");

    //------------------------------------------------------------------------------------------------------------------------
    private By addedName = By.xpath("//h6[@class='oxd-text oxd-text--h6 --strong']");
    private By employeelistbutton = By.xpath("//a[normalize-space()='Employee List']");

    //-----------------------------------------------------search----------------------------------------------------------------------
    private By namesearchbox= By.xpath("(//input[@placeholder='Type for hints...'])[1]");
    private By idsearchbox= By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private  By searchemployeebutton=By.xpath("//button[@type='submit']");


    public String AddNewEmployee(String firstname, String lastnameofemployee) throws InterruptedException {
        driver.findElement(AddButton).click();
        driver.findElement(Firstname).sendKeys(firstname);
        driver.findElement(lastname).sendKeys(lastnameofemployee);
        Thread.sleep(3000);
        driver.findElement(savebutton).click();

        Thread.sleep(8000);

        String actualname = driver.findElement(addedName).getText();
        return actualname;
    }

    public void ClickOnEmployeelist() {

        driver.findElement(employeelistbutton).click();

    }

    public void searchForEmployeeWithName(String name){

        driver.findElement(namesearchbox).sendKeys(name);

        driver.findElement(searchemployeebutton).click();

    }


}
