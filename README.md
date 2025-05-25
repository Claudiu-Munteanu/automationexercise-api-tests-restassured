<h1 align="center">AutomationExercise API Test Suite</h1>

<p align="center">
  <a href="https://github.com/Claudiu-Munteanu/automationexercise-api-tests-restassured-testng-java/actions/workflows/ci.yml">
    <img src="https://github.com/Claudiu-Munteanu/automationexercise-api-tests-restassured-testng-java/actions/workflows/ci.yml/badge.svg" alt="CI" width="250"/>
  </a>
</p>
<p align="center">
  <a href="https://claudiu-munteanu.github.io/automationexercise-api-tests-restassured-testng-java/">
    <img src="https://img.shields.io/badge/Allure_Report:-Click Here-4e7eff?logo=allure&logoColor=white" alt="Allure Report" width="275"/>
  </a>
</p>

This repository contains a **demo API test automation project** created for **showcasing my skills** in writing and organizing automated API tests using:

- **Java**
- **Rest Assured**
- **TestNG**
- **Allure Reports**

The tests target the publicly accessible APIs at [Automation Exercise](https://automationexercise.com/api_list), a site that offers dummy endpoints for practice and testing purposes.

> ⚠️ This is a portfolio project, not intended for production use.  
> Its purpose is to demonstrate practical knowledge of API testing tools, frameworks, and best practices.

## 🛠️ Tech Stack

| Tool            | Purpose                                |
|-----------------|----------------------------------------|
| Java            | Main programming language              |
| Maven           | Build and dependency management        |
| Rest Assured    | API test framework                     |
| TestNG          | Test runner and assertion management   |
| Allure Reports  | Test reporting and visualization       |
| IntelliJ IDEA   | Development environment                |

## 📁 Project Structure

```
src/
├── test/
│   ├── java/
│   │   └── com.automationexercise/
│   │       ├── tests/
│   │       │   ├── test_group#1/
│   │       │   │   └── ApiTest#1.java
│   │       │   │
│   │       │   └── test_group#2/
│   │       │       └── ApiTest#2.java
│   │       │   .......................
│   │       │
│   │       ├── utils/
│   │       │   └── RetryConfiguration.java
│   │       │
│   │       └── WebService.java
│   │
│   └── resources/
│       ├── configs/
│       │   └── app.properties
│       │
│       └── runners/
│           └── TestNG_AllApiTests.xml
│       
├── pom.xml
└── README.md
```

## ✅ API Endpoints & Test Coverage

**Base URL**: `https://automationexercise.com/api/`

| #  | Endpoint                | HTTP Method | Params/Body                                                                                                                                                                                       | Success Code | Error Code | Response                                                               |
|----|------------------------|-------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------|------------|------------------------------------------------------------------------|
| 1  | `productsList`         | GET         | —                                                                                                                                                                                                 | 200          | —          | All products list (JSON)                                               |
| 2  | `productsList`         | POST        | —                                                                                                                                                                                                 | —            | 405        | `This request method is not supported.`                                |
| 3  | `brandsList`           | GET         | —                                                                                                                                                                                                 | 200          | —          | All brands list (JSON)                                                 |
| 4  | `brandsList`           | PUT         | —                                                                                                                                                                                                 | —            | 405        | `This request method is not supported.`                                |
| 5  | `searchProduct`        | POST        | `search_product`                                                                                                                                                                                  | 200          | —          | Searched products list (JSON)                                          |
| 6  | `searchProduct`        | POST        | No `search_product`                                                                                                                                                                               | —            | 400        | `Bad request, search_product parameter is missing in POST request.`    |
| 7  | `verifyLogin`          | POST        | `email`, `password`                                                                                                                                                                               | 200          | —          | `User exists!`                                                         |
| 8  | `verifyLogin`          | POST        | No `email`                                                                                                                                                                                        | —            | 400        | `Bad request, email or password parameter is missing in POST request.` |
| 9  | `verifyLogin`          | DELETE      | —                                                                                                                                                                                                 | —            | 405        | `This request method is not supported.`                                |
| 10 | `verifyLogin`          | POST        | Invalid `email`, `password`                                                                                                                                                                       | —            | 404        | `User not found!`                                                      |
| 11 | `createAccount`        | POST        | `name`, `email`, `password`, `title`, `birth_date`, `birth_month`, `birth_year`, `firstname`, `lastname`, `company`, `address1`, `address2`, `country`, `zipcode`, `state`, `city`, `mobile_number` | 201          | —          | `User created!`                                                        |
| 12 | `deleteAccount`        | DELETE      | `email`, `password`                                                                                                                                                                               | 200          | —          | `Account deleted!`                                                     |
| 13 | `updateAccount`        | PUT         | `name`, `email`, `password`, `title`, `birth_date`, `birth_month`, `birth_year`, `firstname`, `lastname`, `company`, `address1`, `address2`, `country`, `zipcode`, `state`, `city`, `mobile_number` | 200          | —          | `User updated!`                                                          |
| 14 | `getUserDetailByEmail` | GET         | `email`                                                                                                                                                                                           | 200          | —          | User detail (JSON)                                                     |

## ▶️ How to Run the Tests

There are two main ways to see these tests in action:

### 1. Run in GitHub Actions (Recommended)
- **Fork** this repository to your own GitHub account.
- Go to the **Actions** tab in your fork.
- Select the **test-run** workflow and click **Run workflow**.
- Once complete, you can review logs and view the Allure Report (https://<YOUR-USERNAME>.github.io/automationexercise-api-tests-restassured-testng-java/) if published.

### 2. Run Locally
- Clone this repository.
- Make sure you have **Java 17** and **Maven** installed.
- Run the tests:
  ```sh
  mvn clean test -DsuiteXmlFile=src/test/resources/runners/TestNG_AllApiTests.xml
  ```
- (Optional) To generate a report, install Allure CLI and run:
  ```sh
  npm install -g allure-commandline --unsafe-perm=true
  allure generate allure-results --clean -o allure-report
  allure open allure-report
  ```