package com.example.graphql.demo.model.api;

import lombok.Data;

@Data
public class DSVDbReferenceObject {
    private String name;
    private String id;
    private String url;
    private String alternativeUrl;
    private Boolean reviewed;
}

