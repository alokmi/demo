package com.example.graphql.demo.model.api;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DSPFeature {

	private String type;
	private String category;
	private String typeDescription;
	private String ftId;
	private String description;
	private long begin;
	private long end;
	private String molecule;
	private List<Evidence> evidences;

}
