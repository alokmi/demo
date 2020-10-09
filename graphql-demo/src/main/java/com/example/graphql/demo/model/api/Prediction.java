package com.example.graphql.demo.model.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Prediction {
	private String predictionValType;
	private String predAlgorithmNameType;
	private double score;
}
