package com.contact_list.api.requestspecs;

import io.restassured.specification.RequestSpecification;

public class UserSpec extends RequestSpec{
    @Override
    public RequestSpecification get(String BaseUri, String token) {
        return super.get(BaseUri, token);
    }
}
