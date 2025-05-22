package com.automationexercise.tests.productsList;

import com.automationexercise.tests.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class POST_ProductsList extends TestBase {

    @Test(description = "POST To All Products List", retryAnalyzer = TestBase.class)
    public void postProductsList() {
        Response postProductsList = automationExerciseWebService.postProductsList();
        assertThat(postProductsList.getStatusCode(), equalTo(200));
        assertThat(postProductsList.jsonPath().getInt("responseCode"), equalTo(405));
        assertThat(postProductsList.jsonPath().getString("message"), containsString("This request method is not supported."));
    }
}
