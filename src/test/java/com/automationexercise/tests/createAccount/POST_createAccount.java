package com.automationexercise.tests.createAccount;

import com.automationexercise.tests.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class POST_createAccount extends TestBase {

    @Test(description = "POST To Create/Register User Account", retryAnalyzer = TestBase.class)
    public void postCreateAccount() {
        Random random = new Random();
        String[] titles = {"Mr", "Mrs", "Ms"};
        String title = titles[random.nextInt(titles.length)];
        int daysInMonth = 31;
        String birth_date = String.valueOf(random.nextInt(daysInMonth));
        System.out.println("Birth date: " + birth_date);
        int months = 12;
        String birth_month = String.valueOf(random.nextInt(months));
        System.out.println("Birth month: " + birth_month);
        String birth_year = String.valueOf(ThreadLocalRandom.current()
                .nextInt(1990, 2000 + 1));


        Response postCreateAccount = automationExerciseWebService.postCreateAccount(
                "ThisIsAName",
                "thisisa@mail.test",
                "ThisIsAPassword",
                title,
                birth_date,
                birth_month,
                birth_year,
                "John",
                "Doe",
                "ThisIsACompany",
                "Strada Izvor 2-4",
                "Bucharest",
                "Romania",
                "123456",
                "Bucharest",
                "Bucharest",
                "+40712345678");
        assertThat(postCreateAccount.getStatusCode(), equalTo(200));
        assertThat(postCreateAccount.jsonPath().getInt("responseCode"), equalTo(201));
        assertThat(postCreateAccount.jsonPath().getString("message"), containsString("User created!"));
    }
}