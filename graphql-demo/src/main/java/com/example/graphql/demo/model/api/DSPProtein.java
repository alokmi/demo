package com.example.graphql.demo.model.api;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DSPProtein {
	private DSPRecommendedName recommendedName;
	private List<DSPRecommendedName> submittedName;
}
