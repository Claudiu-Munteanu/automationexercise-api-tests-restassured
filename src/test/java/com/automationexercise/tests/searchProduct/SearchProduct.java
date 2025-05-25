package com.automationexercise.tests.searchProduct;

import com.automationexercise.tests.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchProduct extends TestBase {

    @Test(description = "POST To Search Product", retryAnalyzer = TestBase.class)
    public void postSearchProduct() {
        Random random = new Random();
        String[] product = {"top", "tshirt", "jeans"};
        String searchProduct = product[random.nextInt(product.length)];

        Response postSearchProduct = automationExerciseWebService.postSearchProduct(searchProduct);
        assertThat(postSearchProduct.getStatusCode(), equalTo(200));
        assertThat(postSearchProduct.jsonPath().getInt("responseCode"), equalTo(200));
        assertThat(postSearchProduct.jsonPath().getString("products"), allOf(
                containsStringIgnoringCase("id"),
                containsStringIgnoringCase("name"),
                containsStringIgnoringCase("price"),
                containsStringIgnoringCase("brand"),
                containsStringIgnoringCase("category")));
    }

    @Test(description = "POST To Search Product without search_product parameter", retryAnalyzer = TestBase.class)
    public void postSearchProduct_WithoutSearchProductParameter_WithoutSearchProductParameter() {
        Response postSearchProduct_WithoutSearchProductParameter = automationExerciseWebService.postSearchProduct_WithoutSearchProductParameter();
        assertThat(postSearchProduct_WithoutSearchProductParameter.getStatusCode(), equalTo(200));
        assertThat(postSearchProduct_WithoutSearchProductParameter.jsonPath().getInt("responseCode"), equalTo(400));
        assertThat(postSearchProduct_WithoutSearchProductParameter.jsonPath().getString("message"), equalTo("Bad request, search_product parameter is missing in POST request."));
    }
}
