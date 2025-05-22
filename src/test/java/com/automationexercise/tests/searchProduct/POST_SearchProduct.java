package com.automationexercise.tests.searchProduct;

import com.automationexercise.tests.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class POST_SearchProduct extends TestBase {

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
}
