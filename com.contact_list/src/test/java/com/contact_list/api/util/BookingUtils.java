package com.contact_list.api.util;

import com.epam.gym_app.api.model.Workout;
import com.epam.gym_app.api.model.WorkoutRequest;
import com.epam.gym_app.constants.ConstantsProvider;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BookingUtils extends CommonUtils {

    public static void createMockBookings(String clientId, String coachId) {

        for(int i = 0; i < 4; i++ ) {
            System.out.println("Creating booking " + i);
            String date = java.time.LocalDate.now().plusDays((long) (Math.random() * 365)).toString();
            String time = "02:00";

            WorkoutRequest workoutBuilder = new WorkoutRequest.Builder()
                    .withClientId(clientId)
                    .withCoachId(coachId)
                    .withDate(date)
                    .withTime(time)
                    .withActivity("YOGA")
                    .build();

            Response response = given()
                    .contentType("application/json")
                    .header("Authorization", "Bearer " + TokenManager.getToken("client"))
                    .when()
                    .body(workoutBuilder)
                    .post(ConstantsProvider.CREATE_WORKOUTS_ENDPOINT)
                    .then()
                    .extract().response();

        }
    }

    public static void deleteAllBookings(String clientId) {
        Response response = given()
                .header("Authorization", "Bearer " + TokenManager.getToken("client"))
                .queryParam("clientId", clientId)
                .when()
                .get(ConstantsProvider.BOOKED_WORKOUTS_ENDPOINT)
                .then().extract().response();
        try {
            String res = response.jsonPath().getString("message");
            if(res == null) throw new Exception();
        } catch (Exception e) {
            List<String> bookingIds = response.jsonPath().getList("data._id", String.class);
            for (String bookingId : bookingIds) {
                given()
                        .header("Authorization", "Bearer " + TokenManager.getToken("client"))
                        .when()
                        .delete(ConstantsProvider.QA_DELETE_WORKOUTS_ENDPOINT + "/" + bookingId);

                System.out.println("DELETED: " + bookingId);
            }
        }
    }

    public static String createMockBooking(String clientId, String coachId) {
        String date = java.time.LocalDate.now().plusDays((long) (Math.random() * 365)).toString();
        String time = "02:00";

        WorkoutRequest workoutBuilder = new WorkoutRequest.Builder()
                .withClientId(clientId)
                .withCoachId(coachId)
                .withDate(date)
                .withTime(time)
                .withActivity("YOGA")
                .build();

        Response response = given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + TokenManager.getToken("client"))
                .when()
                .body(workoutBuilder)
                .post(ConstantsProvider.CREATE_WORKOUTS_ENDPOINT)
                .then()
                .extract().response();

        return response.jsonPath().getString("workout._id");

    }

    public static String getWorkoutId(int i) {
        Response response = given()
                .header("Authorization", "Bearer " + TokenManager.getToken("client"))
                .queryParam("clientId", sessionClientId)
                .when()
                .get(ConstantsProvider.BOOKED_WORKOUTS_ENDPOINT);

        List<String> ids = response.jsonPath().getList("data._id", String.class);
        return ids != null && !ids.isEmpty() ? ids.get(0) : null;
    }

    public static Response cancelWorkout(String workoutId) {
         return given()
                .header("Authorization", "Bearer " + TokenManager.getToken("client"))
                .when()
                .delete(ConstantsProvider.CREATE_WORKOUTS_ENDPOINT + "/" + workoutId);
    }

    public static String createMockBookingWithDate(String clientId, String coachId, String date) {
        String time = "02:00";


        WorkoutRequest workoutBuilder = new WorkoutRequest.Builder()
                .withClientId(clientId)
                .withCoachId(coachId)
                .withDate(date)
                .withTime(time)
                .withActivity("YOGA")
                .build();

        Response response = given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + TokenManager.getToken("client"))
                .when()
                .body(workoutBuilder)
                .post(ConstantsProvider.CREATE_WORKOUTS_ENDPOINT)
                .then()
                .extract().response();

        return response.jsonPath().getString("workout._id");
    }

    public static Workout getWorkoutById(String lastCancelledWorkoutId) {
        Response response = given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + TokenManager.getToken("client"))
                .when()
                .queryParam("clientId", sessionClientId)
                .get(ConstantsProvider.BOOKED_WORKOUTS_ENDPOINT)
                .then()
                .extract().response();

        return response.jsonPath().getList("data", Workout.class).stream().filter(workout -> workout.getId().equalsIgnoreCase(lastCancelledWorkoutId)).findFirst().orElse(null);
    }

    public static Response createBookingWithPayload(String payload) {
        return given()
                .contentType("application/json")
                .headers("Authorization", "Bearer " + TokenManager.getToken("client"))
                .when()
                .body(payload)
                .post(ConstantsProvider.CREATE_WORKOUTS_ENDPOINT)
                .then().extract().response();
    }
}
