package com.automationexercise;

import com.automationexercise.tests.TestBase;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

@Getter
@Setter
public class AutomationExerciseWebService {
    private static final Logger logger = LogManager.getLogger();
    private static final AllureRestAssured allureRestAssured = new AllureRestAssured();

    private AutomationExerciseWebService() {}
    public static AutomationExerciseWebService getInstance() {
        return new AutomationExerciseWebService();
    }

    public Response getProductsList() {
        RequestSpecification requestSpecification = given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.urlEncodingEnabled(false);
        return automationExerciseApiRequestWithoutAuthorization("productsList", Method.GET, requestSpecification)
                .then().extract().response();
    }

    public Response postProductsList() {
        RequestSpecification requestSpecification = given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.urlEncodingEnabled(false);
        return automationExerciseApiRequestWithoutAuthorization("productsList", Method.POST, requestSpecification)
                .then().extract().response();
    }

    public Response getBrandsList() {
        RequestSpecification requestSpecification = given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.urlEncodingEnabled(false);
        return automationExerciseApiRequestWithoutAuthorization("brandsList", Method.GET, requestSpecification)
                .then().extract().response();
    }

    public Response postBrandsList() {
        RequestSpecification requestSpecification = given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.urlEncodingEnabled(false);
        return automationExerciseApiRequestWithoutAuthorization("brandsList", Method.POST, requestSpecification)
                .then().extract().response();
    }

    public Response postSearchProduct(String searchProduct) {
        RequestSpecification requestSpecification = given();
        requestSpecification.contentType(ContentType.MULTIPART);
        requestSpecification.urlEncodingEnabled(false);
        requestSpecification.multiPart("search_product", searchProduct);
        return automationExerciseApiRequestWithoutAuthorization("searchProduct", Method.POST, requestSpecification)
                .then().extract().response();
    }

    public Response postSearchProduct_WithoutSearchProductParameter() {
        RequestSpecification requestSpecification = given();
        requestSpecification.contentType(ContentType.MULTIPART);
        requestSpecification.urlEncodingEnabled(false);
        return automationExerciseApiRequestWithoutAuthorization("searchProduct", Method.POST, requestSpecification)
                .then().extract().response();
    }

    public Response postCreateAccount(String name, String email, String password, String title, String birth_date, String birth_month, String birth_year,
                                      String firstname, String lastname, String company, String address1, String address2, String country, String zipcode, String state,
                                      String city, String mobile_number) {
        RequestSpecification requestSpecification = given();
        requestSpecification.contentType(ContentType.MULTIPART);
        requestSpecification.urlEncodingEnabled(false);
        requestSpecification.multiPart("name", name);
        requestSpecification.multiPart("email", email);
        requestSpecification.multiPart("password", password);
        requestSpecification.multiPart("title", title);
        requestSpecification.multiPart("birth_date", birth_date);
        requestSpecification.multiPart("birth_month", birth_month);
        requestSpecification.multiPart("birth_year", birth_year);
        requestSpecification.multiPart("firstname", firstname);
        requestSpecification.multiPart("lastname", lastname);
        requestSpecification.multiPart("company", company);
        requestSpecification.multiPart("address1", address1);
        requestSpecification.multiPart("address2", address2);
        requestSpecification.multiPart("country", country);
        requestSpecification.multiPart("zipcode", zipcode);
        requestSpecification.multiPart("state", state);
        requestSpecification.multiPart("city", city);
        requestSpecification.multiPart("mobile_number", mobile_number);
        return automationExerciseApiRequestWithoutAuthorization("createAccount", Method.POST, requestSpecification)
                .then().extract().response();
    }

    public Response getUserDetailByEmail(String email) {
        RequestSpecification requestSpecification = given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.urlEncodingEnabled(false);
        requestSpecification.queryParam("email", email);
        return automationExerciseApiRequestWithoutAuthorization("getUserDetailByEmail", Method.GET, requestSpecification)
                .then().extract().response();
    }

    public Response deleteAccount(String email, String password) {
        RequestSpecification requestSpecification = given();
        requestSpecification.contentType(ContentType.MULTIPART);
        requestSpecification.urlEncodingEnabled(false);
        requestSpecification.multiPart("email", email);
        requestSpecification.multiPart("password", password);
        return automationExerciseApiRequestWithoutAuthorization("deleteAccount", Method.DELETE, requestSpecification)
                .then().extract().response();
    }

    public Response putUpdateAccount(String name, String email, String password, String title, String birth_date, String birth_month, String birth_year,
                                     String firstname, String lastname, String company, String address1, String address2, String country, String zipcode, String state,
                                     String city, String mobile_number) {
        RequestSpecification requestSpecification = given();
        requestSpecification.contentType(ContentType.MULTIPART);
        requestSpecification.urlEncodingEnabled(false);
        requestSpecification.multiPart("name", name);
        requestSpecification.multiPart("email", email);
        requestSpecification.multiPart("password", password);
        requestSpecification.multiPart("title", title);
        requestSpecification.multiPart("birth_date", birth_date);
        requestSpecification.multiPart("birth_month", birth_month);
        requestSpecification.multiPart("birth_year", birth_year);
        requestSpecification.multiPart("firstname", firstname);
        requestSpecification.multiPart("lastname", lastname);
        requestSpecification.multiPart("company", company);
        requestSpecification.multiPart("address1", address1);
        requestSpecification.multiPart("address2", address2);
        requestSpecification.multiPart("country", country);
        requestSpecification.multiPart("zipcode", zipcode);
        requestSpecification.multiPart("state", state);
        requestSpecification.multiPart("city", city);
        requestSpecification.multiPart("mobile_number", mobile_number);
        return automationExerciseApiRequestWithoutAuthorization("updateAccount", Method.PUT, requestSpecification)
                .then().extract().response();
    }

    public Response postVerifyLoginWithEmailAndPassword(String email, String password) {
        RequestSpecification requestSpecification = given();
        requestSpecification.contentType(ContentType.MULTIPART);
        requestSpecification.urlEncodingEnabled(false);
        requestSpecification.multiPart("email", email);
        requestSpecification.multiPart("password", password);
        return automationExerciseApiRequestWithoutAuthorization("verifyLogin", Method.POST, requestSpecification)
                .then().extract().response();
    }

    public Response postVerifyLoginWithoutEmail(String password) {
        RequestSpecification requestSpecification = given();
        requestSpecification.contentType(ContentType.MULTIPART);
        requestSpecification.urlEncodingEnabled(false);
        requestSpecification.multiPart("password", password);
        return automationExerciseApiRequestWithoutAuthorization("verifyLogin", Method.POST, requestSpecification)
                .then().extract().response();
    }

    public Response deleteVerifyLogin() {
        RequestSpecification requestSpecification = given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.urlEncodingEnabled(false);
        return automationExerciseApiRequestWithoutAuthorization("verifyLogin", Method.DELETE, requestSpecification)
                .then().extract().response();
    }


    private Response automationExerciseApiRequestWithoutAuthorization(String methodName, Method httpMethod, RequestSpecification requestSpecification) {
        final String automationExerciseApiBaseUri = TestBase.automationExerciseApiUrl;
        logger.info("Request base URL: " + automationExerciseApiBaseUri + "/" + methodName);

        return given()
                .filter(allureRestAssured)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .spec(requestSpecification)
                .baseUri(automationExerciseApiBaseUri)
                .when().request(httpMethod, methodName)
                .then().extract().response();
    }
}
