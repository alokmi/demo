package com.example.graphql.demo.model.api;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DSCGnCoordinate {
	private DSCGenomicLocation genomicLocation;
	private String ensemblGeneId;
	private String ensemblTranscriptId;
	private String ensemblTranslationId;
	private List<DSCFeature> feature;
}
