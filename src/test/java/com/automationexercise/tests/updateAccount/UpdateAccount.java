package com.automationexercise.tests.updateAccount;

import com.automationexercise.tests.TestBase;
import com.automationexercise.tests.createAccount.CreateAccount;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdateAccount extends TestBase {
    private static final Random random = new Random();
    public static final String updated_name = CreateAccount.name + "Updated";
    public static String updated_tile;
    public static String updated_birth_day;
    public static String updated_birth_month;
    public static String updated_birth_year;
    public static final String updated_firstname = CreateAccount.firstname + "Updated";
    public static final String updated_lastname = CreateAccount.lastname + "Updated";
    public static final String updated_company = CreateAccount.company + "Updated";
    public static final String updated_address1 = CreateAccount.address1 + " Updated";
    public static final String updated_address2 = CreateAccount.address2 + " Updated";
    public static final String updated_country = CreateAccount.country + " Updated";
    public static final String updated_zipcode = CreateAccount.zipcode + random.nextInt(9);
    public static final String updated_state = CreateAccount.state + " Updated";
    public static final String updated_city = CreateAccount.city + " Updated";
    public static final String updated_mobile_number = CreateAccount.mobile_number + random.nextInt(9);

    @Test(description = "PUT METHOD To Update User Account", retryAnalyzer = TestBase.class)
    public void putUpdateAccount() {
        updated_tile = "";
        switch (CreateAccount.title) {
            case "Mr": {
                String[] titleOptions = {"Mrs", "Miss"};
                updated_tile = titleOptions[random.nextInt(titleOptions.length)];
                break;
            }
            case "Mrs": {
                String[] titleOptions = {"Mr", "Miss"};
                updated_tile = titleOptions[random.nextInt(titleOptions.length)];
                break;
            }
            case "Miss": {
                String[] titleOptions = {"Mr", "Mrs"};
                updated_tile = titleOptions[random.nextInt(titleOptions.length)];
                break;
            }
        }
        int daysInMonth = 31;
        updated_birth_day = "";
        do {
            updated_birth_day = String.valueOf(random.nextInt(daysInMonth - 1) + 1);
        } while (updated_birth_day.equals(CreateAccount.birth_day));
        int months = 12;
        updated_birth_month = "";
        do {
            updated_birth_month = String.valueOf(random.nextInt(months - 1) + 1);
        } while (updated_birth_month.equals(CreateAccount.birth_month));
        updated_birth_year = "";
        do {
            updated_birth_year = String.valueOf(
                    ThreadLocalRandom.current().nextInt(1990, 2000 + 1)
            );
        } while (updated_birth_year.equals(CreateAccount.birth_year));

        Response updateAccount  = automationExerciseWebService.putUpdateAccount(
                updated_name,
                CreateAccount.email,
                CreateAccount.password,
                updated_tile,
                updated_birth_day,
                updated_birth_month,
                updated_birth_year,
                updated_firstname,
                updated_lastname,
                updated_company,
                updated_address1,
                updated_address2,
                updated_country,
                updated_zipcode,
                updated_state,
                updated_city,
                updated_mobile_number);
        assertThat(updateAccount .getStatusCode(), equalTo(200));
        assertThat(updateAccount .jsonPath().getInt("responseCode"), equalTo(200));
        assertThat(updateAccount .jsonPath().getString("message"), equalTo("User updated!"));
    }
}