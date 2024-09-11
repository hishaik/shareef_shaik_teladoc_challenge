package com.teladoc.steps;

import com.teladoc.pages.AddUserPage;
import com.teladoc.pages.UserTablePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class UserSteps {
    private WebDriver driver;
    private AddUserPage addUserPage;
    private UserTablePage userTablePage;
    private Properties properties;
    
    public UserSteps() {
        // Load the configuration properties
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            // Load properties from file
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Given("I am on the user management page")
    public void i_am_on_the_user_management_page() {
    	String browser = properties.getProperty("browser");
        String url = properties.getProperty("url");
        
        if ("chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        
        driver.manage().window().maximize();

        // Open the URL
        driver.get(url);

        // Initialize page objects
        addUserPage = new AddUserPage(driver);
        userTablePage = new UserTablePage(driver);
    }

    @When("I add a user with username {string}")
    public void i_add_a_user_with_username(String userName) {
        userTablePage.clickAddButton();
        addUserPage.enterFirstName("Shareef");
        addUserPage.enterLastName("Shaik");
        addUserPage.enterUserName(userName);
        addUserPage.enterPassword("shaik@123");
        addUserPage.selectCustomer();
        addUserPage.selectRole("Customer");
        addUserPage.enterEmail("shareef.shaik@example.com");
        addUserPage.enterMobilePhone("1234567890");
        addUserPage.clickSaveButton();
    }

	@Then("The user with username {string} should be present in the table")
    public void the_user_with_username_should_be_present_in_the_table(String userName) {
        Assert.assertTrue(userTablePage.isUserPresent(userName), "User not found in table");
        driver.close();
    }

    @When("I delete the user with username {string}")
    public void i_delete_the_user_with_username(String userName) {
        userTablePage.deleteUser(userName);
    }

    @Then("The user with username {string} should not be present in the table")
    public void the_user_with_username_should_not_be_present_in_the_table(String userName) {
        Assert.assertFalse(userTablePage.isUserPresent(userName), "User still present in table");
        driver.close();
    }
}

