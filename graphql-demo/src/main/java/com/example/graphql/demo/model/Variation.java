package com.example.graphql.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Variation {
	private long begin;
    private long end;
    private String wildType;
    private String alternativeSequence;
    private String consequence;

}
