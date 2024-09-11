package com.teladoc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UserTablePage {
    private WebDriver driver;

    public UserTablePage(WebDriver driver) {
        this.driver = driver;
    }

    private By addButton = By.xpath("//button[@ng-click='pop()']");
    private By userTableRows = By.xpath("//table/tbody/tr");
    private By deleteButton = By.xpath(".//button[@ng-click='delUser()']");
    private By confirmationDialogButton = By.xpath("//button[text()='OK']");

    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public void deleteUser(String userName) {
        List<WebElement> rows = driver.findElements(userTableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(userName)) {
                // Click delete button in the row
                row.findElement(deleteButton).click();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
                wait.until(ExpectedConditions.elementToBeClickable(confirmationDialogButton));
                // Confirm deletion
                driver.findElement(confirmationDialogButton).click();
                break;
            }
        }
    }

    public boolean isUserPresent(String userName) {
        List<WebElement> rows = driver.findElements(userTableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(userName)) {
                return true;
            }
        }
        return false;
    }
}
