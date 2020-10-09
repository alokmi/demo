package com.example.graphql.demo.model.api;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DataServiceCoordiante {
	private String accession;
	private List<DSCGene> gene;
	private List<DSCGnCoordinate> gnCoordinate;
}
