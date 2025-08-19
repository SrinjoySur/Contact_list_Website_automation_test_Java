package com.contact_list.api.manager;

import com.contact_list.utils.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationManager {
    private static RequestSpecification requestSpec;

    public static RequestSpecification getRequestSpecification() {
        if (requestSpec == null) {
            requestSpec = new RequestSpecBuilder()
                    .setBaseUri(ConfigReader.getInstance().getProperty("api.base.uri"))
                    .setContentType(ContentType.JSON)
                    .build();
        }
        return requestSpec;
    }
    public static RequestSpecification getAuthenticatedRequestSpecification(String token) {
        if (requestSpec == null) {
            requestSpec = new RequestSpecBuilder()
                    .addHeader("Authorization", "Bearer " + token)
                    .setBaseUri(ConfigReader.getInstance().getProperty("api.base.uri"))
                    .setContentType(ContentType.JSON)
                    .build();
        }
        return requestSpec;
    }

    public static void resetRequestSpec() {
        requestSpec = null;
    }
}
