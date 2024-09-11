package com.teladoc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddUserPage {
    private WebDriver driver;

    public AddUserPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstNameInput = By.name("FirstName");
    private By lastNameInput = By.name("LastName");
    private By userNameInput = By.name("UserName");
    private By passwordInput = By.name("Password");
    private By customerRadio = By.xpath("//label[text()='Company BBB']/input");
    private By roleDropdown = By.name("RoleId");
    private By emailInput = By.name("Email");
    private By mobilePhoneInput = By.name("Mobilephone");
    private By saveButton = By.xpath("//button[@ng-click='save(user)']");

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterUserName(String userName) {
        driver.findElement(userNameInput).sendKeys(userName);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void selectCustomer() {
        driver.findElement(customerRadio).click();
    }

    public void selectRole(String role) {
        WebElement dropdown = driver.findElement(roleDropdown);
        dropdown.click();
        dropdown.findElement(By.xpath("//option[. = '" + role + "']")).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterMobilePhone(String mobilePhone) {
        driver.findElement(mobilePhoneInput).sendKeys(mobilePhone);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }
}
