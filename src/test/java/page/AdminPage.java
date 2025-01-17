package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {

    WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }


    private By adminButton = By.xpath("//span[text()=\"Admin\"]");

    private By adminUserManagementTitle = By.xpath("//h6[text()=\"Admin\"]");

    private By userManagementButton = By.xpath("//span[text()=\"User Management \"]");
    private By userButton = By.xpath("//a[text()=\"Users\"]");
    private By addAdminButton = By.xpath("//button[text()=\" Add \"]");
    private By addUsertext = By.xpath("//h6[text()=\"Add User\"]");


    public String clickOnAdmin() {
        driver.findElement(adminButton).click();
        String AdminUserManagement = driver.findElement(adminUserManagementTitle).getText();
        return AdminUserManagement;
    }

    public void clickOnUserManagement() {
        driver.findElement(userManagementButton).click();
        driver.findElement(userButton).click();
    }

    public String clickOnAddButton(){
        driver.findElement(addAdminButton).click();
       String addUser= driver.findElement(addUsertext).getText();
       return addUser;


    }



}
