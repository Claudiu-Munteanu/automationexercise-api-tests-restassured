<h1 align="center">AutomationExercise API Test Suite</h1>

<p align="center">
  <a href="https://github.com/Claudiu-Munteanu/automationexercise-api-tests-restassured-testng-java/actions/workflows/ci.yml">
    <img src="https://github.com/Claudiu-Munteanu/automationexercise-api-tests-restassured/actions/workflows/ci.yml/badge.svg" alt="CI" width="250"/>
  </a>
</p>
<p align="center">
  <a href="https://claudiu-munteanu.github.io/automationexercise-api-tests-restassured/">
    <img src="https://img.shields.io/badge/Allure_Report:-Click Here-4e7eff?logo=allure&logoColor=white" alt="Allure Report" width="300"/>
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

**Base URL:** `https://automationexercise.com/api/`

<details>
<summary><strong>Get All Products List</strong></summary>

- **Endpoint:** `/productsList`
- **Request Method:** `GET`
- **Response Code:** `200`
- **Response JSON:** All products list
</details>

<details>
<summary><strong>POST To All Products List</strong></summary>

- **Endpoint:** `/productsList`
- **Request Method:** `POST`
- **Response Code:** `405`
- **Response Message:** This request method is not supported.
</details>

<details>
<summary><strong>Get All Brands List</strong></summary>

- **Endpoint:** `/brandsList`
- **Request Method:** `GET`
- **Response Code:** `200`
- **Response JSON:** All brands list
</details>

<details>
<summary><strong>PUT To All Brands List</strong></summary>

- **Endpoint:** `/brandsList`
- **Request Method:** `PUT`
- **Response Code:** `405`
- **Response Message:** This request method is not supported.
</details>

<details>
<summary><strong>POST To Search Product</strong></summary>

- **Endpoint:** `/searchProduct`
- **Request Method:** `POST`
- **Request Parameter:** `search_product` (e.g., `top`, `tshirt`, `jean`)
- **Response Code:** `200`
- **Response JSON:** Searched products list
</details>

<details>
<summary><strong>POST To Search Product without search_product parameter</strong></summary>

- **Endpoint:** `/searchProduct`
- **Request Method:** `POST`
- **Response Code:** `400`
- **Response Message:** Bad request, search_product parameter is missing in POST request.
</details>

<details>
<summary><strong>POST To Verify Login with valid details</strong></summary>

- **Endpoint:** `/verifyLogin`
- **Request Method:** `POST`
- **Request Parameters:** `email`, `password`
- **Response Code:** `200`
- **Response Message:** User exists!
</details>

<details>
<summary><strong>POST To Verify Login without email parameter</strong></summary>

- **Endpoint:** `/verifyLogin`
- **Request Method:** `POST`
- **Request Parameter:** `password`
- **Response Code:** `400`
- **Response Message:** Bad request, email or password parameter is missing in POST request.
</details>

<details>
<summary><strong>DELETE To Verify Login</strong></summary>

- **Endpoint:** `/verifyLogin`
- **Request Method:** `DELETE`
- **Response Code:** `405`
- **Response Message:** This request method is not supported.
</details>

<details>
<summary><strong>POST To Verify Login with invalid details</strong></summary>

- **Endpoint:** `/verifyLogin`
- **Request Method:** `POST`
- **Request Parameters:** `email`, `password` (invalid values)
- **Response Code:** `404`
- **Response Message:** User not found!
</details>

<details>
<summary><strong>POST To Create/Register User Account</strong></summary>

- **Endpoint:** `/createAccount`
- **Request Method:** `POST`
- **Request Parameters:** `name`, `email`, `password`, `title` (e.g., `Mr`, `Mrs`, `Miss`), `birth_date`, `birth_month`, `birth_year`, `firstname`, `lastname`, `company`, `address1`, `address2`, `country`, `zipcode`, `state`, `city`, `mobile_number`
- **Response Code:** `201`
- **Response Message:** User created!
</details>

<details>
<summary><strong>DELETE To Delete User Account</strong></summary>

- **Endpoint:** `/deleteAccount`
- **Request Method:** `DELETE`
- **Request Parameters:** `email`, `password`
- **Response Code:** `200`
- **Response Message:** Account deleted!
</details>

<details>
<summary><strong>PUT To Update User Account</strong></summary>

- **Endpoint:** `/updateAccount`
- **Request Method:** `PUT`
- **Request Parameters:** `name`, `email`, `password`, `title` (e.g., `Mr`, `Mrs`, `Miss`), `birth_date`, `birth_month`, `birth_year`, `firstname`, `lastname`, `company`, `address1`, `address2`, `country`, `zipcode`, `state`, `city`, `mobile_number`
- **Response Code:** `200`
- **Response Message:** User updated!
</details>

<details>
<summary><strong>GET user account detail by email</strong></summary>

- **Endpoint:** `/getUserDetailByEmail`
- **Request Method:** `GET`
- **Request Parameters:** `email`
- **Response Code:** `200`
- **Response JSON:** User Detail
</details>

## ▶️ How to Run the Tests

There are two main ways to see these tests in action:

### 1. Run in GitHub Actions (Recommended)
- **Fork** this repository to your own GitHub account.
- Go to the **Actions** tab in your fork.
- Select the **test-run** workflow and click **Run workflow**.
- Once complete, you can review logs and view the [Allure Report](https://your-username.github.io/automationexercise-api-tests-restassured-testng-java/) if published.

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