package com.example.graphql.demo.model.api;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DSPRecommendedName {
	private DSPName fullName;
	private List<DSPName> shortName;
}
