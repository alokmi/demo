package com.example.graphql.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Protein {
	private String accession;
	private String name;
	private String type;
    private Variation variation;
    private Object comments;
}
