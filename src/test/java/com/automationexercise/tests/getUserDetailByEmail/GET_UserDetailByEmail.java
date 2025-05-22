package com.automationexercise.tests.getUserDetailByEmail;

import com.automationexercise.tests.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GET_UserDetailByEmail extends TestBase {

    @Test(description = "GET user account detail by email", retryAnalyzer = TestBase.class)
    public void getUserDetailByEmail() {
        Response getUserDetailByEmail = automationExerciseWebService.getUserDetailByEmail("thisisa@mail.test");
        assertThat(getUserDetailByEmail.getStatusCode(), equalTo(200));
        assertThat(getUserDetailByEmail.jsonPath().getInt("responseCode"), equalTo(200));
//        assertThat(getUserDetailByEmail.jsonPath().getString("products"), allOf(
//                containsStringIgnoringCase("id"),
//                containsStringIgnoringCase("name"),
//                containsStringIgnoringCase("price"),
//                containsStringIgnoringCase("brand"),
//                containsStringIgnoringCase("category")));
    }
}
