package com.example.graphql.demo.model.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Feature {
	private long begin;
	private long end;
	private String description;
	private String type;
	private String category;
	private String typeDescription;
	private String ftId;
	private String molecule;
	private String codon;
	private List<Prediction> predictions;
	private String wildType;
	private String mutatedType;
	private List<DSVDbReferenceObject> xrefs;
	private List<Evidence> evidences;
	private DSVSourceTypeEnum sourceType;
	private String consequenceType;
	private List<DSVAssociation> association = new ArrayList<DSVAssociation>();
	private List<DSVClinicalSignificance> clinicalSignificances;
	private List<DSVPopulationFrequency> populationFrequencies;
	
	public String getSignificances() {
		String clincalSignificances = "";
		if(this.clinicalSignificances!=null) {
			clincalSignificances = this.clinicalSignificances.stream().map(DSVClinicalSignificance::getType).collect(Collectors.joining(","));
		}
		return clincalSignificances;
	}
}
