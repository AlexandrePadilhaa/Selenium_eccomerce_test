# Ecommerce Automation Project

This project automates a series of actions for an ecommerce platform using Selenium WebDriver and Java. The test case simulates a user interacting with the shopping site, including adding products to the cart, checking out, and verifying the completion of the checkout process.

## How to Run

To run the tests in this project, follow these steps:

### 1. Clone the repository

Clone the project to your local machine using Git:

git clone https://github.com/AlexandrePadilhaa/Selenium_eccomerce_test.git
### 2. Update Dependencies
Make sure all the required dependencies are up to date. In the project folder, run:

mvn clean install

This will download and install the required dependencies for the project.

### 3. Run Tests
There are two ways to execute the tests:

Using Maven Test:

You can run the tests directly using Maven by executing the following command:


mvn test

Running the Main Class: 

Alternatively, you can run the main test class EcommerceTest.java directly in your IDE. This class orchestrates the entire test process and serves as the entry point for running the test suite.

# Project Structure
The project follows the Page Object Model (POM) design pattern to organize the code. The folder structure is as follows:

Folder Descriptions
config/: Contains WebDriver setup and configurations for the browser being used for automation.

pages/: Contains classes that represent individual pages of the ecommerce site. Each class handles the interactions and actions for a specific page (e.g., Login, Cart, Checkout).

tests/: Contains the main test class EcommerceTest.java, which executes the entire test case flow from login to checkout completion.

screenshots/: Stores the screenshot of the last page captured during the test execution.

## Comments and Limitations
Due to time constraints and the learning curve associated with new technologies used in this project, the following limitations were encountered:

## Logging System: 
It was not possible to implement a logging system that stores logs in a file. Logs are only output to the console during the execution of the tests.

## Test Timeout Issues:
Some tests may fail when running with mvn test due to timeout errors. Unfortunately, due to time constraints, a solution to this issue could not be implemented.