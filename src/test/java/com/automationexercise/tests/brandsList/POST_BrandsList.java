package com.automationexercise.tests.brandsList;

import com.automationexercise.tests.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class POST_BrandsList extends TestBase {

    @Test(description = "POST To All Brands List", retryAnalyzer = TestBase.class)
    public void postBrandsList() {
        Response postBrandsList = automationExerciseWebService.postBrandsList();
        assertThat(postBrandsList.getStatusCode(), equalTo(200));
        assertThat(postBrandsList.jsonPath().getInt("responseCode"), equalTo(405));
        assertThat(postBrandsList.jsonPath().getString("message"), containsString("This request method is not supported."));
    }
}
