package com.example.graphql.demo.model.api;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataServiceProtein {
	private String accession;
	private DSPInfo info;
	private DSPProtein protein;
	private List<DSPComment> comments;
	private List<DBReference> dbReferences;
	private List<Feature> features;
	private DSPSequence sequence;
	private List<Reference> references;
}
