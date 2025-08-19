package com.contact_list.constants;

import com.contact_list.utils.ConfigReader;

public class ConstantsProvider {
    public static final String configPath = "src/main/resources/config/config.properties";
    public static final String screenshotsDirPath = System.getProperty("user.dir") + "\\screenshots";
    public static final String jsonSchemasDir = "src/test/resources/jsonschemas";
    /**
     * The below constants are defined for backend APIs. These include
     * various endpoints
     */
    public static final String API_BASE_URI = ConfigReader.getInstance().getProperty("api.base.uri");
    public static final String SIGN_IN_ENDPOINT = API_BASE_URI + "/api/v1/auth/sign-in";
    public static final String SIGN_UP_ENDPOINT = API_BASE_URI + "/api/v1/auth/sign-up";
    public static final String AVAILABLE_WORKOUTS_ENDPOINT = "/api/v1/workouts/available";
    public static final String CREATE_WORKOUTS_ENDPOINT = API_BASE_URI + "/api/v1/workouts";
    public static final String BOOKED_WORKOUTS_ENDPOINT = API_BASE_URI + "/api/v1/workouts/booked";
    public static final String QA_DELETE_WORKOUTS_ENDPOINT = API_BASE_URI + "/api/v1/workouts/delete";
    public static final String GET_ALL_COACHES_ENDPOINT = API_BASE_URI + "/api/v1/coaches";
    public static final String GET_COACH_AVAILABILITY_ENDPOINT = API_BASE_URI + "/api/v1/coaches";
}
