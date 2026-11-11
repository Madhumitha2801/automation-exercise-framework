
# Automation Exercise – UI & API Automation Framework

A beginner-friendly test automation project built using Java, Selenium WebDriver, TestNG, Maven, Postman, Newman, Jenkins, and Allure Reports.

This project demonstrates UI and API automation integrated into a Jenkins CI/CD pipeline.

## Project Overview

This framework includes:

- UI automation using Selenium WebDriver and Java.
- Test execution using TestNG.
- Page Object Model (POM) design pattern.
- API automation using Postman collections.
- API test execution using Newman.
- CI/CD integration using Jenkins.
- Test reporting using Allure Reports.


## Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Selenium WebDriver | UI automation |
| TestNG | Test execution and assertions |
| Maven | Build and dependency management |
| Page Object Model | Framework design pattern |
| Postman | API testing and collection management |
| Newman | Command-line API test execution |
| Jenkins | CI/CD pipeline |
| Allure Reports | Test execution reporting |
| Git & GitHub | Version control and source code management |


## UI Automation Features

The Selenium automation framework covers the following scenarios:

- Search for products.
- Add products to the shopping cart.
- Verify cart details.
- User login functionality.
- New user signup functionality.

### UI Automation Framework Highlights

- Page Object Model (POM) implementation.
- Reusable page classes and methods.
- Explicit waits for synchronization.
- TestNG annotations for test execution.
- Browser setup and teardown using BaseTest.
- Automated test execution using Maven.


## UI Automation Features

The Selenium automation framework covers the following scenarios:

- Search for products.
- Add products to the shopping cart.
- Verify cart details.
- User login functionality.
- New user signup functionality.

### Framework Highlights

- Page Object Model (POM) implementation.
- Reusable page classes and methods.
- Explicit waits for synchronization.
- TestNG annotations for test execution.
- Browser setup and teardown using BaseTest.
- Automated test execution using Maven.

## API Automation Features

API testing is performed using Postman and Newman with the Restful Booker API.

The collection covers the following scenarios:

- Get all bookings.
- Create a new booking.
- Retrieve the created booking.
- Generate an authentication token.
- Update an existing booking.
- Delete a booking.

### API Testing Highlights

- Request and response validation.
- Status code verification.
- JSON response assertions.
- Data validation using Postman test scripts.
- Command-line execution using Newman.
- Integration with the Jenkins pipeline.

## Jenkins CI/CD Pipeline

The project is integrated with Jenkins to execute UI and API automation tests automatically.

### Pipeline Stages

1. Checkout source code from GitHub.
2. Compile the Java project using Maven.
3. Execute Selenium UI tests using TestNG.
4. Install Newman dependencies using npm.
5. Execute API tests using Newman.
6. Generate and publish Allure test reports.
7. Archive test results and reports in Jenkins.

### Pipeline Benefits

- Automated execution of UI and API tests.
- Centralized test reporting.
- Easy identification of test failures.
- Continuous integration using Jenkins.
