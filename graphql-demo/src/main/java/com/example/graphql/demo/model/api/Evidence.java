package com.example.graphql.demo.model.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Evidence {

	private String code;
	private DSPSource source;
	private String sourceName;
	private String sourceId;
	private String sourceUrl;
	private String sourceAlternativeUrl;
	private String label;
}
