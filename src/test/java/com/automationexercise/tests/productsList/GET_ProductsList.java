package com.automationexercise.tests.productsList;

import com.automationexercise.tests.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GET_ProductsList extends TestBase {

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
}
