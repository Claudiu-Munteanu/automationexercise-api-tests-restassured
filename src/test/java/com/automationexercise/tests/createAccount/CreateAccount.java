package com.automationexercise.tests.createAccount;

import com.automationexercise.tests.TestBase;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Feature("Create Account API")
public class CreateAccount extends TestBase {
    public static final String name = "ThisIsAName";
    public static final String email = "thisisa@mail.test";
    public static final String password = "ThisIsAPassword";
    public static String title;
    public static String birth_day;
    public static String birth_month;
    public static String birth_year;
    public static final String firstname = "John";
    public static final String lastname = "Doe";
    public static final String company = "ThisIsACompany";
    public static final String address1 = "Strada Izvor 2-4";
    public static final String address2 = "Bucharest";
    public static final String country = "Romania";
    public static final String zipcode = "123456";
    public static final String state = "Bucharest";
    public static final String city = "Bucharest";
    public static final String mobile_number = "+40712345678";

    @Test(description = "POST To Create/Register User Account", retryAnalyzer = TestBase.class)
    public void postCreateAccount() {

            Random random = new Random();
            String[] titles = {"Mr", "Mrs", "Ms"};
            title = titles[random.nextInt(titles.length)];
            int daysInMonth = 31;
            birth_day = String.valueOf(random.nextInt(daysInMonth));
            int months = 12;
            birth_month = String.valueOf(random.nextInt(months));
            birth_year = String.valueOf(ThreadLocalRandom.current()
                    .nextInt(1990, 2000 + 1));

        Response postCreateAccount = automationExerciseWebService.postCreateAccount(
                name,
                email,
                password,
                title,
                birth_day,
                birth_month,
                birth_year,
                firstname,
                lastname,
                company,
                address1,
                address2,
                country,
                zipcode,
                state,
                city,
                mobile_number);
        assertThat(postCreateAccount.getStatusCode(), equalTo(200));
        assertThat(postCreateAccount.jsonPath().getInt("responseCode"), equalTo(201));
        assertThat(postCreateAccount.jsonPath().getString("message"), equalTo("User created!"));
    }
}