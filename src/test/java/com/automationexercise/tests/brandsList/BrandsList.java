package com.automationexercise.tests.brandsList;

import com.automationexercise.tests.TestBase;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Feature("Brands List API")
public class BrandsList extends TestBase {

    @Test(description = "Get All Brands List", retryAnalyzer = TestBase.class)
    public void getBrandsList() {
        Response getBrandsList = automationExerciseWebService.getBrandsList();
        assertThat(getBrandsList.getStatusCode(), equalTo(200));
        assertThat(getBrandsList.jsonPath().getInt("responseCode"), equalTo(200));
        assertThat(getBrandsList.jsonPath().getString("brands"), allOf(
                containsStringIgnoringCase("id"),
                containsStringIgnoringCase("brand")));
    }

    @Test(description = "POST To All Brands List", retryAnalyzer = TestBase.class)
    public void postBrandsList() {
        Response postBrandsList = automationExerciseWebService.postBrandsList();
        assertThat(postBrandsList.getStatusCode(), equalTo(200));
        assertThat(postBrandsList.jsonPath().getInt("responseCode"), equalTo(405));
        assertThat(postBrandsList.jsonPath().getString("message"), equalTo("This request method is not supported."));
    }
}
