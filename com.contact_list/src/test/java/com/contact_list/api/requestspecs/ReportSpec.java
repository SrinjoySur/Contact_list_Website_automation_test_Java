package com.contact_list.api.requestspecs;

import io.restassured.specification.RequestSpecification;
public class ReportSpec extends RequestSpec{
    @Override
    public RequestSpecification get(String BaseUri, String token) {
        return super.get(BaseUri, token);
    }
}

