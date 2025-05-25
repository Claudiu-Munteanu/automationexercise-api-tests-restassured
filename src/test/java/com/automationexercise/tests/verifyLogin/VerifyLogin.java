package com.automationexercise.tests.verifyLogin;

import com.automationexercise.tests.TestBase;
import com.automationexercise.tests.createAccount.CreateAccount;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Feature("Verify Login API")
public class VerifyLogin extends TestBase {

    @Test(description = "POST To Verify Login with valid details", retryAnalyzer = TestBase.class)
    public void postVerifyLogin_WithValidDetails() {
        Response updateAccount  = automationExerciseWebService.postVerifyLoginWithEmailAndPassword(
                CreateAccount.email,
                CreateAccount.password);
        assertThat(updateAccount .getStatusCode(), equalTo(200));
        assertThat(updateAccount .jsonPath().getInt("responseCode"), equalTo(200));
        assertThat(updateAccount .jsonPath().getString("message"), equalTo("User exists!"));
    }

    @Test(description = "POST To Verify Login with invalid details", retryAnalyzer = TestBase.class)
    public void postVerifyLogin_WithInvalidDetails() {
        Response updateAccount  = automationExerciseWebService.postVerifyLoginWithEmailAndPassword(
                "invalidEmail",
                "invalidPassword");
        assertThat(updateAccount .getStatusCode(), equalTo(200));
        assertThat(updateAccount .jsonPath().getInt("responseCode"), equalTo(404));
        assertThat(updateAccount .jsonPath().getString("message"), equalTo("User not found!"));
    }

    @Test(description = "POST To Verify Login without email parameter")
    public void postVerifyLogin_WithoutEmailParameter() {
        Response updateAccount  = automationExerciseWebService.postVerifyLoginWithoutEmail(
                CreateAccount.password);
        assertThat(updateAccount .getStatusCode(), equalTo(200));
        assertThat(updateAccount .jsonPath().getInt("responseCode"), equalTo(400));
        assertThat(updateAccount .jsonPath().getString("message"), equalTo("Bad request, email or password parameter is missing in POST request."));
    }

    @Test(description = "DELETE To Verify Login")
    public void deleteVerifyLogin() {
        Response updateAccount  = automationExerciseWebService.deleteVerifyLogin();
        assertThat(updateAccount .getStatusCode(), equalTo(200));
        assertThat(updateAccount .jsonPath().getInt("responseCode"), equalTo(405));
        assertThat(updateAccount .jsonPath().getString("message"), equalTo("This request method is not supported."));
    }
}