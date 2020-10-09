package com.example.graphql.demo.model.api;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataServiceVariation {
    private String accession;
    private String geneName;
    private List<Feature> features;
    
}
