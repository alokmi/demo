package com.example.graphql.demo.model.api;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DSCProtein {
	private List<DSCProteinName> submittedName;
	private DSCProteinName recommendedName;
}
