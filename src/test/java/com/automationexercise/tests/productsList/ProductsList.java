package com.automationexercise.tests.productsList;

import com.automationexercise.tests.TestBase;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Feature("Products List API")
public class ProductsList extends TestBase {

    @Test(description = "Get All Products List", retryAnalyzer = TestBase.class)
    public void getProductsList() {
        Response getProductsList = automationExerciseWebService.getProductsList();
        assertThat(getProductsList.getStatusCode(), equalTo(200));
        assertThat(getProductsList.jsonPath().getInt("responseCode"), equalTo(200));
        assertThat(getProductsList.jsonPath().getString("products"), allOf(
                containsStringIgnoringCase("id"),
                containsStringIgnoringCase("name"),
                containsStringIgnoringCase("price"),
                containsStringIgnoringCase("brand"),
                containsStringIgnoringCase("category")));
    }

    @Test(description = "POST To All Products List", retryAnalyzer = TestBase.class)
    public void postProductsList() {
        Response postProductsList = automationExerciseWebService.postProductsList();
        assertThat(postProductsList.getStatusCode(), equalTo(200));
        assertThat(postProductsList.jsonPath().getInt("responseCode"), equalTo(405));
        assertThat(postProductsList.jsonPath().getString("message"), equalTo("This request method is not supported."));
    }
}
