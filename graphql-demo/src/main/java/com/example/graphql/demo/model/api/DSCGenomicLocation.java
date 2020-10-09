package com.example.graphql.demo.model.api;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DSCGenomicLocation {
	private String chromosome;
	private long start;
	private long end;
	private boolean reverseStrand;
	private List<Exon> exon;
	
}

