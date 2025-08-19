package com.contact_list.api.requestspecs;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class AuthenticateSpec extends RequestSpec{
    @Override
    public RequestSpecification post(String BaseUri){
        return requestSpecBuilder.setBaseUri(BaseUri).setContentType(ContentType.JSON).build();
    }
}
