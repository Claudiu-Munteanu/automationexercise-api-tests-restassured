# automationexercise-api-tests-restassured-testng-java

This repository contains a **demo API test automation project** created for **showcasing my skills** in writing and organizing automated API tests using:

- **Java**
- **Rest Assured**
- **TestNG**
- **Allure Reports**

The tests target the publicly accessible APIs at [Automation Exercise](https://automationexercise.com/api_list), a site that offers dummy endpoints for practice and testing purposes.

> ⚠️ This is a portfolio project, not intended for production use.  
> Its purpose is to demonstrate practical knowledge of API testing tools, frameworks, and best practices.

---

## 🛠️ Tech Stack

| Tool            | Purpose                                |
|-----------------|----------------------------------------|
| Java            | Main programming language              |
| Maven           | Build and dependency management        |
| Rest Assured    | API test framework                     |
| TestNG          | Test runner and assertion management   |
| Allure Reports  | Test reporting and visualization       |
| IntelliJ IDEA   | Development environment                |

---

## 📁 Project Structure

> Work in progress...

---

## ✅ API Endpoints & Test Coverage

Below is a list of all tested APIs from **AutomationExercise** with the expected behavior and request details.

### API 1: Get All Products List
- **API URL**: [https://automationexercise.com/api/productsList](https://automationexercise.com/api/productsList)
- **Request Method**: GET
- **Response Code**: 200
- **Response JSON**: All products list

### API 2: POST To All Products List
- **API URL**: [https://automationexercise.com/api/productsList](https://automationexercise.com/api/productsList)
- **Request Method**: POST
- **Response Code**: 405
- **Response Message**: This request method is not supported.

### API 3: Get All Brands List
- **API URL**: [https://automationexercise.com/api/brandsList](https://automationexercise.com/api/brandsList)
- **Request Method**: GET
- **Response Code**: 200
- **Response JSON**: All brands list

### API 4: PUT To All Brands List
- **API URL**: [https://automationexercise.com/api/brandsList](https://automationexercise.com/api/brandsList)
- **Request Method**: PUT
- **Response Code**: 405
- **Response Message**: This request method is not supported.

### API 5: POST To Search Product
- **API URL**: [https://automationexercise.com/api/searchProduct](https://automationexercise.com/api/searchProduct)
- **Request Method**: POST
- **Request Parameter**: `search_product` (e.g., "top", "tshirt", "jean")
- **Response Code**: 200
- **Response JSON**: Searched products list

### API 6: POST To Search Product without `search_product` Parameter
- **API URL**: [https://automationexercise.com/api/searchProduct](https://automationexercise.com/api/searchProduct)
- **Request Method**: POST
- **Response Code**: 400
- **Response Message**: Bad request, `search_product` parameter is missing in POST request.

### API 7: POST To Verify Login with Valid Details
- **API URL**: [https://automationexercise.com/api/verifyLogin](https://automationexercise.com/api/verifyLogin)
- **Request Method**: POST
- **Request Parameters**: `email`, `password`
- **Response Code**: 200
- **Response Message**: User exists!

### API 8: POST To Verify Login without `email` Parameter
- **API URL**: [https://automationexercise.com/api/verifyLogin](https://automationexercise.com/api/verifyLogin)
- **Request Method**: POST
- **Request Parameter**: `password`
- **Response Code**: 400
- **Response Message**: Bad request, `email` or `password` parameter is missing in POST request.

### API 9: DELETE To Verify Login
- **API URL**: [https://automationexercise.com/api/verifyLogin](https://automationexercise.com/api/verifyLogin)
- **Request Method**: DELETE
- **Response Code**: 405
- **Response Message**: This request method is not supported.

### API 10: POST To Verify Login with Invalid Details
- **API URL**: [https://automationexercise.com/api/verifyLogin](https://automationexercise.com/api/verifyLogin)
- **Request Method**: POST
- **Request Parameters**: `email`, `password` (invalid values)
- **Response Code**: 404
- **Response Message**: User not found!

### API 11: POST To Create/Register User Account
- **API URL**: [https://automationexercise.com/api/createAccount](https://automationexercise.com/api/createAccount)
- **Request Method**: POST
- **Request Parameters**: `name`, `email`, `password`, `title`, `birth_date`, `birth_month`, `birth_year`, `firstname`, `lastname`, `company`, `address1`, `address2`, `country`, `zipcode`, `state`, `city`, `mobile_number`
- **Response Code**: 201
- **Response Message**: User created!

### API 12: DELETE METHOD To Delete User Account
- **API URL**: [https://automationexercise.com/api/deleteAccount](https://automationexercise.com/api/deleteAccount)
- **Request Method**: DELETE
- **Request Parameters**: `email`, `password`
- **Response Code**: 200
- **Response Message**: Account deleted!

### API 13: PUT METHOD To Update User Account
- **API URL**: [https://automationexercise.com/api/updateAccount](https://automationexercise.com/api/updateAccount)
- **Request Method**: PUT
- **Request Parameters**: `name`, `email`, `password`, `title`, `birth_date`, `birth_month`, `birth_year`, `firstname`, `lastname`, `company`, `address1`, `address2`, `country`, `zipcode`, `state`, `city`, `mobile_number`
- **Response Code**: 200
- **Response Message**: User updated!

### API 14: GET User Account Detail by Email
- **API URL**: [https://automationexercise.com/api/getUserDetailByEmail](https://automationexercise.com/api/getUserDetailByEmail)
- **Request Method**: GET
- **Request Parameters**: `email`
- **Response Code**: 200
- **Response JSON**: User detail

---

## ▶️ How to Run the Tests

> Work in progress...
