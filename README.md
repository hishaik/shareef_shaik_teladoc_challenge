# Cucumber Framework for User Management

This project is a Cucumber-based testing framework for managing user operations in a web application. It uses Selenium WebDriver for browser automation and Maven for build and dependency management.


# Table of Contents
1. Project Overview
2. Setup and Installation
3. Configuration
4. Running Tests


# 1. Project Overview
This project includes automated tests for user management functionalities using Cucumber for Behavior-Driven Development (BDD) and Selenium for browser interactions. The framework supports the following:

- Adding and validating new users.
- Deleting users from the system.
- Validating user presence in the table.

# 2. Setup and Installation
Prerequisites
Java JDK 11 or later: Ensure Java is installed and the JAVA_HOME environment variable is set.

Maven: Ensure Maven is installed and added to your system path.

ChromeDriver: Download the ChromeDriver executable and ensure it’s accessible from your system path.

Clone the Repository

git clone https://github.com/hishaik/shareef_shaik_teladoc_challenge.git

cd shareef_shaik_teladoc_challenge

Install Dependencies

Run the following command to install the necessary Maven dependencies:

$ mvn install

# 3. Configuration

Configuration File
Edit the src/main/resources/config.properties file to configure the browser and URL settings:

properties

browser=chrome

url=https://www.way2automation.com/angularjs-protractor/webtables/

# 4. Running Tests
- From Command Line

To run the Cucumber tests, execute the following Maven command:

$ mvn clean test


- Using TestNG XML
To run tests specified in the testng.xml configuration file:

$ mvn test -DsuiteXmlFile=testng.xml

