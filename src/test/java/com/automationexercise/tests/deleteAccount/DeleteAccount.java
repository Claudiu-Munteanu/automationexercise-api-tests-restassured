package com.automationexercise.tests.deleteAccount;

import com.automationexercise.tests.TestBase;
import com.automationexercise.tests.createAccount.CreateAccount;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteAccount extends TestBase {

    @Test(description = "DELETE METHOD To Delete User Account", retryAnalyzer = TestBase.class)
    public void deleteAccount() {
        Response deleteAccount = automationExerciseWebService.deleteAccount(
                CreateAccount.email,
                CreateAccount.password);
        assertThat(deleteAccount.getStatusCode(), equalTo(200));
        assertThat(deleteAccount.jsonPath().getInt("responseCode"), equalTo(200));
        assertThat(deleteAccount.jsonPath().getString("message"), equalTo("Account deleted!"));
    }
}