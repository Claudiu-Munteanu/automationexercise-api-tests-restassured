package com.automationexercise.tests.brandsList;

import com.automationexercise.tests.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GET_BrandsList extends TestBase {

    @Test(description = "Get All Brands List", retryAnalyzer = TestBase.class)
    public void getBrandsList() {
        Response getBrandsList = automationExerciseWebService.getBrandsList();
        assertThat(getBrandsList.getStatusCode(), equalTo(200));
        assertThat(getBrandsList.jsonPath().getInt("responseCode"), equalTo(200));
        assertThat(getBrandsList.jsonPath().getString("brands"), allOf(
                containsStringIgnoringCase("id"),
                containsStringIgnoringCase("brand")));
    }
}
