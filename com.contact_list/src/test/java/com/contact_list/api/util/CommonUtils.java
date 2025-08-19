package com.contact_list.api.util;

import com.epam.gym_app.api.model.Authenticate;
import com.epam.gym_app.api.model.Coach;
import com.epam.gym_app.constants.ConstantsProvider;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CommonUtils {

    public static String sessionClientId;

    public static String generateAuthToken(String email, String password) {
        Authenticate auth = new Authenticate.AuthBuilder().withEmail(email).withPassword(password).build();

        Response response = given()
                .contentType("application/json")
                .body(auth)
                .when()
                .post(ConstantsProvider.SIGN_IN_ENDPOINT)
                .then()
                .extract().response();

        if (response.statusCode() == 200) {
            sessionClientId = response.jsonPath().getString("user.id");
            return response.jsonPath().getString("tokens.accessToken");
        } else {
            throw new RuntimeException("Failed to generate token for user: " + email);
        }
    }

    public static String getCoachIdByEmail(String email) {
        List<Coach> coaches = given()
            .contentType("application/json")
            .when()
            .get(ConstantsProvider.GET_ALL_COACHES_ENDPOINT)
            .then()
            .extract().response().jsonPath().getList("", Coach.class);

        return coaches.stream().filter(coach -> coach.getEmail().equalsIgnoreCase(email)).findFirst().get().getId();
    }

    public static String getAvailableCoachAtTime(String time) {
        List<Coach> coaches = given()
                .contentType("application/json")
                .when()
                .get(ConstantsProvider.GET_ALL_COACHES_ENDPOINT)
                .then()
                .extract().response().jsonPath().getList("", Coach.class);

        return coaches.stream().map(Coach::getId).filter(id -> isCoachAvailableAtTimeAndDate(time, id)).findFirst().orElse(null);

    }

    private static boolean isCoachAvailableAtTimeAndDate(String time, String id) {
        String date = LocalDate.now().plusDays(1).toString();
        System.out.println("Searching availability of " + id + " at time " + time + " on date " + date);

        List<String> availableTimePeriod = given()
                .contentType("application/json")
                .when()
                .get(ConstantsProvider.GET_COACH_AVAILABILITY_ENDPOINT + "/" + id + "/available-slots/" + date)
                .then()
                .extract().response()
                .jsonPath().getList("availableSlots", String.class);

        return availableTimePeriod.stream().anyMatch(timePeriod -> timePeriod.equals(time));

    }

}
