package com.example.graphql.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gene {
	private String accession;
	private String chromosome;
	private String ensgId;
	private String enstId;
	private String enspId;
	private Protein protein;
}
