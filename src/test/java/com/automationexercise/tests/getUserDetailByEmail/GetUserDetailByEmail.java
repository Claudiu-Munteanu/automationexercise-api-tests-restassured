package com.automationexercise.tests.getUserDetailByEmail;

import com.automationexercise.tests.TestBase;
import com.automationexercise.tests.createAccount.CreateAccount;
import com.automationexercise.tests.updateAccount.UpdateAccount;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Feature("Get User Detail By Email API")
public class GetUserDetailByEmail extends TestBase {

    @Test(description = "GET user account detail by email", retryAnalyzer = TestBase.class)
    public void getUserDetailByEmail() {
        Response getUserDetailByEmail = automationExerciseWebService.getUserDetailByEmail("thisisa@mail.test");
        assertThat(getUserDetailByEmail.getStatusCode(), equalTo(200));
        assertThat(getUserDetailByEmail.jsonPath().getInt("responseCode"), equalTo(200));
        assertThat(getUserDetailByEmail.jsonPath().getString("user"), allOf(
                containsStringIgnoringCase("name:" + UpdateAccount.updated_name),
                containsStringIgnoringCase("email:" + CreateAccount.email),
                containsStringIgnoringCase("title:"    + UpdateAccount.updated_tile),
                containsStringIgnoringCase("birth_day:"  + UpdateAccount.updated_birth_day),
                containsStringIgnoringCase("birth_month:" + UpdateAccount.updated_birth_month),
                containsStringIgnoringCase("birth_year:"  + UpdateAccount.updated_birth_year),
                containsStringIgnoringCase("first_name:" + UpdateAccount.updated_firstname),
                containsStringIgnoringCase("last_name:"  + UpdateAccount.updated_lastname),
                containsStringIgnoringCase("company:"   + UpdateAccount.updated_company),
                containsStringIgnoringCase("address1:"  + UpdateAccount.updated_address1),
                containsStringIgnoringCase("address2:"  + UpdateAccount.updated_address2),
                containsStringIgnoringCase("country:"   + UpdateAccount.updated_country),
                containsStringIgnoringCase("zipcode:"   + UpdateAccount.updated_zipcode),
                containsStringIgnoringCase("state:"     + UpdateAccount.updated_state),
                containsStringIgnoringCase("city:"      + UpdateAccount.updated_city)));
    }
}
