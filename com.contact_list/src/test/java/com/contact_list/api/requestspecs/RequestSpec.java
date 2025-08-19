package com.contact_list.api.requestspecs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class RequestSpec {
    RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

    protected RequestSpecification get(String BaseUri) {
        return requestSpecBuilder.setBaseUri(BaseUri).build();
    }
    protected RequestSpecification get(String BaseUri, String token) {
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("Authorization","Bearer "+token).build();
    }
    protected RequestSpecification post(String BaseUri){
        return requestSpecBuilder.setBaseUri(BaseUri).setContentType(ContentType.JSON).build();
    }
    protected RequestSpecification post(String BaseUri, String token) {
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("accept", "*/*").addHeader("Authorization", "Bearer " + token).build();
    }
    protected RequestSpecification put(String BaseUri) {
        return requestSpecBuilder.setBaseUri(BaseUri).build();
    }
    protected RequestSpecification put(String BaseUri, String token) {
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("accept", "*/*").addHeader("Authorization", "Bearer " + token).build();
    }
    protected RequestSpecification patch(String BaseUri) {
        return requestSpecBuilder.setBaseUri(BaseUri).build();
    }
    protected RequestSpecification patch(String BaseUri, String token) {
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("accept", "*/*").addHeader("Authorization", "Bearer " + token).build();
    }
    protected RequestSpecification delete(String BaseUri) {
        return requestSpecBuilder.setBaseUri(BaseUri).build();
    }
    protected RequestSpecification delete(String BaseUri, String token) {
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("accept", "*/*").addHeader("Authorization", "Bearer " + token).build();
    }
}
