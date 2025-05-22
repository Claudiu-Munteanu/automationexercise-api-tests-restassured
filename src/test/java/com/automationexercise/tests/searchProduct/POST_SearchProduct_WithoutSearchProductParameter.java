package com.automationexercise.tests.searchProduct;

import com.automationexercise.tests.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class POST_SearchProduct_WithoutSearchProductParameter extends TestBase {

    @Test(description = "POST To Search Product without search_product parameter", retryAnalyzer = TestBase.class)
    public void postSearchProduct_WithoutSearchProductParameter_WithoutSearchProductParameter() {
        Response postSearchProduct_WithoutSearchProductParameter = automationExerciseWebService.postSearchProduct_WithoutSearchProductParameter();
        assertThat(postSearchProduct_WithoutSearchProductParameter.getStatusCode(), equalTo(200));
        assertThat(postSearchProduct_WithoutSearchProductParameter.jsonPath().getInt("responseCode"), equalTo(400));
        assertThat(postSearchProduct_WithoutSearchProductParameter.jsonPath().getString("message"), containsString("Bad request, search_product parameter is missing in POST request."));
    }
}
